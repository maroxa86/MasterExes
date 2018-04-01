package tienda.dao.impl;

import javax.ejb.Stateless;

import tienda.dao.ProductoDAO;
import tienda.dominios.Producto;
import java.util.List;
import javax.persistence.TypedQuery;

@Stateless
public class ProductoDAOImpl extends AbstractGenericDAOImpl<Producto, Integer> implements ProductoDAO {

    @Override
    public List<Producto> cantidadStockProductos() {
        TypedQuery<Producto> consulta = getManager().createNamedQuery("productoSinStock", Producto.class);
        return consulta.getResultList();
    }

}
