/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.entrevideo.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "s_rol_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SRolUsuario.findAll", query = "SELECT s FROM SRolUsuario s"),
    @NamedQuery(name = "SRolUsuario.findByDbid", query = "SELECT s FROM SRolUsuario s WHERE s.dbid = :dbid")})
public class SRolUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "dbid_")
    private Integer dbid;
    @JoinColumn(name = "usuario", referencedColumnName = "dbid_")
    @ManyToOne(optional = false)
    private SUsuario usuario;
    @JoinColumn(name = "rol", referencedColumnName = "dbid_")
    @ManyToOne(optional = false)
    private SRol rol;

    public SRolUsuario() {
    }

    public SRolUsuario(Integer dbid) {
        this.dbid = dbid;
    }

    public Integer getDbid() {
        return dbid;
    }

    public void setDbid(Integer dbid) {
        this.dbid = dbid;
    }

    public SUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(SUsuario usuario) {
        this.usuario = usuario;
    }

    public SRol getRol() {
        return rol;
    }

    public void setRol(SRol rol) {
        this.rol = rol;
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
        if (!(object instanceof SRolUsuario)) {
            return false;
        }
        SRolUsuario other = (SRolUsuario) object;
        if ((this.dbid == null && other.dbid != null) || (this.dbid != null && !this.dbid.equals(other.dbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.com.entrevideo.modelo.SRolUsuario[ dbid=" + dbid + " ]";
    }
    
}
