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
public class DescripcionArticulo implements Serializable {
    @Id
    private String codigoBarra;
    @Basic
     private String nombreArticulo;
    @Basic
    private String descripcion;
    @Basic
    private String tipoEnvase;
    @Basic
    private String unidadMedida;
    @Basic
    private float cantidadUnidadMedida;
    @Basic
    private float precioCompra;
    @Basic
    private float precioVenta;
    @Basic 
    private float precioVentaMay;
    
    //@OneToMany
    //private ArrayList<Articulo>ListaArticulos;
    
    public DescripcionArticulo(){}

    public DescripcionArticulo(String codigoBarra, String nombreArticulo, String descripcion, String tipoEnvase, String unidadMedida, float cantidadUnidadMedida, float precioCompra, float precioVenta, float precioVentaMay) {
        this.codigoBarra = codigoBarra;
        this.nombreArticulo = nombreArticulo;
        this.descripcion = descripcion;
        this.tipoEnvase = tipoEnvase;
        this.unidadMedida = unidadMedida;
        this.cantidadUnidadMedida = cantidadUnidadMedida;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.precioVentaMay = precioVentaMay;
        //this.ListaArticulos = ListaArticulos;
    }
    
    @Override
    public String toString(){
        return "Cod. Barras: " + codigoBarra + "| Articulo: " + nombreArticulo + "| P. Compra: " + precioCompra + "| P. Vta: " + precioVenta + "| P. Vta May: " + precioVentaMay;
    }
    
    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoEnvase() {
        return tipoEnvase;
    }

    public void setTipoEnvase(String tipoEnvase) {
        this.tipoEnvase = tipoEnvase;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public float getCantidadUnidadMedida() {
        return cantidadUnidadMedida;
    }

    public void setCantidadUnidadMedida(float cantidadUnidadMedida) {
        this.cantidadUnidadMedida = cantidadUnidadMedida;
    }

    public float getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(float precioCompra) {
        this.precioCompra = precioCompra;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public float getPrecioVentaMay() {
        return precioVentaMay;
    }

    public void setPrecioVentaMay(float precioVentaMay) {
        this.precioVentaMay = precioVentaMay;
    }
    /*
    public ArrayList<Articulo> getListaArticulos() {
        return ListaArticulos;
    }

    public void setListaArticulos(ArrayList<Articulo> ListaArticulos) {
        this.ListaArticulos = ListaArticulos;
    }
    */
}