/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestores;

import Entidades.Gatos;
import Scanner.Lector;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 *
 * @author admin
 */
public class Gestor_Gatos extends GestorBase<Gatos> {
    Lector lector=new Lector ();

    public Gestor_Gatos(String rutaArchivo) {
        super("gatos.txt");
    }
    
    @Override
    public void cargarDatos() {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 6) {
                    int id = Integer.parseInt(datos[0]);
                    String nombre = datos[1];
                    int edad = Integer.parseInt(datos[2]);
                    String raza = datos[3];
                    String estado_gato = datos [4];
                    String cuidado_requerido = datos[5];
                    listaGatos.add(new Gatos(id, nombre, edad, raza,estado_gato, cuidado_requerido));
    }

    @Override
    public void guardarDatos(Gatos gato) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
            String linea = String.format("%d,%s,%d,%s,%s,%s",
            gato.getId(),
            gato.getNombre(),
            gato.getEdad(),
            gato.getRaza(),
            gato.getEstado_gato(),
            gato.getCuidado_requerido());
        bw.write(linea);
        bw.newLine();
        
        getElementos().put(String.valueOf(gato.getId()), gato);
            System.out.println("Gato agregado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar gato en el archivo.");
        }
    }

    @Override
    public boolean registrar(Gatos elemento) {
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
        Gatos gato= new Gatos(id,nombre,edad,raza,estado_gato,cuidado_requerido);
        guardarDatos(gato);   
        return false;
    }

    @Override
    public boolean existe(String identificador) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
 
}
