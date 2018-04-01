package tienda.dao;

import javax.ejb.Local;
import tienda.dominios.Usuario;

@Local
public interface UsuarioDAO extends GenericDAO<Usuario, Integer> {

	Usuario login(String user, String password);
}
