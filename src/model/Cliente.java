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

    public Cliente(int nroCliente, String apellido, String nombre, String dni, String fechaNac, SituacionTributaria unaSituacionTributaria) {
        
        this.nroCliente = nroCliente;
    }
    public int getNroCliente() {
        return nroCliente;
    }

    public void setNroCliente(int nroCliente) {
        this.nroCliente = nroCliente;
    }
    
    
    
}
