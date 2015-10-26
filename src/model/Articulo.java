/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
/**
 *
 * @author Daniel
 */
@Entity
public class Articulo implements Serializable{
    @Id
    private int nroArticulo;
    @Basic
    private String lote;
    @Basic
    private String fechaExpira;
    @Basic
    private String fechaElabora;
    
    public Articulo(){}

    public Articulo(int nroArticulo, String lote, String fechaExpira, String fechaElabora) {
        this.nroArticulo = nroArticulo;
        this.lote = lote;
        this.fechaExpira = fechaExpira;
        this.fechaElabora = fechaElabora;
    }

    public int getNroArticulo() {
        return nroArticulo;
    }

    public String getLote() {
        return lote;
    }

    public String getFechaExpira() {
        return fechaExpira;
    }

    public String getFechaElabora() {
        return fechaElabora;
    }

    public void setNroArticulo(int nroArticulo) {
        this.nroArticulo = nroArticulo;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public void setFechaExpira(String fechaExpira) {
        this.fechaExpira = fechaExpira;
    }

    public void setFechaElabora(String fechaElabora) {
        this.fechaElabora = fechaElabora;
    }
    
    
}
