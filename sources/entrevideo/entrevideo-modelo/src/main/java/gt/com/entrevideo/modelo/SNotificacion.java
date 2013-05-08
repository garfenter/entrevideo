/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.entrevideo.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author garfenter
 */
@Entity
@Table(name = "s_notificacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SNotificacion.findAll", query = "SELECT s FROM SNotificacion s"),
    @NamedQuery(name = "SNotificacion.findByDbid", query = "SELECT s FROM SNotificacion s WHERE s.dbid = :dbid"),
    @NamedQuery(name = "SNotificacion.findByMensaje", query = "SELECT s FROM SNotificacion s WHERE s.mensaje = :mensaje"),
    @NamedQuery(name = "SNotificacion.findByFechaExpiracion", query = "SELECT s FROM SNotificacion s WHERE s.fechaExpiracion = :fechaExpiracion"),
    @NamedQuery(name = "SNotificacion.findByTipoNotificacion", query = "SELECT s FROM SNotificacion s WHERE s.tipoNotificacion = :tipoNotificacion"),
    @NamedQuery(name = "SNotificacion.findByVerUnaVez", query = "SELECT s FROM SNotificacion s WHERE s.verUnaVez = :verUnaVez")})
public class SNotificacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "dbid_")
    private Integer dbid;
    @Column(name = "mensaje")
    private String mensaje;
    @Column(name = "fecha_expiracion")
    private String fechaExpiracion;
    @Column(name = "tipo_notificacion")
    private String tipoNotificacion;
    @Column(name = "ver_una_vez")
    private String verUnaVez;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sNotificacionDbid")
    private List<SUsuarioNotificacion> sUsuarioNotificacionList;

    public SNotificacion() {
    }

    public SNotificacion(Integer dbid) {
        this.dbid = dbid;
    }

    public Integer getDbid() {
        return dbid;
    }

    public void setDbid(Integer dbid) {
        this.dbid = dbid;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(String fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public String getTipoNotificacion() {
        return tipoNotificacion;
    }

    public void setTipoNotificacion(String tipoNotificacion) {
        this.tipoNotificacion = tipoNotificacion;
    }

    public String getVerUnaVez() {
        return verUnaVez;
    }

    public void setVerUnaVez(String verUnaVez) {
        this.verUnaVez = verUnaVez;
    }

    @XmlTransient
    public List<SUsuarioNotificacion> getSUsuarioNotificacionList() {
        return sUsuarioNotificacionList;
    }

    public void setSUsuarioNotificacionList(List<SUsuarioNotificacion> sUsuarioNotificacionList) {
        this.sUsuarioNotificacionList = sUsuarioNotificacionList;
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
        if (!(object instanceof SNotificacion)) {
            return false;
        }
        SNotificacion other = (SNotificacion) object;
        if ((this.dbid == null && other.dbid != null) || (this.dbid != null && !this.dbid.equals(other.dbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.com.entrevideo.modelo.SNotificacion[ dbid=" + dbid + " ]";
    }
    
}
