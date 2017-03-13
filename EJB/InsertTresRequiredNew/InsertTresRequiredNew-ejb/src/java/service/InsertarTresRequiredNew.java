/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.InsertarTresDAO;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import modelo.InsertarTres;

/**
 *
 * @author Xavi
 */
@Stateless
public class InsertarTresRequiredNew implements InsertarTresRequiredNewRemote {

    @EJB
    private InsertarTresDAO insertarTresDAOImpl;

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void insertTresEnteros(int primerEntero, int segundoEntero, int tercerEntero) {
        insertarTresDAOImpl.insertar(primerEntero);
        insertarTresDAOImpl.insertar(segundoEntero);
        insertarTresDAOImpl.insertar(tercerEntero);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void insertarEntero(int entero) {
        insertarTresDAOImpl.insertar(entero);
    }

    
    
}
