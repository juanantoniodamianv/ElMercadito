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
public class SectorEstante implements Serializable{
    @Id
    private int nroSectorEstante;
    @Basic
    private String nombreSector;
    @Basic
    private int cantArtMax;
    @Basic
    private int cantArtMin;
    @Basic
    private int cantArtActual;
    @OneToMany
    private ArrayList<Articulo>articulosAlmacenados;
    
    public SectorEstante(){}

    public SectorEstante(int nroSectorEstante, String nombreSector, int cantArtMax, int cantArtMin, int cantArtActual, ArrayList<Articulo> articulosAlmacenados) {
        this.nroSectorEstante = nroSectorEstante;
        this.nombreSector = nombreSector;
        this.cantArtMax = cantArtMax;
        this.cantArtMin = cantArtMin;
        this.cantArtActual = cantArtActual;
        this.articulosAlmacenados = articulosAlmacenados;
    }

    public int getNroSectorEstante() {
        return nroSectorEstante;
    }

    public String getNombreSector() {
        return nombreSector;
    }

    public int getCantArtMax() {
        return cantArtMax;
    }

    public int getCantArtMin() {
        return cantArtMin;
    }

    public int getCantArtActual() {
        return cantArtActual;
    }

    public ArrayList<Articulo> getArticulosAlmacenados() {
        return articulosAlmacenados;
    }

    public void setNroSectorEstante(int nroSectorEstante) {
        this.nroSectorEstante = nroSectorEstante;
    }

    public void setNombreSector(String nombreSector) {
        this.nombreSector = nombreSector;
    }

    public void setCantArtMax(int cantArtMax) {
        this.cantArtMax = cantArtMax;
    }

    public void setCantArtMin(int cantArtMin) {
        this.cantArtMin = cantArtMin;
    }

    public void setCantArtActual(int cantArtActual) {
        this.cantArtActual = cantArtActual;
    }

    public void setArticulosAlmacenados(ArrayList<Articulo> articulosAlmacenados) {
        this.articulosAlmacenados = articulosAlmacenados;
    }
    
    
            
            
            
    
}
