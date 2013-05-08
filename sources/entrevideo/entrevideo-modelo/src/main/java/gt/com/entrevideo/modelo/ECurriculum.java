/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.entrevideo.modelo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author garfenter
 */
@Entity
@Table(name = "e_curriculum")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ECurriculum.findAll", query = "SELECT e FROM ECurriculum e"),
    @NamedQuery(name = "ECurriculum.findByDbid", query = "SELECT e FROM ECurriculum e WHERE e.dbid = :dbid"),
    @NamedQuery(name = "ECurriculum.findByNombre", query = "SELECT e FROM ECurriculum e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "ECurriculum.findByDescripcion", query = "SELECT e FROM ECurriculum e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "ECurriculum.findByFechaCreacion", query = "SELECT e FROM ECurriculum e WHERE e.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "ECurriculum.findByEstado", query = "SELECT e FROM ECurriculum e WHERE e.estado = :estado")})
public class ECurriculum implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "dbid_")
    private Integer dbid;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curriculum")
    private List<EIdioma> eIdiomaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curriculum")
    private List<EHabilidad> eHabilidadList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curriculum")
    private List<EFormacionAcademica> eFormacionAcademicaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curriculum")
    private List<EExperiencia> eExperienciaList;
    @JoinColumn(name = "persona", referencedColumnName = "dbid_")
    @ManyToOne(optional = false)
    private EPersona persona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curriculum")
    private List<EExpectativaLaboral> eExpectativaLaboralList;

    public ECurriculum() {
    }

    public ECurriculum(Integer dbid) {
        this.dbid = dbid;
    }

    public ECurriculum(Integer dbid, Date fechaCreacion, String estado) {
        this.dbid = dbid;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
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

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<EIdioma> getEIdiomaList() {
        return eIdiomaList;
    }

    public void setEIdiomaList(List<EIdioma> eIdiomaList) {
        this.eIdiomaList = eIdiomaList;
    }

    @XmlTransient
    public List<EHabilidad> getEHabilidadList() {
        return eHabilidadList;
    }

    public void setEHabilidadList(List<EHabilidad> eHabilidadList) {
        this.eHabilidadList = eHabilidadList;
    }

    @XmlTransient
    public List<EFormacionAcademica> getEFormacionAcademicaList() {
        return eFormacionAcademicaList;
    }

    public void setEFormacionAcademicaList(List<EFormacionAcademica> eFormacionAcademicaList) {
        this.eFormacionAcademicaList = eFormacionAcademicaList;
    }

    @XmlTransient
    public List<EExperiencia> getEExperienciaList() {
        return eExperienciaList;
    }

    public void setEExperienciaList(List<EExperiencia> eExperienciaList) {
        this.eExperienciaList = eExperienciaList;
    }

    public EPersona getPersona() {
        return persona;
    }

    public void setPersona(EPersona persona) {
        this.persona = persona;
    }

    @XmlTransient
    public List<EExpectativaLaboral> getEExpectativaLaboralList() {
        return eExpectativaLaboralList;
    }

    public void setEExpectativaLaboralList(List<EExpectativaLaboral> eExpectativaLaboralList) {
        this.eExpectativaLaboralList = eExpectativaLaboralList;
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
        if (!(object instanceof ECurriculum)) {
            return false;
        }
        ECurriculum other = (ECurriculum) object;
        if ((this.dbid == null && other.dbid != null) || (this.dbid != null && !this.dbid.equals(other.dbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.com.entrevideo.modelo.ECurriculum[ dbid=" + dbid + " ]";
    }
    
}
