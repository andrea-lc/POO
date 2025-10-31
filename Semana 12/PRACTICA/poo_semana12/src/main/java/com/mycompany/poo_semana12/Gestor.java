/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo_semana12;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author admin
 * @param <V>
 */
public class Gestor<V>{
    protected Map<String, V> elementos = new HashMap<>();
    
    public void registrar(String clave, V elemento) {
        elementos.put(clave, elemento);
        System.out.println("Registrado: " + elemento);
    }
    
    public void mostrarTodo() {
        System.out.println("=== ELEMENTOS ===");
        for (V elemento : elementos.values()) {
            System.out.println(elemento);
        }
    }
    
    public V buscar(String clave) {
        return elementos.get(clave);
    }
}

