/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mayusculas;

import javax.ejb.Stateless;

/**
 *
 * @author Xavi
 */
@Stateless
public class Mayusculas implements MayusculasRemote, MayusculasLocal {

    @Override
    public String cadenaMayusculas(String cadena) {
        return cadena.toUpperCase();
    }

}
