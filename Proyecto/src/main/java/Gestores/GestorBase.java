/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestores;

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
}
