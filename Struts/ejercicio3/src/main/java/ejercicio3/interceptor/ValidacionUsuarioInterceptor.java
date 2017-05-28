package ejercicio3.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class ValidacionUsuarioInterceptor implements Interceptor {

	private static final long serialVersionUID = -7601601468204900783L;

	public void init() {
	}

	@Override
	public String intercept(ActionInvocation invocacion) throws Exception {

		// recuperar los objetos de la sesi�n
		Map<String, Object> session = invocacion.getInvocationContext().getSession();

		if (session.get("autenticacion") == null) {
			// el usuario no se autentica regresar a la p�gina de autenticaci�n
			// "autenticacion";
			return "autenticacion";
		} else {
			// verificar la autenticaci�n
			boolean autenticacion = (Boolean) (session.get("autenticacion"));
			if (autenticacion) {
				// el usuario se han autenticado, continuar la acci�n
				return invocacion.invoke();
			} else {
				// el usuario no se ha autenticado regresar a la p�gina de
				// autenticaci�n
				return "autenticacion";
			}
		}
	}

	public void destroy() {
		
	}

}
