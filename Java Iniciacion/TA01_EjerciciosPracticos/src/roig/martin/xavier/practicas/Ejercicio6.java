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
public class Ejercicio6 {
    public final static int CILINDROS = 12020;
    public final static int PISTAS = 16;
    public final static int SECTORES = 8;
    public final static int CAPACIDAD_SECTORES = 512;
    
    public static void main(String[] args) {
        
        double capacidad = CILINDROS * PISTAS * SECTORES * CAPACIDAD_SECTORES;
        
        System.out.println("La capadidad del disco en bytes es de: " + capacidad);
        System.out.println("La capadidad del disco en kilobytes es de: " + capacidad / 1024);
        System.out.println("La capadidad del disco en megabytes es de: " + capacidad / 1024 / 1024);
        System.out.println("La capadidad del disco en gigabytes es de: " + capacidad / 1024 / 1024 / 1024);
        
        
    }
}
