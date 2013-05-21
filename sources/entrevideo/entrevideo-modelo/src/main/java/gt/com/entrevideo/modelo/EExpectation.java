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
@NamedQueries(
        {
            @NamedQuery(name = "EExpectation.findByEmail", query = "SELECT e FROM EExpectation e WHERE e.email = :email")
        }
)
public class EExpectation implements Serializable {
    @Id
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private String id;    
    private String email;
    private String bussinessArea;
    private String employment;
    private String salary;

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

    public String getBussinessArea() {
        return bussinessArea;
    }

    public void setBussinessArea(String bussinessArea) {
        this.bussinessArea = bussinessArea;
    }

    public String getEmployment() {
        return employment;
    }

    public void setEmployment(String employment) {
        this.employment = employment;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
    
    
}
