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
import model.Proveedor;



public class ProveedorJpaController implements Serializable{
    

   //constructor
    public ProveedorJpaController(EntityManagerFactory emf) {
    this.emf = emf;
}
    private EntityManagerFactory emf = null;
    
    public ProveedorJpaController() {
   emf= Persistence.createEntityManagerFactory("ElMercaditoPU");
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

//metodo de jpaController. Create
    public void create(Proveedor proveedor) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(proveedor);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProveedor(proveedor.getDni()) != null) {
                throw new PreexistingEntityException("proveedor" + proveedor + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        
        }
    }
//    metodo de jpaController. edit
    public void edit(Proveedor proveedor) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            proveedor= em.merge(proveedor);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = proveedor.getDni();
                if (findProveedor(id) == null) {
                    throw new NonexistentEntityException("The proveedor with id " + id+ " no longer exists.");
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
    public Proveedor findProveedor(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Proveedor.class, id);
        } finally {
            em.close();
        }
    }


    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Proveedor proveedor;
            try {
                proveedor = em.getReference(Proveedor.class, id);
                proveedor.getDni();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The proveedor with nroCuil " + id + " no longer exists.", enfe);
            }
            em.remove(proveedor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
///método de jpa controller: obtener varios elementos
    public List<Proveedor> findProveedorEntities() {
        return findProveedorEntities(true, -1, -1);
    }

    public List<Proveedor> findProveedorEntities(int maxResults, int firstResult) {
        return findProveedorEntities(false, maxResults, firstResult);
    }

    private List<Proveedor> findProveedorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Proveedor as o");
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
    public int getProveedorCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from Proveedor as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
//    private Object findProveedor(String id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

   
    public Object findProveedor(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}


