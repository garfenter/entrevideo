/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.papiro.gae.support;

import java.util.Map;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 *
 * @author garfenter
 */
public class ForceSessionSerializationPhaseListener implements PhaseListener {
 
    private static final Logger LOGGER = Logger.getLogger(ForceSessionSerializationPhaseListener.class.getName());
 
    private void touchSession() {
        final FacesContext facesContext = FacesContext.getCurrentInstance();
        final Map sessionMap = facesContext.getExternalContext().getSessionMap();
        sessionMap.put("forceGaeSessionSerialization", System.currentTimeMillis());
    }
    @Override
    public void afterPhase(final PhaseEvent event) {
        touchSession();
    }
    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RENDER_RESPONSE;
    }
    /**
     *
     * @param event
     */
    @Override
    public void beforePhase(PhaseEvent event) {
    }
}