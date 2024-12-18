/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import clases.CamposPorTablaConsulta;
import clases.ConexionesDisponible;
import clases.DTO.CampoDTO;
import clases.DTO.ConexionDTO;
import clases.IngresarDatosDestino;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MenuPrincipal extends javax.swing.JFrame {
    
    //CONEXIONES Y TABLAS PARA EL ORIGEN
    public static ConexionesDisponible conexionesDisponibles = new ConexionesDisponible();
    public static ArrayList<ConexionDTO> conexiones = new ArrayList<ConexionDTO>();
    public static ConexionDTO ConexionOrigen  = new ConexionDTO();
   
    //CONEXINES PARA EL DESTINO
    public static ConexionDTO conexionDestino = new ConexionDTO();
				
    // CREAMOS LA ESTRUCTURA PARA OBTENER LOS CAMPOS DE LA TABLA ORIGEN Y DESTINO
    public static CamposPorTablaConsulta camposPorTabla = new CamposPorTablaConsulta();
    public static ArrayList<CampoDTO> campos = new ArrayList<CampoDTO>();
    
    //GUARDAR TODAS INSERCCIONES DE UN DATAMART(DIMENESIONES)
    public static ArrayList<ArrayList<String>> InserccionesETL = new ArrayList<>(); 
       public static ArrayList<ArrayList<String>> camposSelectOrigenETL = new ArrayList<>();

    
   
    public static frmConexionOrigen frmCONOR = new frmConexionOrigen();
    
    
    //Lista de para el Jlist
     public static DefaultListModel<String> listDimensiones = new DefaultListModel<>();
     public static DefaultListModel<String> listHechos = new DefaultListModel<>();


   //VARIABLES GLOBALES
   public static String UsuarioCOnexion;
   public static String UsuarioCOnexionDestino;
   public static String UserAdministrador, PasswordAdministrador;   
   public static boolean fromTable;

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();

      
      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCrearETL = new javax.swing.JButton();
        btnEjecutar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jlsListaDimensiones = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jListaHechos = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnConexionOrigen = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCrearETL.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        btnCrearETL.setText("Agregar ETL");
        btnCrearETL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearETLActionPerformed(evt);
            }
        });

        btnEjecutar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnEjecutar.setText("Ejecutar ETL");
        btnEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEjecutarActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 499, Short.MAX_VALUE)
        );

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jlsListaDimensiones.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jScrollPane3.setViewportView(jlsListaDimensiones);

        jListaHechos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jScrollPane4.setViewportView(jListaHechos);

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        jLabel1.setText("Dimesiones");

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        jLabel2.setText("Hechos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(0, 3, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        btnConexionOrigen.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        btnConexionOrigen.setText("Conexion origen");
        btnConexionOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConexionOrigenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCrearETL, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEjecutar, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(85, 85, 85))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnConexionOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68)))))
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(89, Short.MAX_VALUE)
                .addComponent(btnConexionOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrearETL, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEjecutar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(172, 172, 172))
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearETLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearETLActionPerformed
         
         if(ConexionOrigen.getUsername()==null){
            JOptionPane.showMessageDialog(this, "DEBER ESCOGER UNA CONEXION DE ORIGEN");

        }else{
             FormularioETL frmETL = new FormularioETL();      
            frmETL.setLocationRelativeTo(this);  // Centra la ventana con respecto a la ventana principal
            frmETL.setVisible(true);  // Mostrar la ventana
         }
        
    }//GEN-LAST:event_btnCrearETLActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        
        try {
            if(CredecialesConexion.conOrigen!=null || ConexionDestino.conDestino!=null){
                CredecialesConexion.conOrigen.close();
                ConexionDestino.conDestino.close();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
       
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnConexionOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConexionOrigenActionPerformed
         // Crear una instancia de tu formulario (JFrame)

        // Centrar la ventana con respecto al JFrame principal
        frmCONOR.setLocationRelativeTo(this);  // Centra la ventana con respecto a la ventana principal

        // Hacer visible el JFrame
        frmCONOR.setVisible(true);  // Mostrar la ventana
    }//GEN-LAST:event_btnConexionOrigenActionPerformed

    private void btnEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjecutarActionPerformed
        IngresarDatosDestino EjecutarConsulta = new IngresarDatosDestino();
        String ConsultaInserccion;
        String TablaOrigen;
        String CamposOrigen;
        int FILASAFECTADAS=0;
        try{
            if(InserccionesETL.isEmpty()){
            JOptionPane.showMessageDialog(this, "DEBER TENER CREANDO A QUE SEA UN TABLA DE HECHOS Y UNA TABLA DE DIMENSIONES");

            }else{
                
                if(fromTable){
                    for(int j = 0; j<InserccionesETL.size();j++){
                        TablaOrigen = InserccionesETL.get(j).get(2).toString();
                        

                        ConsultaInserccion = InserccionesETL.get(j).get(3).toString();


                        FILASAFECTADAS= EjecutarConsulta.ejecutarInsercion(ConexionDestino.conDestino, CredecialesConexion.conOrigen, ConsultaInserccion,
                            TablaOrigen,true,camposSelectOrigenETL.get(j));
                        
                     }
                        JOptionPane.showMessageDialog(this, "Se insertaron "+ String.valueOf(FILASAFECTADAS) + " filas al destino correctmante");
   
                    
                }else{

                    for(int j = 0; j<InserccionesETL.size();j++){
                        TablaOrigen = InserccionesETL.get(j).get(2).toString();
                        ConsultaInserccion = InserccionesETL.get(j).get(3).toString();
                        

                       FILASAFECTADAS=EjecutarConsulta.ejecutarInsercion(ConexionDestino.conDestino, CredecialesConexion.conOrigen, ConsultaInserccion,
                              TablaOrigen,false, camposSelectOrigenETL.get(j));
                    }
                                    JOptionPane.showMessageDialog(this, "Se insertaron "+ String.valueOf(FILASAFECTADAS) + " filas al destino correctmante");

                }
                
                
            } 
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Succedio un error inesperado al momento de insertar datos "+ e.getMessage());

        }
       
    }//GEN-LAST:event_btnEjecutarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConexionOrigen;
    public static javax.swing.JButton btnCrearETL;
    private javax.swing.JButton btnEjecutar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public static javax.swing.JList<String> jListaHechos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    public static javax.swing.JList<String> jlsListaDimensiones;
    // End of variables declaration//GEN-END:variables
}
