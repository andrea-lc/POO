/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestores;

import Entidades.Gatos;
import Scanner.Lector;
import java.util.List;

/**
 *
 * @author admin
 */
public class Gestor_Gatos {
    Lector lector=new Lector ();

    // Permite registrar un nuevo gato solicitando sus datos por consola y 
    // guardándolos en el archivo mediante Gestor_usuarios.
    public void registrarGato() {      
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
        
        Gestor_usuarios gestor_gatos = new Gestor_usuarios();
        gestor_gatos.guardarGato(id, nombre, edad, raza, estado_gato, cuidado_requerido);
    }

    // Método privado que lista todos los gatos guardados en el archivo.
    // Si no hay registros, muestra un mensaje informativo.
    public void listarGatos() {
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
    public void buscarGato() {
        Gestor_usuarios gestor = new Gestor_usuarios();
        List<Gatos> gatos = gestor.leerGatos();

        System.out.print("Ingrese el nombre del gato a buscar: ");
        String nombre_Buscado = lector.LeerString(); 

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
    
    public void modificar(){ 
        Gestor_usuarios gestor = new Gestor_usuarios();
        List<Gatos> gatos = gestor.leerGatos();
        boolean gato_correcto = false;  
        boolean intentardenuevo = true; 
        int id_Buscado;
            
        do{ 
            System.out.println("Ingrese Id del gato a modificar:");
            id_Buscado=lector.LeerEntero();
            
            for (Gatos g : gatos) {
                if (g.getId()==(id_Buscado)) {
                    gato_correcto=true;
                    break;                
                }else{
                    System.out.println("Gato no encontrado");                      
                    System.out.print("Desea intentar de nuevo? (si/no): ");
                    String volver = lector.LeerString();
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
        int modificacion=lector.LeerEntero();

        switch (modificacion){
            case 1: {
                System.out.println("Nuevo nombre: ");
                String nuevo=lector.LeerString();
                gestor.modificador(nuevo, id_Buscado, modificacion);
                break;
            }
            case 2: {
                System.out.println("Nueva edad: ");
                String nuevo=lector.LeerString();
                gestor.modificador(nuevo, id_Buscado, modificacion); 
                break;
            }
            case 3: {
                System.out.println("Nuevo estado del gato: ");
                String nuevo=lector.LeerString();
                gestor.modificador(nuevo, id_Buscado, modificacion);
                break;
            }
            case 4: { 
                System.out.println("Nuevo cuidado requerido: ");
                String nuevo=lector.LeerString();
                gestor.modificador(nuevo, id_Buscado, modificacion);
                break;
            }
            default: {
                System.out.println("Numero invalido");
            }           
        }       
    }
}
