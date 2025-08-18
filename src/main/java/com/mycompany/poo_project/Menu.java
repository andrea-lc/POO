/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo_project;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Menu {
    private final Scanner scanner = new Scanner(System.in);

    public void mostrar() {
        int opcion;
        do {
            System.out.println("""
                               ========== Cat Haven ==========
                               1) Gestión de gatos
                               2) Gestión de clientes
                               3) Adopciones
                               4) Reportes
                               0) Cerrar sesión
                               ===============================
                               """);
            System.out.print("Elige una opción: ");
            opcion = leerEntero();

            switch (opcion) {
                case 1 -> System.out.println("Aquí irá el módulo de gatos...");
                case 2 -> System.out.println("Aquí irá el módulo de clientes...");
                case 3 -> System.out.println("Aquí irá el módulo de adopciones...");
                case 4 -> System.out.println("Aquí irá el módulo de reportes...");
                case 0 -> System.out.println("Cerrando sesión...");
                default -> System.out.println("pción inválida.");
            }
        } while (opcion != 0);
    }

    private int leerEntero() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Ingresa un número válido: ");
            }
        }
    }
}

