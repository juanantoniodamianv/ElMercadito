/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package Persistencia;
//
//import Persistencia.exceptions.NonexistentEntityException;
//import Persistencia.exceptions.PreexistingEntityException;
//import java.io.Serializable;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityNotFoundException;
//import javax.persistence.Persistence;
//import model.ListaDePrecio;
//
///**
// *
// * @author daniel
// */
//
//
//public class ListaDePrecioJpaController implements Serializable{
//    
//   //constructor
//    public ListaDePrecioJpaController(EntityManagerFactory emf) {
//    this.emf = emf;
//}
//    private EntityManagerFactory emf = null;
//    
//    public ListaDePrecioJpaController() {
//   emf= Persistence.createEntityManagerFactory("ElMercaditoPU");
//    }
//    
//    public EntityManager getEntityManager() {
//        return emf.createEntityManager();
//    }
//
////metodo de jpaController. Create
//    public void create(ListaDePrecio listaDePrecio) throws PreexistingEntityException, Exception {
//        EntityManager em = null;
//        try {
//            em = getEntityManager();
//            em.getTransaction().begin();
//            em.persist(listaDePrecio);
//            em.getTransaction().commit();
//        } catch (Exception ex) {
//            if (findEncargado(listaDePrecio.getCodigoBarra()) != null) {
//                throw new PreexistingEntityException("Encargado " + encargado + " already exists.", ex);
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
//    public void edit(Encargado encargado) throws NonexistentEntityException, Exception {
//        EntityManager em = null;
//        try {
//            em = getEntityManager();
//            em.getTransaction().begin();
//            encargado= em.merge(encargado);
//            em.getTransaction().commit();
//        } catch (Exception ex) {
//            String msg = ex.getLocalizedMessage();
//            if (msg == null || msg.length() == 0) {
//                String id = encargado.getDni();
//                if (findEncargado(id) == null) {
//                    throw new NonexistentEntityException("The encargado with id " + id+ " no longer exists.");
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
//    public Encargado findEncargado(int id) {
//        EntityManager em = getEntityManager();
//        try {
//            return em.find(Encargado.class, id);
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
//            Encargado encargado;
//            try {
//               encargado = em.getReference(Encargado.class, id);
//                encargado.getDni();
//            } catch (EntityNotFoundException enfe) {
//                throw new NonexistentEntityException("The encargado with dni " + id + " no longer exists.", enfe);
//            }
//            em.remove(encargado);
//            em.getTransaction().commit();
//        } finally {
//            if (em != null) {
//                em.close();
//            }
//        }
//    }
//
//    private Object findEncargado(String id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    } 
//}
