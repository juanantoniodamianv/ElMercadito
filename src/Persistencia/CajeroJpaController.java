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
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Articulo;
import model.Cajero;

/**
 *
 * @author daniel
 */
public class CajeroJpaController implements Serializable{
   
   //constructor
    public CajeroJpaController(EntityManagerFactory emf) {
    this.emf = emf;
}
    private EntityManagerFactory emf = null;
    public CajeroJpaController() {
   emf= Persistence.createEntityManagerFactory("ElMercaditoPU");
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

//metodo de jpaController. Create
    public void create(Cajero cajero) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(cajero);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCajero(cajero.getDni()) != null) {
                throw new PreexistingEntityException("Cajero " + cajero + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        
        }
    }
//    metodo de jpaController. edit
    public void edit(Cajero cajero) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            cajero= em.merge(cajero);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = cajero.getDni();
                if (findCajero(id) == null) {
                    throw new NonexistentEntityException("The cajero with id " + id+ " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
//    método de jpaController: obtener un elemento
    public Cajero findCajero(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cajero.class, id);
        } finally {
            em.close();
        }
    }


    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cajero cajero;
            try {
                cajero = em.getReference(Cajero.class, id);
                cajero.getDni();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cajero with dni " + id + " no longer exists.", enfe);
            }
            em.remove(cajero);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    //método de jpa controller: obtener varios elementos
    public List<Cajero> findCajeroEntities() {
        return findCajeroEntities(true, -1, -1);
    }

    public List<Cajero> findCajeroEntities(int maxResults, int firstResult) {
        return findCajeroEntities(false, maxResults, firstResult);
    }

    private List<Cajero> findCajeroEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Cajero as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }


//metodo de jpaController: obtener cantidad de elementos persistidos
    public int getCajeroCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from Cajero as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
}
}
