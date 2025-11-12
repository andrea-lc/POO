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
    
    public Adoptantes(Persona persona, int gato_Adoptado) {
        super (persona);
        this.gato_Adoptado = gato_Adoptado;
    }

    public int getGato_Adoptado() {
        return gato_Adoptado;
    }

    public void setGato_Adoptado(int gato_Adoptado) {
        this.gato_Adoptado = gato_Adoptado;
    }

    @Override
    public String toString() {
        return super.toString()+ "Gato_Adoptado: "+ gato_Adoptado  + "\n" ;
    }
    
}
