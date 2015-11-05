/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Comprobante;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author daniel
 */
public class ComprobanteJpaController implements Serializable {

    public ComprobanteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    ComprobanteJpaController() {
<<<<<<< HEAD
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
=======
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
>>>>>>> refs/remotes/origin/RamaA
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Comprobante comprobante) throws PreexistingEntityException, Exception {
        if (comprobante.getListaComprobantes() == null) {
            comprobante.setListaComprobantes(new ArrayList<Comprobante>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ArrayList<Comprobante> attachedListaComprobantes = new ArrayList<Comprobante>();
            for (Comprobante listaComprobantesComprobanteToAttach : comprobante.getListaComprobantes()) {
                listaComprobantesComprobanteToAttach = em.getReference(listaComprobantesComprobanteToAttach.getClass(), listaComprobantesComprobanteToAttach.getNroComprobante());
                attachedListaComprobantes.add(listaComprobantesComprobanteToAttach);
            }
            comprobante.setListaComprobantes(attachedListaComprobantes);
            em.persist(comprobante);
            for (Comprobante listaComprobantesComprobante : comprobante.getListaComprobantes()) {
                listaComprobantesComprobante.getListaComprobantes().add(comprobante);
                listaComprobantesComprobante = em.merge(listaComprobantesComprobante);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findComprobante(comprobante.getNroComprobante()) != null) {
                throw new PreexistingEntityException("Comprobante " + comprobante + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Comprobante comprobante) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Comprobante persistentComprobante = em.find(Comprobante.class, comprobante.getNroComprobante());
            ArrayList<Comprobante> listaComprobantesOld = persistentComprobante.getListaComprobantes();
            ArrayList<Comprobante> listaComprobantesNew = comprobante.getListaComprobantes();
            ArrayList<Comprobante> attachedListaComprobantesNew = new ArrayList<Comprobante>();
            for (Comprobante listaComprobantesNewComprobanteToAttach : listaComprobantesNew) {
                listaComprobantesNewComprobanteToAttach = em.getReference(listaComprobantesNewComprobanteToAttach.getClass(), listaComprobantesNewComprobanteToAttach.getNroComprobante());
                attachedListaComprobantesNew.add(listaComprobantesNewComprobanteToAttach);
            }
            listaComprobantesNew = attachedListaComprobantesNew;
            comprobante.setListaComprobantes(listaComprobantesNew);
            comprobante = em.merge(comprobante);
            for (Comprobante listaComprobantesOldComprobante : listaComprobantesOld) {
                if (!listaComprobantesNew.contains(listaComprobantesOldComprobante)) {
                    listaComprobantesOldComprobante.getListaComprobantes().remove(comprobante);
                    listaComprobantesOldComprobante = em.merge(listaComprobantesOldComprobante);
                }
            }
            for (Comprobante listaComprobantesNewComprobante : listaComprobantesNew) {
                if (!listaComprobantesOld.contains(listaComprobantesNewComprobante)) {
                    listaComprobantesNewComprobante.getListaComprobantes().add(comprobante);
                    listaComprobantesNewComprobante = em.merge(listaComprobantesNewComprobante);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = comprobante.getNroComprobante();
                if (findComprobante(id) == null) {
                    throw new NonexistentEntityException("The comprobante with id " + id + " no longer exists.");
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
            Comprobante comprobante;
            try {
                comprobante = em.getReference(Comprobante.class, id);
                comprobante.getNroComprobante();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The comprobante with id " + id + " no longer exists.", enfe);
            }
            ArrayList<Comprobante> listaComprobantes = comprobante.getListaComprobantes();
            for (Comprobante listaComprobantesComprobante : listaComprobantes) {
                listaComprobantesComprobante.getListaComprobantes().remove(comprobante);
                listaComprobantesComprobante = em.merge(listaComprobantesComprobante);
            }
            em.remove(comprobante);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Comprobante> findComprobanteEntities() {
        return findComprobanteEntities(true, -1, -1);
    }

    public List<Comprobante> findComprobanteEntities(int maxResults, int firstResult) {
        return findComprobanteEntities(false, maxResults, firstResult);
    }

    private List<Comprobante> findComprobanteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Comprobante.class));
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

    public Comprobante findComprobante(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Comprobante.class, id);
        } finally {
            em.close();
        }
    }

    public int getComprobanteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Comprobante> rt = cq.from(Comprobante.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
