/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.dao;

import java.util.List;
import javax.ejb.Local;
import tienda.dominios.Mensajes;

/**
 *
 * @author Xavi
 */
@Local
public interface MensajesDAO extends GenericDAO<Mensajes, Integer> {

    public long existsMensajesPendientes();

    public List<Mensajes> obtenerMensajesPendientes();
    
}
