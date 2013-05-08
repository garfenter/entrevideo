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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "e_plaza")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EPlaza.findAll", query = "SELECT e FROM EPlaza e"),
    @NamedQuery(name = "EPlaza.findByDbid", query = "SELECT e FROM EPlaza e WHERE e.dbid = :dbid")})
public class EPlaza implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dbid_")
    private Integer dbid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ePlazaDbid")
    private List<EPruebaPlaza> ePruebaPlazaList;
    @JoinColumn(name = "empresa", referencedColumnName = "dbid_")
    @ManyToOne(optional = false)
    private EEmpresa empresa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plaza")
    private List<EFormacionAcademicaRequerida> eFormacionAcademicaRequeridaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plaza")
    private List<EExperienciaRequerida> eExperienciaRequeridaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plaza")
    private List<EExpectativaRequerida> eExpectativaRequeridaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plaza")
    private List<EHabilidadRequerida> eHabilidadRequeridaList;

    public EPlaza() {
    }

    public EPlaza(Integer dbid) {
        this.dbid = dbid;
    }

    public Integer getDbid() {
        return dbid;
    }

    public void setDbid(Integer dbid) {
        this.dbid = dbid;
    }

    @XmlTransient
    public List<EPruebaPlaza> getEPruebaPlazaList() {
        return ePruebaPlazaList;
    }

    public void setEPruebaPlazaList(List<EPruebaPlaza> ePruebaPlazaList) {
        this.ePruebaPlazaList = ePruebaPlazaList;
    }

    public EEmpresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EEmpresa empresa) {
        this.empresa = empresa;
    }

    @XmlTransient
    public List<EFormacionAcademicaRequerida> getEFormacionAcademicaRequeridaList() {
        return eFormacionAcademicaRequeridaList;
    }

    public void setEFormacionAcademicaRequeridaList(List<EFormacionAcademicaRequerida> eFormacionAcademicaRequeridaList) {
        this.eFormacionAcademicaRequeridaList = eFormacionAcademicaRequeridaList;
    }

    @XmlTransient
    public List<EExperienciaRequerida> getEExperienciaRequeridaList() {
        return eExperienciaRequeridaList;
    }

    public void setEExperienciaRequeridaList(List<EExperienciaRequerida> eExperienciaRequeridaList) {
        this.eExperienciaRequeridaList = eExperienciaRequeridaList;
    }

    @XmlTransient
    public List<EExpectativaRequerida> getEExpectativaRequeridaList() {
        return eExpectativaRequeridaList;
    }

    public void setEExpectativaRequeridaList(List<EExpectativaRequerida> eExpectativaRequeridaList) {
        this.eExpectativaRequeridaList = eExpectativaRequeridaList;
    }

    @XmlTransient
    public List<EHabilidadRequerida> getEHabilidadRequeridaList() {
        return eHabilidadRequeridaList;
    }

    public void setEHabilidadRequeridaList(List<EHabilidadRequerida> eHabilidadRequeridaList) {
        this.eHabilidadRequeridaList = eHabilidadRequeridaList;
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
        if (!(object instanceof EPlaza)) {
            return false;
        }
        EPlaza other = (EPlaza) object;
        if ((this.dbid == null && other.dbid != null) || (this.dbid != null && !this.dbid.equals(other.dbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.com.entrevideo.modelo.EPlaza[ dbid=" + dbid + " ]";
    }
    
}
