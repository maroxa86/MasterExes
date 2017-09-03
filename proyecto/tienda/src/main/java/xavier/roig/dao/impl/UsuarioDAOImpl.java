/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xavier.roig.dao.impl;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import xavier.roig.dao.UsuarioDAO;
import xavier.roig.model.Usuario;

/**
 *
 * @author Xavi
 */
@Repository
public class UsuarioDAOImpl extends AbstractGenericDAOImpl<Usuario, Integer> implements UsuarioDAO{

    @Override
    @Transactional(readOnly=true)
    public Usuario login(String user, String password) {
        try{
           return (Usuario) getManager().createNamedQuery("Usuario.login")
                                    .setParameter("user", user)
                                    .setParameter("password", password)
                                    .getSingleResult(); 
        }
        catch(NoResultException ex){
            return null;
        }
    }
    
}
