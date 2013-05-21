package gt.com.entrevideo.web.backend.session;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.jpa.JpaPersistModule;
import gt.com.entrevideo.guice.config.EntrevideoDaoModule;
import gt.com.entrevideo.guice.config.EntrevideoServiceModule;
import gt.com.entrevideo.svc.EntrevideoService;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author garfenter
 */
@ManagedBean(name = "sessionUI")
@SessionScoped
public class SessionUI implements Serializable {       
    private String firstName;
    private String lastName;
    private String gender;
    private String id;
    
    
    
    @PostConstruct
    public void init(){
        
    }
    
    public String getLoggedUser() {
        javax.servlet.http.Cookie userId = (javax.servlet.http.Cookie) FacesContext.getCurrentInstance().getExternalContext().getRequestCookieMap().get("ENV_US");          
        return userId.getValue();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }            

    public EntrevideoService getEntrevideoService() {
        EntrevideoService entrevideoService;
        Injector injector = Guice.createInjector(new EntrevideoDaoModule(), new EntrevideoServiceModule(), new JpaPersistModule("entrevideo-pu"));
        entrevideoService = injector.getInstance(EntrevideoService.class);
        return entrevideoService;
    }    
  
}
