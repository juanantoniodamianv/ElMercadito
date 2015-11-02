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
@Entity
public class Sucursal implements Serializable {
    @Id
    private int nroSucursal;
    @Basic
    private String cuil;
    @Basic
    private String telefono;
    @Basic
    private String razonSocial;
    @OneToOne
    private Deposito unDeposito;
     @OneToOne
    private Direccion unaDireccion;
     @OneToMany
    private ArrayList<Proveedor> listaProveedores;
     @OneToMany
    private ArrayList<Caja> listaCajas;
     @OneToMany
    private ArrayList<ListaDePrecio> ListaDePrecios;
//    constructor nulo
    public Sucursal(){}
    public static final ControladoraPersistencia persistencia= new ControladoraPersistencia();
    
//    constructor con parámetros

    public Sucursal(int nroSucursal, String cuil, String telefono, String razonSocial) {
        this.nroSucursal = nroSucursal;
        this.cuil = cuil;
        this.telefono = telefono;
        this.razonSocial = razonSocial;
        this.unaDireccion = unaDireccion;
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

    public Deposito getUnDeposito() {
        return unDeposito;
    }

    public Direccion getUnaDireccion() {
        return unaDireccion;
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

    public void setUnDeposito(Deposito unDeposito) {
        this.unDeposito = unDeposito;
    }

    public void setUnaDireccion(Direccion unaDireccion) {
        this.unaDireccion = unaDireccion;
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

    public void nuevoProveedor(int nroProv, String razonSocial, String cuit, String dni, String apellido, String nombre, String fecha, String telefono) throws Exception {
    Proveedor prov= new Proveedor(nroProv,razonSocial,cuit,dni,apellido,nombre,fecha,telefono);
//    this.listaProveedores.add(prov);
    Sucursal.persistencia.AgregarProveedorPersis(prov);
        
    }
//    public void getListaProveedores(Proveedor prov) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    public void agregarProveedor(int parseInt, String text, String text0, String text1, String text2, String text3, String text4) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    }
//    
//       this.listaProveedores.add(prov);
//    Empresa.persistencia.AgregarProveedorPersis(prov);
    


    

   

    
    

