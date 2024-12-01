/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import clases.DTO.ConexionDTO;
import clases.ConexionesDisponible;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class frmConexionOrigen extends javax.swing.JFrame {

    
    public frmConexionOrigen() {
        initComponents();
        pnlConexionOrigen.setEnabled((false));
        btnConectarOrigen.setEnabled((false));
        lblconOrigen.setEnabled((false));
        cmbConexionesD.setEnabled(false);
        
         if(MenuPrincipal.conexiones==null){
             btnVerificarUserAdmin.setEnabled(true);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUserAdmin = new javax.swing.JTextField();
        txtPasswordAdmin = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        pnlConexionOrigen = new javax.swing.JPanel();
        cmbConexionesD = new javax.swing.JComboBox<>();
        lblconOrigen = new javax.swing.JLabel();
        btnConectarOrigen = new javax.swing.JButton();
        btnVerificarUserAdmin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        jLabel2.setText("Contraseña:");

        jLabel3.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        jLabel3.setText("Usuario Administrador");

        txtUserAdmin.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtUserAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserAdminActionPerformed(evt);
            }
        });

        txtPasswordAdmin.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtPasswordAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordAdminActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        jLabel5.setText("Usuario:");

        pnlConexionOrigen.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CONEXION ORIGEN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 0, 18))); // NOI18N

        cmbConexionesD.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbConexionesD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbConexionesD.setInheritsPopupMenu(true);
        cmbConexionesD.setOpaque(true);
        cmbConexionesD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbConexionesDActionPerformed(evt);
            }
        });

        lblconOrigen.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        lblconOrigen.setText("Conexione Disponibles: ");

        btnConectarOrigen.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        btnConectarOrigen.setText("Conectar");
        btnConectarOrigen.setInheritsPopupMenu(true);
        btnConectarOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConectarOrigenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlConexionOrigenLayout = new javax.swing.GroupLayout(pnlConexionOrigen);
        pnlConexionOrigen.setLayout(pnlConexionOrigenLayout);
        pnlConexionOrigenLayout.setHorizontalGroup(
            pnlConexionOrigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConexionOrigenLayout.createSequentialGroup()
                .addGroup(pnlConexionOrigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlConexionOrigenLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblconOrigen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbConexionesD, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlConexionOrigenLayout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(btnConectarOrigen)))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        pnlConexionOrigenLayout.setVerticalGroup(
            pnlConexionOrigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlConexionOrigenLayout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(pnlConexionOrigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblconOrigen)
                    .addComponent(cmbConexionesD))
                .addGap(18, 18, 18)
                .addComponent(btnConectarOrigen)
                .addContainerGap())
        );

        cmbConexionesD.getAccessibleContext().setAccessibleDescription("");

        btnVerificarUserAdmin.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        btnVerificarUserAdmin.setText("Verificar Usuario Administrador");
        btnVerificarUserAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarUserAdminActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(67, 67, 67)
                                        .addComponent(jLabel5)
                                        .addGap(48, 48, 48))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel2)
                                        .addGap(30, 30, 30)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtUserAdmin)
                                    .addComponent(txtPasswordAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel3)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(pnlConexionOrigen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(btnVerificarUserAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUserAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPasswordAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(btnVerificarUserAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(pnlConexionOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbConexionesDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbConexionesDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbConexionesDActionPerformed

    private void txtPasswordAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordAdminActionPerformed
        
    }//GEN-LAST:event_txtPasswordAdminActionPerformed

    private void txtUserAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserAdminActionPerformed
       
    }//GEN-LAST:event_txtUserAdminActionPerformed

    private void btnVerificarUserAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarUserAdminActionPerformed
        MenuPrincipal.conexiones.clear();
        MenuPrincipal.UserAdministrador = txtUserAdmin.getText();
        MenuPrincipal.PasswordAdministrador = txtPasswordAdmin.getText();
       if(MenuPrincipal.conexionesDisponibles.verificarCredenciales(MenuPrincipal.UserAdministrador,  MenuPrincipal.PasswordAdministrador)){
            MenuPrincipal.conexiones = MenuPrincipal.conexionesDisponibles.obtenerConexionesDisponibles(MenuPrincipal.UserAdministrador, MenuPrincipal.PasswordAdministrador);
            pnlConexionOrigen.setEnabled((true));
            btnConectarOrigen.setEnabled((true));
            lblconOrigen.setEnabled((true));
            cmbConexionesD.setEnabled(true);
           
            DefaultComboBoxModel model =new DefaultComboBoxModel();
            
            int i = 0;
            
            for (ConexionDTO conexionDTO : MenuPrincipal.conexiones) {
                 model.addElement( MenuPrincipal.conexiones.get(i).getUsername());
                    i++;
            }
            if(MenuPrincipal.conexiones == null){
                       JOptionPane.showMessageDialog(this, "No hay conexiones");
             }else{
                JOptionPane.showMessageDialog(this, "Conexión exitosa");
              
                
            }
           
            this.cmbConexionesD.setModel(model);
       }else{
            JOptionPane.showMessageDialog(this, "Error al verificar credenciales: Compruebe si el usuario o contraseña esta escrito correctamente"); 

       }
        
         
    
    }//GEN-LAST:event_btnVerificarUserAdminActionPerformed

    private void btnConectarOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConectarOrigenActionPerformed
        // TODO add your handling code here:
         MenuPrincipal.UsuarioCOnexion = this.cmbConexionesD.getSelectedItem().toString();
        CredecialesConexion.ConexionElegida = this.cmbConexionesD.getSelectedIndex();
       
        CredecialesConexion ventanaComprobocacionCred = new CredecialesConexion();

        ventanaComprobocacionCred.setLocationRelativeTo(this);  // Centra la ventana con respecto a la ventana principal

        ventanaComprobocacionCred.setVisible(true);  // Mostrar la ventana
        
    }//GEN-LAST:event_btnConectarOrigenActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConectarOrigen;
    private javax.swing.JButton btnVerificarUserAdmin;
    private javax.swing.JComboBox<String> cmbConexionesD;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel lblconOrigen;
    private javax.swing.JPanel pnlConexionOrigen;
    private javax.swing.JTextField txtPasswordAdmin;
    private javax.swing.JTextField txtUserAdmin;
    // End of variables declaration//GEN-END:variables
}
