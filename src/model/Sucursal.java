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
    private List<Cliente> listaClientes = new LinkedList();
    private List<Proveedor> listaProveedores = new LinkedList();
    
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
    private List<Proveedor> cargarListaProveedoresBD(){
        return this.listaProveedores = Sucursal.persistencia.BuscarListaProveedoresPersis();
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
    
    //CLIENTE
    public void ModificarUnCliente(Cliente unCliente, String idPersona, String apellido, String nombre, String razonSocial, String tipoCliente, String ivaCondicion, String telefono, String direccion, String localidad, String provincia) throws PreexistingEntityException, Exception{
        unCliente.setIdPersona(idPersona);
        unCliente.setApellido(apellido);
        unCliente.setNombre(nombre);
        unCliente.setRazonSocial(razonSocial);
        unCliente.setTipoCliente(tipoCliente);
        unCliente.setIvaCondicion(ivaCondicion);
        unCliente.setTelefono(telefono);
        unCliente.setDireccion(direccion);
        unCliente.setProvincia(provincia);
        unCliente.setLocalidad(localidad);
        Sucursal.persistencia.ModificarClientePersis(unCliente);
    }
    public void AgregarUnCliente(String idPersona, String apellido, String nombre, String razonSocial, String tipoCliente, String ivaCondicion, String telefono, String direccion, String localidad, String provincia) throws PreexistingEntityException, Exception{
        Cliente unCliente = new Cliente(idPersona, apellido, nombre, razonSocial, tipoCliente, ivaCondicion, telefono, direccion, localidad, provincia);
        this.listaClientes.add(unCliente);
        Sucursal.persistencia.AgregarClientePersis(unCliente);
    }
    public Cliente BuscarCliente(String idPersona){
        Cliente aux=null, cli;
        Iterator it = this.cargarListaClientesBD().iterator();
        while(it.hasNext()){
            cli=(Cliente) it.next();
            if(cli.getIdPersona().equals(idPersona)){
                aux=cli;
            }
        }
        return aux;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
    
    private List<Cliente> cargarListaClientesBD(){
        return this.listaClientes = Sucursal.persistencia.BuscarListaClientesPersis();
    }
    
    ////////////////////////////////////////////////////////////////////////////////////
    
    //PROVEEDOR
    public void ModificarUnProveedor(Proveedor unProveedor, String idPersona, String razonSocial, String situacionTributaria, String tipoProveduria, String telefono, String direccion, String localidad, String provincia)  throws PreexistingEntityException, Exception{
        unProveedor.setIdPersona(idPersona);
        unProveedor.setRazonSocial(razonSocial);
        unProveedor.setSituacionTributaria(situacionTributaria);
        unProveedor.setTipoProveduria(tipoProveduria);
        unProveedor.setTelefono(telefono);
        unProveedor.setDireccion(direccion);
        unProveedor.setLocalidad(localidad);
        unProveedor.setProvincia(provincia);
        Sucursal.persistencia.ModificarProveedorPersis(unProveedor);
    
    }
    
    public void AgregarUnProveedor(String idPersona, String razonSocial, String situacionTributaria, String tipoProveduria, String telefono, String direccion, String localidad, String provincia) throws PreexistingEntityException, Exception{
        Proveedor unProveedor = new Proveedor(idPersona, razonSocial, situacionTributaria, tipoProveduria, telefono, direccion, localidad, provincia);
        this.listaProveedores.add(unProveedor);
        Sucursal.persistencia.AgregarProveedorPersis(unProveedor);
    }
    
    public Proveedor BuscarProveedor(String idPersona){
        Proveedor aux=null, pro;
        Iterator it = this.cargarListaProveedoresBD().iterator();
        while(it.hasNext()){
            pro=(Proveedor) it.next();
            if(pro.getIdPersona().equals(idPersona)){
                aux=pro;
            }
        }
        return aux;
    }
    
    public List<Proveedor> getListaProveedores() {
        return listaProveedores;
    }

    public void setListaProveedores(List<Proveedor> listaProveedores) {
        this.listaProveedores = listaProveedores;
    }
    
}
