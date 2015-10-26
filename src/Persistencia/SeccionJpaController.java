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
import model.Seccion;

/**
 *
 * @author daniel
 */
   
public class SeccionJpaController implements Serializable{
    
   //constructor
    public SeccionJpaController(EntityManagerFactory emf) {
    this.emf = emf;
}
    private EntityManagerFactory emf = null;
    public SeccionJpaController() {
   emf= Persistence.createEntityManagerFactory("ElMercaditoPU");
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

//metodo de jpaController. Create
    public void create(Seccion seccion) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(seccion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (null != findSeccion(seccion.getNroSeccion())) {
                throw new PreexistingEntityException("Seccion " + seccion + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        
        }
    }
//    metodo de jpaController. edit
    public void edit(Seccion seccion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            seccion= em.merge(seccion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = seccion.getNroSeccion();
                if (findSeccion(id) == null) {
                    throw new NonexistentEntityException("The seccion with id " + id+ " no longer exists.");
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
    public Seccion findSeccion(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Seccion.class, id);
        } finally {
            em.close();
        }
    }


    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Seccion seccion;
            try {
                seccion = em.getReference(Seccion.class, id);
                seccion.getNroSeccion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The seccion with nroSeccion " + id + " no longer exists.", enfe);
            }
            em.remove(seccion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
        
    }

