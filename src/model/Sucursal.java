/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

//import javax.swing.text.html.parser.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import Persistencia.ControladoraPersistencia;


/**
 *
 * @author Antonio
 */
//@Entity

public class Sucursal{
    private static final long serialVersionUID = 1L;
  

   
//    @Id
    private int nroSucursal;
 //    @Basic
    private String cuil;
 //    @Basic
    private String telefono;
 //    @Basic
    private String razonSocial;
       @Basic
    private String direccion;
 //    @OneToOne
    private Deposito unDeposito;
 //  
  //    @OneToMany
    private ArrayList<Proveedor> listaProveedores;
  //    @OneToMany
    private ArrayList<Caja> listaCajas;
  //    @OneToMany
    private ArrayList<ListaDePrecio> ListaDePrecios;
//    constructor nulo
    public Sucursal() {}
   
    public static final ControladoraPersistencia persistencia= new ControladoraPersistencia();
    
//    constructor con parámetros

    public Sucursal(int nroSucursal, String cuil, String telefono, String razonSocial, String direccion) {
        this();
        this.nroSucursal = nroSucursal;
        this.cuil = cuil;
        this.telefono = telefono;
        this.razonSocial = razonSocial;
        this.direccion = direccion;
        this.unDeposito = unDeposito;
        this.listaProveedores = listaProveedores;
        this.listaCajas = listaCajas;
        this.ListaDePrecios = ListaDePrecios;
    }

    

    public int getNroSucursal() {
        return nroSucursal;
    }

    public String getCuil() {
        return cuil;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public Deposito getUnDeposito() {
        return unDeposito;
    }

    public ArrayList<Proveedor> getListaProveedores() {
        return listaProveedores;
    }

    public ArrayList<Caja> getListaCajas() {
        return listaCajas;
    }

    public ArrayList<ListaDePrecio> getListaDePrecios() {
        return ListaDePrecios;
    }

    public void setNroSucursal(int nroSucursal) {
        this.nroSucursal = nroSucursal;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setUnDeposito(Deposito unDeposito) {
        this.unDeposito = unDeposito;
    }

    public void setListaProveedores(ArrayList<Proveedor> listaProveedores) {
        this.listaProveedores = listaProveedores;
    }

    public void setListaCajas(ArrayList<Caja> listaCajas) {
        this.listaCajas = listaCajas;
    }

    public void setListaDePrecios(ArrayList<ListaDePrecio> ListaDePrecios) {
        this.ListaDePrecios = ListaDePrecios;
    }

   

   
    

  
    public void nuevoProveedor(int nroProv, String razonSocial, String nroCuit, String dni, String apellido, String nombre, String fechaNac, String telefono, String condicionIva, String direccion, String provincia, String localidad) throws Exception {
    Proveedor prov= new Proveedor(nroProv,razonSocial,nroCuit,dni,apellido,nombre,fechaNac,telefono,condicionIva,direccion,provincia,localidad);
    this.listaProveedores.add(prov);
    Sucursal.persistencia.AgregarProveedorPersis(prov);
        
    }
    public void getListaProveedores(Proveedor prov) {
        
    }
    

      public void agregarProveedor(int nroProv, String razonSocial, String nroCuit, String dni, String apellido, String nombre, String fechaNac, String telefono, String condicionIva, String direccion, String provincia, String localidad) throws Exception {
    Proveedor prov= new Proveedor(nroProv,razonSocial,nroCuit,dni,apellido,nombre,fechaNac,telefono,condicionIva,direccion,provincia,localidad);
    this.listaProveedores.add(prov);
    Sucursal.persistencia.AgregarProveedorPersis(prov);
     }


    public void modificarProveedor(int parseInt, String text, String text0, String text1, String text2, String text3, String text4) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public Proveedor BuscarProveedorCuit(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void BuscarProveedorCuit(int parseInt, String text, String text0, String text1, String text2, String text3, String text4) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void BorrarProveedor(int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void ModificarProveedor(Proveedor unPro, int parseInt, String text, String text0, String text1, String text2, String text3, String text4) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
//       this.listaProveedores.add(prov);
//    Empresa.persistencia.AgregarProveedorPersis(prov);

  

    
    
}


    

   

    
    

