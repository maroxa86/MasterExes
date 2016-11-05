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
public class Ejercicio5 {
    public final static double velocidad = 3.5;
    public final static double espacioInicial = 12.3;
    
    public static void main(String[] args) {        
        double tiempo = Double.parseDouble(args[0]);
        
        double distanciaRecorrida = (velocidad * tiempo) + espacioInicial;
        
        System.out.println("La distancia recorrida en " + tiempo + " segundos ha sido de: " + distanciaRecorrida + " metros");
        
      
    }
}
