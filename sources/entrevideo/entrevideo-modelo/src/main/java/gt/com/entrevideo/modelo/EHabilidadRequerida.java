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
@Table(name = "e_habilidad_requerida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EHabilidadRequerida.findAll", query = "SELECT e FROM EHabilidadRequerida e"),
    @NamedQuery(name = "EHabilidadRequerida.findByDbid", query = "SELECT e FROM EHabilidadRequerida e WHERE e.dbid = :dbid"),
    @NamedQuery(name = "EHabilidadRequerida.findByHabilidad", query = "SELECT e FROM EHabilidadRequerida e WHERE e.habilidad = :habilidad")})
public class EHabilidadRequerida implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dbid_")
    private Integer dbid;
    @Column(name = "habilidad")
    private String habilidad;
    @JoinColumn(name = "plaza", referencedColumnName = "dbid_")
    @ManyToOne(optional = false)
    private EPlaza plaza;

    public EHabilidadRequerida() {
    }

    public EHabilidadRequerida(Integer dbid) {
        this.dbid = dbid;
    }

    public Integer getDbid() {
        return dbid;
    }

    public void setDbid(Integer dbid) {
        this.dbid = dbid;
    }

    public String getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }

    public EPlaza getPlaza() {
        return plaza;
    }

    public void setPlaza(EPlaza plaza) {
        this.plaza = plaza;
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
        if (!(object instanceof EHabilidadRequerida)) {
            return false;
        }
        EHabilidadRequerida other = (EHabilidadRequerida) object;
        if ((this.dbid == null && other.dbid != null) || (this.dbid != null && !this.dbid.equals(other.dbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.com.entrevideo.modelo.EHabilidadRequerida[ dbid=" + dbid + " ]";
    }
    
}
