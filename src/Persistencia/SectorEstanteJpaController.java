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
import model.SectorEstante;




/**
 *
 * @author daniel
 */
   
public class SectorEstanteJpaController implements Serializable{
    
   //constructor
    public SectorEstanteJpaController(EntityManagerFactory emf) {
    this.emf = emf;
}
    private EntityManagerFactory emf = null;
    public SectorEstanteJpaController() {
   emf= Persistence.createEntityManagerFactory("ElMercaditoPU");
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

//metodo de jpaController. Create
    public void create(SectorEstante sectorEstante) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(sectorEstante);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (null != findSectorEstante(sectorEstante.getNroSectorEstante())) {
                throw new PreexistingEntityException("SectorEstante " + sectorEstante + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        
        }
    }
//    metodo de jpaController. edit
    public void edit(SectorEstante sectorEstante) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            sectorEstante= em.merge(sectorEstante);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = sectorEstante.getNroSectorEstante();
                if (findSectorEstante(id) == null) {
                    throw new NonexistentEntityException("The sectorEstante with id " + id+ " no longer exists.");
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
    public SectorEstante findSectorEstante(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(SectorEstante.class, id);
        } finally {
            em.close();
        }
    }


    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            SectorEstante sectorEstante;
            try {
                sectorEstante = em.getReference(SectorEstante.class, id);
                sectorEstante.getNroSectorEstante();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The sectorEstante with nroSectorEstante " + id + " no longer exists.", enfe);
            }
            em.remove(sectorEstante);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    
}
