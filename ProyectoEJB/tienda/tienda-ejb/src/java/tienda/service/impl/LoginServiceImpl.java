package tienda.service.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import tienda.dao.UsuarioDAO;
import tienda.dominios.Usuario;
import tienda.service.LoginService;

@Stateless
public class LoginServiceImpl implements LoginService{
        @EJB
	private UsuarioDAO usuarioDAO;

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	@Override
	public Usuario login(String user, String password) {
		Usuario usuario = usuarioDAO.login(user, password);
		return usuario;
	}
}
