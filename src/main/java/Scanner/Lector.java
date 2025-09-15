/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Scanner;

import java.util.InputMismatchException;

/**
 *
 * @author admin
 */
public class Lector {
    private final java.util.Scanner scanner = new java.util.Scanner (System.in);
    
    public int LeerEntero (){
        while (true){
            try {
                return scanner.nextInt();
                
            }catch (InputMismatchException e){
                System.out.println("Ingrese un numero valido: ");
                scanner.nextLine();
            }
        }
    }
    public String LeerString () {
     while (true){
         String salida=scanner.nextLine();
            if (!salida.isEmpty()){
              return salida.trim();
            } else {
                System.out.println("Ingrese un dato valido: ");
            }
        }
    }
}
