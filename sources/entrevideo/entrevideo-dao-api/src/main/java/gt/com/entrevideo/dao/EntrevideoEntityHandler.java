package gt.com.entrevideo.dao;

import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;

/**
 *
 * @author garfenter
 */

public interface EntrevideoEntityHandler {
    public void initTransaction();
    public void commit();
    public void rollback();
    public EntityManager getEntityManager();
    public List executeNamedQuery(String namedQuery, Map<String, Object> parameters);
    public List executeNamedQuery(String namedQuery, Map<String, Object> parameters, int first, int max);
    public List executeQuery(String query, Map<String, Object> parameters);
    public List executeQuery(String query, Map<String, Object> parameters, int first, int max);    
    public Object executeSingleValueQuery(String query, Map<String, Object> parameters);
    public Object executeSingleValueNamedQuery(String namedQuery, Map<String, Object> parameters);    
}
