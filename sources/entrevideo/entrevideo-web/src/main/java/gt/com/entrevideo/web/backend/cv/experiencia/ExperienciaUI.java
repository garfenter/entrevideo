package gt.com.entrevideo.web.backend.cv.experiencia;

import gt.com.entrevideo.component.autocomplete.AutocompleteBeanUI;
import gt.com.entrevideo.modelo.SListaValores;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
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
    @Inject
    AutocompleteBeanUI autocomplete;

    public ExperienciaUI() {
        
    }
    @PostConstruct
    public void init(){
        autocomplete.getAutocompleteTipoByNombre("areaNegocio");
        autocomplete.getAutocompleteTipoByNombre("puesto");
    }
    
    public List<SListaValores> completeAreaNegocio(String query) {
        return autocomplete.getAutocompleteTipoByNombre("areaNegocio").complete(query);
    }

    public List<SListaValores> completePuesto(String query) {
        return autocomplete.getAutocompleteTipoByNombre("puesto").complete(query);
    }
    
    public void agregarExperiencia() {
        getExperiencias().add(getExperiencia());
        experiencia = null;
    }

    public void eliminarExperiencia(int i) {
        getExperiencias().remove(i);
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
        }
        return experiencias;
    }

    public void setExperiencias(List<Experiencia> experiencias) {
        this.experiencias = experiencias;
    }
}
