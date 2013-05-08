/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.entrevideo.component.fileupload;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.fileupload.FileItemStream;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author garfenter
 */
public class FileStreamUploadedFile  implements UploadedFile{
    public FileItemStream fileItemStream;
    public FileStreamUploadedFile(FileItemStream fis){
        this.fileItemStream = fis;
    }
    @Override
    public String getFileName() {
        return fileItemStream.getName();
    }

    @Override
    public InputStream getInputstream() throws IOException {
        return fileItemStream.openStream();
    }

    @Override
    public long getSize() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public byte[] getContents() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getContentType() {
        return fileItemStream.getContentType();
    }
    
}
