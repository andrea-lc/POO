/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestores;

import Entidades.Adoptantes;
import Entidades.Gatos;
import Entidades.Voluntarios;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author admin
 * @param <T>
 */
public abstract class GestorBase <T> implements GestorInterface<T> {
    protected Map<String, T> elementos = new HashMap<>();
    protected List<T> elementos_lista= new ArrayList<>(elementos.values());
    protected final String rutaArchivo;
    
    
    public GestorBase(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
        cargarDatos();
    }
    
    public Map<String, T> getElementos() {
        return elementos;
    }
    
    public List<T> getElementos_lista() {
        return elementos_lista;
    }
    
    public T retornarElemento(String identificador){
        T objeto = null;
        if(getElementos().containsKey(identificador)){ //busca por id o dni :0
            objeto=getElementos().get(identificador);
        }else {
            for (T o : getElementos().values()) { // busca por nombre 
            String nombre = null;
            //para verificar si objeto es una instancia de Gatos/Adoptantes/Voluntarios 
            // (como examinar de que tipo sera objeto)
                if (o instanceof Gatos){ 
                    nombre= (((Gatos) o).getNombre()); // aqui hace cast, osea convertir un objeto a otro
                } else if (o instanceof Adoptantes ){
                    nombre= ((Adoptantes) o).getNombre();
                } else if (o instanceof Voluntarios){
                    nombre=((Voluntarios) o).getNombre();
                }          
                if (identificador.equalsIgnoreCase(nombre)){
                    objeto=o;
                }
            }       
        }
        return objeto;
    }
}
