/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.entrevideo;

import gt.com.entrevideo.dao.EntrevideoEntityHandler;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author garfenter
 */
@SessionScoped
@Named
public class EntrevideoEntityHandlerImpl implements EntrevideoEntityHandler, Serializable {

    private EntityManager em;

    private void createEntityManager() {
        if (em == null) {
            em = EMF.get().createEntityManager();
        }
        if (em == null) {
            Logger.getLogger("Test").log(Level.INFO, "No se recupero un entity manager");
        }
    }

    private void closeEntityManager() {
        if (em != null) {
            em.close();
            em = null;
        }
    }

    @Override
    public void initTransaction() {
        if (em == null) {
            createEntityManager();
        }else{
            if(em.getTransaction().isActive()){
                throw new IllegalStateException("La transaccion ya ha sido iniciada");
            }
        }
        em.getTransaction().begin();
    }

    @Override
    public void commit() {
        if (em == null || !em.getTransaction().isActive()) {
            throw new IllegalStateException("No se ha iniciado una transaccion");
        }
        try {
            em.getTransaction().commit();      
            
        } finally {
            closeEntityManager();
        }
    }

    @Override
    public void rollback() {
        if (em == null || !em.getTransaction().isActive()) {
            throw new IllegalStateException("No se ha iniciado una transaccion");
        }
        try {
            em.getTransaction().rollback();
        } finally {
            closeEntityManager();
        }
    }

    @Override
    public EntityManager getEntityManager() {
        createEntityManager();
        return em;
    }
    @Override
    public List executeNamedQuery(String namedQuery, Map<String, Object> parameters){
        try{
            createEntityManager();
            Query qry = em.createNamedQuery(namedQuery);
            for(String key: parameters.keySet()){
                qry.setParameter(key, parameters.get(key));
            }
            return qry.getResultList();
        }finally{
            closeEntityManager();
        }
    }
    @Override
    public List executeQuery(String query, Map<String, Object> parameters){
        try{
            createEntityManager();
            Query qry = em.createQuery(query);
            for(String key: parameters.keySet()){
                qry.setParameter(key, parameters.get(key));
            }
            return qry.getResultList();
        }finally{
            closeEntityManager();
        }
    }

    @Override
    public List executeNamedQuery(String namedQuery, Map<String, Object> parameters, int first, int max) {
        try{
            createEntityManager();
            
            Query qry = em.createNamedQuery(namedQuery);
            for(String key: parameters.keySet()){
                qry.setParameter(key, parameters.get(key));
            }
            qry.setFirstResult(first);
            qry.setMaxResults(max);
            return qry.getResultList();
        }finally{
            closeEntityManager();
        }
    }

    @Override
    public List executeQuery(String query, Map<String, Object> parameters, int first, int max) {
        try{
            createEntityManager();
            Query qry = em.createQuery(query);
            for(String key: parameters.keySet()){
                qry.setParameter(key, parameters.get(key));
            }
            qry.setFirstResult(first);
            qry.setMaxResults(max);
            return qry.getResultList();
        }finally{
            closeEntityManager();
        }
    }

    @Override
    public Object executeSingleValueQuery(String query, Map<String, Object> parameters) {
        try{
            createEntityManager();
            Query qry = em.createQuery(query);
            for(String key: parameters.keySet()){
                qry.setParameter(key, parameters.get(key));
            }           
            return qry.getSingleResult();
        }finally{
            closeEntityManager();
        }
    }

    @Override
    public Object executeSingleValueNamedQuery(String namedQuery, Map<String, Object> parameters) {
        try{
            createEntityManager();
            Query qry = em.createNamedQuery(namedQuery);
            for(String key: parameters.keySet()){
                qry.setParameter(key, parameters.get(key));
            }            
            return qry.getResultList();
        }finally{
            closeEntityManager();
        }
    }
}
