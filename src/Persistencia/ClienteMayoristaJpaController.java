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
import model.ClienteMayorista;

/**
 *
 * @author daniel
 */
public class ClienteMayoristaJpaController implements Serializable{
    
   //constructor
    public ClienteMayoristaJpaController(EntityManagerFactory emf) {
    this.emf = emf;
}
    private EntityManagerFactory emf = null;
    
    public ClienteMayoristaJpaController() {
   emf= Persistence.createEntityManagerFactory("ElMercaditoPU");
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

//metodo de jpaController. Create
    public void create(ClienteMayorista clienteMayorista) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(clienteMayorista);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findClienteMayorista(clienteMayorista.getDni()) != null) {
                throw new PreexistingEntityException("Cliente Mayorista " + clienteMayorista + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        
        }
    }
//    metodo de jpaController. edit
    public void edit(ClienteMayorista clienteMayorista) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            clienteMayorista= em.merge(clienteMayorista);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = clienteMayorista.getDni();
                if (findClienteMayorista(id) == null) {
                    throw new NonexistentEntityException("The cliente mayorista with id " + id+ " no longer exists.");
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
    public ClienteMayorista findClienteMayorista(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ClienteMayorista.class, id);
        } finally {
            em.close();
        }
    }


    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ClienteMayorista clienteMayorista;
            try {
                clienteMayorista = em.getReference(ClienteMayorista.class, id);
                clienteMayorista.getDni();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cliente mayorista with dni " + id + " no longer exists.", enfe);
            }
            em.remove(clienteMayorista);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    private Object findClienteMayorista(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}