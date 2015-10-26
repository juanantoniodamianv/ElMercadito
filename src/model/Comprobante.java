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
public class Comprobante implements Serializable {
    @Id
    private int nroComprobante;
    @Basic
    private String tipoComprobante;
    @Basic
    private String copia;
    @Basic
    private String fecha;
    @OneToMany
    private ArrayList<Comprobante>listaComprobantes;
    
    public Comprobante(){}

    public int getNroComprobante() {
        return nroComprobante;
    }

    public String getTipoComprobante() {
        return tipoComprobante;
    }

    public String getCopia() {
        return copia;
    }

    public String getFecha() {
        return fecha;
    }

    public ArrayList<Comprobante> getListaComprobantes() {
        return listaComprobantes;
    }

    public void setNroComprobante(int nroComprobante) {
        this.nroComprobante = nroComprobante;
    }

    public void setTipoComprobante(String tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    public void setCopia(String copia) {
        this.copia = copia;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setListaComprobantes(ArrayList<Comprobante> listaComprobantes) {
        this.listaComprobantes = listaComprobantes;
    }
    
            
    
    
}
