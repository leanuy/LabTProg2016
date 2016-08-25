/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 *
 * @author leandro
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        this.setSize((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()), (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()));
        
        
        //MainPanel.setLayout(new FlowLayout());
        this.setLocationRelativeTo(null);
        this.setTitle("ESPOTIFY");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        internalAltaAlbum = new javax.swing.JInternalFrame();
        internalAltaPerfil = new javax.swing.JInternalFrame();
        AltaPerfil_nickname_label = new javax.swing.JLabel();
        AltaPerfil_nickname_input = new javax.swing.JTextField();
        AltaPerfil_nombre_label = new javax.swing.JLabel();
        AltaPerfil_nombre_input = new javax.swing.JTextField();
        AltaPerfil_apellido_label = new javax.swing.JLabel();
        AltaPerfil_apellido_input = new javax.swing.JTextField();
        AltaPerfil_email_label = new javax.swing.JLabel();
        AltaPerfil_email_input = new javax.swing.JTextField();
        AltaPerfil_fechanacimiento_label = new javax.swing.JLabel();
        AltaPerfil_tipousuario_label = new javax.swing.JLabel();
        AltaPerfil_tipousuario_input = new javax.swing.JComboBox<>();
        AltaPerfil_botonimagen_button = new javax.swing.JButton();
        AltaPerfil_url_label = new javax.swing.JLabel();
        AltaPerfil_url_input = new javax.swing.JTextField();
        AltaPerfil_bio_label = new javax.swing.JLabel();
        AltaPerfil_bio_container = new javax.swing.JScrollPane();
        AltaPerfil_bio_input = new javax.swing.JTextArea();
        MainPanel = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        SesionDropDown = new javax.swing.JMenu();
        cerrarOption = new javax.swing.JMenuItem();
        AltasDropDown = new javax.swing.JMenu();
        AltaPerfil = new javax.swing.JMenuItem();
        AltaGeneroMItem = new javax.swing.JMenuItem();
        AltaAlbum = new javax.swing.JMenuItem();
        AltaLista = new javax.swing.JMenuItem();
        ConsultasDropDown = new javax.swing.JMenu();
        ConsultaClienteMI = new javax.swing.JMenuItem();
        ConsultaArtistaMI = new javax.swing.JMenuItem();
        ConsultaAlbumMenuItem = new javax.swing.JMenuItem();
        SocialMenu = new javax.swing.JMenu();
        SeguirMItem = new javax.swing.JMenuItem();
        DejarSeguirMItem = new javax.swing.JMenuItem();
        ListasMenu = new javax.swing.JMenu();
        PublicarListaMItem = new javax.swing.JMenuItem();

        internalAltaAlbum.setBorder(null);
        internalAltaAlbum.setClosable(true);
        internalAltaAlbum.setTitle("Alta Album");
        internalAltaAlbum.setVisible(true);

        javax.swing.GroupLayout internalAltaAlbumLayout = new javax.swing.GroupLayout(internalAltaAlbum.getContentPane());
        internalAltaAlbum.getContentPane().setLayout(internalAltaAlbumLayout);
        internalAltaAlbumLayout.setHorizontalGroup(
            internalAltaAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 669, Short.MAX_VALUE)
        );
        internalAltaAlbumLayout.setVerticalGroup(
            internalAltaAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 231, Short.MAX_VALUE)
        );

        internalAltaPerfil.setClosable(true);
        internalAltaPerfil.setTitle("Alta Perfil");
        internalAltaPerfil.setToolTipText("");
        internalAltaPerfil.setPreferredSize(new java.awt.Dimension(1422, 800));
        try {
            internalAltaPerfil.setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        internalAltaPerfil.setVisible(true);

        AltaPerfil_nickname_label.setText("Nickname");

        AltaPerfil_nombre_label.setText("Nombre");

        AltaPerfil_apellido_label.setText("Apellido");

        AltaPerfil_email_label.setText("Email");

        AltaPerfil_fechanacimiento_label.setText("Fecha de nacimiento");

        AltaPerfil_tipousuario_label.setText("Tipo de Usuario");

        AltaPerfil_tipousuario_input.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cliente", "Artista" }));

        AltaPerfil_botonimagen_button.setText("Elegir imágen de perfil");

        AltaPerfil_url_label.setText("Página web");

        AltaPerfil_bio_label.setText("Bio");

        AltaPerfil_bio_input.setColumns(20);
        AltaPerfil_bio_input.setRows(5);
        AltaPerfil_bio_container.setViewportView(AltaPerfil_bio_input);

        javax.swing.GroupLayout internalAltaPerfilLayout = new javax.swing.GroupLayout(internalAltaPerfil.getContentPane());
        internalAltaPerfil.getContentPane().setLayout(internalAltaPerfilLayout);
        internalAltaPerfilLayout.setHorizontalGroup(
            internalAltaPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, internalAltaPerfilLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(internalAltaPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AltaPerfil_fechanacimiento_label)
                    .addComponent(AltaPerfil_botonimagen_button)
                    .addGroup(internalAltaPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, internalAltaPerfilLayout.createSequentialGroup()
                            .addGroup(internalAltaPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(AltaPerfil_nombre_label)
                                .addComponent(AltaPerfil_nickname_label)
                                .addComponent(AltaPerfil_apellido_label)
                                .addComponent(AltaPerfil_email_label)
                                .addComponent(AltaPerfil_tipousuario_label))
                            .addGap(62, 62, 62)
                            .addGroup(internalAltaPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(internalAltaPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(AltaPerfil_nombre_input, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(AltaPerfil_nickname_input, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(internalAltaPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(AltaPerfil_apellido_input)
                                        .addComponent(AltaPerfil_email_input, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(AltaPerfil_tipousuario_input, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(internalAltaPerfilLayout.createSequentialGroup()
                            .addGroup(internalAltaPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(AltaPerfil_url_label)
                                .addComponent(AltaPerfil_bio_label))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(internalAltaPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(AltaPerfil_url_input, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                                .addComponent(AltaPerfil_bio_container)))))
                .addGap(274, 274, 274))
        );
        internalAltaPerfilLayout.setVerticalGroup(
            internalAltaPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(internalAltaPerfilLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(internalAltaPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AltaPerfil_nickname_label)
                    .addComponent(AltaPerfil_nickname_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(internalAltaPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AltaPerfil_nombre_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AltaPerfil_nombre_label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(internalAltaPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AltaPerfil_apellido_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AltaPerfil_apellido_label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(internalAltaPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AltaPerfil_email_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AltaPerfil_email_label))
                .addGap(18, 18, 18)
                .addComponent(AltaPerfil_fechanacimiento_label)
                .addGap(25, 25, 25)
                .addGroup(internalAltaPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AltaPerfil_tipousuario_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AltaPerfil_tipousuario_label))
                .addGap(18, 18, 18)
                .addComponent(AltaPerfil_botonimagen_button)
                .addGap(18, 18, 18)
                .addGroup(internalAltaPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AltaPerfil_url_label)
                    .addComponent(AltaPerfil_url_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(internalAltaPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AltaPerfil_bio_container, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AltaPerfil_bio_label))
                .addContainerGap(97, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 200, 700));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new javax.swing.OverlayLayout(getContentPane()));

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 669, Short.MAX_VALUE)
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 409, Short.MAX_VALUE)
        );

        getContentPane().add(MainPanel);

        SesionDropDown.setText("Sesion");

        cerrarOption.setText("Cerrar");
        cerrarOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarOptionActionPerformed(evt);
            }
        });
        SesionDropDown.add(cerrarOption);

        jMenuBar1.add(SesionDropDown);

        AltasDropDown.setText("Altas");

        AltaPerfil.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        AltaPerfil.setText("Alta Perfil");
        AltaPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AltaPerfilActionPerformed(evt);
            }
        });
        AltasDropDown.add(AltaPerfil);

        AltaGeneroMItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        AltaGeneroMItem.setText("Alta Género");
        AltaGeneroMItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AltaGeneroMItemActionPerformed(evt);
            }
        });
        AltasDropDown.add(AltaGeneroMItem);

        AltaAlbum.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        AltaAlbum.setText("Alta Album");
        AltaAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AltaAlbumActionPerformed(evt);
            }
        });
        AltasDropDown.add(AltaAlbum);

        AltaLista.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        AltaLista.setText("Alta Lista");
        AltaLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AltaListaActionPerformed(evt);
            }
        });
        AltasDropDown.add(AltaLista);

        jMenuBar1.add(AltasDropDown);

        ConsultasDropDown.setText("Consultas");

        ConsultaClienteMI.setText("Consulta perfil Cliente");
        ConsultaClienteMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultaClienteMIActionPerformed(evt);
            }
        });
        ConsultasDropDown.add(ConsultaClienteMI);

        ConsultaArtistaMI.setText("Consulta perfil Artista");
        ConsultaArtistaMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultaArtistaMIActionPerformed(evt);
            }
        });
        ConsultasDropDown.add(ConsultaArtistaMI);

        ConsultaAlbumMenuItem.setText("Consulta Album");
        ConsultaAlbumMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultaAlbumMenuItemActionPerformed(evt);
            }
        });
        ConsultasDropDown.add(ConsultaAlbumMenuItem);

        jMenuBar1.add(ConsultasDropDown);

        SocialMenu.setText("Social");

        SeguirMItem.setText("Seguir Usuario");
        SeguirMItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeguirMItemActionPerformed(evt);
            }
        });
        SocialMenu.add(SeguirMItem);

        DejarSeguirMItem.setText("Dejar de Seguir Usuario");
        DejarSeguirMItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DejarSeguirMItemActionPerformed(evt);
            }
        });
        SocialMenu.add(DejarSeguirMItem);

        jMenuBar1.add(SocialMenu);

        ListasMenu.setText("Listas");

        PublicarListaMItem.setText("Publicar Lista");
        PublicarListaMItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PublicarListaMItemActionPerformed(evt);
            }
        });
        ListasMenu.add(PublicarListaMItem);

        jMenuBar1.add(ListasMenu);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cerrarOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarOptionActionPerformed
        this.dispose();
    }//GEN-LAST:event_cerrarOptionActionPerformed

    private void AltaPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AltaPerfilActionPerformed
        internalAltaPerfil frameAltaPerfil = new internalAltaPerfil();
        MainPanel.add(frameAltaPerfil);
        frameAltaPerfil.setVisible(true);
        
    }//GEN-LAST:event_AltaPerfilActionPerformed

    private void AltaAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AltaAlbumActionPerformed
        AltaAlbum album = new AltaAlbum();
        //album.setLocation((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth())/2, (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight())/2);
        MainPanel.add(album);
        //ver que agregar y hacer visible
        album.setVisible(true);
    }//GEN-LAST:event_AltaAlbumActionPerformed

    private void SeguirMItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeguirMItemActionPerformed
        SeguirUsuario seguir = new SeguirUsuario();
        MainPanel.add(seguir);
        seguir.setVisible(true);
    }//GEN-LAST:event_SeguirMItemActionPerformed

    private void DejarSeguirMItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DejarSeguirMItemActionPerformed
        DejarSeguirUsuario dejar = new DejarSeguirUsuario();
        MainPanel.add(dejar);
        dejar.setVisible(true);
    }//GEN-LAST:event_DejarSeguirMItemActionPerformed

    private void ConsultaClienteMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultaClienteMIActionPerformed
        ConsultaCliente cons = new ConsultaCliente();
        MainPanel.add(cons);
        cons.setVisible(true);
    }//GEN-LAST:event_ConsultaClienteMIActionPerformed

    private void ConsultaArtistaMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultaArtistaMIActionPerformed
        ConsultaArtista art = new ConsultaArtista();
        MainPanel.add(art);
        art.setVisible(true);
    }//GEN-LAST:event_ConsultaArtistaMIActionPerformed

    private void AltaListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AltaListaActionPerformed
        AltaLista frameAltaLista = new AltaLista();
        MainPanel.add(frameAltaLista);
        frameAltaLista.setVisible(true);
    }//GEN-LAST:event_AltaListaActionPerformed

    private void PublicarListaMItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PublicarListaMItemActionPerformed
        PublicarLista framePublicarLista = new PublicarLista();
        MainPanel.add(framePublicarLista);
        framePublicarLista.setVisible(true);    }//GEN-LAST:event_PublicarListaMItemActionPerformed

    private void ConsultaAlbumMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultaAlbumMenuItemActionPerformed
            Object[] options = {"Artista","Genero"};
            int opcion = JOptionPane.showOptionDialog(this, "Desea consultar album por Artista o por Genero?","Elija una opcion", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,null,options,options[0]);
            if(opcion == 0 ){
               ConsultaAlbumPorArtista consAlbArt = new ConsultaAlbumPorArtista();
               MainPanel.add(consAlbArt);
               consAlbArt.setVisible(true);
            }else{
               ConsultaAlbumPorGenero consAlbGen = new ConsultaAlbumPorGenero();
               MainPanel.add(consAlbGen);
               consAlbGen.setVisible(true);
            }
    }//GEN-LAST:event_ConsultaAlbumMenuItemActionPerformed

    private void AltaGeneroMItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AltaGeneroMItemActionPerformed
        AltaGenero frameAltaGenero = new AltaGenero();
        MainPanel.add(frameAltaGenero);
        frameAltaGenero.setVisible(true);
    }//GEN-LAST:event_AltaGeneroMItemActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AltaAlbum;
    private javax.swing.JMenuItem AltaGeneroMItem;
    private javax.swing.JMenuItem AltaLista;
    private javax.swing.JMenuItem AltaPerfil;
    private javax.swing.JTextField AltaPerfil_apellido_input;
    private javax.swing.JLabel AltaPerfil_apellido_label;
    private javax.swing.JScrollPane AltaPerfil_bio_container;
    private javax.swing.JTextArea AltaPerfil_bio_input;
    private javax.swing.JLabel AltaPerfil_bio_label;
    private javax.swing.JButton AltaPerfil_botonimagen_button;
    private javax.swing.JTextField AltaPerfil_email_input;
    private javax.swing.JLabel AltaPerfil_email_label;
    private javax.swing.JLabel AltaPerfil_fechanacimiento_label;
    private javax.swing.JTextField AltaPerfil_nickname_input;
    private javax.swing.JLabel AltaPerfil_nickname_label;
    private javax.swing.JTextField AltaPerfil_nombre_input;
    private javax.swing.JLabel AltaPerfil_nombre_label;
    private javax.swing.JComboBox<String> AltaPerfil_tipousuario_input;
    private javax.swing.JLabel AltaPerfil_tipousuario_label;
    private javax.swing.JTextField AltaPerfil_url_input;
    private javax.swing.JLabel AltaPerfil_url_label;
    private javax.swing.JMenu AltasDropDown;
    private javax.swing.JMenuItem ConsultaAlbumMenuItem;
    private javax.swing.JMenuItem ConsultaArtistaMI;
    private javax.swing.JMenuItem ConsultaClienteMI;
    private javax.swing.JMenu ConsultasDropDown;
    private javax.swing.JMenuItem DejarSeguirMItem;
    private javax.swing.JMenu ListasMenu;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JMenuItem PublicarListaMItem;
    private javax.swing.JMenuItem SeguirMItem;
    private javax.swing.JMenu SesionDropDown;
    private javax.swing.JMenu SocialMenu;
    private javax.swing.JMenuItem cerrarOption;
    private javax.swing.JInternalFrame internalAltaAlbum;
    private javax.swing.JInternalFrame internalAltaPerfil;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
