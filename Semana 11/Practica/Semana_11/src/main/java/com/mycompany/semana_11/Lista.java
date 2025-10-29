/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semana_11;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 * @param <T>
 */
public abstract class Lista <T> {
    protected List<T> elementos= new ArrayList<>();
    
    public List<T> getElementos (){
        return elementos;
    }
}
