package gt.com.entrevideo.svc.modelo;

import java.util.List;

/**
 *
 * @author garfenter
 */
public class ListValueElement {
    private String listName;
    private String value;
    private Long popularity;
    private List<String> synonymous;

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<String> getSynonymous() {
        return synonymous;
    }

    public void setSynonymous(List<String> synonymous) {
        this.synonymous = synonymous;
    }

    public Long getPopularity() {
        return popularity;
    }

    public void setPopularity(Long popularity) {
        this.popularity = popularity;
    }
    
  
    
    
}
