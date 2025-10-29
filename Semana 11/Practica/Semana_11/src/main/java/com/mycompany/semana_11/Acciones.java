/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semana_11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Acciones{
    Scanner scanner= new Scanner (System.in);
    protected List<Persona> elementos= new ArrayList<>();
    
    public void insertar (){
        System.out.print("\nIngrese el nombre: ");
        String nombre= scanner.nextLine();
        System.out.print("Ingrese la edad: ");
        int edad= scanner.nextInt();
        scanner.nextLine();
        elementos.add(new Persona (nombre,edad));
        System.out.println("Persona Agregada");
    }
    
    public void buscar (){
        System.out.print("\nIngrese el nombre de la persona que desea buscar: ");
        String nombreBuscado = scanner.nextLine(); // <- .trim() elimina espacios
    
    for (Persona persona : elementos) {
        if (persona.getNombre().equalsIgnoreCase(nombreBuscado)) {
            System.out.println(persona);            
            }            
        }
    }
    
    public void eliminar (){
        System.out.print("\nIngrese el nombre de la persona que desea eliminar: ");
        String eliminar=scanner.nextLine();
        for (Persona persona: elementos){
            if (persona.getNombre().equalsIgnoreCase(eliminar)){
                int indice = elementos.indexOf(persona);
                elementos.remove(indice);
                break;
            }       
        }
        System.out.println("Persona eliminada ");
    }
    public void modificar (){
        System.out.print("\nIngrese el nombre de la persona el cual desea modificar un dato: ");
        String nombre= scanner.nextLine();
        System.out.print("""
                           Modificar:
                           1) Nombre
                           2) Edad
                           Escoga una opcion: """);
        int opcion= scanner.nextInt();
        scanner.nextLine();

        switch (opcion){
            case 1 -> {
                System.out.print("Nuevo nombre: ");
                String nuevoNombre=scanner.nextLine();
                
                for (Persona persona: elementos){
                    if (persona.getNombre().equalsIgnoreCase(nombre)){
                    int indice = elementos.indexOf(persona);   
                    elementos.set(indice, new Persona(nuevoNombre,persona.getEdad()));
                    }
                }
            }
            case 2 -> {
                System.out.print("Nueva edad: ");
                int nuevaEdad=scanner.nextInt();
                scanner.nextLine();

                for (Persona persona: elementos){
                    if (persona.getNombre().equalsIgnoreCase(nombre)){
                    int indice = elementos.indexOf(persona);   
                    elementos.set(indice, new Persona(persona.getNombre(),nuevaEdad));
                    }
                }
            }                   
        }
        System.out.println("Dato modificado\n");               
    }
    public void mostrar (){
        for (Persona persona: elementos){
            System.out.println(persona);
        }
    }
}