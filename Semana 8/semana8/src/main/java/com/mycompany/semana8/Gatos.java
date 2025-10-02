/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semana8;

/**
 *
 * @author admin
 */
public class Gatos implements ICuidados, IAdopcion{
    private int id;
    private String nombre;
    private int edad;
    private String raza;
    private String estado_gato;
    private String cuidado_requerido;
    private boolean vacunasAlDia;

  
    public Gatos(int id, String nombre, int edad, String raza, String estado_gato, String cuidado_requerido) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.raza = raza;
        this.estado_gato = estado_gato;
        this.cuidado_requerido = cuidado_requerido;
        this.vacunasAlDia = false; // Por defecto
    }

    @Override
    public void aplicarTratamiento(String tratamiento) {
        this.cuidado_requerido = tratamiento;
        System.out.println("✅ Tratamiento aplicado a " + nombre + ": " + tratamiento);
    }

    @Override
    public boolean necesitaVacunas() {
        return !vacunasAlDia;
    }

    @Override
    public String getEstadoSalud() {
        return "Estado: " + estado_gato + " | Cuidados: " + cuidado_requerido;
    }

    @Override
    public boolean esAdoptable() {
        // Solo es adoptable si está sano y no necesita cuidados especiales
        return estado_gato.equalsIgnoreCase("en adopción") && 
               cuidado_requerido.equalsIgnoreCase("ninguno");
    }

    @Override
    public void marcarComoAdoptado() {
        this.estado_gato = "adoptado";
        System.out.println("🎉 ¡" + nombre + " ha sido adoptado!");
    }

    @Override
    public String getInformacionAdopcion() {
        return "Gato: " + nombre + " | Adoptable: " + (esAdoptable() ? "SÍ" : "NO");
    }

    // ========================
    // MÉTODOS ADICIONALES
    // ========================
    public void aplicarVacunas() {
        this.vacunasAlDia = true;
        System.out.println("💉 Vacunas aplicadas a " + nombre);
    }

    // Getters y Setters (tu código existente)
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public String getRaza() { return raza; }
    public String getEstado_gato() { return estado_gato; }
    public String getCuidado_requerido() { return cuidado_requerido; }

    public void setEstado_gato(String estado_gato) { this.estado_gato = estado_gato; }
    public void setCuidado_requerido(String cuidado_requerido) { this.cuidado_requerido = cuidado_requerido; }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Edad: " + edad + 
               ", Raza: " + raza + ", Estado: " + estado_gato + 
               ", Cuidados: " + cuidado_requerido + ", Vacunas: " + (vacunasAlDia ? "SÍ" : "NO");
    }
}

