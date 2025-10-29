/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.semana9;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class Semana9 {
    public static void main(String[] args) {
         Refugio refugio = new Refugio();
        
        AnimalAdoptable gato = new Gato("Mimi", true);
        refugio.adoptarAnimal(gato);
        
        AnimalAdoptable perro = new Perro("Rex", true);
        refugio.adoptarAnimal(perro);
        
        List<AnimalAdoptable> animales = new ArrayList<>();
        animales.add(gato);
        animales.add(perro);
        
        for(AnimalAdoptable animal : animales) {
            refugio.adoptarAnimal(animal);
        }
    }
}
