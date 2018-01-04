package tienda.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tienda.dao.ProductoDAO;
import tienda.dominios.Producto;
import tienda.service.ProductoService;

@Service(value="productoService")
public class ProductoServiceImpl implements ProductoService {

	private ProductoDAO productoDAO;

	public ProductoDAO getProductoDAO() {
		return productoDAO;
	}

	@Autowired
	public void setProductoDAO(ProductoDAO productoDAO) {
		this.productoDAO = productoDAO;
	}

	public List<Producto> getListadoProductos() {
		return productoDAO.buscarTodos();
	}

	@Override
	@Transactional
	public void addProducto(Producto producto) {
		productoDAO.insertar(producto);
	}

	@Override
	public Producto getProducto(int id) {
		return productoDAO.buscarPorClave(id);
	}

	@Override
	@Transactional
	public void saveProducto(Producto producto) {
		productoDAO.salvar(producto);
	}

	@Override
	@Transactional
	public void cambioPrecio(int idProducto, BigDecimal nuevoPrecio) {

	}

	@Override
	@Transactional
	public void augmentarStock(int idProducto, int nuevoStock) {

	}

	@Override
	public void restarStock(int idProducito, int restaProducto) {

	}

}
