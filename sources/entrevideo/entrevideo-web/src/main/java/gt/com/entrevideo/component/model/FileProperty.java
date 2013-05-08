package gt.com.entrevideo.component.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author garfenter
 */
public class FileProperty implements Serializable {

    private String label;
    private String value;
    private boolean inlineUpdatable;
    private int tipoDespliegue; // 1 - Normal, 2 - Text Area
    private List<FilePropertyChangeListener> listeners;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
        for(FilePropertyChangeListener listener:getListeners()){
            listener.valueChanged(this);
        }
    }

    public FileProperty(String label, String value) {
        this.label = label;
        this.value = value;
        inlineUpdatable = false;
        this.tipoDespliegue = 1;
    }

    public FileProperty(String label, String value, FilePropertyChangeListener listener) {
        this.label = label;
        this.value = value;
        inlineUpdatable = false;
        this.tipoDespliegue = 1;
        getListeners().add(listener);
    }

    public FileProperty(String label, String value, boolean inlineUpdatable) {
        this.label = label;
        this.value = value;
        this.inlineUpdatable = inlineUpdatable;
        this.tipoDespliegue = 1;
    }

    public FileProperty(String label, String value, boolean inlineUpdatable, FilePropertyChangeListener listener) {
        this.label = label;
        this.value = value;
        this.inlineUpdatable = inlineUpdatable;
        this.tipoDespliegue = 1;
        getListeners().add(listener);
    }
    
    public FileProperty(String label, String value, boolean inlineUpdatable, int tipoDespliegue) {
        this.label = label;
        this.value = value;
        this.inlineUpdatable = inlineUpdatable;
        this.tipoDespliegue = tipoDespliegue;
    }
    public FileProperty(String label, String value, boolean inlineUpdatable, int tipoDespliegue, FilePropertyChangeListener listener) {
        this.label = label;
        this.value = value;
        this.inlineUpdatable = inlineUpdatable;
        this.tipoDespliegue = tipoDespliegue;
        getListeners().add(listener);
    }

    public boolean isInlineUpdatable() {
        return inlineUpdatable;
    }

    public void setInlineUpdatable(boolean inlineUpdatable) {
        this.inlineUpdatable = inlineUpdatable;
    }

    public int getTipoDespliegue() {
        return tipoDespliegue;
    }

    public void setTipoDespliegue(int tipoDespliegue) {
        this.tipoDespliegue = tipoDespliegue;
    }

    public final List<FilePropertyChangeListener> getListeners() {
        if (listeners == null) {
            listeners = new ArrayList<FilePropertyChangeListener>();
        }
        return listeners;
    }

    public void setListeners(List<FilePropertyChangeListener> listeners) {
        this.listeners = listeners;
    }
}
