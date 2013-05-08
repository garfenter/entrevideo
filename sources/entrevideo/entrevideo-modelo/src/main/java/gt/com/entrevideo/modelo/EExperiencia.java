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
@Table(name = "e_experiencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EExperiencia.findAll", query = "SELECT e FROM EExperiencia e"),
    @NamedQuery(name = "EExperiencia.findByDbid", query = "SELECT e FROM EExperiencia e WHERE e.dbid = :dbid"),
    @NamedQuery(name = "EExperiencia.findByEmpresa", query = "SELECT e FROM EExperiencia e WHERE e.empresa = :empresa"),
    @NamedQuery(name = "EExperiencia.findByAnios", query = "SELECT e FROM EExperiencia e WHERE e.anios = :anios"),
    @NamedQuery(name = "EExperiencia.findByFechaInicio", query = "SELECT e FROM EExperiencia e WHERE e.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "EExperiencia.findByFechaFin", query = "SELECT e FROM EExperiencia e WHERE e.fechaFin = :fechaFin"),
    @NamedQuery(name = "EExperiencia.findByTipoEmpresa", query = "SELECT e FROM EExperiencia e WHERE e.tipoEmpresa = :tipoEmpresa"),
    @NamedQuery(name = "EExperiencia.findByPuesto", query = "SELECT e FROM EExperiencia e WHERE e.puesto = :puesto")})
public class EExperiencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dbid_")
    private Integer dbid;
    @Column(name = "empresa")
    private String empresa;
    @Column(name = "anios")
    private String anios;
    @Column(name = "fecha_inicio")
    private String fechaInicio;
    @Column(name = "fecha_fin")
    private String fechaFin;
    @Column(name = "tipo_empresa")
    private String tipoEmpresa;
    @Column(name = "puesto")
    private String puesto;
    @JoinColumn(name = "curriculum", referencedColumnName = "dbid_")
    @ManyToOne(optional = false)
    private ECurriculum curriculum;

    public EExperiencia() {
    }

    public EExperiencia(Integer dbid) {
        this.dbid = dbid;
    }

    public Integer getDbid() {
        return dbid;
    }

    public void setDbid(Integer dbid) {
        this.dbid = dbid;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getAnios() {
        return anios;
    }

    public void setAnios(String anios) {
        this.anios = anios;
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

    public String getTipoEmpresa() {
        return tipoEmpresa;
    }

    public void setTipoEmpresa(String tipoEmpresa) {
        this.tipoEmpresa = tipoEmpresa;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
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
        if (!(object instanceof EExperiencia)) {
            return false;
        }
        EExperiencia other = (EExperiencia) object;
        if ((this.dbid == null && other.dbid != null) || (this.dbid != null && !this.dbid.equals(other.dbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.com.entrevideo.modelo.EExperiencia[ dbid=" + dbid + " ]";
    }
    
}
