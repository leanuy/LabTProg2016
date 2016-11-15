/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import espotify.Fabrica;
import espotify.datatypes.DataAlbumExt;
import espotify.datatypes.DataArtistaExt;
import espotify.datatypes.DataTema;
import espotify.interfaces.IVerEliminados;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author JavierM42
 */
public class VerArtistasEliminados extends javax.swing.JInternalFrame {

    IVerEliminados interf = Fabrica.getIVerEliminados();

    /**
     * Creates new form VerArtistasEliminados
     */
    public VerArtistasEliminados() {
        initComponents();
        List<String> artistas = interf.cargarArtistasEliminados();
        for (String str : artistas) {
            nickArtistasCmb.addItem(str);
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

        nickArtistasCmb = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        ApellidoText = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        CorreoText = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        FechaText = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        UrlText = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AlbumsList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        NombreText = new javax.swing.JLabel();
        CantidadSeguidoresText = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TemasList = new javax.swing.JList<>();
        jLabel7 = new javax.swing.JLabel();
        VerAlbumBtn = new javax.swing.JButton();

        setClosable(true);

        nickArtistasCmb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                nickArtistasCmbItemStateChanged(evt);
            }
        });
        nickArtistasCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nickArtistasCmbActionPerformed(evt);
            }
        });

        jLabel1.setText("Seleccione un Artista eliminado:");

        ApellidoText.setText("      ");

        jLabel2.setText("Nombre:");

        CorreoText.setText("      ");

        jLabel3.setText("Apellido:");

        FechaText.setText("    ");

        jLabel4.setText("Correo:");

        UrlText.setText("     ");

        jLabel5.setText("Fecha Nacimiento:");

        jScrollPane1.setViewportView(AlbumsList);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jLabel6.setText("Albums:");

        jLabel8.setText("URL:");

        jLabel9.setText("Bio:");

        NombreText.setText("        ");

        jScrollPane3.setViewportView(TemasList);

        jLabel7.setText("Temas del Album:");

        VerAlbumBtn.setText("Ver Temas");
        VerAlbumBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerAlbumBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(UrlText))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(36, 36, 36))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3))
                                        .addGap(26, 26, 26)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ApellidoText)
                                    .addComponent(NombreText)
                                    .addComponent(CorreoText)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(FechaText))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nickArtistasCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(VerAlbumBtn))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CantidadSeguidoresText, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(732, 732, 732))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nickArtistasCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NombreText)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ApellidoText)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CorreoText)
                    .addComponent(jLabel4))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FechaText)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(46, 46, 46))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(UrlText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(38, 38, 38)
                        .addComponent(CantidadSeguidoresText, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(VerAlbumBtn)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nickArtistasCmbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_nickArtistasCmbItemStateChanged
        
    }//GEN-LAST:event_nickArtistasCmbItemStateChanged

    private void nickArtistasCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nickArtistasCmbActionPerformed
        String usr = String.valueOf(nickArtistasCmb.getSelectedItem());
        DataArtistaExt dArt;
        dArt = interf.consultaArtistaEliminado(usr);
        NombreText.setText(dArt.getNombre());
        ApellidoText.setText(dArt.getApellido());
        CorreoText.setText(dArt.getCorreo());
        jTextArea1.setText(dArt.getBio());
        UrlText.setText(dArt.getUrl());
        Calendar fechaNacimiento = dArt.getfNac();
        String fecha = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        if (fechaNacimiento != null) {
            fecha = sdf.format(fechaNacimiento.getTime());
        }
        FechaText.setText(fecha);
        String[] albums = dArt.getAlbums();
        AlbumsList.clearSelection();
        AlbumsList.setListData(albums);
        TemasList.removeAll();
    }//GEN-LAST:event_nickArtistasCmbActionPerformed

    private void VerAlbumBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerAlbumBtnActionPerformed
        String usr = String.valueOf(nickArtistasCmb.getSelectedItem());
        String alb = AlbumsList.getSelectedValue();
        List<String> temas;
        temas = interf.consultaTemasAlbumEliminado(usr,alb);
        
        DefaultListModel model = new DefaultListModel();
        for (String t : temas) {
            model.addElement(t);
        }
        TemasList.removeAll();
        TemasList.setModel(model);
    }//GEN-LAST:event_VerAlbumBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> AlbumsList;
    private javax.swing.JLabel ApellidoText;
    private javax.swing.JLabel CantidadSeguidoresText;
    private javax.swing.JLabel CorreoText;
    private javax.swing.JLabel FechaText;
    private javax.swing.JLabel NombreText;
    private javax.swing.JList<String> TemasList;
    private javax.swing.JLabel UrlText;
    private javax.swing.JButton VerAlbumBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JComboBox<String> nickArtistasCmb;
    // End of variables declaration//GEN-END:variables
}
