
package view;

import App.Aplicacion;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import pkgLogica.Proveedor;
import pkgPersistencia.exceptions.NonexistentEntityException;
import pkgPersistencia.exceptions.PreexistingEntityException;


public class FormProveedor extends javax.swing.JDialog {

    Aplicacion unaAplicacion;
    private DefaultListModel modeloProveedor = new DefaultListModel();
    public FormProveedor(java.awt.Frame parent, boolean modal, Aplicacion unaAplicacion) {
        super(parent, modal);
        this.unaAplicacion=unaAplicacion;
        initComponents();
        this.setVisible(true);
        this.ListProveedor.setModel(modeloProveedor);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        btnBorrar = new javax.swing.JButton();
        btnSl = new javax.swing.JButton();
        btnModificarProveedor = new javax.swing.JButton();
        btnAgregarProveedor = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtDniProveedor = new javax.swing.JTextField();
        txtNombreProveedor = new javax.swing.JTextField();
        txtApellidoProveedor = new javax.swing.JTextField();
        txtCuitProveedor = new javax.swing.JTextField();
        txtTelefonoProveedor = new javax.swing.JTextField();
        btnBuscarPorClave = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtNroProveedor = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNombreComercialProveedor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListProveedor = new javax.swing.JList();

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

        jLabel2.setText("nombre");

        jLabel3.setText("apellido");

        jLabel5.setText("cuit");

        jLabel6.setText("telefono");

        txtDniProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDniProveedorActionPerformed(evt);
            }
        });

        btnBuscarPorClave.setText("Buscar");
        btnBuscarPorClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPorClaveActionPerformed(evt);
            }
        });

        jLabel4.setText("Nro. Prov");

        jLabel8.setText("Nombre comercial");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCuitProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtDniProveedor)
                                .addComponent(txtNombreComercialProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                            .addComponent(btnBuscarPorClave, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtApellidoProveedor)
                            .addComponent(txtNroProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(txtTelefonoProveedor))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCuitProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtNombreComercialProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDniProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtApellidoProveedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNroProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefonoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscarPorClave)
                .addContainerGap())
        );

        ListProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListProveedorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ListProveedor);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btnAgregarProveedor)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificarProveedor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSl))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(257, 257, 257))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarProveedor)
                    .addComponent(btnModificarProveedor)
                    .addComponent(btnBorrar)
                    .addComponent(btnSl))
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
                Proveedor unPro= this.unaAplicacion.getUnaEmpresa().BuscarProveedorCuit(this.txtCuitProveedor.getText());
                this.unaAplicacion.getUnaEmpresa().ModificarProveedor(unPro,Integer.parseInt(this.txtNroProveedor.getText()),this.txtNombreComercialProveedor.getText(),this.txtDniProveedor.getText(), this.txtNombreProveedor.getText(), this.txtApellidoProveedor.getText(), this.txtCuitProveedor.getText(), this.txtTelefonoProveedor.getText());
                JOptionPane.showMessageDialog(this, "Se modificaron correctamente los datos");
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(FormProveedor.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error con la base de datos, no existe");
            } catch (Exception ex) {
                Logger.getLogger(FormProveedor.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error con la base de datos");
            }
        }
    }//GEN-LAST:event_btnModificarProveedorActionPerformed

    private void btnAgregarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProveedorActionPerformed
        
        
            try {
                this.unaAplicacion.getUnaEmpresa().agregarProveedor(Integer.parseInt(this.txtNroProveedor.getText()),this.txtNombreComercialProveedor.getText(),this.txtDniProveedor.getText(),this.txtNombreProveedor.getText(),this.txtApellidoProveedor.getText(), this.txtCuitProveedor.getText(),this.txtTelefonoProveedor.getText());
                this.ListProveedor.setModel(modeloProveedor);
                this.CargarListaProveedor(this.unaAplicacion.getUnaEmpresa().getListaProveedores());
                JOptionPane.showMessageDialog(this, "Se ha agregado satisfactoriamente");
            } catch (PreexistingEntityException ex) {
                Logger.getLogger(FormProveedor.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error con la base de datos, ya existe");
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
        unProveedor=unaAplicacion.getUnaEmpresa().BuscarProveedorCuit(this.txtCuitProveedor.getText());
        this.txtDniProveedor.setText(unProveedor.getDni());
        this.txtNombreProveedor.setText(unProveedor.getNombre());
        this.txtApellidoProveedor.setText(unProveedor.getApellido());
        this.txtNombreComercialProveedor.setText(unProveedor.getRazonSocial());
        this.txtTelefonoProveedor.setText(unProveedor.getTelefono());
        this.txtCuitProveedor.setText(unProveedor.getCuit());
    }//GEN-LAST:event_btnBuscarPorClaveActionPerformed

    private void ListProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListProveedorMouseClicked
        Proveedor unProveedor = (Proveedor) this.modeloProveedor.getElementAt(this.ListProveedor.getSelectedIndex());
        this.txtDniProveedor.setText(unProveedor.getDni());
        this.txtNombreProveedor.setText(unProveedor.getNombre());
        this.txtApellidoProveedor.setText(unProveedor.getApellido());
        this.txtNombreComercialProveedor.setText(unProveedor.getRazonSocial());
        this.txtTelefonoProveedor.setText(unProveedor.getTelefono());
        this.txtCuitProveedor.setText(unProveedor.getCuit());
    }//GEN-LAST:event_ListProveedorMouseClicked

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        try {
        
            this.unaAplicacion.getUnaEmpresa().BorrarProveedor(Integer.parseInt(this.txtNroProveedor.getText()));
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(FormProveedor.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error con la base de datos, no existe proveedor");
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList ListProveedor;
    private javax.swing.JButton btnAgregarProveedor;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBuscarPorClave;
    private javax.swing.JButton btnModificarProveedor;
    private javax.swing.JButton btnSl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtApellidoProveedor;
    private javax.swing.JTextField txtCuitProveedor;
    private javax.swing.JTextField txtDniProveedor;
    private javax.swing.JTextField txtNombreComercialProveedor;
    private javax.swing.JTextField txtNombreProveedor;
    private javax.swing.JTextField txtNroProveedor;
    private javax.swing.JTextField txtTelefonoProveedor;
    // End of variables declaration//GEN-END:variables
}
