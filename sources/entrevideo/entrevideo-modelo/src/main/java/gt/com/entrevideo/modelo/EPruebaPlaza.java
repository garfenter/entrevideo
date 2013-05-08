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
@Table(name = "e_prueba_plaza")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EPruebaPlaza.findAll", query = "SELECT e FROM EPruebaPlaza e"),
    @NamedQuery(name = "EPruebaPlaza.findByDbid", query = "SELECT e FROM EPruebaPlaza e WHERE e.dbid = :dbid")})
public class EPruebaPlaza implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "dbid_")
    private Integer dbid;
    @JoinColumn(name = "e_prueba_psicometrica_dbid_", referencedColumnName = "dbid_")
    @ManyToOne(optional = false)
    private EPruebaPsicometrica ePruebaPsicometricaDbid;
    @JoinColumn(name = "e_plaza_dbid_", referencedColumnName = "dbid_")
    @ManyToOne(optional = false)
    private EPlaza ePlazaDbid;

    public EPruebaPlaza() {
    }

    public EPruebaPlaza(Integer dbid) {
        this.dbid = dbid;
    }

    public Integer getDbid() {
        return dbid;
    }

    public void setDbid(Integer dbid) {
        this.dbid = dbid;
    }

    public EPruebaPsicometrica getEPruebaPsicometricaDbid() {
        return ePruebaPsicometricaDbid;
    }

    public void setEPruebaPsicometricaDbid(EPruebaPsicometrica ePruebaPsicometricaDbid) {
        this.ePruebaPsicometricaDbid = ePruebaPsicometricaDbid;
    }

    public EPlaza getEPlazaDbid() {
        return ePlazaDbid;
    }

    public void setEPlazaDbid(EPlaza ePlazaDbid) {
        this.ePlazaDbid = ePlazaDbid;
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
        if (!(object instanceof EPruebaPlaza)) {
            return false;
        }
        EPruebaPlaza other = (EPruebaPlaza) object;
        if ((this.dbid == null && other.dbid != null) || (this.dbid != null && !this.dbid.equals(other.dbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.com.entrevideo.modelo.EPruebaPlaza[ dbid=" + dbid + " ]";
    }
    
}
