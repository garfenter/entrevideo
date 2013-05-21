package gt.com.entrevideo.svc;

import com.google.inject.Inject;
import com.google.inject.persist.Transactional;
import gt.com.entrevideo.dao.EntrevideoDao;
import gt.com.entrevideo.svc.modelo.ListValueElement;
import java.util.List;
import gt.com.entrevideo.modelo.SValue;
import gt.com.entrevideo.svc.util.ListValueElementUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author garfenter
 */
public class ValueListCatalogImpl implements ValuesListCatalog {

    private EntrevideoDao sysDao;

    @Inject
    public ValueListCatalogImpl(EntrevideoDao sysDao) {
        this.sysDao = sysDao;
    }

    @Override
    public List<ListValueElement> findListValueElementsByListName(String list) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("name", list);
        List<SValue> valores = sysDao.findListValueElementsByListName(list);
        return ListValueElementUtil.convertToBussinessObjects(valores);
    }

    @Override
    @Transactional
    public void persistListValueElement(ListValueElement element) {

        sysDao.persist(ListValueElementUtil.convertToDbObject(element));

    }

    @Override
    @Transactional
    public void persistListValueElement(String listName, String element, String... synonymous) {
        SValue lElement = new SValue();
        lElement.setListName(listName);
        List<String> lSynonymous = new ArrayList<String>();
        lSynonymous.addAll(Arrays.asList(synonymous));
        lElement.setSynonymous(lSynonymous);
        lElement.setValue(element);
        sysDao.persist(lElement);

    }
}
