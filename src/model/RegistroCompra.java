/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author daniel
 */
public class RegistroCompra {
    private ArrayList<Compra>ListaCompras;
    
public RegistroCompra(){}

    public RegistroCompra(ArrayList<Compra> ListaCompras) {
        this.ListaCompras = ListaCompras;
    }

    public ArrayList<Compra> getListaCompras() {
        return ListaCompras;
    }

    public void setListaCompras(ArrayList<Compra> ListaCompras) {
        this.ListaCompras = ListaCompras;
    }

    
    
}
