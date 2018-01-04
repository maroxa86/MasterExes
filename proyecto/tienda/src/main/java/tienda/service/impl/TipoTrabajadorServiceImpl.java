package tienda.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tienda.dao.TipoTrabajadorDAO;
import tienda.dominios.TipoTrabajador;
import tienda.service.TipoTrabajadorService;

@Service(value="tipoTrabajadorService")
public class TipoTrabajadorServiceImpl implements TipoTrabajadorService{

	private TipoTrabajadorDAO tipoTrabajadorDAO;
	
	public TipoTrabajadorDAO getTipoTrabajadorDAO() {
		return tipoTrabajadorDAO;
	}

	@Autowired
	public void setTipoTrabajadorDAO(TipoTrabajadorDAO tipoTrabajadorDAO) {
		this.tipoTrabajadorDAO = tipoTrabajadorDAO;
	}

	@Override
	public List<TipoTrabajador> getListadoTipoTrabajador() {
		return tipoTrabajadorDAO.buscarTodos();
	}

}
