/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.dao.impl;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import tienda.dao.MensajesDAO;
import tienda.dominios.Factura;
import tienda.dominios.Mensajes;

/**
 *
 * @author Xavi
 */
@Stateless
public class MensajesDAOImpl extends AbstractGenericDAOImpl<Mensajes, Integer> implements MensajesDAO{

    @Override
    public long existsMensajesPendientes() {
        //TypedQuery<Mensajes> consulta = getManager().createNamedQuery("existsMensajesPendientes", Mensajes.class);
        Query consulta = getManager().createQuery("SELECT count(mensajes.id) FROM Mensajes mensajes where mensajes.leido = 0");
        return (Long)consulta.getSingleResult();
    }

    @Override
    public List<Mensajes> obtenerMensajesPendientes() {
        TypedQuery<Mensajes> consulta = getManager().createNamedQuery("listadoMensajesPendientes", Mensajes.class);
        return consulta.getResultList();
    }
    
}
