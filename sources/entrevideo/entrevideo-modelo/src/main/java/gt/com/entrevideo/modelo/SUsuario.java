/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.entrevideo.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author garfenter
 */
@Entity
@Table(name = "s_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SUsuario.findAll", query = "SELECT s FROM SUsuario s"),
    @NamedQuery(name = "SUsuario.findByDbid", query = "SELECT s FROM SUsuario s WHERE s.dbid = :dbid"),
    @NamedQuery(name = "SUsuario.findByEmail", query = "SELECT s FROM SUsuario s WHERE s.email = :email"),
    @NamedQuery(name = "SUsuario.findByEstado", query = "SELECT s FROM SUsuario s WHERE s.estado = :estado"),
    @NamedQuery(name = "SUsuario.findByFechaActivacion", query = "SELECT s FROM SUsuario s WHERE s.fechaActivacion = :fechaActivacion")})
public class SUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dbid_")
    private Integer dbid;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @Column(name = "fecha_activacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActivacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<EPersona> ePersonaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<SRolUsuario> sRolUsuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dueno")
    private List<EEmpresa> eEmpresaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioActivo")
    private List<SListaValores> sListaValoresList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sUsuarioDbid")
    private List<SUsuarioNotificacion> sUsuarioNotificacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<SBitacoraUsuario> sBitacoraUsuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<EEmpresaUsuario> eEmpresaUsuarioList;

    public SUsuario() {
    }

    public SUsuario(Integer dbid) {
        this.dbid = dbid;
    }

    public SUsuario(Integer dbid, String email, String estado, Date fechaActivacion) {
        this.dbid = dbid;
        this.email = email;
        this.estado = estado;
        this.fechaActivacion = fechaActivacion;
    }

    public Integer getDbid() {
        return dbid;
    }

    public void setDbid(Integer dbid) {
        this.dbid = dbid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaActivacion() {
        return fechaActivacion;
    }

    public void setFechaActivacion(Date fechaActivacion) {
        this.fechaActivacion = fechaActivacion;
    }

    @XmlTransient
    public List<EPersona> getEPersonaList() {
        return ePersonaList;
    }

    public void setEPersonaList(List<EPersona> ePersonaList) {
        this.ePersonaList = ePersonaList;
    }

    @XmlTransient
    public List<SRolUsuario> getSRolUsuarioList() {
        return sRolUsuarioList;
    }

    public void setSRolUsuarioList(List<SRolUsuario> sRolUsuarioList) {
        this.sRolUsuarioList = sRolUsuarioList;
    }

    @XmlTransient
    public List<EEmpresa> getEEmpresaList() {
        return eEmpresaList;
    }

    public void setEEmpresaList(List<EEmpresa> eEmpresaList) {
        this.eEmpresaList = eEmpresaList;
    }

    @XmlTransient
    public List<SListaValores> getSListaValoresList() {
        return sListaValoresList;
    }

    public void setSListaValoresList(List<SListaValores> sListaValoresList) {
        this.sListaValoresList = sListaValoresList;
    }

    @XmlTransient
    public List<SUsuarioNotificacion> getSUsuarioNotificacionList() {
        return sUsuarioNotificacionList;
    }

    public void setSUsuarioNotificacionList(List<SUsuarioNotificacion> sUsuarioNotificacionList) {
        this.sUsuarioNotificacionList = sUsuarioNotificacionList;
    }

    @XmlTransient
    public List<SBitacoraUsuario> getSBitacoraUsuarioList() {
        return sBitacoraUsuarioList;
    }

    public void setSBitacoraUsuarioList(List<SBitacoraUsuario> sBitacoraUsuarioList) {
        this.sBitacoraUsuarioList = sBitacoraUsuarioList;
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
        if (!(object instanceof SUsuario)) {
            return false;
        }
        SUsuario other = (SUsuario) object;
        if ((this.dbid == null && other.dbid != null) || (this.dbid != null && !this.dbid.equals(other.dbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.com.entrevideo.modelo.SUsuario[ dbid=" + dbid + " ]";
    }
    
}
