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
import model.RemitoVta;



public class RemitoVtaJpaController implements Serializable {
    

   //constructor
    public RemitoVtaJpaController(EntityManagerFactory emf) {
    this.emf = emf;
}
    private EntityManagerFactory emf = null;
    public RemitoVtaJpaController() {
//   emf= Persistence.createEntityManagerFactory("ElMercaditoPU");
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

//metodo de jpaController. Create
    public void create(RemitoVta remitoVta) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(remitoVta);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findRemitoVta(remitoVta.getNroComprobante()) != null) {
                throw new PreexistingEntityException("RemitoVta " + remitoVta + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        
        }
    }
//    metodo de jpaController. edit
    public void edit(RemitoVta remitoVta) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
           remitoVta= em.merge(remitoVta);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = remitoVta.getNroComprobante();
                if (findRemitoVta(id) == null) {
                    throw new NonexistentEntityException("The remitoVta with id " + id+ " no longer exists.");
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
    public RemitoVta findRemitoVta(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(RemitoVta.class, id);
        } finally {
            em.close();
        }
    }


    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            RemitoVta remitoVta;
            try {
                remitoVta = em.getReference(RemitoVta.class, id);
                remitoVta.getNroComprobante();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The remitoVta with nroComprobante " + id + " no longer exists.", enfe);
            }
            em.remove(remitoVta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    
}
