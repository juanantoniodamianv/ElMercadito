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
 * @author Antonio
 */
@Entity
public class Pago implements Serializable{
     @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int codigoPago;
    @Basic
    private String tipopago;
    @Basic
    private float subtotal;
    @Basic
    private float recargo;
    @Basic
    private float total;
  public Pago(){}

    public Pago(int codigoPago, String tipopago, float subtotal, float recargo, float total) {
        this.codigoPago = codigoPago;
        this.tipopago = tipopago;
        this.subtotal = subtotal;
        this.recargo = recargo;
        this.total = total;
    }

    public int getCodigoPago() {
        return codigoPago;
    }

    public String getTipopago() {
        return tipopago;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public float getRecargo() {
        return recargo;
    }

    public float getTotal() {
        return total;
    }
  
  
}
