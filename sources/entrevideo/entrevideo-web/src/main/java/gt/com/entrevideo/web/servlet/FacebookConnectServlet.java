/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.entrevideo.web.servlet;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.gson.Gson;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.jpa.JpaPersistModule;
import gt.com.entrevideo.guice.config.EntrevideoDaoModule;
import gt.com.entrevideo.guice.config.EntrevideoServiceModule;
import gt.com.entrevideo.modelo.EExperience;
import gt.com.entrevideo.modelo.EProfile;
import gt.com.entrevideo.svc.EntrevideoService;
import gt.com.entrevideo.web.backend.session.SessionUI;
import gt.com.entrevideo.web.facebook.connect.FacebookResponse;
import gt.com.entrevideo.web.facebook.connect.Work;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author garfenter
 */
public class FacebookConnectServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(FacebookConnectServlet.class.getName());

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        logger.log(Level.INFO, "Entrando al servlet de facebook");
        String code = req.getParameter("code");
        logger.log(Level.INFO, "Codigo: {0}", code);
        if (code == null || code.equals("")) {
            // an error occurred, handle this
        }

        String token = null;
        try {
            String g = "https://graph.facebook.com/oauth/access_token?client_id=561471017218152&redirect_uri=" + URLEncoder.encode("http://entrevideoprueba.appspot.com/FacebookConnectServlet", "UTF-8") + "&client_secret=e09793fc86dadaa5ca904ef0fa4ae908&code=" + code;
            URL u = new URL(g);
            URLConnection c = u.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(c.getInputStream()));
            String inputLine;
            StringBuilder b = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                logger.log(Level.INFO, "Texto entrada: {0}", inputLine);
                b.append(inputLine).append("\n");
            }
            in.close();
            token = b.toString();
            System.out.println(token);
            if (token.startsWith("{")) {
                throw new Exception("error on requesting token: " + token + " with code: " + code);
            }
        } catch (Exception e) {
            // an error occurred, handle this
        }

        String graph = null;
        try {
            String g = "https://graph.facebook.com/me?" + token;
            URL u = new URL(g);
            URLConnection c = u.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(c.getInputStream()));
            String inputLine;
            StringBuilder b = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                logger.log(Level.INFO, "Texto entrada: {0}", inputLine);
                b.append(inputLine).append("\n");
            }
            in.close();
            graph = b.toString();
        } catch (Exception e) {
            // an error occurred, handle this
        }


        Gson gson = new Gson();
        System.out.println(graph);
        FacebookResponse response = gson.fromJson(graph, FacebookResponse.class);

        Injector injector = Guice.createInjector(new JpaPersistModule("entrevideo-pu"), new EntrevideoDaoModule(), new EntrevideoServiceModule());
        EntrevideoService service = injector.getInstance(EntrevideoService.class);
        if(response == null || response.getEmail() == null){
            res.getOutputStream().write(graph.getBytes());
            return;
        }

        if (service.findProfileByEmail(response.getEmail()) == null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");

            EProfile profile = new EProfile();
            profile.setEmail(response.getEmail());
            profile.setLastName(response.getLast_name());
            profile.setName((response.getFirst_name() + " " + response.getMiddle_name()).trim());
            profile.setGender(response.getGender());
            profile.setUseExternalImage(true);
            if (response.getLocation() != null) {
                profile.setAddress(response.getLocation().getName());
            }
            profile.setExternalImageURL("http://graph.facebook.com/${username}/picture".replace("${username}", response.getUsername()));
            List<EExperience> experiencia = new ArrayList<EExperience>();

            try {
                int key = 0;
                for (Work work : response.getWork()) {
                    EExperience experience = new EExperience();
                    experience.setEnterprise(work.getEmployer().getName());
                    Date date1 = sdf.parse(work.getStart_date());
                    Date date2 = sdf.parse(work.getEnd_date());
                    GregorianCalendar gc1 = new GregorianCalendar();
                    gc1.setTime(date1);
                    GregorianCalendar gc2 = new GregorianCalendar();
                    gc1.setTime(date2);
                    int year1 = gc1.get(GregorianCalendar.YEAR);
                    int year2 = gc2.get(GregorianCalendar.YEAR);
                    experience.setYears(year2 - year1);
                    experience.setId(response.getEmail().concat(String.valueOf(key)));
                    experience.setEmail(response.getEmail());
                    experiencia.add(experience);
                    key++;
                }
            } catch (Exception ex) {
            }
            service.persistProfile(profile);
            for (EExperience experience : experiencia) {
                service.persistExperience(experience);
            }
        } 
        res.addCookie(new Cookie("ENV_US", response.getEmail()));
        res.sendRedirect("/secured/");
    }
}
