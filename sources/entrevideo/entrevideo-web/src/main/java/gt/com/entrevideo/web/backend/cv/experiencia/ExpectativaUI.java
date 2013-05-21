package gt.com.entrevideo.web.backend.cv.experiencia;

import gt.com.entrevideo.component.autocomplete.AutocompleteBeanUI;
import gt.com.entrevideo.modelo.EExpectation;
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
@Named("expectativaUI")
public class ExpectativaUI implements Serializable {

    private List<Expectativa> expectativas;
    private Expectativa expectativa;
    SessionUI session;

    @PostConstruct
    public void init() {          
        session = (SessionUI) FacesContextUtil.getObjectFromELContext("#{sessionUI}", SessionUI.class);
    }

    public void agregarExpectativa() {
        getExpectativas().add(getExpectativa());
        EExpectation expectation = new EExpectation();
        expectation.setBussinessArea(getExpectativa().getAreaInteres());
        expectation.setEmployment(getExpectativa().getPuesto());
        expectation.setSalary(getExpectativa().getSalarioEsperado());
        expectation.setId(session.getLoggedUser().concat(String.valueOf(getExpectativas().size() - 1)));
        expectation.setEmail(session.getLoggedUser());
        session.getEntrevideoService().persistExpectation(expectation);
        expectativa = null;
    }

    public void eliminarExpectativa(int i) {
        getExpectativas().remove(i);
        EExpectation expectation = new EExpectation();
        expectation.setId(session.getLoggedUser().concat(String.valueOf(i)));
        session.getEntrevideoService().deleteExpectation(expectation);
    }

    public Expectativa getExpectativa() {
        if (expectativa == null) {
            expectativa = new Expectativa();
        }
        return expectativa;
    }

    public void setExpectativa(Expectativa expectativa) {
        this.expectativa = expectativa;
    }

    public List<Expectativa> getExpectativas() {
        if (expectativas == null) {
            expectativas = new ArrayList<Expectativa>();
            expectativas = convertToExpectativas(session.getEntrevideoService().findExpectationByEmail(session.getLoggedUser()));
        }
        return expectativas;
    }

    public void setExpectativas(List<Expectativa> expectativas) {
        this.expectativas = expectativas;
    }

    private List<Expectativa> convertToExpectativas(List<EExpectation> expectations) {
        List<Expectativa> result = new ArrayList<Expectativa>();
        for(EExpectation expectation:expectations){
            Expectativa exp = new Expectativa();
            exp.setAreaInteres(expectation.getBussinessArea());
            exp.setPuesto(expectation.getEmployment());
            exp.setSalarioEsperado(expectation.getSalary());
            result.add(exp);
        }        
        return result;
    }
}
