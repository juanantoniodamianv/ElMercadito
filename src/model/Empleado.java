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
public class Empleado extends Persona implements Serializable{
    @Basic
    private String apellido;
    @Basic
    private String nombre;
    @Basic
    private String fechaNac;
    @Basic
    private String sexo;
    @Basic
    private String estadoCivil;
    @Basic
    private String fechaIngreso;
    @Basic
    private String cargo;
    
    public Empleado(){}

    public Empleado(String apellido, String nombre, String fechaNac, String sexo, String estadoCivil, String fechaIngreso, String cargo) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.fechaIngreso = fechaIngreso;
        this.cargo = cargo;
    }

    public Empleado(String idPersona, String apellido, String nombre, String fechaNac, String sexo, String estadoCivil, String fechaIngreso, String cargo, String telefono, String direccion, String localidad, String provincia) {
        super(idPersona, telefono, direccion, localidad, provincia);
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.fechaIngreso = fechaIngreso;
        this.cargo = cargo;
    }
    
    @Override
    public String toString(){
        return "CUIL: " + super.getIdPersona() + "| Apellido: " + apellido + "| Nombre: " + nombre + "| Fecha de ingreso: " + fechaIngreso + "| Cargo: " + cargo;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    
}
