/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mensajeria;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

/**
 *
 * @author Xavi
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/myqueue")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class ReceptorMensajeBean implements MessageListener {
    
    public ReceptorMensajeBean() {
    }
    
    @Override
    public void onMessage(Message message) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(new File("fichero.txt")));){
            TextMessage tmg = (TextMessage) message;
            System.out.println(tmg.getText());
            pw.println(tmg.getText());           
        } catch (JMSException | IOException ex) {
            Logger.getLogger(ReceptorMensajeBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
