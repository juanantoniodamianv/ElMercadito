/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Daniel
 */
@Entity
public class Caja implements Serializable {
    @Id
    private int nroCaja;
    
    public Caja(){}

    public Caja(int nroCaja) {
        this.nroCaja = nroCaja;
    }

    public int getNroCaja() {
        return nroCaja;
    }

    public void setNroCaja(int nroCaja) {
        this.nroCaja = nroCaja;
    }
    
    
}
