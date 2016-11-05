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
public class Ejercicio16 {
    public static void main(String[] args){
        
        for(int i = 1; i < 10; i++){
            System.out.print("La serie de fibonacci del valor: " + i + " es: ");
            int aux;
            int anterior = 0;
            int actual = 1;
            for(int j = 0; j < i; j++){
                aux = actual;
                actual = actual + anterior;
                anterior = aux;
                System.out.print(actual + " ");
            }
            System.out.println();
        }
    }
}
