/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poosemana7;

/**
 *
 * @author admin
 */
public class POOsemana7 {

    public static void main(String[] args) {
        // Crear personas de prueba
        Persona persona1 = new Persona(12345678, "Juan Pérez", 123456789, "Calle 123", "juan@email.com") {
            @Override
            public String getTipoPersona() { return "Persona"; }
        };
        
        Persona persona2 = new Persona(87654321, "María García", 987654321, "Avenida 456", "maria@email.com") {
            @Override
            public String getTipoPersona() { return "Persona"; }
        };

        // Agregar al gestor
        Gestor.agregarPersona(persona1);
        Gestor.agregarPersona(persona2);

        // Crear adoptante y voluntario
        GestorAdoptante.agregarAdoptante(12345678, "2024-01-15", "Adoptó un gato");
        GestorVoluntarios.agregarVoluntario(87654321, "2024-01-10", "Cuidado animal", 8);

        // Probar búsquedas
        System.out.println("=== PRUEBAS DEL SISTEMA ===\n");

        // Buscar persona
        Persona p = Gestor.buscarPersona(12345678);
        System.out.println("Persona encontrada: " + p.getInformacionCompleta());

        // Buscar adoptante
        Adoptantes a = GestorAdoptante.buscarAdoptante(12345678);
        System.out.println("Adoptante: " + a.getInformacionCompleta());

        // Buscar voluntario
        Voluntario v = GestorVoluntarios.buscarVoluntario(87654321);
        System.out.println("Voluntario: " + v.getInformacionCompleta());

        System.out.println("\n¡Prueba completada!");
    }
}


