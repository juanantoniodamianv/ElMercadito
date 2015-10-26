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
public class Gondola implements Serializable{
    @Id
    private int nroGondola;
    @Basic
    private String nombreGondola;
    @OneToMany
    private ArrayList<Estante>listaEstantes;
    
    public Gondola(){}

    public Gondola(int nroGondola, String nombreGondola, ArrayList<Estante> listaEstantes) {
        this.nroGondola = nroGondola;
        this.nombreGondola = nombreGondola;
        this.listaEstantes = listaEstantes;
    }

    public int getNroGondola() {
        return nroGondola;
    }

    public String getNombreGondola() {
        return nombreGondola;
    }

    public ArrayList<Estante> getListaEstantes() {
        return listaEstantes;
    }

    public void setNroGondola(int nroGondola) {
        this.nroGondola = nroGondola;
    }

    public void setNombreGondola(String nombreGondola) {
        this.nombreGondola = nombreGondola;
    }

    public void setListaEstantes(ArrayList<Estante> listaEstantes) {
        this.listaEstantes = listaEstantes;
    }

   
    
}
