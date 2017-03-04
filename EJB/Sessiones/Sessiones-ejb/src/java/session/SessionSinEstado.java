/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import javax.ejb.Stateless;

/**
 *
 * @author Xavi
 */
@Stateless
public class SessionSinEstado implements SessionSinEstadoRemote, SessionSinEstadoLocal {
    private int valor;

    @Override
    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public int getValor() {
        return valor;
    }

    
}
