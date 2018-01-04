package tienda.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tienda.dao.TrabajadorDAO;
import tienda.dominios.Trabajador;
import tienda.service.TrabajadorService;

@Service(value="trabajadorService")
public class TrabajadorServiceImpl implements TrabajadorService {

	private TrabajadorDAO trabajadorDAO;
	
	public TrabajadorDAO getTrabajadorDAO() {
		return trabajadorDAO;
	}

	@Autowired
	public void setTrabajadorDAO(TrabajadorDAO trabajadorDAO) {
		this.trabajadorDAO = trabajadorDAO;
	}

	@Override
	@Transactional
	public void newTrabajador(Trabajador trabajador) {
		trabajadorDAO.insertar(trabajador);
	}

}
