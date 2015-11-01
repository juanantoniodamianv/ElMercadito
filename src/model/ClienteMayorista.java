/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;

/**
 *
 * @author Daniel
 */
@Entity
public class ClienteMayorista extends Cliente implements Serializable{
    private static final long serialVersionUID = 1L;
    @Basic
    private String razonSocial;
    
    public ClienteMayorista(){}

    public ClienteMayorista(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public ClienteMayorista(String razonSocial, int nroCliente) {
        super(nroCliente);
        this.razonSocial = razonSocial;
    }

    public ClienteMayorista(String razonSocial, int nroCliente, String dni, String apellido, String nombre, String fechaNac, String telefono, String condicionIva, Direccion unaDireccion, Provincia unaProvincia) {
        super(nroCliente, dni, apellido, nombre, fechaNac, telefono, condicionIva, unaDireccion, unaProvincia);
        this.razonSocial = razonSocial;
    }

   

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }
    
}
