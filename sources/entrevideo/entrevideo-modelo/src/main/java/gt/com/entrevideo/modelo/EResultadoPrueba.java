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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "e_resultado_prueba")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EResultadoPrueba.findAll", query = "SELECT e FROM EResultadoPrueba e"),
    @NamedQuery(name = "EResultadoPrueba.findByDbid", query = "SELECT e FROM EResultadoPrueba e WHERE e.dbid = :dbid")})
public class EResultadoPrueba implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "dbid_")
    private Integer dbid;
    @JoinColumn(name = "e_prueba_psicometrica_dbid_", referencedColumnName = "dbid_")
    @ManyToOne(optional = false)
    private EPruebaPsicometrica ePruebaPsicometricaDbid;
    @JoinColumn(name = "e_persona_dbid_", referencedColumnName = "dbid_")
    @ManyToOne(optional = false)
    private EPersona ePersonaDbid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "resultadoPrueba")
    private List<EDetalleResultado> eDetalleResultadoList;

    public EResultadoPrueba() {
    }

    public EResultadoPrueba(Integer dbid) {
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

    public EPersona getEPersonaDbid() {
        return ePersonaDbid;
    }

    public void setEPersonaDbid(EPersona ePersonaDbid) {
        this.ePersonaDbid = ePersonaDbid;
    }

    @XmlTransient
    public List<EDetalleResultado> getEDetalleResultadoList() {
        return eDetalleResultadoList;
    }

    public void setEDetalleResultadoList(List<EDetalleResultado> eDetalleResultadoList) {
        this.eDetalleResultadoList = eDetalleResultadoList;
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
        if (!(object instanceof EResultadoPrueba)) {
            return false;
        }
        EResultadoPrueba other = (EResultadoPrueba) object;
        if ((this.dbid == null && other.dbid != null) || (this.dbid != null && !this.dbid.equals(other.dbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.com.entrevideo.modelo.EResultadoPrueba[ dbid=" + dbid + " ]";
    }
    
}
