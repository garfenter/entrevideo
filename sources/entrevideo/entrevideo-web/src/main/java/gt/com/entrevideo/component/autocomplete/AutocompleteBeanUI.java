package gt.com.entrevideo.component.autocomplete;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.googlecode.concurrenttrees.common.Iterables;
import com.googlecode.concurrenttrees.radix.node.concrete.DefaultCharArrayNodeFactory;
import com.googlecode.concurrenttrees.suffix.ConcurrentSuffixTree;
import gt.com.entrevideo.guice.config.EntrevideoDaoModule;
import gt.com.entrevideo.guice.config.EntrevideoServiceModule;
import gt.com.entrevideo.svc.ValuesListCatalog;
import gt.com.entrevideo.svc.modelo.ListValueElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author garfenter
 */
@ApplicationScoped
@ManagedBean(name = "autocompleteUI")
public class AutocompleteBeanUI {
    private static final Logger logger = Logger.getLogger(AutocompleteBeanUI.class.getName());
    Map<String, AutocompleteTipo> autocompleteTipo = new HashMap<String, AutocompleteTipo>();        
    
    ValuesListCatalog valueListCatalog;
    public String getName(){
        return "";
    }
    
    @PostConstruct
    public void init(){
        Injector injector = Guice.createInjector(new EntrevideoDaoModule(), new EntrevideoServiceModule(), new JpaPersistModule("entrevideo-pu"));
        valueListCatalog = injector.getInstance(ValuesListCatalog.class);
    }
    
    
    public AutocompleteTipo getAutocompleteTipoByNombre(String nombre) {
        if (autocompleteTipo.containsKey(nombre)) {
            return autocompleteTipo.get(nombre);
        } else {
            AutocompleteTipo at = new AutocompleteTipo(nombre);
            autocompleteTipo.put(nombre, at);
            return at;
        }
    }

    public class AutocompleteTipo implements Serializable {

        ConcurrentSuffixTree<ListValueElement> tree = new ConcurrentSuffixTree<ListValueElement>(new DefaultCharArrayNodeFactory());

        public AutocompleteTipo(String nombre) {
            for(int i = 0; i < 10; i++){
                valueListCatalog.persistListValueElement(nombre, nombre + i);
            }
            List<ListValueElement> valores = valueListCatalog.findListValueElementsByListName(nombre);            
            for (ListValueElement element : valores) {                
                tree.put(element.getValue().toUpperCase(), element);
                for (String key : element.getSynonymous()) {                    
                    tree.put(key.toUpperCase(), element);
                }

            }
        }

        public List<AutocompleteElement> complete(String query) {            
            List<AutocompleteElement> result = AutocompleteElement.convertToAutocompleteElement(Iterables.toList(tree.getValuesForKeysContaining(query)));
            if (result == null) {
                result = new ArrayList<AutocompleteElement>();
            }
            return result;
        }
    }
}
