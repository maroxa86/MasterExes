package tienda.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import tienda.dao.UsuarioDAO;
import tienda.dominios.Usuario;

@Stateless
public class UsuarioDAOImpl extends AbstractGenericDAOImpl<Usuario, Integer> implements UsuarioDAO {

    @Override
    @Transactional
    public Usuario login(String user, String password) {
        try {
            return (Usuario) getManager().createNamedQuery("Usuario.login").setParameter("user", user)
                    .setParameter("password", password).getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

}
