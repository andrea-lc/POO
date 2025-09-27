/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestor;

import com.mycompany.poosemana7.Persona;
import com.mycompany.poosemana7.Voluntario;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author admin
 */
public class GestorVoluntarios {
        private static final String Ruta_voluntarios = "voluntarios.txt";
    private static Map<Integer, Voluntario> voluntarios = new HashMap<>();
    
    static {
        cargarVoluntarios();
    }
    
    public static void agregarVoluntario(int dniPersona, String fechaIngreso, String areaTrabajo, int horasSemanales) {
        Persona persona = Gestor.buscarPersona(dniPersona);
        if (persona != null) {
            Voluntario voluntario = new Voluntario(persona, fechaIngreso, areaTrabajo, horasSemanales);
            voluntarios.put(dniPersona, voluntario);
            guardarVoluntario(voluntario);
        } else {
            System.out.println("No se encontro una persona con DNI: " + dniPersona);
        }
    }
    
    private static void cargarVoluntarios() {
        try (BufferedReader br = new BufferedReader(new FileReader(Ruta_voluntarios))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 8) {
                    int dni = Integer.parseInt(datos[0].trim());
                    Persona persona = Gestor.buscarPersona(dni);
                    if (persona != null) {
                        Voluntario voluntario = new Voluntario(persona, datos[5].trim(), datos[6].trim(), 
                                Integer.parseInt(datos[7].trim()));
                        voluntarios.put(dni, voluntario);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("No se pudo cargar voluntarios.");
        }
    }
    
    private static void guardarVoluntario(Voluntario voluntario) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(Ruta_voluntarios, true))) {
            pw.println(voluntario.getId_persona() + "," +
                      voluntario.getNombre() + "," +
                      voluntario.getTelefono() + "," +
                      voluntario.getDireccion() + "," +
                      voluntario.getCorreo() + "," +
                      voluntario.getFechaIngreso() + "," +
                      voluntario.getAreaTrabajo() + "," +
                      voluntario.getHorasSemanales());
        } catch (IOException e) {
            System.out.println("Error al guardar voluntario.");
        }
    }
   
    public static Voluntario buscarVoluntario(int dni) {
        return voluntarios.get(dni);
    }
}

