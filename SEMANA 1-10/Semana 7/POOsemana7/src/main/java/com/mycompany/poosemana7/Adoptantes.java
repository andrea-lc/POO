/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poosemana7;



/**
 *
 * @author admin
 */
public class Adoptantes extends Persona {
    private String fecha;
    private String observaciones;

    public Adoptantes(int dni_persona, String nombre, int telefono, String direccion, 
                     String correo, String fecha, String observaciones) {
        super(dni_persona, nombre, telefono, direccion, correo);
        this.fecha = fecha;
        this.observaciones = observaciones;
    }

    // Constructor de copia
    public Adoptantes(Persona persona, String fecha, String observaciones) {
        super(persona);
        this.fecha = fecha;
        this.observaciones = observaciones;
    }


    @Override
    public String getInformacionCompleta() {
        return super.getInformacionCompleta() + 
               String.format(", Fecha Adopción: %s, Observaciones: %s", fecha, observaciones);
    }

    // Getters y setters existentes...
    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }
}