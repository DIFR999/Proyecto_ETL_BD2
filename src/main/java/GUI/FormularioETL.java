/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import clases.CamposPorTablaConsulta;
import clases.DTO.CampoDTO;
import clases.DTO.ConexionDTO;
import clases.ExtracionDatosOrigen;
import clases.IngresarDatosDestino;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class FormularioETL extends javax.swing.JFrame {
    
    //ESTRUCTURAR PARA OBTENER LAS TABLAS DE ORIGEN
    public static ExtracionDatosOrigen tablasPorConexion = new ExtracionDatosOrigen();
    public static ArrayList<String> tablas = new ArrayList<String>();
    public static ArrayList<CampoDTO> camposSelectOrigen = new ArrayList<CampoDTO>();
    
    
        //ESTRUCTURAR PARA OBTENER LAS TABLAS DE DESTINO
    public static ExtracionDatosOrigen tablasPorConexionDestino = new ExtracionDatosOrigen();
    public static ArrayList<String> tablasDestino = new ArrayList<String>();
    public static ArrayList<CampoDTO> camposSelectDestino = new ArrayList<CampoDTO>();
    
    
    //EStructura en order de los campos(Mapeo)
      // CREAMOS LA ESTRUCTURA PARA OBTENER LOS CAMPOS DE LA TABLA ORIGEN
        public static CamposPorTablaConsulta camposPorTablaDestino = new CamposPorTablaConsulta();
        public static ArrayList<CampoDTO> camposSelectOrigenOrden = new ArrayList<CampoDTO>();

        public static ArrayList<CampoDTO> camposSelectDestinoOrden = new ArrayList<CampoDTO>();
        
        //Lista de campos ya pasado por todo el procesod en ETL;
        public static ArrayList<String> camposSelectDestinoOrdenFinal = new ArrayList<String>();
        public static ArrayList<String> camposSelectOrigenOrdenFinal = new ArrayList<String>();


     //Variables globales
     public static String tablaSeleccionada;
     public static String tablaDEstinoSeleccionada;
     public static String Consulta;
     public static String tipoT;
     public static String NombreETL=null;
     
     
    /**
     * Creates new form FormularioETL
     */
    public FormularioETL() {
        initComponents();
      
           
        cmbTablas.setEnabled(true);
        txaConsultaSQL.setEnabled(false);
        cmbTablas.setEnabled(false);
        btnEscogerCampos.setEnabled(false);
        btnTransformar.setEnabled(false);
        btnAsignacionesCampos.setEnabled(false);
        btnCrearETL.setEnabled(false);
        
        if(MenuPrincipal.conexiones.isEmpty()){
             btnAgregarConexionDestino.setEnabled(false);
        }else{
             btnAgregarConexionDestino.setEnabled(true);
        }
       
        
        String tiposT[] = {"Dimension","Hecho"};
          int inputCb;
          JComboBox tipoTabla = new JComboBox(tiposT);
          
          
            inputCb = JOptionPane.showConfirmDialog(this, tipoTabla, "Seleccione el tipo de tabla que sera el ETL:", 
                           JOptionPane.DEFAULT_OPTION);
            
            if(inputCb == JOptionPane.OK_OPTION){
                 tipoT = (String) tipoTabla.getSelectedItem();   
            }
            
            NombreETL = JOptionPane.showInputDialog("Ingrese un nombre al ETL:");
            
            if(NombreETL==null){
                if(tiposT.equals("Dimension")){
                    NombreETL = "Tabla de Dimensión "+ (String.valueOf((MenuPrincipal.InserccionesETL.size()+1)));
                }else if(tiposT.equals("Hecho")){
                    NombreETL = "Tabla de Hecho "+ (String.valueOf((MenuPrincipal.InserccionesETL.size()+1)));
                }
                
            }
    }
    
   
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
                new FormularioETL().setVisible(true);
            }
        });
    }
    public void LimpiarVariables(){
        camposSelectOrigen.clear();
        camposSelectDestino.clear();
        camposSelectOrigenOrden.clear();
        camposSelectDestinoOrden.clear();
        camposSelectDestinoOrdenFinal.clear();
        camposSelectOrigenOrdenFinal.clear();
        MenuPrincipal.campos.clear();
 
        cmbTablas.removeAllItems();
        cmbTablasDestino.removeAllItems();
        txaConsultaSQL.setText("");
                
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgrTipoExtraccion = new javax.swing.ButtonGroup();
        jToggleButton1 = new javax.swing.JToggleButton();
        pnlExtracion = new javax.swing.JPanel();
        jrbTabla = new javax.swing.JRadioButton();
        jrbConsulta = new javax.swing.JRadioButton();
        cmbTablas = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaConsultaSQL = new javax.swing.JTextArea();
        btnExtraerBD = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        btnEscogerCampos = new javax.swing.JButton();
        pnlDataConversion = new javax.swing.JPanel();
        btnTransformar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblUsuarioBaseDestion = new javax.swing.JLabel();
        txtBaseDestino = new javax.swing.JTextField();
        btnAgregarConexionDestino = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cmbTablasDestino = new javax.swing.JComboBox<>();
        btnAsignacionesCampos = new javax.swing.JButton();
        btnCrearETL = new javax.swing.JButton();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ETL");

        pnlExtracion.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "EXTRACCIÓN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Gloucester MT Extra Condensed", 0, 18))); // NOI18N

        bgrTipoExtraccion.add(jrbTabla);
        jrbTabla.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jrbTabla.setText("Tabla:");
        jrbTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbTablaActionPerformed(evt);
            }
        });

        bgrTipoExtraccion.add(jrbConsulta);
        jrbConsulta.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jrbConsulta.setText("Consulta:");
        jrbConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbConsultaActionPerformed(evt);
            }
        });

        cmbTablas.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        cmbTablas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTablasActionPerformed(evt);
            }
        });

        txaConsultaSQL.setColumns(20);
        txaConsultaSQL.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txaConsultaSQL.setRows(5);
        jScrollPane1.setViewportView(txaConsultaSQL);

        btnExtraerBD.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnExtraerBD.setText("Extraer Datos");
        btnExtraerBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExtraerBDActionPerformed(evt);
            }
        });

        btnEscogerCampos.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        btnEscogerCampos.setText("ESCOGER CAMPOS");
        btnEscogerCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEscogerCamposActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlExtracionLayout = new javax.swing.GroupLayout(pnlExtracion);
        pnlExtracion.setLayout(pnlExtracionLayout);
        pnlExtracionLayout.setHorizontalGroup(
            pnlExtracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlExtracionLayout.createSequentialGroup()
                .addGroup(pnlExtracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlExtracionLayout.createSequentialGroup()
                        .addGroup(pnlExtracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jrbConsulta)
                            .addComponent(jrbTabla))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlExtracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbTablas, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlExtracionLayout.createSequentialGroup()
                                .addGroup(pnlExtracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnEscogerCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 783, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnExtraerBD, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlExtracionLayout.createSequentialGroup()
                        .addGap(892, 892, 892)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlExtracionLayout.setVerticalGroup(
            pnlExtracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlExtracionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlExtracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrbTabla)
                    .addComponent(cmbTablas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlExtracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlExtracionLayout.createSequentialGroup()
                        .addGroup(pnlExtracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlExtracionLayout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(jrbConsulta))
                            .addGroup(pnlExtracionLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlExtracionLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExtraerBD, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)))
                .addComponent(btnEscogerCampos)
                .addGap(1, 1, 1)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlDataConversion.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "TRANSFORMACIÓN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Gloucester MT Extra Condensed", 0, 18))); // NOI18N

        btnTransformar.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        btnTransformar.setText("Transformar campos");
        btnTransformar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransformarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDataConversionLayout = new javax.swing.GroupLayout(pnlDataConversion);
        pnlDataConversion.setLayout(pnlDataConversionLayout);
        pnlDataConversionLayout.setHorizontalGroup(
            pnlDataConversionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDataConversionLayout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addComponent(btnTransformar, javax.swing.GroupLayout.PREFERRED_SIZE, 957, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        pnlDataConversionLayout.setVerticalGroup(
            pnlDataConversionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDataConversionLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btnTransformar)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "CARGA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Gloucester MT Extra Condensed", 0, 18))); // NOI18N

        lblUsuarioBaseDestion.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        lblUsuarioBaseDestion.setText("Data Destination");

        txtBaseDestino.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtBaseDestino.setEnabled(false);

        btnAgregarConexionDestino.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        btnAgregarConexionDestino.setText("Agregar Conexion Data Destination");
        btnAgregarConexionDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarConexionDestinoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel1.setText("Tabla Destino:");

        cmbTablasDestino.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbTablasDestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbTablasDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTablasDestinoActionPerformed(evt);
            }
        });

        btnAsignacionesCampos.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        btnAsignacionesCampos.setText("Asignaciones Campos(Mapear)");
        btnAsignacionesCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignacionesCamposActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblUsuarioBaseDestion)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtBaseDestino)
                    .addComponent(cmbTablasDestino, 0, 433, Short.MAX_VALUE))
                .addGap(39, 39, 39)
                .addComponent(btnAgregarConexionDestino)
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAsignacionesCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(263, 263, 263))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuarioBaseDestion)
                    .addComponent(txtBaseDestino)
                    .addComponent(btnAgregarConexionDestino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTablasDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(btnAsignacionesCampos)
                .addContainerGap())
        );

        btnCrearETL.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        btnCrearETL.setText("Ejecutar ETL");
        btnCrearETL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearETLActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(pnlDataConversion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pnlExtracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCrearETL, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(395, 395, 395))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(pnlExtracion, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDataConversion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCrearETL, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jrbTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbTablaActionPerformed
         cmbTablas.setEnabled(true);  // Habilitar cmbTablas
         txaConsultaSQL.setEnabled(false);  // Deshabilitar txaConsultaSQL
         txaConsultaSQL.setText("");
         cmbTablas.removeAllItems();
         btnCrearETL.setEnabled(false);
         FormularioETL.camposSelectOrigen.clear();
         btnTransformar.setEnabled(false);
         try{
                this.tablas = tablasPorConexion.obtenerTablas(MenuPrincipal.ConexionOrigen.getUsername(),CredecialesConexion.conOrigen);

                // MOSTRAMOS LA LISTA DE TABLAS QUE EL SCHEMA POSEE

                 DefaultComboBoxModel modelTablas =new DefaultComboBoxModel();
            
                  int i = 0;
                      modelTablas.addElement("Selecciona una tabla");
                for (String tabla : tablas) {
                       modelTablas.addElement(tablas.get(i).toString());
                        i++;
                }
                
                this.cmbTablas.setModel(modelTablas);
        }catch  (Exception e){
            JOptionPane.showMessageDialog(this, "No se pudo establecer conexion con las tablas ." + e.getMessage());

        }
         
         
         
         
    }//GEN-LAST:event_jrbTablaActionPerformed

    private void cmbTablasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTablasActionPerformed
     
    }//GEN-LAST:event_cmbTablasActionPerformed

    private void jrbConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbConsultaActionPerformed
        cmbTablas.setEnabled(false);  // Deshabilitar cmbTablas
        txaConsultaSQL.setEnabled(true);  // Habilitar txaConsultaSQL
        cmbTablas.removeAllItems();
         FormularioETL.camposSelectOrigen.clear();
         btnTransformar.setEnabled(false);
        
    }//GEN-LAST:event_jrbConsultaActionPerformed

    private void btnExtraerBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExtraerBDActionPerformed
        if(jrbTabla.isSelected()==true){  
            if(cmbTablas.getSelectedItem().toString()=="Selecciona una tabla"){
                JOptionPane.showMessageDialog(this, "Seleccione una tabla");
            }
            else{
               MenuPrincipal.campos = MenuPrincipal.camposPorTabla.obtenerCampos(CredecialesConexion.conOrigen, cmbTablas.getSelectedItem().toString());
               tablaSeleccionada= cmbTablas.getSelectedItem().toString();
               btnEscogerCampos.setEnabled(true);
               btnTransformar.setEnabled(true);
                MenuPrincipal.fromTable = true;

            }
         }else if(jrbConsulta.isSelected()==true){
            try {	
                String consultaSQL =txaConsultaSQL.getText().replaceAll("\\s+", " ").trim();
                Consulta = consultaSQL;
                MenuPrincipal.campos = MenuPrincipal.camposPorTabla.obtenerCamposConsulta(CredecialesConexion.conOrigen, consultaSQL);
                if(txaConsultaSQL.getText()==null ||txaConsultaSQL.getText().isEmpty() ){
                    JOptionPane.showMessageDialog(null, "El campo de consulta SQL está vacío. Por favor, ingresa una consulta.", "Advertencia", JOptionPane.WARNING_MESSAGE);

                }
                else{
                    if (MenuPrincipal.campos != null) {
                        JOptionPane.showMessageDialog(this, "La consulta es correcta");
                        btnEscogerCampos.setEnabled(true);
                          btnTransformar.setEnabled(true);
                           Consulta = txaConsultaSQL.getText().replaceAll("\\s+"," ").trim();
                            MenuPrincipal.fromTable = false;
                    } else {
                        JOptionPane.showMessageDialog(this, "La consulta no produjo resultados válidos. Intente nuevamente.");

                    }
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al ejecutar la consulta: "+e.getMessage() );

            }
              
        }else if(jrbTabla.isSelected()==false &&jrbConsulta.isSelected()==false ){
            JOptionPane.showMessageDialog(this, "Eligar una opcion para extraer los datos, ya sea por tabla o consulta");

        }
              
          
    }//GEN-LAST:event_btnExtraerBDActionPerformed

    private void btnEscogerCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEscogerCamposActionPerformed
        FrmEscogerCampos frmEscogerC = new FrmEscogerCampos();      
        frmEscogerC.setLocationRelativeTo(this);  // Centra la ventana con respecto a la ventana principal
        frmEscogerC.setVisible(true);  // Mostrar la ventana
    }//GEN-LAST:event_btnEscogerCamposActionPerformed

    private void btnTransformarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransformarActionPerformed
            DataConversion dataConversionFRM = new DataConversion();      
            dataConversionFRM.setLocationRelativeTo(this);  // Centra la ventana con respecto a la ventana principal
            dataConversionFRM.setVisible(true);  // Mostrar la ventana
    }//GEN-LAST:event_btnTransformarActionPerformed

    private void btnAgregarConexionDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarConexionDestinoActionPerformed
        if(MenuPrincipal.UserAdministrador.isEmpty()){
            JOptionPane.showMessageDialog(this, "No hay conexiones, verifique si ha anadido la credenciales de administrador");

        }else{
           
            ConexionDestino guiConexionDestino = new ConexionDestino();      
            guiConexionDestino.setLocationRelativeTo(this);  // Centra la ventana con respecto a la ventana principal
            guiConexionDestino.setVisible(true);  // Mostrar la ventana
           
            
        }        
    }//GEN-LAST:event_btnAgregarConexionDestinoActionPerformed

    private void btnAsignacionesCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignacionesCamposActionPerformed
        if(cmbTablasDestino.getSelectedItem().equals("Selecciona una tabla")) {
            JOptionPane.showMessageDialog(this, "Seleccione una tabla de destino");
        }else{
            try{
                
                tablaDEstinoSeleccionada = cmbTablasDestino.getSelectedItem().toString();
                camposSelectDestino = camposPorTablaDestino.obtenerCampos(ConexionDestino.conDestino, cmbTablasDestino.getSelectedItem().toString());
                AsignacionesMapeo frmMapeo = new AsignacionesMapeo();      
                frmMapeo.setLocationRelativeTo(this);  // Centra la ventana con respecto a la ventana principal
                frmMapeo.setVisible(true);  // Mostrar la ventana
                                                   
            }catch (Exception e){
                    JOptionPane.showMessageDialog(this, "Sucedio un error inesperado al momento de obtener los campos de la tabla de destino: "+ e.getMessage());

            }
        } 
            
       
    }//GEN-LAST:event_btnAsignacionesCamposActionPerformed

    private void cmbTablasDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTablasDestinoActionPerformed
    }//GEN-LAST:event_cmbTablasDestinoActionPerformed

    private void btnCrearETLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearETLActionPerformed
          IngresarDatosDestino CrearInsercion = new IngresarDatosDestino();
          ArrayList<String> fila = new ArrayList<>();
          ArrayList<String> filaCampos = new ArrayList<>();
          String CosultaInsert;
          
          
        try {
            
            
           
           // JOptionPane.showMessageDialog(this, "Sucedio un error inesperado al momento de obtener los campos de la tabla de destino: ");
            if(jrbTabla.isSelected()){
                CosultaInsert = CrearInsercion.prepararInsercion(CredecialesConexion.conOrigen, camposSelectDestinoOrdenFinal, 
                camposSelectOrigenOrdenFinal, tablaSeleccionada, tablaDEstinoSeleccionada, true);
                JOptionPane.showMessageDialog(this, "Se creo correctamente el ETL");
                fila.add(tipoT);
                fila.add(NombreETL);
                fila.add(tablaSeleccionada);
                fila.add(CosultaInsert);
                MenuPrincipal.InserccionesETL.add(fila);
                filaCampos.add(camposSelectOrigenOrdenFinal.toString());
                MenuPrincipal.camposSelectOrigenETL.add(filaCampos);
                

                
                
               
            }else {
                
                CosultaInsert = CrearInsercion.prepararInsercion(CredecialesConexion.conOrigen,camposSelectDestinoOrdenFinal, 
                camposSelectOrigenOrdenFinal, Consulta, tablaDEstinoSeleccionada, false);
     JOptionPane.showMessageDialog(this, "Se creo correctamente el ETL");                fila.add(tipoT);
                fila.add(NombreETL);
                fila.add(Consulta);
                fila.add(CosultaInsert);
                MenuPrincipal.InserccionesETL.add(fila);
                                filaCampos.add(camposSelectOrigenOrdenFinal.toString());

                MenuPrincipal.camposSelectOrigenETL.add(filaCampos);
                System.out.println("Campos de origen: " + (MenuPrincipal.camposSelectOrigenETL.get(0) != null ? MenuPrincipal.camposSelectOrigenETL.get(0).toString() : "Lista vacía o nula"));


               
                
                
                 
            }
            
            if(tipoT.equals("Dimension")){
                 MenuPrincipal.listDimensiones.addElement(NombreETL);
                 MenuPrincipal.jlsListaDimensiones.setModel(MenuPrincipal.listDimensiones);
            }else{
                 MenuPrincipal.listHechos.addElement(NombreETL);
                 MenuPrincipal.jListaHechos.setModel(MenuPrincipal.listHechos);
            }
           dispose();
           
             //inputCb = JOptionPane.showConfirmDialog(this,tipoTabla, "Seleccione un tipo",JOptionPane.DEFAULT_OPTION);
            
             
            
             
             /*if(inputCb == JOptionPane.OK_OPTION){
                 String 
             }*/

        }catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Sucedio un error inesperado al momento de crear el ETL: "+ e.getMessage());


        }
    }//GEN-LAST:event_btnCrearETLActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgrTipoExtraccion;
    public static javax.swing.JButton btnAgregarConexionDestino;
    public static javax.swing.JButton btnAsignacionesCampos;
    public static javax.swing.JButton btnCrearETL;
    private javax.swing.JButton btnEscogerCampos;
    private javax.swing.JButton btnExtraerBD;
    private javax.swing.JButton btnTransformar;
    private javax.swing.JComboBox<String> cmbTablas;
    public static javax.swing.JComboBox<String> cmbTablasDestino;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToggleButton jToggleButton1;
    public static javax.swing.JRadioButton jrbConsulta;
    public static javax.swing.JRadioButton jrbTabla;
    private javax.swing.JLabel lblUsuarioBaseDestion;
    private javax.swing.JPanel pnlDataConversion;
    private javax.swing.JPanel pnlExtracion;
    private javax.swing.JTextArea txaConsultaSQL;
    public static javax.swing.JTextField txtBaseDestino;
    // End of variables declaration//GEN-END:variables
}
