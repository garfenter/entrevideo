package gt.com.entrevideo.web.facebook.connect;

/**
 *
 * @author garfenter
 */
public class Work {
    private Employer employer;    
    private String start_date;
    private String end_date;

    public Employer getEmployer() {
        if(employer == null){
            employer = new Employer();                    
        }
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }
    
    
}
