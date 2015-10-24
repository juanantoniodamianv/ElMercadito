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
public class LineaVtaMin {
    private int cantidadarticulo;
    private Articulo unArticulo;
    private DescripcionArticulo unaDescripcionArticulo;
    
    public LineaVtaMin(){}

    public LineaVtaMin(int cantidadarticulo, Articulo unArticulo, DescripcionArticulo unaDescripcionArticulo) {
        this.cantidadarticulo = cantidadarticulo;
        this.unArticulo = unArticulo;
        this.unaDescripcionArticulo = unaDescripcionArticulo;
    }

    public int getCantidadarticulo() {
        return cantidadarticulo;
    }

    public Articulo getUnArticulo() {
        return unArticulo;
    }

    public DescripcionArticulo getUnaDescripcionArticulo() {
        return unaDescripcionArticulo;
    }

    public void setCantidadarticulo(int cantidadarticulo) {
        this.cantidadarticulo = cantidadarticulo;
    }

    public void setUnArticulo(Articulo unArticulo) {
        this.unArticulo = unArticulo;
    }

    public void setUnaDescripcionArticulo(DescripcionArticulo unaDescripcionArticulo) {
        this.unaDescripcionArticulo = unaDescripcionArticulo;
    }
    
    
}
