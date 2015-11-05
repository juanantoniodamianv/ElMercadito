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
import model.Cajero;

/**
 *
 * @author daniel
 */
public class CajeroJpaController implements Serializable {
<<<<<<< HEAD
=======
    private static final long serialVersionUID = 1L;
>>>>>>> refs/remotes/origin/RamaA

    public CajeroJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    CajeroJpaController() {
<<<<<<< HEAD
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
=======
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
>>>>>>> refs/remotes/origin/RamaA
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cajero cajero) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(cajero);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCajero(cajero.getNroCajero()) != null) {
                throw new PreexistingEntityException("Cajero " + cajero + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cajero cajero) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            cajero = em.merge(cajero);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = cajero.getNroCajero();
                if (findCajero(id) == null) {
                    throw new NonexistentEntityException("The cajero with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cajero cajero;
            try {
                cajero = em.getReference(Cajero.class, id);
                cajero.getNroCajero();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cajero with id " + id + " no longer exists.", enfe);
            }
            em.remove(cajero);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cajero> findCajeroEntities() {
        return findCajeroEntities(true, -1, -1);
    }

    public List<Cajero> findCajeroEntities(int maxResults, int firstResult) {
        return findCajeroEntities(false, maxResults, firstResult);
    }

    private List<Cajero> findCajeroEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cajero.class));
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

    public Cajero findCajero(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cajero.class, id);
        } finally {
            em.close();
        }
    }

    public int getCajeroCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cajero> rt = cq.from(Cajero.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    Cajero findCajero(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
