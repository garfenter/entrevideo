/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.entrevideo.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "e_telefono")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ETelefono.findAll", query = "SELECT e FROM ETelefono e"),
    @NamedQuery(name = "ETelefono.findByDbid", query = "SELECT e FROM ETelefono e WHERE e.dbid = :dbid"),
    @NamedQuery(name = "ETelefono.findByNumero", query = "SELECT e FROM ETelefono e WHERE e.numero = :numero"),
    @NamedQuery(name = "ETelefono.findByTipo", query = "SELECT e FROM ETelefono e WHERE e.tipo = :tipo")})
public class ETelefono implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dbid_")
    private Integer dbid;
    @Column(name = "numero")
    private String numero;
    @Column(name = "tipo")
    private String tipo;
    @JoinColumn(name = "persona", referencedColumnName = "dbid_")
    @ManyToOne(optional = false)
    private EPersona persona;

    public ETelefono() {
    }

    public ETelefono(Integer dbid) {
        this.dbid = dbid;
    }

    public Integer getDbid() {
        return dbid;
    }

    public void setDbid(Integer dbid) {
        this.dbid = dbid;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public EPersona getPersona() {
        return persona;
    }

    public void setPersona(EPersona persona) {
        this.persona = persona;
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
        if (!(object instanceof ETelefono)) {
            return false;
        }
        ETelefono other = (ETelefono) object;
        if ((this.dbid == null && other.dbid != null) || (this.dbid != null && !this.dbid.equals(other.dbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.com.entrevideo.modelo.ETelefono[ dbid=" + dbid + " ]";
    }
    
}
