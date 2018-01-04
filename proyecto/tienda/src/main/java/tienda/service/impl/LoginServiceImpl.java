package tienda.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tienda.dao.UsuarioDAO;
import tienda.dominios.Usuario;
import tienda.service.LoginService;

@Service(value="loginService")
public class LoginServiceImpl implements LoginService{
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
