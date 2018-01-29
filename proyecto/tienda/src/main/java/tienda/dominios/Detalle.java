package tienda.dominios;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="DETALLE")
public class Detalle implements Serializable {

	private static final long serialVersionUID = 3933421313136319558L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DETALLE_SEQ")
    @SequenceGenerator(sequenceName = "DETALLE_SEQ", allocationSize = 1, name = "DETALLE_SEQ")
	private Integer id;
	
	@Column(name="NUM_DETALLE")
	private Integer numDetalle;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="NUM_FACTURA")
	private Factura factura;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="ID_PRODUCTO")
	private Producto producto;
	
	@NotNull
	private Integer cantidad;
	
	@NotNull
	private Double precio;

	public Detalle() {
		super();
	}

	public Detalle(Integer numDetalle, Factura factura, Producto producto, Integer cantidad,
			Double precio) {
		super();
		this.numDetalle = numDetalle;
		this.factura = factura;
		this.producto = producto;
		this.cantidad = cantidad;
		this.precio = precio;
	}
	
	public Detalle(Integer id, Integer numDetalle, Factura factura, Producto producto, Integer cantidad,
			Double precio) {
		super();
		this.id = id;
		this.numDetalle = numDetalle;
		this.factura = factura;
		this.producto = producto;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getNumDetalle() {
		return numDetalle;
	}

	public void setNumDetalle(Integer numDetalle) {
		this.numDetalle = numDetalle;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((factura == null) ? 0 : factura.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((numDetalle == null) ? 0 : numDetalle.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Detalle other = (Detalle) obj;
		if (factura == null) {
			if (other.factura != null)
				return false;
		} else if (!factura.equals(other.factura))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (numDetalle == null) {
			if (other.numDetalle != null)
				return false;
		} else if (!numDetalle.equals(other.numDetalle))
			return false;
		return true;
	}
	
}
