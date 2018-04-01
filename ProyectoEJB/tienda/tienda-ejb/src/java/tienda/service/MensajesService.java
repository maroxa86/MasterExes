/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.service;

import java.util.List;
import javax.ejb.Local;
import tienda.dominios.Mensajes;

/**
 *
 * @author Xavi
 */
@Local
public interface MensajesService {
    void insertarMensajes(Mensajes mensaje);
    boolean existsMensajesPenditenes();
    List<Mensajes> obtenerMensajesPendientes();
    Mensajes leerMensaje(String idMensaje);
}
