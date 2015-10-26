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
    @Basic
    private String razonSocial;
    @OneToOne
    
    private SituacionTributaria unaSituaciontributaria;
   
 public Proveedor(){}

    public Proveedor(String razonSocial, SituacionTributaria unaSituaciontributaria) {
        this.razonSocial = razonSocial;
        this.unaSituaciontributaria = unaSituaciontributaria;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public SituacionTributaria getUnaSituaciontributaria() {
        return unaSituaciontributaria;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public void setUnaSituaciontributaria(SituacionTributaria unaSituaciontributaria) {
        this.unaSituaciontributaria = unaSituaciontributaria;
    }
 
}
