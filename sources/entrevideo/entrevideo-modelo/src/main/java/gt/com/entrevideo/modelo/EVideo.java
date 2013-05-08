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
@Table(name = "e_video")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EVideo.findAll", query = "SELECT e FROM EVideo e"),
    @NamedQuery(name = "EVideo.findByDbid", query = "SELECT e FROM EVideo e WHERE e.dbid = :dbid"),
    @NamedQuery(name = "EVideo.findByNombre", query = "SELECT e FROM EVideo e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "EVideo.findByDescripcion", query = "SELECT e FROM EVideo e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "EVideo.findByFechaCreacion", query = "SELECT e FROM EVideo e WHERE e.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "EVideo.findByUrl", query = "SELECT e FROM EVideo e WHERE e.url = :url"),
    @NamedQuery(name = "EVideo.findByEstado", query = "SELECT e FROM EVideo e WHERE e.estado = :estado")})
public class EVideo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "dbid_")
    private Integer dbid;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fecha_creacion")
    private String fechaCreacion;
    @Column(name = "url")
    private String url;
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "persona", referencedColumnName = "dbid_")
    @ManyToOne(optional = false)
    private EPersona persona;

    public EVideo() {
    }

    public EVideo(Integer dbid) {
        this.dbid = dbid;
    }

    public Integer getDbid() {
        return dbid;
    }

    public void setDbid(Integer dbid) {
        this.dbid = dbid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public EPersona getPersona() {
        return persona;
    }

    public void setPersona(EPersona persona) {
        this.persona = persona;
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
        if (!(object instanceof EVideo)) {
            return false;
        }
        EVideo other = (EVideo) object;
        if ((this.dbid == null && other.dbid != null) || (this.dbid != null && !this.dbid.equals(other.dbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.com.entrevideo.modelo.EVideo[ dbid=" + dbid + " ]";
    }
    
}
