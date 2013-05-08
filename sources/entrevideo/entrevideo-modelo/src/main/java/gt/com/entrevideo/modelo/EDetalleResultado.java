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
@Table(name = "e_detalle_resultado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EDetalleResultado.findAll", query = "SELECT e FROM EDetalleResultado e"),
    @NamedQuery(name = "EDetalleResultado.findByDbid", query = "SELECT e FROM EDetalleResultado e WHERE e.dbid = :dbid")})
public class EDetalleResultado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "dbid_")
    private Integer dbid;
    @JoinColumn(name = "resultado_prueba", referencedColumnName = "dbid_")
    @ManyToOne(optional = false)
    private EResultadoPrueba resultadoPrueba;
    @JoinColumn(name = "respuesta", referencedColumnName = "dbid_")
    @ManyToOne(optional = false)
    private ERespuestaPregunta respuesta;

    public EDetalleResultado() {
    }

    public EDetalleResultado(Integer dbid) {
        this.dbid = dbid;
    }

    public Integer getDbid() {
        return dbid;
    }

    public void setDbid(Integer dbid) {
        this.dbid = dbid;
    }

    public EResultadoPrueba getResultadoPrueba() {
        return resultadoPrueba;
    }

    public void setResultadoPrueba(EResultadoPrueba resultadoPrueba) {
        this.resultadoPrueba = resultadoPrueba;
    }

    public ERespuestaPregunta getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(ERespuestaPregunta respuesta) {
        this.respuesta = respuesta;
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
        if (!(object instanceof EDetalleResultado)) {
            return false;
        }
        EDetalleResultado other = (EDetalleResultado) object;
        if ((this.dbid == null && other.dbid != null) || (this.dbid != null && !this.dbid.equals(other.dbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.com.entrevideo.modelo.EDetalleResultado[ dbid=" + dbid + " ]";
    }
    
}