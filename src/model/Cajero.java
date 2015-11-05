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
public class Cajero extends Empleado implements Serializable{
    @Basic
    private int nroCajaAsignada;
    
    public Cajero(){}

    public Cajero(int nroCajaAsignada) {
        this.nroCajaAsignada = nroCajaAsignada;
    }

    public Cajero(int nroCajaAsignada, String apellido, String nombre, String fechaNac, String sexo, String estadoCivil, String fechaIngreso, String cargo) {
        super(apellido, nombre, fechaNac, sexo, estadoCivil, fechaIngreso, cargo);
        this.nroCajaAsignada = nroCajaAsignada;
    }

    public Cajero(int nroCajaAsignada, String apellido, String nombre, String fechaNac, String sexo, String estadoCivil, String fechaIngreso, String cargo, String idPersona, String telefono, String direccion, String localidad, String provincia) {
        super(apellido, nombre, fechaNac, sexo, estadoCivil, fechaIngreso, cargo, idPersona, telefono, direccion, localidad, provincia);
        this.nroCajaAsignada = nroCajaAsignada;
    }

    public int getNroCajaAsignada() {
        return nroCajaAsignada;
    }

    public void setNroCajaAsignada(int nroCajaAsignada) {
        this.nroCajaAsignada = nroCajaAsignada;
    }
    
    
    
}
