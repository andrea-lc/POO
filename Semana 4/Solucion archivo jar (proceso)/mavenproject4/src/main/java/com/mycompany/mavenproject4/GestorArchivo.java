/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;

/**
 *
 * @author admin
 */
class GestorArchivo {
   private File archivo;

    // Constructor vacío: se pedirá al usuario seleccionar archivo con JFileChooser
    public GestorArchivo() {
        this.archivo = null;
    }

    // Método para seleccionar archivo (guardar o abrir)
    private void seleccionarArchivo(boolean guardar) {
        JFileChooser chooser = new JFileChooser();
        int opcion;

        if (guardar) {
            opcion = chooser.showSaveDialog(null); // para guardar
        } else {
            opcion = chooser.showOpenDialog(null); // para abrir
        }

        if (opcion == JFileChooser.APPROVE_OPTION) {
            archivo = chooser.getSelectedFile();
        }
    }

    // Método para guardar información
    public void guardarLinea(String texto) {
        if (archivo == null) {
            seleccionarArchivo(true); // si no hay archivo, pedir ruta
        }
        if (archivo != null) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true))) {
                bw.write(texto);
                bw.newLine();
                System.out.println("Texto guardado en: " + archivo.getAbsolutePath());
            } catch (IOException e) {
                System.out.println("Error al guardar en el archivo: " + e.getMessage());
            }
        }
    }

    // Método para leer todo el archivo
    public List<String> leerArchivo() {
        List<String> lineas = new ArrayList<>();
        if (archivo == null) {
            seleccionarArchivo(false); // si no hay archivo, pedir ruta
        }
        if (archivo != null && archivo.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    lineas.add(linea);
                }
            } catch (IOException e) {
                System.out.println("Error al leer el archivo: " + e.getMessage());
            }
        }
        return lineas;
    }
}


