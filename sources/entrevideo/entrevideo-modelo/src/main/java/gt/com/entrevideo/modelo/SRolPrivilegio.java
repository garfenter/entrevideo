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
@Table(name = "s_rol_privilegio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SRolPrivilegio.findAll", query = "SELECT s FROM SRolPrivilegio s"),
    @NamedQuery(name = "SRolPrivilegio.findByDbid", query = "SELECT s FROM SRolPrivilegio s WHERE s.dbid = :dbid")})
public class SRolPrivilegio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "dbid_")
    private Integer dbid;
    @JoinColumn(name = "rol", referencedColumnName = "dbid_")
    @ManyToOne(optional = false)
    private SRol rol;
    @JoinColumn(name = "privilegio", referencedColumnName = "dbid_")
    @ManyToOne(optional = false)
    private SPrivilegio privilegio;

    public SRolPrivilegio() {
    }

    public SRolPrivilegio(Integer dbid) {
        this.dbid = dbid;
    }

    public Integer getDbid() {
        return dbid;
    }

    public void setDbid(Integer dbid) {
        this.dbid = dbid;
    }

    public SRol getRol() {
        return rol;
    }

    public void setRol(SRol rol) {
        this.rol = rol;
    }

    public SPrivilegio getPrivilegio() {
        return privilegio;
    }

    public void setPrivilegio(SPrivilegio privilegio) {
        this.privilegio = privilegio;
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
        if (!(object instanceof SRolPrivilegio)) {
            return false;
        }
        SRolPrivilegio other = (SRolPrivilegio) object;
        if ((this.dbid == null && other.dbid != null) || (this.dbid != null && !this.dbid.equals(other.dbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.com.entrevideo.modelo.SRolPrivilegio[ dbid=" + dbid + " ]";
    }
    
}
