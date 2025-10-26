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
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author admin
 */
public class Gestor_Gatos extends GestorBase<Gatos> {
    Lector lector=new Lector ();

    public Gestor_Gatos() {
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
                    Gatos gato=new Gatos (id,nombre,edad,raza,estado_gato,cuidado_requerido);
                    
                    getElementos().put(String.valueOf(gato.getId()), gato);
                }
            }
        } catch (IOException e) {
            System.out.println("No se pudo cargar usuarios (puede que el archivo esté vacio).");
        }
    }

    @Override
    public boolean registrar(Gatos gatos) {
        if (getElementos().containsKey(String.valueOf(gatos.getId()))) {   //verifica si el map contiene la clave
            System.out.println("Ese correo ya está registrado.");
            return true;
        }
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
        // Escribir los datos de la persona en el formato correcto
        String linea = String.format("%d,%s,%d,%s,%s,%s",
            gatos.getId(),
            gatos.getNombre(),
            gatos.getEdad(),
            gatos.getRaza(),
            gatos.getEstado_gato(),
            gatos.getCuidado_requerido());     
        bw.write(linea);
        bw.newLine();
        System.out.println("Usuario agregado correctamente.");

        getElementos().put(String.valueOf(gatos.getId()), gatos);        
            } catch (IOException ex) {
            System.out.println("Error al guardar en usuarios.txt");
        }
    return true;
    }

    
    @Override
    // verificara si un gato existe >:( y si no piña
    public boolean existe(String identificador) {
            for (Gatos gato : getElementos().values()) {
            if (gato.getNombre().equalsIgnoreCase(identificador)){
                System.out.println("\n======= GATOS ENCONTRADO =======");
                System.out.println("Gato #" + gato.getNombre());
                System.out.println("  ID: " + gato.getId());
                System.out.println("  Edad: " + gato.getEdad() + " años");
                System.out.println("  Raza: " + gato.getRaza());
                System.out.println("  Estado: " + gato.getEstado_gato());
                System.out.println("  Cuidados requeridos: " + gato.getCuidado_requerido());
                System.out.println("----------------------------------");               
            }
        }
            return true;
    }

    @Override
    // esta saliendo desordenado !!!
    public void mostrar() {
        if (getElementos().isEmpty()) {
        System.out.println("No hay gatos registrados en el sistema.");
        return;
    }  
        System.out.println("\n=== LISTA DE GATOS REGISTRADOS ===");
        System.out.println("Total de gatos: " + getElementos().size());
        System.out.println("-----------------------------------");
        
        for (Gatos gato : ordenar()) {
        System.out.println("Gato #" + gato.getNombre());
        System.out.println("  ID: " + gato.getId());
        System.out.println("  Edad: " + gato.getEdad() + " años");
        System.out.println("  Raza: " + gato.getRaza());
        System.out.println("  Estado: " + gato.getEstado_gato());
        System.out.println("  Cuidados requeridos: " + gato.getCuidado_requerido());
        System.out.println("-----------------------------------");
        }
    }

    
    // opciones que tenia, usar put() o usar replace()
    // mas segura? replace ya que si la llave no existe, 
    // no aumenta uno y es la indicada ya que esta sera una opcion para SOLO modificar
    // no put() porque si no existe la clave no aumenta nada  (sirve como info pero no para esta parte :()ERROR
    @Override
    public void modificar(String gatoModificar, int opcion) { 
       
            System.out.print("Nuevo dato a remplazar: ");
            String nuevoDato=lector.LeerString();
            for (Gatos gato : getElementos().values()) {
                if( gato.getNombre().equalsIgnoreCase(gatoModificar) || 
                        gato.getId()==(Integer.parseInt(gatoModificar))){
                    switch (opcion){
                        case 1: 
                            gato.setNombre(nuevoDato);
                        break;
                        case 2:
                            gato.setEdad(Integer.parseInt(nuevoDato));
                            break;
                        case 3:
                            gato.setRaza(nuevoDato);
                            break;
                        case 4: 
                            gato.setEstado_gato(nuevoDato);
                            break;
                        case 5: 
                            gato.setCuidado_requerido(nuevoDato);
                            break;
                        default: System.out.println("Opcion invalida");                    
                        break;
                }
            // Como se esta modificando el objeto directamente, el Map se actualiza automaticamente
            // porque tenemos una referencia al mismo objeto
            }
        }              
    }
    @Override
    public List<Gatos> ordenar() {
        List<Gatos> listaGatos = new ArrayList<>(getElementos().values()); //llena la lista con los valores del Map :0
        
        // Insertion Sort
        for (int i = 1; i < listaGatos.size(); i++) {
            Gatos gatoActual = listaGatos.get(i);
            int j = i - 1;
            
            // Mover elementos mayores hacia la derecha
            while (j >= 0 && listaGatos.get(j).getId() > gatoActual.getId()) {
                listaGatos.set(j + 1, listaGatos.get(j));
                j--;
            }
            listaGatos.set(j + 1, gatoActual);
        }
        
        return listaGatos;
    }
    
    
}
   