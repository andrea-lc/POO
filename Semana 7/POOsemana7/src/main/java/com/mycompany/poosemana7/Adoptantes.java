/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poosemana7;

import java.time.LocalDate;



/**
 *
 * @author admin
 */
public class Adoptantes extends Persona {
    private LocalDate fecha;
    private String observaciones;

    public Adoptantes(int id_persona, String nombre, int telefono, String direccion, 
                     String correo, LocalDate fecha, String observaciones) {
        super(id_persona, nombre, telefono, direccion, correo);
        this.fecha = fecha;
        this.observaciones = observaciones;
    }

    // Constructor de copia
    public Adoptantes(Persona persona, LocalDate fecha, String observaciones) {
        super(persona);
        this.fecha = fecha;
        this.observaciones = observaciones;
    }

    @Override
    public String getTipoPersona() {
        return "Adoptante";
    }

    @Override
    public String getInformacionCompleta() {
        return super.getInformacionCompleta() + 
               String.format(", Fecha Adopción: %s, Observaciones: %s", fecha, observaciones);
    }

    // Getters y setters existentes...
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }
}