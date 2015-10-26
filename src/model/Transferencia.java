/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.ArrayList;

/**
 *
 * @author Antonio
 */
public class Transferencia {
    private String tipotransferencia;
    private String origen;
    private String destino;
    private String fecha;
    private String hora;
    private RemitoTransferencia unRemito;
    private ArrayList<LineaDeTransferencia>listaLineaDeTransferencia;
    
    
    public Transferencia(){}

    public Transferencia(String tipotransferencia, String origen, String destino, String fecha, String hora, RemitoTransferencia unRemito, ArrayList<LineaDeTransferencia> listaLineaDeTransferencia) {
        this.tipotransferencia = tipotransferencia;
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.hora = hora;
        this.unRemito = unRemito;
        this.listaLineaDeTransferencia = listaLineaDeTransferencia;
    }

    public String getTipotransferencia() {
        return tipotransferencia;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public RemitoTransferencia getUnRemito() {
        return unRemito;
    }

    public ArrayList<LineaDeTransferencia> getListaLineaDeTransferencia() {
        return listaLineaDeTransferencia;
    }

    public void setTipotransferencia(String tipotransferencia) {
        this.tipotransferencia = tipotransferencia;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setUnRemito(RemitoTransferencia unRemito) {
        this.unRemito = unRemito;
    }

    public void setListaLineaDeTransferencia(ArrayList<LineaDeTransferencia> listaLineaDeTransferencia) {
        this.listaLineaDeTransferencia = listaLineaDeTransferencia;
    }

    
    }

    

    
    
            
            
    

