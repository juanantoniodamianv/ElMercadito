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
// * ME PARECE QUE CODIGO DE BARRA Y PRECIOCIOMPRA NO DEBERIAN IR COMO ATRIBUTOS DE LISTAPRECIO
 */
@Entity
public class ListaDePrecio implements Serializable{
    @Id
    private String codigoBarra;
    @Basic
    private float precioCompra;
    @OneToMany
    private ArrayList<DescripcionArticulo>listaDescripcionArticulo;
    
    public ListaDePrecio(){}

    public ListaDePrecio(String codigoBarra, float precioCompra, ArrayList<DescripcionArticulo> listaDescripcionArticulo) {
        this.codigoBarra = codigoBarra;
        this.precioCompra = precioCompra;
        this.listaDescripcionArticulo = listaDescripcionArticulo;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public float getPrecioCompra() {
        return precioCompra;
    }

    public ArrayList<DescripcionArticulo> getListaDescripcionArticulo() {
        return listaDescripcionArticulo;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public void setPrecioCompra(float precioCompra) {
        this.precioCompra = precioCompra;
    }

    public void setListaDescripcionArticulo(ArrayList<DescripcionArticulo> listaDescripcionArticulo) {
        this.listaDescripcionArticulo = listaDescripcionArticulo;
    }
}
//    
//}
