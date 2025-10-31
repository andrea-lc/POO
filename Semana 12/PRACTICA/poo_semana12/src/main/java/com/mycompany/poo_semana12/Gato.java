/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo_semana12;

/**
 *
 * @author admin
 */
public class Gato {
    String nombre;
    
    public Gato(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String toString() {
        return "Gatito: " + nombre;
    }
}
