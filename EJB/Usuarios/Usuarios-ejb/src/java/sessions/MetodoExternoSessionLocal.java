/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import javax.ejb.Local;

/**
 *
 * @author Xavi
 */
@Local
public interface MetodoExternoSessionLocal {

    void metodoExterno(String usuario);
    
}
