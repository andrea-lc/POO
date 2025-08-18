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
        Menu menu=new Menu ();
        int opcion;
        do {
            System.out.println("""
                               ------------------Cat Haven------------------
                               1) Iniciar sesion
                               2) Registrar nuevo Usuario
                               3) Salir 
                               --------------------------------------------""");    
            opcion=scanner.nextInt(); 
            scanner.nextLine();
            switch (                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 opcion){
                case 1 -> { 
                    boolean logincorrecto=false;
                    boolean intentardenuevo=true;
                    do{
                        System.out.println("Nombre de Usuario: ");
                        String user_name=scanner.nextLine();
                        System.out.println("Contraseña: ");
                        String contraseña=scanner.nextLine();
                        if (gu.login(user_name, contraseña)) {
                            System.out.println("Ingresando...");
                            logincorrecto = true;
                            menu.mostrar();
                        } else {
                            System.out.println("Usuario o contraseña incorrectos.");
                            System.out.print("Desea intentar de nuevo? (si/no): ");
                            String volvermenu = scanner.nextLine();
                            
                            if (volvermenu.equalsIgnoreCase("no")) {
                                intentardenuevo = false;
                                System.out.println("Regresando al menú principal...");
                            }
                        }
                    } while (!logincorrecto && intentardenuevo);
                    break;
                }
                case 2 -> { 
                    System.out.println("Nombre de Usuario: ");
                    String user_name1=scanner.nextLine();
   
                    System.out.println("Cree una constraseña: ");
                    String contraseña1=scanner.nextLine();   
                    gu.registrar_usuario(user_name1, contraseña1);
                    break;
                }
                case 3 -> {
                    break;
                }
                default -> System.out.println("Ingrese una opcion valida");
            }
        }while (opcion!=3);        
    }
}
