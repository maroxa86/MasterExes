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
public class Ejercicio4 {
    public static void main(String[] args){
        int valor = 77;
        valor = valor / 10;
        valor = valor * 10;
        
        System.out.println("El valor resultado es = " + valor);
        
        valor = 77;
        valor = (int) (valor * 10.0f);
        valor = (int) (valor / 10.0f);
        
        System.out.println("El valor resultado es = " + valor);
    }
}
