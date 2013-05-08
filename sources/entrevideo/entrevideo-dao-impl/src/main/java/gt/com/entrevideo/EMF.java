/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.entrevideo;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author garfenter
 */
public final class EMF {    
    private static final EntityManagerFactory emfInstance = Persistence
        .createEntityManagerFactory("transactions-optional");

    private EMF() {
    }

    public static EntityManagerFactory get() {
        return emfInstance;
    }

}
