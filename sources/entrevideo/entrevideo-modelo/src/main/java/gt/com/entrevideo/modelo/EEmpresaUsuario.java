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
@Table(name = "e_empresa_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EEmpresaUsuario.findAll", query = "SELECT e FROM EEmpresaUsuario e"),
    @NamedQuery(name = "EEmpresaUsuario.findByDbid", query = "SELECT e FROM EEmpresaUsuario e WHERE e.dbid = :dbid"),
    @NamedQuery(name = "EEmpresaUsuario.findByEstado", query = "SELECT e FROM EEmpresaUsuario e WHERE e.estado = :estado"),
    @NamedQuery(name = "EEmpresaUsuario.findByFechaActivacion", query = "SELECT e FROM EEmpresaUsuario e WHERE e.fechaActivacion = :fechaActivacion")})
public class EEmpresaUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dbid_")
    private Integer dbid;
    @Column(name = "estado")
    private String estado;
    @Column(name = "fecha_activacion")
    private String fechaActivacion;
    @JoinColumn(name = "usuario", referencedColumnName = "dbid_")
    @ManyToOne(optional = false)
    private SUsuario usuario;
    @JoinColumn(name = "empresa", referencedColumnName = "dbid_")
    @ManyToOne(optional = false)
    private EEmpresa empresa;

    public EEmpresaUsuario() {
    }

    public EEmpresaUsuario(Integer dbid) {
        this.dbid = dbid;
    }

    public Integer getDbid() {
        return dbid;
    }

    public void setDbid(Integer dbid) {
        this.dbid = dbid;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaActivacion() {
        return fechaActivacion;
    }

    public void setFechaActivacion(String fechaActivacion) {
        this.fechaActivacion = fechaActivacion;
    }

    public SUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(SUsuario usuario) {
        this.usuario = usuario;
    }

    public EEmpresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EEmpresa empresa) {
        this.empresa = empresa;
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
        if (!(object instanceof EEmpresaUsuario)) {
            return false;
        }
        EEmpresaUsuario other = (EEmpresaUsuario) object;
        if ((this.dbid == null && other.dbid != null) || (this.dbid != null && !this.dbid.equals(other.dbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.com.entrevideo.modelo.EEmpresaUsuario[ dbid=" + dbid + " ]";
    }
    
}
