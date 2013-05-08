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
@Table(name = "s_usuario_notificacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SUsuarioNotificacion.findAll", query = "SELECT s FROM SUsuarioNotificacion s"),
    @NamedQuery(name = "SUsuarioNotificacion.findByDbid", query = "SELECT s FROM SUsuarioNotificacion s WHERE s.dbid = :dbid")})
public class SUsuarioNotificacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "dbid_")
    private Integer dbid;
    @JoinColumn(name = "s_usuario_dbid_", referencedColumnName = "dbid_")
    @ManyToOne(optional = false)
    private SUsuario sUsuarioDbid;
    @JoinColumn(name = "s_notificacion_dbid_", referencedColumnName = "dbid_")
    @ManyToOne(optional = false)
    private SNotificacion sNotificacionDbid;

    public SUsuarioNotificacion() {
    }

    public SUsuarioNotificacion(Integer dbid) {
        this.dbid = dbid;
    }

    public Integer getDbid() {
        return dbid;
    }

    public void setDbid(Integer dbid) {
        this.dbid = dbid;
    }

    public SUsuario getSUsuarioDbid() {
        return sUsuarioDbid;
    }

    public void setSUsuarioDbid(SUsuario sUsuarioDbid) {
        this.sUsuarioDbid = sUsuarioDbid;
    }

    public SNotificacion getSNotificacionDbid() {
        return sNotificacionDbid;
    }

    public void setSNotificacionDbid(SNotificacion sNotificacionDbid) {
        this.sNotificacionDbid = sNotificacionDbid;
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
        if (!(object instanceof SUsuarioNotificacion)) {
            return false;
        }
        SUsuarioNotificacion other = (SUsuarioNotificacion) object;
        if ((this.dbid == null && other.dbid != null) || (this.dbid != null && !this.dbid.equals(other.dbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.com.entrevideo.modelo.SUsuarioNotificacion[ dbid=" + dbid + " ]";
    }
    
}
