/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import javax.ejb.Remote;

/**
 *
 * @author Xavi
 */
@Remote
public interface MetodoExternoSessionRemote {

    void metodoExterno(String usuario);
    
}
