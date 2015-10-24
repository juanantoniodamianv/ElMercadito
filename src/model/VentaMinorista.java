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
public class VentaMinorista extends Venta{
    private ArrayList<LineaVtaMin>listaLienaVtaMin;
    
    public VentaMinorista(){}

    public VentaMinorista(ArrayList<LineaVtaMin> listaLienaVtaMin) {
        this.listaLienaVtaMin = listaLienaVtaMin;
    }

    public ArrayList<LineaVtaMin> getListaLienaVtaMin() {
        return listaLienaVtaMin;
    }

    public void setListaLienaVtaMin(ArrayList<LineaVtaMin> listaLienaVtaMin) {
        this.listaLienaVtaMin = listaLienaVtaMin;
    }
    }

  