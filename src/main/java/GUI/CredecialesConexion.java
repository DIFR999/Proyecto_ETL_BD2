/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import clases.DTO.ConexionDTO;
import clases.ConexionGBD;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class CredecialesConexion extends javax.swing.JFrame {

    public static int ConexionElegida;
    public static Connection conOrigen = null;
    public CredecialesConexion() {
        initComponents();
        if(MenuPrincipal.UsuarioCOnexion!="" || MenuPrincipal.UsuarioCOnexion!=null){
            txtusuarioCredenciales.setEnabled(false);
            txtusuarioCredenciales.setText(MenuPrincipal.UsuarioCOnexion);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtusuarioCredenciales = new javax.swing.JTextField();
        txtPasswordCredenciales = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnVerificarCredenciales = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel1.setText("Usuario:");

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel2.setText("Contraseña:");

        txtusuarioCredenciales.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        txtPasswordCredenciales.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel3.setText("VERIFICAR CREDENCIALES");

        btnVerificarCredenciales.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        btnVerificarCredenciales.setText("Conectar a la base de datos");
        btnVerificarCredenciales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarCredencialesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(32, 32, 32)
                        .addComponent(txtPasswordCredenciales))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(69, 69, 69)
                        .addComponent(txtusuarioCredenciales)))
                .addGap(75, 75, 75))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(141, 141, 141))
            .addGroup(layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(btnVerificarCredenciales)
                .addContainerGap(152, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel3)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtusuarioCredenciales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPasswordCredenciales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(btnVerificarCredenciales)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerificarCredencialesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarCredencialesActionPerformed
        ConexionGBD conexion = new ConexionGBD();
       
        

        String contraseniaOrigen;
        // Solicitamos las credenciales de la conexión
            MenuPrincipal.ConexionOrigen = MenuPrincipal.conexiones.get(ConexionElegida);
            contraseniaOrigen = txtPasswordCredenciales.getText();
        try {
                conOrigen = conexion.openConnection(MenuPrincipal.ConexionOrigen.getUsername(), contraseniaOrigen);
                JOptionPane.showMessageDialog(this, "Conexion Exitosa");
                dispose(); // Cierra la ventana actual
                
                
                  if(MenuPrincipal.ConexionOrigen.getUsername()!=null){
                     MenuPrincipal.menu.btnCrearETL.setEnabled(false);
                }
                MenuPrincipal.frmCONOR.dispose();


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "No se pudo establecer la conexión. Verifique las credenciales.");

        }
    }//GEN-LAST:event_btnVerificarCredencialesActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVerificarCredenciales;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtPasswordCredenciales;
    private javax.swing.JTextField txtusuarioCredenciales;
    // End of variables declaration//GEN-END:variables
}
