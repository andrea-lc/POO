/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menus;

import Entidades.Adoptantes;
import Entidades.Persona;
import Gestores.Gestor_Adoptante;
import Gestores.Gestor_Gatos;
import Scanner.Lector;

/**
 *
 * @author admin
 */
public class Acciones_Adoptante implements Menu_Acciones{

    Lector lector=new Lector ();
    Gestor_Adoptante gestor_adoptante= new Gestor_Adoptante();
    Gestor_Gatos gestor_gatos= new Gestor_Gatos();

    @Override
    // aca ocurre un error, que pasa si se ingresa un gato pero este no esta en 
    // la lista de los adoptables, ocurre un error, por eso puse un try porque
    // si no se cerraba el programa abrutamente :(
    public void registrar() { // registrara el proceso para adoptar
        System.out.println("\n========== REGISTRO ==========");
        System.out.print("Dni: ");
        int dni= lector.LeerEntero();
        System.out.print("Nombre: ");
        String nombre= lector.LeerString();
        System.out.print("Correo: ");
        String correo= lector.LeerString();
        System.out.print("Telefono: ");
        int telefono = lector.LeerEntero();
        System.out.print("Gatos en adopcion disponibles: ");
        gestor_gatos.mostrarGatos(); // muestra gatos en adopcion :0
        System.out.print("Ingrese el nombre de un Gato: ");
        int gato_Adoptado=(gestor_gatos.conseguirID(lector.LeerString()));
        System.out.println("===============================");
        gestor_adoptante.registrar(new Adoptantes(new Persona(dni,nombre,telefono,correo),gato_Adoptado));
        }   
        

    @Override
    public void Listar() {
        gestor_adoptante.mostrar();
    }

    @Override
    public void Buscar() {
        System.out.print("Ingrese el nombre  o dni del adoptante que desea buscar: ");
        String adoptanteBuscado= lector.LeerString();
        if (gestor_adoptante.existe(adoptanteBuscado)==true){
            gestor_adoptante.buscar(adoptanteBuscado);
            }else {
            System.out.println("Adoptante no encontrado");
            }      
        }


    @Override
    public void modificar() { // aqui se modificara el proceso a rechzado o aceptado
        System.out.println("\n======= MODIFICAR DATOS =======");
        System.out.print("Ingrese el nombre o ID del adoptante que desea modificar: ");
        String adoptanteModificar= lector.LeerString();
        int opcion;
        if (gestor_adoptante.existe(adoptanteModificar)== true){
            boolean seguir; //va a iniciar como si se quisiera continuar modificando
            do{                     
                System.out.println("Que dato desea modificar: ");
                System.out.print("1) Telefono: ");
                System.out.print("2) Correo: ");
                System.out.print("Ingrese una opcion: ");
                opcion=lector.LeerEntero();
                gestor_adoptante.modificar(adoptanteModificar, opcion);
                System.out.print("Desea modificar otro dato?: (si/no)");
                String respuesta=lector.LeerString();
                seguir= respuesta.equalsIgnoreCase("si"); //? true:false
                System.out.println("==========================");
            }while (seguir);
            System.out.println("Datos modificados exitosamente! ");
        } else {
            System.out.println("Adoptante no encontrado");
            }
    }
    
}
