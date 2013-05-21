/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.entrevideo.web.backend.cv.habilidades;

import gt.com.entrevideo.component.autocomplete.AutocompleteBeanUI;
import gt.com.entrevideo.component.autocomplete.AutocompleteElement;
import gt.com.entrevideo.modelo.ESkill;
import gt.com.entrevideo.web.backend.session.SessionUI;
import gt.com.entrevideo.web.util.FacesContextUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author garfenter
 */
@SessionScoped
@ManagedBean(name = "habilidadesUI")
public class HabilidadesUI implements Serializable{
    
    
    
    private String habilidad;
    private List<String> habilidades;
    SessionUI session;        
    
    @PostConstruct
    public void init(){
        AutocompleteBeanUI autocomplete;
        autocomplete = (AutocompleteBeanUI) FacesContextUtil.getObjectFromApplicationMap("autocompleteUI");
        autocomplete.getAutocompleteTipoByNombre("habilidad");
        session = (SessionUI) FacesContextUtil.getObjectFromELContext("#{sessionUI}", SessionUI.class);
    }
    public String getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }
    public List<AutocompleteElement> complete(String query){
        AutocompleteBeanUI autocomplete;
        autocomplete = (AutocompleteBeanUI) FacesContextUtil.getObjectFromApplicationMap("autocompleteUI");
        return autocomplete.getAutocompleteTipoByNombre("habilidad").complete(query);
    }    
    
    public List<String> getHabilidades() {
        if(habilidades == null){
            habilidades = new ArrayList<String>();
            habilidades = convertToHabilidades(session.getEntrevideoService().findSkillsByEmail(session.getLoggedUser()));
        }
        return habilidades;
    }
    
    public void agregarHabilidad(){
        getHabilidades().add(getHabilidad());
        ESkill skill = new ESkill();
        skill.setEmail(session.getLoggedUser());
        skill.setSkill(getHabilidad());
        skill.setId(session.getLoggedUser().concat(String.valueOf(getHabilidades().size() - 1)));
        session.getEntrevideoService().persistSkill(skill);
        habilidad = null;
    }
    public void removerHabilidad(int i){
        getHabilidades().remove(i);        
        ESkill skill = new ESkill();
        skill.setEmail(session.getLoggedUser());
        skill.setSkill(getHabilidad());
        skill.setId(session.getLoggedUser().concat(String.valueOf(i)));
        session.getEntrevideoService().deleteSkill(skill);
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    private List<String> convertToHabilidades(List<ESkill> skills) {
        List<String> result = new ArrayList<String>();
        for(ESkill skill: skills){
            result.add(skill.getSkill());
        }
        return result;
    }
    
    
}
