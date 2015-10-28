/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Antonio
 */
@Entity
public class FacturaVta extends Comprobante implements Serializable{
 @Basic
  private int nroFactura;
 @Basic
  private String tipoFactura;
 @Basic
  private String puntoVenta;
 @Basic
  private int cantidad;
 @Basic
  private float importe;
 @Basic
  private Date fechaVencimiento;
 @Basic
  private Date fechaEmision;
 //segun modelo que paso el profesor Koch y consultas que se realizaron sería asi la parte de abajo
//consta de un subtotal, un impuesto (si hubiese distinto al iva), un subtotal con ese impuesto, el porcentaje del del iva
//el importe del iva, y finalmente se sumaria el subtotal con impuesto mas el iva y daria el total.
 @Basic
  private float subTotales;
 @Basic
  private float porcImpuesto;
 @Basic
  private float impuesto;
 @Basic
  private float subTotalConImpuesto;
 @Basic
  private float porcIva;
 @Basic
  private float iva;
 @Basic
  private float totales;
 @Basic
  private String claveAutorImpresion;
 //esto re sepite, seria la descripcionArticulo y el precioUnitario. El importe se calcula muliplicando precio por cantidad.
 @OneToMany
  private ArrayList<DescripcionArticulo> unaDescripcionArticulo;
 //completa la parte de los datos del cliente
 @OneToOne
  private Cliente unCliente;
  //encabeazado tendria los datos de la empresa, el numero de sucursal, fecha de inicio, situacion tributaria
  //IB que se cargarian primero
 @OneToOne
  private Encabezado unEncabezado;
 
  public FacturaVta(){}

    public FacturaVta(int nroFactura, String tipoFactura, String puntoVenta, int cantidad, float importe, Date fechaVencimiento, Date fechaEmision, float subTotales, float porcImpuesto, float impuesto, float subTotalConImpuesto, float porcIva, float iva, float totales, String claveAutorImpresion, ArrayList<DescripcionArticulo> unaDescripcionArticulo, Cliente unCliente, Encabezado unEncabezado) {
        this.nroFactura = nroFactura;
        this.tipoFactura = tipoFactura;
        this.puntoVenta = puntoVenta;
        this.cantidad = cantidad;
        this.importe = importe;
        this.fechaVencimiento = fechaVencimiento;
        this.fechaEmision = fechaEmision;
        this.subTotales = subTotales;
        this.porcImpuesto = porcImpuesto;
        this.impuesto = impuesto;
        this.subTotalConImpuesto = subTotalConImpuesto;
        this.porcIva = porcIva;
        this.iva = iva;
        this.totales = totales;
        this.claveAutorImpresion = claveAutorImpresion;
        this.unaDescripcionArticulo = unaDescripcionArticulo;
        this.unCliente = unCliente;
        this.unEncabezado = unEncabezado;
    }

    public int getNroFactura() {
        return nroFactura;
    }

    public String getTipoFactura() {
        return tipoFactura;
    }

    public String getPuntoVenta() {
        return puntoVenta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public float getImporte() {
        return importe;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public float getSubTotales() {
        return subTotales;
    }

    public float getPorcImpuesto() {
        return porcImpuesto;
    }

    public float getImpuesto() {
        return impuesto;
    }

    public float getSubTotalConImpuesto() {
        return subTotalConImpuesto;
    }

    public float getPorcIva() {
        return porcIva;
    }

    public float getIva() {
        return iva;
    }

    public float getTotales() {
        return totales;
    }

    public String getClaveAutorImpresion() {
        return claveAutorImpresion;
    }

    public ArrayList<DescripcionArticulo> getUnaDescripcionArticulo() {
        return unaDescripcionArticulo;
    }

    public Cliente getUnCliente() {
        return unCliente;
    }

    public Encabezado getUnEncabezado() {
        return unEncabezado;
    }

    public void setNroFactura(int nroFactura) {
        this.nroFactura = nroFactura;
    }

    public void setTipoFactura(String tipoFactura) {
        this.tipoFactura = tipoFactura;
    }

    public void setPuntoVenta(String puntoVenta) {
        this.puntoVenta = puntoVenta;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public void setSubTotales(float subTotales) {
        this.subTotales = subTotales;
    }

    public void setPorcImpuesto(float porcImpuesto) {
        this.porcImpuesto = porcImpuesto;
    }

    public void setImpuesto(float impuesto) {
        this.impuesto = impuesto;
    }

    public void setSubTotalConImpuesto(float subTotalConImpuesto) {
        this.subTotalConImpuesto = subTotalConImpuesto;
    }

    public void setPorcIva(float porcIva) {
        this.porcIva = porcIva;
    }

    public void setIva(float iva) {
        this.iva = iva;
    }

    public void setTotales(float totales) {
        this.totales = totales;
    }

    public void setClaveAutorImpresion(String claveAutorImpresion) {
        this.claveAutorImpresion = claveAutorImpresion;
    }

    public void setUnaDescripcionArticulo(ArrayList<DescripcionArticulo> unaDescripcionArticulo) {
        this.unaDescripcionArticulo = unaDescripcionArticulo;
    }

    public void setUnCliente(Cliente unCliente) {
        this.unCliente = unCliente;
    }

    public void setUnEncabezado(Encabezado unEncabezado) {
        this.unEncabezado = unEncabezado;
    }
  
  
}
