package tienda.service;

import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Local;

import tienda.dominios.Producto;

@Local
public interface ProductoService {
	public List<Producto> getListadoProductos();

	void addProducto(Producto producto);

	Producto getProducto(int id);

	void saveProducto(Producto producto);

	void cambioPrecio(int idProducto, BigDecimal nuevoPrecio);

	void augmentarStock(int idProducto, int nuevoStock);

	void restarStock(int idProducito, int restaProducto);
        
        List<Producto> cantidadStockProductos();
}
