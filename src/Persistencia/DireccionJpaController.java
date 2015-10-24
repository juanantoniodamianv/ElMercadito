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
import model.Direccion;

/**
 *
 * @author daniel
 */

public class DireccionJpaController implements Serializable{
     
   //constructor
    public DireccionJpaController(EntityManagerFactory emf) {
    this.emf = emf;
}
    private EntityManagerFactory emf = null;
    
    public DireccionJpaController() {
   emf= Persistence.createEntityManagerFactory("ElMercaditoPU");
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

//metodo de jpaController. Create
    public void create(Direccion direccion) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(direccion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDireccion(direccion.getCodigo()) != null) {
                throw new PreexistingEntityException("Direccion" + direccion + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        
        }
    }
//    metodo de jpaController. edit
    public void edit(Direccion direccion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            direccion= em.merge(direccion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = direccion.getCodigo();
                if (findDireccion(id) == null) {
                    throw new NonexistentEntityException("The Direccion with id " + id+ " no longer exists.");
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
    public Direccion findDireccion(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Direccion.class, id);
        } finally {
            em.close();
        }
    }


    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Direccion direccion;
            try {
                direccion = em.getReference(Direccion.class, id);
                direccion.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The direccion with codigo " + id + " no longer exists.", enfe);
            }
            em.remove(direccion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
