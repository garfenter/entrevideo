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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author garfenter
 */
@Entity
@Table(name = "s_filtro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SFiltro.findAll", query = "SELECT s FROM SFiltro s"),
    @NamedQuery(name = "SFiltro.findByDbid", query = "SELECT s FROM SFiltro s WHERE s.dbid = :dbid"),
    @NamedQuery(name = "SFiltro.findByNombre", query = "SELECT s FROM SFiltro s WHERE s.nombre = :nombre"),
    @NamedQuery(name = "SFiltro.findByDescripcion", query = "SELECT s FROM SFiltro s WHERE s.descripcion = :descripcion"),
    @NamedQuery(name = "SFiltro.findByFtlJpqlQuery", query = "SELECT s FROM SFiltro s WHERE s.ftlJpqlQuery = :ftlJpqlQuery")})
public class SFiltro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "dbid_")
    private Integer dbid;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "ftl_jpql_query")
    private String ftlJpqlQuery;

    public SFiltro() {
    }

    public SFiltro(Integer dbid) {
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

    public String getFtlJpqlQuery() {
        return ftlJpqlQuery;
    }

    public void setFtlJpqlQuery(String ftlJpqlQuery) {
        this.ftlJpqlQuery = ftlJpqlQuery;
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
        if (!(object instanceof SFiltro)) {
            return false;
        }
        SFiltro other = (SFiltro) object;
        if ((this.dbid == null && other.dbid != null) || (this.dbid != null && !this.dbid.equals(other.dbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.com.entrevideo.modelo.SFiltro[ dbid=" + dbid + " ]";
    }
    
}
