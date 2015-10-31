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
import model.Localidad;
import model.Provincia;

/**
 *
 * @author daniel
 */
public class LocalidadJpaController implements Serializable {

    public LocalidadJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    LocalidadJpaController() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Localidad localidad) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Provincia unaProvincia = localidad.getUnaProvincia();
            if (unaProvincia != null) {
                unaProvincia = em.getReference(unaProvincia.getClass(), unaProvincia.getCodigoProv());
                localidad.setUnaProvincia(unaProvincia);
            }
            em.persist(localidad);
            if (unaProvincia != null) {
                unaProvincia.getListaLocalidades().add(localidad);
                unaProvincia = em.merge(unaProvincia);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findLocalidad(localidad.getCp()) != null) {
                throw new PreexistingEntityException("Localidad " + localidad + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Localidad localidad) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Localidad persistentLocalidad = em.find(Localidad.class, localidad.getCp());
            Provincia unaProvinciaOld = persistentLocalidad.getUnaProvincia();
            Provincia unaProvinciaNew = localidad.getUnaProvincia();
            if (unaProvinciaNew != null) {
                unaProvinciaNew = em.getReference(unaProvinciaNew.getClass(), unaProvinciaNew.getCodigoProv());
                localidad.setUnaProvincia(unaProvinciaNew);
            }
            localidad = em.merge(localidad);
            if (unaProvinciaOld != null && !unaProvinciaOld.equals(unaProvinciaNew)) {
                unaProvinciaOld.getListaLocalidades().remove(localidad);
                unaProvinciaOld = em.merge(unaProvinciaOld);
            }
            if (unaProvinciaNew != null && !unaProvinciaNew.equals(unaProvinciaOld)) {
                unaProvinciaNew.getListaLocalidades().add(localidad);
                unaProvinciaNew = em.merge(unaProvinciaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = localidad.getCp();
                if (findLocalidad(id) == null) {
                    throw new NonexistentEntityException("The localidad with id " + id + " no longer exists.");
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
            Localidad localidad;
            try {
                localidad = em.getReference(Localidad.class, id);
                localidad.getCp();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The localidad with id " + id + " no longer exists.", enfe);
            }
            Provincia unaProvincia = localidad.getUnaProvincia();
            if (unaProvincia != null) {
                unaProvincia.getListaLocalidades().remove(localidad);
                unaProvincia = em.merge(unaProvincia);
            }
            em.remove(localidad);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Localidad> findLocalidadEntities() {
        return findLocalidadEntities(true, -1, -1);
    }

    public List<Localidad> findLocalidadEntities(int maxResults, int firstResult) {
        return findLocalidadEntities(false, maxResults, firstResult);
    }

    private List<Localidad> findLocalidadEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Localidad.class));
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

    public Localidad findLocalidad(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Localidad.class, id);
        } finally {
            em.close();
        }
    }

    public int getLocalidadCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Localidad> rt = cq.from(Localidad.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
