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
                if (datos.length == 9) { 
                    int id = Integer.parseInt(datos[0]);
                    String nombre = datos[1];
                    int edad = Integer.parseInt(datos[2]);
                    String raza = datos[3];
                    double peso= Double.parseDouble(datos[4]);
                    String genero=datos [5];
                    String esterilizacion= datos[6];
                    String estado_gato = datos [7];
                    String cuidado_requerido = datos[8];
                    Gatos gato=new Gatos (id,nombre,edad,raza,peso,genero,esterilizacion,estado_gato,cuidado_requerido);
                    
                    getElementos().put(String.valueOf(gato.getId()), gato);
                }
            }
        } catch (IOException e) {
            System.out.println("No se pudo cargar usuarios (puede que el archivo esté vacio).");
        }
    }
    @Override
    public void guardarCambios() { // despues de realizar una medificacion no se guardaga los datos en la lista 
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
        for (Gatos gato : getElementos().values()) {
            String linea = String.format("%d,%s,%d,%s,%.2f,%s,%s,%s,%s",
                gato.getId(),
                gato.getNombre(),
                gato.getEdad(),
                gato.getRaza(),
                gato.getPeso(),
                gato.getGenero(),
                gato.getEstirilizacion(),
                gato.getEstado_gato(),
                gato.getCuidado_requerido());
            bw.write(linea);
            bw.newLine();
        }
    } catch (IOException ex) {
        System.out.println("Error al guardar cambios en el archivo.");
        }
    }


    @Override
    public boolean registrar(Gatos gatos) {
        if (getElementos().containsKey(String.valueOf(gatos.getId()))) {   //verifica si el map contiene la clave
            System.out.println("ID duplicada! ingrese otro");
            return true;
        }
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
        // Escribir los datos de la persona en el formato correcto
            String linea = String.format("%d,%s,%d,%s,%s,%s,%s,%s,%s",
            gatos.getId(),
            gatos.getNombre(),
            gatos.getEdad(),
            gatos.getRaza(),
            gatos.getPeso(),
            gatos.getGenero(),
            gatos.getEstirilizacion(),
            gatos.getEstado_gato(),
            gatos.getCuidado_requerido());     
        bw.write(linea);
        bw.newLine();
        System.out.println("Usuario agregado correctamente.");

        getElementos().put(String.valueOf(gatos.getId()), gatos);  
        guardarCambios();
            } catch (IOException ex) {
            System.out.println("Error al guardar en usuarios.txt");
        }
    return true;
    }

    @Override
    public Gatos buscar(String identificador) {
        Gatos gato = null;

        // Buscar por ID (clave del HashMap)
        if (getElementos().containsKey(identificador)) {
            gato = getElementos().get(identificador);
        } else {
            // Buscar por nombre
            for (Gatos g : getElementos().values()) {
                if (identificador.equalsIgnoreCase(g.getNombre())) {
                    gato = g;
                    break;
                }
            }
        }
            if (gato!=null){
                System.out.println("\n======= GATOS ENCONTRADO =======");
                System.out.println("Gato #" + gato.getNombre());
                System.out.println("  ID: " + gato.getId());
                System.out.println("  Edad: " + gato.getEdad() + " años");
                System.out.println("  Raza: " + gato.getRaza());
                System.out.println("  Peso: " + gato.getPeso());
                System.out.println("  Genero: " + gato.getGenero());
                System.out.println("  Esterilazacion: " + gato.getEstirilizacion());
                System.out.println("  Estado: " + gato.getEstado_gato());
                System.out.println("  Cuidados requeridos: " + gato.getCuidado_requerido());
                System.out.println("----------------------------------"); 
            }
        return gato;
        }                         
    
    
    
    @Override
    // verificara si un gato existe >:( y si no piña
    public boolean existe(String identificador) {
        boolean resultado=false;
            if (getElementos().containsKey(identificador)){
                resultado= true;
            }else{  
                for (Gatos gato : getElementos().values()) {
                if (identificador.equalsIgnoreCase(gato.getNombre())){
                    resultado= true;
                    }               
                }
            }
            return resultado;
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
        System.out.println("  Peso: " + gato.getPeso());
        System.out.println("  Genero: " + gato.getGenero());
        System.out.println("  Esterilazacion: " + gato.getEstirilizacion());
        System.out.println("  Estado: " + gato.getEstado_gato());
        System.out.println("  Cuidados requeridos: " + gato.getCuidado_requerido());
        System.out.println("-----------------------------------");
        }
    }

    
    // opciones que tenia, usar put() o usar replace()
    // mas segura? replace ya que si la llave no existe, 
    // no aumenta uno y es la indicada ya que esta sera una opcion para SOLO modificar
    // no put() porque si no existe la clave no aumenta nada  (sirve como info pero no para esta parte :()ERROR :(
    @Override
    public void modificar(String gatoModificar, int opcion) {
        Gatos gato = null;
        // Buscar por ID (clave del HashMap)
        if (getElementos().containsKey(gatoModificar)) {
            gato = getElementos().get(gatoModificar);
        } else {
            // Buscar por nombre
            for (Gatos g : getElementos().values()) {
                if (gatoModificar.equalsIgnoreCase(g.getNombre())) {
                    gato = g;
                    break;
                }
            }
        }
        if (gato != null){
                switch (opcion) {
                case 1: 
                    System.out.print("Nuevo nombre: ");
                    String nuevoNombre = lector.LeerString();
                    gato.setNombre(nuevoNombre);
                    break;
                case 2:
                    System.out.print("Nueva edad: ");
                    int nuevaEdad = lector.LeerEntero();
                    gato.setEdad(nuevaEdad);
                    break;
                case 3:
                    System.out.print("Nueva raza: ");
                    String nuevaRaza = lector.LeerString();
                    gato.setRaza(nuevaRaza);
                    break;
                case 4: 
                    System.out.print("Nuevo peso: ");
                    double nuevoPeso = lector.LeerDouble();
                    gato.setPeso(nuevoPeso);
                    break;
                case 5: 
                    System.out.print("¿Está esterilizado? (si/no): ");
                    String nuevaEsterilizacion = lector.LeerString();
                    gato.setEstirilizacion(nuevaEsterilizacion);
                    break;
                case 6: 
                    System.out.print("Nuevo estado: ");
                    String nuevoEstado = lector.LeerString();
                    gato.setEstado_gato(nuevoEstado);
                    break;
                case 7: 
                    System.out.print("Nuevo cuidado requerido: ");
                    String nuevoCuidado = lector.LeerString();
                    gato.setCuidado_requerido(nuevoCuidado);
                    break;
                default: 
                    System.out.println("Opción inválida");                    
                    break;
            }
            // Como se esta modificando el objeto directamente, el Map se actualiza automaticamente
            // porque hay una referencia al mismo objeto
        }
        guardarCambios();
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