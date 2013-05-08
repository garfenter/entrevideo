package gt.com.entrevideo.dao;

import gt.com.entrevideo.modelo.SListaValores;
import java.util.List;

/**
 *
 * @author garfenter
 */
public interface EntrevideoSysDao {
    public List<SListaValores> findListaValoresByNombreTipo(String nombre);
}
