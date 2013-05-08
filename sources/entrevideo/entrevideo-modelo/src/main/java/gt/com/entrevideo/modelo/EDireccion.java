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
@Table(name = "e_direccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EDireccion.findAll", query = "SELECT e FROM EDireccion e"),
    @NamedQuery(name = "EDireccion.findByDbid", query = "SELECT e FROM EDireccion e WHERE e.dbid = :dbid"),
    @NamedQuery(name = "EDireccion.findByDireccion", query = "SELECT e FROM EDireccion e WHERE e.direccion = :direccion")})
public class EDireccion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dbid_")
    private Integer dbid;
    @Column(name = "direccion")
    private String direccion;
    @JoinColumn(name = "persona", referencedColumnName = "dbid_")
    @ManyToOne(optional = false)
    private EPersona persona;

    public EDireccion() {
    }

    public EDireccion(Integer dbid) {
        this.dbid = dbid;
    }

    public Integer getDbid() {
        return dbid;
    }

    public void setDbid(Integer dbid) {
        this.dbid = dbid;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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
        if (!(object instanceof EDireccion)) {
            return false;
        }
        EDireccion other = (EDireccion) object;
        if ((this.dbid == null && other.dbid != null) || (this.dbid != null && !this.dbid.equals(other.dbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.com.entrevideo.modelo.EDireccion[ dbid=" + dbid + " ]";
    }
    
}
