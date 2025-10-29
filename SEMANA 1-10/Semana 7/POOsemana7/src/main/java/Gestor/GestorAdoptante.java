/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestor;

import com.mycompany.poosemana7.Adoptantes;
import com.mycompany.poosemana7.Persona;
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
public class GestorAdoptante {
    private static final String Ruta_adoptantes = "adoptantes.txt";
    private static final Map<Integer, Adoptantes> adoptantes = new HashMap<>();
    
    static {
        cargarAdoptantes();
    }
    
    public static void agregarAdoptante(int dniPersona, String fecha, String observaciones) {
        Persona persona = Gestor.buscarPersona(dniPersona);
        // Si la persona existe continua ya que solo se podra agregar la 
        // fecha de adopcion y observaciones si la persona esta registrada
        if (persona != null) {
            // Crea un nuevo objeto Adoptantes usando los datos de la persona encontrada (nombre, teléfono, etc.)
            Adoptantes adoptante = new Adoptantes(persona, fecha, observaciones);
            adoptantes.put(dniPersona, adoptante);
            guardarAdoptante(adoptante);
        } else {
            System.out.println("No se encontró una persona con DNI: " + dniPersona);
        }
    }
    
    private static void cargarAdoptantes() {
        try (BufferedReader br = new BufferedReader(new FileReader(Ruta_adoptantes))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 7) {
                    int dni = Integer.parseInt(datos[0].trim());
                    // Buscar si la persona ya existe en el gestor principal
                    Persona persona = Gestor.buscarPersona(dni);
                    if (persona != null) {
                        Adoptantes adoptante = new Adoptantes(persona, datos[5].trim(), datos[6].trim());
                        adoptantes.put(dni, adoptante);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("No se pudo cargar adoptantes.");
        }
    }
    
    private static void guardarAdoptante(Adoptantes adoptante) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(Ruta_adoptantes, true))) {
            bw.write(adoptante.getId_persona() + "," +
                      adoptante.getNombre() + "," +
                      adoptante.getTelefono() + "," +
                      adoptante.getDireccion() + "," +
                      adoptante.getCorreo() + "," +
                      adoptante.getFecha() + "," +
                      adoptante.getObservaciones());
        } catch (IOException e) {
            System.out.println("Error al guardar adoptante.");
        }
    }
    
    public static Adoptantes buscarAdoptante(int dni) {
        return adoptantes.get(dni);
    
    }

    
}

