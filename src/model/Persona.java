/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.InheritanceType;
import javax.persistence.Inheritance;

/**
 *
 * @author Antonio
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Persona implements Serializable {
    @Id
    private String idPersona;
    @Basic
    private String telefono;
    @Basic
    private String direccion;
    @Basic
    private String localidad;
    @Basic 
    private String provincia;
    
    public Persona(){}

    public Persona(String idPersona, String telefono, String direccion, String localidad, String provincia) {
        this.idPersona = idPersona;
        this.telefono = telefono;
        this.direccion = direccion;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    

}
