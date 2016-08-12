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
        this.setSize(1600, 900);
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

        internalAltaPerfil = new javax.swing.JInternalFrame();
        internalAltaAlbum = new javax.swing.JInternalFrame();
        jMenuBar1 = new javax.swing.JMenuBar();
        SesionDropDown = new javax.swing.JMenu();
        cerrarOption = new javax.swing.JMenuItem();
        AltasDropDown = new javax.swing.JMenu();
        AltaPerfil = new javax.swing.JMenuItem();
        AltaAlbum = new javax.swing.JMenuItem();
        ConsultasDropDown = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        internalAltaPerfil.setClosable(true);
        internalAltaPerfil.setIconifiable(true);
        internalAltaPerfil.setMaximizable(true);
        internalAltaPerfil.setTitle("Alta Perfil");
        internalAltaPerfil.setToolTipText("");
        internalAltaPerfil.setPreferredSize(new java.awt.Dimension(1422, 800));
        try {
            internalAltaPerfil.setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        internalAltaPerfil.setVisible(true);

        javax.swing.GroupLayout internalAltaPerfilLayout = new javax.swing.GroupLayout(internalAltaPerfil.getContentPane());
        internalAltaPerfil.getContentPane().setLayout(internalAltaPerfilLayout);
        internalAltaPerfilLayout.setHorizontalGroup(
            internalAltaPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1420, Short.MAX_VALUE)
        );
        internalAltaPerfilLayout.setVerticalGroup(
            internalAltaPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 778, Short.MAX_VALUE)
        );

        internalAltaAlbum.setTitle("Alta Album");
        internalAltaAlbum.setVisible(true);

        javax.swing.GroupLayout internalAltaAlbumLayout = new javax.swing.GroupLayout(internalAltaAlbum.getContentPane());
        internalAltaAlbum.getContentPane().setLayout(internalAltaAlbumLayout);
        internalAltaAlbumLayout.setHorizontalGroup(
            internalAltaAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 214, Short.MAX_VALUE)
        );
        internalAltaAlbumLayout.setVerticalGroup(
            internalAltaAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 55, Short.MAX_VALUE)
        );

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

        AltaPerfil.setText("Alta Perfil");
        AltaPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AltaPerfilActionPerformed(evt);
            }
        });
        AltasDropDown.add(AltaPerfil);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(internalAltaAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(internalAltaPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(internalAltaAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(internalAltaPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        try {
            internalAltaPerfil.setMaximum(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }

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
    private javax.swing.JMenu AltasDropDown;
    private javax.swing.JMenu ConsultasDropDown;
    private javax.swing.JMenu SesionDropDown;
    private javax.swing.JMenuItem cerrarOption;
    private javax.swing.JInternalFrame internalAltaAlbum;
    private javax.swing.JInternalFrame internalAltaPerfil;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
