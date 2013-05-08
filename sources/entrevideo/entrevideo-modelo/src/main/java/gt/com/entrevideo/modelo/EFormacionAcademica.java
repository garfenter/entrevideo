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
@Table(name = "e_formacion_academica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EFormacionAcademica.findAll", query = "SELECT e FROM EFormacionAcademica e"),
    @NamedQuery(name = "EFormacionAcademica.findByDbid", query = "SELECT e FROM EFormacionAcademica e WHERE e.dbid = :dbid"),
    @NamedQuery(name = "EFormacionAcademica.findByUniversidad", query = "SELECT e FROM EFormacionAcademica e WHERE e.universidad = :universidad"),
    @NamedQuery(name = "EFormacionAcademica.findByFechaInicio", query = "SELECT e FROM EFormacionAcademica e WHERE e.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "EFormacionAcademica.findByFechaFin", query = "SELECT e FROM EFormacionAcademica e WHERE e.fechaFin = :fechaFin"),
    @NamedQuery(name = "EFormacionAcademica.findByActualmenteCursando", query = "SELECT e FROM EFormacionAcademica e WHERE e.actualmenteCursando = :actualmenteCursando"),
    @NamedQuery(name = "EFormacionAcademica.findByGradoAcademico", query = "SELECT e FROM EFormacionAcademica e WHERE e.gradoAcademico = :gradoAcademico"),
    @NamedQuery(name = "EFormacionAcademica.findByCampoEstudio", query = "SELECT e FROM EFormacionAcademica e WHERE e.campoEstudio = :campoEstudio"),
    @NamedQuery(name = "EFormacionAcademica.findByDescripcion", query = "SELECT e FROM EFormacionAcademica e WHERE e.descripcion = :descripcion")})
public class EFormacionAcademica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "dbid_")
    private Integer dbid;
    @Column(name = "universidad")
    private String universidad;
    @Column(name = "fecha_inicio")
    private String fechaInicio;
    @Column(name = "fecha_fin")
    private String fechaFin;
    @Column(name = "actualmente_cursando")
    private String actualmenteCursando;
    @Column(name = "grado_academico")
    private String gradoAcademico;
    @Column(name = "campo_estudio")
    private String campoEstudio;
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "curriculum", referencedColumnName = "dbid_")
    @ManyToOne(optional = false)
    private ECurriculum curriculum;

    public EFormacionAcademica() {
    }

    public EFormacionAcademica(Integer dbid) {
        this.dbid = dbid;
    }

    public Integer getDbid() {
        return dbid;
    }

    public void setDbid(Integer dbid) {
        this.dbid = dbid;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getActualmenteCursando() {
        return actualmenteCursando;
    }

    public void setActualmenteCursando(String actualmenteCursando) {
        this.actualmenteCursando = actualmenteCursando;
    }

    public String getGradoAcademico() {
        return gradoAcademico;
    }

    public void setGradoAcademico(String gradoAcademico) {
        this.gradoAcademico = gradoAcademico;
    }

    public String getCampoEstudio() {
        return campoEstudio;
    }

    public void setCampoEstudio(String campoEstudio) {
        this.campoEstudio = campoEstudio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        if (!(object instanceof EFormacionAcademica)) {
            return false;
        }
        EFormacionAcademica other = (EFormacionAcademica) object;
        if ((this.dbid == null && other.dbid != null) || (this.dbid != null && !this.dbid.equals(other.dbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.com.entrevideo.modelo.EFormacionAcademica[ dbid=" + dbid + " ]";
    }
    
}
