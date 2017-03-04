/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mayusculas;

import javax.ejb.Local;

/**
 *
 * @author Xavi
 */
@Local
public interface MayusculasLocal {

    public String cadenaMayusculas(String cadena);
    
}
