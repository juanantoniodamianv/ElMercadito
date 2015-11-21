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
 * @author Antonio
 */
@Entity
public class Proveedor extends Persona implements Serializable{
    @Basic
    private String razonSocial;    
    @Basic
    private String situacionTributaria;
    @Basic
    private String tipoProveduria;
   
 public Proveedor(){}

    public Proveedor(String razonSocial, String situacionTributaria, String tipoProveduria) {
        this.razonSocial = razonSocial;
        this.situacionTributaria = situacionTributaria;
        this.tipoProveduria = tipoProveduria;
    }

    public Proveedor(String idPersona, String razonSocial, String situacionTributaria, String tipoProveduria, String telefono, String direccion, String localidad, String provincia) {
        super(idPersona, telefono, direccion, localidad, provincia);
        this.razonSocial = razonSocial;
        this.situacionTributaria = situacionTributaria;
        this.tipoProveduria = tipoProveduria;
    }
    @Override
    public String toString(){
        return "CUIT: " + super.getIdPersona() + "| Razón Social: " + razonSocial + "| Tipo de Proveduria: " + tipoProveduria; 
    }
    
    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getSituacionTributaria() {
        return situacionTributaria;
    }

    public void setSituacionTributaria(String situacionTributaria) {
        this.situacionTributaria = situacionTributaria;
    }

    public String getTipoProveduria() {
        return tipoProveduria;
    }

    public void setTipoProveduria(String tipoProveduria) {
        this.tipoProveduria = tipoProveduria;
    }

    
   

}