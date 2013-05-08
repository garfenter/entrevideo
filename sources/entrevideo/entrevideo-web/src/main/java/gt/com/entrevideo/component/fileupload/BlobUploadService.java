package gt.com.entrevideo.component.fileupload;

import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author garfenter
 */
@RequestScoped
@Named("blobUploadService")
public class BlobUploadService implements Serializable{
    private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
    public String getUploadUrl(){        
        return blobstoreService.createUploadUrl("/upload");        
    }

}
