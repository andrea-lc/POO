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
public class Menu {
    private Menu_Acciones acciones;  
    Lector lector=new Lector ();
    
    private void setAcciones(Menu_Acciones nuevasAcciones) {
        this.acciones = nuevasAcciones;
    }
       
    // Se encarga de mostrar el menú principal en consola
    public void MainMenu() {    
        int opcion;
        do {
            System.out.println("\n========== Cat Haven ==========");
            System.out.println("1) Gestion de Gatos");
            System.out.println("2) Historia");
            System.out.println("3) Adopciones");
            System.out.println("4) Voluntariado");
            System.out.println("5) Donaciones");
            System.out.println("0) Cerrar sesion");
            System.out.println("================================");
            System.out.print("Elige una opcion: ");
            
            // Leer opción ingresada por el usuario
            opcion = lector.LeerEntero();

            switch (opcion) {
                case 1: {
                    // Caso 1: Llama al módulo de gestión de gatos
                    mostrarMenuGatos();
                    break;
                }
                case 2: {
                    // Caso 2: Módulo de clientes (a implementar)
                    System.out.println("Aquí irá el módulo de clientes...");
                    break;
                }
                case 3: {
                    // Caso 3: Módulo de adopciones (a implementar)
                    mostrarMenuAdoptantes();
                    break;
                }
                case 4: {
                    // Caso 4: Módulo de reportes (a implementar)
                    System.out.println("Aquí irá el módulo de reportes...");
                    break;
                }
                case 0: {
                    // Caso 0: Salir del sistema
                    System.out.println("Cerrando sesión...");
                    break;
                }
                default: {
                    // Opción inválida: mensaje de error
                    System.out.println("Opción inválida.");
                }
            }
        } while (opcion != 0); // Repite hasta que el usuario elija salir
    }
    
    // Muestra el submenu sobre gatos y maneja las opciones.
    public void mostrarMenuGatos() {
        int opcion;
        setAcciones(new Acciones_gatos());
        do {
            System.out.println("\n=== Gestión de Gatos ===");
            System.out.println("1) Registrar nuevo gato");
            System.out.println("2) Listar gatos");
            System.out.println("3) Buscar gato por nombre");
            System.out.println("4) Modificar algun dato");
            System.out.println("0) Volver");
            System.out.println("========================");
            System.out.print("Elige una opción: ");
            
            // Leer la opcion elegida
            opcion = lector.LeerEntero();
            // Manejar la opción seleccionada
            switch (opcion) {
                case 1: {
                    // Registrar un nuevo gato
                    acciones.registrar();                   
                    break;
                }
                case 2: {
                    // Listar todos los gatos
                    acciones.Listar();
                    break;
                }
                case 3: {
                    // Buscar ung ato
                    acciones.Buscar();
                    break;
                }
                case 4: 
                    // Modificar algun dato
                    acciones.modificar();
                    break;
                case 0: {
                    // Volver al menú principal
                    System.out.println("Volviendo al menú principal...");
                    break;
                }
                default: {
                    // Manejo de opción invalida
                    System.out.println("Opción inválida.");
                }
            }
        } while (opcion != 0); // Se repite hasta que el usuario decida salir
    }
    public void mostrarMenuAdoptantes (){
        int opcion;
        setAcciones(new Acciones_Adoptante());
        do {
            System.out.println("\n=== Gestion de Adoptantes ===");
            System.out.println("1) Registrar nueva Adopcion");
            System.out.println("2) Listar adoptantes");
            System.out.println("3) Buscar Adoptante");
            System.out.println("4) Modificar algun dato");
            System.out.println("0) Volver");
            System.out.println("========================");
            System.out.print("Elige una opción: ");
            
            // Leer la opcion elegida
            opcion = lector.LeerEntero();
            // Manejar la opción seleccionada
            switch (opcion) {
                case 1: {
                    // Registrar un nuevo gato
                    acciones.registrar();                   
                    break;
                }
                case 2: {
                    // Listar todos los gatos
                    acciones.Listar();
                    break;
                }
                case 3: {
                    // Buscar un adoptante
                    acciones.Buscar();
                    break;
                }
                case 4: 
                    // Modificar algun dato
                    acciones.modificar();
                    break;
                case 0: {
                    // Volver al menu principal
                    System.out.println("Volviendo al menu principal...");
                    break;
                }
                default: {
                    // Manejo de opción invalida
                    System.out.println("Opción invalida.");
                }
            }
        } while (opcion != 0); 
    }
}