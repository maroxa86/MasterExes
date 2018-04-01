package tienda.service;

import java.util.List;
import javax.ejb.Local;

import tienda.dominios.TipoTrabajador;

@Local
public interface TipoTrabajadorService {

	List<TipoTrabajador> getListadoTipoTrabajador();
}
