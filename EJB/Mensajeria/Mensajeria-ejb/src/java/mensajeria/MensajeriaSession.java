/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mensajeria;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;

/**
 *
 * @author Xavi
 */
@Stateless
public class MensajeriaSession implements MensajeriaSessionRemote {

    @Resource(mappedName = "jms/myqueue")
    private Queue myqueue;

    @Inject
    @JMSConnectionFactory("java:comp/DefaultJMSConnectionFactory")
    private JMSContext context;

    
//    @Resource(name="jms/myqueue")
//    private Queue queueReceptor;
//    
//    @Resource(name="jms/myqueueFactory")
//    private ConnectionFactory queueReceptorFactory;
    
    @Override
    public void enviarMensaje(Serializable objeto) {
        sendJMSMessageToMyqueue("Probando");
    }

    private Message createJMSMessageForjmsQueueReceptor(Session session, Serializable objeto) throws JMSException {
        ObjectMessage tm = session.createObjectMessage();
        tm.setObject(objeto);
        return tm;
    }

    private void sendJMSMessageToMyqueue(String messageData) {
        context.createProducer().send(myqueue, messageData);
    }

}
