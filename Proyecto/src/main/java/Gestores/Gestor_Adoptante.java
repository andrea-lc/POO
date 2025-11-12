/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestores;

import Entidades.Adoptantes;
import Entidades.Persona;
import Scanner.Lector;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.function.Consumer;

/**
 *
 * @author admin
 */
public class Gestor_Adoptante extends GestorBase<Adoptantes>{
    Lector lector=new Lector ();

    public Gestor_Adoptante() {
        super("Adoptantes.txt");
    }
 
    @Override
    public void cargarDatos() {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");              
                if (datos.length == 5) {
                    int dni = Integer.parseInt(datos[0]);
                    String nombre = datos[1];
                    int telefono = Integer.parseInt(datos[2]);
                    String correo = datos[3];
                    int gato_Adoptado = Integer.parseInt(datos[4]);
                    
                    Persona persona= new Persona(dni,nombre,telefono,correo);
                    
                    getElementos().put(String.valueOf(dni), 
                            new Adoptantes(persona, gato_Adoptado));
                }
            }
        } catch (IOException e) {
            System.out.println("No se pudo cargar usuarios (puede que el archivo esté vacio).");
        }
    }

    @Override
    public void guardarCambios() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (Adoptantes adoptante : getElementos().values()) {
                String linea = String.format("%d,%s,%d,%s,%d",
                    adoptante.getId_persona(),
                    adoptante.getNombre(),
                    adoptante.getTelefono(),
                    adoptante.getCorreo(),
                    adoptante.getGato_Adoptado());
                bw.write(linea);
                bw.newLine();
            }
        } catch (IOException ex) {
            System.out.println("Error al guardar cambios en el archivo de adoptantes.");
        }
    }

    @Override
    public boolean registrar(Adoptantes adoptante) {        
        if (getElementos().containsKey(String.valueOf(adoptante.getId_persona()))) {
            System.out.println("Este DNI ya esta registrado como adoptante.");
            return false;
        }
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
            String linea = String.format("%d,%s,%d,%s,%d",
                adoptante.getId_persona(), 
                adoptante.getNombre(),
                adoptante.getTelefono(),
                adoptante.getCorreo(),
                adoptante.getGato_Adoptado());                  
            bw.write(linea);
            bw.newLine();
            
            getElementos().put((String.valueOf(adoptante.getId_persona())), adoptante);
            getElementos_lista().add(adoptante);
            
            System.out.println("Adoptante registrado correctamente.");
            return true;
        } catch (IOException ex) {
            System.out.println("Error al guardar en Adoptantes.txt");
            return false;
        }
    }

    @Override
    public boolean existe(String identificador) {
        boolean resultado=false;
            if (getElementos().containsKey(identificador)){
                resultado= true;
            }else{  
                for (Adoptantes adoptante: getElementos().values()) {
                if (identificador.equalsIgnoreCase(adoptante.getNombre())){
                    resultado= true;
                    }               
                }
            }
            return resultado;
    }

    @Override
    public void mostrar() {
        if (getElementos().isEmpty()) {
            System.out.println("No hay adoptantes registrados en el sistema.");
            return;
        }  
        
        System.out.println("\n=== LISTA DE ADOPTANTES REGISTRADOS ===");
        System.out.println("Total de adoptantes: " + getElementos().size());
        System.out.println("----------------------------------------");
        
        getElementos_lista().sort((a1, a2) -> Integer.compare(a1.getId_persona(), a2.getId_persona()));
        getElementos_lista().forEach(System.out::println);
        System.out.println("----------------------------------------");        

    }

    @Override
    public void modificar(String datoModificar, int opcion) {
        Adoptantes adoptante = null;
        // Buscar por ID (clave del HashMap)
        if (getElementos().containsKey(datoModificar)) {
            adoptante = getElementos().get(datoModificar);
        } else {
            // Buscar por nombre
            for (Adoptantes a : getElementos().values()) {
                if (datoModificar.equalsIgnoreCase(a.getNombre())) {
                    adoptante = a;
                    break;
                }
            }
        }
        Consumer <Adoptantes> [] modificador= new Consumer[4];
        if (adoptante != null){
            modificador[1]= (a) ->{ System.out.print("Nuevo telefono: "); 
                                    a.setTelefono(lector.LeerEntero());};
            modificador[2]= (a)->{ System.out.print("Nuevo correo: ");
                                    a.setCorreo(lector.LeerString());};        
            }  
        modificador[opcion].accept(adoptante);
        guardarCambios();
    } 
        
    @Override
    public Adoptantes buscar(String identificador) {
        Adoptantes adoptante = null;

        // Buscar por DNI (clave del HashMap)
        if (getElementos().containsKey(identificador)) {
            adoptante = getElementos().get(identificador);
        } else {
            // Buscar por nombre o correo
            for (Adoptantes a : getElementos().values()) {
                if (identificador.equalsIgnoreCase(a.getNombre()) || 
                    identificador.equalsIgnoreCase(a.getCorreo())) {
                    adoptante = a;
                    break;
                }
            }
        }
        if (adoptante !=null){
            System.out.println(adoptante);
        }
        return adoptante;
    }     
}   