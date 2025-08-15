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
class Gestor_usuarios {
    //ATRIBUTOS
    private static final String Ruta_archivo = "usuarios.txt";
    
    //METODOS
    public void registrar_usuario (String usuario,String contraseña){
        try(BufferedWriter bw= new BufferedWriter (new FileWriter(Ruta_archivo,true)) ){
            bw.write(usuario + "," + contraseña);
            bw.newLine();
            System.out.println("Usuario agregado correctamente.");
        } catch (IOException ex) {
            System.out.println("Error al leer usuarios.txt"+ex);
        }      
    }
    
       public boolean login(String usuario, String contraseña) {
        try (BufferedReader br = new BufferedReader(new FileReader(Ruta_archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 2) {
                    String validarUsuario = datos[0];
                    String validarUser = datos[1];
                    if (validarUsuario.equals(usuario) && validarUser.equals(contraseña)) {
                        return true;
                    }
                    System.out.println("Ingresando...");
                }
            }
        } catch (IOException ex) {
            System.out.println("Error leyendo archivo: " + ex);
        }
        return false;
    }
       
     public List<String[]> leer_usuario() {
        List<String[]> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(Ruta_archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split("\\,");
                lista.add(datos);
            }
        } catch (IOException ex) {
            System.out.println("Error al leer usuarios.txt"+ex);
        }
        return lista;
    }
}

