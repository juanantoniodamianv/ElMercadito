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
import model.Estante;

/**
 *
 * @author daniel
 */
public class EstanteJpaController implements Serializable {

    public EstanteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    EstanteJpaController() {
<<<<<<< HEAD
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
=======
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
>>>>>>> refs/remotes/origin/RamaA
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Estante estante) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(estante);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEstante(estante.getNroEstante()) != null) {
                throw new PreexistingEntityException("Estante " + estante + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Estante estante) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            estante = em.merge(estante);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = estante.getNroEstante();
                if (findEstante(id) == null) {
                    throw new NonexistentEntityException("The estante with id " + id + " no longer exists.");
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
            Estante estante;
            try {
                estante = em.getReference(Estante.class, id);
                estante.getNroEstante();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The estante with id " + id + " no longer exists.", enfe);
            }
            em.remove(estante);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Estante> findEstanteEntities() {
        return findEstanteEntities(true, -1, -1);
    }

    public List<Estante> findEstanteEntities(int maxResults, int firstResult) {
        return findEstanteEntities(false, maxResults, firstResult);
    }

    private List<Estante> findEstanteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Estante.class));
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

    public Estante findEstante(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Estante.class, id);
        } finally {
            em.close();
        }
    }

    public int getEstanteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Estante> rt = cq.from(Estante.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
