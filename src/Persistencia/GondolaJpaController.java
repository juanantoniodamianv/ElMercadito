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
import model.Gondola;

/**
 *
 * @author daniel
 */

public class GondolaJpaController implements Serializable{
     
   //constructor
    public GondolaJpaController(EntityManagerFactory emf) {
    this.emf = emf;
}
    private EntityManagerFactory emf = null;
    
    public GondolaJpaController() {
   emf= Persistence.createEntityManagerFactory("ElMercaditoPU");
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

//metodo de jpaController. Create
    public void create(Gondola gondola) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(gondola);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findGondola(gondola.getNroGondola()) != null) {
                throw new PreexistingEntityException("Gondola " + gondola + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        
        }
    }
//    metodo de jpaController. edit
    public void edit(Gondola gondola) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            gondola= em.merge(gondola);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = gondola.getNroGondola();
                if (findGondola(id) == null) {
                    throw new NonexistentEntityException("The gondola with id " + id+ " no longer exists.");
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
    public Gondola findDGondola(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Gondola.class, id);
        } finally {
            em.close();
        }
    }


    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Gondola gondola;
            try {
                gondola = em.getReference(Gondola.class, id);
                gondola.getNroGondola();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The facturaVta with nroComprobante " + id + " no longer exists.", enfe);
            }
            em.remove(gondola);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    private Object findGondola(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}


