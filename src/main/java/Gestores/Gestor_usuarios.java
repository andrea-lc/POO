/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestores;

import Entidades.Gatos;
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
public class Gestor_usuarios {

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
    public void registrar_usuario(String correo, String usuario, String contraseña) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(Ruta_archivo, true))) {
            bw.write(correo+ ","+ usuario + "," + contraseña); // Guardar en formato CSV
            bw.newLine();
            System.out.println("Usuario agregado correctamente.");
        } catch (IOException ex) {
            System.out.println("Error al leer usuarios.txt");
        }      
    }
    
    // Método público, paramétrico, con retorno (boolean).
    // Recibe usuario y contraseña como parámetros.
    // Retorna true si las credenciales existen en el archivo usuarios.txt, de lo contrario false.
    public boolean login(String correo, String contraseña) {
        try (BufferedReader br = new BufferedReader(new FileReader(Ruta_archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 3) {
                    String validarCorreo = datos[0];
                    String validarContra = datos[2];
                    if (validarCorreo.equals(correo) && validarContra.equals(contraseña)) {
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
    public void guardarGato(int iD, String nombre, int edad, String raza, String estado_gato, String cuidado_requerido) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(Ruta_gatos, true))) {
            bw.write(iD + "," + nombre + ","+ edad + ","+ raza + "," + estado_gato + "," + cuidado_requerido);
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
                if (datos.length == 6) {
                    int id = Integer.parseInt(datos[0]);
                    String nombre = datos[1];
                    int edad = Integer.parseInt(datos[2]);
                    String raza = datos[3];
                    String estado_gato = datos [4];
                    String cuidado_requerido = datos[5];
                    listaGatos.add(new Gatos(id, nombre, edad, raza,estado_gato, cuidado_requerido)); // Crear objeto y añadir a la lista
                }
            }
        } catch (IOException gestor_usuarie) {
            System.out.println("Error al leer gatos desde el archivo.");
        }
        return listaGatos;
    }
    
        private void guardarGatos(List<Gatos> listaGatos) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(Ruta_gatos))) {
            for (Gatos g : listaGatos) {
                bw.write(g.getId() + "," + g.getNombre() + "," + g.getEdad() + "," +
                         g.getRaza() + "," + g.getEstado_gato() + "," + g.getCuidado_requerido());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar los gatos: " + e.getMessage());
        }
    }
    
    public void modificador (String nuevo, int Id_gato, int modificador){       
        List<Gatos> listaGatos = leerGatos(); // Lee la lista
       
        boolean encontrado = false;
        for (Gatos g : listaGatos) {
            if (g.getId() == Id_gato) {
                encontrado = true;             
                    switch (modificador){
                        case 1: { 
                            System.out.println("Nuevo nombre: ");
                            g.setNombre(nuevo);
                            break;
                        }
                        case 2: {
                            System.out.println("Nueva edad: ");
                            int nuevo_entero=Integer.parseInt(nuevo);
                            g.setEdad(nuevo_entero);
                            break;
                        }
                        case 3: {
                            System.out.println("Nuevo estado del gato: ");
                            g.setEstado_gato(nuevo);
                            break;
                        }
                        case 4: { 
                            System.out.println("Nuevo cuidado requerido: ");
                            g.setCuidado_requerido(nuevo);
                            
                    }                       
                }
            }
        }
        if (encontrado){
            guardarGatos(listaGatos);
            System.out.println("Gato modificado y guardado en el archivo.");
        } else {
            System.out.println("No se encontró el gato con ID " + Id_gato);
        }
    }
}

