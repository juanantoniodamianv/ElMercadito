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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Antonio
 */
@Entity
public class Zona implements Serializable {
     @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int codigoZona;
    @Basic
    private String nombre;
    @OneToMany
    private ArrayList <Provincia> listaProvincias;
   
    public Zona(){}

    public Zona(int codigoZona, String nombre, ArrayList<Provincia> listaProvincias) {
        this.codigoZona = codigoZona;
        this.nombre = nombre;
        this.listaProvincias = listaProvincias;
    }

    public int getCodigoZona() {
        return codigoZona;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList <Provincia> getListaProvincias() {
        return listaProvincias;
    }

    public void setCodigoZona(int codigoZona) {
        this.codigoZona = codigoZona;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setListaProvincias(ArrayList <Provincia> listaProvincias) {
        this.listaProvincias = listaProvincias;
    }

    
}
