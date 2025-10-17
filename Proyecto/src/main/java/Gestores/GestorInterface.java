/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Gestores;

/**
 *
 * @author admin
 * @param <t>
 */
public interface GestorInterface <t> {
    void cargarDatos();
    void guardarDatos();
    boolean registrar(t elemento);
    boolean existe(String identificador);
}
