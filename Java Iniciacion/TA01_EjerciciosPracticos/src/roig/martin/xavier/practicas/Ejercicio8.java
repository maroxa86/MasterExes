package roig.martin.xavier.practicas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Xavi
 */
public class Ejercicio8 {
    public static void main(String[] args){
        String var1 = "Hola";
        String var2 = "Hola";
        
        if(var1.equals(var2)){
            System.out.println("Son inguales");
        }
        else{
            System.out.println("No son iguales");
        }
        
        System.out.println("La longitud de la primera cadena es: " + var1.length());
        System.out.println("La longitud de la segunda cadena es: " + var2.length());
       
        String var3 = var1.concat(var2);
        
        
        System.out.println("La longitud de la suma de las cadenas es: " + var3.length());
        
        System.out.println("El literal de la suma de las cadenas en mayusculas es:" + var3.toUpperCase());
        
        if(var3.contains("Prueba")){
            System.out.println("La cadena contine el texto Prueba y esta en la posición: " + var3.indexOf("Prueba"));
        }
        else{
            System.out.println("La cadena no contiene la cadena Prueba");
        }
    }
}
