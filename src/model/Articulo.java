/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 *
 * @author Daniel
 */
@Entity
public class Articulo implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int idArticulo;    
    @Basic
    private int codigoBarra;
    @Basic
    private String lote;
    @Basic
    private String fechaExpira;
    @Basic
    private String fechaElabora;
    
    public Articulo(){}

    public Articulo(int idArticulo, int codigoBarra, String lote, String fechaExpira, String fechaElabora) {
        this.idArticulo = idArticulo;
        this.codigoBarra = codigoBarra;
        this.lote = lote;
        this.fechaExpira = fechaExpira;
        this.fechaElabora = fechaElabora;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public int getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(int codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getFechaExpira() {
        return fechaExpira;
    }

    public void setFechaExpira(String fechaExpira) {
        this.fechaExpira = fechaExpira;
    }

    public String getFechaElabora() {
        return fechaElabora;
    }

    public void setFechaElabora(String fechaElabora) {
        this.fechaElabora = fechaElabora;
    }
    
   
  
}
