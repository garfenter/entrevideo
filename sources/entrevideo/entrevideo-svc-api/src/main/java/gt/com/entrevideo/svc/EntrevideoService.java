package gt.com.entrevideo.svc;

import com.google.appengine.api.search.Results;
import com.google.appengine.api.search.ScoredDocument;
import gt.com.entrevideo.modelo.EExpectation;
import gt.com.entrevideo.modelo.EExperience;
import gt.com.entrevideo.modelo.EProfile;
import gt.com.entrevideo.modelo.ESkill;
import java.util.List;

/**
 *
 * @author garfenter
 */
public interface EntrevideoService {
    public EProfile findProfileByEmail(String email);
    public List<EExpectation> findExpectationByEmail(String email);
    public List<EExperience> findExperiencesByEmail(String email);
    public List<ESkill> findSkillsByEmail(String email);
    public void persistProfile(EProfile profile);
    public void persistExperience(EExperience experience);
    public void persistSkill(ESkill skill);
    public void persistExpectation(EExpectation expection);
    public void deleteExpectation(EExpectation expectation);
    public void deleteSkill(ESkill skill);
    public void deleteExperience(EExperience experience);
    public Results<ScoredDocument> findContactsByQuery(String query);
}
