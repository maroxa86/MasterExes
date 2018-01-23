package tienda.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tienda.dao.DetalleDAO;
import tienda.dao.FacturaDAO;
import tienda.dominios.Detalle;
import tienda.dominios.Factura;
import tienda.service.FacturaService;

@Service(value="facturaService")
public class FacturaServiceImpl implements FacturaService{

	private FacturaDAO facturaDAO;
	private DetalleDAO detalleDAO;
	
	@Override
	@Transactional
	public void insertFactura(Factura factura, List<Detalle> listadoDetalles) {
		
		facturaDAO.insertar(factura);
		for(Detalle detalle : listadoDetalles){
			detalle.getDetallePK().setNumFactura(factura);
			detalleDAO.insertar(detalle);
		}
	}

	public FacturaDAO getFacturaDAO() {
		return facturaDAO;
	}

	@Autowired
	public void setFacturaDAO(FacturaDAO facturaDAO) {
		this.facturaDAO = facturaDAO;
	}

	public DetalleDAO getDetalleDAO() {
		return detalleDAO;
	}

	@Autowired
	public void setDetalleDAO(DetalleDAO detalleDAO) {
		this.detalleDAO = detalleDAO;
	}

	@Override
	@Transactional
	public void insertFactura(Factura factura) {
		facturaDAO.insertar(factura);
		
	}
		
}
