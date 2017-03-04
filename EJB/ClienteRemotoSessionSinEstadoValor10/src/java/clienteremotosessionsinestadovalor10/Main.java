/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteremotosessionsinestadovalor10;

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
        System.out.println("El valor a insertar en la session es: " + 10);
        sessionSinEstado.setValor(10);
        System.out.println("El recuperado de la session es: " + sessionSinEstado.getValor());
    }
    
}
