/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.prueba_herencia;

/**
 *
 * @author admin
 */
public class Prueba_herencia {

    public static void main(String[] args) {
        Persona persona=new Persona (1, "Helena", 946414833, 
                "Av. Los Pioneros 742, Arequipa", "helenadelc@gmail.com");
        
        Adoptante adoptante=new Adoptante (persona,"18/09/2025","ninguna");
        
        System.out.println(adoptante);
       
            
        
    }
}
