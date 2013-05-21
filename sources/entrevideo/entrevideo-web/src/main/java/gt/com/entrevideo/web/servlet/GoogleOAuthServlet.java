package gt.com.entrevideo.web.servlet;



import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.auth.oauth2.AuthorizationCodeResponseUrl;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.appengine.auth.oauth2.AbstractAppEngineAuthorizationCodeCallbackServlet;
import com.google.api.client.extensions.appengine.http.UrlFetchTransport;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.json.jackson.JacksonFactory;
import com.google.gson.Gson;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.jpa.JpaPersistModule;
import gt.com.entrevideo.guice.config.EntrevideoDaoModule;
import gt.com.entrevideo.guice.config.EntrevideoServiceModule;
import gt.com.entrevideo.modelo.EProfile;
import gt.com.entrevideo.svc.EntrevideoService;
import gt.com.entrevideo.web.google.GoogleProfileResponse;
import gt.com.entrevideo.web.util.Constants;
import gt.com.entrevideo.web.util.StringUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author garfenter
 */
public class GoogleOAuthServlet extends AbstractAppEngineAuthorizationCodeCallbackServlet {

    private String accessToken = "test1";

    @Override
    protected void onSuccess(HttpServletRequest req, HttpServletResponse resp, Credential credential)
            throws ServletException, IOException {
        System.out.println("Validado exitosamente: " + credential.getAccessToken());
        accessToken = credential.getAccessToken();

        String g = "https://www.googleapis.com/oauth2/v1/userinfo?access_token=" + accessToken;
        URL u = new URL(g);
        URLConnection c = u.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(c.getInputStream()));
        String inputLine;
        StringBuilder b = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {        
            b.append(inputLine).append("\n");
        }
        Gson gson = new Gson();
        GoogleProfileResponse profile = gson.fromJson(b.toString(), GoogleProfileResponse.class);
        String hash = "";
        try {
            hash = StringUtil.convertToMD5(profile.getEmail(), Constants.ENTREVIDEO_PRIVATE_KEY);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(GoogleOAuthServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Injector injector = Guice.createInjector(new JpaPersistModule("entrevideo-pu"), new EntrevideoDaoModule(), new EntrevideoServiceModule());
        EntrevideoService service = injector.getInstance(EntrevideoService.class);
        
        if (service.findProfileByEmail(profile.getEmail()) == null) {
            EProfile eProfile = new EProfile();
            eProfile.setEmail(profile.getEmail());
            eProfile.setLastName(profile.getFamily_name());
            eProfile.setName(profile.getGiven_name());
            eProfile.setGender(profile.getGender());
            eProfile.setUseExternalImage(true);
            eProfile.setExternalImageURL("https://plus.google.com/s2/photos/profile/${profile_id}".replace("${profile_id}", profile.getId()));            
            service.persistProfile(eProfile);            
        }
        
        resp.addCookie(new Cookie("ENV_US", profile.getEmail()));
        resp.addCookie(new Cookie("hsh", hash));
        
        resp.sendRedirect("/secured/");


    }

    @Override
    protected void onError(
            HttpServletRequest req, HttpServletResponse resp, AuthorizationCodeResponseUrl errorResponse)
            throws ServletException, IOException {
        System.out.println("Ha ocurrido un error al validar el usuario");
    }

    @Override
    protected AuthorizationCodeFlow initializeFlow() throws ServletException, IOException {
        List<String> scopes = new ArrayList<String>();
        scopes.add("https://www.googleapis.com/auth/userinfo.email");
        scopes.add("https://www.googleapis.com/auth/userinfo.profile");
        return new GoogleAuthorizationCodeFlow.Builder(new UrlFetchTransport(), new JacksonFactory(),
                Constants.GOOGLE_CLIENT_ID, Constants.GOOGLE_SECRET_ID,
                scopes).build();

    }

    @Override
    protected String getRedirectUri(HttpServletRequest hsr) throws ServletException, IOException {
        return Constants.GOOGLE_REDICT_URI;
    }

    @Override
    protected String getUserId(HttpServletRequest req) throws ServletException, IOException {
        return null;
    }
}
