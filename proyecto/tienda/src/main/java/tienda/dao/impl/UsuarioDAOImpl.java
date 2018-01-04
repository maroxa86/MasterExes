package tienda.dao.impl;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tienda.dao.UsuarioDAO;
import tienda.dominios.Usuario;

@Repository
public class UsuarioDAOImpl extends AbstractGenericDAOImpl<Usuario, Integer> implements UsuarioDAO {

	@Override
	@Transactional(readOnly = true)
	public Usuario login(String user, String password) {
		try {
			return (Usuario) getManager().createNamedQuery("Usuario.login").setParameter("user", user)
					.setParameter("password", password).getSingleResult();
		}

		catch (NoResultException ex) {
			return null;
		}
	}

}
