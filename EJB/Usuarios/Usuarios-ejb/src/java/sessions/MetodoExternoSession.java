/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Xavi
 */
@Stateless
@DeclareRoles({"rolIncorrecto", "rolCorrecto"})
public class MetodoExternoSession implements MetodoExternoSessionRemote, MetodoExternoSessionLocal {

    @EJB
    private MetodoInternoSessionLocal metodoInternoSession;

    @Override
    @RolesAllowed({"rolIncorrecto", "rolCorrecto"})
    public void metodoExterno(String usuario) {
        metodoInternoSession.metodoInterno(usuario);
    }


}
