/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.semana8;

/**
 *
 * @author admin
 */
public class Semana8 {

    public static void main(String[] args) {
        System.out.println("=== PRUEBA HERENCIA MULTIPLE ===\n");
        
        // Crear gatos
        Gatos gato1 = new Gatos(1, "Luna", 2, "Siames", "en adopcion", "ninguno");
        Gatos gato2 = new Gatos(2, "Simon", 5, "Persa", "en recuperacion", "dieta especial");
        Adoptante adoptante = new Adoptante ("Andrea", 19);
        
             
        System.out.println("=== ADOPTANTE 1 ===");
        // aqui usara el metodo default de Identificador para mostrar su numero de identidad
        System.out.print("\nN° de identificacion: ");
        adoptante.mostrarIdentificador();
                
                
        System.out.println("=== GATO 1 ===");
        // aqui mostrara el id del gato ya escrito en la instancia ya que el metodo mostrarIdentificacion esta sobreescrito
        System.out.print("\nN° de identificacion: ");
        gato1.mostrarIdentificador();
        System.out.println(gato1);
        
        // Usar mRtodos de ICuidados
        System.out.println("\n--- CUIDADOS ---");
        System.out.println("Necesita vacunas? " + (gato1.necesitaVacunas() ? "SI" : "NO"));
        gato1.aplicarVacunas();
        System.out.println("Estado salud: " + gato1.getEstadoSalud());
        
        // Usar mEtodos de IAdopcion
        System.out.println("\n--- ADOPCION ---");
        System.out.println("Es adoptable? " + (gato1.esAdoptable() ? "SI" : "NO"));
        System.out.println(gato1.getInformacionAdopcion());
        
        if (gato1.esAdoptable()) {
            gato1.marcarComoAdoptado();
        }
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        System.out.println("=== GATO 2 ===");
        System.out.println(gato2);
        
        // Usar métodos de ICuidados
        System.out.println("\n--- CUIDADOS ---");
        System.out.println("Necesita vacunas? " + (gato2.necesitaVacunas() ? "SI" : "NO"));
        gato2.aplicarTratamiento("control mensual");
        System.out.println("Estado salud: " + gato2.getEstadoSalud());
        
        // Usar metodos de IAdopcion
        System.out.println("\n--- ADOPCION ---");
        System.out.println("Es adoptable? " + (gato2.esAdoptable() ? "SI" : "NO"));
        System.out.println(gato2.getInformacionAdopcion());
        
        // Probar polimorfismo
        System.out.println("\n" + "=".repeat(50));
        System.out.println("=== POLIMORFISMO ===");
        
        // Podemos tratar al gato como ICuidados
        ICuidados gatoComoCuidados = gato1;
        System.out.println("Como ICuidados: " + gatoComoCuidados.getEstadoSalud());
        
        // O como IAdopcion
        IAdopcion gatoComoAdopcion = gato1;
        System.out.println("Como IAdopcion: " + gatoComoAdopcion.getInformacionAdopcion());
    }
}
