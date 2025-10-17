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

/**
 *
 * @author admin
 */
public class Gestor_usuarios2 extends GestorBase<Persona> implements UsuarioGestorInterface {
    
    public Gestor_usuarios2(String rutaArchivo) {
        super("usuarios.txt");
    }
    
    @Override
    public void cargarDatos() {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 6) { 
                    Persona persona = new Persona(
                        datos[0].trim(),
                        Integer.parseInt(datos[1]),
                        datos[2],
                        Integer.parseInt(datos[3]),
                        datos[4],
                        datos[5]
                    );
                    elementos.put(persona.getCorreo(), persona);
                }
            }
        } catch (IOException e) {
            System.out.println("No se pudo cargar usuarios (puede que el archivo esté vacio).");
        }
    }
    
    @Override
    public void guardarDatos() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (Persona persona : elementos.values()) {
                String linea = String.format("%s,%d,%s,%d,%s,%s",
                    persona.getContraseña(),
                    persona.getId_persona(),
                    persona.getNombre(),
                    persona.getTelefono(),
                    persona.getDireccion(),
                    persona.getCorreo());
                bw.write(linea);
                bw.newLine();
            }
        } catch (IOException ex) {
            System.out.println("Error al guardar en usuarios.txt");
        }
    }
    
    @Override
    public boolean registrar(Persona persona) {
        if (existe(persona.getCorreo())) {
            System.out.println("Ese correo ya está registrado.");
            return false;
        }
        
        elementos.put(persona.getCorreo(), persona);
        guardarDatos();
        System.out.println("Usuario agregado correctamente.");
        return true;
    }
    
    @Override
    public boolean login(String correo, String contraseña) {
        Persona persona = buscarPorCorreo(correo);
        if (persona != null && persona.getContraseña().equals(contraseña)) {
            System.out.println("Bienvenido " + persona.getNombre());
            return true;
        }
        return false;
    }
    
    @Override
    public Persona buscarPorCorreo(String correo) {
        return elementos.get(correo);
    }
}

