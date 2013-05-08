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
@Table(name = "s_lista_valores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SListaValores.findAll", query = "SELECT s FROM SListaValores s"),
    @NamedQuery(name = "SListaValores.findByDbid", query = "SELECT s FROM SListaValores s WHERE s.dbid = :dbid"),
    @NamedQuery(name = "SListaValores.findByCodigo", query = "SELECT s FROM SListaValores s WHERE s.codigo = :codigo"),
    @NamedQuery(name = "SListaValores.findByNombre", query = "SELECT s FROM SListaValores s WHERE s.nombre = :nombre"),
    @NamedQuery(name = "SListaValores.findByDescripcion", query = "SELECT s FROM SListaValores s WHERE s.descripcion = :descripcion"),
    @NamedQuery(name = "SListaValores.findByImagen", query = "SELECT s FROM SListaValores s WHERE s.imagen = :imagen"),
    @NamedQuery(name = "SListaValores.findByEstado", query = "SELECT s FROM SListaValores s WHERE s.estado = :estado"),
    @NamedQuery(name = "SListaValores.findByFechaActivacion", query = "SELECT s FROM SListaValores s WHERE s.fechaActivacion = :fechaActivacion")})
public class SListaValores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "dbid_")
    private Integer dbid;
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "imagen")
    private String imagen;
    @Column(name = "estado")
    private String estado;
    @Column(name = "fecha_activacion")
    private String fechaActivacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "listaValores")
    private List<SSinonimo> sSinonimoList;
    @JoinColumn(name = "usuario_activo", referencedColumnName = "dbid_")
    @ManyToOne(optional = false)
    private SUsuario usuarioActivo;
    @JoinColumn(name = "tipo_lista", referencedColumnName = "dbid_")
    @ManyToOne(optional = false)
    private STipoLista tipoLista;

    public SListaValores() {
    }

    public SListaValores(Integer dbid) {
        this.dbid = dbid;
    }

    public Integer getDbid() {
        return dbid;
    }

    public void setDbid(Integer dbid) {
        this.dbid = dbid;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaActivacion() {
        return fechaActivacion;
    }

    public void setFechaActivacion(String fechaActivacion) {
        this.fechaActivacion = fechaActivacion;
    }

    @XmlTransient
    public List<SSinonimo> getSSinonimoList() {
        return sSinonimoList;
    }

    public void setSSinonimoList(List<SSinonimo> sSinonimoList) {
        this.sSinonimoList = sSinonimoList;
    }

    public SUsuario getUsuarioActivo() {
        return usuarioActivo;
    }

    public void setUsuarioActivo(SUsuario usuarioActivo) {
        this.usuarioActivo = usuarioActivo;
    }

    public STipoLista getTipoLista() {
        return tipoLista;
    }

    public void setTipoLista(STipoLista tipoLista) {
        this.tipoLista = tipoLista;
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
        if (!(object instanceof SListaValores)) {
            return false;
        }
        SListaValores other = (SListaValores) object;
        if ((this.dbid == null && other.dbid != null) || (this.dbid != null && !this.dbid.equals(other.dbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
    
}
