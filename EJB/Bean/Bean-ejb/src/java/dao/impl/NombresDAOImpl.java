/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.Nombres;
import dao.NombresDAO;

/**
 *
 * @author Xavi
 */
@Stateless
public class NombresDAOImpl implements NombresDAO{

    @PersistenceContext(unitName = "Bean-persistence")
    EntityManager em;
    
    @Override
    public List<Nombres> nombresList() {
        Query consulta = em.createQuery("select n from Nombres n");
        List<Nombres> listadoNombres = (List<Nombres>)consulta.getResultList();
        return listadoNombres;
    }

    @Override
    public void saveNombres(Nombres nombre) {
        em.merge(nombre);
    }

    @Override
    public Nombres getNombres(long idNombre) {
        Nombres nombre = em.find(Nombres.class, idNombre);
        return nombre;
    }

    @Override
    public void deleteNombres(Nombres nombre) {
        Nombres nombreBorrar = em.merge(nombre);
        em.remove(nombreBorrar);
    }
    
}
