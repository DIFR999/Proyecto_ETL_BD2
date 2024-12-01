/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import static GUI.FormularioETL.tablas;
import static GUI.FormularioETL.tablasPorConexion;
import clases.ConexionGBD;
import clases.DTO.ConexionDTO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class ConexionDestino extends javax.swing.JFrame {

  public static Connection conDestino = null;
    public ConexionDestino() {
        initComponents();
        btnVerificarCredencialesDestino.setEnabled(false);
        txtusuarioCredencialesDestino.setEnabled(false);
        txtPasswordCredencialesDestino.setEnabled(false);
        
        DefaultComboBoxModel model =new DefaultComboBoxModel();
        
        
        if(MenuPrincipal.conexiones.isEmpty()){
             JOptionPane.showMessageDialog(this, "No hay conexiones, verifique si ha anadido la credenciales de administrador en la conexiones al origen");
         }else{
            int i = 0;
             for (ConexionDTO conexionDTO : MenuPrincipal.conexiones) {
                    model.addElement(conexionDTO.getUsername());
                i++;
               }
             cmbConexionesDD.setModel(model); 


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

        pnlConexionOrigen = new javax.swing.JPanel();
        cmbConexionesDD = new javax.swing.JComboBox<>();
        lblconOrigen = new javax.swing.JLabel();
        btnConectarDestino = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtusuarioCredencialesDestino = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPasswordCredencialesDestino = new javax.swing.JTextField();
        btnVerificarCredencialesDestino = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        pnlConexionOrigen.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CONEXION DESTINO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 0, 18))); // NOI18N

        cmbConexionesDD.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbConexionesDD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbConexionesDD.setInheritsPopupMenu(true);
        cmbConexionesDD.setOpaque(true);
        cmbConexionesDD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbConexionesDDActionPerformed(evt);
            }
        });

        lblconOrigen.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        lblconOrigen.setText("Conexione Disponibles: ");

        btnConectarDestino.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        btnConectarDestino.setText("Conectar");
        btnConectarDestino.setInheritsPopupMenu(true);
        btnConectarDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConectarDestinoActionPerformed(evt);
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
                        .addComponent(cmbConexionesDD, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlConexionOrigenLayout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(btnConectarDestino)))
                .addContainerGap(113, Short.MAX_VALUE))
        );
        pnlConexionOrigenLayout.setVerticalGroup(
            pnlConexionOrigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlConexionOrigenLayout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(pnlConexionOrigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblconOrigen)
                    .addComponent(cmbConexionesDD))
                .addGap(18, 18, 18)
                .addComponent(btnConectarDestino)
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel3.setText("VERIFICAR CREDENCIALES");

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel1.setText("Usuario:");

        txtusuarioCredencialesDestino.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtusuarioCredencialesDestino.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel2.setText("Contraseña:");

        txtPasswordCredencialesDestino.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtPasswordCredencialesDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordCredencialesDestinoActionPerformed(evt);
            }
        });

        btnVerificarCredencialesDestino.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        btnVerificarCredencialesDestino.setText("Conectar a la base de datos");
        btnVerificarCredencialesDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarCredencialesDestinoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(pnlConexionOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPasswordCredencialesDestino, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                            .addComponent(txtusuarioCredencialesDestino)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnVerificarCredencialesDestino)
                            .addComponent(jLabel3))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(pnlConexionOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabel3)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtusuarioCredencialesDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPasswordCredencialesDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(btnVerificarCredencialesDestino)
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbConexionesDDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbConexionesDDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbConexionesDDActionPerformed

    private void btnConectarDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConectarDestinoActionPerformed
        // TODO add your handling code here:
        MenuPrincipal.UsuarioCOnexionDestino = this.cmbConexionesDD.getSelectedItem().toString();
        btnVerificarCredencialesDestino.setEnabled(true);
        txtPasswordCredencialesDestino.setEnabled(true);
        txtusuarioCredencialesDestino.setText(this.cmbConexionesDD.getSelectedItem().toString());
       

    }//GEN-LAST:event_btnConectarDestinoActionPerformed

    private void btnVerificarCredencialesDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarCredencialesDestinoActionPerformed
        ConexionGBD conexion2 = new ConexionGBD();

        String contraseniaDestino;
        // Solicitamos las credenciales de la conexión
        MenuPrincipal.conexionDestino = MenuPrincipal.conexiones.get(cmbConexionesDD.getSelectedIndex());
        contraseniaDestino = txtPasswordCredencialesDestino.getText();
        try {
            conDestino = conexion2.openConnection(MenuPrincipal.conexionDestino.getUsername(), contraseniaDestino);
            JOptionPane.showMessageDialog(this, "Conexion Exitosa");
            
            FormularioETL.txtBaseDestino.setText(MenuPrincipal.conexionDestino.getUsername());
            
            
            try{
            FormularioETL.tablasDestino = FormularioETL.tablasPorConexionDestino.obtenerTablas(MenuPrincipal.conexionDestino.getUsername(), conDestino);

                // MOSTRAMOS LA LISTA DE TABLAS QUE EL SCHEMA POSEE

                 DefaultComboBoxModel modelTablasDestino =new DefaultComboBoxModel();
            
                  int i = 0;
                      modelTablasDestino.addElement("Selecciona una tabla");
                for (String tabla : FormularioETL.tablasDestino) {
                       modelTablasDestino.addElement(FormularioETL.tablasDestino.get(i).toString());
                        i++;
                }
                
                FormularioETL.cmbTablasDestino.setModel(modelTablasDestino);
        }catch  (Exception e){
            JOptionPane.showMessageDialog(this, "No se pudo establecer conexion con las tablas ." + e.getMessage());

        }
            FormularioETL.btnAsignacionesCampos.setEnabled(true);
            dispose(); // Cierra la ventana actual
            
         

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "No se pudo establecer la conexión. Verifique las credenciales.");

        }
    }//GEN-LAST:event_btnVerificarCredencialesDestinoActionPerformed

    private void txtPasswordCredencialesDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordCredencialesDestinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordCredencialesDestinoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConectarDestino;
    private javax.swing.JButton btnVerificarCredencialesDestino;
    public static javax.swing.JComboBox<String> cmbConexionesDD;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblconOrigen;
    private javax.swing.JPanel pnlConexionOrigen;
    private javax.swing.JTextField txtPasswordCredencialesDestino;
    private javax.swing.JTextField txtusuarioCredencialesDestino;
    // End of variables declaration//GEN-END:variables
}
