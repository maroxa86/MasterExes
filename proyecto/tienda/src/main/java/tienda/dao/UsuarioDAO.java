package tienda.dao;

import tienda.dominios.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario, Integer> {

	Usuario login(String user, String password);
}
