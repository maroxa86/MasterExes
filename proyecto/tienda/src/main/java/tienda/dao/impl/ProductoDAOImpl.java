package tienda.dao.impl;

import org.springframework.stereotype.Repository;

import tienda.dao.ProductoDAO;
import tienda.dominios.Producto;

@Repository
public class ProductoDAOImpl extends AbstractGenericDAOImpl<Producto, Integer> implements ProductoDAO {

}
