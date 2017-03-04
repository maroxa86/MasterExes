/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteremotoservletsinsesionvalor10;

import javax.ejb.EJB;
import session.SessionConEstadoRemote;

/**
 *
 * @author Xavi
 */
public class Main {

    @EJB
    private static SessionConEstadoRemote sessionConEstado;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("El valor a insertar en la session es: " + 10);
        sessionConEstado.setValor(10);
        System.out.println("El recuperado de la session es: " + sessionConEstado.getValor());
    }
    
}
