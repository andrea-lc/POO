/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestores;

import Entidades.Administradores;
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
// Clase Gestor_usuarios
public class Gestor_usuarios extends GestorBase <Administradores>{

    private static Gestor_usuarios instancia;
    
    public Gestor_usuarios() {
        super("Administradores.txt");
    }
    
    public static Gestor_usuarios getInstanciaUsuario() {
        if (instancia==null){
            instancia= new Gestor_usuarios();
        }  
        return instancia; 
    }         
     
    @Override
    public void cargarDatos() {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 6) { 
                    int dni = Integer.parseInt(datos[0]);
                    String nombre = datos[1];
                    String apellido= datos[2];
                    int telefono = Integer.parseInt(datos[3]);
                    String correo = datos[4];
                    String contraseña = datos[5];
                    Administradores administrador =new Administradores(new Persona(dni,nombre,apellido,telefono,correo), 
                            contraseña);
                    
                    getElementos().put(administrador.getCorreo(), administrador);
                }
            }
        } catch (IOException e) {
            System.out.println("No se pudo cargar usuarios (puede que el archivo este vacio).");
        }
    }

    @Override
    public boolean registrar(Administradores administrador) {
        if (getElementos().containsKey(administrador.getCorreo())) {   //verifica si el map contiene la clave
            System.out.println("Ese correo ya esta registrado.");
            return true;
        }
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
        // Escribir los datos de la persona en el formato correcto
        String linea = String.format("%d,%s,%s,%d,%s,%s",          
            administrador.getDni_persona(),           
            administrador.getNombre(),
            administrador.getApellido(),
            administrador.getTelefono(),
            administrador.getCorreo(),  
            administrador.getContraseña());
        bw.write(linea);
        bw.newLine();
        System.out.println("Usuario agregado correctamente.");

        // Guardar en el HashMap (usando el correo como clave y la Persona como valor)
        getElementos().put(administrador.getCorreo(), administrador);
        } catch (IOException ex) {
            System.out.println("Error al guardar en usuarios.txt");
        }
    return true;
    }
        @Override
    public void guardarCambios() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    public boolean login(String correo, String contraseña) {
        if (!getElementos().containsKey(correo)) {   
            return false; // correo (usuario) no encontrado
            
        }
        Administradores valor = getElementos().get(correo); // devolvera el valor asociado a la clave "correo"
        
        if (valor != null && valor.getContraseña().equals(contraseña)) {
            System.out.println("Bienvenid@ "+ valor.getNombre());
            return true;  // login correcto
        } else {
            return false; // contraseña incorrecta
        }
    }

    @Override
    public boolean existe(String identificador) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mostrar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void modificar(String datoModificar, int opcion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void buscar(String identificador) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(String identificador) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}