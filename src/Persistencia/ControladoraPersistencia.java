/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;
import java.util.ArrayList;
import ElMercadito.ElMercadito;
import model.Articulo;
import model.Bulto;
import model.Caja;
import model.Cajero;
import model.Cliente;
//import model.ClienteMayorista;
//import model.ClienteMinorista;
import model.Compra;
import model.Comprobante;
//import model.ControladoraVisual;
import model.Deposito;
import model.DescripcionArticulo;
//import model.Direccion;
import model.Empleado;
import model.Encabezado;
import model.Encargado;
import model.Estante;
import model.FacturaVta;
import model.Gondola;
import model.LineaDeCompra;
import model.LineaDeTransferencia;
import model.LineaVtaMay;
import model.LineaVtaMin;
//import model.Localidad;
import model.OrdenCompra;
import model.Pago;
import model.Persona;
import model.Proveedor;
//import model.Provincia;
import model.RegistroCompra;
import model.RegistroTransferencia;
import model.RegistroVtaMay;
import model.RegistroVtaMin;
import model.RemitoTransferencia;
import model.RegistroVtaMay;
import model.Repositor;
import model.Seccion;
import model.SectorEstante;
import model.SituacionTributaria;
import model.Sucursal;
import model.TicketVta;
import model.Transferencia;
import model.Venta;
import model.VentaMayorista;
import model.VentaMinorista;
//import model.Zona;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import java.util.List;
// * @author daniel

public class ControladoraPersistencia {
    public ControladoraPersistencia() {
    }
    ArticuloJpaController articuloPersistencia;
    BultoJpaController bultoPersistencia=new BultoJpaController();
    CajaJpaController cajaPersistencia = new CajaJpaController();
    CajeroJpaController cajeroPersistencia = new CajeroJpaController();
    ClienteJpaController clientePersistencia = new ClienteJpaController();
    CompraJpaController compra=new CompraJpaController();
    ComprobanteJpaController comprobantePersistencia = new ComprobanteJpaController();
    DepositoJpaController depositoPersistencia = new DepositoJpaController();
    DescripcionArticuloJpaController descripcionArticuloPersistencia=new DescripcionArticuloJpaController();
    EmpleadoJpaController empleadoPersistencia = new EmpleadoJpaController();
    EncabezadoJpaController encabezadoPersistencia= new EncabezadoJpaController();
    EncargadoJpaController encargadoPersistencia = new EncargadoJpaController();
    EstanteJpaController estantePersistencia = new EstanteJpaController();
    FacturaVtaJpaController facturaVtaPersistencia = new FacturaVtaJpaController();
    GondolaJpaController gondolaPersistencia = new GondolaJpaController();
    LineaDeCompraJpaController lineaDeCompraPersistencia = new LineaDeCompraJpaController();
    LineaDeTransferenciaJpaController lineaDeTransferenciaPersistencia = new LineaDeTransferenciaJpaController();  
    LineaVtaMayJpaController lineaVtaMayPersistencia = new LineaVtaMayJpaController();
    LineaVtaMinJpaController lineaVtaMinPersistencia = new LineaVtaMinJpaController();
    OrdenCompraJpaController ordenCompraPersistencia = new OrdenCompraJpaController();
    PagoJpaController pagoPersistencia = new PagoJpaController();
    PersonaJpaController personaPersistencia = new PersonaJpaController();
    ProveedorJpaController proveedorPersistencia = new ProveedorJpaController();
    RemitoTransferenciaJpaController remitoTransferenciaPersistencia = new RemitoTransferenciaJpaController();
    RemitoVtaJpaController remitoVtaPersistencia = new RemitoVtaJpaController(); 
    RepositorJpaController repositorPersistencia = new RepositorJpaController();  
    SeccionJpaController seccionPersistencia = new SeccionJpaController();
    SectorEstanteJpaController sectorEstantePersistencia = new SectorEstanteJpaController();
    SituacionTributariaJpaController situacionTributariaPersistencia = new SituacionTributariaJpaController();
    //SucursalJpaController sucursalPersistencia = new SucursalJpaController();
    TicketVtaJpaController  ticketVtaPersistencia = new TicketVtaJpaController();
    TransferenciaJpaController transferenciaPersistencia= new TransferenciaJpaController ();
    VentaJpaController ventaPersistencia = new VentaJpaController();
    VentaMayoristaJpaController  ventaMayoristaPersistencia = new VentaMayoristaJpaController();
    VentaMinoristaJpaController ventaMinoristaPersistencia = new VentaMinoristaJpaController();
     


//    //Articulo////
    public void AgregarArticuloPersis(Articulo art) throws PreexistingEntityException, Exception{
       this.articuloPersistencia.create(art);
    }
    public void ModificarArticuloPersis(Articulo art) throws NonexistentEntityException, Exception{
        this.articuloPersistencia.edit(art);
    }
    public void BorrarArticuloPersis(int id) throws NonexistentEntityException{
        this.articuloPersistencia.destroy(id);
    }
    public List<Articulo> BuscarListaArticulos(){
       return this.articuloPersistencia.findArticuloEntities();
    }
    /*public Articulo BuscarUnArticulo(String id){
        return this.articuloPersistencia.findArticulo(id);
    }*/
    //Bulto////
    public void AgregarBultoPersis(Bulto bul) throws PreexistingEntityException, Exception{
       this.bultoPersistencia.create(bul);
    }
    public void ModificarBultoPersis(Bulto bul) throws NonexistentEntityException, Exception{
        this.bultoPersistencia.edit(bul);
    }
    public void BorrarBultoPersis(String id) throws NonexistentEntityException{
        this.bultoPersistencia.destroy(id);
    }
    public List<Bulto> BuscarListaBultos(){
       return this.bultoPersistencia.findBultoEntities();
    }
    public Bulto BuscarUnBulto(String id){
        return this.bultoPersistencia.findBulto(id);
    }
    
    //Caja////
    
    public void AgregarCajaPersis(Caja caja) throws PreexistingEntityException, Exception{
       this.cajaPersistencia.create(caja);
    }
    public void ModificarCajaPersis(Caja caja) throws NonexistentEntityException, Exception{
        this.cajaPersistencia.edit(caja);
    }
    public void BorrarCajaPersis(int id) throws NonexistentEntityException{
        this.cajaPersistencia.destroy(id);
    }
    public List<Caja> BuscarListaCajas(){
       return this.cajaPersistencia.findCajaEntities();
    }
    public Caja BuscarUnaCaja(int id){
        return this.cajaPersistencia.findCaja(id);
}
    
 //Cajero////   
//    CajeroJpaController cajeroPersistencia = new CajeroJpaController(); 
    public void AgregarCajeroPersis(Cajero cajero) throws PreexistingEntityException, Exception{
       this.cajeroPersistencia.create(cajero);
    }
    public void ModificarCajeroPersis(Cajero cajero) throws NonexistentEntityException, Exception{
        this.cajeroPersistencia.edit(cajero);
    }
    public void BorrarCajeroPersis(String id) throws NonexistentEntityException{
        this.cajeroPersistencia.destroy(id);
    }
    public List<Cajero> BuscarListaCajeros(){
       return this.cajeroPersistencia.findCajeroEntities();
    }
    public Cajero BuscarUnCajero(String id){
        return this.cajeroPersistencia.findCajero(id);
    }
    //Cliente////   
//    CajeroJpaController cajeroPersistencia = new CajeroJpaController(); 
    public void AgregarClientePersis(Cliente cliente) throws PreexistingEntityException, Exception{
       this.clientePersistencia.create(cliente);
    }
    public void ModificarClientePersis(Cliente cliente) throws NonexistentEntityException, Exception{
        this.clientePersistencia.edit(cliente);
    }
    public void BorrarClientePersis(int id) throws NonexistentEntityException{
        this.clientePersistencia.destroy(id);
    }
    public List<Cliente> BuscarListaClientesPersis(){
       return this.clientePersistencia.findClienteEntities();
    }
    public Object BuscarUnCliente(String idPersona){
        return this.clientePersistencia.findCliente(idPersona);
    }


 //Proveedor///   
//    
    public void AgregarProveedorPersis(Proveedor proveedor) throws PreexistingEntityException, Exception{
       this.proveedorPersistencia.create(proveedor);
    }
    public void ModificarProveedorPersis(Proveedor proveedor) throws NonexistentEntityException, Exception{
        this.proveedorPersistencia.edit(proveedor);
    }
    public void BorrarProveedorPersis(int id) throws NonexistentEntityException{
        this.proveedorPersistencia.destroy(id);
    }
    public List<Proveedor> BuscarListaProveedoresPersis(){
       return this.proveedorPersistencia.findProveedorEntities();
    }
    public Object BuscarUnProveedor(String id){
        return this.proveedorPersistencia.findProveedor(id);
    }
    //Persona///   
//    
    public void AgregarPersonaPersis(Persona persona) throws PreexistingEntityException, Exception{
       this.personaPersistencia.create(persona);
    }
    public void ModificarPersonaPersis(Persona persona) throws NonexistentEntityException, Exception{
        this.personaPersistencia.edit(persona);
    }
    public void BorrarPersonaPersis(int id) throws NonexistentEntityException{
        this.personaPersistencia.destroy(id);
    }
    public List<Persona> BuscarListaPersonas(){
       return this.personaPersistencia.findPersonaEntities();
    }
    public Object BuscarUnPersona(String id){
        return this.personaPersistencia.findPersona(id);
    }
    
    //Empleado
    public void AgregarUnEmpleadoPersis(Empleado emp) throws PreexistingEntityException, Exception{
       this.empleadoPersistencia.create(emp);
    }
    public void ModificarUnEmpleadoPersis(Empleado emp) throws NonexistentEntityException, Exception{
        this.empleadoPersistencia.edit(emp);
    }
    public void BorrarEmpleadoPersis(String idPersona) throws NonexistentEntityException{
        this.empleadoPersistencia.destroy(idPersona) ;
    }
    public Empleado BuscarEmpleadoPersis(String idPersona){
        return (Empleado) this.empleadoPersistencia.findEmpleado(idPersona);
    }
    public List<Empleado> BuscarListaEmpleadoPersis(){
        return this.empleadoPersistencia.findEmpleadoEntities();
    }
    ///////////////////////////////////////////////////////
}