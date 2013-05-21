package gt.com.entrevideo.modelo;

import java.io.Serializable;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Persistent;
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
    @NamedQuery(name = "ESkill.findByEmail", query = "SELECT s FROM ESkill s WHERE s.email = :email")
})
public class ESkill implements Serializable {
    @Id
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private String id;    
    private String email;
    private String skill;
    private String synonymous;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getSynonymous() {
        return synonymous;
    }

    public void setSynonymous(String synonymous) {
        this.synonymous = synonymous;
    }
    
    
}
