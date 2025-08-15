/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poo_project;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class POO_project {

    public static void main(String[] args) {
        Scanner scanner=new Scanner (System.in);
        Gestor_usuarios gu=new Gestor_usuarios(); 
        int opcion;
        do {
            System.out.println("""
                               -------Praderas del Adiós (cementerio)------
                               1) Iniciar sesion
                               2) Registrar nuevo Usuario
                               3) Salir 
                               --------------------------------------------""");    
            opcion=scanner.nextInt(); 
            switch (opcion){
                case 1:System.out.println("");
                    System.out.println("Nombre de Usuario: ");
                    String user_name=scanner.nextLine();
                    scanner.nextLine();
                    System.out.println("Contraseña: ");
                    String contraseña=scanner.nextLine();
                    gu.login(user_name, contraseña);
                    
                case 2: 
                    System.out.println("Nombre de Usuario: ");
                    String user_name1=scanner.nextLine();
                    scanner.nextLine();
                    System.out.println("Cree una constraseña: ");
                    String contraseña1=scanner.nextLine();   
                    gu.registrar_usuario(user_name1, contraseña1);
                case 3:                  
                    break;              
                default: System.out.println("Ingrese una opcion valida");
            }
        }while (opcion!=0);        
    }
}
