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

/**
 *
 * @author Antonio
 */
@Entity
public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    @Id
      private String dni;
    @Basic
    private String apellido;
    @Basic
    private String nombre;
    @Basic
    private String fechaNac;
    @Basic
    private String telefono;
     @Basic
    private String condicionIva;
    @Basic
    private String direccion;
    @Basic
    private String provincia;
    @Basic
    private String localidad;
    
    
    
    
    public Persona(){}

    public Persona(String dni, String apellido, String nombre, String fechaNac, String telefono, String condicionIva, String direccion, String provincia, String localidad) {
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.telefono = telefono;
        this.condicionIva = condicionIva;
        this.direccion = direccion;
        this.provincia = provincia;
        this.localidad = localidad;
    }

    public String getDni() {
        return dni;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCondicionIva() {
        return condicionIva;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCondicionIva(String condicionIva) {
        this.condicionIva = condicionIva;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

  
    }

    