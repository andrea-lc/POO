package com.mycompany.poosemana7;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
public abstract class Gestor {
    private static final String Ruta_personas = "personas.txt"; // Nuevo archivo
    private static Map<Integer, Persona> personas = new HashMap<>(); // Nuevo mapa para Personas

    public Gestor() {
        cargarUsuarios();
    }
    
    
    
    private void cargarUsuarios() {
        try (BufferedReader br = new BufferedReader(new FileReader(Ruta_personas))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 5) {
                    int dni = Integer.parseInt(datos[0].trim());
                    String nombre = datos[1].trim();
                    int telefono = Integer.parseInt(datos[2].trim());
                    String direccion = datos[3].trim();
                    String correo = datos[4].trim();
                    Persona persona = new Persona(dni, nombre, telefono, direccion, correo) {
                        @Override
                        public String getTipoPersona() {
                            return "Persona";
                        }
                    };
                    
                    personas.put(dni, persona); // [correo, usuario, contraseña]
                }
            }
        } catch (IOException e) {
            System.out.println("No se pudo cargar usuarios (puede que el archivo esté vacío).");
        }
    }
    public static Persona buscarPersona(int dni) {
        return personas.get(dni);
    }
    public static void agregarPersona(Persona persona) {
        personas.put(persona.getId_persona(), persona);
    }
}
