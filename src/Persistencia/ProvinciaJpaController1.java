/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Zona;
import model.Localidad;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import model.Provincia;

/**
 *
 * @author daniel
 */
public class ProvinciaJpaController1 implements Serializable {

    public ProvinciaJpaController1(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Provincia provincia) {
        if (provincia.getListaLocalidades() == null) {
            provincia.setListaLocalidades(new ArrayList<Localidad>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Zona unaZona = provincia.getUnaZona();
            if (unaZona != null) {
                unaZona = em.getReference(unaZona.getClass(), unaZona.getCodigoZona());
                provincia.setUnaZona(unaZona);
            }
            ArrayList<Localidad> attachedListaLocalidades = new ArrayList<Localidad>();
            for (Localidad listaLocalidadesLocalidadToAttach : provincia.getListaLocalidades()) {
                listaLocalidadesLocalidadToAttach = em.getReference(listaLocalidadesLocalidadToAttach.getClass(), listaLocalidadesLocalidadToAttach.getCp());
                attachedListaLocalidades.add(listaLocalidadesLocalidadToAttach);
            }
            provincia.setListaLocalidades(attachedListaLocalidades);
            em.persist(provincia);
            if (unaZona != null) {
                unaZona.getListaProvincias().add(provincia);
                unaZona = em.merge(unaZona);
            }
            for (Localidad listaLocalidadesLocalidad : provincia.getListaLocalidades()) {
                Provincia oldUnaProvinciaOfListaLocalidadesLocalidad = listaLocalidadesLocalidad.getUnaProvincia();
                listaLocalidadesLocalidad.setUnaProvincia(provincia);
                listaLocalidadesLocalidad = em.merge(listaLocalidadesLocalidad);
                if (oldUnaProvinciaOfListaLocalidadesLocalidad != null) {
                    oldUnaProvinciaOfListaLocalidadesLocalidad.getListaLocalidades().remove(listaLocalidadesLocalidad);
                    oldUnaProvinciaOfListaLocalidadesLocalidad = em.merge(oldUnaProvinciaOfListaLocalidadesLocalidad);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Provincia provincia) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Provincia persistentProvincia = em.find(Provincia.class, provincia.getCodigoProv());
            Zona unaZonaOld = persistentProvincia.getUnaZona();
            Zona unaZonaNew = provincia.getUnaZona();
            ArrayList<Localidad> listaLocalidadesOld = persistentProvincia.getListaLocalidades();
            ArrayList<Localidad> listaLocalidadesNew = provincia.getListaLocalidades();
            if (unaZonaNew != null) {
                unaZonaNew = em.getReference(unaZonaNew.getClass(), unaZonaNew.getCodigoZona());
                provincia.setUnaZona(unaZonaNew);
            }
            ArrayList<Localidad> attachedListaLocalidadesNew = new ArrayList<Localidad>();
            for (Localidad listaLocalidadesNewLocalidadToAttach : listaLocalidadesNew) {
                listaLocalidadesNewLocalidadToAttach = em.getReference(listaLocalidadesNewLocalidadToAttach.getClass(), listaLocalidadesNewLocalidadToAttach.getCp());
                attachedListaLocalidadesNew.add(listaLocalidadesNewLocalidadToAttach);
            }
            listaLocalidadesNew = attachedListaLocalidadesNew;
            provincia.setListaLocalidades(listaLocalidadesNew);
            provincia = em.merge(provincia);
            if (unaZonaOld != null && !unaZonaOld.equals(unaZonaNew)) {
                unaZonaOld.getListaProvincias().remove(provincia);
                unaZonaOld = em.merge(unaZonaOld);
            }
            if (unaZonaNew != null && !unaZonaNew.equals(unaZonaOld)) {
                unaZonaNew.getListaProvincias().add(provincia);
                unaZonaNew = em.merge(unaZonaNew);
            }
            for (Localidad listaLocalidadesOldLocalidad : listaLocalidadesOld) {
                if (!listaLocalidadesNew.contains(listaLocalidadesOldLocalidad)) {
                    listaLocalidadesOldLocalidad.setUnaProvincia(null);
                    listaLocalidadesOldLocalidad = em.merge(listaLocalidadesOldLocalidad);
                }
            }
            for (Localidad listaLocalidadesNewLocalidad : listaLocalidadesNew) {
                if (!listaLocalidadesOld.contains(listaLocalidadesNewLocalidad)) {
                    Provincia oldUnaProvinciaOfListaLocalidadesNewLocalidad = listaLocalidadesNewLocalidad.getUnaProvincia();
                    listaLocalidadesNewLocalidad.setUnaProvincia(provincia);
                    listaLocalidadesNewLocalidad = em.merge(listaLocalidadesNewLocalidad);
                    if (oldUnaProvinciaOfListaLocalidadesNewLocalidad != null && !oldUnaProvinciaOfListaLocalidadesNewLocalidad.equals(provincia)) {
                        oldUnaProvinciaOfListaLocalidadesNewLocalidad.getListaLocalidades().remove(listaLocalidadesNewLocalidad);
                        oldUnaProvinciaOfListaLocalidadesNewLocalidad = em.merge(oldUnaProvinciaOfListaLocalidadesNewLocalidad);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = provincia.getCodigoProv();
                if (findProvincia(id) == null) {
                    throw new NonexistentEntityException("The provincia with id " + id + " no longer exists.");
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
            Provincia provincia;
            try {
                provincia = em.getReference(Provincia.class, id);
                provincia.getCodigoProv();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The provincia with id " + id + " no longer exists.", enfe);
            }
            Zona unaZona = provincia.getUnaZona();
            if (unaZona != null) {
                unaZona.getListaProvincias().remove(provincia);
                unaZona = em.merge(unaZona);
            }
            ArrayList<Localidad> listaLocalidades = provincia.getListaLocalidades();
            for (Localidad listaLocalidadesLocalidad : listaLocalidades) {
                listaLocalidadesLocalidad.setUnaProvincia(null);
                listaLocalidadesLocalidad = em.merge(listaLocalidadesLocalidad);
            }
            em.remove(provincia);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Provincia> findProvinciaEntities() {
        return findProvinciaEntities(true, -1, -1);
    }

    public List<Provincia> findProvinciaEntities(int maxResults, int firstResult) {
        return findProvinciaEntities(false, maxResults, firstResult);
    }

    private List<Provincia> findProvinciaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Provincia.class));
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

    public Provincia findProvincia(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Provincia.class, id);
        } finally {
            em.close();
        }
    }

    public int getProvinciaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Provincia> rt = cq.from(Provincia.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
