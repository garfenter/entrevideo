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
@Table(name = "e_empresa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EEmpresa.findAll", query = "SELECT e FROM EEmpresa e"),
    @NamedQuery(name = "EEmpresa.findByDbid", query = "SELECT e FROM EEmpresa e WHERE e.dbid = :dbid"),
    @NamedQuery(name = "EEmpresa.findByNombre", query = "SELECT e FROM EEmpresa e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "EEmpresa.findByDescripcion", query = "SELECT e FROM EEmpresa e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "EEmpresa.findByLogo", query = "SELECT e FROM EEmpresa e WHERE e.logo = :logo"),
    @NamedQuery(name = "EEmpresa.findByContacto", query = "SELECT e FROM EEmpresa e WHERE e.contacto = :contacto"),
    @NamedQuery(name = "EEmpresa.findBySUsuarioDbid", query = "SELECT e FROM EEmpresa e WHERE e.sUsuarioDbid = :sUsuarioDbid")})
public class EEmpresa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "dbid_")
    private Integer dbid;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "logo")
    private String logo;
    @Column(name = "contacto")
    private String contacto;
    @Basic(optional = false)
    @Column(name = "s_usuario_dbid_")
    private int sUsuarioDbid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa")
    private List<EPlaza> ePlazaList;
    @JoinColumn(name = "dueno", referencedColumnName = "dbid_")
    @ManyToOne(optional = false)
    private SUsuario dueno;
    @OneToMany(mappedBy = "empresa")
    private List<EPruebaPsicometrica> ePruebaPsicometricaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa")
    private List<EEmpresaUsuario> eEmpresaUsuarioList;

    public EEmpresa() {
    }

    public EEmpresa(Integer dbid) {
        this.dbid = dbid;
    }

    public EEmpresa(Integer dbid, int sUsuarioDbid) {
        this.dbid = dbid;
        this.sUsuarioDbid = sUsuarioDbid;
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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public int getSUsuarioDbid() {
        return sUsuarioDbid;
    }

    public void setSUsuarioDbid(int sUsuarioDbid) {
        this.sUsuarioDbid = sUsuarioDbid;
    }

    @XmlTransient
    public List<EPlaza> getEPlazaList() {
        return ePlazaList;
    }

    public void setEPlazaList(List<EPlaza> ePlazaList) {
        this.ePlazaList = ePlazaList;
    }

    public SUsuario getDueno() {
        return dueno;
    }

    public void setDueno(SUsuario dueno) {
        this.dueno = dueno;
    }

    @XmlTransient
    public List<EPruebaPsicometrica> getEPruebaPsicometricaList() {
        return ePruebaPsicometricaList;
    }

    public void setEPruebaPsicometricaList(List<EPruebaPsicometrica> ePruebaPsicometricaList) {
        this.ePruebaPsicometricaList = ePruebaPsicometricaList;
    }

    @XmlTransient
    public List<EEmpresaUsuario> getEEmpresaUsuarioList() {
        return eEmpresaUsuarioList;
    }

    public void setEEmpresaUsuarioList(List<EEmpresaUsuario> eEmpresaUsuarioList) {
        this.eEmpresaUsuarioList = eEmpresaUsuarioList;
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
        if (!(object instanceof EEmpresa)) {
            return false;
        }
        EEmpresa other = (EEmpresa) object;
        if ((this.dbid == null && other.dbid != null) || (this.dbid != null && !this.dbid.equals(other.dbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.com.entrevideo.modelo.EEmpresa[ dbid=" + dbid + " ]";
    }
    
}
