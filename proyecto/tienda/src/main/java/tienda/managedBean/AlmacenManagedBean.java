package tienda.managedBean;

import java.math.BigDecimal;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import tienda.dominios.Producto;
import tienda.service.ProductoService;

@ManagedBean(name = "almacen")
@SessionScoped
public class AlmacenManagedBean {

	private List<Producto> listadoProductos;

	private String nombre;
	private String precio;
	private String stock;
	private Producto infoProducto;

	@ManagedProperty("#{productoService}")
	private ProductoService productoBean;

	public ProductoService getProductoBean() {
		return productoBean;
	}

	public void setProductoBean(ProductoService productoBean) {
		this.productoBean = productoBean;
	}

	public String getInventarioProductos() {
		listadoProductos = productoBean.getListadoProductos();
		return "inventario";
	}
	
	public String getInventarioProductosAdmin(){
		listadoProductos = productoBean.getListadoProductos();
		return "inventarioAdmin";
	}
	
	public String crearUsuario(){
		return "crearUsuario";
	}

	public String newProducto() {
		this.nombre = null;
		this.precio = null;
		this.stock = null;
		return "newProducto";
	}

	public void addProducto() {
		Producto producto = new Producto();
		producto.setNombre(nombre);
		producto.setPrecio(new BigDecimal(precio));
		producto.setStock(Integer.parseInt(stock));
		productoBean.addProducto(producto);
	}

	public String editarProducto(String id) {
		infoProducto = productoBean.getProducto(Integer.parseInt(id));
		return "editarProducto";
	}

	public void guardarProducto() {
		productoBean.saveProducto(infoProducto);
	}

	public List<Producto> getListadoProductos() {
		return listadoProductos;
	}

	public void setListadoProductos(List<Producto> listadoProductos) {
		this.listadoProductos = listadoProductos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public Producto getInfoProducto() {
		return infoProducto;
	}

	public void setInfoProducto(Producto infoProducto) {
		this.infoProducto = infoProducto;
	}
}
