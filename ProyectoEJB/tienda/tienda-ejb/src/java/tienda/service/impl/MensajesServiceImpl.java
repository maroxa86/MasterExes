/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.service.impl;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import tienda.dao.MensajesDAO;
import tienda.dominios.Mensajes;
import tienda.service.MensajesService;

/**
 *
 * @author Xavi
 */
@Stateless
public class MensajesServiceImpl implements MensajesService{

    @EJB
    private MensajesDAO mensajesDAO;
    
    @Override
    public void insertarMensajes(Mensajes mensaje) {
        mensajesDAO.insertar(mensaje);
    }

    @Override
    public boolean existsMensajesPenditenes() {
        long mensajesPendites = mensajesDAO.existsMensajesPendientes();
        return mensajesPendites > 0;
    }

    @Override
    public List<Mensajes> obtenerMensajesPendientes() {
        return mensajesDAO.obtenerMensajesPendientes();
    }

    @Override
    public Mensajes leerMensaje(String idMensaje) {
        Mensajes mensaje = mensajesDAO.buscarPorClave(Integer.parseInt(idMensaje));
        mensaje.setLeido(new Short("1"));
        mensajesDAO.salvar(mensaje);
        return mensaje;
    }
    
}
