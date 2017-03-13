/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import javax.ejb.Remote;

/**
 *
 * @author Xavi
 */
@Remote
public interface InsetarTresServiceRemote {

    void insertarTres(int primerEntero, int segundoEntero, int tercerEntero);

    void insertar(int entero);
    
}
