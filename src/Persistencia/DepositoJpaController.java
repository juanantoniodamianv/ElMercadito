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
import model.Deposito;
/**
 *
 * @author daniel
 */

public class DepositoJpaController implements Serializable{
     
   //constructor
    public DepositoJpaController(EntityManagerFactory emf) {
    this.emf = emf;
}
    private EntityManagerFactory emf = null;
    
    public DepositoJpaController() {
   emf= Persistence.createEntityManagerFactory("ElMercaditoPU");
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

//metodo de jpaController. Create
    public void create(Deposito deposito) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(deposito);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDeposito(deposito.getNroDeposito()) != null) {
                throw new PreexistingEntityException("Deposito " + deposito + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        
        }
    }
//    metodo de jpaController. edit
    public void edit(Deposito deposito) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            deposito= em.merge(deposito);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = deposito.getNroDeposito();
                if (findDeposito(id) == null) {
                    throw new NonexistentEntityException("The deposito with id " + id+ " no longer exists.");
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
    public Deposito findDeposito(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Deposito.class, id);
        } finally {
            em.close();
        }
    }


    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Deposito deposito;
            try {
                deposito = em.getReference(Deposito.class, id);
                deposito.getNroDeposito();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The deposito with nroDeposito " + id + " no longer exists.", enfe);
            }
            em.remove(deposito);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}

