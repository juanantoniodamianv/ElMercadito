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
public class Cliente extends Persona implements Serializable{
        private String nroCliente;
    @Basic
        private String tipoCliente;
    @Basic
        private String razonSocial;
    @Basic
        private String cuit;
    @Basic
        private String ivaCondicion;

    public Cliente() {
    }

    public Cliente(String nroCliente, String tipoCliente, String razonSocial, String cuit, String ivaCondicion, String dni, String apellido, String nombre, String fechaNac, String telefono, Direccion unaDireccion, Localidad unaLocalidad, Provincia unaProvincia) {
        super(dni, apellido, nombre, fechaNac, telefono, unaDireccion, unaLocalidad, unaProvincia);
        this.nroCliente = nroCliente;
        this.tipoCliente = tipoCliente;
        this.razonSocial = razonSocial;
        this.cuit = cuit;
        this.ivaCondicion = ivaCondicion;
    }

    public String getNroCliente() {
        return nroCliente;
    }

    public void setNroCliente(String nroCliente) {
        this.nroCliente = nroCliente;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
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

    public String getIvaCondicion() {
        return ivaCondicion;
    }

    public void setIvaCondicion(String ivaCondicion) {
        this.ivaCondicion = ivaCondicion;
    }

    
    
}
