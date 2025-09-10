/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prueba_herencia;


/**
 *
 * @author admin
 */
public class Adoptante extends Persona {
    String fecha;
    String observaciones;

    public Adoptante(String fecha, String observaciones) {
        super(persona.getId_persona(), persona.getNombre(), persona.getTelefono(), persona.getDireccion(), persona.getCorreo()); 
        this.fecha = fecha;
        this.observaciones = observaciones;
    }  

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    @Override
    public String toString() {
        return "Id:"+ id_persona+ "Nombre: "+ nombre + "telefono: "+ telefono+ "Direccion: "+ direccion + "fecha"
                + fecha+"Observaciones"+observaciones;
    }
}


