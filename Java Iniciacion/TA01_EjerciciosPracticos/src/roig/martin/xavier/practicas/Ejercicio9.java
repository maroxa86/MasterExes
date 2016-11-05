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
public class Ejercicio9 {
    
    public static void main(String[] args){
        boolean var1 = false;
        boolean var2 = false;
        
        System.out.println("Tabla verdad AND");
        System.out.println("var1: " + var1 + " var2: " + var2 + " resultado: " + (var1 & var2));
        System.out.println("var1: " + !var1 + " var2: " + var2 + " resultado: " + (!var1 & var2));
        System.out.println("var1: " + var1 + " var2: " + !var2 + " resultado: " + (var1 & !var2));
        System.out.println("var1: " + !var1 + " var2: " + !var2 + " resultado: " + (!var1 & !var2));
        
        
        System.out.println("Tabla verdad OR");
        System.out.println("var1: " + var1 + " var2: " + var2 + " resultado: " + (var1 | var2));
        System.out.println("var1: " + !var1 + " var2: " + var2 + " resultado: " + (!var1 | var2));
        System.out.println("var1: " + var1 + " var2: " + !var2 + " resultado: " + (var1 | !var2));
        System.out.println("var1: " + !var1 + " var2: " + !var2 + " resultado: " + (!var1 | !var2));
        
         
    }
}
