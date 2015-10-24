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
import javax.persistence.OneToOne;

/**
 *
 * @author Daniel
 */
@Entity
public class Compra implements Serializable{
    @Id
    private int nroCompra;
    @Basic
    private String fecha;
    @Basic
    private String hora;
    @OneToMany
    private ArrayList<LineaDeCompra>ListaLineaDeCompra;
    @OneToOne
    private OrdenCompra unaOrdenCompra;
    
    
    public Compra(){}

    public Compra(int nroCompra, String fecha, String hora, ArrayList<LineaDeCompra> ListaLineaDeCompra, OrdenCompra unaOrdenCompra) {
        this.nroCompra = nroCompra;
        this.fecha = fecha;
        this.hora = hora;
        this.ListaLineaDeCompra = ListaLineaDeCompra;
        this.unaOrdenCompra = unaOrdenCompra;
    }

    public int getNroCompra() {
        return nroCompra;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public ArrayList<LineaDeCompra> getListaLineaDeCompra() {
        return ListaLineaDeCompra;
    }

    public OrdenCompra getUnaOrdenCompra() {
        return unaOrdenCompra;
    }

    public void setNroCompra(int nroCompra) {
        this.nroCompra = nroCompra;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setListaLineaDeCompra(ArrayList<LineaDeCompra> ListaLineaDeCompra) {
        this.ListaLineaDeCompra = ListaLineaDeCompra;
    }

    public void setUnaOrdenCompra(OrdenCompra unaOrdenCompra) {
        this.unaOrdenCompra = unaOrdenCompra;
    }
    
}
    