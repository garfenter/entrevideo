/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.entrevideo.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "e_expectativa_laboral")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EExpectativaLaboral.findAll", query = "SELECT e FROM EExpectativaLaboral e"),
    @NamedQuery(name = "EExpectativaLaboral.findByDbid", query = "SELECT e FROM EExpectativaLaboral e WHERE e.dbid = :dbid"),
    @NamedQuery(name = "EExpectativaLaboral.findBySalarioEsperado", query = "SELECT e FROM EExpectativaLaboral e WHERE e.salarioEsperado = :salarioEsperado"),
    @NamedQuery(name = "EExpectativaLaboral.findByObservaciones", query = "SELECT e FROM EExpectativaLaboral e WHERE e.observaciones = :observaciones")})
public class EExpectativaLaboral implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "dbid_")
    private Integer dbid;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "salario_esperado")
    private BigDecimal salarioEsperado;
    @Column(name = "observaciones")
    private String observaciones;
    @JoinColumn(name = "curriculum", referencedColumnName = "dbid_")
    @ManyToOne(optional = false)
    private ECurriculum curriculum;

    public EExpectativaLaboral() {
    }

    public EExpectativaLaboral(Integer dbid) {
        this.dbid = dbid;
    }

    public Integer getDbid() {
        return dbid;
    }

    public void setDbid(Integer dbid) {
        this.dbid = dbid;
    }

    public BigDecimal getSalarioEsperado() {
        return salarioEsperado;
    }

    public void setSalarioEsperado(BigDecimal salarioEsperado) {
        this.salarioEsperado = salarioEsperado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
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
        if (!(object instanceof EExpectativaLaboral)) {
            return false;
        }
        EExpectativaLaboral other = (EExpectativaLaboral) object;
        if ((this.dbid == null && other.dbid != null) || (this.dbid != null && !this.dbid.equals(other.dbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.com.entrevideo.modelo.EExpectativaLaboral[ dbid=" + dbid + " ]";
    }
    
}
