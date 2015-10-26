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
import model.OrdenCompra;

/**
 *
 * @author daniel
 */

public class OrdenCompraJpaController implements Serializable{
    
   //constructor
    public OrdenCompraJpaController(EntityManagerFactory emf) {
    this.emf = emf;
}
    private EntityManagerFactory emf = null;
    public OrdenCompraJpaController() {
   emf= Persistence.createEntityManagerFactory("ElMercaditoPU");
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

//metodo de jpaController. Create
    public void create(OrdenCompra ordenCompra) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(ordenCompra);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findOrdenCompra(ordenCompra.getNroComprobante()) != null) {
                throw new PreexistingEntityException("OrdenCompra " + ordenCompra + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        
        }
    }
//    metodo de jpaController. edit
    public void edit(OrdenCompra ordenCompra) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
           ordenCompra= em.merge(ordenCompra);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = ordenCompra.getNroComprobante();
                if (findOrdenCompra(id) == null) {
                    throw new NonexistentEntityException("The ordenCompra with id " + id+ " no longer exists.");
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
    public OrdenCompra findOrdenCompra(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(OrdenCompra.class, id);
        } finally {
            em.close();
        }
    }


    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            OrdenCompra ordenCompra;
            try {
                ordenCompra = em.getReference(OrdenCompra.class, id);
                ordenCompra.getNroComprobante();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ordenCompra with nroComprobante " + id + " no longer exists.", enfe);
            }
            em.remove(ordenCompra);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
