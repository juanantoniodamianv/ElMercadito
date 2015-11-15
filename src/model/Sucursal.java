/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

//import javax.swing.text.html.parser.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import Persistencia.ControladoraPersistencia;
import javax.swing.JOptionPane;


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
    private String direccion;
     @OneToMany
    private ArrayList<Persona> listaPersonas;
    
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
        this.unDeposito = unDeposito;
        this.direccion = direccion;
        this.listaPersonas = listaPersonas;
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

    public String getDireccion() {
        return direccion;
    }

    public ArrayList<Persona> getListaPersonas() {
        return listaPersonas;
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

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setListaPersonas(ArrayList<Persona> listaPersonas) {
        
        this.listaPersonas = listaPersonas;
    }
   
    @SuppressWarnings("unchecked")
    public ArrayList<Proveedor> cargarListaProveedores(){
        
//     return this.listaProveedores= (ArrayList) Sucursal.persistencia.BuscarListaProveedores();
     return (ArrayList<Proveedor>) Sucursal.persistencia.BuscarListaProveedores();
     
    }
    

    public void setListaCajas(ArrayList<Caja> listaCajas) {
        this.listaCajas = listaCajas;
    }

    public void setListaDePrecios(ArrayList<ListaDePrecio> ListaDePrecios) {
        this.ListaDePrecios = ListaDePrecios;
       
    }
    public Proveedor BuscarProveedorCuit(String idPersona){
    
//    
     Proveedor aux=null,pro;
     Iterator it= this.cargarListaProveedores().iterator();
     while (it.hasNext()){
         pro= (Proveedor) it.next();
         if ( pro.getIdPersona().equals(idPersona)){
             aux=pro;
         }
         if (aux ==null){
             System.out.println("Proveedor no encontrado");
         }
     }
    return aux;
//    JOptionPane.showMessageDialog(this, "Proveedor no encontrado);
   }



    public ArrayList<Proveedor> getListaProveedores() {
        return listaProveedores;
    }

    public void setListaProveedores(ArrayList<Proveedor> listaProveedores) {
        this.listaProveedores = listaProveedores;
    }

    

    
    }
    

