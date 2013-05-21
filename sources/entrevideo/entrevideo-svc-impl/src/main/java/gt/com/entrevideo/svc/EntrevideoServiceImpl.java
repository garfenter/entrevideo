package gt.com.entrevideo.svc;

import com.google.appengine.api.search.Document;
import com.google.appengine.api.search.Document.Builder;
import com.google.appengine.api.search.Field;
import com.google.appengine.api.search.Index;
import com.google.appengine.api.search.IndexSpec;
import com.google.appengine.api.search.Results;
import com.google.appengine.api.search.ScoredDocument;
import com.google.appengine.api.search.SearchServiceFactory;
import com.google.inject.Inject;
import com.google.inject.persist.Transactional;
import gt.com.entrevideo.dao.EntrevideoDao;
import gt.com.entrevideo.modelo.EExpectation;
import gt.com.entrevideo.modelo.EExperience;
import gt.com.entrevideo.modelo.EProfile;
import gt.com.entrevideo.modelo.ESkill;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author garfenter
 */
public class EntrevideoServiceImpl implements EntrevideoService, Serializable {

    EntrevideoDao entrevideoDao;

    public Index getIndex() {
        IndexSpec indexSpec = IndexSpec.newBuilder().setName("contacts").build();
        return SearchServiceFactory.getSearchService().getIndex(indexSpec);

    }

    @Inject
    public EntrevideoServiceImpl(EntrevideoDao entrevideoDao) {
        this.entrevideoDao = entrevideoDao;
    }

    @Override
    public EProfile findProfileByEmail(String email) {
        return entrevideoDao.findProfileByEmail(email);
    }

    @Transactional
    @Override
    public void persistProfile(EProfile profile) {
        entrevideoDao.persist(profile);

        
        Builder builder = getDocBuilder(profile.getEmail());
                builder.addField(Field.newBuilder().setName("name").setText(profile.getName()))
                .addField(Field.newBuilder().setName("last_anme").setText(profile.getLastName()))
                .addField(Field.newBuilder().setName("gender").setText(profile.getGender()))
                .addField(Field.newBuilder().setName("sexo").setText(profile.getGender().equalsIgnoreCase("male") ? "Hombre Masculino" : "Mujer Femenino"))
                .addField(Field.newBuilder().setName("address").setText(profile.getAddress()))
                .addField(Field.newBuilder().setName("phone").setText(profile.getPhone()))
                .addField(Field.newBuilder().setName("email").setText(profile.getEmail()));
        Document doc = builder.build();
        getIndex().put(doc);
    }

    @Transactional
    @Override
    public void persistExperience(EExperience experience) {
        entrevideoDao.persist(experience);                
        Builder builder = getDocBuilder(experience.getEmail());
        Document doc = builder.addField(Field.newBuilder().setName("bussinesArea").setText(experience.getBussinessArea()))
                .addField(Field.newBuilder().setName("employment").setText(experience.getEmployment()))
                .addField(Field.newBuilder().setName("enterprise").setText(experience.getEnterprise()))                
                .build();
        getIndex().put(doc);
    }

    @Transactional
    @Override
    public void persistSkill(ESkill skill) {
        entrevideoDao.persist(skill);        
        Builder builder = getDocBuilder(skill.getEmail());
        Document doc = builder.addField(Field.newBuilder().setName("skill").setText(skill.getSkill()))                
                .addField(Field.newBuilder().setName("synonymous").setText(skill.getSynonymous()))
                .build();
        getIndex().put(doc);
    }

    @Transactional
    @Override
    public void persistExpectation(EExpectation expection) {
        entrevideoDao.persist(expection);        
        Builder builder = getDocBuilder(expection.getEmail());
        Document doc = builder.addField(Field.newBuilder().setName("bussinesArea").setText(expection.getBussinessArea()))
                .addField(Field.newBuilder().setName("employment").setText(expection.getEmployment()))
                .addField(Field.newBuilder().setName("salary").setText(expection.getSalary()))                
                .build();
        getIndex().put(doc);
    }

    @Transactional
    @Override
    public void deleteExpectation(EExpectation expectation) {
        expectation = entrevideoDao.getEntityManager().find(EExpectation.class, expectation.getId());
        entrevideoDao.getEntityManager().remove(expectation);        

    }

    @Transactional
    @Override
    public void deleteSkill(ESkill skill) {
        skill = entrevideoDao.getEntityManager().find(ESkill.class, skill.getId());
        entrevideoDao.getEntityManager().remove(skill);        
    }

    @Transactional
    @Override
    public void deleteExperience(EExperience experience) {
        experience = entrevideoDao.getEntityManager().find(EExperience.class, experience.getId());
        entrevideoDao.getEntityManager().remove(experience);        
    }

    @Override
    public List<EExpectation> findExpectationByEmail(String email) {
        return entrevideoDao.findExpectationsByEmail(email);
    }

    @Override
    public List<EExperience> findExperiencesByEmail(String email) {
        return entrevideoDao.findExperiencesByEmail(email);
    }

    @Override
    public List<ESkill> findSkillsByEmail(String email) {
        return entrevideoDao.findSkillsByEmail(email);
    }

    @Override
    public Results<ScoredDocument> findContactsByQuery(String query) {
        Results<ScoredDocument> results = getIndex().search(query);
        return results;
    }

    private Builder getDocBuilder(String id) {
        Document doc = getIndex().get(id);
        Builder builder = Document.newBuilder().setId(id);
        if(doc != null){            
            builder.setId(doc.getId());
            for(Field f:doc.getFields()){
                builder.addField(f);
            }
        }
        return builder;
    }
}
