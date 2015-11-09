/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import Persistencia.CajeroJpaController;
import Persistencia.ClienteJpaController;
import Persistencia.EmpleadoJpaController;
import Persistencia.PersonaJpaController;
import Persistencia.ProveedorJpaController;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Cajero;
import model.Cliente;
import model.Empleado;
import model.Persona;
import model.Proveedor;

/**
 *
 * @author Antonio
 */
public class InternalFrameAdministracion extends javax.swing.JInternalFrame {
    //private EntityManagerFactory objFactory;
    ProveedorJpaController jpaProv = new ProveedorJpaController();
    ClienteJpaController jpaCli = new ClienteJpaController();
    EmpleadoJpaController jpaEmp = new EmpleadoJpaController();
    CajeroJpaController jpaCajero = new CajeroJpaController();
    /**
     * Creates new form InternalFrameAdministracion
     */
    
    public InternalFrameAdministracion() {
        initComponents();
        CrearModeloProveedor();
        CrearModeloCliente();
        CrearModeloEmpleado();
        //Formulario PROVEEDOR
        cargarTablaProveedor();
        btnGuardarProveedor.setEnabled(false);
        btnNuevoProveedor.setEnabled(true);
        btnEditarProveedor.setEnabled(false);
        btnEliminarProveedor.setEnabled(false);
        btnCancelarProveedor.setEnabled(false);
        txtEditableProveedor(false);
        //Formulario CLIENTE
        cargarTablaCliente();
        btnGuardarCliente.setEnabled(false);
        btnNuevoCliente.setEnabled(true);
        btnEditarCliente.setEnabled(false);
        btnEliminarCliente.setEnabled(false);
        btnCancelarCliente.setEnabled(false);
        txtEditableCliente(false);
        //Formulario EMPLEADO
        cargarTablaEmpleado();
        btnGuardarEmpleado.setEnabled(false);
        btnNuevoEmpleado.setEnabled(true);
        btnEditarEmpleado.setEnabled(false);
        btnEliminarEmpleado.setEnabled(false);
        btnCancelarEmpleado.setEnabled(false);
        txtEditableEmpleado(false);
    }
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
        txtDireccionCliente.setEditable(bool);
        txtProvinciaCliente.setEditable(bool);
        txtLocalidadCliente.setEditable(bool);
    }
    public void limpiarTxtEmpleado(){
        txtApellidoEmpleado.setText("");
        txtNombreEmpleado.setText("");
        txtFechaNacEmpleado.setText("");
        txtCuilEmpleado.setText("");
        txtFechaIngEmpleado.setText("");
        txtCargoEmpleado.setText("");
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
        jPanel17 = new javax.swing.JPanel();
        lblBuscarProveedor = new javax.swing.JLabel();
        txtBuscarProveedor = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblProveedor = new javax.swing.JTable();
        jPanelClientes = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        lblBuscarCliente = new javax.swing.JLabel();
        txtBuscarCliente = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCliente = new javax.swing.JTable();
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
        jPanelEmpleados = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        lblApellidoEmpleado = new javax.swing.JLabel();
        txtApellidoEmpleado = new javax.swing.JTextField();
        lblNombreEmpleado = new javax.swing.JLabel();
        txtNombreEmpleado = new javax.swing.JTextField();
        lblFechaNacEmpleado = new javax.swing.JLabel();
        txtFechaNacEmpleado = new javax.swing.JFormattedTextField();
        lblCuilEmpleado = new javax.swing.JLabel();
        txtCuilEmpleado = new javax.swing.JTextField();
        lblSexoEmpleado = new javax.swing.JLabel();
        cmbSexoEmpleado = new javax.swing.JComboBox();
        lblEstadoCivilEmpleado = new javax.swing.JLabel();
        cmbEstadoCivilEmpleado = new javax.swing.JComboBox();
        lblFechaIngEmpleado = new javax.swing.JLabel();
        txtFechaIngEmpleado = new javax.swing.JFormattedTextField();
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
        jPanel23 = new javax.swing.JPanel();
        lblBuscarEmpleado = new javax.swing.JLabel();
        txtBuscarEmpleado = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblEmpleado = new javax.swing.JTable();
        jPanelArticulo = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNroArt = new javax.swing.JTextField();
        txtLoteArt = new javax.swing.JTextField();
        txtFechaExpiraArt = new javax.swing.JTextField();
        txtFechaElaboraArt = new javax.swing.JTextField();
        btnGuardarArt = new javax.swing.JButton();

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
                .addContainerGap(209, Short.MAX_VALUE))
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

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addComponent(btnNuevoProveedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditarProveedor)
                .addGap(8, 8, 8)
                .addComponent(btnGuardarProveedor)
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
                    .addComponent(btnEliminarProveedor))
                .addGap(11, 11, 11))
        );

        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblBuscarProveedor.setText("Buscar:");

        txtBuscarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarProveedorActionPerformed(evt);
            }
        });

        tblProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tblProveedor);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(lblBuscarProveedor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBuscarProveedor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
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
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jTabbedPaneAdministracion.addTab("Proveedores", jPanelProveedores);

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblBuscarCliente.setText("Buscar:");

        txtBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarClienteActionPerformed(evt);
            }
        });

        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblCliente);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(lblBuscarCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBuscarCliente)
                    .addComponent(txtBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
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
                        .addComponent(txtRazonSocialCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
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

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(btnNuevoCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditarCliente)
                        .addGap(8, 8, 8)
                        .addComponent(btnGuardarCliente)
                        .addGap(10, 10, 10)
                        .addComponent(btnEliminarCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelarCliente)
                        .addGap(0, 121, Short.MAX_VALUE))
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
                    .addComponent(btnEliminarCliente))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        jTabbedPaneAdministracion.addTab("Clientes", jPanelClientes);

        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.MatteBorder(null), "Datos personales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        lblApellidoEmpleado.setText("Apellido:");

        lblNombreEmpleado.setText("Nombre:");

        lblFechaNacEmpleado.setText("Fecha de nacimiento:");

        txtFechaNacEmpleado.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        lblCuilEmpleado.setText("N° CUIL:");

        lblSexoEmpleado.setText("Sexo: ");

        cmbSexoEmpleado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Femenino" }));

        lblEstadoCivilEmpleado.setText("Estado civil: ");

        cmbEstadoCivilEmpleado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Soltero", "Casado", "Viudo", "Divorciado" }));

        lblFechaIngEmpleado.setText("Fecha de ingreso:");

        txtFechaIngEmpleado.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFechaNacEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                .addComponent(lblEstadoCivilEmpleado)
                                .addGap(18, 18, 18)
                                .addComponent(cmbEstadoCivilEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblFechaIngEmpleado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFechaIngEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(btnNuevoEmpleado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEditarEmpleado)
                .addGap(8, 8, 8)
                .addComponent(btnGuardarEmpleado)
                .addGap(10, 10, 10)
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
                    .addComponent(txtFechaIngEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCuilEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCuilEmpleado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCargoEmpleado)
                    .addComponent(txtCargoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarEmpleado)
                    .addComponent(btnNuevoEmpleado)
                    .addComponent(btnEditarEmpleado)
                    .addComponent(btnCancelarEmpleado)
                    .addComponent(btnEliminarEmpleado))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblBuscarEmpleado.setText("Buscar:");

        txtBuscarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarEmpleadoActionPerformed(evt);
            }
        });

        tblEmpleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(tblEmpleado);

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(lblBuscarEmpleado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBuscarEmpleado)
                    .addComponent(txtBuscarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
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
                .addContainerGap(64, Short.MAX_VALUE))
        );

        jTabbedPaneAdministracion.addTab("Empleados", jPanelEmpleados);

        jLabel1.setText("Nro. Articulo:");

        jLabel2.setText("Lote:");

        jLabel3.setText("Fecha Expira: ");

        jLabel4.setText("Fecha Elabora:");

        btnGuardarArt.setText("Guardar");
        btnGuardarArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarArtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGuardarArt)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtFechaElaboraArt, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtFechaExpiraArt))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(txtLoteArt))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtNroArt))))
                .addContainerGap(469, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNroArt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtLoteArt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtFechaExpiraArt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtFechaElaboraArt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(btnGuardarArt)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelArticuloLayout = new javax.swing.GroupLayout(jPanelArticulo);
        jPanelArticulo.setLayout(jPanelArticuloLayout);
        jPanelArticuloLayout.setHorizontalGroup(
            jPanelArticuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelArticuloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelArticuloLayout.setVerticalGroup(
            jPanelArticuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelArticuloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(359, Short.MAX_VALUE))
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

    private void txtBuscarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarEmpleadoActionPerformed

    private void txtBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarClienteActionPerformed

    private void txtBuscarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarProveedorActionPerformed

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
        btnNuevoEmpleado.setEnabled(true);
        btnGuardarEmpleado.setEnabled(false);
    }//GEN-LAST:event_btnCancelarEmpleadoActionPerformed

    private void btnGuardarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarEmpleadoActionPerformed
        EmpleadoJpaController jpaEmpleado = new EmpleadoJpaController();
        Empleado emp = new Empleado();
        emp.setApellido(txtApellidoEmpleado.getText());
        emp.setNombre(txtNombreEmpleado.getText());
        emp.setFechaIngreso(txtFechaNacEmpleado.getText());
        emp.setIdPersona(txtCuilEmpleado.getText());
        emp.setSexo((String)cmbSexoEmpleado.getSelectedItem());
        emp.setEstadoCivil((String)cmbEstadoCivilEmpleado.getSelectedItem());
        emp.setFechaIngreso(txtFechaIngEmpleado.getText());
        emp.setCargo(txtCargoEmpleado.getText());
        emp.setDireccion(txtDireccionEmpleado.getText());
        emp.setProvincia(txtProvinciaEmpleado.getText());
        emp.setLocalidad(txtLocalidadEmpleado.getText());
        try {
            jpaEmpleado.create(emp);
            cargarTablaEmpleado();
            limpiarTxtEmpleado();
            txtEditableEmpleado(false);
            btnNuevoEmpleado.setEnabled(true);
            btnGuardarEmpleado.setEnabled(false);
            btnCancelarEmpleado.setEnabled(false);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.toString()+"Error al crear empleado.");
        }
                
    }//GEN-LAST:event_btnGuardarEmpleadoActionPerformed

    private void btnGuardarArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarArtActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnGuardarArtActionPerformed

    private void btnGuardarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarProveedorActionPerformed
        ProveedorJpaController jpaProveedor = new ProveedorJpaController();
        Proveedor prov = new Proveedor();
        prov.setIdPersona(txtCuitProveedor.getText());
        prov.setSituacionTributaria((String)cmbSituacTribProveedor.getSelectedItem());
        prov.setTipoProveduria(txtTipoProveeduriaProveedor.getText());
        prov.setTelefono(txtTelProveedor.getText());
        prov.setDireccion(txtDireccionProveedor.getText());
        prov.setLocalidad(txtLocalidadProveedor.getText());
        prov.setProvincia(txtProvinciaProveedor.getText());
        prov.setRazonSocial(txtRazonSocialProveedor.getText());
        try {
            jpaProveedor.create(prov);
            cargarTablaProveedor();
            limpiarTxtProveedor();
            txtEditableProveedor(false);
            btnNuevoProveedor.setEnabled(true);
            btnGuardarProveedor.setEnabled(false);
            btnCancelarProveedor.setEnabled(false);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.toString()+"Error al crear proveedor.");
        }
        
    }//GEN-LAST:event_btnGuardarProveedorActionPerformed

    private void btnCancelarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarProveedorActionPerformed
        txtEditableProveedor(false);
        limpiarTxtProveedor();
        btnNuevoProveedor.setEnabled(true);
        btnGuardarProveedor.setEnabled(false);
        btnCancelarProveedor.setEnabled(false);
    }//GEN-LAST:event_btnCancelarProveedorActionPerformed

    private void btnEditarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProveedorActionPerformed
        txtEditableProveedor(true);
        btnEditarProveedor.setEnabled(false);
        btnNuevoProveedor.setEnabled(false);
        btnGuardarProveedor.setEnabled(true);
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
        ClienteJpaController jpaCliente = new ClienteJpaController();
        Cliente cli = new Cliente();
        cli.setTipoCliente((String)cmbTipoCliente.getSelectedItem());
        cli.setIdPersona(txtCuitCliente.getText());
        cli.setRazonSocial(txtRazonSocialCliente.getText());
        cli.setApellido(txtApellidoCliente.getText());
        cli.setNombre(txtNombreCliente.getText());
        cli.setIvaCondicion((String)cmbCondIvaCliente.getSelectedItem());
        cli.setTelefono(txtTelCliente.getText());
        cli.setDireccion(txtDireccionCliente.getText());
        cli.setProvincia(txtProvinciaCliente.getText());
        cli.setLocalidad(txtLocalidadCliente.getText());
        try {
            jpaCliente.create(cli);
            cargarTablaCliente();
            limpiarTxtCliente();
            txtEditableCliente(false);
            btnNuevoCliente.setEnabled(true);
            btnGuardarCliente.setEnabled(false);
            btnCancelarCliente.setEnabled(false);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.toString()+"Error al crear cliente.");
        }
    }//GEN-LAST:event_btnGuardarClienteActionPerformed

    private void btnEditarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarClienteActionPerformed
        txtEditableCliente(true);
        btnEditarCliente.setEnabled(false);
        btnNuevoCliente.setEnabled(false);
        btnGuardarCliente.setEnabled(true);
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
    }//GEN-LAST:event_btnCancelarClienteActionPerformed

    private void btnNuevoEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoEmpleadoActionPerformed
        txtEditableEmpleado(true);
        btnNuevoEmpleado.setEnabled(false);
        btnGuardarEmpleado.setEnabled(true);
        btnCancelarEmpleado.setEnabled(true);
        limpiarTxtEmpleado();
    }//GEN-LAST:event_btnNuevoEmpleadoActionPerformed

    private void btnEditarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarEmpleadoActionPerformed
        txtEditableCliente(true);
        btnEditarCliente.setEnabled(false);
        btnNuevoCliente.setEnabled(false);
        btnGuardarCliente.setEnabled(true);
        btnCancelarCliente.setEnabled(true);
    }//GEN-LAST:event_btnEditarEmpleadoActionPerformed

   //CARGAR LAS TABLAS/////////////////////////////////////////////////////
   //P R O V E E D O R
    public static DefaultTableModel modeloProveedor;
    private void CrearModeloProveedor(){
        try {
            modeloProveedor = (new DefaultTableModel(
            null, new String [] {
            "CUIT","Razón Social",
            "Sit. Tributaria","Tipo Proveduria"}){
            Class[] types = new Class [] {
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
            false,false,false,false
            };
            @Override
            public Class getColumnClass(int columnIndex) {
            return types [columnIndex];
            }
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex){
            return canEdit [colIndex];
            }
            });
            tblProveedor.setModel(modeloProveedor);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.toString()+"error2");
        }
    }
    private void cargarTablaProveedor(){
        try{
            Object A[] = null;
            List<Proveedor> listaProveedor = jpaProv.findProveedorEntities();
            for (int i = 0; i < listaProveedor.size(); i++) {
                modeloProveedor.addRow(A);
                modeloProveedor.setValueAt(listaProveedor.get(i).getIdPersona(), i, 0);
                modeloProveedor.setValueAt(listaProveedor.get(i).getRazonSocial(), i, 1);
                modeloProveedor.setValueAt(listaProveedor.get(i).getSituacionTributaria(), i, 2);
                modeloProveedor.setValueAt(listaProveedor.get(i).getTipoProveduria(), i, 3);
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    //C L I E N T E/////////////////////////////////////
    public static DefaultTableModel modeloCliente;
    private void CrearModeloCliente(){
        try {
            modeloCliente = (new DefaultTableModel(
            null, new String [] {
            "DNI/CUIT","Apellido",
            "Nombre","Razón Social","Tel.","Dirección"}){
            Class[] types = new Class [] {
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
            false,false,false,false,false,false
            };
            @Override
            public Class getColumnClass(int columnIndex) {
            return types [columnIndex];
            }
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex){
            return canEdit [colIndex];
            }
            });
            tblCliente.setModel(modeloCliente);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.toString()+"error2");
        }
    }
    private void cargarTablaCliente(){
        try{
            Object A[] = null;
            List<Cliente> listaCliente = jpaCli.findClienteEntities();
            for (int i = 0; i < listaCliente.size(); i++) {
                modeloCliente.addRow(A);
                modeloCliente.setValueAt(listaCliente.get(i).getIdPersona(), i, 0);
                modeloCliente.setValueAt(listaCliente.get(i).getNombre(), i, 1);
                modeloCliente.setValueAt(listaCliente.get(i).getApellido(), i, 2);
                modeloCliente.setValueAt(listaCliente.get(i).getRazonSocial(), i, 3);
                modeloCliente.setValueAt(listaCliente.get(i).getTelefono(), i, 4);
                modeloCliente.setValueAt(listaCliente.get(i).getDireccion(), i, 5);
                
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    //E M P L E A D O
    public static DefaultTableModel modeloEmpleado;
    private void CrearModeloEmpleado(){
        try {
            modeloEmpleado = (new DefaultTableModel(
            null, new String [] {
            "CUIL","Apellido",
            "Nombre","Fecha de Ingreso","Cargo","Tel.","Dirección"}){
            Class[] types = new Class [] {
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
            false,false,false,false,false,false,false
            };
            @Override
            public Class getColumnClass(int columnIndex) {
            return types [columnIndex];
            }
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex){
            return canEdit [colIndex];
            }
            });
            tblEmpleado.setModel(modeloEmpleado);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.toString()+"error2");
        }
    }
    private void cargarTablaEmpleado(){
        try{
            Object A[] = null;
            List<Empleado> listaEmpleado = jpaEmp.findEmpleadoEntities();
            for (int i = 0; i < listaEmpleado.size(); i++) {
                modeloEmpleado.addRow(A);
                modeloEmpleado.setValueAt(listaEmpleado.get(i).getIdPersona(), i, 0);
                modeloEmpleado.setValueAt(listaEmpleado.get(i).getNombre(), i, 1);
                modeloEmpleado.setValueAt(listaEmpleado.get(i).getApellido(), i, 2);
                modeloEmpleado.setValueAt(listaEmpleado.get(i).getFechaIngreso(), i, 3);
                modeloEmpleado.setValueAt(listaEmpleado.get(i).getCargo(), i, 4);
                modeloEmpleado.setValueAt(listaEmpleado.get(i).getTelefono(), i, 5);
                modeloEmpleado.setValueAt(listaEmpleado.get(i).getDireccion(), i, 6);
                
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarCliente;
    private javax.swing.JButton btnCancelarEmpleado;
    private javax.swing.JButton btnCancelarProveedor;
    private javax.swing.JButton btnEditarCliente;
    private javax.swing.JButton btnEditarEmpleado;
    private javax.swing.JButton btnEditarProveedor;
    private javax.swing.JButton btnEliminarCliente;
    private javax.swing.JButton btnEliminarEmpleado;
    private javax.swing.JButton btnEliminarProveedor;
    private javax.swing.JButton btnGuardarArt;
    private javax.swing.JButton btnGuardarCliente;
    private javax.swing.JButton btnGuardarEmpleado;
    private javax.swing.JButton btnGuardarProveedor;
    private javax.swing.JButton btnNuevoCliente;
    private javax.swing.JButton btnNuevoEmpleado;
    private javax.swing.JButton btnNuevoProveedor;
    private javax.swing.JComboBox cmbCondIvaCliente;
    private javax.swing.JComboBox cmbEstadoCivilEmpleado;
    private javax.swing.JComboBox cmbSexoEmpleado;
    private javax.swing.JComboBox cmbSituacTribProveedor;
    private javax.swing.JComboBox cmbTipoCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
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
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPaneAdministracion;
    private javax.swing.JLabel lblApellidoCliente;
    private javax.swing.JLabel lblApellidoEmpleado;
    private javax.swing.JLabel lblBuscarCliente;
    private javax.swing.JLabel lblBuscarEmpleado;
    private javax.swing.JLabel lblBuscarProveedor;
    private javax.swing.JLabel lblCargoEmpleado;
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
    private javax.swing.JLabel lblNombreCliente;
    private javax.swing.JLabel lblNombreEmpleado;
    private javax.swing.JLabel lblProvinciaCliente;
    private javax.swing.JLabel lblProvinciaEmpleado;
    private javax.swing.JLabel lblProvinciaProveedor;
    private javax.swing.JLabel lblRazonSocialCliente;
    private javax.swing.JLabel lblRazonSocialProveedor;
    private javax.swing.JLabel lblSexoEmpleado;
    private javax.swing.JLabel lblSituacTribProveedor;
    private javax.swing.JLabel lblTelCliente;
    private javax.swing.JLabel lblTelProveedor;
    private javax.swing.JLabel lblTipoCliente;
    private javax.swing.JLabel lblTipoProveeduriaProveedor;
    private javax.swing.JTable tblCliente;
    private javax.swing.JTable tblEmpleado;
    private javax.swing.JTable tblProveedor;
    private javax.swing.JTextField txtApellidoCliente;
    private javax.swing.JTextField txtApellidoEmpleado;
    private javax.swing.JTextField txtBuscarCliente;
    private javax.swing.JTextField txtBuscarEmpleado;
    private javax.swing.JTextField txtBuscarProveedor;
    private javax.swing.JTextField txtCargoEmpleado;
    private javax.swing.JTextField txtCuilEmpleado;
    private javax.swing.JTextField txtCuitCliente;
    private javax.swing.JTextField txtCuitProveedor;
    private javax.swing.JTextField txtDireccionCliente;
    private javax.swing.JTextField txtDireccionEmpleado;
    private javax.swing.JTextField txtDireccionProveedor;
    private javax.swing.JTextField txtFechaElaboraArt;
    private javax.swing.JTextField txtFechaExpiraArt;
    private javax.swing.JFormattedTextField txtFechaIngEmpleado;
    private javax.swing.JFormattedTextField txtFechaNacEmpleado;
    private javax.swing.JTextField txtLocalidadCliente;
    private javax.swing.JTextField txtLocalidadEmpleado;
    private javax.swing.JTextField txtLocalidadProveedor;
    private javax.swing.JTextField txtLoteArt;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtNombreEmpleado;
    private javax.swing.JTextField txtNroArt;
    private javax.swing.JTextField txtProvinciaCliente;
    private javax.swing.JTextField txtProvinciaEmpleado;
    private javax.swing.JTextField txtProvinciaProveedor;
    private javax.swing.JTextField txtRazonSocialCliente;
    private javax.swing.JTextField txtRazonSocialProveedor;
    private javax.swing.JTextField txtTelCliente;
    private javax.swing.JTextField txtTelProveedor;
    private javax.swing.JTextField txtTipoProveeduriaProveedor;
    // End of variables declaration//GEN-END:variables
}