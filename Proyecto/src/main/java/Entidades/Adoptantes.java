/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author admin
 */
public class Adoptantes extends Persona {
    private int gato_Adoptado;
    private String estado_Adopcion;
    
    public Adoptantes(Persona persona, int gato_Adoptado, String estado_Adopcion) {
        super (persona);
        this.gato_Adoptado = gato_Adoptado;
        this.estado_Adopcion = estado_Adopcion;
    }

    public int getGato_Adoptado() {
        return gato_Adoptado;
    }

    public void setGato_Adoptado(int gato_Adoptado) {
        this.gato_Adoptado = gato_Adoptado;
    }

    public String getEstado_Adopcion() {
        return estado_Adopcion;
    }

    public void setEstado_Adopcion(String estado_Adopcion) {
        this.estado_Adopcion = estado_Adopcion;
    }
 
    @Override
    public String toString() {
        return super.toString()+ "Gato_Adoptado: "+ gato_Adoptado  + "\n"
                               + "Estado de la Adopcion: "+ estado_Adopcion;
    }
    
}
