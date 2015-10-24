/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
//import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Antonio
 */
 @Entity
public class Estante implements Serializable{
     @Id
    private int nroEstante;
    public Estante(){}

    public Estante(int nroEstante) {
        this.nroEstante = nroEstante;
    }

    public int getNroEstante() {
        return nroEstante;
    }

    public void setNroEstante(int nroEstante) {
        this.nroEstante = nroEstante;
    }
    
}
