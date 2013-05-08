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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "e_persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EPersona.findAll", query = "SELECT e FROM EPersona e"),
    @NamedQuery(name = "EPersona.findByDbid", query = "SELECT e FROM EPersona e WHERE e.dbid = :dbid"),
    @NamedQuery(name = "EPersona.findByNombre", query = "SELECT e FROM EPersona e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "EPersona.findByApellido", query = "SELECT e FROM EPersona e WHERE e.apellido = :apellido"),
    @NamedQuery(name = "EPersona.findByFechaNacimiento", query = "SELECT e FROM EPersona e WHERE e.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "EPersona.findBySexo", query = "SELECT e FROM EPersona e WHERE e.sexo = :sexo"),
    @NamedQuery(name = "EPersona.findByPaisOrigen", query = "SELECT e FROM EPersona e WHERE e.paisOrigen = :paisOrigen")})
public class EPersona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dbid_")
    private Integer dbid;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "fecha_nacimiento")
    private String fechaNacimiento;
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "pais_origen")
    private String paisOrigen;
    @JoinColumn(name = "usuario", referencedColumnName = "dbid_")
    @ManyToOne(optional = false)
    private SUsuario usuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ePersonaDbid")
    private List<EResultadoPrueba> eResultadoPruebaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
    private List<EDireccion> eDireccionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
    private List<ETelefono> eTelefonoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
    private List<ECurriculum> eCurriculumList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
    private List<EVideo> eVideoList;

    public EPersona() {
    }

    public EPersona(Integer dbid) {
        this.dbid = dbid;
    }

    public EPersona(Integer dbid, String nombre, String apellido) {
        this.dbid = dbid;
        this.nombre = nombre;
        this.apellido = apellido;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public SUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(SUsuario usuario) {
        this.usuario = usuario;
    }

    @XmlTransient
    public List<EResultadoPrueba> getEResultadoPruebaList() {
        return eResultadoPruebaList;
    }

    public void setEResultadoPruebaList(List<EResultadoPrueba> eResultadoPruebaList) {
        this.eResultadoPruebaList = eResultadoPruebaList;
    }

    @XmlTransient
    public List<EDireccion> getEDireccionList() {
        return eDireccionList;
    }

    public void setEDireccionList(List<EDireccion> eDireccionList) {
        this.eDireccionList = eDireccionList;
    }

    @XmlTransient
    public List<ETelefono> getETelefonoList() {
        return eTelefonoList;
    }

    public void setETelefonoList(List<ETelefono> eTelefonoList) {
        this.eTelefonoList = eTelefonoList;
    }

    @XmlTransient
    public List<ECurriculum> getECurriculumList() {
        return eCurriculumList;
    }

    public void setECurriculumList(List<ECurriculum> eCurriculumList) {
        this.eCurriculumList = eCurriculumList;
    }

    @XmlTransient
    public List<EVideo> getEVideoList() {
        return eVideoList;
    }

    public void setEVideoList(List<EVideo> eVideoList) {
        this.eVideoList = eVideoList;
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
        if (!(object instanceof EPersona)) {
            return false;
        }
        EPersona other = (EPersona) object;
        if ((this.dbid == null && other.dbid != null) || (this.dbid != null && !this.dbid.equals(other.dbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.com.entrevideo.modelo.EPersona[ dbid=" + dbid + " ]";
    }
    
}
