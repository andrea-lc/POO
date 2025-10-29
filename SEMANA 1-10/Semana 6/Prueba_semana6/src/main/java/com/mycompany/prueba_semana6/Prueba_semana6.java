/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.prueba_semana6;

/**
 *
 * @author admin
 */
public class Prueba_semana6 {

    public static void main(String[] args) {
        Adoptante adoptante=new Adoptante(1, "Carlos Perez", 987654321, "Av. Siempre Viva 123", "carlos@example.com", 
                                          "06/07/2025" ,"ninguna");
        
        Voluntarios voluntario =new Voluntarios(1, "Carlos Perez", 987654321, "Av. Siempre Viva 123", "carlos@example.com", 
                                          "Limpiar");
        
        System.out.println(adoptante);
        System.out.println(adoptante.mostrarRol());
        System.out.println("");
        System.out.println(voluntario);
        System.out.println(voluntario.mostrarRol());
    }
}
