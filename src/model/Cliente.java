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
    @Basic
        private String apellido;
    @Basic
        private String nombre;
    @Basic
        private String tipoCliente;
    @Basic
        private String razonSocial; //Predeterminado es NULL si es tipoCliente: Minorista
    @Basic
        private String ivaCondicion;

    public Cliente() {
    }

    public Cliente(String apellido, String nombre, String razonSocial, String tipoCliente, String ivaCondicion) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.tipoCliente = tipoCliente;
        this.razonSocial = razonSocial;
        this.ivaCondicion = ivaCondicion;
    }

    public Cliente(String idPersona, String apellido, String nombre, String razonSocial, String tipoCliente, String ivaCondicion, String telefono, String direccion, String localidad, String provincia) {
        super(idPersona, telefono, direccion, localidad, provincia);
        this.apellido = apellido;
        this.nombre = nombre;
        this.tipoCliente = tipoCliente;
        this.razonSocial = razonSocial;
        this.ivaCondicion = ivaCondicion;
    }
    @Override
    public String toString(){
        return "CUIT/DNI: " + super.getIdPersona() + " | Apellido y Nombre: " + apellido + nombre + " | Razon Social: " + razonSocial;
    }
    
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getIvaCondicion() {
        return ivaCondicion;
    }

    public void setIvaCondicion(String ivaCondicion) {
        this.ivaCondicion = ivaCondicion;
    }

    
    
    
}
