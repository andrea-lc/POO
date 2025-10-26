/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Gestores;

import java.util.List;

/**
 *
 * @author admin
 * @param <t>
 */
public interface GestorInterface <t> {
    void cargarDatos();
    boolean registrar(t elemento);
    boolean existe(String identificador);
    void mostrar ();
    void modificar (String datoModificar, int opcion);
    List<t> ordenar();
}
