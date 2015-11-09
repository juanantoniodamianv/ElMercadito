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
import model.TicketVta;

/**
 *
 * @author daniel
 */

public class TicketVtaJpaController implements Serializable {
    

   //constructor
    public TicketVtaJpaController(EntityManagerFactory emf) {
    this.emf = emf;
}
    private EntityManagerFactory emf = null;
    public TicketVtaJpaController() {
   emf= Persistence.createEntityManagerFactory("El_mercaditoPU");
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

//metodo de jpaController. Create
    public void create(TicketVta ticketVta) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(ticketVta);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTicketVta(ticketVta.getNroComprobante()) != null) {
                throw new PreexistingEntityException("ticketVta " + ticketVta + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        
        }
    }
//    metodo de jpaController. edit
    public void edit(TicketVta ticketVta) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
           ticketVta= em.merge(ticketVta);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = ticketVta.getNroComprobante();
                if (findTicketVta(id) == null) {
                    throw new NonexistentEntityException("The ticketVta with id " + id+ " no longer exists.");
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
    public TicketVta findTicketVta(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TicketVta.class, id);
        } finally {
            em.close();
        }
    }


    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TicketVta ticketVta;
            try {
                ticketVta = em.getReference(TicketVta.class, id);
                ticketVta.getNroComprobante();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ticketVta with nroComprobante " + id + " no longer exists.", enfe);
            }
            em.remove(ticketVta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
