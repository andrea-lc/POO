/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestores;

import Entidades.Persona;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author admin
 */
// Clase Gestor_usuarios
public class Gestor_usuarios {
    private static final String Ruta_archivo = "usuarios.txt";
    private static Map<String, Persona> usuarios = new HashMap<>();
    
    
    //problema: no leia el txt ya que el hashmap estaba vacio 
    // solucion: crear constructor para llamar al metodo y cada 
    // vez que se instancie, el map se inicializara  con los datos llenos
    public Gestor_usuarios() {
        cargarUsuarios(); // <---(ejecuta el metodo cargarUsuarios para que los datos de txt llenen el map
    }
    
    
    private void cargarUsuarios() {
        try (BufferedReader br = new BufferedReader(new FileReader(Ruta_archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 6) { 
                    String contraseña = datos[0].trim();
                    int dni = Integer.parseInt(datos[1]);
                    String nombre = datos[2];
                    int telefono = Integer.parseInt(datos[3]);
                    String direccion = datos[4];
                    String correo = datos[5];
                    Persona persona=new Persona (contraseña,dni,nombre,telefono,direccion,correo);
                    
                    usuarios.put(persona.getCorreo(), persona);
                }
            }
        } catch (IOException e) {
            System.out.println("No se pudo cargar usuarios (puede que el archivo esté vacio).");
        }
    }


    public void registrar_usuario(Persona persona) {
        if (usuarios.containsKey(persona.getCorreo())) {   //verifica si el map contiene la clave
            System.out.println("Ese correo ya está registrado.");
            return;
        }
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(Ruta_archivo, true))) {
        // Escribir los datos de la persona en el formato correcto
        String linea = String.format("%s,%d,%s,%d,%s,%s",
            persona.getContraseña(),
            persona.getId_persona(),
            persona.getNombre(),
            persona.getTelefono(),
            persona.getDireccion(),
            persona.getCorreo());
        
        bw.write(linea);
        bw.newLine();
        System.out.println("Usuario agregado correctamente.");

        // Guardar en el HashMap (usando el correo como clave y la Persona como valor)
        usuarios.put(persona.getCorreo(), persona);

        } catch (IOException ex) {
            System.out.println("Error al guardar en usuarios.txt");
        }
    }
    
    // Recibe usuario y contraseña como parámetros.
    public boolean login(String correo, String contraseña) {
        if (!usuarios.containsKey(correo)) {   
            return false; // correo (usuario) no encontrado
            
        }
        Persona valor = usuarios.get(correo); // devolvera el valor asociado a la clave "correo"
        
        if (valor != null && valor.getContraseña().equals(contraseña)) {
            System.out.println("Bienvenido "+ valor.getNombre());
            return true;  // login correcto
        } else {
            return false; // contraseña incorrecta
        }
    }     
}