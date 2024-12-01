/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import clases.DTO.CampoDTO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class AsignacionesMapeo extends javax.swing.JFrame {
    public static DefaultListModel<String> listModelOrigen = new DefaultListModel<>();
    public static DefaultListModel<String> listModelDestino = new DefaultListModel<>();
    /**
     * Creates new form AsignacionesMapeo
     */
    public AsignacionesMapeo() {
        initComponents();
         //Si no se selecciono campos
                 DefaultComboBoxModel camposOrigen =new DefaultComboBoxModel();
                 DefaultComboBoxModel camposDestino = new DefaultComboBoxModel();
                 
                 
            try{
                if(FormularioETL.camposSelectOrigen.isEmpty()){
                      int i = 0;

                        for (CampoDTO campoO : MenuPrincipal.campos) {

                             camposOrigen.addElement(campoO.getColumnName()+" "+campoO.getDataType()
                                     +" "+campoO.getMaxLength());
                            i++;
                        }
                //Si se seleciono campos
                }else{
                      int i = 0;

                        for (CampoDTO campoO2 : FormularioETL.camposSelectOrigen) {

                             camposOrigen.addElement(campoO2.getColumnName()+" "+campoO2.getDataType()
                                     +" "+campoO2.getMaxLength());
                            i++;
                        }
                }
                this.cmbCamposOrigen.setModel(camposOrigen);
                
                
                int j = 0;

                for (CampoDTO campoDestino : FormularioETL.camposSelectDestino) {

                     camposDestino.addElement(campoDestino.getColumnName()+" "+campoDestino.getDataType()
                             +" "+campoDestino.getMaxLength());
                    j++;
                }
                
                this.cmbCamposDestino.setModel(camposDestino);
                
                if(listModelOrigen.isEmpty()){
                    FormularioETL.camposSelectOrigenOrden.clear();
                }
                if(listModelDestino.isEmpty()){
                    FormularioETL.camposSelectDestinoOrden.clear();
                }
            }catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Succedio un error inesperado " + e.getMessage());

                    
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
        cmbCamposOrigen = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jslCamposOrigenOrden = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jlsCamposDestinoOrder = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        cmbCamposDestino = new javax.swing.JComboBox<>();
        btnGuardarMapeo = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnAsignarMapeo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MAPEO DE DATOS");
        setBackground(new java.awt.Color(204, 255, 255));
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel1.setText("Campos Origen:");

        cmbCamposOrigen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbCamposOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCamposOrigenActionPerformed(evt);
            }
        });

        jslCamposOrigenOrden.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jslCamposOrigenOrden.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jslCamposOrigenOrden);

        jlsCamposDestinoOrder.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlsCamposDestinoOrder.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jlsCamposDestinoOrder);

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel2.setText("Campos Destino");

        cmbCamposDestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnGuardarMapeo.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        btnGuardarMapeo.setText("Confirmar Mapeo");
        btnGuardarMapeo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarMapeoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel3.setText("Columna de Entrada(Origen)");

        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel4.setText("Columna de Destino");

        jLabel5.setFont(new java.awt.Font("Bernard MT Condensed", 0, 36)); // NOI18N
        jLabel5.setText("MAPEO DE DATOS(ASIGNACIONES)");

        btnAsignarMapeo.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        btnAsignarMapeo.setText("Asignar");
        btnAsignarMapeo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarMapeoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(365, 365, 365)
                        .addComponent(btnGuardarMapeo, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(396, 396, 396)
                        .addComponent(btnAsignarMapeo, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(cmbCamposOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(cmbCamposDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbCamposOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cmbCamposDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(btnAsignarMapeo)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(btnGuardarMapeo)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAsignarMapeoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarMapeoActionPerformed
        CampoDTO camposO = new CampoDTO();
        CampoDTO camposD = new CampoDTO();
        
        // Obtener el elemento seleccionado del JComboBox
        String selectedItemOrigen = (String) cmbCamposOrigen.getSelectedItem();
        String selectedItemDestino = (String) cmbCamposDestino.getSelectedItem();
        int indexCampoOrigen = cmbCamposOrigen.getSelectedIndex();
        int indexCampoDestino = cmbCamposDestino.getSelectedIndex();
        boolean existeListaOrigen = false;
        boolean existeListaDestino  = false;  
        String elementoDestino;
        String elementoOrigen;
        
        
        
        if(FormularioETL.camposSelectOrigen.isEmpty()){
            camposO = MenuPrincipal.campos.get(indexCampoOrigen);
            camposD = FormularioETL.camposSelectDestino.get(indexCampoDestino);
          
        //Si se seleciono campos
        }else{
            camposO = FormularioETL.camposSelectOrigen.get(cmbCamposOrigen.getSelectedIndex());
             camposD = FormularioETL.camposSelectDestino.get(indexCampoDestino);
        }
        
        
          
            //Averiguamos si en el campo seleccionado del origen fueron transformado;
              if(camposO.getColumnName().equals(camposO.getColumnNameConvert()) ){
                    if((camposO.getDataType().equals( camposD.getDataType())) && ((camposO.getMaxLength())<= (camposD.getMaxLength()))){
                             elementoOrigen = camposO.getColumnName() + " " +
                             camposO.getDataType() + " " +
                             camposO.getMaxLength();
                            
                             elementoDestino = camposD.getColumnName() + " " +
                              camposD.getDataType() + " " +
                               camposD.getMaxLength();
                            for (int i = 0; i < listModelOrigen.getSize(); i++) {
                                if (listModelOrigen.get(i).equals(elementoOrigen)) {
                                    existeListaOrigen = true;
                                    break;
                                }
                            }
                            
                            for (int i = 0; i < listModelDestino.getSize(); i++) {
                                if (listModelDestino.get(i).equals(elementoDestino)) {
                                    existeListaDestino = true;
                                    break;
                                }
                            }

                            if (selectedItemOrigen != null && selectedItemDestino!=null) {
                                if(!existeListaOrigen && !existeListaDestino){                                
                                    listModelOrigen.addElement(elementoOrigen); // Agregar al modelo de la lista
                                    listModelDestino.addElement(elementoDestino);
                                    jslCamposOrigenOrden.setModel(listModelOrigen);
                                    jlsCamposDestinoOrder.setModel(listModelDestino);
                                    
                                    FormularioETL.camposSelectOrigenOrden.add(camposO);
                                    FormularioETL.camposSelectDestinoOrden.add(camposD);
                                        // Depuración para ArrayList camposDestino
           
                                }else{
                                    JOptionPane.showMessageDialog(this, "Ya mapeo esos campo");

                                }  
                            } 
                    }else{
                         JOptionPane.showMessageDialog(this, "Error al mapea, revise que ambos campos tenga el mismo tipo de datos o que tenga la misma o menor tamaño(Longitud)");    
                   }         
                    
              }else{
                  if(camposO.getDataType().equals(camposD.getDataType()) && (camposO.getMaxLeghtConvert()<= camposD.getMaxLength())){
                      elementoOrigen = camposO.getAlias()+ " " + 
                             camposO.getDataType() + " " +
                             camposO.getMaxLeghtConvert();
                            
                             elementoDestino = camposD.getColumnName() + " " +
                              camposD.getDataType() + " " +
                               camposD.getMaxLength();
                            for (int i = 0; i < listModelOrigen.getSize(); i++) {
                                if (listModelOrigen.get(i).equals(elementoOrigen)) {
                                    existeListaOrigen = true;
                                    break;
                                }
                            }
                            
                            for (int i = 0; i < listModelDestino.getSize(); i++) {
                                if (listModelDestino.get(i).equals(elementoDestino)) {
                                    existeListaDestino = true;
                                    break;
                                }
                            }

                            if (selectedItemOrigen != null && selectedItemDestino!=null) {
                                if(!existeListaOrigen && !existeListaDestino){                                
                                    listModelOrigen.addElement(elementoOrigen); // Agregar al modelo de la lista
                                    listModelDestino.addElement(elementoDestino);
                                    jslCamposOrigenOrden.setModel(listModelOrigen);
                                    jlsCamposDestinoOrder.setModel(listModelDestino);
                                    
                                    FormularioETL.camposSelectOrigenOrden.add(camposO);
                                    FormularioETL.camposSelectDestinoOrden.add(camposD);
                                        // Depuración para ArrayList camposDestino
           
                                }else{
                                    JOptionPane.showMessageDialog(this, "Ya mapeo esos campo");

                                }  
                            } 
                   }else{
                        JOptionPane.showMessageDialog(this, "Error al mapea, revise que ambos campos tenga el mismo tipo de datos o que tenga la misma o menor tamaño(Longitud)");    
 
                  }
              }
             

    }//GEN-LAST:event_btnAsignarMapeoActionPerformed

    private void cmbCamposOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCamposOrigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCamposOrigenActionPerformed

    private void btnGuardarMapeoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarMapeoActionPerformed
        
        if((FormularioETL.camposSelectDestinoOrden.size() < FormularioETL.camposSelectDestino.size())){
            JOptionPane.showMessageDialog(this, "Antes, debes mapea todos los campos del destino");    

        }else{ // Aqui cuando todos los campos esta mapeando, creamos COnfirmamos el mapeo
            
             for (int i = 0; i < FormularioETL.camposSelectOrigenOrden.size(); i++) {
                 if(FormularioETL.camposSelectOrigenOrden.get(i).getColumnName().equals(FormularioETL.camposSelectOrigenOrden.get(i).getColumnNameConvert())){
                      FormularioETL.camposSelectOrigenOrdenFinal.add(FormularioETL.camposSelectOrigenOrden.get(i).getColumnName());
                 }else{
                    FormularioETL.camposSelectOrigenOrdenFinal.add(FormularioETL.camposSelectOrigenOrden.get(i).getColumnNameConvert());

                 }
                   
             }
             for (int i = 0; i < FormularioETL.camposSelectDestinoOrden.size(); i++) {
                FormularioETL.camposSelectDestinoOrdenFinal.add(FormularioETL.camposSelectDestinoOrden.get(i).getColumnName());
             }
             
             // MenuPrincipal.CamposOrigenSelecTFinal.add(FormularioETL.camposSelectOrigenOrdenFinal);
                  // Depuración para ArrayList camposDestino
            System.out.println("Campos de destino: " + (FormularioETL.camposSelectDestinoOrdenFinal != null ? FormularioETL.camposSelectDestinoOrdenFinal.toString() : "Lista vacía o nula"));
    
        // Depuración para ArrayList camposOrigen
        System.out.println("Campos de origen: " + (FormularioETL.camposSelectOrigenOrdenFinal != null ? FormularioETL.camposSelectOrigenOrdenFinal.toString() : "Lista vacía o nula"));
            JOptionPane.showMessageDialog(this, "Guardado mapeo");    
            FormularioETL.btnCrearETL.setEnabled(true);
            dispose();
        }

    }//GEN-LAST:event_btnGuardarMapeoActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAsignarMapeo;
    private javax.swing.JButton btnGuardarMapeo;
    private javax.swing.JComboBox<String> cmbCamposDestino;
    private javax.swing.JComboBox<String> cmbCamposOrigen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> jlsCamposDestinoOrder;
    private javax.swing.JList<String> jslCamposOrigenOrden;
    // End of variables declaration//GEN-END:variables
}
