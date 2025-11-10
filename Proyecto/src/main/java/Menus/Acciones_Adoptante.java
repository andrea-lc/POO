/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menus;

import Scanner.Lector;

/**
 *
 * @author admin
 */
public class Acciones_Adoptante implements Menu_Acciones{
    Lector lector=new Lector ();

    @Override
    public void registrar() { // registrara elproceso para adoptar
        System.out.println("\n========== REGISTRO ==========");
        System.out.println("Nombre: ");
        String nombre= lector.LeerString();
        System.out.println("Escoja un gato disponible: ");
        Listar();
        String nombre_gatos= lector.LeerString();
        System.out.println("Cargando proceso...");
        System.out.println("Estado del proceso: "+ get.estado_proceso);
        
        

    }

    @Override
    public void Listar() { // mostar la lista de gatos para adoptar 
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Buscar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void modificar() {// aqui se modificara el proceso a rechzado o aceptado
    }
    
}
