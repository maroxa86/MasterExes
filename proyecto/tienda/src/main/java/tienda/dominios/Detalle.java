package tienda.dominios;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import tienda.dominios.pk.DetallePK;

@Entity
@Table(name="DETALLE")
public class Detalle implements Serializable {

	private static final long serialVersionUID = 3933421313136319558L;

	@EmbeddedId
	private DetallePK detallePK;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="ID_PRODUCTO", referencedColumnName="ID")
	private Producto producto;
	
	@NotNull
	private Integer cantidad;
	
	@NotNull
	private Double precio;

	public Detalle() {
		super();
	}

	public Detalle(DetallePK detallePK, Producto producto, Integer cantidad, Double precio) {
		super();
		this.detallePK = detallePK;
		this.producto = producto;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public DetallePK getDetallePK() {
		return detallePK;
	}

	public void setDetallePK(DetallePK detallePK) {
		this.detallePK = detallePK;
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
		result = prime * result + ((detallePK == null) ? 0 : detallePK.hashCode());
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
		if (detallePK == null) {
			if (other.detallePK != null)
				return false;
		} else if (!detallePK.equals(other.detallePK))
			return false;
		return true;
	}
	
}
