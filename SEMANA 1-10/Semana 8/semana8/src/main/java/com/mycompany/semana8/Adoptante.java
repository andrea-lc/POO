/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semana8;

/**
 *
 * @author admin
 */
public class Adoptante implements Identificador {
    private String nombre;
    private int edad;
    // El metodo default no se sobreescribe ya que se usara el que ya esta predeterminado
    public Adoptante(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    
}
