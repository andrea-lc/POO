/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Menus;

import Entidades.Gatos;
import Gestores.Gestor_Gatos;
import Scanner.Lector;

/**
 *
 * @author admin
 */
public class Acciones_gatos implements Menu_Acciones  {
    Lector lector=new Lector ();
    Gestor_Gatos gestor= new Gestor_Gatos();
    @Override
    public void registrar() {
        System.out.print("ID: ");
        int id = lector.LeerEntero();
        System.out.print("Nombre: ");
        String nombre = lector.LeerString();
        System.out.print("Edad: ");
        int edad = lector.LeerEntero();
        System.out.print("Raza: ");
        String raza = lector.LeerString();
        System.out.println("Estado del gato: (En adopción, Adoptado, En cuidado, En recuperación)");
        String estado_gato= lector.LeerString();
        System.out.println("Cuidado requerido:");
        String cuidado_requerido=lector.LeerString();
        gestor.registrar(new Gatos(id,nombre,edad,raza,estado_gato,cuidado_requerido));
    }

    @Override
    public void Listar() {
        if (gestor.getElementos().isEmpty()) {
        System.out.println("No hay gatos registrados en el sistema.");
        return;
    }  
        System.out.println("\n=== LISTA DE GATOS REGISTRADOS ===");
        System.out.println("Total de gatos: " + gestor.getElementos().size());
        System.out.println("-----------------------------------");
        
        for (Gatos gato : gestor.getElementos().values()) {
        System.out.println("Gato #" + gato.getNombre());
        System.out.println("  ID: " + gato.getId());
        System.out.println("  Edad: " + gato.getEdad() + " años");
        System.out.println("  Raza: " + gato.getRaza());
        System.out.println("  Estado: " + gato.getEstado_gato());
        System.out.println("  Cuidados requeridos: " + gato.getCuidado_requerido());
        System.out.println("-----------------------------------");
        }
    }

    @Override
    public void Buscar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void modificar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    } 
}
