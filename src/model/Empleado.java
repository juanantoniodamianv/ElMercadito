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
    private static final long serialVersionUID = 1L;
     @Basic
    private String sexo;
     @Basic
    private int edad;
     @Basic
    private String estadoCivil;
     @Basic
    private String antiguedadAños;
    
    public Empleado(){}

    

    public Empleado(String sexo, int edad, String estadoCivil, String antiguedadAños, String dni, String apellido, String nombre, String fechaNac, String telefono, String condicionIva, String direccion, String provincia, String localidad) {
        super(dni, apellido, nombre, fechaNac, telefono, condicionIva, direccion, provincia, localidad);
        this.sexo = sexo;
        this.edad = edad;
        this.estadoCivil = estadoCivil;
        this.antiguedadAños = antiguedadAños;
    }

    public String getSexo() {
        return sexo;
    }

    public int getEdad() {
        return edad;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public String getAntiguedadAños() {
        return antiguedadAños;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public void setAntiguedadAños(String antiguedadAños) {
        this.antiguedadAños = antiguedadAños;
    }

    

   
    }

   
    

