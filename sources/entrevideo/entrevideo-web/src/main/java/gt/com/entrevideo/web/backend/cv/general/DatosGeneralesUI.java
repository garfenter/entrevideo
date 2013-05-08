package gt.com.entrevideo.web.backend.cv.general;

import gt.com.entrevideo.component.model.UploadBlobFile;
import gt.com.entrevideo.web.backend.session.SessionUI;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author garfenter
 */
@Named("datosGeneralesUI")
@SessionScoped
public class DatosGeneralesUI implements Serializable{
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String correoElectronico;
    @Inject
    SessionUI session;
    private UploadBlobFile foto;

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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        if(correoElectronico  == null){
            correoElectronico = session.getLoggedUser();
        }
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public UploadBlobFile getFoto() {
        if(foto == null){
            foto = new UploadBlobFile();
        }
        return foto;
    }

    public void setFoto(UploadBlobFile foto) {
        this.foto = foto;
    }
    
    
}
