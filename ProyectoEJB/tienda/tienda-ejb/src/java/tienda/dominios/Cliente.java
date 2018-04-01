package tienda.dominios;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Basic;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Xavi
 */
@Entity
@Table(name = "CLIENTE")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLIENTE_SEQ")
    @SequenceGenerator(sequenceName = "CLIENTE_SEQ", allocationSize = 1, name = "CLIENTE_SEQ")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "NOMBRE")
    private String nombre;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "CIF")
    private String cif;

    @JoinColumn(name = "ID_TRABAJADOR", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Trabajador trabajador;

    @Basic(optional = false)
    @NotNull
    @Column(name = "COMISION")
    private short comision;

    @OneToMany
    private List<Factura> listadoFacturas;

    public Cliente() {
    }

    public Cliente(Integer id) {
        this.id = id;
    }

    public Cliente(Integer id, String nombre, String cif, Short comision) {
        this.id = id;
        this.nombre = nombre;
        this.cif = cif;
        this.comision = comision;
    }

    public Cliente(String nombre, String cif, Short comision, Trabajador trabajador) {
        this.nombre = nombre;
        this.cif = cif;
        this.comision = comision;
        this.trabajador = trabajador;
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

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }


    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public List<Factura> getListadoFacturas() {
        return listadoFacturas;
    }

    public void setListadoFacturas(List<Factura> listadoFacturas) {
        this.listadoFacturas = listadoFacturas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "xavier.roig.login.model.Cliente[ id=" + id + " ]";
    }

    public short getComision() {
        return comision;
    }

    public void setComision(short comision) {
        this.comision = comision;
    }

}
