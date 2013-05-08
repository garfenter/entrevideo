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
@Table(name = "e_seccion_prueba")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ESeccionPrueba.findAll", query = "SELECT e FROM ESeccionPrueba e"),
    @NamedQuery(name = "ESeccionPrueba.findByDbid", query = "SELECT e FROM ESeccionPrueba e WHERE e.dbid = :dbid"),
    @NamedQuery(name = "ESeccionPrueba.findByNombre", query = "SELECT e FROM ESeccionPrueba e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "ESeccionPrueba.findByDescripcion", query = "SELECT e FROM ESeccionPrueba e WHERE e.descripcion = :descripcion")})
public class ESeccionPrueba implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "dbid_")
    private Integer dbid;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seccion")
    private List<EPreguntaSeccion> ePreguntaSeccionList;
    @JoinColumn(name = "prueba_psicometrica", referencedColumnName = "dbid_")
    @ManyToOne(optional = false)
    private EPruebaPsicometrica pruebaPsicometrica;

    public ESeccionPrueba() {
    }

    public ESeccionPrueba(Integer dbid) {
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

    @XmlTransient
    public List<EPreguntaSeccion> getEPreguntaSeccionList() {
        return ePreguntaSeccionList;
    }

    public void setEPreguntaSeccionList(List<EPreguntaSeccion> ePreguntaSeccionList) {
        this.ePreguntaSeccionList = ePreguntaSeccionList;
    }

    public EPruebaPsicometrica getPruebaPsicometrica() {
        return pruebaPsicometrica;
    }

    public void setPruebaPsicometrica(EPruebaPsicometrica pruebaPsicometrica) {
        this.pruebaPsicometrica = pruebaPsicometrica;
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
        if (!(object instanceof ESeccionPrueba)) {
            return false;
        }
        ESeccionPrueba other = (ESeccionPrueba) object;
        if ((this.dbid == null && other.dbid != null) || (this.dbid != null && !this.dbid.equals(other.dbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.com.entrevideo.modelo.ESeccionPrueba[ dbid=" + dbid + " ]";
    }
    
}
