/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.entrevideo.web.servlet;

import com.google.appengine.api.blobstore.BlobInfo;
import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author garfenter
 */
public class FileUploadServlet extends HttpServlet {

    private static BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
    private static final Logger logger = Logger.getLogger(FileUploadServlet.class.getName());

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        Gson gson = new Gson();
        try {
            FileUploadResult result = new FileUploadResult();
            result.setResult(1);
            result.setResultText("El archivo fue cargado exitosamente");
            Map<String, List<BlobInfo>> blobs = blobstoreService.getBlobInfos(req);            
            for (String key : blobs.keySet()) {
                List<BlobInfo> files = blobs.get(key);
                
                for (BlobInfo bKey : files) {
                    result.setBlobInfo(bKey);
                }
            }
            res.getOutputStream().print(gson.toJson(result));
            res.getOutputStream().close();
        } catch (Exception ex) {
            FileUploadResult result = new FileUploadResult();
            result.setResult(0);
            result.setResultText("No se ha logrado procesar la peticion en estos momentos, porfavor intentelo mas tarde: " + ex.getMessage());
            res.getOutputStream().print(gson.toJson(result));
            res.getOutputStream().close();
        }
    }

    public class FileUploadResult {

        private String resultText;
        // 0 - NOT OK
        // 1 - OK
        private int result;
        private BlobInfo blobInfo;
        

        public String getResultText() {
            return resultText;
        }

        public void setResultText(String resultText) {
            this.resultText = resultText;
        }

        public int getResult() {
            return result;
        }

        public void setResult(int result) {
            this.result = result;
        }

        public BlobInfo getBlobInfo() {
            return blobInfo;
        }

        public void setBlobInfo(BlobInfo blobInfo) {
            this.blobInfo = blobInfo;
        }
        
      
    }
}
