/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.dominios;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
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
@Table(name = "MENSAJES")
@NamedQuery(name = "listadoMensajesPendientes", query="SELECT mensajes FROM Mensajes mensajes WHERE mensajes.leido = 0")
public class Mensajes implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MENSAJES_SEQ")
    @SequenceGenerator(sequenceName = "MENSAJES_SEQ", allocationSize = 1, name = "MENSAJES_SEQ")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name="ASUNTO")
    private String asunto;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "MENSAJE")
    private String mensaje;
    
    @Column(name = "LEIDO")
    private Short leido = 0;
    
    @Column(name = "FECHA_RECIBIDO")
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRecibido;

    public Mensajes() {
    }

    public Mensajes(Integer id) {
        this.id = id;
    }

    public Mensajes(Integer id, String asunto, String mensaje, Date fechaRecibido) {
        this.id = id;
        this.asunto = asunto;
        this.mensaje = mensaje;
        this.fechaRecibido = fechaRecibido;
    }
    
    public Mensajes(String asunto, String mensaje, Date fechaRecibido){
        this.asunto = asunto;
        this.mensaje = mensaje;
        this.fechaRecibido = fechaRecibido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Short getLeido() {
        return leido;
    }

    public void setLeido(Short leido) {
        this.leido = leido;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public Date getFechaRecibido() {
        return fechaRecibido;
    }

    public void setFechaRecibido(Date fechaRecibido) {
        this.fechaRecibido = fechaRecibido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mensajes)) {
            return false;
        }
        Mensajes other = (Mensajes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tienda.dominios.Mensajes[ id=" + id + " ]";
    }
    
}
