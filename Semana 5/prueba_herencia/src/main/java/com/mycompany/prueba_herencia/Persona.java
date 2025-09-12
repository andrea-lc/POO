/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prueba_herencia;

/**
 *
 * @author admin
 */
public class Persona {
    protected int id_persona;
    protected String nombre; 
    protected int telefono;
    protected String direccion;
    protected String correo;

    public Persona(int id_persona, String nombre, int telefono, String direccion, String correo) {
        this.id_persona = id_persona;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
    }
    // Constructor de copia
    // constructor especial de una clase que recibe un objeto de 
    // la misma clase como parametro y copia sus atributos
    public Persona(Persona otra) {
        this.id_persona = otra.id_persona;
        this.nombre = otra.nombre;
        this.telefono = otra.telefono;
        this.direccion = otra.direccion;
        this.correo = otra.correo;
    }
    
    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}

