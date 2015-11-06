/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ElMercadito;
import Persistencia.ArticuloJpaController;
import Persistencia.CajaJpaController;
import Persistencia.CajeroJpaController;
import Persistencia.ControladoraPersistencia;
import Persistencia.PersonaJpaController;
import Persistencia.ProveedorJpaController;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Articulo;
import model.Caja;
import model.Cajero;
import model.Persona;
import model.Proveedor;
import model.Sucursal;
import view.*;

/**
 *
 * @author Antonio
 * autor autor autor
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
        /*
        EntityManagerFactory objFactory;
        objFactory = Persistence.createEntityManagerFactory("El_mercaditoPU");
        EntityManager manager = objFactory.createEntityManager();
        CajeroJpaController jpaCajero = new CajeroJpaController(objFactory);
        Cajero unCajero = new Cajero();
        unCajero.setIdPersona("2034221189");
        unCajero.setApellido("Vargas");
        unCajero.setNombre("Marcelo");
        unCajero.setFechaNac("31-01-1989");
        unCajero.setSexo("Masculino");
        unCajero.setEstadoCivil("Soltero");
        unCajero.setFechaIngreso("04-11-2015");
        unCajero.setCargo("Cajero");
        unCajero.setNroCajaAsignada(1);
        jpaCajero.create(unCajero);
       
        ArticuloJpaController jpa = new ArticuloJpaController(objFactory);
        List<Articulo> lista = jpa.findArticuloEntities();
        CajaJpaController jpaCaja = new CajaJpaController(objFactory);
        List<Caja> listaCaja = jpaCaja.findCajaEntities();
        
        PersonaJpaController jpaPersona = new PersonaJpaController(objFactory);
        List<Persona> listaPersona = jpaPersona.findPersonaEntities();
        ProveedorJpaController jpaProveedor = new ProveedorJpaController();
        List<Proveedor> listaProveedor = jpaProveedor.findProveedorEntities();       
       
        Proveedor prov = new Proveedor();
        prov.setRazonSocial("Pomaco S.A.");
        prov.setSituacionTributaria("Monotributista");
        prov.setTipoProveduria("Materiales de construcción");
        prov.setIdPersona("21148774589");
        prov.setTelefono("3764658945");
        prov.setDireccion("España 3415");
        prov.setLocalidad("Posadas");
        prov.setProvincia("Misiones");
        jpaProveedor.create(prov);
        
        Proveedor prov2 = new Proveedor();
        prov2.setRazonSocial("Aniway S.A.");
        prov2.setSituacionTributaria("Monotributista");
        prov2.setTipoProveduria("Insumos informáticos");
        prov2.setIdPersona("23148765439");
        prov2.setTelefono("3764764387");
        prov2.setDireccion("Colón 2021");
        prov2.setLocalidad("Posadas");
        prov2.setProvincia("Misiones");
        jpaProveedor.create(prov2);
        
                
                
                
        Articulo art = new Articulo();
        art.setNroArticulo(3);
        art.setLote("22-09-2015");
        art.setFechaElabora("22-09-2015");
        art.setFechaExpira("15-11-2016");
        jpa.create(art);
        
        Caja caj = new Caja();
        caj.setNroCaja(3);
        jpaCaja.create(caj);*/
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
    

    