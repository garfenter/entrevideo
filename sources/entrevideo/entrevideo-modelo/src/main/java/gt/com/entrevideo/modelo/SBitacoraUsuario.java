/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.entrevideo.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author garfenter
 */
@Entity
@Table(name = "s_bitacora_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SBitacoraUsuario.findAll", query = "SELECT s FROM SBitacoraUsuario s"),
    @NamedQuery(name = "SBitacoraUsuario.findByDbid", query = "SELECT s FROM SBitacoraUsuario s WHERE s.dbid = :dbid"),
    @NamedQuery(name = "SBitacoraUsuario.findByDescripcionCambio", query = "SELECT s FROM SBitacoraUsuario s WHERE s.descripcionCambio = :descripcionCambio"),
    @NamedQuery(name = "SBitacoraUsuario.findByFecha", query = "SELECT s FROM SBitacoraUsuario s WHERE s.fecha = :fecha")})
public class SBitacoraUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dbid_")
    private Integer dbid;
    @Column(name = "descripcion_cambio")
    private String descripcionCambio;
    @Column(name = "fecha")
    private String fecha;
    @JoinColumn(name = "usuario", referencedColumnName = "dbid_")
    @ManyToOne(optional = false)
    private SUsuario usuario;

    public SBitacoraUsuario() {
    }

    public SBitacoraUsuario(Integer dbid) {
        this.dbid = dbid;
    }

    public Integer getDbid() {
        return dbid;
    }

    public void setDbid(Integer dbid) {
        this.dbid = dbid;
    }

    public String getDescripcionCambio() {
        return descripcionCambio;
    }

    public void setDescripcionCambio(String descripcionCambio) {
        this.descripcionCambio = descripcionCambio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public SUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(SUsuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dbid != null ? dbid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SBitacoraUsuario)) {
            return false;
        }
        SBitacoraUsuario other = (SBitacoraUsuario) object;
        if ((this.dbid == null && other.dbid != null) || (this.dbid != null && !this.dbid.equals(other.dbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.com.entrevideo.modelo.SBitacoraUsuario[ dbid=" + dbid + " ]";
    }
    
}
