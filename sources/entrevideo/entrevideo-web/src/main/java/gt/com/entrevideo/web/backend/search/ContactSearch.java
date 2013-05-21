package gt.com.entrevideo.web.backend.search;

import com.google.appengine.api.search.ScoredDocument;
import gt.com.entrevideo.component.autocomplete.AutocompleteBeanUI;
import gt.com.entrevideo.modelo.EProfile;
import gt.com.entrevideo.web.backend.session.SessionUI;
import gt.com.entrevideo.web.util.FacesContextUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;

import javax.inject.Named;

/**
 *
 * @author garfenter
 */
@SessionScoped
@Named("contactSearchUI")
public class ContactSearch implements Serializable{
    private List<EProfile> profiles;
    SessionUI session;        
    private String query;
    
    @PostConstruct
    public void init(){
        session = (SessionUI) FacesContextUtil.getObjectFromELContext("#{sessionUI}", SessionUI.class);    
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
    
    
    
    public List<EProfile> find(){
        Map<String, EProfile> mProfiles = new HashMap<String, EProfile>();
        List<EProfile> result = new ArrayList<EProfile>();
        for(ScoredDocument document:session.getEntrevideoService().findContactsByQuery(getQuery())){
            String email = document.getFields("email").iterator().next().getText();
            if(!mProfiles.containsKey(email)){
                EProfile profile = session.getEntrevideoService().findProfileByEmail(email);
                mProfiles.put(email, profile);
                result.add(profile);
            }
        }
        return result;
    }
    
    public List<EProfile> getProfiles(){
        return profiles;    
    }
    public void search(){
        profiles = find();
    }
    
}
