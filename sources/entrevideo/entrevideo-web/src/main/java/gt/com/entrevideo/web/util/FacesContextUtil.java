/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.entrevideo.web.util;

import gt.com.entrevideo.modelo.SValue;
import javax.faces.context.FacesContext;

/**
 *
 * @author garfenter
 */
public class FacesContextUtil {
    public static Object getObjectFromELContext(String elExpression, Class c){
        FacesContext context = FacesContext.getCurrentInstance();
	  Object result =  context.getApplication().getExpressionFactory()
            .createValueExpression(context.getELContext(), elExpression, c)
              .getValue(context.getELContext());
          return result;
    }
    public static Object getObjectFromApplicationMap(String object){
        return FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().get(object);
    }
}
