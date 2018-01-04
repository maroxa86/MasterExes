package tienda.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tienda.dao.TrabajadorDAO;
import tienda.dao.UsuarioDAO;
import tienda.dominios.Usuario;
import tienda.service.UsuarioService;

@Service(value="usuarioService")
public class UsuarioServiceImpl implements UsuarioService {

	private UsuarioDAO usuarioDAO;
	private TrabajadorDAO trabajadorDAO;
	
	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	@Autowired
	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	public TrabajadorDAO getTrabajadorDAO() {
		return trabajadorDAO;
	}

	@Autowired
	public void setTrabajadorDAO(TrabajadorDAO trabajadorDAO) {
		this.trabajadorDAO = trabajadorDAO;
	}

	@Override
	@Transactional
	public void newUsuario(Usuario usuario) {
		trabajadorDAO.insertar(usuario.getIdTrabajador());
		usuarioDAO.insertar(usuario);
	}

}
