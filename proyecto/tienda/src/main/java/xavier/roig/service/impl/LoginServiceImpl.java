/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xavier.roig.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xavier.roig.dao.UsuarioDAO;
import xavier.roig.model.Usuario;
import xavier.roig.service.LoginService;

/**
 *
 * @author Xavi
 */
@Service(value="loginService")
public class LoginServiceImpl implements LoginService {
    
    private UsuarioDAO usuarioDAO;
    
    public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

    @Autowired
	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	@Override
    public Usuario login(String user, String password) {
        Usuario usuario = usuarioDAO.login(user, password);
        return usuario;
    }

}
