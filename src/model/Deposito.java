/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Antonio
 */
@Entity
public class Deposito implements Serializable {
    @Id
    private int nroDeposito;
    @OneToMany
    private ArrayList<Seccion>ListaSecciones;
    @OneToMany
    private ArrayList<RegistroTransferencia>ListaRegistroTransferencia;
    @OneToMany
    private ArrayList<RegistroCompra>ListaRegistrocompras;
    @OneToOne
    private Encargado unencargado;
    @OneToOne
    private Transferencia unaTransferencia;
    
    public Deposito(){}

    public Deposito(int nroDeposito, ArrayList<Seccion> ListaSecciones, ArrayList<RegistroTransferencia> ListaRegistroTransferencia, ArrayList<RegistroCompra> ListaRegistrocompras, Encargado unencargado, Transferencia unaTransferencia) {
        this.nroDeposito = nroDeposito;
        this.ListaSecciones = ListaSecciones;
        this.ListaRegistroTransferencia = ListaRegistroTransferencia;
        this.ListaRegistrocompras = ListaRegistrocompras;
        this.unencargado = unencargado;
        this.unaTransferencia = unaTransferencia;
    }

    public int getNroDeposito() {
        return nroDeposito;
    }

    public ArrayList<Seccion> getListaSecciones() {
        return ListaSecciones;
    }

    public ArrayList<RegistroTransferencia> getListaRegistroTransferencia() {
        return ListaRegistroTransferencia;
    }

    public ArrayList<RegistroCompra> getListaRegistrocompras() {
        return ListaRegistrocompras;
    }

    public Encargado getUnencargado() {
        return unencargado;
    }

    public Transferencia getUnaTransferencia() {
        return unaTransferencia;
    }

}