package gt.com.entrevideo.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author garfenter
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "SValue.findByListName", query="SELECT l FROM SValue l WHERE l.listName = :name")
})
public class SValue implements Serializable {
    @Id        
    private String value;    
    private String listName;
    private List<String> synonymous;
    private Long popularity;
  

    public Long getPopularity() {
        return popularity;
    }

    public void setPopularity(Long popularity) {
        this.popularity = popularity;
    }
    

    public List<String> getSynonymous() {
        return synonymous;
    }

    public void setSynonymous(List<String> synonymous) {
        this.synonymous = synonymous;
    }    

    public SValue() {
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + (this.value != null ? this.value.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SValue other = (SValue) obj;
        if ((this.value == null) ? (other.value != null) : !this.value.equals(other.value)) {
            return false;
        }
        return true;
    }    
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }
    
    
    
}
