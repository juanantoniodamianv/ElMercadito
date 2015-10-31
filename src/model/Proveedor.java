/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 *
 * @author Antonio
 */
@Entity
public class Proveedor extends Persona implements Serializable{
    private static final long serialVersionUID = 1L;
//porqué me pide esto?
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    @Basic 
    private int nroProveedor;
    @Basic
    private String razonSocial;
    
    @Basic 
    private String nroCiut;
    
   
   
 public Proveedor(){}

    public Proveedor(int nroProveedor, String razonSocial, String nroCiut) {
        this.nroProveedor = nroProveedor;
        this.razonSocial = razonSocial;
        this.nroCiut = nroCiut;
    }

    public Proveedor(int nroProveedor, String razonSocial, String nroCiut, String dni, String apellido, String nombre, String fechaNac, String telefono, String condicionIva, Direccion unaDireccion, Provincia unaProvincia) {
        super(dni, apellido, nombre, fechaNac, telefono, condicionIva, unaDireccion, unaProvincia);
        this.nroProveedor = nroProveedor;
        this.razonSocial = razonSocial;
        this.nroCiut = nroCiut;
    }

 

    public int getNroProveedor() {
        return nroProveedor;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public String getNroCiut() {
        return nroCiut;
    }

    public void setNroProveedor(int nroProveedor) {
        this.nroProveedor = nroProveedor;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public void setNroCiut(String nroCiut) {
        this.nroCiut = nroCiut;
    }

   
}
