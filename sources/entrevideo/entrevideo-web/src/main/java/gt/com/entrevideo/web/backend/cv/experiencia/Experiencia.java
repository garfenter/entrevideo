package gt.com.entrevideo.web.backend.cv.experiencia;

import java.io.Serializable;

/**
 *
 * @author garfenter
 */
public class Experiencia implements Serializable {
    private String areaNegocio;
    private String puesto;
    private Integer anios;

    public String getAreaNegocio() {
        return areaNegocio;
    }

    public void setAreaNegocio(String areaNegocio) {
        this.areaNegocio = areaNegocio;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public Integer getAnios() {
        return anios;
    }

    public void setAnios(Integer anios) {
        this.anios = anios;
    }
    
    
}
