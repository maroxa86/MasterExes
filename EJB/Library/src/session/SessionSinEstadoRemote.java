/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import javax.ejb.Remote;

/**
 *
 * @author Xavi
 */
@Remote
public interface SessionSinEstadoRemote {

    public void setValor(int valor);

    public int getValor();
    
}
