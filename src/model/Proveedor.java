/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 *
 * @author Antonio
 */
@Entity
public class Proveedor extends Persona implements Serializable{
<<<<<<< HEAD
//    private static final long serialVersionUID = 1L;
////porqué me pide esto?
//    public static long getSerialVersionUID() {
//        return serialVersionUID;
//    }
    @Basic 
    private int nroProveedor;
=======
    private static final long serialVersionUID = 1L;
//porqué me pide esto?
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
>>>>>>> refs/remotes/origin/RamaA
    @Basic
    private String razonSocial;
    
    @Basic 
<<<<<<< HEAD
    private String nroCuit;
    
   
   
 public Proveedor(){}

    
    

    public Proveedor(int nroProveedor, String razonSocial, String nroCiut, String dni, String apellido, String nombre, String fechaNac, String telefono, String condicionIva, String direccion, String provincia, String localidad) {
        super(dni, apellido, nombre, fechaNac, telefono, condicionIva, direccion, provincia, localidad);
        this.nroProveedor = nroProveedor;
        this.razonSocial = razonSocial;
        this.nroCuit = nroCiut;
    }

    public int getNroProveedor() {
        return nroProveedor;
=======
    private String nroCiut;
    
    @Basic 
    private String nombreFantasia;
    
    @OneToOne
    private SituacionTributaria unaSituaciontributaria;
   
 public Proveedor(){}

    public Proveedor(String razonSocial, String nroCiut, String nombreFantasia, SituacionTributaria unaSituaciontributaria) {
        this.razonSocial = razonSocial;
        this.nroCiut = nroCiut;
        this.nombreFantasia = nombreFantasia;
        this.unaSituaciontributaria = unaSituaciontributaria;
>>>>>>> refs/remotes/origin/RamaA
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public String getNroCiut() {
<<<<<<< HEAD
        return nroCuit;
    }

    public void setNroProveedor(int nroProveedor) {
        this.nroProveedor = nroProveedor;
=======
        return nroCiut;
    }

    public String getNombreFantasia() {
        return nombreFantasia;
    }

    public SituacionTributaria getUnaSituaciontributaria() {
        return unaSituaciontributaria;
>>>>>>> refs/remotes/origin/RamaA
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public void setNroCiut(String nroCiut) {
<<<<<<< HEAD
        this.nroCuit = nroCiut;
    }
   
}
=======
        this.nroCiut = nroCiut;
    }

    public void setNombreFantasia(String nombreFantasia) {
        this.nombreFantasia = nombreFantasia;
    }

    public void setUnaSituaciontributaria(SituacionTributaria unaSituaciontributaria) {
        this.unaSituaciontributaria = unaSituaciontributaria;
    }

}
>>>>>>> refs/remotes/origin/RamaA
