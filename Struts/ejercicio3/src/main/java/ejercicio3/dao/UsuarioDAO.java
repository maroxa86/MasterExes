package ejercicio3.dao;

import ejercicio3.beans.Usuario;

public interface UsuarioDAO {

	public Usuario getUsuario(String usuario) throws Exception;
	public void saveUsuario(Usuario usuario) throws Exception;
}
