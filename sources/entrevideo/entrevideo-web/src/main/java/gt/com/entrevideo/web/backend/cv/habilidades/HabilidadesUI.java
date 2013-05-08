/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.entrevideo.web.backend.cv.habilidades;

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
@Named("habilidadesUI")
public class HabilidadesUI implements Serializable{
    
    @Inject
    AutocompleteBeanUI autocomplete;
    private String habilidad;
    private List<String> habilidades;
    
    @PostConstruct
    public void init(){
        autocomplete.getAutocompleteTipoByNombre("habilidad");
    }
    public String getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }
    public List<SListaValores> complete(String query){
        return autocomplete.getAutocompleteTipoByNombre("habilidad").complete(query);
    }    
    
    public List<String> completeStr(String query){
        List<SListaValores> valores = autocomplete.getAutocompleteTipoByNombre("habilidad").complete(query);
        List<String> result = new ArrayList<String>();
        for(SListaValores valor:valores){
            result.add(valor.getNombre());
        }
        return result;
    }

    public List<String> getHabilidades() {
        if(habilidades == null){
            habilidades = new ArrayList<String>();
        }
        return habilidades;
    }
    
    public void agregarHabilidad(){
        getHabilidades().add(getHabilidad());
    }
    public void removerHabilidad(int i){
        getHabilidades().remove(i);
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }
    
    
}
