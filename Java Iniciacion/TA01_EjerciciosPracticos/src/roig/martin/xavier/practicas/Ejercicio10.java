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
public class Ejercicio10 {
    private static Lampara lampara; 
    
    public static void main(String[] args){
        System.out.println("Enchufamos la lampara a la corriente");
        lampara = new Lampara();
        System.out.println("La lampara esta: " + lampara.estadoLampara());
        System.out.println("Encendemos la lampara");
        lampara.encenderLampara();
        System.out.println("La lampara esta: " + lampara.estadoLampara());
        System.out.println("Apagamos la lampara");
        lampara.apagarLampara();
        System.out.println("La lampara esta: " + lampara.estadoLampara());
    }
}
