package gt.com.entrevideo.component.model;

import com.coremedia.iso.IsoFile;
import com.coremedia.iso.boxes.MovieBox;
import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreInputStream;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import java.io.Serializable;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/**
 *
 * @author garfenter
 */
public class VideoBlobFile extends UploadBlobFile implements Serializable, FilePropertyChangeListener {

    private static BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
    private Integer duracion;

    @Override
    public void cancelUpload() {
        BlobKey bkey = new BlobKey(getBlobKey());
        blobstoreService.delete(bkey);
        setFileUploaded(false);
        setFechaCreacion(null);
        setFilename(null);
        setContentType(null);
        setBlobKey(null);
    }

    @Override
    public void processUpload() {
        try {
            setProperties(null);
            BlobKey bkey = new BlobKey(getBlobKey());
            BlobstoreInputStream bis = new BlobstoreInputStream(bkey);

            ReadableByteChannel rbc = Channels.newChannel(bis);
            IsoFile isoFile = new IsoFile(rbc);
            MovieBox moov = isoFile.getBoxes(MovieBox.class).get(0);
            long duration = moov.getMovieHeaderBox().getDuration();
            long timescale = moov.getMovieHeaderBox().getTimescale();
            long segundos = duration / timescale;
            long minutos = segundos / 60;
            segundos = segundos - (minutos * 60);
            setDuracion(Integer.parseInt(String.valueOf(duration / timescale)));
            getProperties().add(new FileProperty("Duracion", String.format("%1$d:%2$d", minutos, segundos)));
            getProperties().add(new FileProperty("Archivo", getFilename()));
            getProperties().add(new FileProperty("Tipo", getContentType()));

            setFileUploaded(true);
        } catch (Exception ex) {
            setFileUploaded(false);
            setProperties(null);
        }
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }
    
}
