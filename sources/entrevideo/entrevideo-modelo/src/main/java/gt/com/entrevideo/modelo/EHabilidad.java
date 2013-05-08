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
@Table(name = "e_habilidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EHabilidad.findAll", query = "SELECT e FROM EHabilidad e"),
    @NamedQuery(name = "EHabilidad.findByDbid", query = "SELECT e FROM EHabilidad e WHERE e.dbid = :dbid"),
    @NamedQuery(name = "EHabilidad.findByStrHabilidad", query = "SELECT e FROM EHabilidad e WHERE e.strHabilidad = :strHabilidad")})
public class EHabilidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dbid_")
    private Integer dbid;
    @Column(name = "str_habilidad")
    private String strHabilidad;
    @JoinColumn(name = "habilidad", referencedColumnName = "dbid_")
    @ManyToOne(optional = false)
    private SSinonimo habilidad;
    @JoinColumn(name = "curriculum", referencedColumnName = "dbid_")
    @ManyToOne(optional = false)
    private ECurriculum curriculum;

    public EHabilidad() {
    }

    public EHabilidad(Integer dbid) {
        this.dbid = dbid;
    }

    public Integer getDbid() {
        return dbid;
    }

    public void setDbid(Integer dbid) {
        this.dbid = dbid;
    }

    public String getStrHabilidad() {
        return strHabilidad;
    }

    public void setStrHabilidad(String strHabilidad) {
        this.strHabilidad = strHabilidad;
    }

    public SSinonimo getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(SSinonimo habilidad) {
        this.habilidad = habilidad;
    }

    public ECurriculum getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(ECurriculum curriculum) {
        this.curriculum = curriculum;
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
        if (!(object instanceof EHabilidad)) {
            return false;
        }
        EHabilidad other = (EHabilidad) object;
        if ((this.dbid == null && other.dbid != null) || (this.dbid != null && !this.dbid.equals(other.dbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.com.entrevideo.modelo.EHabilidad[ dbid=" + dbid + " ]";
    }
    
}
