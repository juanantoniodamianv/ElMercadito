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
public class Localidad implements Serializable {
    @Id
    private int cp;
    @Basic
    private String nombre;
    
    @OneToOne
    private Provincia unaProvincia;
    
 public Localidad(){}

    public Localidad(int cp, String nombre, Provincia unaProvincia) {
        this.cp = cp;
        this.nombre = nombre;
        this.unaProvincia = unaProvincia;
    }

    public int getCp() {
        return cp;
    }

    public String getNombre() {
        return nombre;
    }

    public Provincia getUnaProvincia() {
        return unaProvincia;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUnaProvincia(Provincia unaProvincia) {
        this.unaProvincia = unaProvincia;
    }

    
 }

