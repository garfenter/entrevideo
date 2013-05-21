package gt.com.entrevideo.web.util;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author garfenter
 */
@RequestScoped
@Named("utils")
public class Utils implements Serializable{
    
    public String encodeUrl(String url) throws UnsupportedEncodingException{
        return URLEncoder.encode(url, "UTF-8");
    }
    public String getGoogleClientId(){
        return Constants.GOOGLE_CLIENT_ID;
    }
    public String getGoogleRedirectUri(){
        return Constants.GOOGLE_REDICT_URI;
    }
    
}
