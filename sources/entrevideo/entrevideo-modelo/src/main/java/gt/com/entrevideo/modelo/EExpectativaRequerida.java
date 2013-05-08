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
@Table(name = "e_expectativa_requerida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EExpectativaRequerida.findAll", query = "SELECT e FROM EExpectativaRequerida e"),
    @NamedQuery(name = "EExpectativaRequerida.findByDbid", query = "SELECT e FROM EExpectativaRequerida e WHERE e.dbid = :dbid"),
    @NamedQuery(name = "EExpectativaRequerida.findBySalarioMinimo", query = "SELECT e FROM EExpectativaRequerida e WHERE e.salarioMinimo = :salarioMinimo"),
    @NamedQuery(name = "EExpectativaRequerida.findBySalarioMaximo", query = "SELECT e FROM EExpectativaRequerida e WHERE e.salarioMaximo = :salarioMaximo")})
public class EExpectativaRequerida implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "dbid_")
    private Integer dbid;
    @Column(name = "salario_minimo")
    private String salarioMinimo;
    @Column(name = "salario_maximo")
    private String salarioMaximo;
    @JoinColumn(name = "plaza", referencedColumnName = "dbid_")
    @ManyToOne(optional = false)
    private EPlaza plaza;

    public EExpectativaRequerida() {
    }

    public EExpectativaRequerida(Integer dbid) {
        this.dbid = dbid;
    }

    public Integer getDbid() {
        return dbid;
    }

    public void setDbid(Integer dbid) {
        this.dbid = dbid;
    }

    public String getSalarioMinimo() {
        return salarioMinimo;
    }

    public void setSalarioMinimo(String salarioMinimo) {
        this.salarioMinimo = salarioMinimo;
    }

    public String getSalarioMaximo() {
        return salarioMaximo;
    }

    public void setSalarioMaximo(String salarioMaximo) {
        this.salarioMaximo = salarioMaximo;
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
        if (!(object instanceof EExpectativaRequerida)) {
            return false;
        }
        EExpectativaRequerida other = (EExpectativaRequerida) object;
        if ((this.dbid == null && other.dbid != null) || (this.dbid != null && !this.dbid.equals(other.dbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.com.entrevideo.modelo.EExpectativaRequerida[ dbid=" + dbid + " ]";
    }
    
}
