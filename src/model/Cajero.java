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

/**
 *
 * @author Daniel
 */
@Entity
public class Cajero extends Empleado implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    private int nroCajero;
    @Basic
    private int nroCajaAsignada;
    
    public Cajero(){}

    public Cajero(int nroCajero, int nroCajaAsignada) {
        this.nroCajero = nroCajero;
        this.nroCajaAsignada = nroCajaAsignada;
    }

    public Cajero(int nroCajero, int nroCajaAsignada, String sexo, int edad, String estadoCivil, String antiguedadAños) {
        super(sexo, edad, estadoCivil, antiguedadAños);
        this.nroCajero = nroCajero;
        this.nroCajaAsignada = nroCajaAsignada;
    }

    public Cajero(int nroCajero, int nroCajaAsignada, String sexo, int edad, String estadoCivil, String antiguedadAños, String dni, String apellido, String nombre, String fechaNac, String telefono, String condicionIva, Direccion unaDireccion, Provincia unaProvincia) {
        super(sexo, edad, estadoCivil, antiguedadAños, dni, apellido, nombre, fechaNac, telefono, condicionIva, unaDireccion, unaProvincia);
        this.nroCajero = nroCajero;
        this.nroCajaAsignada = nroCajaAsignada;
    }


    
    
   

    public int getNroCajero() {
        return nroCajero;
    }

    public int getNroCajaAsignada() {
        return nroCajaAsignada;
    }

    public void setNroCajero(int nroCajero) {
        this.nroCajero = nroCajero;
    }

    public void setNroCajaAsignada(int nroCajaAsignada) {
        this.nroCajaAsignada = nroCajaAsignada;
    }
    
}
