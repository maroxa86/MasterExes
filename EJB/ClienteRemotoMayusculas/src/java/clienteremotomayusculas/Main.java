/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteremotomayusculas;

import javax.ejb.EJB;
import mayusculas.MayusculasRemote;

/**
 *
 * @author Xavi
 */
public class Main {

    @EJB
    private static MayusculasRemote mayusculas;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(mayusculas.cadenaMayusculas("Cadena en Mayusculas"));
    }
    
}
