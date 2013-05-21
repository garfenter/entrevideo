package gt.com.entrevideo;

import com.google.inject.Inject;
import com.google.inject.persist.PersistService;
import gt.com.entrevideo.dao.EntrevideoDao;
import gt.com.entrevideo.modelo.EExpectation;
import gt.com.entrevideo.modelo.EExperience;
import gt.com.entrevideo.modelo.EProfile;
import gt.com.entrevideo.modelo.ESkill;
import gt.com.entrevideo.modelo.SValue;
import gt.com.entrevideo.modelo.SValuesList;
import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author garfenter
 */
public class EntrevideoDaoImpl implements EntrevideoDao, Serializable{
    @Inject
    EntityManager em;           
    @Inject
    public EntrevideoDaoImpl(PersistService service){
        service.start();
    }
    
    @Override
    public List<SValuesList> findListValuesByListName(String name) {
        Query qry = em.createNamedQuery("SValuesList.findByName");
        qry.setParameter("name", name);        
        return qry.getResultList();
    }

    @Override
    public void persist(Object obj) {
        em.persist(obj);
    }

    @Override
    public List<SValue> findListValueElementsByListName(String listName) {
        Query qry = em.createNamedQuery("SValue.findByListName");
        qry.setParameter("name", listName);
        return qry.getResultList();
    }
    
    
    @Override
    public EProfile findProfileByEmail(String email) {
        return em.find(EProfile.class, email);
    }

    @Override
    public void detach(Object object) {
        em.detach(object);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<EExperience> findExperiencesByEmail(String email) {
        return em.createNamedQuery("EExperience.findByEmail").setParameter("email", email).getResultList();
    }

    @Override
    public List<ESkill> findSkillsByEmail(String email) {
        return em.createNamedQuery("ESkill.findByEmail").setParameter("email", email).getResultList();
    }

    @Override
    public List<EExpectation> findExpectationsByEmail(String email) {
        return em.createNamedQuery("EExpectation.findByEmail").setParameter("email", email).getResultList();
    }
    
}
