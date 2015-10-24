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
import model.FacturaVta;

/**
 *
 * @author daniel
 */
public class FacturaVtaJpaController1 implements Serializable {

    public FacturaVtaJpaController1(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(FacturaVta facturaVta) throws PreexistingEntityException, Exception {
        if (facturaVta.getListaComprobantes() == null) {
            facturaVta.setListaComprobantes(new ArrayList<Comprobante>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ArrayList<Comprobante> attachedListaComprobantes = new ArrayList<Comprobante>();
            for (Comprobante listaComprobantesComprobanteToAttach : facturaVta.getListaComprobantes()) {
                listaComprobantesComprobanteToAttach = em.getReference(listaComprobantesComprobanteToAttach.getClass(), listaComprobantesComprobanteToAttach.getNroComprobante());
                attachedListaComprobantes.add(listaComprobantesComprobanteToAttach);
            }
            facturaVta.setListaComprobantes(attachedListaComprobantes);
            em.persist(facturaVta);
            for (Comprobante listaComprobantesComprobante : facturaVta.getListaComprobantes()) {
                listaComprobantesComprobante.getListaComprobantes().add(facturaVta);
                listaComprobantesComprobante = em.merge(listaComprobantesComprobante);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findFacturaVta(facturaVta.getNroComprobante()) != null) {
                throw new PreexistingEntityException("FacturaVta " + facturaVta + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(FacturaVta facturaVta) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            FacturaVta persistentFacturaVta = em.find(FacturaVta.class, facturaVta.getNroComprobante());
            ArrayList<Comprobante> listaComprobantesOld = persistentFacturaVta.getListaComprobantes();
            ArrayList<Comprobante> listaComprobantesNew = facturaVta.getListaComprobantes();
            ArrayList<Comprobante> attachedListaComprobantesNew = new ArrayList<Comprobante>();
            for (Comprobante listaComprobantesNewComprobanteToAttach : listaComprobantesNew) {
                listaComprobantesNewComprobanteToAttach = em.getReference(listaComprobantesNewComprobanteToAttach.getClass(), listaComprobantesNewComprobanteToAttach.getNroComprobante());
                attachedListaComprobantesNew.add(listaComprobantesNewComprobanteToAttach);
            }
            listaComprobantesNew = attachedListaComprobantesNew;
            facturaVta.setListaComprobantes(listaComprobantesNew);
            facturaVta = em.merge(facturaVta);
            for (Comprobante listaComprobantesOldComprobante : listaComprobantesOld) {
                if (!listaComprobantesNew.contains(listaComprobantesOldComprobante)) {
                    listaComprobantesOldComprobante.getListaComprobantes().remove(facturaVta);
                    listaComprobantesOldComprobante = em.merge(listaComprobantesOldComprobante);
                }
            }
            for (Comprobante listaComprobantesNewComprobante : listaComprobantesNew) {
                if (!listaComprobantesOld.contains(listaComprobantesNewComprobante)) {
                    listaComprobantesNewComprobante.getListaComprobantes().add(facturaVta);
                    listaComprobantesNewComprobante = em.merge(listaComprobantesNewComprobante);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = facturaVta.getNroComprobante();
                if (findFacturaVta(id) == null) {
                    throw new NonexistentEntityException("The facturaVta with id " + id + " no longer exists.");
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
            FacturaVta facturaVta;
            try {
                facturaVta = em.getReference(FacturaVta.class, id);
                facturaVta.getNroComprobante();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The facturaVta with id " + id + " no longer exists.", enfe);
            }
            ArrayList<Comprobante> listaComprobantes = facturaVta.getListaComprobantes();
            for (Comprobante listaComprobantesComprobante : listaComprobantes) {
                listaComprobantesComprobante.getListaComprobantes().remove(facturaVta);
                listaComprobantesComprobante = em.merge(listaComprobantesComprobante);
            }
            em.remove(facturaVta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<FacturaVta> findFacturaVtaEntities() {
        return findFacturaVtaEntities(true, -1, -1);
    }

    public List<FacturaVta> findFacturaVtaEntities(int maxResults, int firstResult) {
        return findFacturaVtaEntities(false, maxResults, firstResult);
    }

    private List<FacturaVta> findFacturaVtaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(FacturaVta.class));
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

    public FacturaVta findFacturaVta(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(FacturaVta.class, id);
        } finally {
            em.close();
        }
    }

    public int getFacturaVtaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<FacturaVta> rt = cq.from(FacturaVta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
