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
@Table(name = "e_pregunta_seccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EPreguntaSeccion.findAll", query = "SELECT e FROM EPreguntaSeccion e"),
    @NamedQuery(name = "EPreguntaSeccion.findByDbid", query = "SELECT e FROM EPreguntaSeccion e WHERE e.dbid = :dbid"),
    @NamedQuery(name = "EPreguntaSeccion.findByPregunta", query = "SELECT e FROM EPreguntaSeccion e WHERE e.pregunta = :pregunta"),
    @NamedQuery(name = "EPreguntaSeccion.findByAyuda", query = "SELECT e FROM EPreguntaSeccion e WHERE e.ayuda = :ayuda"),
    @NamedQuery(name = "EPreguntaSeccion.findByObservaciones", query = "SELECT e FROM EPreguntaSeccion e WHERE e.observaciones = :observaciones")})
public class EPreguntaSeccion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "dbid_")
    private Integer dbid;
    @Column(name = "pregunta")
    private String pregunta;
    @Column(name = "ayuda")
    private String ayuda;
    @Column(name = "observaciones")
    private String observaciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pregunta")
    private List<ERespuestaPregunta> eRespuestaPreguntaList;
    @JoinColumn(name = "seccion", referencedColumnName = "dbid_")
    @ManyToOne(optional = false)
    private ESeccionPrueba seccion;

    public EPreguntaSeccion() {
    }

    public EPreguntaSeccion(Integer dbid) {
        this.dbid = dbid;
    }

    public Integer getDbid() {
        return dbid;
    }

    public void setDbid(Integer dbid) {
        this.dbid = dbid;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getAyuda() {
        return ayuda;
    }

    public void setAyuda(String ayuda) {
        this.ayuda = ayuda;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @XmlTransient
    public List<ERespuestaPregunta> getERespuestaPreguntaList() {
        return eRespuestaPreguntaList;
    }

    public void setERespuestaPreguntaList(List<ERespuestaPregunta> eRespuestaPreguntaList) {
        this.eRespuestaPreguntaList = eRespuestaPreguntaList;
    }

    public ESeccionPrueba getSeccion() {
        return seccion;
    }

    public void setSeccion(ESeccionPrueba seccion) {
        this.seccion = seccion;
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
        if (!(object instanceof EPreguntaSeccion)) {
            return false;
        }
        EPreguntaSeccion other = (EPreguntaSeccion) object;
        if ((this.dbid == null && other.dbid != null) || (this.dbid != null && !this.dbid.equals(other.dbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.com.entrevideo.modelo.EPreguntaSeccion[ dbid=" + dbid + " ]";
    }
    
}
