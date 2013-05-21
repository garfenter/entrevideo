/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.entrevideo.web.backend.profile;

import gt.com.entrevideo.component.model.UploadBlobFile;
import gt.com.entrevideo.modelo.EExpectation;
import gt.com.entrevideo.modelo.EExperience;
import gt.com.entrevideo.modelo.EProfile;
import gt.com.entrevideo.modelo.ESkill;
import gt.com.entrevideo.web.backend.cv.experiencia.Expectativa;
import gt.com.entrevideo.web.backend.cv.experiencia.Experiencia;
import gt.com.entrevideo.web.backend.session.SessionUI;
import gt.com.entrevideo.web.util.FacesContextUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author garfenter
 */
@SessionScoped
@Named("profileUI")
public class ProfileUI implements Serializable {

    private EProfile profile;
    private List<String> habilidades;
    private List<Experiencia> experiencias;
    private List<Expectativa> expectativas;
    private String email;
    SessionUI session;

    @PostConstruct
    public void init() {
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
        if (foto == null) {
            foto = new UploadBlobFile();
        }
        return foto;
    }

    public void setFoto(UploadBlobFile foto) {
        this.foto = foto;
    }

    public void initValues() {
        if (!FacesContext.getCurrentInstance().isPostback()) {
            profile = null;
            expectativas = null;
            habilidades = null;
            experiencias = null;
        }
    }

    public EProfile getProfile() {
        if (profile == null && session.getLoggedUser() != null && !session.getLoggedUser().isEmpty()) {
            profile = session.getEntrevideoService().findProfileByEmail(getEmail());
        }
        return profile;
    }

    public void setProfile(EProfile profile) {
        this.profile = profile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getHabilidades() {
        if (habilidades == null) {
            habilidades = new ArrayList<String>();
            habilidades = convertToHabilidades(session.getEntrevideoService().findSkillsByEmail(getEmail()));
        }
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    private List<String> convertToHabilidades(List<ESkill> skills) {
        List<String> result = new ArrayList<String>();
        for (ESkill skill : skills) {
            result.add(skill.getSkill());
        }
        return result;
    }

    public List<Experiencia> getExperiencias() {
        if (experiencias == null) {
            experiencias = new ArrayList<Experiencia>();
            experiencias = convertToExperiencias(session.getEntrevideoService().findExperiencesByEmail(getEmail()));
        }
        return experiencias;
    }

    public void setExperiencias(List<Experiencia> experiencias) {
        this.experiencias = experiencias;
    }

    private List<Experiencia> convertToExperiencias(List<EExperience> experiences) {
        List<Experiencia> result = new ArrayList<Experiencia>();
        for (EExperience experience : experiences) {
            Experiencia exp = new Experiencia();
            exp.setAnios(experience.getYears());
            exp.setAreaNegocio(experience.getBussinessArea());
            exp.setEmpresa(experience.getEnterprise());
            exp.setPuesto(experience.getEmployment());
            result.add(exp);
        }
        return result;
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
        for (EExpectation expectation : expectations) {
            Expectativa exp = new Expectativa();
            exp.setAreaInteres(expectation.getBussinessArea());
            exp.setPuesto(expectation.getEmployment());
            exp.setSalarioEsperado(expectation.getSalary());
            result.add(exp);
        }
        return result;
    }
}
