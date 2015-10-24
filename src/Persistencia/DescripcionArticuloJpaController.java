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
import model.DescripcionArticulo;

/**
 *
 * @author daniel
 */
public class DescripcionArticuloJpaController implements Serializable{
   
   //constructor
    public DescripcionArticuloJpaController(EntityManagerFactory emf) {
    this.emf = emf;
}
    private EntityManagerFactory emf = null;
    
    public DescripcionArticuloJpaController() {
   emf= Persistence.createEntityManagerFactory("ElMercaditoPU");
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

//metodo de jpaController. Create
    public void create(DescripcionArticulo descripcionArticulo) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(descripcionArticulo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDescripcionArticulo(descripcionArticulo.getCodigoBarra()) != null) {
                throw new PreexistingEntityException("descripcionArticulo " + descripcionArticulo + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        
        }
    }
//    metodo de jpaController. edit
    public void edit(DescripcionArticulo descripcionArticulo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            descripcionArticulo= em.merge(descripcionArticulo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = descripcionArticulo.getCodigoBarra();
                if (findDescripcionArticulo(id) == null) {
                    throw new NonexistentEntityException("The descripcionArticulo with id " + id+ " no longer exists.");
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
    public DescripcionArticulo findDescripcionArticulo(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DescripcionArticulo.class, id);
        } finally {
            em.close();
        }
    }


    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DescripcionArticulo descripcionArticulo;
            try {
                descripcionArticulo = em.getReference(DescripcionArticulo.class, id);
                descripcionArticulo.getCodigoBarra();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The descripcionArticulo with Codigo Barra " + id + " no longer exists.", enfe);
            }
            em.remove(descripcionArticulo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    private Object findDescripcionArticulo(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

