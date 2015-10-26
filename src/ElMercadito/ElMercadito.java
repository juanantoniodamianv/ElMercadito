/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ElMercadito;
import view.*;
import Persistencia.ArticuloJpaController1;
import Persistencia.ControladoraPersistencia;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Articulo;
import model.Sucursal;

/**
 *
 * @author Antonio
 */
public class ElMercadito {
private static final Sucursal unaSucursal = new Sucursal(1,"cuil","telefono","razon social");
    private ControladoraPersistencia unaControlPersistencia;
    
    public static void main(String[] args) throws Exception{
        //Carga el estilo look and feel
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFramePrincipal().setVisible(true);
                
            }
        });
        EntityManagerFactory objFactory;
        objFactory = Persistence.createEntityManagerFactory("El_mercaditoPU");
        EntityManager manager = objFactory.createEntityManager();
        //ArticuloJpaController1 jpa = new ArticuloJpaController1(objFactory);
        //List<Articulo> lista = jpa.findArticuloEntities();
        
                
        /*Articulo art = new Articulo();
        art.setNroArticulo(15916);
        art.setLote("22-09-2015");
        art.setFechaElabora("22-09-2015");
        art.setFechaExpira("15-11-2016");
        jpa.create(art*/
        
    }

    
    public ElMercadito(ControladoraPersistencia unaControlPersistencia) {
        this.unaControlPersistencia = unaControlPersistencia;
    }


    public ControladoraPersistencia getUnaControlPersistencia() {
        return unaControlPersistencia;
    }


    public void setUnaControlPersistencia(ControladoraPersistencia unaControlPersistencia) {
        this.unaControlPersistencia = unaControlPersistencia;
    }

    
    }
    

    
//   