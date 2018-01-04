package tienda.dominios;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Xavi
 */
@Entity
@Table(name = "TRABAJADOR")
public class Trabajador implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRABAJADOR_SEQ")
    @SequenceGenerator(sequenceName = "TRABAJADOR_SEQ", allocationSize = 1, name = "TRABAJADOR_SEQ")
	private Integer id;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "APELLIDO1")
	private String apellido1;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "APELLIDO2")
	private String apellido2;
	
	@Column(name = "FECHA_NACIMIENTO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaNacimiento;
	
	@Column(name = "FECHA_INCORPORACION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaIncorporacion;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "trabajador")
	private List<Venta> ventaList;
	
	@JoinColumn(name = "TIPO_TRABAJADOR", referencedColumnName = "ID")
	@ManyToOne(optional = false)
	private TipoTrabajador tipoTrabajador;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "trabajador")
	private List<Representante> representanteList;
	
	@OneToMany(mappedBy = "idTrabajador")
	private List<Usuario> usuarioList;

	public Trabajador() {
	}

	public Trabajador(Integer id) {
		this.id = id;
	}

	public Trabajador(Integer id, String nombre, String apellido1, String apellido2) {
		this.id = id;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Date getFechaIncorporacion() {
		return fechaIncorporacion;
	}

	public void setFechaIncorporacion(Date fechaIncorporacion) {
		this.fechaIncorporacion = fechaIncorporacion;
	}

	public List<Venta> getVentaList() {
		return ventaList;
	}

	public void setVentaList(List<Venta> ventaList) {
		this.ventaList = ventaList;
	}

	public TipoTrabajador getTipoTrabajador() {
		return tipoTrabajador;
	}

	public void setTipoTrabajador(TipoTrabajador tipoTrabajador) {
		this.tipoTrabajador = tipoTrabajador;
	}

	public List<Representante> getRepresentanteList() {
		return representanteList;
	}

	public void setRepresentanteList(List<Representante> representanteList) {
		this.representanteList = representanteList;
	}

	public List<Usuario> getUsuarioList() {
		return usuarioList;
	}

	public void setUsuarioList(List<Usuario> usuarioList) {
		this.usuarioList = usuarioList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Trabajador)) {
			return false;
		}
		Trabajador other = (Trabajador) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "xavier.roig.login.model.Trabajador[ id=" + id + " ]";
	}
}
