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
@Table(name = "s_sinonimo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SSinonimo.findAll", query = "SELECT s FROM SSinonimo s"),
    @NamedQuery(name = "SSinonimo.findByDbid", query = "SELECT s FROM SSinonimo s WHERE s.dbid = :dbid"),
    @NamedQuery(name = "SSinonimo.findByNombre", query = "SELECT s FROM SSinonimo s WHERE s.nombre = :nombre")})
public class SSinonimo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "dbid_")
    private Integer dbid;
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "lista_valores", referencedColumnName = "dbid_")
    @ManyToOne(optional = false)
    private SListaValores listaValores;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "habilidad")
    private List<EHabilidad> eHabilidadList;

    public SSinonimo() {
    }

    public SSinonimo(Integer dbid) {
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

    public SListaValores getListaValores() {
        return listaValores;
    }

    public void setListaValores(SListaValores listaValores) {
        this.listaValores = listaValores;
    }

    @XmlTransient
    public List<EHabilidad> getEHabilidadList() {
        return eHabilidadList;
    }

    public void setEHabilidadList(List<EHabilidad> eHabilidadList) {
        this.eHabilidadList = eHabilidadList;
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
        if (!(object instanceof SSinonimo)) {
            return false;
        }
        SSinonimo other = (SSinonimo) object;
        if ((this.dbid == null && other.dbid != null) || (this.dbid != null && !this.dbid.equals(other.dbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.com.entrevideo.modelo.SSinonimo[ dbid=" + dbid + " ]";
    }
    
}
