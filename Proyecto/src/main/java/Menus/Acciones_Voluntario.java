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
    Lector lector= Lector.getInstanciaLector();
    Gestor_Voluntario gestor_voluntario= Gestor_Voluntario.getInstanciaAdoptante();
    
    @Override
    public void registrar() {
        System.out.println("\n========== REGISTRO ==========");
        System.out.print("Dni: ");
        int dni= lector.LeerEntero();
        System.out.print("Nombre: ");
        String nombre= lector.LeerStringMayuscula();
        System.out.print("Apellido: ");  
        String apellido = lector.LeerStringMayuscula();
        System.out.print("Correo: ");
        String correo= lector.LeerString();
        System.out.print("Telefono: ");
        int telefono = lector.LeerEntero();
        //aca muestra los horarios disponibles
        horariosDisponibles();
        System.out.print("Ingrese una opcion: ");
        String Horarios_disponibles;
        int opcion;
        while (true){
           opcion=lector.LeerEntero(); 
            if(opcion<=6 || opcion >=1){
               Horarios_disponibles= gestor_voluntario.gestionHorario(lector.LeerEntero());
               break;                
            }else {
                System.out.print("Opcion invalida, ingrese otra: ");
                }          
        } 
        gestor_voluntario.registrar(new Voluntarios(new Persona(dni,nombre,apellido, telefono,correo),
                Horarios_disponibles));
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
        System.out.println("==================================");
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
                while(true){
                    System.out.print("Ingrese una opcion: ");
                    opcion=lector.LeerEntero();
                    if (opcion>3 || opcion<1){
                        System.out.println("Opcion invalida");              
                    }else { break;}
                }
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
    
    private void horariosDisponibles() {
        String [] horarios={"Lunes (Diurno): 9:00 - 11:00", 
                            "Miércoles (Diurno): 10:00 - 12:00",
                            "Viernes (Diurno): 11:00 - 13:00",
                            "Martes (Tarde): 14:00 - 16:00",
                            "Jueves (Tarde): 15:00 - 17:00", 
                            "Sábado (Tarde): 16:00 - 18:00" };
            
        System.out.println("\n===== HORARIOS DISPONIBLES =====");      
        for (int i=0; i<horarios.length ;i++){
            System.out.println((i+1)+") "+horarios[i]);
        }
        
    }

}
