package ejercicio3;

import org.springframework.stereotype.Component;

@Component
public class AccionImpl implements Accion {

	@Override
	public void accion() {
		System.out.println("Se esta ejecutando una accion");
	}

	@Override
	public void accionError() {
		System.out.println("Se esta ejecutando una accion con un error");
		try {
			throw new Exception("Ejecucion de un error");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
