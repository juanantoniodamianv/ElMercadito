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
import model.Deposito;

/**
 *
 * @author daniel
 */
public class DepositoJpaController implements Serializable {

    public DepositoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    DepositoJpaController() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Deposito deposito) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(deposito);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDeposito(deposito.getNroDeposito()) != null) {
                throw new PreexistingEntityException("Deposito " + deposito + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Deposito deposito) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            deposito = em.merge(deposito);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = deposito.getNroDeposito();
                if (findDeposito(id) == null) {
                    throw new NonexistentEntityException("The deposito with id " + id + " no longer exists.");
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
            Deposito deposito;
            try {
                deposito = em.getReference(Deposito.class, id);
                deposito.getNroDeposito();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The deposito with id " + id + " no longer exists.", enfe);
            }
            em.remove(deposito);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Deposito> findDepositoEntities() {
        return findDepositoEntities(true, -1, -1);
    }

    public List<Deposito> findDepositoEntities(int maxResults, int firstResult) {
        return findDepositoEntities(false, maxResults, firstResult);
    }

    private List<Deposito> findDepositoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Deposito.class));
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

    public Deposito findDeposito(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Deposito.class, id);
        } finally {
            em.close();
        }
    }

    public int getDepositoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Deposito> rt = cq.from(Deposito.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
