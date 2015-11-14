/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

//import javax.swing.text.html.parser.Entity;

import Persistencia.ControladoraPersistencia;
import Persistencia.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Antonio
 */
@Entity
public class Sucursal implements Serializable {
    @Id
    private int nroSucursal;
    @Basic
    private String cuil;
    @Basic
    private String telefono;
    @Basic
    private String razonSocial;
    
    private Deposito unDeposito;
    
    private String direccion;
    
    private ArrayList<Persona> listaPersonas;
    
    private ArrayList<Caja> listaCajas;
    
    private ArrayList<ListaDePrecio> ListaDePrecios;
    
    private List<Empleado> listaEmpleados = new LinkedList();
    public static final ControladoraPersistencia persistencia = new ControladoraPersistencia();
//    constructor nulo
    public Sucursal(){}
    
//    constructor con parámetros
    public Sucursal(int nroSucursal, String cuil, String telefono, String razonSocial) {
        this();
        this.nroSucursal = nroSucursal;
        this.cuil = cuil;
        this.telefono = telefono;
        this.razonSocial = razonSocial;
        this.unDeposito = unDeposito;
        this.direccion = direccion;
        this.listaPersonas = listaPersonas;
        this.listaCajas = listaCajas;
        this.ListaDePrecios = ListaDePrecios;
    }

    public int getNroSucursal() {
        return nroSucursal;
    }

    public void setNroSucursal(int nroSucursal) {
        this.nroSucursal = nroSucursal;
    }

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public Deposito getUnDeposito() {
        return unDeposito;
    }

    public void setUnDeposito(Deposito unDeposito) {
        this.unDeposito = unDeposito;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(ArrayList<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    public ArrayList<Caja> getListaCajas() {
        return listaCajas;
    }

    public void setListaCajas(ArrayList<Caja> listaCajas) {
        this.listaCajas = listaCajas;
    }

    public ArrayList<ListaDePrecio> getListaDePrecios() {
        return ListaDePrecios;
    }

    public void setListaDePrecios(ArrayList<ListaDePrecio> ListaDePrecios) {
        this.ListaDePrecios = ListaDePrecios;
    }

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }
    private List<Empleado> cargarListaEmpleadosBD() {
        return this.listaEmpleados = Sucursal.persistencia.BuscarListaEmpleadoPersis();
    }
    
    //EMPLEADO
    public void ModificarUnEmpleado(Empleado unEmpleado, String idPersona, String apellido, String nombre, String fechaNac, String sexo, String estadoCivil, String fechaIngreso, String cargo, String telefono, String direccion, String provincia, String localidad) throws PreexistingEntityException, Exception{
        unEmpleado.setIdPersona(idPersona);
        unEmpleado.setApellido(apellido);
        unEmpleado.setNombre(nombre);
        unEmpleado.setFechaNac(fechaNac);
        unEmpleado.setSexo(sexo);
        unEmpleado.setEstadoCivil(estadoCivil);
        unEmpleado.setFechaIngreso(fechaIngreso);
        unEmpleado.setCargo(cargo);
        unEmpleado.setTelefono(telefono);
        unEmpleado.setDireccion(direccion);
        unEmpleado.setProvincia(provincia);
        unEmpleado.setLocalidad(localidad);
        Sucursal.persistencia.ModificarUnEmpleadoPersis(unEmpleado);
    }    
    public void AgregarUnEmpleado(String idPersona, String apellido, String nombre, String fechaNac, String sexo, String estadoCivil, String fechaIngreso, String cargo, String telefono, String direccion, String provincia, String localidad) throws PreexistingEntityException, Exception{
	Empleado unEmpleado = new Empleado(idPersona, apellido, nombre, fechaNac, sexo, estadoCivil, fechaIngreso, cargo, telefono, direccion, provincia, localidad);
	this.listaEmpleados.add(unEmpleado);
	Sucursal.persistencia.AgregarUnEmpleadoPersis(unEmpleado);    
    }
    public Empleado BuscarEmpleado(String idPersona){
        Empleado aux=null, emp;
        Iterator it = this.cargarListaEmpleadosBD().iterator();
        while(it.hasNext()){
            emp=(Empleado) it.next();
            if(emp.getIdPersona().equals(idPersona)){
                aux=emp;
            }
        }
        return aux;
    }
    ////////////////////////////////////////////////////////////////////////////////////

    
}
