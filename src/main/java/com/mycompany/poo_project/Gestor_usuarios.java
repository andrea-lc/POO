/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo_project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;                                          


/**
 *
 * @author admin
 */
// Clase Gestor_usuarios
// Se encarga de manejar la persistencia de usuarios y gatos en archivos de texto
class Gestor_usuarios {
    
    // ========================
    // ATRIBUTOS
    // ========================
    // Atributo estático y constante (final): su valor no cambia durante la ejecución
    // Representa la ruta del archivo donde se guardan los usuarios
    private static final String Ruta_archivo = "usuarios.txt";
    
    // Lo mismo pero aca se guardaran los gatos
    private static final String Ruta_gatos = "gatos.txt";

    // ========================
    // MÉTODOS
    // ========================

    // Método público, paramétrico, sin retorno (void).
    // Recibe usuario y contraseña como parámetros y los guarda en el archivo usuarios.txt
    public void registrar_usuario(String usuario, String contraseña) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(Ruta_archivo, true))) {
            bw.write(usuario + "," + contraseña); // Guardar en formato CSV
            bw.newLine();
            System.out.println("Usuario agregado correctamente.");
        } catch (IOException ex) {
            System.out.println("Error al leer usuarios.txt");
        }      
    }
    
    // Método público, paramétrico, con retorno (boolean).
    // Recibe usuario y contraseña como parámetros.
    // Retorna true si las credenciales existen en el archivo usuarios.txt, de lo contrario false.
    public boolean login(String usuario, String contraseña) {
        try (BufferedReader br = new BufferedReader(new FileReader(Ruta_archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 2) {
                    String validarUsuario = datos[0];
                    String validarContra = datos[1];
                    if (validarUsuario.equals(usuario) && validarContra.equals(contraseña)) {
                        return true; // Credenciales correctas
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println("Error leyendo archivo de usuarios.");
        }
        return false; // Si no encuentra coincidencia
    }
       
    // Método público, paramétrico, sin retorno (void).
    // Recibe datos de un gato (id, nombre, edad y raza) y los guarda en el archivo gatos.txt
    public void guardarGato(int iD, String nombre, int edad, String raza) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(Ruta_gatos, true))) {
            bw.write(iD + "," + nombre + ","+ edad + ","+ raza);
            bw.newLine();
            System.out.println("Gato agregado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar gato en el archivo.");
        }
    }

    // Método público, no paramétrico, con retorno (List<Gatos>).
    // No recibe parámetros. 
    // Retorna una lista con todos los gatos que están almacenados en el archivo gatos.txt
    public List<Gatos> leerGatos() {
        List<Gatos> listaGatos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(Ruta_gatos))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 4) {
                    int id = Integer.parseInt(datos[0]);
                    String nombre = datos[1];
                    int edad = Integer.parseInt(datos[2]);
                    String raza = datos[3];
                    listaGatos.add(new Gatos(id, nombre, edad, raza)); // Crear objeto y añadir a la lista
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer gatos desde el archivo.");
        }
        return listaGatos;
    }
}

