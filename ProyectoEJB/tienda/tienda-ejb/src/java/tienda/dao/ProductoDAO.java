package tienda.dao;

import javax.ejb.Local;
import tienda.dominios.Producto;
import java.util.List;

@Local
public interface ProductoDAO extends GenericDAO<Producto, Integer> {
    List<Producto> cantidadStockProductos();
}
