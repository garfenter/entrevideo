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
@Table(name = "e_idioma")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EIdioma.findAll", query = "SELECT e FROM EIdioma e"),
    @NamedQuery(name = "EIdioma.findByDbid", query = "SELECT e FROM EIdioma e WHERE e.dbid = :dbid"),
    @NamedQuery(name = "EIdioma.findByIdioma", query = "SELECT e FROM EIdioma e WHERE e.idioma = :idioma"),
    @NamedQuery(name = "EIdioma.findByNivel", query = "SELECT e FROM EIdioma e WHERE e.nivel = :nivel")})
public class EIdioma implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "dbid_")
    private Integer dbid;
    @Column(name = "idioma")
    private String idioma;
    @Column(name = "nivel")
    private String nivel;
    @JoinColumn(name = "curriculum", referencedColumnName = "dbid_")
    @ManyToOne(optional = false)
    private ECurriculum curriculum;

    public EIdioma() {
    }

    public EIdioma(Integer dbid) {
        this.dbid = dbid;
    }

    public Integer getDbid() {
        return dbid;
    }

    public void setDbid(Integer dbid) {
        this.dbid = dbid;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
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
        if (!(object instanceof EIdioma)) {
            return false;
        }
        EIdioma other = (EIdioma) object;
        if ((this.dbid == null && other.dbid != null) || (this.dbid != null && !this.dbid.equals(other.dbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.com.entrevideo.modelo.EIdioma[ dbid=" + dbid + " ]";
    }
    
}
