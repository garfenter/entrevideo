package gt.com.entrevideo.web.backend.session;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author garfenter
 */
@Named("sessionUI")
@SessionScoped
public class SessionUI implements Serializable {       
    public String getLoggedUser() {
        String userId = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();       
        return userId;
    }
  
}
