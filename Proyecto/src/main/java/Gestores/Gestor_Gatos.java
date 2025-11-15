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
import java.util.function.Consumer;

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
                    getElementos_lista().add(gato);
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
                gato.getEsterilizacion(),
                gato.getEstado_gato(),
                gato.getCuidado_requerido());
            bw.write(linea);
            bw.newLine();
            getElementos_lista().add(gato);

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
            String linea = String.format("%d,%s,%d,%s,%.2f,%s,%s,%s,%s",
            gatos.getId(),
            gatos.getNombre(),
            gatos.getEdad(),
            gatos.getRaza(),
            gatos.getPeso(),
            gatos.getGenero(),
            gatos.getEsterilizacion(),
            gatos.getEstado_gato(),
            gatos.getCuidado_requerido());     
        bw.write(linea);
        bw.newLine();
        System.out.println("Usuario agregado correctamente.");

        getElementos().put(String.valueOf(gatos.getId()), gatos);
        getElementos_lista().add(gatos);

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
                System.out.println(gato);
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
        getElementos_lista().sort((g1,g2)->Integer.compare(g1.getId(), g2.getId()));
        
        getElementos_lista().forEach(System.out::println);
        System.out.println("-----------------------------------");        
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
        Consumer <Gatos> [] modificador= new Consumer[7];
        if (gato != null){
            modificador[0]= g -> { System.out.print("Nuevo nombre: ");
                                        g.setNombre(lector.LeerString()); };
            modificador[1]= g -> { System.out.print("Nueva edad: ");
                                         g.setEdad(lector.LeerEntero());};                                      
            modificador[2]= g -> { System.out.print("Nueva raza: ");
                                         g.setRaza(lector.LeerString());};
            modificador[3]= g -> {System.out.print("Nuevo peso: ");                   
                                         g.setPeso(lector.LeerDouble());};
            modificador [4]= g-> {System.out.print("Esta esterilizado? (si/no): ");
                                         g.setEsterilizacion(lector.LeerString());};
            modificador[5]= g-> {System.out.print("Nuevo estado: ");                 
                                         g.setEstado_gato(lector.LeerString());};
            modificador [6]= g-> {System.out.print("Nuevo cuidado requerido: ");
                                         g.setCuidado_requerido(lector.LeerString());};
            // Como se esta modificando el objeto directamente, el Map se actualiza automaticamente
            // porque hay una referencia al mismo objeto
        }
        modificador[opcion].accept(gato);
        guardarCambios();
    }
    
    //METODOS PARA LA CLASE ACCION ADOPTANTES 
    // esta clase es para mostrar los gatos en adopcion, para usarla en acciones_adoptantes 
        public void mostrarGatos() {
            
            if (getElementos().isEmpty()) {
            System.out.println("No hay gatos registrados en el sistema.");
            return;            
        }  
            List<Gatos> Gatos_enAdopcion= new ArrayList<>();  
            for (Gatos gato: getElementos_lista()){
                if (gato.getEstado_gato().equalsIgnoreCase("En adopcion"))
                    Gatos_enAdopcion.add(gato);
            }

            System.out.println("\n=== LISTA DE GATOS REGISTRADOS ===");
            System.out.println("Total de gatos en adopcion: " + Gatos_enAdopcion.size());
            System.out.println("-----------------------------------");

            Gatos_enAdopcion.sort((g1,g2) -> Integer.compare(g1.getId(), g2.getId()));
            Gatos_enAdopcion.forEach(gato -> System.out.println("Id: "+ gato.getId()+"  Nombre: "+ gato.getNombre()));       
            System.out.println("-----------------------------------");        
        }
        
        //antes tenia una clase que cambia el estado del gato pero s
        //pero es mejor hacerlo defrente al conseguir el id
        //porque al adoptar un gato, se sabe automaticamente que su estado debe cambiar
        public int conseguirID (String nombre){
            Gatos gato = null;   
            try{ 
            
         // Buscar por nombre
            for (Gatos g : getElementos().values()) {
                if (nombre.equalsIgnoreCase(g.getNombre())) {
                    gato = g;
                    break;
                }
            } 
            Consumer <Gatos> realizarCambio = a -> { a.setEstado_gato("Adoptado");};
                realizarCambio.accept(gato); 
                guardarCambios();
                        }catch (NullPointerException e){
                System.out.println("Gatito1"
                        + " no registrado como en adopcion ");
            } 
        return gato.getId();  
    }
}