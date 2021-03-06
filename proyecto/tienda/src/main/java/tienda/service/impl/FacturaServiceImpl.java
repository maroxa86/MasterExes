package tienda.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tienda.dao.DetalleDAO;
import tienda.dao.FacturaDAO;
import tienda.dao.ProductoDAO;
import tienda.dominios.Detalle;
import tienda.dominios.Factura;
import tienda.dominios.Producto;
import tienda.service.FacturaService;

@Service(value="facturaService")
public class FacturaServiceImpl implements FacturaService{

	private FacturaDAO facturaDAO;
	private DetalleDAO detalleDAO;
	private ProductoDAO productoDAO;
	
	@Override
	@Transactional
	public void insertFactura(Factura factura, List<Detalle> listadoDetalles) {
		
		facturaDAO.insertar(factura);
		for(Detalle detalle : listadoDetalles){
			detalle.setFactura(factura);
			detalleDAO.insertar(detalle);
		}
	}
	
	@Override
	public List<Factura> getListadoFacturaByIdUsuario(int idUsuario) {
		List<Factura> listadoFacturas = facturaDAO.getListadoFacturasByIdUsuario(idUsuario);
		for(Factura factura : listadoFacturas){
			double totalFactura = 0;
			for(Detalle detalle : factura.getListadoDetalles()){
				totalFactura += detalle.getCantidad() * detalle.getPrecio();
			}
			factura.setTotalFactura(totalFactura);
		}
		return listadoFacturas;
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

	@Override
	public List<Factura> getListadoPedidosMensual(int idUsuario) {
		List<Factura> listadoFacturas = facturaDAO.getListadoFacturaMensual(idUsuario);
		for(Factura factura : listadoFacturas){
			double totalFactura = 0;
			for(Detalle detalle : factura.getListadoDetalles()){
				totalFactura += detalle.getCantidad() * detalle.getPrecio();
			}
			factura.setTotalFactura(totalFactura);
		}
		return listadoFacturas;
	}

	@Override
	public List<Factura> getListadoFacturasPendientes() {
		return facturaDAO.getListadoFacturasPendientes();
	}

	@Override
	public Factura getFacturaById(Long numFactura) {
		return facturaDAO.buscarPorClave(numFactura);
	}

	@Override
	@Transactional
	public void finalizarFactura(Factura factura) {
		for(Detalle detalle : factura.getListadoDetalles()){
			Producto producto = detalle.getProducto();
			producto.setStock(producto.getStock() - detalle.getCantidad());
			productoDAO.salvar(producto);
		}
		factura.setProcesado(1);
		facturaDAO.salvar(factura);
	}

	public ProductoDAO getProductoDAO() {
		return productoDAO;
	}

	@Autowired
	public void setProductoDAO(ProductoDAO productoDAO) {
		this.productoDAO = productoDAO;
	}
		
}
