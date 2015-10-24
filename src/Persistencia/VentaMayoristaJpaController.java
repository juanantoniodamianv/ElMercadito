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
import model.VentaMayorista;

/**
 *
 * @author daniel
 */

public class VentaMayoristaJpaController implements Serializable{
   
   //constructor
    public VentaMayoristaJpaController(EntityManagerFactory emf) {
    this.emf = emf;
}
    private EntityManagerFactory emf = null;
    public VentaMayoristaJpaController() {
   emf= Persistence.createEntityManagerFactory("ElMercaditoPU");
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

//metodo de jpaController. Create
    public void create(VentaMayorista ventaMayorista) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(ventaMayorista);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findVentaMayorista(ventaMayorista.getCodigoVta()) != null) {
                throw new PreexistingEntityException("ventaMayorista" + ventaMayorista + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        
        }
    }
//    metodo de jpaController. edit
    public void edit(VentaMayorista ventaMayorista) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
           ventaMayorista= em.merge(ventaMayorista);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = ventaMayorista.getCodigoVta();
                if (findVentaMayorista(id) == null) {
                    throw new NonexistentEntityException("The ventaMayorista with id " + id+ " no longer exists.");
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
    public VentaMayorista findVentaMayorista(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(VentaMayorista.class, id);
        } finally {
            em.close();
        }
    }


    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            VentaMayorista ventaMayorista;
            try {
                ventaMayorista = em.getReference(VentaMayorista.class, id);
                ventaMayorista.getCodigoVta();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ventaMayorista with codigoVta " + id + " no longer exists.", enfe);
            }
            em.remove(ventaMayorista);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    
}
