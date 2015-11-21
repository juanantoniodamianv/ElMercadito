/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import ElMercadito.ElMercadito;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.management.Query.gt;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import model.Cliente;
import model.DescripcionArticulo;
import model.Empleado;
import model.Proveedor;


/**
 *
 * @author Juan Antonio Damian Vargas
 */
public class InternalFrameAdministracion extends javax.swing.JInternalFrame {
    private ElMercadito unMercadito;
    private DefaultListModel modeloEmpleados = new DefaultListModel();
    private DefaultListModel modeloClientes = new DefaultListModel();
    private DefaultListModel modeloProveedor = new DefaultListModel();
    private DefaultListModel modeloArticulo = new DefaultListModel();
    
    /**
     * Creates new form InternalFrameAdministracion
     * @param unMercadito
     */
    public InternalFrameAdministracion(ElMercadito unMercadito) {
        this.unMercadito= unMercadito;
        initComponents();
        //########EMPLEADOS##############///
        this.ListEmpleados.setModel(modeloEmpleados);
        btnGuardarEmpleado.setEnabled(false);
        btnNuevoEmpleado.setEnabled(true);
        btnEditarEmpleado.setEnabled(false);
        btnGuardarEditEmpleado.setEnabled(false);
        btnEliminarEmpleado.setEnabled(false);
        btnCancelarEmpleado.setEnabled(false);
        txtEditableEmpleado(false);
        //###################################///////
        //##########ARTICULOS##############///
        this.ListArticulosDetalles.setModel(modeloArticulo);
        btnGuardarArticulo.setEnabled(false);
        btnGuardarEditArticulo.setEnabled(false);
        btnNuevoArticulo.setEnabled(true);
        btnEditarArticulo.setEnabled(false);
        btnEliminarArticulo.setEnabled(false);
        btnCancelarArticulo.setEnabled(false);
        txtEditableArticulo(false);
        //###################################///////
        //##########PROVEEDOR##############///
        this.ListProveedor.setModel(modeloProveedor);
        btnGuardarProveedor.setEnabled(false);
        btnGuardarEditProveedor.setEnabled(false);
        btnNuevoProveedor.setEnabled(true);
        btnEditarProveedor.setEnabled(false);
        btnEliminarProveedor.setEnabled(false);
        btnCancelarProveedor.setEnabled(false);
        txtEditableProveedor(false);
        //###################################///////
        //##########CLIENTE##############///
        this.ListClientes.setModel(modeloEmpleados);
        btnGuardarCliente.setEnabled(false);
        btnGuardarEditCliente.setEnabled(false);
        btnNuevoCliente.setEnabled(true);
        btnEditarCliente.setEnabled(false);
        btnEliminarCliente.setEnabled(false);
        btnCancelarCliente.setEnabled(false);
        txtEditableCliente(false);
        //###################################///////        
    }
    //HACE EDITABLE LOS CAMPOS DEL FORMULARIO DETALLE ARTICULOS
    public void txtEditableArticulo(boolean bool){
        txtCodBarraArticulo.setEditable(bool);
        txtNombreArticulo.setEditable(bool);
        txtDescripcionArticulo.setEditable(bool);
        txtTipoEnvaseArticulo.setEditable(bool);
        cmbUnDeMedidaArticulo.setEnabled(bool);
        txtCantMedidaArticulo.setEditable(bool);
        txtPrecioUnitCompraArticulo.setEditable(bool);
        txtPrecioUnitVentaArticulo.setEditable(bool);
        txtPrecioUnitMayVentaArticulo.setEditable(bool);
    }
    //LIMPIA LOS CAMPOS DEL FORMULARIO DETALLE ARTICULOS
    public void limpiarTxtArticulo(){
        txtCodBarraArticulo.setText("");
        txtNombreArticulo.setText("");
        txtDescripcionArticulo.setText("");
        txtTipoEnvaseArticulo.setText("");
        txtCantMedidaArticulo.setText("");
        txtPrecioUnitCompraArticulo.setText("");
        txtPrecioUnitVentaArticulo.setText("");
        txtPrecioUnitMayVentaArticulo.setText("");
    }
    //
    //Hace editable los campos del formulario PROVEEDOR
    public void txtEditableProveedor(boolean bool){
        txtCuitProveedor.setEditable(bool);
        txtRazonSocialProveedor.setEditable(bool);
        cmbSituacTribProveedor.setEnabled(bool);
        txtTipoProveeduriaProveedor.setEditable(bool);
        txtTelProveedor.setEditable(bool);
        txtDireccionProveedor.setEditable(bool);
        txtProvinciaProveedor.setEditable(bool);
        txtLocalidadProveedor.setEditable(bool);
    }
    public void limpiarTxtProveedor(){
        txtCuitProveedor.setText("");
        txtRazonSocialProveedor.setText("");
        txtTipoProveeduriaProveedor.setText("");
        txtTelProveedor.setText("");
        txtDireccionProveedor.setText("");
        txtProvinciaProveedor.setText("");
        txtLocalidadProveedor.setText("");
    }
    //Hace editable los campos del formulario CLIENTE
    public void txtEditableCliente(boolean bool){
        cmbTipoCliente.setEnabled(bool);
        txtCuitCliente.setEditable(bool);
        txtRazonSocialCliente.setEditable(bool);
        txtApellidoCliente.setEditable(bool);
        txtNombreCliente.setEditable(bool);
        cmbCondIvaCliente.setEnabled(bool);
        txtTelCliente.setEditable(bool);
        txtDireccionCliente.setEditable(bool);
        txtProvinciaCliente.setEditable(bool);
        txtLocalidadCliente.setEditable(bool);
    }
    public void limpiarTxtCliente(){
        txtCuitCliente.setText("");
        txtRazonSocialCliente.setText("");
        txtApellidoCliente.setText("");
        txtNombreCliente.setText("");
        txtTelCliente.setText("");
        txtDireccionCliente.setText("");
        txtProvinciaCliente.setText("");
        txtLocalidadCliente.setText("");
    }
    //Hace editable los campos del formulario EMPLEADO
    public void txtEditableEmpleado(boolean bool){
        txtApellidoEmpleado.setEditable(bool);
        txtNombreEmpleado.setEditable(bool);
        txtFechaNacEmpleado.setEditable(bool);
        txtCuilEmpleado.setEditable(bool);
        cmbSexoEmpleado.setEnabled(bool);
        cmbEstadoCivilEmpleado.setEnabled(bool);
        txtFechaIngEmpleado.setEditable(bool);
        txtCargoEmpleado.setEditable(bool);
        txtTelEmpleado.setEditable(bool);
        txtDireccionEmpleado.setEditable(bool);
        txtProvinciaEmpleado.setEditable(bool);
        txtLocalidadEmpleado.setEditable(bool);
    }
    public void limpiarTxtEmpleado(){
        txtApellidoEmpleado.setText("");
        txtNombreEmpleado.setText("");
        txtFechaNacEmpleado.setText("");
        txtCuilEmpleado.setText("");
        txtFechaIngEmpleado.setText("");
        txtCargoEmpleado.setText("");
        txtTelEmpleado.setText("");
        txtDireccionEmpleado.setText("");
        txtProvinciaEmpleado.setText("");
        txtLocalidadEmpleado.setText("");
    }
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jTabbedPaneAdministracion = new javax.swing.JTabbedPane();
        jPanelProveedores = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        lblRazonSocialProveedor = new javax.swing.JLabel();
        txtRazonSocialProveedor = new javax.swing.JTextField();
        lblSituacTribProveedor = new javax.swing.JLabel();
        lblCuitProveedor = new javax.swing.JLabel();
        txtCuitProveedor = new javax.swing.JTextField();
        cmbSituacTribProveedor = new javax.swing.JComboBox();
        jPanel14 = new javax.swing.JPanel();
        lblDireccionProveedor = new javax.swing.JLabel();
        txtDireccionProveedor = new javax.swing.JTextField();
        lblProvinciaProveedor = new javax.swing.JLabel();
        lblLocalidadProveedor = new javax.swing.JLabel();
        txtProvinciaProveedor = new javax.swing.JTextField();
        txtLocalidadProveedor = new javax.swing.JTextField();
        lblTelProveedor = new javax.swing.JLabel();
        txtTelProveedor = new javax.swing.JTextField();
        lblTipoProveeduriaProveedor = new javax.swing.JLabel();
        txtTipoProveeduriaProveedor = new javax.swing.JTextField();
        btnNuevoProveedor = new javax.swing.JButton();
        btnEditarProveedor = new javax.swing.JButton();
        btnGuardarProveedor = new javax.swing.JButton();
        btnCancelarProveedor = new javax.swing.JButton();
        btnEliminarProveedor = new javax.swing.JButton();
        btnGuardarEditProveedor = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        lblBuscarProveedor = new javax.swing.JLabel();
        txtBuscarProveedor = new javax.swing.JTextField();
        btnBuscarProveedor = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListProveedor = new javax.swing.JList();
        jPanelClientes = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        txtBuscarCliente = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        ListClientes = new javax.swing.JList();
        btnBuscarCliente = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        lblApellidoCliente = new javax.swing.JLabel();
        txtApellidoCliente = new javax.swing.JTextField();
        lblNombreCliente = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JTextField();
        lblTipoCliente = new javax.swing.JLabel();
        cmbTipoCliente = new javax.swing.JComboBox();
        lblCuitCliente = new javax.swing.JLabel();
        txtCuitCliente = new javax.swing.JTextField();
        lblRazonSocialCliente = new javax.swing.JLabel();
        txtRazonSocialCliente = new javax.swing.JTextField();
        lblCondIva = new javax.swing.JLabel();
        cmbCondIvaCliente = new javax.swing.JComboBox();
        lblTelCliente = new javax.swing.JLabel();
        txtTelCliente = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        lblDireccionCliente = new javax.swing.JLabel();
        txtDireccionCliente = new javax.swing.JTextField();
        lblProvinciaCliente = new javax.swing.JLabel();
        lblLocalidadCliente = new javax.swing.JLabel();
        txtProvinciaCliente = new javax.swing.JTextField();
        txtLocalidadCliente = new javax.swing.JTextField();
        btnGuardarCliente = new javax.swing.JButton();
        btnNuevoCliente = new javax.swing.JButton();
        btnEditarCliente = new javax.swing.JButton();
        btnCancelarCliente = new javax.swing.JButton();
        btnEliminarCliente = new javax.swing.JButton();
        btnGuardarEditCliente = new javax.swing.JButton();
        jPanelEmpleados = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        lblApellidoEmpleado = new javax.swing.JLabel();
        txtApellidoEmpleado = new javax.swing.JTextField();
        lblNombreEmpleado = new javax.swing.JLabel();
        txtNombreEmpleado = new javax.swing.JTextField();
        lblFechaNacEmpleado = new javax.swing.JLabel();
        lblCuilEmpleado = new javax.swing.JLabel();
        txtCuilEmpleado = new javax.swing.JTextField();
        lblSexoEmpleado = new javax.swing.JLabel();
        cmbSexoEmpleado = new javax.swing.JComboBox();
        lblEstadoCivilEmpleado = new javax.swing.JLabel();
        cmbEstadoCivilEmpleado = new javax.swing.JComboBox();
        lblFechaIngEmpleado = new javax.swing.JLabel();
        lblCargoEmpleado = new javax.swing.JLabel();
        txtCargoEmpleado = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        lblDireccionEmpleado = new javax.swing.JLabel();
        txtDireccionEmpleado = new javax.swing.JTextField();
        lblProvinciaEmpleado = new javax.swing.JLabel();
        lblLocalidadEmpleado = new javax.swing.JLabel();
        txtProvinciaEmpleado = new javax.swing.JTextField();
        txtLocalidadEmpleado = new javax.swing.JTextField();
        btnNuevoEmpleado = new javax.swing.JButton();
        btnEditarEmpleado = new javax.swing.JButton();
        btnGuardarEmpleado = new javax.swing.JButton();
        btnEliminarEmpleado = new javax.swing.JButton();
        btnCancelarEmpleado = new javax.swing.JButton();
        txtTelEmpleado = new javax.swing.JTextField();
        lblTelEmpleado = new javax.swing.JLabel();
        txtFechaNacEmpleado = new javax.swing.JTextField();
        txtFechaIngEmpleado = new javax.swing.JTextField();
        btnGuardarEditEmpleado = new javax.swing.JButton();
        jPanel23 = new javax.swing.JPanel();
        txtBuscarEmpleado = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        ListEmpleados = new javax.swing.JList();
        btnBuscarEmpleado = new javax.swing.JButton();
        jPanelArticulo = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblCodBarraArticulo = new javax.swing.JLabel();
        txtCodBarraArticulo = new javax.swing.JTextField();
        lblNombreArticulo = new javax.swing.JLabel();
        txtNombreArticulo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtDescripcionArticulo = new javax.swing.JTextField();
        lblTipoEnvaseArticulo = new javax.swing.JLabel();
        txtTipoEnvaseArticulo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cmbUnDeMedidaArticulo = new javax.swing.JComboBox();
        txtCantMedidaArticulo = new javax.swing.JTextField();
        lblPrecioCompraArticulo = new javax.swing.JLabel();
        txtPrecioUnitCompraArticulo = new javax.swing.JTextField();
        lblPrecioVentaArticulo = new javax.swing.JLabel();
        txtPrecioUnitMayVentaArticulo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPrecioUnitVentaArticulo = new javax.swing.JTextField();
        btnNuevoArticulo = new javax.swing.JButton();
        btnEditarArticulo = new javax.swing.JButton();
        btnGuardarArticulo = new javax.swing.JButton();
        btnEliminarArticulo = new javax.swing.JButton();
        btnCancelarArticulo = new javax.swing.JButton();
        btnGuardarEditArticulo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ListArticulosDetalles = new javax.swing.JList();
        txtBuscarDescripcionArticulo = new javax.swing.JTextField();
        btnBuscarCodDeBarraArticulo = new javax.swing.JButton();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Administración");

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.MatteBorder(null), "Datos del proveedor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        lblRazonSocialProveedor.setText("Razón social:");

        lblSituacTribProveedor.setText("Situación tributaria:");

        lblCuitProveedor.setText("N° CUIT:");

        cmbSituacTribProveedor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Resp. inscripto", "Consumidor final", "Exento", "Monotributista" }));

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.MatteBorder(null), "Domicilio"));

        lblDireccionProveedor.setText("Dirección:");

        lblProvinciaProveedor.setText("Provincia:");

        lblLocalidadProveedor.setText("Localidad:");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblProvinciaProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProvinciaProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblLocalidadProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLocalidadProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addComponent(lblDireccionProveedor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDireccionProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(240, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDireccionProveedor)
                    .addComponent(txtDireccionProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblLocalidadProveedor)
                        .addComponent(txtLocalidadProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblProvinciaProveedor)
                        .addComponent(txtProvinciaProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblTelProveedor.setText("Telefono:");

        lblTipoProveeduriaProveedor.setText("Tipo de proveeduría:");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(lblCuitProveedor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCuitProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblRazonSocialProveedor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtRazonSocialProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblSituacTribProveedor))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(lblTipoProveeduriaProveedor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTipoProveeduriaProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblTelProveedor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTelProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(cmbSituacTribProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCuitProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCuitProveedor)
                    .addComponent(lblRazonSocialProveedor)
                    .addComponent(txtRazonSocialProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSituacTribProveedor)
                    .addComponent(cmbSituacTribProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTelProveedor)
                        .addComponent(txtTelProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTipoProveeduriaProveedor)
                        .addComponent(txtTipoProveeduriaProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnNuevoProveedor.setText("Nuevo");
        btnNuevoProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoProveedorActionPerformed(evt);
            }
        });

        btnEditarProveedor.setText("Editar");
        btnEditarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarProveedorActionPerformed(evt);
            }
        });

        btnGuardarProveedor.setText("Guardar");
        btnGuardarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarProveedorActionPerformed(evt);
            }
        });

        btnCancelarProveedor.setText("Cancelar");
        btnCancelarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarProveedorActionPerformed(evt);
            }
        });

        btnEliminarProveedor.setText("Eliminar");

        btnGuardarEditProveedor.setText("Guardar Edición");
        btnGuardarEditProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarEditProveedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(btnNuevoProveedor)
                .addGap(18, 18, 18)
                .addComponent(btnGuardarProveedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditarProveedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardarEditProveedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminarProveedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelarProveedor)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 230, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarProveedor)
                    .addComponent(btnNuevoProveedor)
                    .addComponent(btnEditarProveedor)
                    .addComponent(btnCancelarProveedor)
                    .addComponent(btnEliminarProveedor)
                    .addComponent(btnGuardarEditProveedor))
                .addGap(11, 11, 11))
        );

        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnBuscarProveedor.setText("Buscar por CUIT");
        btnBuscarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProveedorActionPerformed(evt);
            }
        });

        ListProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListProveedorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ListProveedor);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(lblBuscarProveedor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarProveedor)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblBuscarProveedor)
                        .addComponent(btnBuscarProveedor)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelProveedoresLayout = new javax.swing.GroupLayout(jPanelProveedores);
        jPanelProveedores.setLayout(jPanelProveedoresLayout);
        jPanelProveedoresLayout.setHorizontalGroup(
            jPanelProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProveedoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelProveedoresLayout.setVerticalGroup(
            jPanelProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProveedoresLayout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        jTabbedPaneAdministracion.addTab("Proveedores", jPanelProveedores);

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ListClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListClientesMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(ListClientes);

        btnBuscarCliente.setText("Buscar por CUIT o DNI");
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(txtBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscarCliente)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.MatteBorder(null), "Datos personales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        lblApellidoCliente.setText("Apellido:");

        lblNombreCliente.setText("Nombre:");

        lblTipoCliente.setText("Tipo cliente:");

        cmbTipoCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Minorista", "Mayorista" }));

        lblCuitCliente.setText("N° DNI/CUIT:");

        lblRazonSocialCliente.setText("Razón Social:");

        lblCondIva.setText("Condición ante el IVA:");

        cmbCondIvaCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Monotributista", "Exento", "Cons. Final", "No Categorizado" }));

        lblTelCliente.setText("Telefono:");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(lblTipoCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbTipoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblCuitCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCuitCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(lblRazonSocialCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtRazonSocialCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(lblApellidoCliente)
                                .addGap(18, 18, 18)
                                .addComponent(txtApellidoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(lblCondIva)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbCondIvaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombreCliente)
                            .addComponent(lblTelCliente))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTelCliente)
                            .addComponent(txtNombreCliente))))
                .addGap(103, 103, 103))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipoCliente)
                    .addComponent(cmbTipoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCuitCliente)
                    .addComponent(txtCuitCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRazonSocialCliente)
                    .addComponent(txtRazonSocialCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellidoCliente)
                    .addComponent(txtApellidoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombreCliente))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCondIva)
                    .addComponent(cmbCondIvaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelCliente)
                    .addComponent(txtTelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.MatteBorder(null), "Domicilio", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        lblDireccionCliente.setText("Direccion:");

        lblProvinciaCliente.setText("Provincia:");

        lblLocalidadCliente.setText("Localidad:");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                        .addComponent(lblDireccionCliente)
                        .addGap(18, 18, 18)
                        .addComponent(txtDireccionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(lblProvinciaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProvinciaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblLocalidadCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLocalidadCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDireccionCliente)
                    .addComponent(txtDireccionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblProvinciaCliente)
                        .addComponent(txtProvinciaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblLocalidadCliente)
                        .addComponent(txtLocalidadCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        btnGuardarCliente.setText("Guardar");
        btnGuardarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarClienteActionPerformed(evt);
            }
        });

        btnNuevoCliente.setText("Nuevo");
        btnNuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoClienteActionPerformed(evt);
            }
        });

        btnEditarCliente.setText("Editar");
        btnEditarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarClienteActionPerformed(evt);
            }
        });

        btnCancelarCliente.setText("Cancelar");
        btnCancelarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarClienteActionPerformed(evt);
            }
        });

        btnEliminarCliente.setText("Eliminar");
        btnEliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarClienteActionPerformed(evt);
            }
        });

        btnGuardarEditCliente.setText("Guardar Edición");
        btnGuardarEditCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarEditClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(btnNuevoCliente)
                        .addGap(5, 5, 5)
                        .addComponent(btnGuardarCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditarCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardarEditCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelarCliente)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarCliente)
                    .addComponent(btnNuevoCliente)
                    .addComponent(btnEditarCliente)
                    .addComponent(btnCancelarCliente)
                    .addComponent(btnEliminarCliente)
                    .addComponent(btnGuardarEditCliente))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelClientesLayout = new javax.swing.GroupLayout(jPanelClientes);
        jPanelClientes.setLayout(jPanelClientesLayout);
        jPanelClientesLayout.setHorizontalGroup(
            jPanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelClientesLayout.setVerticalGroup(
            jPanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        jTabbedPaneAdministracion.addTab("Clientes", jPanelClientes);

        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.MatteBorder(null), "Datos personales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        lblApellidoEmpleado.setText("Apellido:");

        lblNombreEmpleado.setText("Nombre:");

        lblFechaNacEmpleado.setText("Fecha de nacimiento:");

        lblCuilEmpleado.setText("N° CUIL:");

        lblSexoEmpleado.setText("Sexo: ");

        cmbSexoEmpleado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Femenino" }));

        lblEstadoCivilEmpleado.setText("Estado civil: ");

        cmbEstadoCivilEmpleado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Soltero", "Casado", "Viudo", "Divorciado" }));

        lblFechaIngEmpleado.setText("Fecha de ingreso:");

        lblCargoEmpleado.setText("Cargo en la empresa:");

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.MatteBorder(null), "Domicilio", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        lblDireccionEmpleado.setText("Direccion:");

        lblProvinciaEmpleado.setText("Provincia:");

        lblLocalidadEmpleado.setText("Localidad:");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel13Layout.createSequentialGroup()
                        .addComponent(lblDireccionEmpleado)
                        .addGap(18, 18, 18)
                        .addComponent(txtDireccionEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(lblProvinciaEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProvinciaEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblLocalidadEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLocalidadEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDireccionEmpleado)
                    .addComponent(txtDireccionEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblProvinciaEmpleado)
                        .addComponent(txtProvinciaEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblLocalidadEmpleado)
                        .addComponent(txtLocalidadEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        btnNuevoEmpleado.setText("Nuevo");
        btnNuevoEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoEmpleadoActionPerformed(evt);
            }
        });

        btnEditarEmpleado.setText("Editar");
        btnEditarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarEmpleadoActionPerformed(evt);
            }
        });

        btnGuardarEmpleado.setText("Guardar");
        btnGuardarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarEmpleadoActionPerformed(evt);
            }
        });

        btnEliminarEmpleado.setText("Eliminar");

        btnCancelarEmpleado.setText("Cancelar");
        btnCancelarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarEmpleadoActionPerformed(evt);
            }
        });

        lblTelEmpleado.setText("Telefono:");

        btnGuardarEditEmpleado.setText("Guardar Edición");
        btnGuardarEditEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarEditEmpleadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addComponent(lblApellidoEmpleado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtApellidoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblNombreEmpleado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblFechaNacEmpleado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFechaNacEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel21Layout.createSequentialGroup()
                                        .addComponent(lblCargoEmpleado)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCargoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel21Layout.createSequentialGroup()
                                        .addComponent(lblCuilEmpleado)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCuilEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblSexoEmpleado)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cmbSexoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblEstadoCivilEmpleado)
                                    .addComponent(lblTelEmpleado))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel21Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(txtTelEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel21Layout.createSequentialGroup()
                                        .addComponent(cmbEstadoCivilEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblFechaIngEmpleado)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtFechaIngEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 52, Short.MAX_VALUE))
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(btnNuevoEmpleado)
                .addGap(18, 18, 18)
                .addComponent(btnGuardarEmpleado)
                .addGap(18, 18, 18)
                .addComponent(btnEditarEmpleado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardarEditEmpleado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminarEmpleado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelarEmpleado)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellidoEmpleado)
                    .addComponent(txtApellidoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombreEmpleado)
                    .addComponent(txtNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFechaNacEmpleado)
                    .addComponent(txtFechaNacEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSexoEmpleado)
                    .addComponent(cmbSexoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEstadoCivilEmpleado)
                    .addComponent(cmbEstadoCivilEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFechaIngEmpleado)
                    .addComponent(txtCuilEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCuilEmpleado)
                    .addComponent(txtFechaIngEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCargoEmpleado)
                    .addComponent(txtCargoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelEmpleado))
                .addGap(18, 18, 18)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarEmpleado)
                    .addComponent(btnNuevoEmpleado)
                    .addComponent(btnEditarEmpleado)
                    .addComponent(btnCancelarEmpleado)
                    .addComponent(btnEliminarEmpleado)
                    .addComponent(btnGuardarEditEmpleado))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ListEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(ListEmpleados);

        btnBuscarEmpleado.setText("Buscar por CUIL");
        btnBuscarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEmpleadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(txtBuscarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarEmpleado)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarEmpleado))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelEmpleadosLayout = new javax.swing.GroupLayout(jPanelEmpleados);
        jPanelEmpleados.setLayout(jPanelEmpleadosLayout);
        jPanelEmpleadosLayout.setHorizontalGroup(
            jPanelEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEmpleadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelEmpleadosLayout.setVerticalGroup(
            jPanelEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEmpleadosLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        jTabbedPaneAdministracion.addTab("Empleados", jPanelEmpleados);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.MatteBorder(null), "Datos del Artículo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        lblCodBarraArticulo.setText("Código de barra:");

        lblNombreArticulo.setText("Nombre:");

        jLabel1.setText("Descripción:");

        lblTipoEnvaseArticulo.setText("Tipo de envase:");

        jLabel2.setText("Unidad de medida y cantidad:");

        cmbUnDeMedidaArticulo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Kilogramos", "Gramos", "Litros" }));

        lblPrecioCompraArticulo.setText("Precio de compra (unitario en $ARS):");

        txtPrecioUnitCompraArticulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioUnitCompraArticuloKeyTyped(evt);
            }
        });

        lblPrecioVentaArticulo.setText("Precio de venta (unitario en $ARS:)");

        txtPrecioUnitMayVentaArticulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioUnitMayVentaArticuloKeyTyped(evt);
            }
        });

        jLabel3.setText("Precio de venta (unitario MAY en $ARS):");

        txtPrecioUnitVentaArticulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioUnitVentaArticuloKeyTyped(evt);
            }
        });

        btnNuevoArticulo.setText("Nuevo");
        btnNuevoArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoArticuloActionPerformed(evt);
            }
        });

        btnEditarArticulo.setText("Editar");
        btnEditarArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarArticuloActionPerformed(evt);
            }
        });

        btnGuardarArticulo.setText("Guardar");
        btnGuardarArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarArticuloActionPerformed(evt);
            }
        });

        btnEliminarArticulo.setText("Eliminar");
        btnEliminarArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarArticuloActionPerformed(evt);
            }
        });

        btnCancelarArticulo.setText("Cancelar");
        btnCancelarArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarArticuloActionPerformed(evt);
            }
        });

        btnGuardarEditArticulo.setText("Guardar Edición");
        btnGuardarEditArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarEditArticuloActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblCodBarraArticulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodBarraArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(lblNombreArticulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombreArticulo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDescripcionArticulo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblPrecioCompraArticulo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPrecioUnitCompraArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblTipoEnvaseArticulo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTipoEnvaseArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel2)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cmbUnDeMedidaArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtCantMedidaArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtPrecioUnitMayVentaArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblPrecioVentaArticulo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPrecioUnitVentaArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(btnNuevoArticulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardarArticulo)
                .addGap(18, 18, 18)
                .addComponent(btnEditarArticulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardarEditArticulo)
                .addGap(10, 10, 10)
                .addComponent(btnEliminarArticulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelarArticulo)
                .addGap(155, 155, 155))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNombreArticulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNombreArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCodBarraArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCodBarraArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescripcionArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipoEnvaseArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTipoEnvaseArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbUnDeMedidaArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantMedidaArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPrecioCompraArticulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPrecioUnitCompraArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblPrecioVentaArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPrecioUnitVentaArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioUnitMayVentaArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarArticulo)
                    .addComponent(btnNuevoArticulo)
                    .addComponent(btnEditarArticulo)
                    .addComponent(btnCancelarArticulo)
                    .addComponent(btnEliminarArticulo)
                    .addComponent(btnGuardarEditArticulo))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.MatteBorder(null), "Listado de Artículos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        ListArticulosDetalles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListArticulosDetallesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(ListArticulosDetalles);

        btnBuscarCodDeBarraArticulo.setText("Buscar por Cód. de Barras");
        btnBuscarCodDeBarraArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCodDeBarraArticuloActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtBuscarDescripcionArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscarCodDeBarraArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarDescripcionArticulo, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(btnBuscarCodDeBarraArticulo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelArticuloLayout = new javax.swing.GroupLayout(jPanelArticulo);
        jPanelArticulo.setLayout(jPanelArticuloLayout);
        jPanelArticuloLayout.setHorizontalGroup(
            jPanelArticuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelArticuloLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelArticuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelArticuloLayout.setVerticalGroup(
            jPanelArticuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelArticuloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPaneAdministracion.addTab("Articulos", jPanelArticulo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneAdministracion)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPaneAdministracion)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoProveedorActionPerformed
        txtEditableProveedor(true);
        btnNuevoProveedor.setEnabled(false);
        btnGuardarProveedor.setEnabled(true);
        btnCancelarProveedor.setEnabled(true);
        limpiarTxtProveedor();
    }//GEN-LAST:event_btnNuevoProveedorActionPerformed

    private void btnCancelarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarEmpleadoActionPerformed
        txtEditableEmpleado(false);
        limpiarTxtEmpleado();
        btnCancelarEmpleado.setEnabled(false);
        btnGuardarEditEmpleado.setEnabled(false);
        btnNuevoEmpleado.setEnabled(true);
        btnGuardarEmpleado.setEnabled(false);
    }//GEN-LAST:event_btnCancelarEmpleadoActionPerformed
    //CARGAR LISTA EMPLEADOS
    public void CargarListaEmpleados(List listaComun){
        Iterator iter = listaComun.iterator();
        this.modeloEmpleados.clear();
        while(iter.hasNext()){
            this.modeloEmpleados.addElement(iter.next());
        }
    }
    //GUARDAR EMPLEADO
    private void btnGuardarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarEmpleadoActionPerformed
        try{          
            this.unMercadito.getUnaSucursal().AgregarUnEmpleado(this.txtCuilEmpleado.getText(), this.txtApellidoEmpleado.getText(), this.txtNombreEmpleado.getText(), this.txtFechaNacEmpleado.getText(), this.cmbSexoEmpleado.getSelectedItem().toString(), this.cmbEstadoCivilEmpleado.getSelectedItem().toString(), this.txtFechaIngEmpleado.getText(), this.txtCargoEmpleado.getText(), this.txtTelEmpleado.getText(), this.txtDireccionEmpleado.getText(), this.txtProvinciaEmpleado.getText(), this.txtLocalidadEmpleado.getText());
            limpiarTxtEmpleado();
            txtEditableEmpleado(false);
            btnNuevoEmpleado.setEnabled(true);
            btnGuardarEmpleado.setEnabled(false);
            btnCancelarEmpleado.setEnabled(false);
            JOptionPane.showMessageDialog(this, "¡Empleado agregado correctamente!");
            this.CargarListaEmpleados(this.unMercadito.getUnaSucursal().getListaEmpleados());
            this.ListEmpleados.setModel(modeloEmpleados);
	} catch (PreexistingEntityException ex) {
            Logger.getLogger(InternalFrameAdministracion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error con la base de datos, ya existe");
        } catch (Exception ex) {
            Logger.getLogger(InternalFrameAdministracion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error con la base de datos");
        }                
    }//GEN-LAST:event_btnGuardarEmpleadoActionPerformed

    private void btnGuardarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarProveedorActionPerformed
        try{          
            this.unMercadito.getUnaSucursal().AgregarUnProveedor(this.txtCuitProveedor.getText(), this.txtRazonSocialProveedor.getText(), this.cmbSituacTribProveedor.getSelectedItem().toString(), this.txtTipoProveeduriaProveedor.getText(), this.txtTelProveedor.getText(), this.txtDireccionProveedor.getText(), this.txtLocalidadProveedor.getText(), this.txtProvinciaProveedor.getText());
            limpiarTxtProveedor();
            txtEditableProveedor(false);
            btnNuevoProveedor.setEnabled(true);
            btnGuardarProveedor.setEnabled(false);
            btnCancelarProveedor.setEnabled(false);
            JOptionPane.showMessageDialog(this, "¡Proveedor agregado correctamente!");
            this.CargarListaProveedor(this.unMercadito.getUnaSucursal().getListaProveedores());
            this.ListProveedor.setModel(modeloProveedor);
        } catch (PreexistingEntityException ex) {
            Logger.getLogger(InternalFrameAdministracion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error con la base de datos, ya existe");
        } catch (Exception ex) {
            Logger.getLogger(InternalFrameAdministracion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error con la base de datos");
        }   
    }//GEN-LAST:event_btnGuardarProveedorActionPerformed

    private void btnCancelarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarProveedorActionPerformed
        txtEditableProveedor(false);
        limpiarTxtProveedor();
        btnNuevoProveedor.setEnabled(true);
        btnGuardarProveedor.setEnabled(false);
        btnCancelarProveedor.setEnabled(false);
        btnGuardarEditProveedor.setEnabled(false);
    }//GEN-LAST:event_btnCancelarProveedorActionPerformed
    
    public void CargarListaProveedor(List listaComun){
        Iterator iter = listaComun.iterator();
        this.modeloProveedor.clear();
        while(iter.hasNext()){
            this.modeloProveedor.addElement(iter.next());
        }
    }
    
    private void btnEditarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProveedorActionPerformed
        txtEditableProveedor(true);
        btnEditarProveedor.setEnabled(false);
        btnNuevoProveedor.setEnabled(false);
        btnGuardarProveedor.setEnabled(true);
        btnGuardarEditProveedor.setEnabled(true);
        btnCancelarProveedor.setEnabled(true);
    }//GEN-LAST:event_btnEditarProveedorActionPerformed

    private void btnNuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoClienteActionPerformed
        txtEditableCliente(true);
        btnNuevoCliente.setEnabled(false);
        btnGuardarCliente.setEnabled(true);
        btnCancelarCliente.setEnabled(true);
        limpiarTxtCliente();
    }//GEN-LAST:event_btnNuevoClienteActionPerformed

    private void btnGuardarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarClienteActionPerformed
        try{          
        this.unMercadito.getUnaSucursal().AgregarUnCliente(this.txtCuitCliente.getText(), this.txtApellidoCliente.getText(), this.txtNombreCliente.getText(), this.txtRazonSocialCliente.getText(), this.cmbTipoCliente.getSelectedItem().toString(), this.cmbCondIvaCliente.getSelectedItem().toString(), this.txtTelCliente.getText(), this.txtDireccionCliente.getText(), this.txtProvinciaCliente.getText(), this.txtLocalidadCliente.getText());
        limpiarTxtCliente();
        txtEditableCliente(false);
        btnNuevoCliente.setEnabled(true);
        btnGuardarCliente.setEnabled(false);
        btnCancelarCliente.setEnabled(false);
        JOptionPane.showMessageDialog(this, "¡Cliente agregado correctamente!");
        this.CargarListaClientes(this.unMercadito.getUnaSucursal().getListaClientes());
        this.ListClientes.setModel(modeloClientes);
        } catch (PreexistingEntityException ex) {
            Logger.getLogger(InternalFrameAdministracion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error con la base de datos, ya existe");
        } catch (Exception ex) {
            Logger.getLogger(InternalFrameAdministracion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error con la base de datos");
        }    
    }//GEN-LAST:event_btnGuardarClienteActionPerformed

    private void btnEditarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarClienteActionPerformed
        txtEditableCliente(true);
        btnEditarCliente.setEnabled(false);
        btnNuevoCliente.setEnabled(false);
        btnGuardarCliente.setEnabled(false);
        btnGuardarEditCliente.setEnabled(true);
        btnCancelarCliente.setEnabled(true);
    }//GEN-LAST:event_btnEditarClienteActionPerformed

    private void btnEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarClienteActionPerformed

    private void btnCancelarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarClienteActionPerformed
        txtEditableCliente(false);
        limpiarTxtCliente();
        btnNuevoCliente.setEnabled(true);
        btnGuardarCliente.setEnabled(false);
        btnCancelarCliente.setEnabled(false);
        btnGuardarEditCliente.setEnabled(false);
    }//GEN-LAST:event_btnCancelarClienteActionPerformed

    private void btnNuevoEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoEmpleadoActionPerformed
        txtEditableEmpleado(true);
        btnNuevoEmpleado.setEnabled(false);
        btnGuardarEmpleado.setEnabled(true);
        btnCancelarEmpleado.setEnabled(true);
        limpiarTxtEmpleado();
    }//GEN-LAST:event_btnNuevoEmpleadoActionPerformed

    private void btnEditarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarEmpleadoActionPerformed
        txtEditableEmpleado(true);
        btnEditarEmpleado.setEnabled(false);
        btnNuevoEmpleado.setEnabled(false);
        btnGuardarEmpleado.setEnabled(false);
        btnGuardarEditEmpleado.setEnabled(true);
        btnCancelarEmpleado.setEnabled(true);
    }//GEN-LAST:event_btnEditarEmpleadoActionPerformed

    private void btnNuevoArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoArticuloActionPerformed
        txtEditableArticulo(true);
        btnNuevoArticulo.setEnabled(false);
        btnGuardarArticulo.setEnabled(true);
        btnCancelarArticulo.setEnabled(true);
        limpiarTxtArticulo();
    }//GEN-LAST:event_btnNuevoArticuloActionPerformed

    private void btnEditarArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarArticuloActionPerformed
        txtEditableArticulo(true);
        btnEditarArticulo.setEnabled(false);
        btnNuevoArticulo.setEnabled(false);
        btnGuardarArticulo.setEnabled(false);
        btnGuardarEditArticulo.setEnabled(true);
        btnCancelarArticulo.setEnabled(true);
    }//GEN-LAST:event_btnEditarArticuloActionPerformed

    private void btnGuardarArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarArticuloActionPerformed
        try{ 
        this.unMercadito.getUnaSucursal().AgregarUnaDescripcionArticulo(this.txtCodBarraArticulo.getText(), this.txtNombreArticulo.getText(), this.txtDescripcionArticulo.getText(), this.txtTipoEnvaseArticulo.getText(), this.cmbUnDeMedidaArticulo.getSelectedItem().toString(), Float.parseFloat(this.txtCantMedidaArticulo.getText().toString()), Float.parseFloat(this.txtPrecioUnitCompraArticulo.getText().toString()),Float.parseFloat(this.txtPrecioUnitVentaArticulo.getText().toString()), Float.parseFloat(this.txtPrecioUnitMayVentaArticulo.getText().toString()));
        limpiarTxtArticulo();
        txtEditableArticulo(false);
        btnNuevoArticulo.setEnabled(true);
        btnGuardarArticulo.setEnabled(false);
        btnCancelarArticulo.setEnabled(false);
        JOptionPane.showMessageDialog(this, "¡Articulo agregado correctamente!");
        this.CargarListaArticulos(this.unMercadito.getUnaSucursal().getListaDescripcionArticulo());
        this.ListArticulosDetalles.setModel(modeloArticulo);
        } catch (PreexistingEntityException ex) {
            Logger.getLogger(InternalFrameAdministracion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error con la base de datos, el código de barras ingresado ya existe");
        } catch (Exception ex) {
            Logger.getLogger(InternalFrameAdministracion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error con la base de datos");
        } 
    }//GEN-LAST:event_btnGuardarArticuloActionPerformed

    private void btnEliminarArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarArticuloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarArticuloActionPerformed

    private void btnCancelarArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarArticuloActionPerformed
        txtEditableArticulo(false);
        limpiarTxtArticulo();
        btnCancelarArticulo.setEnabled(false);
        btnGuardarEditArticulo.setEnabled(false);
        btnNuevoArticulo.setEnabled(true);
        btnGuardarArticulo.setEnabled(false);
    }//GEN-LAST:event_btnCancelarArticuloActionPerformed
    
    public void CargarListaArticulos(List listaComun){
        Iterator iter = listaComun.iterator();
        this.modeloArticulo.clear();
        while(iter.hasNext()){
            this.modeloArticulo.addElement(iter.next());
        }
    }
    
    private void btnBuscarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEmpleadoActionPerformed
        try{
            Empleado unEmpleado;
            unEmpleado=unMercadito.getUnaSucursal().BuscarEmpleado(this.txtBuscarEmpleado.getText());
            this.txtApellidoEmpleado.setText(unEmpleado.getApellido());
            this.txtNombreEmpleado.setText(unEmpleado.getNombre());
            this.txtFechaNacEmpleado.setText(unEmpleado.getFechaNac());
            this.txtCuilEmpleado.setText(unEmpleado.getIdPersona());
            this.cmbSexoEmpleado.setSelectedItem(unEmpleado.getSexo());
            this.cmbEstadoCivilEmpleado.setSelectedItem(unEmpleado.getEstadoCivil());
            this.txtFechaIngEmpleado.setText(unEmpleado.getFechaIngreso());
            this.txtCargoEmpleado.setText(unEmpleado.getCargo());
            this.txtTelEmpleado.setText(unEmpleado.getTelefono());
            this.txtDireccionEmpleado.setText(unEmpleado.getDireccion());
            this.txtProvinciaEmpleado.setText(unEmpleado.getProvincia());
            this.txtLocalidadEmpleado.setText(unEmpleado.getLocalidad());
            btnEditarEmpleado.setEnabled(true);
        }catch (Exception ex){
                 Logger.getLogger(InternalFrameAdministracion.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(this, "Cuil Inexistente");
        }    
    }//GEN-LAST:event_btnBuscarEmpleadoActionPerformed

    private void ListEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListEmpleadosMouseClicked
        Empleado unEmpleado = (Empleado) this.modeloEmpleados.getElementAt(this.ListEmpleados.getSelectedIndex());
        this.txtApellidoEmpleado.setText(unEmpleado.getApellido());
        this.txtNombreEmpleado.setText(unEmpleado.getNombre());
        this.txtFechaNacEmpleado.setText(unEmpleado.getFechaNac());
        this.txtCuilEmpleado.setText(unEmpleado.getIdPersona());
        this.cmbSexoEmpleado.setSelectedItem(unEmpleado.getSexo());
        this.cmbEstadoCivilEmpleado.setSelectedItem(unEmpleado.getEstadoCivil());
        this.txtFechaIngEmpleado.setText(unEmpleado.getFechaIngreso());
        this.txtCargoEmpleado.setText(unEmpleado.getCargo());
        this.txtTelEmpleado.setText(unEmpleado.getTelefono());
        this.txtDireccionEmpleado.setText(unEmpleado.getDireccion());
        this.txtProvinciaEmpleado.setText(unEmpleado.getProvincia());
        this.txtLocalidadEmpleado.setText(unEmpleado.getLocalidad());
        btnEditarEmpleado.setEnabled(true);
    }//GEN-LAST:event_ListEmpleadosMouseClicked

    private void btnGuardarEditEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarEditEmpleadoActionPerformed
       int confirmar;
        confirmar=JOptionPane.showConfirmDialog(this, "Esta accion modificara los datos de la Persona seleccionada ¿Desea continuar?", "Modificar",  JOptionPane.YES_NO_OPTION);
        if(confirmar==JOptionPane.YES_OPTION){
             try {
                Empleado unEmpleado = this.unMercadito.getUnaSucursal().BuscarEmpleado(this.txtCuilEmpleado.getText());
                this.unMercadito.getUnaSucursal().ModificarUnEmpleado(unEmpleado, this.txtCuilEmpleado.getText(), this.txtApellidoEmpleado.getText(), this.txtNombreEmpleado.getText(), this.txtFechaNacEmpleado.getText(), this.cmbSexoEmpleado.getSelectedItem().toString(), this.cmbEstadoCivilEmpleado.getSelectedItem().toString(), this.txtFechaIngEmpleado.getText(), this.txtCargoEmpleado.getText(), this.txtTelEmpleado.getText(), this.txtDireccionEmpleado.getText(), this.txtProvinciaEmpleado.getText(), this.txtLocalidadEmpleado.getText());
                JOptionPane.showMessageDialog(this, "Se modificaron correctamente los datos");
                btnNuevoEmpleado.setEnabled(true);
                btnGuardarEditEmpleado.setEnabled(false);
                btnCancelarEmpleado.setEnabled(false);
                txtEditableEmpleado(false);
             } catch (NonexistentEntityException ex) {
                 Logger.getLogger(InternalFrameAdministracion.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(this, "Error con la base de datos, no existe");
             } catch (Exception ex) {
                 Logger.getLogger(InternalFrameAdministracion.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(this, "Error con la base de datos");
             }
        }else{
            btnNuevoEmpleado.setEnabled(true);
            btnGuardarEditEmpleado.setEnabled(false);
            btnCancelarEmpleado.setEnabled(false);
            txtEditableEmpleado(false);
        }
    }//GEN-LAST:event_btnGuardarEditEmpleadoActionPerformed

    private void btnGuardarEditClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarEditClienteActionPerformed
        int confirmar;
        confirmar=JOptionPane.showConfirmDialog(this, "Esta accion modificara los datos de la Persona seleccionada ¿Desea continuar?", "Modificar",  JOptionPane.YES_NO_OPTION);
        if(confirmar==JOptionPane.YES_OPTION){
             try {
                Cliente unCliente = this.unMercadito.getUnaSucursal().BuscarCliente(this.txtCuitCliente.getText());
                this.unMercadito.getUnaSucursal().ModificarUnCliente(unCliente, this.txtCuitCliente.getText(), this.txtApellidoCliente.getText(), this.txtNombreCliente.getText(), this.txtRazonSocialCliente.getText(), this.cmbTipoCliente.getSelectedItem().toString(), this.cmbCondIvaCliente.getSelectedItem().toString(), this.txtTelCliente.getText(), this.txtDireccionCliente.getText(), this.txtProvinciaCliente.getText(), this.txtLocalidadCliente.getText());
                JOptionPane.showMessageDialog(this, "Se modificaron correctamente los datos");
                btnNuevoCliente.setEnabled(true);
                btnGuardarEditCliente.setEnabled(false);
                btnCancelarCliente.setEnabled(false);
                txtEditableCliente(false);
             } catch (NonexistentEntityException ex) {
                 Logger.getLogger(InternalFrameAdministracion.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(this, "Error con la base de datos, no existe");
             } catch (Exception ex) {
                 Logger.getLogger(InternalFrameAdministracion.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(this, "Error con la base de datos");
             }
        }else{
            btnNuevoCliente.setEnabled(true);
            btnGuardarEditCliente.setEnabled(false);
            btnCancelarCliente.setEnabled(false);
            txtEditableCliente(false);
        }
    }//GEN-LAST:event_btnGuardarEditClienteActionPerformed

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        try{
        Cliente unCliente;
        unCliente=unMercadito.getUnaSucursal().BuscarCliente(this.txtBuscarCliente.getText());
        this.txtApellidoCliente.setText(unCliente.getApellido());
        this.txtNombreCliente.setText(unCliente.getNombre());
        this.txtCuitCliente.setText(unCliente.getIdPersona());
        this.txtRazonSocialCliente.setText(unCliente.getRazonSocial());
        this.cmbTipoCliente.setSelectedItem(unCliente.getTipoCliente());
        this.cmbCondIvaCliente.setSelectedItem(unCliente.getIvaCondicion());
        this.txtTelCliente.setText(unCliente.getTelefono());
        this.txtDireccionCliente.setText(unCliente.getDireccion());
        this.txtProvinciaCliente.setText(unCliente.getProvincia());
        this.txtLocalidadCliente.setText(unCliente.getLocalidad());    
        btnEditarCliente.setEnabled(true);
        }catch (Exception ex){
                 Logger.getLogger(InternalFrameAdministracion.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(this, "CUIT Inexistente");
        }   
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void ListClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListClientesMouseClicked
        Cliente unCliente = (Cliente) this.modeloClientes.getElementAt(this.ListClientes.getSelectedIndex());
        this.txtApellidoCliente.setText(unCliente.getApellido());
        this.txtNombreCliente.setText(unCliente.getNombre());
        this.txtCuitCliente.setText(unCliente.getIdPersona());
        this.txtRazonSocialCliente.setText(unCliente.getRazonSocial());
        this.cmbTipoCliente.setSelectedItem(unCliente.getTipoCliente());
        this.cmbCondIvaCliente.setSelectedItem(unCliente.getIvaCondicion());
        this.txtTelCliente.setText(unCliente.getTelefono());
        this.txtDireccionCliente.setText(unCliente.getDireccion());
        this.txtProvinciaCliente.setText(unCliente.getProvincia());
        this.txtLocalidadCliente.setText(unCliente.getLocalidad());
        btnEditarCliente.setEnabled(true);
    }//GEN-LAST:event_ListClientesMouseClicked

    private void btnBuscarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProveedorActionPerformed
        try{
            Proveedor unProveedor;
            unProveedor=unMercadito.getUnaSucursal().BuscarProveedor(this.txtBuscarProveedor.getText());
            this.txtCuitProveedor.setText(unProveedor.getIdPersona());
            this.txtRazonSocialProveedor.setText(unProveedor.getRazonSocial());
            this.cmbSituacTribProveedor.setSelectedItem(unProveedor.getSituacionTributaria());
            this.txtTipoProveeduriaProveedor.setText(unProveedor.getTipoProveduria());
            this.txtTelProveedor.setText(unProveedor.getTelefono());
            this.txtDireccionProveedor.setText(unProveedor.getDireccion());
            this.txtProvinciaProveedor.setText(unProveedor.getProvincia());
            this.txtLocalidadProveedor.setText(unProveedor.getLocalidad());
            btnEditarProveedor.setEnabled(true);
        }catch (Exception ex){
                 Logger.getLogger(InternalFrameAdministracion.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(this, "¡CUIT Inexistente!");
        }   
    }//GEN-LAST:event_btnBuscarProveedorActionPerformed

    private void ListProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListProveedorMouseClicked
        Proveedor unProveedor = (Proveedor) this.modeloProveedor.getElementAt(this.ListProveedor.getSelectedIndex());
        this.txtCuitProveedor.setText(unProveedor.getIdPersona());
        this.txtRazonSocialProveedor.setText(unProveedor.getRazonSocial());
        this.cmbSituacTribProveedor.setSelectedItem(unProveedor.getSituacionTributaria());
        this.txtTipoProveeduriaProveedor.setText(unProveedor.getTipoProveduria());
        this.txtTelProveedor.setText(unProveedor.getTelefono());
        this.txtDireccionProveedor.setText(unProveedor.getDireccion());
        this.txtProvinciaProveedor.setText(unProveedor.getProvincia());
        this.txtLocalidadProveedor.setText(unProveedor.getLocalidad());
        btnEditarProveedor.setEnabled(true);
    }//GEN-LAST:event_ListProveedorMouseClicked

    private void btnGuardarEditProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarEditProveedorActionPerformed
        int confirmar;
        confirmar=JOptionPane.showConfirmDialog(this, "Esta accion modificara los datos de la Persona seleccionada ¿Desea continuar?", "Modificar",  JOptionPane.YES_NO_OPTION);
        if(confirmar==JOptionPane.YES_OPTION){
             try {
                Proveedor unProveedor = this.unMercadito.getUnaSucursal().BuscarProveedor(this.txtCuitProveedor.getText());
                this.unMercadito.getUnaSucursal().ModificarUnProveedor(unProveedor, this.txtCuitProveedor.getText(), this.txtRazonSocialProveedor.getText(), this.cmbSituacTribProveedor.getSelectedItem().toString(), this.txtTipoProveeduriaProveedor.getText(), this.txtTelProveedor.getText(), this.txtDireccionProveedor.getText(), this.txtLocalidadProveedor.getText(), this.txtProvinciaProveedor.getText());
                JOptionPane.showMessageDialog(this, "Se modificaron correctamente los datos");
                btnNuevoProveedor.setEnabled(true);
                btnGuardarEditProveedor.setEnabled(false);
                btnCancelarProveedor.setEnabled(false);
                txtEditableProveedor(false);
             } catch (NonexistentEntityException ex) {
                 Logger.getLogger(InternalFrameAdministracion.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(this, "Error con la base de datos, no existe");
             } catch (Exception ex) {
                 Logger.getLogger(InternalFrameAdministracion.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(this, "Error con la base de datos");
             }
        }else{
            btnNuevoProveedor.setEnabled(true);
            btnGuardarEditProveedor.setEnabled(false);
            btnCancelarProveedor.setEnabled(false);
            txtEditableProveedor(false);
        }
    }//GEN-LAST:event_btnGuardarEditProveedorActionPerformed

    private void btnBuscarCodDeBarraArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCodDeBarraArticuloActionPerformed
        try{
        DescripcionArticulo unaDescripcionArticulo;
        unaDescripcionArticulo=unMercadito.getUnaSucursal().BuscarDescripcionArticulo(this.txtBuscarDescripcionArticulo.getText());
        this.txtCodBarraArticulo.setText(unaDescripcionArticulo.getCodigoBarra());
        this.txtNombreArticulo.setText(unaDescripcionArticulo.getNombreArticulo());
        this.txtDescripcionArticulo.setText(unaDescripcionArticulo.getDescripcion());
        this.txtTipoEnvaseArticulo.setText(unaDescripcionArticulo.getTipoEnvase());
        this.cmbUnDeMedidaArticulo.setSelectedItem(unaDescripcionArticulo.getUnidadMedida());        
        this.txtCantMedidaArticulo.setText(String.valueOf(unaDescripcionArticulo.getCantidadUnidadMedida()));
        this.txtPrecioUnitCompraArticulo.setText(String.valueOf(unaDescripcionArticulo.getPrecioCompra()));
        this.txtPrecioUnitVentaArticulo.setText(String.valueOf(unaDescripcionArticulo.getPrecioVenta()));
        this.txtPrecioUnitMayVentaArticulo.setText(String.valueOf(unaDescripcionArticulo.getPrecioVentaMay()));
        btnEditarArticulo.setEnabled(true);
        }catch (Exception ex){
                 Logger.getLogger(InternalFrameAdministracion.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(this, "¡Codigo de Barras Inexistente!");
        }    
    }//GEN-LAST:event_btnBuscarCodDeBarraArticuloActionPerformed

    private void ListArticulosDetallesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListArticulosDetallesMouseClicked
        DescripcionArticulo unaDescripcionArticulo = (DescripcionArticulo) this.modeloArticulo.getElementAt(this.ListArticulosDetalles.getSelectedIndex());
        this.txtCodBarraArticulo.setText(unaDescripcionArticulo.getCodigoBarra());
        this.txtNombreArticulo.setText(unaDescripcionArticulo.getNombreArticulo());
        this.txtDescripcionArticulo.setText(unaDescripcionArticulo.getDescripcion());
        this.txtTipoEnvaseArticulo.setText(unaDescripcionArticulo.getTipoEnvase());
        this.cmbUnDeMedidaArticulo.setSelectedItem(unaDescripcionArticulo.getUnidadMedida());        
        this.txtCantMedidaArticulo.setText(String.valueOf(unaDescripcionArticulo.getCantidadUnidadMedida()));
        this.txtPrecioUnitCompraArticulo.setText(String.valueOf(unaDescripcionArticulo.getPrecioCompra()));
        this.txtPrecioUnitVentaArticulo.setText(String.valueOf(unaDescripcionArticulo.getPrecioVenta()));
        this.txtPrecioUnitMayVentaArticulo.setText(String.valueOf(unaDescripcionArticulo.getPrecioVentaMay()));
        btnEditarArticulo.setEnabled(true);
    }//GEN-LAST:event_ListArticulosDetallesMouseClicked

    private void btnGuardarEditArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarEditArticuloActionPerformed
        int confirmar;
        confirmar=JOptionPane.showConfirmDialog(this, "Esta accion modificara los datos del Articulo seleccionado ¿Desea continuar?", "Modificar",  JOptionPane.YES_NO_OPTION);
        if(confirmar==JOptionPane.YES_OPTION){
             try {
                DescripcionArticulo unaDescripcionArticulo = this.unMercadito.getUnaSucursal().BuscarDescripcionArticulo(this.txtCodBarraArticulo.getText());
                this.unMercadito.getUnaSucursal().ModificarUnaDescripcionArticulo(unaDescripcionArticulo, this.txtCodBarraArticulo.getText(), this.txtNombreArticulo.getText(), this.txtDescripcionArticulo.getText(), this.txtTipoEnvaseArticulo.getText(), this.cmbUnDeMedidaArticulo.getSelectedItem().toString(), Float.parseFloat(this.txtCantMedidaArticulo.getText()), Float.parseFloat(this.txtPrecioUnitCompraArticulo.getText()),Float.parseFloat(this.txtPrecioUnitVentaArticulo.getText()), Float.parseFloat(this.txtPrecioUnitMayVentaArticulo.getText()));
                JOptionPane.showMessageDialog(this, "Se modificaron correctamente los datos");
                btnNuevoArticulo.setEnabled(true);
                btnGuardarEditArticulo.setEnabled(false);
                btnCancelarArticulo.setEnabled(false);
                txtEditableArticulo(false);
             } catch (NonexistentEntityException ex) {
                 Logger.getLogger(InternalFrameAdministracion.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(this, "Error con la base de datos, no existe");
             } catch (Exception ex) {
                 Logger.getLogger(InternalFrameAdministracion.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(this, "Error con la base de datos");
             }
        }else{
            btnNuevoArticulo.setEnabled(true);
            btnGuardarEditArticulo.setEnabled(false);
            btnCancelarArticulo.setEnabled(false);
            txtEditableArticulo(false);
        }
    }//GEN-LAST:event_btnGuardarEditArticuloActionPerformed

    private void txtPrecioUnitCompraArticuloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioUnitCompraArticuloKeyTyped
        char c=evt.getKeyChar();          
        if(Character.isLetter(c)) { 
            getToolkit().beep();     
            evt.consume();
            JOptionPane.showMessageDialog(this, "Este campo solo permite numeros.");
          } 
    }//GEN-LAST:event_txtPrecioUnitCompraArticuloKeyTyped

    private void txtPrecioUnitVentaArticuloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioUnitVentaArticuloKeyTyped
        char c=evt.getKeyChar();          
        if(Character.isLetter(c)) { 
            getToolkit().beep();     
            evt.consume();
            JOptionPane.showMessageDialog(this, "Este campo solo permite numeros.");
        }
    }//GEN-LAST:event_txtPrecioUnitVentaArticuloKeyTyped

    private void txtPrecioUnitMayVentaArticuloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioUnitMayVentaArticuloKeyTyped
        char c=evt.getKeyChar();          
        if(Character.isLetter(c)) { 
            getToolkit().beep();     
            evt.consume();
            JOptionPane.showMessageDialog(this, "Este campo solo permite numeros.");
        }
    }//GEN-LAST:event_txtPrecioUnitMayVentaArticuloKeyTyped

    public void CargarListaClientes(List listaComun){
    Iterator iter = listaComun.iterator();
    this.modeloClientes.clear();
    while(iter.hasNext()){
        this.modeloClientes.addElement(iter.next());
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList ListArticulosDetalles;
    private javax.swing.JList ListClientes;
    private javax.swing.JList ListEmpleados;
    private javax.swing.JList ListProveedor;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnBuscarCodDeBarraArticulo;
    private javax.swing.JButton btnBuscarEmpleado;
    private javax.swing.JButton btnBuscarProveedor;
    private javax.swing.JButton btnCancelarArticulo;
    private javax.swing.JButton btnCancelarCliente;
    private javax.swing.JButton btnCancelarEmpleado;
    private javax.swing.JButton btnCancelarProveedor;
    private javax.swing.JButton btnEditarArticulo;
    private javax.swing.JButton btnEditarCliente;
    private javax.swing.JButton btnEditarEmpleado;
    private javax.swing.JButton btnEditarProveedor;
    private javax.swing.JButton btnEliminarArticulo;
    private javax.swing.JButton btnEliminarCliente;
    private javax.swing.JButton btnEliminarEmpleado;
    private javax.swing.JButton btnEliminarProveedor;
    private javax.swing.JButton btnGuardarArticulo;
    private javax.swing.JButton btnGuardarCliente;
    private javax.swing.JButton btnGuardarEditArticulo;
    private javax.swing.JButton btnGuardarEditCliente;
    private javax.swing.JButton btnGuardarEditEmpleado;
    private javax.swing.JButton btnGuardarEditProveedor;
    private javax.swing.JButton btnGuardarEmpleado;
    private javax.swing.JButton btnGuardarProveedor;
    private javax.swing.JButton btnNuevoArticulo;
    private javax.swing.JButton btnNuevoCliente;
    private javax.swing.JButton btnNuevoEmpleado;
    private javax.swing.JButton btnNuevoProveedor;
    private javax.swing.JComboBox cmbCondIvaCliente;
    private javax.swing.JComboBox cmbEstadoCivilEmpleado;
    private javax.swing.JComboBox cmbSexoEmpleado;
    private javax.swing.JComboBox cmbSituacTribProveedor;
    private javax.swing.JComboBox cmbTipoCliente;
    private javax.swing.JComboBox cmbUnDeMedidaArticulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelArticulo;
    private javax.swing.JPanel jPanelClientes;
    private javax.swing.JPanel jPanelEmpleados;
    private javax.swing.JPanel jPanelProveedores;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPaneAdministracion;
    private javax.swing.JLabel lblApellidoCliente;
    private javax.swing.JLabel lblApellidoEmpleado;
    private javax.swing.JLabel lblBuscarProveedor;
    private javax.swing.JLabel lblCargoEmpleado;
    private javax.swing.JLabel lblCodBarraArticulo;
    private javax.swing.JLabel lblCondIva;
    private javax.swing.JLabel lblCuilEmpleado;
    private javax.swing.JLabel lblCuitCliente;
    private javax.swing.JLabel lblCuitProveedor;
    private javax.swing.JLabel lblDireccionCliente;
    private javax.swing.JLabel lblDireccionEmpleado;
    private javax.swing.JLabel lblDireccionProveedor;
    private javax.swing.JLabel lblEstadoCivilEmpleado;
    private javax.swing.JLabel lblFechaIngEmpleado;
    private javax.swing.JLabel lblFechaNacEmpleado;
    private javax.swing.JLabel lblLocalidadCliente;
    private javax.swing.JLabel lblLocalidadEmpleado;
    private javax.swing.JLabel lblLocalidadProveedor;
    private javax.swing.JLabel lblNombreArticulo;
    private javax.swing.JLabel lblNombreCliente;
    private javax.swing.JLabel lblNombreEmpleado;
    private javax.swing.JLabel lblPrecioCompraArticulo;
    private javax.swing.JLabel lblPrecioVentaArticulo;
    private javax.swing.JLabel lblProvinciaCliente;
    private javax.swing.JLabel lblProvinciaEmpleado;
    private javax.swing.JLabel lblProvinciaProveedor;
    private javax.swing.JLabel lblRazonSocialCliente;
    private javax.swing.JLabel lblRazonSocialProveedor;
    private javax.swing.JLabel lblSexoEmpleado;
    private javax.swing.JLabel lblSituacTribProveedor;
    private javax.swing.JLabel lblTelCliente;
    private javax.swing.JLabel lblTelEmpleado;
    private javax.swing.JLabel lblTelProveedor;
    private javax.swing.JLabel lblTipoCliente;
    private javax.swing.JLabel lblTipoEnvaseArticulo;
    private javax.swing.JLabel lblTipoProveeduriaProveedor;
    private javax.swing.JTextField txtApellidoCliente;
    private javax.swing.JTextField txtApellidoEmpleado;
    private javax.swing.JTextField txtBuscarCliente;
    private javax.swing.JTextField txtBuscarDescripcionArticulo;
    private javax.swing.JTextField txtBuscarEmpleado;
    private javax.swing.JTextField txtBuscarProveedor;
    private javax.swing.JTextField txtCantMedidaArticulo;
    private javax.swing.JTextField txtCargoEmpleado;
    private javax.swing.JTextField txtCodBarraArticulo;
    private javax.swing.JTextField txtCuilEmpleado;
    private javax.swing.JTextField txtCuitCliente;
    private javax.swing.JTextField txtCuitProveedor;
    private javax.swing.JTextField txtDescripcionArticulo;
    private javax.swing.JTextField txtDireccionCliente;
    private javax.swing.JTextField txtDireccionEmpleado;
    private javax.swing.JTextField txtDireccionProveedor;
    private javax.swing.JTextField txtFechaIngEmpleado;
    private javax.swing.JTextField txtFechaNacEmpleado;
    private javax.swing.JTextField txtLocalidadCliente;
    private javax.swing.JTextField txtLocalidadEmpleado;
    private javax.swing.JTextField txtLocalidadProveedor;
    private javax.swing.JTextField txtNombreArticulo;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtNombreEmpleado;
    private javax.swing.JTextField txtPrecioUnitCompraArticulo;
    private javax.swing.JTextField txtPrecioUnitMayVentaArticulo;
    private javax.swing.JTextField txtPrecioUnitVentaArticulo;
    private javax.swing.JTextField txtProvinciaCliente;
    private javax.swing.JTextField txtProvinciaEmpleado;
    private javax.swing.JTextField txtProvinciaProveedor;
    private javax.swing.JTextField txtRazonSocialCliente;
    private javax.swing.JTextField txtRazonSocialProveedor;
    private javax.swing.JTextField txtTelCliente;
    private javax.swing.JTextField txtTelEmpleado;
    private javax.swing.JTextField txtTelProveedor;
    private javax.swing.JTextField txtTipoEnvaseArticulo;
    private javax.swing.JTextField txtTipoProveeduriaProveedor;
    // End of variables declaration//GEN-END:variables
}