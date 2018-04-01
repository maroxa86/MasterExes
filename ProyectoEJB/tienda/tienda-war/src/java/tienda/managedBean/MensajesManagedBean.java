/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.managedBean;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import tienda.dominios.Mensajes;
import tienda.service.MensajesService;

/**
 *
 * @author Xavi
 */
@ManagedBean(name = "mensajes")
@SessionScoped
public class MensajesManagedBean implements Serializable{
    
    @EJB
    private MensajesService mensajesService;
    
    private List<Mensajes> listadoMensajes;
    private Mensajes mensaje;
    
    public boolean existsMensajesPendientes(){
        return mensajesService.existsMensajesPenditenes();
    }
    
    public String bandejaDeEntrada(){
        this.setListadoMensajes(mensajesService.obtenerMensajesPendientes());
        return "bandejaDeEntrada";
    }
    
    public String leerMensaje(String idMensaje){
        this.mensaje = mensajesService.leerMensaje(idMensaje);
        return "leerMensaje";
    }

    public List<Mensajes> getListadoMensajes() {
        return listadoMensajes;
    }

    public void setListadoMensajes(List<Mensajes> listadoMensajes) {
        this.listadoMensajes = listadoMensajes;
    }

    public Mensajes getMensaje() {
        return mensaje;
    }

    public void setMensaje(Mensajes mensaje) {
        this.mensaje = mensaje;
    }
    
    
}
