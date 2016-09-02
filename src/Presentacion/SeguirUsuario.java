/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;
import espotify.Excepciones.AutoSeguirseException;
import espotify.Excepciones.SeguidoInexistenteException;
import espotify.Excepciones.SeguidoRepetidoException;
import espotify.Excepciones.SeguidorInexistenteException;
import espotify.Fabrica;
import espotify.Interfaces.IAltaSeguir;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class SeguirUsuario extends javax.swing.JInternalFrame {

    IAltaSeguir interf;
    /**
     * Creates new form SeguirUsuario
     */
    public SeguirUsuario() {
        initComponents();
        interf = Fabrica.getIAltaSeguir();
        ArrayList<String>cl = interf.ListarClientes();
        for(String str : cl) {
            NickSeguidor.addItem(str);
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

        conteiner = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        SeguirButton = new javax.swing.JButton();
        NickSeguidor = new javax.swing.JComboBox<>();
        NickSeguido = new javax.swing.JComboBox<>();

        setClosable(true);

        jLabel1.setText("Nick usuario:");

        jLabel2.setText("Nick del usuario a Seguir:");

        SeguirButton.setText("Seguir");
        SeguirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeguirButtonActionPerformed(evt);
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

        javax.swing.GroupLayout conteinerLayout = new javax.swing.GroupLayout(conteiner);
        conteiner.setLayout(conteinerLayout);
        conteinerLayout.setHorizontalGroup(
            conteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(conteinerLayout.createSequentialGroup()
                .addGroup(conteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(conteinerLayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(conteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(48, 48, 48)
                        .addGroup(conteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NickSeguido, 0, 123, Short.MAX_VALUE)
                            .addComponent(NickSeguidor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(conteinerLayout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(SeguirButton)))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        conteinerLayout.setVerticalGroup(
            conteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(conteinerLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(conteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(NickSeguidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(conteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(NickSeguido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(SeguirButton)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 488, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(conteiner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 276, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(conteiner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SeguirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeguirButtonActionPerformed
        if (Seguidor.isEmpty() || Seguido.isEmpty()){
            JOptionPane.showMessageDialog(this, "No se ingreso el nick de al menos un usuario", "ATENCION", JOptionPane.WARNING_MESSAGE);
        }else{
            try
            {
            interf.AltaSeguir(Seguidor,Seguido);
            JOptionPane.showMessageDialog(this, "Operación completada con éxito.", "OK", JOptionPane.PLAIN_MESSAGE);
            }
            catch (SeguidorInexistenteException e){
                JOptionPane.showMessageDialog(this, "El usuario que quiere seguir no existe.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            catch (SeguidoInexistenteException e){
                JOptionPane.showMessageDialog(this, "El usuario a seguir no existe.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            catch (SeguidoRepetidoException e){
                JOptionPane.showMessageDialog(this, "El seguidor ya sigue a este usuario", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            catch (AutoSeguirseException e){
                JOptionPane.showMessageDialog(this, "Un usuario no puede seguirse a sí mismo.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_SeguirButtonActionPerformed

    private void NickSeguidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NickSeguidorActionPerformed
        Seguidor = String.valueOf(NickSeguidor.getSelectedItem());
        NickSeguido.removeAllItems();
        try {
            ArrayList<String> ar = interf.ListarSeguibles(Seguidor);
            for(String stri : ar) {
                NickSeguido.addItem(stri);
            }
        } catch (SeguidorInexistenteException e){
                JOptionPane.showMessageDialog(this, "El usuario que quiere seguir no existe.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_NickSeguidorActionPerformed

    private void NickSeguidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NickSeguidoActionPerformed
        // TODO add your handling code here:
        Seguido = String.valueOf(NickSeguido.getSelectedItem());
    }//GEN-LAST:event_NickSeguidoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> NickSeguido;
    private javax.swing.JComboBox<String> NickSeguidor;
    private javax.swing.JButton SeguirButton;
    private javax.swing.JPanel conteiner;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
