/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class VentaMayorista extends Venta{
    private ArrayList<VentaMayorista>listaVentaMayorista;
    
public VentaMayorista(){}

    public VentaMayorista(ArrayList<VentaMayorista> listaVentaMayorista) {
        this.listaVentaMayorista = listaVentaMayorista;
    }

    public VentaMayorista(ArrayList<VentaMayorista> listaVentaMayorista, int codigoVta, String fecha, String hora) {
        super(codigoVta, fecha, hora);
        this.listaVentaMayorista = listaVentaMayorista;
    }

    public ArrayList<VentaMayorista> getListaVentaMayorista() {
        return listaVentaMayorista;
    }

    public void setListaVentaMayorista(ArrayList<VentaMayorista> listaVentaMayorista) {
        this.listaVentaMayorista = listaVentaMayorista;
    }

}

    