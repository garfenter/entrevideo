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
@Table(name = "s_rol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SRol.findAll", query = "SELECT s FROM SRol s"),
    @NamedQuery(name = "SRol.findByDbid", query = "SELECT s FROM SRol s WHERE s.dbid = :dbid"),
    @NamedQuery(name = "SRol.findByNombre", query = "SELECT s FROM SRol s WHERE s.nombre = :nombre"),
    @NamedQuery(name = "SRol.findByDescripcion", query = "SELECT s FROM SRol s WHERE s.descripcion = :descripcion")})
public class SRol implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "dbid_")
    private Integer dbid;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rol")
    private List<SRolPrivilegio> sRolPrivilegioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rol")
    private List<SRolUsuario> sRolUsuarioList;

    public SRol() {
    }

    public SRol(Integer dbid) {
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

    @XmlTransient
    public List<SRolPrivilegio> getSRolPrivilegioList() {
        return sRolPrivilegioList;
    }

    public void setSRolPrivilegioList(List<SRolPrivilegio> sRolPrivilegioList) {
        this.sRolPrivilegioList = sRolPrivilegioList;
    }

    @XmlTransient
    public List<SRolUsuario> getSRolUsuarioList() {
        return sRolUsuarioList;
    }

    public void setSRolUsuarioList(List<SRolUsuario> sRolUsuarioList) {
        this.sRolUsuarioList = sRolUsuarioList;
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
        if (!(object instanceof SRol)) {
            return false;
        }
        SRol other = (SRol) object;
        if ((this.dbid == null && other.dbid != null) || (this.dbid != null && !this.dbid.equals(other.dbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.com.entrevideo.modelo.SRol[ dbid=" + dbid + " ]";
    }
    
}
