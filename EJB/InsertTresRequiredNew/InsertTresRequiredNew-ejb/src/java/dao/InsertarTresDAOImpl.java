/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.InsertarTres;

/**
 *
 * @author Xavi
 */
@Stateless
public class InsertarTresDAOImpl implements InsertarTresDAO {

    @PersistenceContext(unitName = "InsertarTres-persistence")
    EntityManager em;

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void insertar(int entero) {
        InsertarTres insertar = new InsertarTres(entero);
        em.persist(insertar);
    }

    
}
