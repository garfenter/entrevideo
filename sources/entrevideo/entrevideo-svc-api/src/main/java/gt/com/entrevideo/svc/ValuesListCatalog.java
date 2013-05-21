package gt.com.entrevideo.svc;

import gt.com.entrevideo.modelo.EProfile;
import gt.com.entrevideo.svc.modelo.ListValueElement;
import java.util.List;

/**
 *
 * @author garfenter
 */
public interface ValuesListCatalog {
    public List<ListValueElement> findListValueElementsByListName(String list);
    public void persistListValueElement (ListValueElement element);
    public void persistListValueElement (String listName, String element, String ... synonymous);
    
}
