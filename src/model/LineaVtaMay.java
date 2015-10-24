/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author daniel
 */
public class LineaVtaMay {
    private int cantidadArticulo;
    private int cantidadminima;
    private Articulo unArticulo;
    private DescripcionArticulo unaDescripconArticulo;
    
    public LineaVtaMay(){}

    public LineaVtaMay(int cantidadArticulo, int cantidadminima, Articulo unArticulo, DescripcionArticulo unaDescripconArticulo) {
        this.cantidadArticulo = cantidadArticulo;
        this.cantidadminima = cantidadminima;
        this.unArticulo = unArticulo;
        this.unaDescripconArticulo = unaDescripconArticulo;
    }

    public int getCantidadArticulo() {
        return cantidadArticulo;
    }

    public int getCantidadminima() {
        return cantidadminima;
    }

    public Articulo getUnArticulo() {
        return unArticulo;
    }

    public DescripcionArticulo getUnaDescripconArticulo() {
        return unaDescripconArticulo;
    }

    public void setCantidadArticulo(int cantidadArticulo) {
        this.cantidadArticulo = cantidadArticulo;
    }

    public void setCantidadminima(int cantidadminima) {
        this.cantidadminima = cantidadminima;
    }

    public void setUnArticulo(Articulo unArticulo) {
        this.unArticulo = unArticulo;
    }

    public void setUnaDescripconArticulo(DescripcionArticulo unaDescripconArticulo) {
        this.unaDescripconArticulo = unaDescripconArticulo;
    }
    
            
    
}
