/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clenteremotousuarios;

import com.sun.enterprise.security.ee.auth.login.ProgrammaticLogin;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import sessions.MetodoExternoSessionRemote;

/**
 *
 * @author Xavi
 */
public class ClenteRemotoUsuarios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NamingException {
        
File auth = new File("auth.conf");
        FileWriter fw;
        try {
            fw = new FileWriter(auth);

            fw.write("default {\ncom.sun.enterprise.security.auth.login.ClientPasswordLoginModule required debug=false; \n};");
            fw.flush();
            fw.close();
            System.setProperty("java.security.auth.login.config", "auth.conf");

        } catch (IOException ex) {
            Logger.getLogger(MetodoExternoSessionRemote.class.getName()).log(Level.SEVERE, null, ex);
        }
        String usuario = "usuarioIncorecto";
        String password = "1";
        Properties props = new Properties();
        props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
        props.setProperty(Context.URL_PKG_PREFIXES, "com.sun.enterprise.naming");
        props.setProperty(Context.STATE_FACTORIES, "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
        props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
        props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");

        ProgrammaticLogin pl = new ProgrammaticLogin();
        boolean loginSuccess = pl.login(usuario, password.toCharArray());
        
        InitialContext ic;
        try {
            ic = new InitialContext(props);
            MetodoExternoSessionRemote bean = (MetodoExternoSessionRemote) ic.lookup("java:global/Usuarios/Usuarios-ejb/MetodoExternoSession!sessions.MetodoExternoSessionRemote");
            bean.metodoExterno(usuario);

        } catch (NamingException ex) {
            Logger.getLogger(MetodoExternoSessionRemote.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
