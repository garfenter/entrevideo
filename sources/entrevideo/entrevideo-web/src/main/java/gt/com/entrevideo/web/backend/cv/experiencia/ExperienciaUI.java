package gt.com.entrevideo.web.backend.cv.experiencia;

import gt.com.entrevideo.component.autocomplete.AutocompleteBeanUI;
import gt.com.entrevideo.component.autocomplete.AutocompleteElement;
import gt.com.entrevideo.modelo.EExperience;
import gt.com.entrevideo.web.backend.session.SessionUI;
import gt.com.entrevideo.web.util.FacesContextUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author garfenter
 */
@SessionScoped
@Named("experienciaUI")
public class ExperienciaUI implements Serializable {

    private List<Experiencia> experiencias;
    private Experiencia experiencia;    
    SessionUI session;

    public ExperienciaUI() {
        
    }
    @PostConstruct
    public void init(){
        AutocompleteBeanUI autocomplete;
        autocomplete = (AutocompleteBeanUI) FacesContextUtil.getObjectFromApplicationMap("autocompleteUI");
        autocomplete.getAutocompleteTipoByNombre("areaNegocio");
        autocomplete.getAutocompleteTipoByNombre("puesto");
        session = (SessionUI) FacesContextUtil.getObjectFromELContext("#{sessionUI}", SessionUI.class);
    }
    
    public List<AutocompleteElement> completeAreaNegocio(String query) {
        AutocompleteBeanUI autocomplete;
        autocomplete = (AutocompleteBeanUI) FacesContextUtil.getObjectFromApplicationMap("autocompleteUI");
        return autocomplete.getAutocompleteTipoByNombre("areaNegocio").complete(query);
    }

    public List<AutocompleteElement> completePuesto(String query) {
        AutocompleteBeanUI autocomplete;
        autocomplete = (AutocompleteBeanUI) FacesContextUtil.getObjectFromApplicationMap("autocompleteUI");
        return autocomplete.getAutocompleteTipoByNombre("puesto").complete(query);
    }
    
    public void agregarExperiencia() {
        getExperiencias().add(getExperiencia());
        EExperience experience = new EExperience();
        experience.setBussinessArea(getExperiencia().getAreaNegocio());
        experience.setEmployment(getExperiencia().getPuesto());
        experience.setEnterprise(getExperiencia().getEmpresa());
        experience.setYears(getExperiencia().getAnios());
        experience.setEmail(session.getLoggedUser());
        experience.setId(session.getLoggedUser().concat(String.valueOf(getExperiencias().size()-1)));
        session.getEntrevideoService().persistExperience(experience);
        experiencia = null;
    }

    public void eliminarExperiencia(int i) {
        getExperiencias().remove(i);
        EExperience experience = new EExperience();
        experience.setId(session.getLoggedUser().concat(String.valueOf(i)));
        session.getEntrevideoService().deleteExperience(experience);        
    }

    public Experiencia getExperiencia() {
        if (experiencia == null) {
            experiencia = new Experiencia();
        }
        return experiencia;
    }

    public void setExperiencia(Experiencia experiencia) {
        this.experiencia = experiencia;
    }

    public List<Experiencia> getExperiencias() {
        if (experiencias == null) {
            experiencias = new ArrayList<Experiencia>();
            experiencias = convertToExperiencias(session.getEntrevideoService().findExperiencesByEmail(session.getLoggedUser()));
        }
        return experiencias;
    }

    public void setExperiencias(List<Experiencia> experiencias) {
        this.experiencias = experiencias;
    }

    private List<Experiencia> convertToExperiencias(List<EExperience> experiences) {
        List<Experiencia> result = new ArrayList<Experiencia>();
        for(EExperience experience: experiences){
            Experiencia exp = new Experiencia();
            exp.setAnios(experience.getYears());
            exp.setAreaNegocio(experience.getBussinessArea());
            exp.setEmpresa(experience.getEnterprise());
            exp.setPuesto(experience.getEmployment());
            result.add(exp);
        }
        return result;
    }
}
