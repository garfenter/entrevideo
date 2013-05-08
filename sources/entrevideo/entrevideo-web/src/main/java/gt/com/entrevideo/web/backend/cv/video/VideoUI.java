package gt.com.entrevideo.web.backend.cv.video;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author garfenter
 */
@Named("videoUI")
@SessionScoped
public class VideoUI implements Serializable{
    private String videoID;

    public String getVideoID() {
        return videoID;
    }

    public void setVideoID(String videoID) {
        this.videoID = videoID;
    }
    
}
