/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

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
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);
        this.internalAltaPerfil.setSize(1422, 800);
        this.internalAltaPerfil.setVisible(false);
        this.setTitle("ESPOTIFY");
        this.internalAltaAlbum.setSize(1422, 800);
        this.internalAltaAlbum.setVisible(false);
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
        jMenuBar1 = new javax.swing.JMenuBar();
        SesionDropDown = new javax.swing.JMenu();
        cerrarOption = new javax.swing.JMenuItem();
        AltasDropDown = new javax.swing.JMenu();
        AltaPerfil = new javax.swing.JMenuItem();
        AltaAlbum = new javax.swing.JMenuItem();
        ConsultasDropDown = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 200, 700));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(3200, 1800));
        getContentPane().setLayout(new javax.swing.OverlayLayout(getContentPane()));

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
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(internalAltaAlbum);

        internalAltaPerfil.setClosable(true);
        internalAltaPerfil.setResizable(true);
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(internalAltaPerfil);
        try {
            internalAltaPerfil.setMaximum(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }

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

        AltaAlbum.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        AltaAlbum.setText("Alta Album");
        AltaAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AltaAlbumActionPerformed(evt);
            }
        });
        AltasDropDown.add(AltaAlbum);

        jMenuBar1.add(AltasDropDown);

        ConsultasDropDown.setText("Consultas");
        jMenuBar1.add(ConsultasDropDown);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cerrarOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarOptionActionPerformed
        this.dispose();
    }//GEN-LAST:event_cerrarOptionActionPerformed

    private void AltaPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AltaPerfilActionPerformed
        this.internalAltaPerfil.setVisible(true);
    }//GEN-LAST:event_AltaPerfilActionPerformed

    private void AltaAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AltaAlbumActionPerformed
        this.internalAltaAlbum.setVisible(true);
    }//GEN-LAST:event_AltaAlbumActionPerformed

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
    private javax.swing.JMenu ConsultasDropDown;
    private javax.swing.JMenu SesionDropDown;
    private javax.swing.JMenuItem cerrarOption;
    private javax.swing.JInternalFrame internalAltaAlbum;
    private javax.swing.JInternalFrame internalAltaPerfil;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
