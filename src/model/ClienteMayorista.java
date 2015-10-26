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
    @Basic
    private String razonSocial;
    
    public ClienteMayorista(){}

    public ClienteMayorista(String razonSocial, int nroCliente, String apellido, String nombre, String cuil, String fechaNac, SituacionTributaria unaSituacionTributaria) {
        super(nroCliente, apellido, nombre, cuil, fechaNac, unaSituacionTributaria);
        this.razonSocial = razonSocial;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }
    
}
