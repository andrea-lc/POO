/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestores;

import Entidades.Gatos;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Gestor_Gatos {

    // ========================
    // ATRIBUTOS
    // ========================
    // Es final porque se inicializa al crear el objeto y no cambia.
    private final Scanner scanner;
    // ========================
    // CONSTRUCTOR
    // ========================
    // Constructor paramétrico que recibe un objeto Scanner
    // para reutilizar la entrada de datos desde la clase Menu.
    public Gestor_Gatos(Scanner scanner) {
        this.scanner = scanner;
    }

    // ========================
    // MÉTODOS
    // ========================

    // Método público, no paramétrico y sin retorno (void).
    // Muestra el submenú de gestión de gatos y maneja las opciones.
    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n=== Gestión de Gatos ===");
            System.out.println("1) Registrar nuevo gato");
            System.out.println("2) Listar gatos");
            System.out.println("3) Buscar gato por nombre");
            System.out.println("4) Modificar algun dato");
            System.out.println("0) Volver");
            System.out.println("========================");
            System.out.print("Elige una opción: ");
            
            // Leer la opción elegida
            opcion = leerEntero();

            // Manejar la opción seleccionada
            switch (opcion) {
                case 1: {
                    // Registrar un nuevo gato
                    registrarGato();
                    break;
                }
                case 2: {
                    // Listar todos los gatos
                    listarGatos();
                    break;
                }
                case 3: {
                    // Buscar un gato por su ID
                    buscarGato();
                    break;
                }
                case 4: 
                    // Modificar algun dato
                    modificar();
                    
                case 0: {
                    // Volver al menú principal
                    System.out.println("Volviendo al menú principal...");
                    break;
                }
                default: {
                    // Manejo de opción inválida
                    System.out.println("Opción inválida.");
                }
            }
        } while (opcion != 0); // Se repite hasta que el usuario decida salir
    }

    // Método privado que intenta leer un número entero desde la consola.
    // Si el usuario ingresa un valor inválido, pide de nuevo hasta que sea correcto.
    private int leerEntero() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Ingresa un número válido: ");
            }
        }
    }

        private String leerString() {
        while (true) {
            try {
                return scanner.nextLine().trim();
            } catch (NumberFormatException e) {
                System.out.print("Ingresa un número válido: ");
            }
        }
    }
    // Método privado, no paramétrico y sin retorno.
    // Permite registrar un nuevo gato solicitando sus datos por consola y 
    // guardándolos en el archivo mediante Gestor_usuarios.
    private void registrarGato() {      
        System.out.print("ID: ");
        int id = leerEntero();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Edad: ");
        int edad = leerEntero();
        System.out.print("Raza: ");
        String raza = scanner.nextLine();
        System.out.println("Estado del gato: (En adopción, Adoptado, En cuidado, En recuperación)");
        String estado_gato= scanner.nextLine();
        System.out.println("Cuidado requerido:");
        String cuidado_requerido=scanner.nextLine();
        
        Gestor_usuarios gestor_gatos = new Gestor_usuarios();
        gestor_gatos.guardarGato(id, nombre, edad, raza, estado_gato, cuidado_requerido);
    }

    // Método privado que lista todos los gatos guardados en el archivo.
    // Si no hay registros, muestra un mensaje informativo.
    private void listarGatos() {
        Gestor_usuarios gestor = new Gestor_usuarios();
        List<Gatos> gatos = gestor.leerGatos();

        if (gatos.isEmpty()) {
            System.out.println("No hay gatos registrados.");
        } else {
            System.out.println("=========== Lista de gatos ===========");
            for (Gatos g : gatos) {
                // Gracias al método toString() de Gatos,
                // se imprime la información formateada automáticamente.
                System.out.println(g); 
            }
        }
    }

    // Método privado que permite buscar un gato por su ID.
    // Recorre la lista de gatos y muestra el primero que coincida.
    // Si no se encuentra, informa al usuario.
    private void buscarGato() {
        Gestor_usuarios gestor = new Gestor_usuarios();
        List<Gatos> gatos = gestor.leerGatos();

        System.out.print("Ingrese el nombre del gato a buscar: ");
        String nombre_Buscado = leerString(); 

        boolean encontrado = false;

        // Buscar en la lista de gatos
        for (Gatos g : gatos) {
            if (g.getNombre().equalsIgnoreCase(nombre_Buscado)) {
                System.out.println("Gato encontrado:");
                System.out.println(g); // Se imprime gracias a toString()
                encontrado = true;
                break; 
            }
        }

        // Si no se encontró ningún gato con el nombre ingresado
        if (!encontrado){
            System.out.println("No se encontró un gato con ese nombre");
        }
    }
    
    private void modificar(){ 
        Gestor_usuarios gestor = new Gestor_usuarios();
        List<Gatos> gatos = gestor.leerGatos();
        boolean gato_correcto = false;  
        boolean intentardenuevo = true; 
        int id_Buscado;
            
        do{ 
            System.out.println("Ingrese Id del gato a modificar:");
            id_Buscado=leerEntero();
            
            for (Gatos g : gatos) {
                if (g.getId()==(id_Buscado)) {
                    gato_correcto=true;
                    break;                
                }else{
                    System.out.println("Gato no encontrado");                      
                    System.out.print("Desea intentar de nuevo? (si/no): ");
                    String volver = leerString();
                    // Si el usuario no quiere volver a intentar, salir del bucle
                    if (volver.equalsIgnoreCase("no")) {
                        intentardenuevo = false;
                        System.out.println("Regresando...");
                    }        
                }
            }
            
        }while (!gato_correcto && intentardenuevo);
        
        System.out.println("Que dato del gato desea modificar:");
        System.out.println("1) Nombre"); 
        System.out.println("2) Edad:");
        System.out.println("3) Estado");
        System.out.println("4) Cuidado requerido");      
        int modificacion=leerEntero();

        switch (modificacion){
            case 1: {
                System.out.println("Nuevo nombre: ");
                String nuevo=leerString();
                gestor.modificador(nuevo, id_Buscado, modificacion);
                break;
            }
            case 2: {
                System.out.println("Nueva edad: ");
                String nuevo=leerString();
                gestor.modificador(nuevo, id_Buscado, modificacion); 
                break;
            }
            case 3: {
                System.out.println("Nuevo estado del gato: ");
                String nuevo=leerString();
                gestor.modificador(nuevo, id_Buscado, modificacion);
                break;
            }
            case 4: { 
                System.out.println("Nuevo cuidado requerido: ");
                String nuevo=leerString();
                gestor.modificador(nuevo, id_Buscado, modificacion);
                break;
            }
            default: {
                System.out.println("Numero invalido");
            }           
        }       
    }
}
