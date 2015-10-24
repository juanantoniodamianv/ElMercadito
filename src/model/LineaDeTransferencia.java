/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author Antonio
 */
public class LineaDeTransferencia {
    private int cantidadBulto;
    private Bulto unBulto;
    private DescripcionArticulo unaDescripcionarticulo;
   
    public LineaDeTransferencia(){}

    public LineaDeTransferencia(int cantidadBulto, Bulto unBulto, DescripcionArticulo unaDescripcionarticulo) {
        this.cantidadBulto = cantidadBulto;
        this.unBulto = unBulto;
        this.unaDescripcionarticulo = unaDescripcionarticulo;
    }

    public int getCantidadBulto() {
        return cantidadBulto;
    }

    public Bulto getUnBulto() {
        return unBulto;
    }

    public DescripcionArticulo getUnaDescripcionarticulo() {
        return unaDescripcionarticulo;
    }

    public void setCantidadBulto(int cantidadBulto) {
        this.cantidadBulto = cantidadBulto;
    }

    public void setUnBulto(Bulto unBulto) {
        this.unBulto = unBulto;
    }

    public void setUnaDescripcionarticulo(DescripcionArticulo unaDescripcionarticulo) {
        this.unaDescripcionarticulo = unaDescripcionarticulo;
    }
    
    
    
}
