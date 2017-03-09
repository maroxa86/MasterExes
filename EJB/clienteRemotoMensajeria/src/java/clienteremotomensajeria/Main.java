/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteremotomensajeria;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import mensajeria.MensajeriaSessionRemote;

/**
 *
 * @author Xavi
 */
public class Main {

    @EJB
    private static MensajeriaSessionRemote mensajeriaSession;

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NamingException {
        if(mensajeriaSession == null){
            InitialContext ctx = new InitialContext();
            mensajeriaSession = (MensajeriaSessionRemote) ctx.lookup(mensajeria.MensajeriaSessionRemote.class.getName());
        }
        
        mensajeriaSession.enviarMensaje("Probando");
    }
    
}
