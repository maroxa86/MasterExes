package tienda.service;

import javax.ejb.Local;
import tienda.dominios.Usuario;

@Local
public interface LoginService {
	Usuario login(String user, String password);
}
