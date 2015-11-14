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
import model.Encargado;

/**
 *
 * @author daniel
 */
public class EncargadoJpaController implements Serializable {

    public EncargadoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    EncargadoJpaController() {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Encargado encargado) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(encargado);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEncargado(encargado.getIdPersona()) != null) {
                throw new PreexistingEntityException("Encargado " + encargado + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Encargado encargado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            encargado = em.merge(encargado);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = encargado.getIdPersona();
                if (findEncargado(id) == null) {
                    throw new NonexistentEntityException("The encargado with id " + id + " no longer exists.");
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
            Encargado encargado;
            try {
                encargado = em.getReference(Encargado.class, id);
                encargado.getIdPersona();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The encargado with id " + id + " no longer exists.", enfe);
            }
            em.remove(encargado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Encargado> findEncargadoEntities() {
        return findEncargadoEntities(true, -1, -1);
    }

    public List<Encargado> findEncargadoEntities(int maxResults, int firstResult) {
        return findEncargadoEntities(false, maxResults, firstResult);
    }

    private List<Encargado> findEncargadoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Encargado.class));
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

    public Encargado findEncargado(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Encargado.class, id);
        } finally {
            em.close();
        }
    }

    public int getEncargadoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Encargado> rt = cq.from(Encargado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
