package gt.com.entrevideo.web.facebook.connect;

/**
 *
 * @author garfenter
 */
public class Education {
    private School school;
    private String type;

    public School getSchool() {
        if(school == null){
            school = new School();
        }
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
}
