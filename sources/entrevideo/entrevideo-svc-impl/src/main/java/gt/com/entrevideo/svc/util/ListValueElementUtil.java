package gt.com.entrevideo.svc.util;

import gt.com.entrevideo.modelo.SValue;
import gt.com.entrevideo.svc.modelo.ListValueElement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author garfenter
 */
public class ListValueElementUtil {
    public static ListValueElement convertToBussinessObject(SValue value){
        ListValueElement result = new ListValueElement();
        result.setListName(value.getListName());
        result.setSynonymous(value.getSynonymous());
        result.setValue(value.getValue());        
        return result;        
    }
    public static List<ListValueElement> convertToBussinessObjects(List<SValue> values){
        List<ListValueElement> result = new ArrayList<ListValueElement>();
        for(SValue value: values){
            result.add(convertToBussinessObject(value));
        }
        return result;
    }
    public static SValue convertToDbObject(ListValueElement element){
        SValue result = new SValue();
        result.setListName(element.getListName());
        result.setPopularity(element.getPopularity());
        result.setSynonymous(element.getSynonymous());
        result.setValue(element.getValue());
        return result;
    
    }
    
}
