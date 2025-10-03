/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semana8;

/**
 *
 * @author admin
 */
public interface IAdopcion {
    boolean esAdoptable();
    default void marcarComoAdoptado(){
        
    };
    String getInformacionAdopcion();
}
