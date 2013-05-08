package gt.com.entrevideo.component.model;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;
import com.google.appengine.api.images.ServingUrlOptions;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author garfenter
 */
public class UploadBlobFile implements Serializable, FilePropertyChangeListener {
    private static final Logger logger = Logger.getLogger(UploadBlobFile.class.getName());
    private static BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
    private static ImagesService imageService = ImagesServiceFactory.getImagesService();
    private String blobKey;
    private String contentType;
    private String filename;
    private String fechaCreacion;
    private boolean fileUploaded;
    private String servinUrl;
    private String fileDescription;
    private List<FileProperty> properties;
    private String titulo;
    private FileProperty archivo;

    public UploadBlobFile() {
        fileUploaded = false;
        properties = new ArrayList<FileProperty>();
        properties.add(new FileProperty("Titulo", "Click aquí para modificar el titulo", true, this));
        properties.add(new FileProperty("Descripcion", "Click aquí para modificar la descripcion", true, 2, this));
        archivo = new FileProperty("Archivo", filename, true, this);
        properties.add(archivo);
    }

    public void cancelUpload() {
        BlobKey bkey = new BlobKey(blobKey);
        blobstoreService.delete(bkey);
        fileUploaded = false;
        fechaCreacion = null;
        filename = null;
        contentType = null;
        blobKey = null;
    }

    public void processUpload() {
        logger.log(Level.INFO, "Procesando upload!");
        try {
            fileUploaded = true;
            ServingUrlOptions suo = ServingUrlOptions.Builder.withBlobKey(new BlobKey(blobKey));
            servinUrl = imageService.getServingUrl(suo);
            archivo.setValue(filename);            
        } catch (Exception ex) {
            logger.log(Level.INFO, "{0}", ex);
            fileUploaded = false;
            properties = new ArrayList<FileProperty>();
        }
    }

    public String getBlobKey() {
        return blobKey;
    }

    public void setBlobKey(String blobKey) {        
        this.blobKey = blobKey;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String fileName) {
        this.filename = fileName;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public boolean isFileUploaded() {
        return fileUploaded;
    }

    public void setFileUploaded(boolean fileUploaded) {
        this.fileUploaded = fileUploaded;
    }

    public String getServinUrl() {
        return servinUrl;
    }

    public void setServinUrl(String servinUrl) {
        this.servinUrl = servinUrl;
    }

    public List<FileProperty> getProperties() {
        if (properties == null) {
            properties = new ArrayList<FileProperty>();
        }
        return properties;
    }

    public void setProperties(List<FileProperty> properties) {
        this.properties = properties;
    }

    public String getFileDescription() {
        return fileDescription;
    }

    public void setFileDescription(String fileDescription) {
        this.fileDescription = fileDescription;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public void valueChanged(FileProperty fileProperty) {
        if (fileProperty.getLabel().equalsIgnoreCase("Titulo") && !fileProperty.getValue().startsWith("Click aquí para modificar el titulo")) {
            titulo = fileProperty.getValue();
        }
        if (fileProperty.getLabel().equalsIgnoreCase("Descripcion") && !fileProperty.getValue().startsWith("Click aquí para modificar la descripción")) {
            fileDescription = fileProperty.getValue();
        }
        if (fileProperty.getLabel().equalsIgnoreCase("Archivo")) {
            filename = fileProperty.getValue();
        }
    }
}
