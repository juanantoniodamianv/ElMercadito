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
    private String razonSocial;
    
    @Basic 
    private String nroCiut;
    
    @Basic 
    private String nombreFantasia;
    
    @OneToOne
    private SituacionTributaria unaSituaciontributaria;
   
 public Proveedor(){}

    public Proveedor(String razonSocial, String nroCiut, String nombreFantasia, SituacionTributaria unaSituaciontributaria) {
        this.razonSocial = razonSocial;
        this.nroCiut = nroCiut;
        this.nombreFantasia = nombreFantasia;
        this.unaSituaciontributaria = unaSituaciontributaria;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public String getNroCiut() {
        return nroCiut;
    }

    public String getNombreFantasia() {
        return nombreFantasia;
    }

    public SituacionTributaria getUnaSituaciontributaria() {
        return unaSituaciontributaria;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public void setNroCiut(String nroCiut) {
        this.nroCiut = nroCiut;
    }

    public void setNombreFantasia(String nombreFantasia) {
        this.nombreFantasia = nombreFantasia;
    }

    public void setUnaSituaciontributaria(SituacionTributaria unaSituaciontributaria) {
        this.unaSituaciontributaria = unaSituaciontributaria;
    }

}