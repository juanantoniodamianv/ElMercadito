/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Antonio
 */
@Entity
public class Seccion implements Serializable {
    @Id
    private int nroSeccion;
    @Basic
    private String nombreSeccion;
    @Basic
    private int cantBultoMax;
    @Basic
    private int cantBultoMin;
    @Basic
    private int cantBultoActual;
    @OneToMany
    private ArrayList<Bulto>bultosAlmacenados;
    
    public Seccion(){}

    public Seccion(int nroSeccion, String nombreSeccion, int cantBultoMax, int cantBultoMin, int cantBultoActual, ArrayList<Bulto> bultosAlmacenados) {
        this.nroSeccion = nroSeccion;
        this.nombreSeccion = nombreSeccion;
        this.cantBultoMax = cantBultoMax;
        this.cantBultoMin = cantBultoMin;
        this.cantBultoActual = cantBultoActual;
        this.bultosAlmacenados = bultosAlmacenados;
    }

    public int getNroSeccion() {
        return nroSeccion;
    }

    public String getNombreSeccion() {
        return nombreSeccion;
    }

    public int getCantBultoMax() {
        return cantBultoMax;
    }

    public int getCantBultoMin() {
        return cantBultoMin;
    }

    public int getCantBultoActual() {
        return cantBultoActual;
    }

    public ArrayList<Bulto> getBultosAlmacenados() {
        return bultosAlmacenados;
    }

    public void setNroSeccion(int nroSeccion) {
        this.nroSeccion = nroSeccion;
    }

    public void setNombreSeccion(String nombreSeccion) {
        this.nombreSeccion = nombreSeccion;
    }

    public void setCantBultoMax(int cantBultoMax) {
        this.cantBultoMax = cantBultoMax;
    }

    public void setCantBultoMin(int cantBultoMin) {
        this.cantBultoMin = cantBultoMin;
    }

    public void setCantBultoActual(int cantBultoActual) {
        this.cantBultoActual = cantBultoActual;
    }

    public void setBultosAlmacenados(ArrayList<Bulto> bultosAlmacenados) {
        this.bultosAlmacenados = bultosAlmacenados;
    }
    
    
    
    
}
