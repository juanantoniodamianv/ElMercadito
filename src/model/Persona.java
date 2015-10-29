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
    //@Basic
    //private String situacionTributaria;
    //en la viste podría ir un desplegable para la provincia y otro desplegable para la localidad.(combos)
    @OneToOne
    private Direccion unaDireccion;
    @OneToOne
    private Localidad unaLocalidad;
    @OneToOne 
    private Provincia unaProvincia;
    
    public Persona(){}

    public Persona(String dni, String apellido, String nombre, String fechaNac, String telefono, Direccion unaDireccion, Localidad unaLocalidad, Provincia unaProvincia) {
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.telefono = telefono;
        //this.situacionTributaria = situacionTributaria;
        this.unaDireccion = unaDireccion;
        this.unaLocalidad = unaLocalidad;
        this.unaProvincia = unaProvincia;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /*
    public String getSituacionTributaria() {
        return situacionTributaria;
    }

    public void setSituacionTributaria(String situacionTributaria) {
        this.situacionTributaria = situacionTributaria;
    }*/

    public Direccion getUnaDireccion() {
        return unaDireccion;
    }

    public void setUnaDireccion(Direccion unaDireccion) {
        this.unaDireccion = unaDireccion;
    }

    public Localidad getUnaLocalidad() {
        return unaLocalidad;
    }

    public void setUnaLocalidad(Localidad unaLocalidad) {
        this.unaLocalidad = unaLocalidad;
    }

    public Provincia getUnaProvincia() {
        return unaProvincia;
    }

    public void setUnaProvincia(Provincia unaProvincia) {
        this.unaProvincia = unaProvincia;
    }
    
    
    
}
