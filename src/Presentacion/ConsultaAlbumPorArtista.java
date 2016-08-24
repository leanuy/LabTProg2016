/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import espotify.Datatypes.DataAlbumExt;
import espotify.Fabrica;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author leandro
 */
public class ConsultaAlbumPorArtista extends javax.swing.JInternalFrame {

    /**
     * Creates new form ConsultaAlbumPorArtista
     */
    private DefaultListModel modelito;
    private DefaultListModel modelitoAlbums;
    
    public ConsultaAlbumPorArtista() {
        initComponents();
        //this.setSize(900,800);
        modelito = new DefaultListModel();
        ListaArtistas.setModel(modelito);
        modelitoAlbums = new DefaultListModel();
        ListaAlbunesArtista.setModel(modelitoAlbums);
//        IConsultaAlbum inter = Fabrica.getIConsultaAlbum();
//        ArrayList<String> artists = null;
//        try{
//            artists = inter.ListarArtistas();
//            for(String s : artists){
//                modelito.addElement(s);
//            }
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(this, e.getMessage(), "Atencion!!!", JOptionPane.WARNING_MESSAGE);
//        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ConsultaAlbumXArtPanel = new javax.swing.JPanel();
        LabelNombreArtista = new javax.swing.JLabel();
        TraerAlbumsButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaAlbunesArtista = new javax.swing.JList<>();
        ConsultaAlbumButton = new javax.swing.JButton();
        SalirButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ListaArtistas = new javax.swing.JList<>();

        setClosable(true);
        setTitle("Consulta Album Por Artista");

        LabelNombreArtista.setText("Artistas");

        TraerAlbumsButton.setText("Seleccionar Artista");
        TraerAlbumsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TraerAlbumsButtonActionPerformed(evt);
            }
        });

        ListaAlbunesArtista.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(ListaAlbunesArtista);

        ConsultaAlbumButton.setText("Consultar Album");
        ConsultaAlbumButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultaAlbumButtonActionPerformed(evt);
            }
        });

        SalirButton.setText("Salir");
        SalirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Albums");

        jScrollPane2.setViewportView(ListaArtistas);

        javax.swing.GroupLayout ConsultaAlbumXArtPanelLayout = new javax.swing.GroupLayout(ConsultaAlbumXArtPanel);
        ConsultaAlbumXArtPanel.setLayout(ConsultaAlbumXArtPanelLayout);
        ConsultaAlbumXArtPanelLayout.setHorizontalGroup(
            ConsultaAlbumXArtPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConsultaAlbumXArtPanelLayout.createSequentialGroup()
                .addGroup(ConsultaAlbumXArtPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ConsultaAlbumXArtPanelLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(ConsultaAlbumXArtPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(LabelNombreArtista)))
                    .addGroup(ConsultaAlbumXArtPanelLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(ConsultaAlbumXArtPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(ConsultaAlbumXArtPanelLayout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TraerAlbumsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(36, 36, 36)
                .addGroup(ConsultaAlbumXArtPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SalirButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ConsultaAlbumButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        ConsultaAlbumXArtPanelLayout.setVerticalGroup(
            ConsultaAlbumXArtPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConsultaAlbumXArtPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelNombreArtista)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ConsultaAlbumXArtPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TraerAlbumsButton))
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ConsultaAlbumXArtPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(ConsultaAlbumXArtPanelLayout.createSequentialGroup()
                        .addComponent(ConsultaAlbumButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SalirButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ConsultaAlbumXArtPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ConsultaAlbumXArtPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TraerAlbumsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TraerAlbumsButtonActionPerformed
//        IConsultaAlbum inter = Fabrica.getIConsultaAlbum();
//        ArrayList<DataAlbumExt> dataAlbums = null;
//        try{
//            dataAlbums = inter.ListarAlbumesDeArtista();
//            for(DataAlbumExt d : dataAlbums){
//                modelitoAlbums.addElement(d.getNombre());
//            } 
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(this, e.getMessage(), "Atencion!!!", JOptionPane.WARNING_MESSAGE);
//        }
    }//GEN-LAST:event_TraerAlbumsButtonActionPerformed

    private void SalirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_SalirButtonActionPerformed

    private void ConsultaAlbumButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultaAlbumButtonActionPerformed
//        IConsultaAlbum inter = Fabrica.getIConsultaAlbum();
//        DataAlbumExt dataAlbum = null;
//        String nomAlbum = null;
//        int[] opciones;
//        try{
//            opciones = ListaAlbunesArtista.getSelectedIndices();
//            if(opciones.length != 1){
//                JOptionPane.showMessageDialog(this, "Debe seleccionar un solo album", "Atencion!!!", JOptionPane.ERROR_MESSAGE);
//                this.dispose();
//            }
//            nomAlbum = (String)modelitoAlbums.getElementAt(ListaAlbunesArtista.getSelectedIndex());
//            dataAlbum = inter.ConsultaAlbum(nomAlbum);
//            //llamar otro frame y mandarle el dataalbum
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(this, e.getMessage(), "Atencion!!!", JOptionPane.WARNING_MESSAGE);
//        }
    }//GEN-LAST:event_ConsultaAlbumButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ConsultaAlbumButton;
    private javax.swing.JPanel ConsultaAlbumXArtPanel;
    private javax.swing.JLabel LabelNombreArtista;
    private javax.swing.JList<String> ListaAlbunesArtista;
    private javax.swing.JList<String> ListaArtistas;
    private javax.swing.JButton SalirButton;
    private javax.swing.JButton TraerAlbumsButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
