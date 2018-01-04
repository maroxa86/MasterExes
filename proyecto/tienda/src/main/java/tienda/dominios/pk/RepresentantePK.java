package tienda.dominios.pk;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Xavi
 */
@Embeddable
public class RepresentantePK implements Serializable {

	private static final long serialVersionUID = 6030911099927243493L;

    @NotNull
    @Column(name = "ID_TRABAJADOR")
    private int idTrabajador;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CLIENTE")
    private int idCliente;

    public RepresentantePK() {
    }

    public RepresentantePK(int idTrabajador, int idCliente) {
        this.idTrabajador = idTrabajador;
        this.idCliente = idCliente;
    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idTrabajador;
        hash += (int) idCliente;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof RepresentantePK)) {
            return false;
        }
        RepresentantePK other = (RepresentantePK) object;
        if (this.idTrabajador != other.idTrabajador) {
            return false;
        }
        if (this.idCliente != other.idCliente) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "xavier.roig.login.model.RepresentantePK[ idTrabajador=" + idTrabajador + ", idCliente=" + idCliente + " ]";
    }
    
}
