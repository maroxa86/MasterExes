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
public class Ejercicio12 {
    
    public static void main(String[] args){
        
        Circulo circulo = new Circulo(2.0,3.5,4);
        
        System.out.println("El Area del ciculo de radio " + circulo.getRadio() + " = " + circulo.calcularArea());
        System.out.println("El Perimetro del ciculo de radio " + circulo.getRadio() + " = " + circulo.calcularPermitro());
    }
}
