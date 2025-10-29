/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semana9;

/**
 *
 * @author admin
 */
public class Refugio {
    // Usa la interfaz, no la clase concreta
    public void adoptarAnimal(AnimalAdoptable animal) {
        if(animal.estaSano()) {
            System.out.println("Adoptando: " + animal.getNombre());
        }
    }
}