/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roig.martin.xavier.practicas;

/**
 *
 * @author Xavi
 */
public class Ejercicio3 {
    public static void main(String[] args){
        int anyo = Integer.parseInt(args[0]);
        
        if(anyo % 4 == 0 && (anyo % 100 == 0 && anyo % 400 != 0)){
            System.out.println("Es año bisiesto");
        }
        else{
            System.out.println("No es año bisisto");
        }
    }
}
