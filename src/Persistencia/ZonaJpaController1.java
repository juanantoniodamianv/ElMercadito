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
import model.Provincia;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import model.Zona;

/**
 *
 * @author daniel
 */
public class ZonaJpaController1 implements Serializable {

    public ZonaJpaController1(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Zona zona) {
        if (zona.getListaProvincias() == null) {
            zona.setListaProvincias(new ArrayList<Provincia>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ArrayList<Provincia> attachedListaProvincias = new ArrayList<Provincia>();
            for (Provincia listaProvinciasProvinciaToAttach : zona.getListaProvincias()) {
                listaProvinciasProvinciaToAttach = em.getReference(listaProvinciasProvinciaToAttach.getClass(), listaProvinciasProvinciaToAttach.getCodigoProv());
                attachedListaProvincias.add(listaProvinciasProvinciaToAttach);
            }
            zona.setListaProvincias(attachedListaProvincias);
            em.persist(zona);
            for (Provincia listaProvinciasProvincia : zona.getListaProvincias()) {
                Zona oldUnaZonaOfListaProvinciasProvincia = listaProvinciasProvincia.getUnaZona();
                listaProvinciasProvincia.setUnaZona(zona);
                listaProvinciasProvincia = em.merge(listaProvinciasProvincia);
                if (oldUnaZonaOfListaProvinciasProvincia != null) {
                    oldUnaZonaOfListaProvinciasProvincia.getListaProvincias().remove(listaProvinciasProvincia);
                    oldUnaZonaOfListaProvinciasProvincia = em.merge(oldUnaZonaOfListaProvinciasProvincia);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Zona zona) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Zona persistentZona = em.find(Zona.class, zona.getCodigoZona());
            ArrayList<Provincia> listaProvinciasOld = persistentZona.getListaProvincias();
            ArrayList<Provincia> listaProvinciasNew = zona.getListaProvincias();
            ArrayList<Provincia> attachedListaProvinciasNew = new ArrayList<Provincia>();
            for (Provincia listaProvinciasNewProvinciaToAttach : listaProvinciasNew) {
                listaProvinciasNewProvinciaToAttach = em.getReference(listaProvinciasNewProvinciaToAttach.getClass(), listaProvinciasNewProvinciaToAttach.getCodigoProv());
                attachedListaProvinciasNew.add(listaProvinciasNewProvinciaToAttach);
            }
            listaProvinciasNew = attachedListaProvinciasNew;
            zona.setListaProvincias(listaProvinciasNew);
            zona = em.merge(zona);
            for (Provincia listaProvinciasOldProvincia : listaProvinciasOld) {
                if (!listaProvinciasNew.contains(listaProvinciasOldProvincia)) {
                    listaProvinciasOldProvincia.setUnaZona(null);
                    listaProvinciasOldProvincia = em.merge(listaProvinciasOldProvincia);
                }
            }
            for (Provincia listaProvinciasNewProvincia : listaProvinciasNew) {
                if (!listaProvinciasOld.contains(listaProvinciasNewProvincia)) {
                    Zona oldUnaZonaOfListaProvinciasNewProvincia = listaProvinciasNewProvincia.getUnaZona();
                    listaProvinciasNewProvincia.setUnaZona(zona);
                    listaProvinciasNewProvincia = em.merge(listaProvinciasNewProvincia);
                    if (oldUnaZonaOfListaProvinciasNewProvincia != null && !oldUnaZonaOfListaProvinciasNewProvincia.equals(zona)) {
                        oldUnaZonaOfListaProvinciasNewProvincia.getListaProvincias().remove(listaProvinciasNewProvincia);
                        oldUnaZonaOfListaProvinciasNewProvincia = em.merge(oldUnaZonaOfListaProvinciasNewProvincia);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = zona.getCodigoZona();
                if (findZona(id) == null) {
                    throw new NonexistentEntityException("The zona with id " + id + " no longer exists.");
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
            Zona zona;
            try {
                zona = em.getReference(Zona.class, id);
                zona.getCodigoZona();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The zona with id " + id + " no longer exists.", enfe);
            }
            ArrayList<Provincia> listaProvincias = zona.getListaProvincias();
            for (Provincia listaProvinciasProvincia : listaProvincias) {
                listaProvinciasProvincia.setUnaZona(null);
                listaProvinciasProvincia = em.merge(listaProvinciasProvincia);
            }
            em.remove(zona);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Zona> findZonaEntities() {
        return findZonaEntities(true, -1, -1);
    }

    public List<Zona> findZonaEntities(int maxResults, int firstResult) {
        return findZonaEntities(false, maxResults, firstResult);
    }

    private List<Zona> findZonaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Zona.class));
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

    public Zona findZona(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Zona.class, id);
        } finally {
            em.close();
        }
    }

    public int getZonaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Zona> rt = cq.from(Zona.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
