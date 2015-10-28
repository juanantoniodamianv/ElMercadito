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
private Direccion unaDireccion;
@Basic
private String telefono;
@OneToOne
private SituacionTributaria unaSituacionTributaria;
@Basic
private String nroCiut;
//aca no estoy seguro si va un nroIbrutosReg o que es//
@Basic
private String nroIBrutosReg;
@Basic
private Date inicioActividades;
    
public Encabezado(){}

    public Encabezado(String nombreEmpresa, int nroSucursal, Direccion unaDireccion, String telefono, SituacionTributaria unaSituacionTributaria, String nroCiut, String nroIBrutosReg, Date inicioActividades) {
        this.nombreEmpresa = nombreEmpresa;
        this.nroSucursal = nroSucursal;
        this.unaDireccion = unaDireccion;
        this.telefono = telefono;
        this.unaSituacionTributaria = unaSituacionTributaria;
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

    public Direccion getUnaDireccion() {
        return unaDireccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public SituacionTributaria getUnaSituacionTributaria() {
        return unaSituacionTributaria;
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

    public void setUnaDireccion(Direccion unaDireccion) {
        this.unaDireccion = unaDireccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setUnaSituacionTributaria(SituacionTributaria unaSituacionTributaria) {
        this.unaSituacionTributaria = unaSituacionTributaria;
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
