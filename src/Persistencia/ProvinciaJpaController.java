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
import model.Provincia;

/**
 *
 * @author daniel
 */


public class ProvinciaJpaController implements Serializable{
     
   //constructor
    public ProvinciaJpaController(EntityManagerFactory emf) {
    this.emf = emf;
}
    private EntityManagerFactory emf = null;
    
    public ProvinciaJpaController() {
   emf= Persistence.createEntityManagerFactory("ElMercaditoPU");
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

//metodo de jpaController. Create
    public void create(Provincia provincia) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(provincia);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProvincia(provincia.getCodigoProv()) != null) {
                throw new PreexistingEntityException("Provincia" + provincia + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        
        }
    }
//    metodo de jpaController. edit
    public void edit(Provincia provincia) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            provincia= em.merge(provincia);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = provincia.getCodigoProv();
                if (findProvincia(id) == null) {
                    throw new NonexistentEntityException("The Provincia with id " + id+ " no longer exists.");
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
    public Provincia findProvincia(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Provincia.class, id);
        } finally {
            em.close();
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
                throw new NonexistentEntityException("The provincia with codigoProv " + id + " no longer exists.", enfe);
            }
            em.remove(provincia);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

        
}  

