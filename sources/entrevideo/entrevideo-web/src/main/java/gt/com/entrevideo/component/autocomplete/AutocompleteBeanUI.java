package gt.com.entrevideo.component.autocomplete;

import com.googlecode.concurrenttrees.common.Iterables;
import com.googlecode.concurrenttrees.radix.node.concrete.DefaultCharArrayNodeFactory;
import com.googlecode.concurrenttrees.suffix.ConcurrentSuffixTree;
import gt.com.entrevideo.EntrevideoEntityHandlerImpl;
import gt.com.entrevideo.EntrevideoSysDaoImpl;
import gt.com.entrevideo.dao.EntrevideoSysDao;
import gt.com.entrevideo.modelo.SListaValores;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author garfenter
 */
@ApplicationScoped
@Named("autocompleteUI")
public class AutocompleteBeanUI implements Serializable {

    Map<String, AutocompleteTipo> autocompleteTipo = new HashMap<String, AutocompleteTipo>();
    private EntrevideoEntityHandlerImpl entityHandler = new EntrevideoEntityHandlerImpl();

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

        ConcurrentSuffixTree<SListaValores> tree = new ConcurrentSuffixTree<SListaValores>(new DefaultCharArrayNodeFactory());

        public AutocompleteTipo(String nombre) {
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("nombre", nombre);
            List<SListaValores> valores =  entityHandler.executeQuery("SELECT l FROM SListaValores l WHERE l.tipoLista.nombre = :nombre  ", parameters);
            
            for (SListaValores valor : valores) {
                tree.put(valor.getNombre().toUpperCase(), valor);
            }
        }

        public List<SListaValores> complete(String query) {
            List<SListaValores> result = Iterables.toList(tree.getValuesForKeysContaining(query));
            if (result == null) {
                result = new ArrayList<SListaValores>();
            }
            return result;
        }
    }
}
