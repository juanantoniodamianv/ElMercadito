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
import model.Comprobante;

/**
 *
 * @author daniel
 */
public class ComprobanteJpaController implements Serializable{
     
   //constructor
    public ComprobanteJpaController(EntityManagerFactory emf) {
    this.emf = emf;
}
    private EntityManagerFactory emf = null;
    
    public ComprobanteJpaController() {
   emf= Persistence.createEntityManagerFactory("ElMercaditoPU");
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

//metodo de jpaController. Create
    public void create(Comprobante comprobante) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(comprobante);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findComprobante(comprobante.getNroComprobante()) != null) {
                throw new PreexistingEntityException("comprobante " + comprobante + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        
        }
    }
//    metodo de jpaController. edit
    public void edit(Comprobante comprobante) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            comprobante= em.merge(comprobante);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = comprobante.getNroComprobante();
                if (findComprobante(id) == null) {
                    throw new NonexistentEntityException("The comprobante with id " + id+ " no longer exists.");
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
    public Comprobante findComprobante(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Comprobante.class, id);
        } finally {
            em.close();
        }
    }


    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Comprobante comprobante;
            try {
                comprobante = em.getReference(Comprobante.class, id);
                comprobante.getNroComprobante();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The comprobante with nroComprobante " + id + " no longer exists.", enfe);
            }
            em.remove(comprobante);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
