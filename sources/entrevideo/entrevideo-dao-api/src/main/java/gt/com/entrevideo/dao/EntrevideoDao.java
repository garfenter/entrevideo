package gt.com.entrevideo.dao;

import gt.com.entrevideo.modelo.EExpectation;
import gt.com.entrevideo.modelo.EExperience;
import gt.com.entrevideo.modelo.EProfile;
import gt.com.entrevideo.modelo.ESkill;
import gt.com.entrevideo.modelo.SValue;
import gt.com.entrevideo.modelo.SValuesList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author garfenter
 */
public interface EntrevideoDao {
    //System
    public List<SValuesList> findListValuesByListName(String name);
    public List<SValue> findListValueElementsByListName(String listName);    
    //Bussines
    public EProfile findProfileByEmail(String email);
    public List<EExperience> findExperiencesByEmail(String email);
    public List<ESkill> findSkillsByEmail(String email);
    public List<EExpectation> findExpectationsByEmail(String email);
    
    public void persist(Object object);
    public void detach(Object object);
    public EntityManager getEntityManager();
}
