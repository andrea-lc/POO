/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo_project;

/**
 *
 * @author admin
 */
public class Gatos {
    // ========================
    // ATRIBUTOS
    // ========================
    private int id;
    // Nombre del gato
    private String nombre;
    // Edad del gato en años
    private int edad;
    // Raza del gato (ejemplo: Persa, Siamés, Mestizo)
    private String raza;

    // ========================
    // CONSTRUCTOR
    // ========================
    // Constructor paramétrico que recibe todos los datos del gato.
    // Permite crear un objeto Gatos con valores específicos desde el inicio.
    public Gatos(int id, String nombre, int edad, String raza) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.raza = raza;
    }

    // ========================
    // MÉTODOS GETTERS
    // ========================
    // Devuelve el ID del gato
    public int getId() {
        return id;
    }

    // Devuelve el nombre del gato
    public String getNombre() {
        return nombre;
    }

    // Devuelve la edad del gato
    public int getEdad() {
        return edad;
    }

    // Devuelve la raza del gato
    public String getRaza() {
        return raza;
    }

    // ========================
    // MÉTODO toString()
    // ========================
    // Sobrescribe el método toString de la clase Object.
    // Permite mostrar la información del gato en formato legible al imprimir el objeto.
    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Edad: " + edad + ", Raza: " + raza;
    }
}