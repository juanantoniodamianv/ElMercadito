/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import model.Zona;

/**
 *
 * @author daniel
 */
public class ZonaJpaController implements Serializable{
  
     
   //constructor
    public ZonaJpaController(EntityManagerFactory emf) {
    this.emf = emf;
}
    private EntityManagerFactory emf = null;
    
    public ZonaJpaController() {
   emf= Persistence.createEntityManagerFactory("ElMercaditoPU");
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

//metodo de jpaController. Create
    public void create(Zona zona) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(zona);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findZona(zona.getCodigoZona()) != null) {
                throw new PreexistingEntityException("Zona" + zona + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        
        }
    }
//    metodo de jpaController. edit
    public void edit(Zona zona) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            zona= em.merge(zona);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = zona.getCodigoZona();
                if (findZona(id) == null) {
                    throw new NonexistentEntityException("The Zona with id " + id+ " no longer exists.");
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
    public Zona findZona(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Zona.class, id);
        } finally {
            em.close();
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
                throw new NonexistentEntityException("The zona with codigoZona " + id + " no longer exists.", enfe);
            }
            em.remove(zona);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
