/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author Daniel
 */
@Entity
public class Cliente extends Persona implements Serializable{
   
    private int nroCliente;
    public Cliente(){}

    public Cliente(int nroCliente) {
        this.nroCliente = nroCliente;
    }

    public Cliente(int nroCliente, String dni, String apellido, String nombre, String fechaNac, String telefono, String condicionIva, Direccion unaDireccion, Provincia unaProvincia) {
        super(dni, apellido, nombre, fechaNac, telefono, condicionIva, unaDireccion, unaProvincia);
        this.nroCliente = nroCliente;
    }

    
    
    public int getNroCliente() {
        return nroCliente;
    }

    public void setNroCliente(int nroCliente) {
        this.nroCliente = nroCliente;
    }
    
    
    
}
