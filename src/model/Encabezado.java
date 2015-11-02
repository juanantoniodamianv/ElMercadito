/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.OneToOne;

/**
 *
 * @author Antonio
 */
public class Encabezado implements Serializable{
@Basic
private String nombreEmpresa;
@Basic
private int nroSucursal;
@Basic
private String direccion;
@Basic
private String telefono;
@Basic
private String nroCiut;
@Basic
private String nroIBrutosReg;
@Basic
private Date inicioActividades;
    
public Encabezado(){}

    public Encabezado(String nombreEmpresa, int nroSucursal, String direccion, String telefono, String nroCiut, String nroIBrutosReg, Date inicioActividades) {
        this.nombreEmpresa = nombreEmpresa;
        this.nroSucursal = nroSucursal;
        this.direccion = direccion;
        this.telefono = telefono;
        this.nroCiut = nroCiut;
        this.nroIBrutosReg = nroIBrutosReg;
        this.inicioActividades = inicioActividades;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public int getNroSucursal() {
        return nroSucursal;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getNroCiut() {
        return nroCiut;
    }

    public String getNroIBrutosReg() {
        return nroIBrutosReg;
    }

    public Date getInicioActividades() {
        return inicioActividades;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public void setNroSucursal(int nroSucursal) {
        this.nroSucursal = nroSucursal;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setNroCiut(String nroCiut) {
        this.nroCiut = nroCiut;
    }

    public void setNroIBrutosReg(String nroIBrutosReg) {
        this.nroIBrutosReg = nroIBrutosReg;
    }

    public void setInicioActividades(Date inicioActividades) {
        this.inicioActividades = inicioActividades;
    }

}

    
