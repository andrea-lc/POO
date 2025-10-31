/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poo_semana12;

/**
 *
 * @author admin
 */
public class Poo_semana12 {

    public static void main(String[] args) {
        System.out.println("=== MINI EJEMPLO GENERICOS + MAP ===\n");
        
        // Mismo gestor para DIFERENTES tipos
        Gestor<Gato> gestorGatos = new Gestor<>();
        Gestor<Usuario> gestorUsuarios = new Gestor<>();
        
        // Usar con Gatos
        gestorGatos.registrar("g1", new Gato("Michi"));
        gestorGatos.registrar("g2", new Gato("Luna"));
        
        // Usar con Usuarios  
        gestorUsuarios.registrar("u1", new Usuario("Ana"));
        gestorUsuarios.registrar("u2", new Usuario("Carlos"));
        
        // Mostrar
        gestorGatos.mostrarTodo();
        gestorUsuarios.mostrarTodo();
        
        // Buscar
        System.out.println("\nBuscando gato g1: " + gestorGatos.buscar("g1"));
        System.out.println("Buscando usuario u2: " + gestorUsuarios.buscar("u2"));
    }
}

