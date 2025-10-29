/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semana9;

/**
 *
 * @author admin
 */
public class Gato implements AnimalAdoptable {
    private String nombre;
    private boolean sano;
    
    public Gato(String nombre, boolean sano) {
        this.nombre = nombre;
        this.sano = sano;
    }
    
    @Override
    public boolean estaSano() {
        return sano;
    }
    
    @Override
    public String getNombre() {
        return nombre;
    }
}

