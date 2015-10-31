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
import model.ClienteMinorista;

/**
 *
 * @author daniel
 */
public class ClienteMinoristaJpaController implements Serializable {

    public ClienteMinoristaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    ClienteMinoristaJpaController() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ClienteMinorista clienteMinorista) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(clienteMinorista);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findClienteMinorista(clienteMinorista.getDni()) != null) {
                throw new PreexistingEntityException("ClienteMinorista " + clienteMinorista + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ClienteMinorista clienteMinorista) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            clienteMinorista = em.merge(clienteMinorista);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = clienteMinorista.getDni();
                if (findClienteMinorista(id) == null) {
                    throw new NonexistentEntityException("The clienteMinorista with id " + id + " no longer exists.");
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
            ClienteMinorista clienteMinorista;
            try {
                clienteMinorista = em.getReference(ClienteMinorista.class, id);
                clienteMinorista.getDni();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The clienteMinorista with id " + id + " no longer exists.", enfe);
            }
            em.remove(clienteMinorista);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ClienteMinorista> findClienteMinoristaEntities() {
        return findClienteMinoristaEntities(true, -1, -1);
    }

    public List<ClienteMinorista> findClienteMinoristaEntities(int maxResults, int firstResult) {
        return findClienteMinoristaEntities(false, maxResults, firstResult);
    }

    private List<ClienteMinorista> findClienteMinoristaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ClienteMinorista.class));
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

    public ClienteMinorista findClienteMinorista(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ClienteMinorista.class, id);
        } finally {
            em.close();
        }
    }

    public int getClienteMinoristaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ClienteMinorista> rt = cq.from(ClienteMinorista.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
