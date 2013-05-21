package gt.com.entrevideo.web.facebook.connect;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author garfenter
 */
public class FacebookResponse {
    private String id;
    private String first_name;
    private String middle_name;
    private String last_name;
    private String email;
    private String gender;
    private String link;
    private String username;
    private Hometown hometown;
    private Location location;
    private List<Work> work;
    private List<Education> education;
    private String locale;
    private String updated_time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Hometown getHometown() {
        return hometown;
    }

    public void setHometown(Hometown hometown) {
        this.hometown = hometown;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Work> getWork() {
        if(work == null){
            work = new ArrayList<Work>();
        }
        return work;
    }

    public void setWork(List<Work> work) {
        this.work = work;
    }

    public List<Education> getEducation() {
        if(education == null){
            education = new ArrayList<Education>();
        }
        return education;
    }

    public void setEducation(List<Education> education) {
        this.education = education;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getUpdated_time() {
        return updated_time;
    }

    public void setUpdated_time(String updated_time) {
        this.updated_time = updated_time;
    }
    
}
