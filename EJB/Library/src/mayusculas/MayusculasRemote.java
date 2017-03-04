/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mayusculas;

import javax.ejb.Remote;

/**
 *
 * @author Xavi
 */
@Remote
public interface MayusculasRemote {

    public String cadenaMayusculas(String cadena);
    
}
