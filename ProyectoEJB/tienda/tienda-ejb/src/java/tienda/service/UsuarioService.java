package tienda.service;

import javax.ejb.Local;
import tienda.dominios.Usuario;

@Local
public interface UsuarioService {

	void newUsuario(Usuario usuario);
}
