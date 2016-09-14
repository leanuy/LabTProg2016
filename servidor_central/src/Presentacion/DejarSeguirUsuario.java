package Presentacion;

import espotify.Excepciones.ClienteInexistenteException;
import espotify.Excepciones.SeguidoInexistenteException;
import espotify.Excepciones.SeguidorInexistenteException;
import espotify.Fabrica;
import espotify.Interfaces.IDejarDeSeguir;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Santiago
 */
public class DejarSeguirUsuario extends javax.swing.JInternalFrame {

    IDejarDeSeguir interf = Fabrica.getIDejarDeSeguir();

    public DejarSeguirUsuario() {
        initComponents();
        List<String> cl = interf.ListarClientes();

        for(String str : cl) {
            NickSeguidor.addItem(str);NickSeguido.addItem(str);
        }
    }

    String Seguido;
    String Seguidor;
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Conteiner3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        DejarButton = new javax.swing.JButton();
        NickSeguidor = new javax.swing.JComboBox<String>();
        NickSeguido = new javax.swing.JComboBox<String>();

        setClosable(true);
        setTitle("Dejar de seguir Usuario");

        jLabel1.setText("Nick usuario:");

        jLabel2.setText("Nick del usuario a dejar de seguir:");

        DejarButton.setText("Dejar de Seguir");
        DejarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DejarButtonActionPerformed(evt);
            }
        });

        NickSeguidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NickSeguidorActionPerformed(evt);
            }
        });

        NickSeguido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NickSeguidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Conteiner3Layout = new javax.swing.GroupLayout(Conteiner3);
        Conteiner3.setLayout(Conteiner3Layout);
        Conteiner3Layout.setHorizontalGroup(
            Conteiner3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Conteiner3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(Conteiner3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGroup(Conteiner3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Conteiner3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(DejarButton)
                        .addContainerGap(217, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Conteiner3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(Conteiner3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(NickSeguido, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NickSeguidor, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(157, 157, 157))))
        );
        Conteiner3Layout.setVerticalGroup(
            Conteiner3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Conteiner3Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(Conteiner3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(NickSeguidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(Conteiner3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(NickSeguido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addComponent(DejarButton)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 628, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Conteiner3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 344, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(Conteiner3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 2, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DejarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DejarButtonActionPerformed
        // TODO add your handling code here:
        if (Seguidor.isEmpty() || Seguido.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "No se ingreso el nick de al menos un usuario",
                    "ATENCION", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                interf.DejarDeSeguir(Seguidor,Seguido);
                JOptionPane.showMessageDialog(this,
                        "Operación completada con éxito.",
                        "OK", JOptionPane.PLAIN_MESSAGE);
            } catch (SeguidoInexistenteException e) {
                JOptionPane.showMessageDialog(this,
                        "El usuario a dejar de seguir no existe o no era seguido por el seguidor.",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            catch (SeguidorInexistenteException e) {
                JOptionPane.showMessageDialog(this,
                        "El usuario seguidor no existe", "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        Seguidor = String.valueOf(NickSeguidor.getSelectedItem());
        String[] seguid=null;
        try {
            seguid = interf.getSeguidos(Seguidor);
        } catch (ClienteInexistenteException ex) {
            Logger.getLogger(DejarSeguirUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        NickSeguido.removeAllItems();
        for(String stri : seguid) {
            NickSeguido.addItem(stri);
        }
    }//GEN-LAST:event_DejarButtonActionPerformed

    private void NickSeguidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NickSeguidorActionPerformed
        // TODO add your handling code here:
        Seguidor = String.valueOf(NickSeguidor.getSelectedItem());
        String[] seguid=null;
        try {
            seguid = interf.getSeguidos(Seguidor);
        } catch (ClienteInexistenteException ex) {
            Logger.getLogger(DejarSeguirUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        NickSeguido.removeAllItems();
        for(String stri : seguid) {
            NickSeguido.addItem(stri);
        }
    }//GEN-LAST:event_NickSeguidorActionPerformed

    private void NickSeguidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NickSeguidoActionPerformed
        // TODO add your handling code here:
        Seguido = String.valueOf(NickSeguido.getSelectedItem());
    }//GEN-LAST:event_NickSeguidoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Conteiner3;
    private javax.swing.JButton DejarButton;
    private javax.swing.JComboBox<String> NickSeguido;
    private javax.swing.JComboBox<String> NickSeguidor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
