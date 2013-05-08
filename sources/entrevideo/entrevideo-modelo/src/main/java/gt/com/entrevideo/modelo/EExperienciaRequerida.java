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
@Table(name = "e_experiencia_requerida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EExperienciaRequerida.findAll", query = "SELECT e FROM EExperienciaRequerida e"),
    @NamedQuery(name = "EExperienciaRequerida.findByDbid", query = "SELECT e FROM EExperienciaRequerida e WHERE e.dbid = :dbid"),
    @NamedQuery(name = "EExperienciaRequerida.findByAniosExperiencia", query = "SELECT e FROM EExperienciaRequerida e WHERE e.aniosExperiencia = :aniosExperiencia"),
    @NamedQuery(name = "EExperienciaRequerida.findByPuesto", query = "SELECT e FROM EExperienciaRequerida e WHERE e.puesto = :puesto"),
    @NamedQuery(name = "EExperienciaRequerida.findByTipoEmpresa", query = "SELECT e FROM EExperienciaRequerida e WHERE e.tipoEmpresa = :tipoEmpresa")})
public class EExperienciaRequerida implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "dbid_")
    private Integer dbid;
    @Column(name = "anios_experiencia")
    private String aniosExperiencia;
    @Column(name = "puesto")
    private String puesto;
    @Column(name = "tipo_empresa")
    private String tipoEmpresa;
    @JoinColumn(name = "plaza", referencedColumnName = "dbid_")
    @ManyToOne(optional = false)
    private EPlaza plaza;

    public EExperienciaRequerida() {
    }

    public EExperienciaRequerida(Integer dbid) {
        this.dbid = dbid;
    }

    public Integer getDbid() {
        return dbid;
    }

    public void setDbid(Integer dbid) {
        this.dbid = dbid;
    }

    public String getAniosExperiencia() {
        return aniosExperiencia;
    }

    public void setAniosExperiencia(String aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getTipoEmpresa() {
        return tipoEmpresa;
    }

    public void setTipoEmpresa(String tipoEmpresa) {
        this.tipoEmpresa = tipoEmpresa;
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
        if (!(object instanceof EExperienciaRequerida)) {
            return false;
        }
        EExperienciaRequerida other = (EExperienciaRequerida) object;
        if ((this.dbid == null && other.dbid != null) || (this.dbid != null && !this.dbid.equals(other.dbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.com.entrevideo.modelo.EExperienciaRequerida[ dbid=" + dbid + " ]";
    }
    
}
