/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Gestores;

import Entidades.Persona;

/**
 *
 * @author admin
 */
public interface UsuarioGestorInterface{
    boolean login(String correo, String contraseña);
    Persona buscarPorCorreo(String correo);
}
