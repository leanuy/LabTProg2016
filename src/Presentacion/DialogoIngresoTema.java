/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author leandro
 */
public class DialogoIngresoTema extends javax.swing.JDialog {

    private String pathATema; 
    private File selectedFile;
    
    /**
     * Creates new form DialogoIngresoTema
     */
    public DialogoIngresoTema(java.awt.Frame parent,String tittle,boolean modal) {
        super(parent, modal);
        initComponents();
        URLdelTema.setEnabled(false);
        URLaTemaRadioButton.setSelected(false);
        this.setTitle(tittle);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelIngresoTemas = new javax.swing.JPanel();
        URLaTemaRadioButton = new javax.swing.JRadioButton();
        URLdelTema = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        AceptarButton = new javax.swing.JButton();
        CancelarButton = new javax.swing.JButton();
        NombreTema = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        PathLocal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        ExaminarButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        DuracionTextField = new javax.swing.JTextField();

        URLaTemaRadioButton.setText("Ingresar link al tema");
        URLaTemaRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                URLaTemaRadioButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("URL:");

        AceptarButton.setText("Aceptar");
        AceptarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarButtonActionPerformed(evt);
            }
        });

        CancelarButton.setText("Cancelar");
        CancelarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre del Tema");

        jLabel3.setText("Path local");

        ExaminarButton.setText("Examinar");
        ExaminarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExaminarButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("Duracion");

        javax.swing.GroupLayout PanelIngresoTemasLayout = new javax.swing.GroupLayout(PanelIngresoTemas);
        PanelIngresoTemas.setLayout(PanelIngresoTemasLayout);
        PanelIngresoTemasLayout.setHorizontalGroup(
            PanelIngresoTemasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelIngresoTemasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelIngresoTemasLayout.createSequentialGroup()
                    .addGap(0, 23, Short.MAX_VALUE)
                    .addGroup(PanelIngresoTemasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(PanelIngresoTemasLayout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(NombreTema, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PanelIngresoTemasLayout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(PathLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(ExaminarButton)
                    .addGap(50, 50, 50))
                .addGroup(PanelIngresoTemasLayout.createSequentialGroup()
                    .addGap(77, 77, 77)
                    .addComponent(jLabel4)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(DuracionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(PanelIngresoTemasLayout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addGroup(PanelIngresoTemasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(URLaTemaRadioButton)
                        .addGroup(PanelIngresoTemasLayout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(URLdelTema)
                            .addGap(141, 141, 141)))))
            .addGroup(PanelIngresoTemasLayout.createSequentialGroup()
                .addGap(240, 240, 240)
                .addComponent(AceptarButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CancelarButton)
                .addGap(14, 14, 14))
        );
        PanelIngresoTemasLayout.setVerticalGroup(
            PanelIngresoTemasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelIngresoTemasLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(PanelIngresoTemasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NombreTema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelIngresoTemasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(DuracionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(PanelIngresoTemasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PathLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(ExaminarButton))
                .addGap(12, 12, 12)
                .addComponent(URLaTemaRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelIngresoTemasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(URLdelTema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(PanelIngresoTemasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AceptarButton)
                    .addComponent(CancelarButton))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelIngresoTemas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelIngresoTemas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void URLaTemaRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_URLaTemaRadioButtonActionPerformed
        if(URLaTemaRadioButton.isSelected()){
            URLdelTema.setEnabled(true);
            PathLocal.setEnabled(false);
        }else{
            URLdelTema.setEnabled(false);
            PathLocal.setEnabled(true);
        }
    }//GEN-LAST:event_URLaTemaRadioButtonActionPerformed

    private void CancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_CancelarButtonActionPerformed

    private void AceptarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarButtonActionPerformed
        int duration = 0;
        try{
            duration = Integer.parseInt(DuracionTextField.getText());
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Duracion invalida", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if("".equals(NombreTema.getText())){
            JOptionPane.showMessageDialog(this, "Nombre de tema vacio", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(URLaTemaRadioButton.isSelected()){
            if("".equals(URLdelTema.getText())){
                JOptionPane.showMessageDialog(this, "Link al tema vacio", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            AltaAlbum.cargarTema(true,URLdelTema.getText(),null,NombreTema.getText(), duration);
            this.dispose();
        }else{
            if("".equals(PathLocal.getText())){
                JOptionPane.showMessageDialog(this, "Cargue un tema", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            AltaAlbum.cargarTema(false,"",selectedFile,NombreTema.getText(), duration);
            this.dispose();
        }
    }//GEN-LAST:event_AceptarButtonActionPerformed

    private void ExaminarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExaminarButtonActionPerformed
        JFileChooser fc = new JFileChooser();
        this.getContentPane().add(fc);
        fc.setVisible(true);
        
        int selected = fc.showDialog(this, "Seleccionar");
        if(selected == JFileChooser.APPROVE_OPTION){
            File file = fc.getSelectedFile();
            try {
                pathATema = file.getCanonicalPath();
                String ext = getExtension(file);
                if(!"mp3".equals(ext)){
                    JOptionPane.showMessageDialog(this, "Debe seleccionar un archivo formato .mp3", "Error", JOptionPane.ERROR_MESSAGE);
                    fc.setVisible(false);
                    return;
                }
                PathLocal.setText(pathATema);
                selectedFile = file;
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "La ruta al archivo no es correcta", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        fc.setVisible(false);
    }//GEN-LAST:event_ExaminarButtonActionPerformed

    private String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');
        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AceptarButton;
    private javax.swing.JButton CancelarButton;
    private javax.swing.JTextField DuracionTextField;
    private javax.swing.JButton ExaminarButton;
    private javax.swing.JTextField NombreTema;
    private javax.swing.JPanel PanelIngresoTemas;
    private javax.swing.JTextField PathLocal;
    private javax.swing.JRadioButton URLaTemaRadioButton;
    private javax.swing.JTextField URLdelTema;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
