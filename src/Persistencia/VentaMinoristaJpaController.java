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
import model.VentaMinorista;

/**
 *
 * @author daniel
 */
public class VentaMinoristaJpaController implements Serializable{


   
   //constructor
    public VentaMinoristaJpaController(EntityManagerFactory emf) {
    this.emf = emf;
}
    private EntityManagerFactory emf = null;
    public VentaMinoristaJpaController() {
//   emf= Persistence.createEntityManagerFactory("ElMercaditoPU");
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

//metodo de jpaController. Create
    public void create(VentaMinorista ventaMinorista) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(ventaMinorista);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findVentaMinorista(ventaMinorista.getCodigoVta()) != null) {
                throw new PreexistingEntityException("VentaMinorista" + ventaMinorista + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        
        }
    }
//    metodo de jpaController. edit
    public void edit(VentaMinorista ventaMinorista) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
           ventaMinorista= em.merge(ventaMinorista);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = ventaMinorista.getCodigoVta();
                if (findVentaMinorista(id) == null) {
                    throw new NonexistentEntityException("The ventaMinorista with id " + id+ " no longer exists.");
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
    public VentaMinorista findVentaMinorista(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(VentaMinorista.class, id);
        } finally {
            em.close();
        }
    }


    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            VentaMinorista ventaMinorista;
            try {
                ventaMinorista = em.getReference(VentaMinorista.class, id);
                ventaMinorista.getCodigoVta();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ventaMinorista with codigoVta " + id + " no longer exists.", enfe);
            }
            em.remove(ventaMinorista);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    
}
