package tienda.service;

import org.springframework.beans.factory.annotation.Autowired;

import tienda.dao.DetalleDAO;
import tienda.dominios.Detalle;

public class DetalleServiceImpl implements DetalleService {

	private DetalleDAO detalleDAO;
	
	@Override
	public void insertDetalle(Detalle detalle) {
		detalleDAO.insertar(detalle);
	}

	public DetalleDAO getDetalleDAO() {
		return detalleDAO;
	}

	@Autowired
	public void setDetalleDAO(DetalleDAO detalleDAO) {
		this.detalleDAO = detalleDAO;
	}
	
	
}
