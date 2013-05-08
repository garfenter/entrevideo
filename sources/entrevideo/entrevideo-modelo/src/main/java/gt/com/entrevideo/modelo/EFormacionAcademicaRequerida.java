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
@Table(name = "e_formacion_academica_requerida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EFormacionAcademicaRequerida.findAll", query = "SELECT e FROM EFormacionAcademicaRequerida e"),
    @NamedQuery(name = "EFormacionAcademicaRequerida.findByDbid", query = "SELECT e FROM EFormacionAcademicaRequerida e WHERE e.dbid = :dbid"),
    @NamedQuery(name = "EFormacionAcademicaRequerida.findByNivelAcademico", query = "SELECT e FROM EFormacionAcademicaRequerida e WHERE e.nivelAcademico = :nivelAcademico"),
    @NamedQuery(name = "EFormacionAcademicaRequerida.findByGradoAcademico", query = "SELECT e FROM EFormacionAcademicaRequerida e WHERE e.gradoAcademico = :gradoAcademico"),
    @NamedQuery(name = "EFormacionAcademicaRequerida.findByAniosEstudio", query = "SELECT e FROM EFormacionAcademicaRequerida e WHERE e.aniosEstudio = :aniosEstudio")})
public class EFormacionAcademicaRequerida implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "dbid_")
    private Integer dbid;
    @Column(name = "nivel_academico")
    private String nivelAcademico;
    @Column(name = "grado_academico")
    private String gradoAcademico;
    @Column(name = "anios_estudio")
    private String aniosEstudio;
    @JoinColumn(name = "plaza", referencedColumnName = "dbid_")
    @ManyToOne(optional = false)
    private EPlaza plaza;

    public EFormacionAcademicaRequerida() {
    }

    public EFormacionAcademicaRequerida(Integer dbid) {
        this.dbid = dbid;
    }

    public Integer getDbid() {
        return dbid;
    }

    public void setDbid(Integer dbid) {
        this.dbid = dbid;
    }

    public String getNivelAcademico() {
        return nivelAcademico;
    }

    public void setNivelAcademico(String nivelAcademico) {
        this.nivelAcademico = nivelAcademico;
    }

    public String getGradoAcademico() {
        return gradoAcademico;
    }

    public void setGradoAcademico(String gradoAcademico) {
        this.gradoAcademico = gradoAcademico;
    }

    public String getAniosEstudio() {
        return aniosEstudio;
    }

    public void setAniosEstudio(String aniosEstudio) {
        this.aniosEstudio = aniosEstudio;
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
        if (!(object instanceof EFormacionAcademicaRequerida)) {
            return false;
        }
        EFormacionAcademicaRequerida other = (EFormacionAcademicaRequerida) object;
        if ((this.dbid == null && other.dbid != null) || (this.dbid != null && !this.dbid.equals(other.dbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.com.entrevideo.modelo.EFormacionAcademicaRequerida[ dbid=" + dbid + " ]";
    }
    
}
