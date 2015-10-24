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
public class RegistroTransferencia {
    
    private ArrayList<Transferencia>ListaTransferencias;
  public RegistroTransferencia(){}

    public RegistroTransferencia(ArrayList<Transferencia> ListaTransferencias) {
        this.ListaTransferencias = ListaTransferencias;
    }

    public ArrayList<Transferencia> getListaTransferencias() {
        return ListaTransferencias;
    }

    public void setListaTransferencias(ArrayList<Transferencia> ListaTransferencias) {
        this.ListaTransferencias = ListaTransferencias;
    }
  
}
