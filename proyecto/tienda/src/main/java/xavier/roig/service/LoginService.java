package xavier.roig.service;

import xavier.roig.model.Usuario;

public interface LoginService {
	Usuario login(String user, String password);
}
