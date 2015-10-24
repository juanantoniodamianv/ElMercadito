/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Bulto;

/**
 *
 * @author daniel
 */
public class BultoJpaController implements Serializable{
    
   //constructor
    public BultoJpaController(EntityManagerFactory emf) {
    this.emf = emf;
}
    private EntityManagerFactory emf = null;
    public BultoJpaController() {
   emf= Persistence.createEntityManagerFactory("ElMercaditoPU");
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

//metodo de jpaController. Create
    public void create(Bulto bulto) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(bulto);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findBulto(bulto.getNroBulto()) != null) {
                throw new PreexistingEntityException("Bulto " + bulto + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        
        }
    }
//    metodo de jpaController. edit
    public void edit(Bulto bulto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            bulto= em.merge(bulto);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = bulto.getNroBulto();
                if (findBulto(id) == null) {
                    throw new NonexistentEntityException("The bulto with id " + id+ " no longer exists.");
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
    public Bulto findBulto(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Bulto.class, id);
        } finally {
            em.close();
        }
    }


    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Bulto bulto;
            try {
                bulto = em.getReference(Bulto.class, id);
                bulto.getNroBulto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The bulto with nroBulto " + id + " no longer exists.", enfe);
            }
            em.remove(bulto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }


//método de jpa controller: obtener varios elementos
    public List<Bulto> findBultoEntities() {
        return findBultoEntities(true, -1, -1);
    }

    public List<Bulto> findBultoEntities(int maxResults, int firstResult) {
        return findBultoEntities(false, maxResults, firstResult);
    }

    private List<Bulto> findBultoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Bulto as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }


//metodo de jpaController: obtener cantidad de elementos persistidos
    public int getBultoCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from Bulto as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    void destroy(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Bulto findBulto(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}