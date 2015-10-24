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
import javax.persistence.OneToOne;

/**
 *
 * @author Antonio
 */
@Entity
public class Provincia implements Serializable {
     @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int codigoProv;
    @Basic
    private String nombre;
    @OneToMany
    private ArrayList <Localidad> listaLocalidades;
    @OneToOne
    private Zona unaZona;
    
   public Provincia(){}

    public Provincia(int codigoProv, String nombre, ArrayList<Localidad> listaLocalidades) {
        this.codigoProv = codigoProv;
        this.nombre = nombre;
        this.listaLocalidades = listaLocalidades;
    }

    public int getCodigoProv() {
        return codigoProv;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList <Localidad> getListaLocalidades() {
        return listaLocalidades;
    }

    public Zona getUnaZona() {
        return unaZona;
    }

    public void setCodigoProv(int codigoProv) {
        this.codigoProv = codigoProv;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setListaLocalidades(ArrayList <Localidad> listaLocalidades) {
        this.listaLocalidades = listaLocalidades;
    }

    public void setUnaZona(Zona unaZona) {
        this.unaZona = unaZona;
    }
   
}
    