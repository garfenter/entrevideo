/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.entrevideo.component.fileupload;

import java.util.List;
import javax.faces.view.facelets.ComponentConfig;
import javax.faces.view.facelets.ComponentHandler;
import javax.faces.view.facelets.MetaRuleset;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.facelets.MethodRule;


public class FileUploadHandler extends ComponentHandler {

    public FileUploadHandler(ComponentConfig config) {
        super(config);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected MetaRuleset createMetaRuleset(Class type) {
        MetaRuleset metaRuleset = super.createMetaRuleset(type);
        Class[] fileUploadEventClass = new Class[]{FileUploadEvent.class};

        metaRuleset.addRule(new MethodRule("fileUploadListener", List.class, fileUploadEventClass));

        return metaRuleset;
    }
}