
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
@NamedQueries
({
    @NamedQuery(name = "SValuesList.findByName", query = "SELECT s FROM SValuesList s WHERE s.name = :name")
})
public class SValuesList implements Serializable{
    @Id
    private String name;
    private String description;      
    private List<String> values; 
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }
    
    
}
