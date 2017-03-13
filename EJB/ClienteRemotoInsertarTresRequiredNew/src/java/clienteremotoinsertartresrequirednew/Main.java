/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteremotoinsertartresrequirednew;

import javax.ejb.EJB;
import service.InsertarTresRequiredNewRemote;

/**
 *
 * @author Xavi
 */
public class Main {

    @EJB
    private static InsertarTresRequiredNewRemote insertarTresRequiredNew;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Se insertan los valores 3,4 y 3");
        insertarTresRequiredNew.insertTresEnteros(3, 4, 3);
    }
    
}
