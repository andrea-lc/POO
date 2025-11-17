/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menus;

import Entidades.Persona;
import Entidades.Voluntarios;
import Gestores.Gestor_Voluntario;
import Scanner.Lector;

/**
 *
 * @author admin
 */
public class Acciones_Voluntario implements Menu_Acciones{
    Lector lector= new Lector();
    Gestor_Voluntario gestor_voluntario= Gestor_Voluntario.getInstanciaAdoptante();
    
    @Override
    public void registrar() {
        System.out.println("\n========== REGISTRO ==========");
        System.out.print("Dni: ");
        int dni= lector.LeerEntero();
        System.out.print("Nombre: ");
        String nombre= lector.LeerString();
        System.out.print("Correo: ");
        String correo= lector.LeerString();
        System.out.print("Telefono: ");
        int telefono = lector.LeerEntero();
        System.out.print("Horarios Disponibles: ");
        String Horarios_disponibles= lector.LeerString();
        
        gestor_voluntario.registrar(new Voluntarios(new Persona(dni,nombre,telefono,correo),Horarios_disponibles));
        }   

    @Override
    public void Listar() {
        gestor_voluntario.mostrar();
    }

    @Override
    public void Buscar() {
        System.out.print("Ingrese el nombre dni del voluntario que desea buscar: ");
        String adoptanteBuscado= lector.LeerString();
        if (gestor_voluntario.existe(adoptanteBuscado)==true){
            gestor_voluntario.buscar(adoptanteBuscado);
            }else {
            System.out.println("Voluntario no encontrado");
            }      
        }

    @Override
    public void modificar() {
        System.out.println("\n======= MODIFICAR DATOS =======");
        System.out.print("Ingrese el nombre o ID del voluntario que desea modificar: ");
        String voluntarioModificar= lector.LeerString();
                int opcion;
        if (gestor_voluntario.existe(voluntarioModificar)== true){
            boolean seguir; //va a iniciar como si se quisiera continuar modificando
            do{                     
                System.out.println("Que dato desea modificar: ");
                System.out.print("1) Telefono: ");
                System.out.print("2) Correo: ");
                System.out.print("3) Horario");
                System.out.print("Ingrese una opcion: ");
                opcion=lector.LeerEntero();
                gestor_voluntario.modificar(voluntarioModificar, opcion);
                System.out.print("Desea modificar otro dato?(si/no):");
                String respuesta=lector.LeerString();
                seguir= respuesta.equalsIgnoreCase("si"); //? true:false
                System.out.println("==========================");
            }while (seguir);
            System.out.println("Datos modificados exitosamente! ");
        } else {
            System.out.println("Voluntario no encontrado");
            }
    }   

}
