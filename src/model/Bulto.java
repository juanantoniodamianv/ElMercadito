/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;
import java.util.ArrayList;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


/**
 *
 * @author Daniel
 */
@Entity
public class Bulto implements Serializable {
    @Id
    private int nroBulto;
    @OneToOne
    private DescripcionArticulo articuloEnbulto;
    @Basic
    private int cantidadArticuloenBulto;
    @OneToMany
    private ArrayList<Articulo>articulosEnBulto;
    
    public Bulto(){}

    public Bulto(int nroBulto, DescripcionArticulo articuloEnbulto, int cantidadArticuloenBulto, ArrayList<Articulo> articulosEnBulto) {
        this.nroBulto = nroBulto;
        this.articuloEnbulto = articuloEnbulto;
        this.cantidadArticuloenBulto = cantidadArticuloenBulto;
        this.articulosEnBulto = articulosEnBulto;
    }

    public int getNroBulto() {
        return nroBulto;
    }

    
    public DescripcionArticulo getArticuloEnbulto() {
        return articuloEnbulto;
    }

    public int getCantidadArticuloenBulto() {
        return cantidadArticuloenBulto;
    }

    public ArrayList<Articulo> getArticulosEnBulto() {
        return articulosEnBulto;
    }

    public void setNroBulto(int nroBulto) {
        this.nroBulto = nroBulto;
    }

    public void setArticuloEnbulto(DescripcionArticulo articuloEnbulto) {
        this.articuloEnbulto = articuloEnbulto;
    }

    public void setCantidadArticuloenBulto(int cantidadArticuloenBulto) {
        this.cantidadArticuloenBulto = cantidadArticuloenBulto;
    }

    public void setArticulosEnBulto(ArrayList<Articulo> articulosEnBulto) {
        this.articulosEnBulto = articulosEnBulto;
    }
    
    
    
    
}
