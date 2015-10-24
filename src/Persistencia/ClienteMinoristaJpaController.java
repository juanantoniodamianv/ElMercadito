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
import model.ClienteMinorista;

/**
 *
 * @author daniel
 */
public class ClienteMinoristaJpaController implements Serializable{
    
   //constructor
    public ClienteMinoristaJpaController(EntityManagerFactory emf) {
    this.emf = emf;
}
    private EntityManagerFactory emf = null;
    
    public ClienteMinoristaJpaController() {
   emf= Persistence.createEntityManagerFactory("ElMercaditoPU");
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

//metodo de jpaController. Create
    public void create(ClienteMinorista clienteMinorista) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(clienteMinorista);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findClienteMinorista(clienteMinorista.getDni()) != null) {
                throw new PreexistingEntityException("cliente minorista " + clienteMinorista + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        
        }
    }
//    metodo de jpaController. edit
    public void edit(ClienteMinorista clienteMinorista) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            clienteMinorista= em.merge(clienteMinorista);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = clienteMinorista.getDni();
                if (findClienteMinorista(id) == null) {
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
    public ClienteMinorista findClienteMinorista(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ClienteMinorista.class, id);
        } finally {
            em.close();
        }
    }


    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ClienteMinorista clienteMinorista;
            try {
                clienteMinorista = em.getReference(ClienteMinorista.class, id);
                clienteMinorista.getDni();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cliente Minorista with dni " + id + " no longer exists.", enfe);
            }
            em.remove(clienteMinorista);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    private Object findClienteMinorista(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
