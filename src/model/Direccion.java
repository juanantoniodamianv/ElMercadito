/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Antonio
 */
@Entity
public class Direccion implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int codigo;
    @Basic
    private String calle;
   
    private int numero;
    @Basic
    private int departamento;
    @Basic
    private int piso;
    @OneToOne
    private Localidad unaLocalidad;
 
    
     public Direccion(){}

    public Direccion(int codigo, String calle, int numero, int departamento, int piso, Localidad unaLocalidad) {
        this.codigo = codigo;
        this.calle = calle;
        this.numero = numero;
        this.departamento = departamento;
        this.piso = piso;
        this.unaLocalidad = unaLocalidad;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getCalle() {
        return calle;
    }

    public int getNumero() {
        return numero;
    }

    public int getDepartamento() {
        return departamento;
    }

    public int getPiso() {
        return piso;
    }

    public Localidad getUnaLocalidad() {
        return unaLocalidad;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setDepartamento(int departamento) {
        this.departamento = departamento;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public void setUnaLocalidad(Localidad unaLocalidad) {
        this.unaLocalidad = unaLocalidad;
    }

    
}
