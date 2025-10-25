/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.semana_11;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Semana_11 {

    public static void main(String[] args) {
        Scanner scanner= new Scanner (System.in);
        Acciones acciones= new Acciones();
        int opcion;
        do{
            System.out.print("""
                               \n=======INDICE======== 
                               1) Agregar persona
                               2) Modificar persona
                               3) Buscar persona
                               4) Eliminar persona
                               5) Mostrar lista
                               6) Salir
                               Ingrese una opcion: """);
            opcion = scanner.nextInt();
            switch (opcion){
                case 1: acciones.insertar();
                break;
                case 2: acciones.modificar();
                break;
                case 3: acciones.buscar();
                break;
                case 4: acciones.eliminar();
                break;
                case 5: acciones.mostrar();
                break;
                case 6: System.out.println("Saliendo...");
                default: System.out.println("Opcion invalida");
            }
        } while (opcion!=6);
    }
}
