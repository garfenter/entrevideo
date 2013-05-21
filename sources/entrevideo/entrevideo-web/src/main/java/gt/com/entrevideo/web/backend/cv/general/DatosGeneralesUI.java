package gt.com.entrevideo.web.backend.cv.general;

import gt.com.entrevideo.component.model.UploadBlobFile;
import gt.com.entrevideo.modelo.EProfile;
import gt.com.entrevideo.web.backend.session.SessionUI;
import gt.com.entrevideo.web.util.FacesContextUtil;
import java.io.Serializable;
import javax.annotation.PostConstruct;
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
    private EProfile profile;
    
    SessionUI session;
    
    @PostConstruct
    public void init(){
        session = (SessionUI) FacesContextUtil.getObjectFromELContext("#{sessionUI}", SessionUI.class);
    }
    
    private UploadBlobFile foto;
    
    public String getNombre() {
        return getProfile().getName();
    }

    public void setNombre(String nombre) {
        getProfile().setName(nombre);
    }

    public String getApellido() {
        return getProfile().getLastName();
    }

    public void setApellido(String apellido) {
        getProfile().setLastName(apellido);
    }

    public String getDireccion() {
        return getProfile().getAddress();
    }

    public void setDireccion(String direccion) {
        getProfile().setAddress(direccion);
    }

    public String getTelefono() {
        return getProfile().getPhone();
    }

    public void setTelefono(String telefono) {
        getProfile().setPhone(telefono);
    }

    public String getCorreoElectronico() {
        return getProfile().getEmail();
    }

    public void setCorreoElectronico(String correoElectronico) {
        getProfile().setEmail(correoElectronico);
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
    
    public void initValues(){
        
    }

    public EProfile getProfile() {
        if(profile == null && session.getLoggedUser()!= null && !session.getLoggedUser().isEmpty()){
            String email = session.getLoggedUser();
            profile = session.getEntrevideoService().findProfileByEmail(email);
        }
        return profile;
    }

    public void setProfile(EProfile profile) {
        this.profile = profile;
    }
    
    
    
}
