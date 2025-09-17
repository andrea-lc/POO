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

    
    // Parametro "persona" de tipo Persona y con super llama al constructor de copia de la clase Persona
    public Adoptante(Persona persona, String fecha, String observaciones) {
        super (persona);
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
        String texto = String.format(
            "%-20s %-20s%n" +   
            "%-20s %-20s%n" +  
            "%-30s%n" +         
            "%-30s",            
            "Id: " + id_persona,
            "Nombre: " + nombre,
            "Telefono: " + telefono,
            "Fecha: " + fecha,
            "Direccion: " + direccion,
            "Observaciones: " + observaciones
        );
        return texto;
    }
}



