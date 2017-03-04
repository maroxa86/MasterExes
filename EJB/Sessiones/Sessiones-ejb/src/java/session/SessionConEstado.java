/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import javax.ejb.Stateful;

/**
 *
 * @author Xavi
 */
@Stateful
public class SessionConEstado implements SessionConEstadoRemote, SessionConEstadoLocal {
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
