/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import model.Articulo;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
/**
 *
 * @author daniel
 */
//public class ArticuloJpaController implements Serializable{
//   //constructor
//    public ArticuloJpaController(EntityManagerFactory emf) {
//    this.emf = emf;
//}
//    private EntityManagerFactory emf = null;
//    public ArticuloJpaController() {
//      emf= Persistence.createEntityManagerFactory("ElMercaditoPU");
//    }
//
//    public EntityManager getEntityManager() {
//        return emf.createEntityManager();
//    }
//
////metodo de jpaController. Create
//    public void create(Articulo articulo) throws PreexistingEntityException, Exception {
//        EntityManager em = null;
//        try {
//            em = getEntityManager();
//            em.getTransaction().begin();
//            em.persist(articulo);
//            em.getTransaction().commit();
//        } catch (Exception ex) {
//            if (findArticulo(articulo.getNroArticulo()) != null) {
//                throw new PreexistingEntityException("Articulo " + articulo + " already exists.", ex);
//            }
//            throw ex;
//        } finally {
//            if (em != null) {
//                em.close();
//            }
//        
//        }
//    }
////    metodo de jpaController. edit
//    public void edit(Articulo articulo) throws NonexistentEntityException, Exception {
//        EntityManager em = null;
//        try {
//            em = getEntityManager();
//            em.getTransaction().begin();
//            articulo = em.merge(articulo);
//            em.getTransaction().commit();
//        } catch (Exception ex) {
//            String msg = ex.getLocalizedMessage();
//            if (msg == null || msg.length() == 0) {
//                int id = articulo.getNroArticulo();
//                if (findArticulo(id) == null) {
//                    throw new NonexistentEntityException("The articulo with id " + id+ " no longer exists.");
//                }
//            }
//            throw ex;
//        } finally {
//            if (em != null) {
//                em.close();
//            }
//        }
//    }
////    método de jpaController: obtener un elemento
//    public Articulo findArticulo(int id) {
//        EntityManager em = getEntityManager();
//        try {
//            return em.find(Articulo.class, id);
//        } finally {
//            em.close();
//        }
//    }
//
//
//    public void destroy(int id) throws NonexistentEntityException {
//        EntityManager em = null;
//        try {
//            em = getEntityManager();
//            em.getTransaction().begin();
//            Articulo articulo;
//            try {
//                articulo = em.getReference(Articulo.class, id);
//                articulo.getNroArticulo();
//            } catch (EntityNotFoundException enfe) {
//                throw new NonexistentEntityException("The articulo with nroArticulo " + id + " no longer exists.", enfe);
//            }
//            em.remove(articulo);
//            em.getTransaction().commit();
//        } finally {
//            if (em != null) {
//                em.close();
//            }
//        }
//    }
//
//
////método de jpa controller: obtener varios elementos
//    public List<Articulo> findArticuloEntities() {
//        return findArticuloEntities(true, -1, -1);
//    }
//
//    public List<Articulo> findArticuloEntities(int maxResults, int firstResult) {
//        return findArticuloEntities(false, maxResults, firstResult);
//    }
//
//    private List<Articulo> findArticuloEntities(boolean all, int maxResults, int firstResult) {
//        EntityManager em = getEntityManager();
//        try {
//            Query q = em.createQuery("select object(o) from Articulo as o");
//            if (!all) {
//                q.setMaxResults(maxResults);
//                q.setFirstResult(firstResult);
//            }
//            return q.getResultList();
//        } finally {
//            em.close();
//        }
//    }
//
//
////metodo de jpaController: obtener cantidad de elementos persistidos
//    public int getArticuloCount() {
//        EntityManager em = getEntityManager();
//        try {
//            Query q = em.createQuery("select count(o) from Articulo as o");
//            return ((Long) q.getSingleResult()).intValue();
//        } finally {
//            em.close();
//        }
//    }
//
//    Articulo findArticulo(String id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//    
//}