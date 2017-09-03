/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xavier.roig.dao;

import xavier.roig.model.Usuario;

/**
 *
 * @author Xavi
 */
public interface UsuarioDAO extends GenericDAO<Usuario, Integer>{
    
    Usuario login(String user, String password);
}
