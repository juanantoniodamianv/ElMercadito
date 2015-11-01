/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Basic;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author daniel
 */
public class Venta {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Basic
    private int codigoVta;
    @Basic
    private String fecha;
    @Basic
    private String hora;
    
    public Venta(){}

    public Venta(int codigoVta, String fecha, String hora) {
        this.codigoVta = codigoVta;
        this.fecha = fecha;
        this.hora = hora;
    }

    public int getCodigoVta() {
        return codigoVta;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setCodigoVta(int codigoVta) {
        this.codigoVta = codigoVta;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
}
    