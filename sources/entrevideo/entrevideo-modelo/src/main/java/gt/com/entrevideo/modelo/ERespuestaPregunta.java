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
@Table(name = "e_respuesta_pregunta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ERespuestaPregunta.findAll", query = "SELECT e FROM ERespuestaPregunta e"),
    @NamedQuery(name = "ERespuestaPregunta.findByDbid", query = "SELECT e FROM ERespuestaPregunta e WHERE e.dbid = :dbid"),
    @NamedQuery(name = "ERespuestaPregunta.findByNombre", query = "SELECT e FROM ERespuestaPregunta e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "ERespuestaPregunta.findByDescripcion", query = "SELECT e FROM ERespuestaPregunta e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "ERespuestaPregunta.findByPunteo", query = "SELECT e FROM ERespuestaPregunta e WHERE e.punteo = :punteo")})
public class ERespuestaPregunta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "dbid_")
    private Integer dbid;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "punteo")
    private String punteo;
    @JoinColumn(name = "pregunta", referencedColumnName = "dbid_")
    @ManyToOne(optional = false)
    private EPreguntaSeccion pregunta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "respuesta")
    private List<EDetalleResultado> eDetalleResultadoList;

    public ERespuestaPregunta() {
    }

    public ERespuestaPregunta(Integer dbid) {
        this.dbid = dbid;
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

    public String getPunteo() {
        return punteo;
    }

    public void setPunteo(String punteo) {
        this.punteo = punteo;
    }

    public EPreguntaSeccion getPregunta() {
        return pregunta;
    }

    public void setPregunta(EPreguntaSeccion pregunta) {
        this.pregunta = pregunta;
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
        if (!(object instanceof ERespuestaPregunta)) {
            return false;
        }
        ERespuestaPregunta other = (ERespuestaPregunta) object;
        if ((this.dbid == null && other.dbid != null) || (this.dbid != null && !this.dbid.equals(other.dbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.com.entrevideo.modelo.ERespuestaPregunta[ dbid=" + dbid + " ]";
    }
    
}
