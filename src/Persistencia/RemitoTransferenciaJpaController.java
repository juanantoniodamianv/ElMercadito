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
import model.RemitoTransferencia;

/**
 *
 * @author daniel
 */
public class RemitoTransferenciaJpaController implements Serializable {
    

   //constructor
    public RemitoTransferenciaJpaController(EntityManagerFactory emf) {
    this.emf = emf;
}
    private EntityManagerFactory emf = null;
    public RemitoTransferenciaJpaController() {
    //   emf= Persistence.createEntityManagerFactory("ElMercaditoPU");
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

//metodo de jpaController. Create
    public void create(RemitoTransferencia remitoTransferencia) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(remitoTransferencia);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findOrdenCompra(remitoTransferencia.getNroComprobante()) != null) {
                throw new PreexistingEntityException("RemitoTransferencia " + remitoTransferencia + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        
        }
    }
//    metodo de jpaController. edit
    public void edit(RemitoTransferencia remitoTransferencia) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
           remitoTransferencia= em.merge(remitoTransferencia);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = remitoTransferencia.getNroComprobante();
                if (findRemitoTransferencia(id) == null) {
                    throw new NonexistentEntityException("The remitoTransferencia with id " + id+ " no longer exists.");
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
    public RemitoTransferencia findRemitoTransferencia(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(RemitoTransferencia.class, id);
        } finally {
            em.close();
        }
    }


    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            RemitoTransferencia remitoTransferencia;
            try {
                remitoTransferencia = em.getReference(RemitoTransferencia.class, id);
                remitoTransferencia.getNroComprobante();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The remitoTransferencia with nroComprobante " + id + " no longer exists.", enfe);
            }
            em.remove(remitoTransferencia);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    private Object findOrdenCompra(int nroComprobante) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

