package gt.com.entrevideo;

import gt.com.entrevideo.dao.EntrevideoSysDao;
import gt.com.entrevideo.modelo.SListaValores;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author garfenter
 */
@SessionScoped
@Named
public class EntrevideoSysDaoImpl implements EntrevideoSysDao, Serializable{
    @Inject
    EntrevideoEntityHandlerImpl entityHandler;
    @Override
    public List<SListaValores> findListaValoresByNombreTipo(String nombre) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("nombre", nombre);
        return entityHandler.executeQuery("SELECT l FROM SListaValores l WHERE l.tipoLista.nombre = :nombre  ", parameters);
    }
    
}
