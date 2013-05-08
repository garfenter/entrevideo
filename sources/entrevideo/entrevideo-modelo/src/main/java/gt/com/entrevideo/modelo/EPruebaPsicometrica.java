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
@Table(name = "e_prueba_psicometrica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EPruebaPsicometrica.findAll", query = "SELECT e FROM EPruebaPsicometrica e"),
    @NamedQuery(name = "EPruebaPsicometrica.findByDbid", query = "SELECT e FROM EPruebaPsicometrica e WHERE e.dbid = :dbid"),
    @NamedQuery(name = "EPruebaPsicometrica.findByNombre", query = "SELECT e FROM EPruebaPsicometrica e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "EPruebaPsicometrica.findByDescripcion", query = "SELECT e FROM EPruebaPsicometrica e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "EPruebaPsicometrica.findByEstado", query = "SELECT e FROM EPruebaPsicometrica e WHERE e.estado = :estado")})
public class EPruebaPsicometrica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "dbid_")
    private Integer dbid;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ePruebaPsicometricaDbid")
    private List<EResultadoPrueba> eResultadoPruebaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ePruebaPsicometricaDbid")
    private List<EPruebaPlaza> ePruebaPlazaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pruebaPsicometrica")
    private List<ESeccionPrueba> eSeccionPruebaList;
    @JoinColumn(name = "empresa", referencedColumnName = "dbid_")
    @ManyToOne
    private EEmpresa empresa;

    public EPruebaPsicometrica() {
    }

    public EPruebaPsicometrica(Integer dbid) {
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<EResultadoPrueba> getEResultadoPruebaList() {
        return eResultadoPruebaList;
    }

    public void setEResultadoPruebaList(List<EResultadoPrueba> eResultadoPruebaList) {
        this.eResultadoPruebaList = eResultadoPruebaList;
    }

    @XmlTransient
    public List<EPruebaPlaza> getEPruebaPlazaList() {
        return ePruebaPlazaList;
    }

    public void setEPruebaPlazaList(List<EPruebaPlaza> ePruebaPlazaList) {
        this.ePruebaPlazaList = ePruebaPlazaList;
    }

    @XmlTransient
    public List<ESeccionPrueba> getESeccionPruebaList() {
        return eSeccionPruebaList;
    }

    public void setESeccionPruebaList(List<ESeccionPrueba> eSeccionPruebaList) {
        this.eSeccionPruebaList = eSeccionPruebaList;
    }

    public EEmpresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EEmpresa empresa) {
        this.empresa = empresa;
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
        if (!(object instanceof EPruebaPsicometrica)) {
            return false;
        }
        EPruebaPsicometrica other = (EPruebaPsicometrica) object;
        if ((this.dbid == null && other.dbid != null) || (this.dbid != null && !this.dbid.equals(other.dbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.com.entrevideo.modelo.EPruebaPsicometrica[ dbid=" + dbid + " ]";
    }
    
}
