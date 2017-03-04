/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteremotosessionsinestadovalor20;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import session.SessionSinEstadoRemote;

/**
 *
 * @author Xavi
 */
public class Main {

    @EJB
    private static SessionSinEstadoRemote sessionSinEstado;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            System.out.println("El valor a insertar en la session es: " + 20);
            sessionSinEstado.setValor(20);
            Thread.sleep(60000);
            System.out.println("El recuperado de la session es: " + sessionSinEstado.getValor());
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
