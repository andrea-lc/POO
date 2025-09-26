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
public class Voluntario extends Persona {
    private String fechaIngreso;
    private String areaTrabajo;
    private int horasSemanales;

    public Voluntario(int dni_persona, String nombre, int telefono, String direccion, 
                     String correo, String fechaIngreso, String areaTrabajo, int horasSemanales) {
        super(dni_persona, nombre, telefono, direccion, correo);
        this.fechaIngreso = fechaIngreso;
        this.areaTrabajo = areaTrabajo;
        this.horasSemanales = horasSemanales;
    }

    // Constructor de copia
    public Voluntario(Persona persona, String fechaIngreso, String areaTrabajo, int horasSemanales) {
        super(persona);
        this.fechaIngreso = fechaIngreso;
        this.areaTrabajo = areaTrabajo;
        this.horasSemanales = horasSemanales;
    }

    @Override
    public String getTipoPersona() {
        return "Voluntario";
    }

    @Override
    public String getInformacionCompleta() {
        return super.getInformacionCompleta() + 
               String.format(", Fecha Ingreso: %s, Área: %s, Horas/Semana: %d", 
                           fechaIngreso, areaTrabajo, horasSemanales);
    }

    // Getters y setters específicos
    public String getFechaIngreso() { return fechaIngreso; }
    public void setFechaIngreso(String fechaIngreso) { this.fechaIngreso = fechaIngreso; }
    public String getAreaTrabajo() { return areaTrabajo; }
    public void setAreaTrabajo(String areaTrabajo) { this.areaTrabajo = areaTrabajo; }
    public int getHorasSemanales() { return horasSemanales; }
    public void setHorasSemanales(int horasSemanales) { this.horasSemanales = horasSemanales; }
}
