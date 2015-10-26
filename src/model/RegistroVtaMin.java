/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.ArrayList;

/**
 *
 * @author Antonio
 */
public class RegistroVtaMin {
    private ArrayList<VentaMinorista>listaVentaMinorista;
    
    public RegistroVtaMin(){}

    public RegistroVtaMin(ArrayList<VentaMinorista> listaVentaMinorista) {
        this.listaVentaMinorista = listaVentaMinorista;
    }

    public ArrayList<VentaMinorista> getListaVentaMinorista() {
        return listaVentaMinorista;
    }

    public void setListaVentaMinorista(ArrayList<VentaMinorista> listaVentaMinorista) {
        this.listaVentaMinorista = listaVentaMinorista;
    }
    
    
}
