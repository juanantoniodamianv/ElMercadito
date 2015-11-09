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
import model.SectorEstante;

/**
 *
 * @author daniel
 */
public class SectorEstanteJpaController implements Serializable {

    public SectorEstanteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    SectorEstanteJpaController() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(SectorEstante sectorEstante) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(sectorEstante);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findSectorEstante(sectorEstante.getNroSectorEstante()) != null) {
                throw new PreexistingEntityException("SectorEstante " + sectorEstante + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(SectorEstante sectorEstante) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            sectorEstante = em.merge(sectorEstante);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = sectorEstante.getNroSectorEstante();
                if (findSectorEstante(id) == null) {
                    throw new NonexistentEntityException("The sectorEstante with id " + id + " no longer exists.");
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
            SectorEstante sectorEstante;
            try {
                sectorEstante = em.getReference(SectorEstante.class, id);
                sectorEstante.getNroSectorEstante();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The sectorEstante with id " + id + " no longer exists.", enfe);
            }
            em.remove(sectorEstante);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<SectorEstante> findSectorEstanteEntities() {
        return findSectorEstanteEntities(true, -1, -1);
    }

    public List<SectorEstante> findSectorEstanteEntities(int maxResults, int firstResult) {
        return findSectorEstanteEntities(false, maxResults, firstResult);
    }

    private List<SectorEstante> findSectorEstanteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(SectorEstante.class));
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

    public SectorEstante findSectorEstante(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(SectorEstante.class, id);
        } finally {
            em.close();
        }
    }

    public int getSectorEstanteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<SectorEstante> rt = cq.from(SectorEstante.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
