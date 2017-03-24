/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;

/**
 *
 * @author Xavi
 */
@Stateless
@DeclareRoles("rolIncorrecto, rolCorrecto")
public class MetodoInternoSession implements MetodoInternoSessionLocal {

    @Override
    @RolesAllowed({"rolCorrecto"})
    public void metodoInterno(String parameter) {
        System.out.println("hola usuario: " + parameter);
    }

    
}
