/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ElMercadito;
import view.*;
import Persistencia.ArticuloJpaController;
import Persistencia.CajaJpaController;
import Persistencia.ControladoraPersistencia;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Articulo;
import model.Caja;
import model.Sucursal;

/**
 *
 * @author Antonio
 */
public class ElMercadito {
private Sucursal unaSucursal = new Sucursal(1,"cuil","telefono","razon social");

    public Sucursal getUnaSucursal() {
        return unaSucursal;
    }
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
            @Override
            public void run() {
                new JFramePrincipal().setVisible(true);
                
            }
        });
        EntityManagerFactory objFactory;
        objFactory = Persistence.createEntityManagerFactory("El_mercaditoPU");
        EntityManager manager = objFactory.createEntityManager();
        ArticuloJpaController jpa = new ArticuloJpaController(objFactory);
        List<Articulo> lista = jpa.findArticuloEntities();
        CajaJpaController jpaCaja = new CajaJpaController(objFactory);
        List<Caja> listaCaja = jpaCaja.findCajaEntities();
        
         //que loco       
        Articulo art = new Articulo();
        art.setNroArticulo(15961);
        art.setLote("22-09-2015");
        art.setFechaElabora("22-09-2015");
        art.setFechaExpira("15-11-2016");
        jpa.create(art);
        
        Caja caj = new Caja();
        caj.setNroCaja(152);
        jpaCaja.create(caj);
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

    public Object getSucursal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    }
    

    
//   