/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ElMercadito;
import Persistencia.ArticuloJpaController;
import Persistencia.CajaJpaController;
import Persistencia.ControladoraPersistencia;
import Persistencia.PersonaJpaController;
import Persistencia.ProveedorJpaController;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Articulo;
import model.Caja;
import model.Persona;
import model.Proveedor;
import model.Sucursal;
import view.*;

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
        
        ArticuloJpaController jpa = new ArticuloJpaController(objFactory);
        List<Articulo> lista = jpa.findArticuloEntities();
        CajaJpaController jpaCaja = new CajaJpaController(objFactory);
        List<Caja> listaCaja = jpaCaja.findCajaEntities();
        /*
        PersonaJpaController jpaPersona = new PersonaJpaController(objFactory);
        List<Persona> listaPersona = jpaPersona.findPersonaEntities();
        ProveedorJpaController jpaProveedor = new ProveedorJpaController(objFactory);
        List<Proveedor> listaProveedor = jpaProveedor.findProveedorEntities();
        
        
         
        Persona pers = new Persona();
        pers.setDni("34826083");
        pers.setNombre("Antonio");
        pers.setApellido("Vargas");
        pers.setDireccion("Chile 5815");
        pers.setProvincia("Misiones");
        pers.setLocalidad("Posadas");
        pers.setTelefono("3764658407");
        pers.setFechaNac("28-03-1991");
        jpaPersona.create(pers);
        
        Proveedor prov = new Proveedor();
        
        prov.setCuit("23348260839");
        prov.setNroProveedor("1");
        prov.setRazonSocial("Corsica S.A.");
        prov.setSituacionTributaria("Monotributista");
                
        jpaProveedor.create(prov);*/
        
                
                
                
        Articulo art = new Articulo();
        art.setNroArticulo(15939);
        art.setLote("22-09-2015");
        art.setFechaElabora("22-09-2015");
        art.setFechaExpira("15-11-2016");
        jpa.create(art);
        
        Caja caj = new Caja();
        caj.setNroCaja(143);
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

    
    }
    

    
//   