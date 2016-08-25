/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import espotify.Datatypes.DataClienteExt;
import espotify.Fabrica;
import espotify.Interfaces.IConsultaCliente;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 *
 * @author Santiago
 */
public class ConsultaCliente extends javax.swing.JInternalFrame {

    /**
     * Creates new form ConsultaCliente
     */
    public ConsultaCliente() {
        initComponents();
        IConsultaCliente interf = Fabrica.getIConsultaCliente();
        String[] a = interf.DevolverClientes();
        for(String str : a) {
            Select.addItem(str);
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

        Conteiner4 = new javax.swing.JPanel();
        Select = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        SeguidosList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        ListasList = new javax.swing.JList<>();
        NombreText = new javax.swing.JLabel();
        ApellidoText = new javax.swing.JLabel();
        CorreoText = new javax.swing.JLabel();
        FechaText = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setClosable(true);

        Select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectActionPerformed(evt);
            }
        });

        jLabel1.setText("Seleccione un Cliente:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Apellido:");

        jLabel4.setText("Correo:");

        jLabel5.setText("Fecha Nacimiento:");

        jLabel6.setText("Sigue a:");

        jLabel7.setText("Listas:");

        jScrollPane1.setViewportView(SeguidosList);

        jScrollPane2.setViewportView(ListasList);

        NombreText.setText("      ");

        ApellidoText.setText("   ");

        CorreoText.setText("       ");

        FechaText.setText("    ");

        jLabel8.setText(" ");

        javax.swing.GroupLayout Conteiner4Layout = new javax.swing.GroupLayout(Conteiner4);
        Conteiner4.setLayout(Conteiner4Layout);
        Conteiner4Layout.setHorizontalGroup(
            Conteiner4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Conteiner4Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(Conteiner4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Conteiner4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(FechaText))
                    .addGroup(Conteiner4Layout.createSequentialGroup()
                        .addGroup(Conteiner4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(31, 31, 31)
                        .addGroup(Conteiner4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NombreText)
                            .addComponent(ApellidoText)
                            .addComponent(CorreoText)))
                    .addComponent(jLabel1)
                    .addComponent(Select, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Conteiner4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(103, 103, Short.MAX_VALUE)
                .addGroup(Conteiner4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Conteiner4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(130, Short.MAX_VALUE))
        );
        Conteiner4Layout.setVerticalGroup(
            Conteiner4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Conteiner4Layout.createSequentialGroup()
                .addGroup(Conteiner4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Conteiner4Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(Select, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addGroup(Conteiner4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(NombreText))
                        .addGap(23, 23, 23)
                        .addGroup(Conteiner4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(ApellidoText))
                        .addGap(18, 18, 18)
                        .addGroup(Conteiner4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(CorreoText))
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Conteiner4Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(Conteiner4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(FechaText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(Conteiner4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Conteiner4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel6))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Conteiner4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Conteiner4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectActionPerformed
        // TODO add your handling code here:
        String usr = String.valueOf(Select.getSelectedItem());
        IConsultaCliente interf = Fabrica.getIConsultaCliente();
        DataClienteExt dc = interf.ConsultaCliente(usr);
        NombreText.setText(dc.getNombre());
        ApellidoText.setText(dc.getApellido());
        CorreoText.setText(dc.getCorreo());
        Calendar fn = dc.getfNac();
        String fecha = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        if (fn != null){
            fecha = sdf.format(fn.getTime());
        }
        FechaText.setText(fecha);
        String[] b = dc.getSeguidos();
        SeguidosList.clearSelection();
        SeguidosList.setListData(b);
        String[] c = dc.getListas();
        ListasList.clearSelection();
        ListasList.setListData(c);
        BufferedImage image = dc.getImg();
        jLabel8.removeAll();
        if (image != null){
            ImageIcon img = new ImageIcon(image);
            jLabel8.setIcon(img);
            jLabel8.setVisible(true);
        }else{
            jLabel8.setText("El usuario NO tiene imagen");
            jLabel8.setVisible(false);
        }   
    }//GEN-LAST:event_SelectActionPerformed

    
    /*
            String nick = ListBox.getName();
        DataClienteExt dc = interface.ConsultaCliente(nick);
    */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ApellidoText;
    private javax.swing.JPanel Conteiner4;
    private javax.swing.JLabel CorreoText;
    private javax.swing.JLabel FechaText;
    private javax.swing.JList<String> ListasList;
    private javax.swing.JLabel NombreText;
    private javax.swing.JList<String> SeguidosList;
    private javax.swing.JComboBox<String> Select;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}