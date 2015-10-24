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
    private String unidadMedida;
    @Basic
    private float cantidadUnidadMedida;
    @Basic
    private String descripcion;
    @Basic
    private String tipoEnvase;
    @Basic
    private float precioVenta;
    @OneToMany
     private ArrayList<Articulo>ListaArticulos;
    
    public DescripcionArticulo(){}

    public DescripcionArticulo(String codigoBarra, String nombreArticulo, String unidadMedida, float cantidadUnidadMedida, String descripcion, String tipoEnvase, float precioVenta, ArrayList<Articulo> ListaArticulos) {
        this.codigoBarra = codigoBarra;
        this.nombreArticulo = nombreArticulo;
        this.unidadMedida = unidadMedida;
        this.cantidadUnidadMedida = cantidadUnidadMedida;
        this.descripcion = descripcion;
        this.tipoEnvase = tipoEnvase;
        this.precioVenta = precioVenta;
        this.ListaArticulos = ListaArticulos;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public float getCantidadUnidadMedida() {
        return cantidadUnidadMedida;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getTipoEnvase() {
        return tipoEnvase;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public ArrayList<Articulo> getListaArticulos() {
        return ListaArticulos;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public void setCantidadUnidadMedida(float cantidadUnidadMedida) {
        this.cantidadUnidadMedida = cantidadUnidadMedida;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setTipoEnvase(String tipoEnvase) {
        this.tipoEnvase = tipoEnvase;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public void setListaArticulos(ArrayList<Articulo> ListaArticulos) {
        this.ListaArticulos = ListaArticulos;
    }
    

}