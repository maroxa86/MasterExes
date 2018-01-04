package tienda.service;

import tienda.dominios.Usuario;

public interface LoginService {
	Usuario login(String user, String password);
}
