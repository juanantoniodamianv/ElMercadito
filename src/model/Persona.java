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
    @OneToOne
    private Direccion unaDireccion;
    @OneToOne
    private SituacionTributaria unaSituacionTributaria;
    @OneToOne 
    //en la viste podría i un desplegable para la provincia y otro desplegable para la localidad.(combos)
    private Provincia unaProvincia;
    
    public Persona(){}

    public Persona(String dni, String apellido, String nombre, String fechaNac, String telefono, SituacionTributaria unaSituacionTributaria, Provincia unaProvincia) {
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.telefono = telefono;
        this.unaSituacionTributaria = unaSituacionTributaria;
        this.unaProvincia = unaProvincia;
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

    public SituacionTributaria getUnaSituacionTributaria() {
        return unaSituacionTributaria;
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

    public void setUnaSituacionTributaria(SituacionTributaria unaSituacionTributaria) {
        this.unaSituacionTributaria = unaSituacionTributaria;
    }

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
