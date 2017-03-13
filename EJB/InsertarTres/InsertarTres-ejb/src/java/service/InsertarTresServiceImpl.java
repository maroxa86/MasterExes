/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.InsertarTresDAO;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.InsertarTres;

/**
 *
 * @author Xavi
 */
@Stateless
public class InsertarTresServiceImpl implements InsetarTresServiceRemote, InsertarTresServiceLocal {

    @EJB
    private InsertarTresDAO insertarTresDAO;

    @Override
    public void insertarTres(int primerEntero, int segundoEntero, int tercerEntero) {
        insertarTresDAO.insertarTres(new InsertarTres(primerEntero), new InsertarTres(segundoEntero), new InsertarTres(tercerEntero));
    }

    @Override
    public void insertar(int entero) {
        insertarTresDAO.insertar(new InsertarTres(entero));
    }

    
}
