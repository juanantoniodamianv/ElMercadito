/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author Antonio
 */
@Entity
public class ClienteMinorista extends Cliente implements Serializable{
    
    public ClienteMinorista(){}

    public ClienteMinorista(int nroCliente, String apellido, String nombre, String cuil, String fechaNac, SituacionTributaria unaSituacionTributaria) {
        super(nroCliente, apellido, nombre, cuil, fechaNac, unaSituacionTributaria);
    }

}

