/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.DescripcionArticulo;

/**
 *
 * @author daniel
 */
public class DescripcionArticuloJpaController implements Serializable {

    public DescripcionArticuloJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    DescripcionArticuloJpaController() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DescripcionArticulo descripcionArticulo) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(descripcionArticulo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDescripcionArticulo(descripcionArticulo.getCodigoBarra()) != null) {
                throw new PreexistingEntityException("DescripcionArticulo " + descripcionArticulo + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DescripcionArticulo descripcionArticulo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            descripcionArticulo = em.merge(descripcionArticulo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = descripcionArticulo.getCodigoBarra();
                if (findDescripcionArticulo(id) == null) {
                    throw new NonexistentEntityException("The descripcionArticulo with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DescripcionArticulo descripcionArticulo;
            try {
                descripcionArticulo = em.getReference(DescripcionArticulo.class, id);
                descripcionArticulo.getCodigoBarra();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The descripcionArticulo with id " + id + " no longer exists.", enfe);
            }
            em.remove(descripcionArticulo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DescripcionArticulo> findDescripcionArticuloEntities() {
        return findDescripcionArticuloEntities(true, -1, -1);
    }

    public List<DescripcionArticulo> findDescripcionArticuloEntities(int maxResults, int firstResult) {
        return findDescripcionArticuloEntities(false, maxResults, firstResult);
    }

    private List<DescripcionArticulo> findDescripcionArticuloEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DescripcionArticulo.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public DescripcionArticulo findDescripcionArticulo(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DescripcionArticulo.class, id);
        } finally {
            em.close();
        }
    }

    public int getDescripcionArticuloCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DescripcionArticulo> rt = cq.from(DescripcionArticulo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
