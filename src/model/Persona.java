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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

/**
 *
 * @author Antonio
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Persona implements Serializable {
<<<<<<< HEAD
//    private static final long serialVersionUID = 1L;
//
//    public static long getSerialVersionUID() {
//        return serialVersionUID;
//    }
=======
    private static final long serialVersionUID = 1L;
>>>>>>> refs/remotes/origin/RamaA
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
<<<<<<< HEAD
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
=======
    @OneToOne
    private Direccion unaDireccion;
    @OneToOne
    private SituacionTributaria unaSituacionTributaria;
    @OneToOne 
    //en la viste podría i un desplegable para la provincia y otro desplegable para la localidad.(combos)
    private Provincia unaProvincia;
    
    public Persona(){}

    public Persona(String dni, String apellido, String nombre, String fechaNac, String telefono, SituacionTributaria unaSituacionTributaria, Provincia unaProvincia) {
>>>>>>> refs/remotes/origin/RamaA
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.telefono = telefono;
<<<<<<< HEAD
        this.condicionIva = condicionIva;
        this.direccion = direccion;
        this.provincia = provincia;
        this.localidad = localidad;
=======
        this.unaSituacionTributaria = unaSituacionTributaria;
        this.unaProvincia = unaProvincia;
>>>>>>> refs/remotes/origin/RamaA
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

<<<<<<< HEAD
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

    
=======
    public Direccion getUnaDireccion() {
        return unaDireccion;
    }

    public Provincia getUnaProvincia() {
        return unaProvincia;
    }

    public void setUnaDireccion(Direccion unaDireccion) {
        this.unaDireccion = unaDireccion;
    }

    public void setUnaProvincia(Provincia unaProvincia) {
        this.unaProvincia = unaProvincia;
    }

    
}
>>>>>>> refs/remotes/origin/RamaA
