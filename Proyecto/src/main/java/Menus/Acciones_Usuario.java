/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menus;

import Entidades.Administradores;
import Entidades.Persona;
import Gestores.Gestor_usuarios;
import Scanner.Lector;

/**
 *
 * @author admin
 */
public class Acciones_Usuario implements Menu_Acciones{
    Lector lector= Lector.getInstanciaLector();
    Gestor_usuarios usuarios= Gestor_usuarios.getInstanciaUsuario();

    
    @Override
    public void registrar() {
        System.out.print("Correo: ");
        String correo = lector.LeerString();             
        System.out.print("Nombre de Usuario: ");
        String nombre = lector.LeerStringMayuscula();
        System.out.print("Apellido: ");  
        String apellido = lector.LeerStringMayuscula();                    
        System.out.print("Dni: ");
        int dni= lector.LeerEntero();                 
        System.out.print("Telefono: ");
        int telefono= lector.LeerEntero();                
        System.out.print("Cree una contraseña: ");
        String contraseña = lector.LeerString();                  
        Administradores admin=new Administradores (new Persona(dni,nombre,apellido,telefono,correo)
                ,contraseña);
        // Llamar al metodo del gestor para registrar un nuevo usuario
        usuarios.registrar(admin);
    }

    
    
    
    @Override
    public void Listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Buscar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void modificar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
