package gt.com.entrevideo.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author garfenter
 */
@Entity
public class EProfile implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    private String email;
    private String name;
    private String lastName;
    private String address;
    private String phone;    
    private String imagenKey;
    private String externalImageURL;
    private Boolean useExternalImage;
    private String gender;
    
    private List<String> skills;        
    private String videoUrl;
    private Integer score;
    private String facebookLastUpdate;
    

    public EProfile() {
        
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImagenKey() {
        return imagenKey;
    }

    public void setImagenKey(String imagenKey) {
        this.imagenKey = imagenKey;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }   
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + (this.email != null ? this.email.hashCode() : 0);
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
        final EProfile other = (EProfile) obj;
        if ((this.email == null) ? (other.email != null) : !this.email.equals(other.email)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EProfile{" + "email=" + email + '}';
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }        
   
    public String getFacebookLastUpdate() {
        return facebookLastUpdate;
    }

    public void setFacebookLastUpdate(String facebookLastUpdate) {
        this.facebookLastUpdate = facebookLastUpdate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getExternalImageURL() {
        return externalImageURL;
    }

    public void setExternalImageURL(String externalImageURL) {
        this.externalImageURL = externalImageURL;
    }

    public Boolean getUseExternalImage() {
        return useExternalImage;
    }

    public void setUseExternalImage(Boolean useExternalImage) {
        this.useExternalImage = useExternalImage;
    }
        
}
