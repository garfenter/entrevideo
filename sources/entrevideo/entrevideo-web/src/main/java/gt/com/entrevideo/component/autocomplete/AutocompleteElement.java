package gt.com.entrevideo.component.autocomplete;

import gt.com.entrevideo.svc.modelo.ListValueElement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author garfenter
 */
public class AutocompleteElement {
    private String label;
    private ListValueElement element;
    
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ListValueElement getElement() {
        return element;
    }

    public void setElement(ListValueElement element) {
        this.element = element;
    }

    public AutocompleteElement(String label, ListValueElement element) {
        this.label = label;
        this.element = element;
    }
    public static List<AutocompleteElement> convertToAutocompleteElement(List<ListValueElement> values){
        List<AutocompleteElement> result = new ArrayList<AutocompleteElement>();
        for(ListValueElement element:values){
            result.add(new AutocompleteElement(element.getValue(), element));
            for(String syn: element.getSynonymous()){
                result.add(new AutocompleteElement(syn, element));
            }
        }
        return result;
    }
}
