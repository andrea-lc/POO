/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject4;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Mavenproject4 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        GestorArchivo gestor = new GestorArchivo(); // archivo donde guardará
        int opcion;
        do{
        System.out.println("1. Guardar texto");
        System.out.println("2. Leer archivo");
        System.out.println("3. Salir");
        opcion = sc.nextInt();
        sc.nextLine(); // limpiar buffer
        switch (opcion) {
            case 1:
                System.out.print("Ingrese el texto a guardar: ");
                String texto = sc.nextLine();
                gestor.guardarLinea(texto);
                break;
            case 2:
                List<String> lineas = gestor.leerArchivo();
                if (lineas.isEmpty()) {
                    System.out.println("El archivo está vacío o no se pudo leer.");
                } else {
                    System.out.println("Contenido del archivo:");
                    for (String linea : lineas) {
                        System.out.println(linea);
                    }
                }
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
       }while (opcion!=3); 
    }
}
 
   
