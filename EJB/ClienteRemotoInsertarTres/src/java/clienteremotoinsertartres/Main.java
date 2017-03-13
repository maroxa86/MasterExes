/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteremotoinsertartres;

import javax.ejb.EJB;
import service.InsetarTresServiceRemote;

/**
 *
 * @author Xavi
 */
public class Main {

    @EJB
    private static InsetarTresServiceRemote insetarTresServiceImpl;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      System.out.println("Se insertar los valores 3, 4 y 3");
      insetarTresServiceImpl.insertarTres(3, 4, 3);
    }
    
}
