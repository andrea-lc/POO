/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prueba_semana6;

/**
 *
 * @author admin
 */
public class Voluntarios extends Persona {
    String tarea;

    public Voluntarios(int id_persona, String nombre, int telefono, String direccion, String correo,String tarea) {
        super(id_persona, nombre, telefono, direccion, correo);
        this.tarea = tarea;
    }


    public String getTarea() {
        return tarea;
    }

    public void setTareas(String tareas) {
        this.tarea = tareas;
    }
        @Override
    public String toString() {
        String texto = String.format(
            "%-20s %-20s%n" +   
            "%-20s%n" +  
            "%-30s%n" +         
            "%-30s",            
            "Id: " + id_persona,
            "Nombre: " + nombre,
            "Telefono: " + telefono,
            "Direccion: " + direccion,
            "Tarea: " + tarea
        );
        return texto;
    }  

    @Override
    public String mostrarRol() {
        String texto= String.format("Rol: Voluntario");
        return texto;
    }
   
}
