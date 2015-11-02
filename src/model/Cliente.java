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
    private int distanciakm;
    public Cliente(){}

    public Cliente(int nroCliente, int distanciakm) {
        this.nroCliente = nroCliente;
        this.distanciakm = distanciakm;
    }

    public Cliente(int nroCliente, int distanciakm, String dni, String apellido, String nombre, String fechaNac, String telefono, String condicionIva, String direccion, String provincia, String localidad) {
        super(dni, apellido, nombre, fechaNac, telefono, condicionIva, direccion, provincia, localidad);
        this.nroCliente = nroCliente;
        this.distanciakm = distanciakm;
    }

    public int getNroCliente() {
        return nroCliente;
    }

    public int getDistanciakm() {
        return distanciakm;
    }

    public void setNroCliente(int nroCliente) {
        this.nroCliente = nroCliente;
    }

    public void setDistanciakm(int distanciakm) {
        this.distanciakm = distanciakm;
    }

  
    
    
}
