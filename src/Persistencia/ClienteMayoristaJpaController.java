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
import model.ClienteMayorista;

/**
 *
 * @author daniel
 */
public class ClienteMayoristaJpaController implements Serializable {

    public ClienteMayoristaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    ClienteMayoristaJpaController() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ClienteMayorista clienteMayorista) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(clienteMayorista);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findClienteMayorista(clienteMayorista.getDni()) != null) {
                throw new PreexistingEntityException("ClienteMayorista " + clienteMayorista + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ClienteMayorista clienteMayorista) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            clienteMayorista = em.merge(clienteMayorista);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = clienteMayorista.getDni();
                if (findClienteMayorista(id) == null) {
                    throw new NonexistentEntityException("The clienteMayorista with id " + id + " no longer exists.");
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
            ClienteMayorista clienteMayorista;
            try {
                clienteMayorista = em.getReference(ClienteMayorista.class, id);
                clienteMayorista.getDni();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The clienteMayorista with id " + id + " no longer exists.", enfe);
            }
            em.remove(clienteMayorista);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ClienteMayorista> findClienteMayoristaEntities() {
        return findClienteMayoristaEntities(true, -1, -1);
    }

    public List<ClienteMayorista> findClienteMayoristaEntities(int maxResults, int firstResult) {
        return findClienteMayoristaEntities(false, maxResults, firstResult);
    }

    private List<ClienteMayorista> findClienteMayoristaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ClienteMayorista.class));
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

    public ClienteMayorista findClienteMayorista(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ClienteMayorista.class, id);
        } finally {
            em.close();
        }
    }

    public int getClienteMayoristaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ClienteMayorista> rt = cq.from(ClienteMayorista.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
