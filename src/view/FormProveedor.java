
package view;

import ElMercadito.ElMercadito;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import model.Proveedor;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;


public class FormProveedor extends javax.swing.JDialog {

    ElMercadito unMercadito;
    private DefaultListModel modeloProveedor = new DefaultListModel();
    public FormProveedor(java.awt.Frame parent, boolean modal, ElMercadito unMercadito) {
        super(parent, modal);
        this.unMercadito=unMercadito;
        initComponents();
        this.setVisible(true);
        this.ListProveedor.setModel(modeloProveedor);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        btnBorrar = new javax.swing.JButton();
        btnSl = new javax.swing.JButton();
        btnModificarProveedor = new javax.swing.JButton();
        btnAgregarProveedor = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblFechaNac = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        txtDniProveedor = new javax.swing.JTextField();
        txtNombreProveedor = new javax.swing.JTextField();
        txtApellidoProveedor = new javax.swing.JTextField();
        txtNroProv = new javax.swing.JTextField();
        txtTelefonoProveedor = new javax.swing.JTextField();
        lblRazonSocial = new javax.swing.JLabel();
        txtCuit = new javax.swing.JTextField();
        lblCuit = new javax.swing.JLabel();
        txtFechaNac = new javax.swing.JTextField();
        lblCondIva = new javax.swing.JLabel();
        Dirección = new javax.swing.JPanel();
        txtDireccion = new javax.swing.JTextField();
        txtProvincia = new javax.swing.JTextField();
        txtLocalidad = new javax.swing.JTextField();
        lblDireccion = new javax.swing.JLabel();
        lblProvincia = new javax.swing.JLabel();
        lblLocalidad = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtRazonSocial = new javax.swing.JTextField();
        cmbCondicionIva = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListProveedor = new javax.swing.JList();
        btnBuscarPorClave = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel7.setText("PROVEEDOR");

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        btnSl.setText("Salir");
        btnSl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSlActionPerformed(evt);
            }
        });

        btnModificarProveedor.setText("Modificar");
        btnModificarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarProveedorActionPerformed(evt);
            }
        });

        btnAgregarProveedor.setText("Agregar");
        btnAgregarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProveedorActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Proveedor"));

        jLabel1.setText("DNI");

        jLabel2.setText("Nombre");

        jLabel3.setText("Apellido");

        lblFechaNac.setText("Fecha Nacimiento");

        lblTelefono.setText("telefono");

        txtDniProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDniProveedorActionPerformed(evt);
            }
        });

        lblRazonSocial.setText("Razón Social");

        lblCuit.setText("Cuit");

        lblCondIva.setText("Condición IVA");

        Dirección.setBorder(javax.swing.BorderFactory.createTitledBorder("Ubicación"));

        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });

        lblDireccion.setText("Dirección");

        lblProvincia.setText("Provincia");

        lblLocalidad.setText("Localidad");

        javax.swing.GroupLayout DirecciónLayout = new javax.swing.GroupLayout(Dirección);
        Dirección.setLayout(DirecciónLayout);
        DirecciónLayout.setHorizontalGroup(
            DirecciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(DirecciónLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DirecciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(DirecciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(DirecciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtProvincia, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                        .addComponent(txtLocalidad))
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        DirecciónLayout.setVerticalGroup(
            DirecciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DirecciónLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(DirecciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDireccion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DirecciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProvincia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(DirecciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLocalidad))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setText("Nro. Prov");

        cmbCondicionIva.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Resp. Insc.", "Monotrib.", "Exento", "C.Final" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCuit)
                    .addComponent(jLabel4)
                    .addComponent(lblRazonSocial))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNroProv, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCuit, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblCondIva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbCondicionIva, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblTelefono)
                                    .addComponent(lblFechaNac))
                                .addGap(8, 8, 8)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtFechaNac)
                                    .addComponent(txtNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDniProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                    .addComponent(txtApellidoProveedor))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(txtTelefonoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
            .addComponent(Dirección, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDniProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellidoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFechaNac))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefonoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelefono))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCondIva)
                    .addComponent(cmbCondicionIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNroProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCuit)
                    .addComponent(txtCuit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRazonSocial)
                    .addComponent(txtRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Dirección, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ListProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListProveedorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ListProveedor);

        btnBuscarPorClave.setText("Buscar");
        btnBuscarPorClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPorClaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btnAgregarProveedor)
                .addGap(18, 18, 18)
                .addComponent(btnModificarProveedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscarPorClave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSl)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(252, 252, 252))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarProveedor)
                    .addComponent(btnModificarProveedor)
                    .addComponent(btnBorrar)
                    .addComponent(btnSl)
                    .addComponent(btnBuscarPorClave))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSlActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSlActionPerformed

    private void btnModificarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarProveedorActionPerformed
        int confirmar;
        confirmar=JOptionPane.showConfirmDialog(this, "Esta accion modificará los datos del Proveedor ¿Desea continuar?", "Modificar",  JOptionPane.YES_NO_OPTION);
        if(confirmar==JOptionPane.YES_OPTION){
            try {
                Proveedor unPro= this.unMercadito.getUnaSucursal().BuscarProveedorCuit(this.txtNroProv.getText());
                this.unMercadito.getUnaSucursal().ModificarProveedor(unPro,Integer.parseInt(this.txtRazonSocial.getText()),this.txtCuit.getText(),this.txtDniProveedor.getText(), this.txtNombreProveedor.getText(), this.txtApellidoProveedor.getText(), this.txtNroProv.getText(), this.txtTelefonoProveedor.getText());
                JOptionPane.showMessageDialog(this, "Se modificaron correctamente los datos");
            } catch (Exception ex) {
                Logger.getLogger(FormProveedor.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error con la base de datos");
            }
        }
    }//GEN-LAST:event_btnModificarProveedorActionPerformed

    @SuppressWarnings("unchecked")
    private void btnAgregarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProveedorActionPerformed
        
        
            try {
                this.unMercadito.getUnaSucursal().agregarProveedor(Integer.parseInt(this.txtRazonSocial.getText()),this.txtCuit.getText(),this.txtDniProveedor.getText(),this.txtNombreProveedor.getText(),this.txtApellidoProveedor.getText(), this.txtNroProv.getText(),this.txtTelefonoProveedor.getText());
                this.ListProveedor.setModel(modeloProveedor);
                this.CargarListaProveedor(this.unMercadito.getUnaSucursal().getListaProveedores());
                JOptionPane.showMessageDialog(this, "Se ha agregado satisfactoriamente");
            } catch (Exception ex) {
                Logger.getLogger(FormProveedor.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error con la base de datos");
            }
            
        
    }//GEN-LAST:event_btnAgregarProveedorActionPerformed
    public void CargarListaProveedor(List listaComun){
        Iterator iter = listaComun.iterator();
        this.modeloProveedor.clear();
        while(iter.hasNext()){
            this.modeloProveedor.addElement(iter.next());
        }
   }
    private void txtDniProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDniProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDniProveedorActionPerformed

    private void btnBuscarPorClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPorClaveActionPerformed
        Proveedor unProveedor;
        unProveedor=unMercadito.getUnaSucursal().BuscarProveedorCuit(this.txtNroProv.getText());
        this.txtDniProveedor.setText(unProveedor.getDni());
        this.txtNombreProveedor.setText(unProveedor.getNombre());
        this.txtApellidoProveedor.setText(unProveedor.getApellido());
        this.txtCuit.setText(unProveedor.getRazonSocial());
        this.txtTelefonoProveedor.setText(unProveedor.getTelefono());
        this.txtNroProv.setText(unProveedor.getNroCiut());
    }//GEN-LAST:event_btnBuscarPorClaveActionPerformed

    private void ListProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListProveedorMouseClicked
        Proveedor unProveedor = (Proveedor) this.modeloProveedor.getElementAt(this.ListProveedor.getSelectedIndex());
        this.txtDniProveedor.setText(unProveedor.getDni());
        this.txtNombreProveedor.setText(unProveedor.getNombre());
        this.txtApellidoProveedor.setText(unProveedor.getApellido());
        this.txtCuit.setText(unProveedor.getRazonSocial());
        this.txtTelefonoProveedor.setText(unProveedor.getTelefono());
        this.txtNroProv.setText(unProveedor.getNroCiut());
    }//GEN-LAST:event_ListProveedorMouseClicked

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        this.unMercadito.getUnaSucursal().BorrarProveedor(Integer.parseInt(this.txtRazonSocial.getText()));
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Dirección;
    private javax.swing.JList ListProveedor;
    private javax.swing.JButton btnAgregarProveedor;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBuscarPorClave;
    private javax.swing.JButton btnModificarProveedor;
    private javax.swing.JButton btnSl;
    private javax.swing.JComboBox cmbCondicionIva;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCondIva;
    private javax.swing.JLabel lblCuit;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblFechaNac;
    private javax.swing.JLabel lblLocalidad;
    private javax.swing.JLabel lblProvincia;
    private javax.swing.JLabel lblRazonSocial;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JTextField txtApellidoProveedor;
    private javax.swing.JTextField txtCuit;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDniProveedor;
    private javax.swing.JTextField txtFechaNac;
    private javax.swing.JTextField txtLocalidad;
    private javax.swing.JTextField txtNombreProveedor;
    private javax.swing.JTextField txtNroProv;
    private javax.swing.JTextField txtProvincia;
    private javax.swing.JTextField txtRazonSocial;
    private javax.swing.JTextField txtTelefonoProveedor;
    // End of variables declaration//GEN-END:variables
}
