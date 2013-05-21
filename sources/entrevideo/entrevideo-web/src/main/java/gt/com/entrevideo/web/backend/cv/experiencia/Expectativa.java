package gt.com.entrevideo.web.backend.cv.experiencia;

import java.io.Serializable;

/**
 *
 * @author garfenter
 */
public class Expectativa implements Serializable{
    private String areaInteres;
    private String puesto;
    private String salarioEsperado;

    public String getAreaInteres() {
        return areaInteres;
    }

    public void setAreaInteres(String areaInteres) {
        this.areaInteres = areaInteres;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getSalarioEsperado() {
        return salarioEsperado;
    }

    public void setSalarioEsperado(String salarioEsperado) {
        this.salarioEsperado = salarioEsperado;
    }
    
    
}
