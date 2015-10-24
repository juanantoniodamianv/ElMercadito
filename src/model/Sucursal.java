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
    private ArrayList<Persona> listaPersonas;
     @OneToMany
    private ArrayList<Caja> listaCajas;
     @OneToMany
    private ArrayList<ListaDePrecio> ListaDePrecios;
//    constructor nulo
    public Sucursal(){}
    
//    constructor con parámetros
    public Sucursal(int nroSucursal, String cuil, String telefono, String razonSocial) {
        this.nroSucursal = nroSucursal;
        this.cuil = cuil;
        this.telefono = telefono;
        this.razonSocial = razonSocial;
//        this.unDeposito = unDeposito;
//        this.unaDireccion = unaDireccion;
//        está bien asi?
//        this.listaPersonas = listaPersonas;
//        o asi?
        this.listaCajas = new ArrayList();
        this.ListaDePrecios = new ArrayList();
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

    public void setUnaDireccion(Direccion unaDireccion) {
        this.unaDireccion = unaDireccion;
    }

    public void setListaPersonas(ArrayList<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    public void setListaCajas(ArrayList<Caja> listaCajas) {
        this.listaCajas = listaCajas;
    }

    public void setListaDePrecios(ArrayList<ListaDePrecio> ListaDePrecios) {
        this.ListaDePrecios = ListaDePrecios;
    }
    
}
