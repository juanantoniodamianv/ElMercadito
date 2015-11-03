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
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    private String nroProveedor;
    @Basic
    private String razonSocial;
    
    @Basic 
    private String cuit;
    
    
    @Basic
    private String situacionTributaria;
   
 public Proveedor(){}

    public Proveedor(String nroProveedor, String razonSocial, String cuit, String situacionTributaria, String dni, String apellido, String nombre, String fechaNac, String telefono, Direccion unaDireccion, Localidad unaLocalidad, Provincia unaProvincia) {
        this.nroProveedor = nroProveedor;
        this.razonSocial = razonSocial;
        this.cuit = cuit;
        this.situacionTributaria = situacionTributaria;
    }

    public String getNroProveedor() {
        return nroProveedor;
    }

    public void setNroProveedor(String nroProveedor) {
        this.nroProveedor = nroProveedor;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getSituacionTributaria() {
        return situacionTributaria;
    }

    public void setSituacionTributaria(String situacionTributaria) {
        this.situacionTributaria = situacionTributaria;
    }
   

}