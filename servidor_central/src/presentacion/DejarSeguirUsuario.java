package presentacion;

import espotify.Fabrica;
import espotify.excepciones.ClienteInexistenteException;
import espotify.excepciones.SeguidoInexistenteException;
import espotify.excepciones.SeguidorInexistenteException;
import espotify.interfaces.IDejarDeSeguir;
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
        List<String> clientes = interf.listarClientes();

        for(String str : clientes) {
            nickSeguidor.addItem(str);
            nickSeguido.addItem(str);
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
        dejarButton = new javax.swing.JButton();
        nickSeguidor = new javax.swing.JComboBox<>();
        nickSeguido = new javax.swing.JComboBox<>();

        setClosable(true);
        setTitle("Dejar de seguir Usuario");

        jLabel1.setText("Nick usuario:");

        jLabel2.setText("Nick del usuario a dejar de seguir:");

        dejarButton.setText("Dejar de Seguir");
        dejarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dejarButtonActionPerformed(evt);
            }
        });

        nickSeguidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nickSeguidorActionPerformed(evt);
            }
        });

        nickSeguido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nickSeguidoActionPerformed(evt);
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
                        .addComponent(dejarButton)
                        .addContainerGap(217, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Conteiner3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(Conteiner3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nickSeguido, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nickSeguidor, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(157, 157, 157))))
        );
        Conteiner3Layout.setVerticalGroup(
            Conteiner3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Conteiner3Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(Conteiner3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nickSeguidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(Conteiner3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nickSeguido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addComponent(dejarButton)
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

    private void dejarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dejarButtonActionPerformed
        // TODO add your handling code here:
        if (Seguidor.isEmpty() || Seguido.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "No se ingreso el nick de al menos un usuario",
                    "ATENCION", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                interf.dejarDeSeguir(Seguidor,Seguido);
                JOptionPane.showMessageDialog(this,
                        "Operación completada con éxito.",
                        "OK", JOptionPane.PLAIN_MESSAGE);
            } catch (SeguidoInexistenteException e) {
                JOptionPane.showMessageDialog(this,
                        "El usuario a dejar de seguir no existe o no era seguido por el seguidor.",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
            } catch (SeguidorInexistenteException e) {
                JOptionPane.showMessageDialog(this,
                        "El usuario seguidor no existe", "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        Seguidor = String.valueOf(nickSeguidor.getSelectedItem());
        String[] seguid=null;
        try {
            seguid = interf.getSeguidos(Seguidor);
        } catch (ClienteInexistenteException ex) {
            Logger.getLogger(DejarSeguirUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        nickSeguido.removeAllItems();
        for(String stri : seguid) {
            nickSeguido.addItem(stri);
        }
    }//GEN-LAST:event_dejarButtonActionPerformed

    private void nickSeguidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nickSeguidorActionPerformed
        // TODO add your handling code here:
        Seguidor = String.valueOf(nickSeguidor.getSelectedItem());
        String[] seguid=null;
        try {
            seguid = interf.getSeguidos(Seguidor);
        } catch (ClienteInexistenteException ex) {
            Logger.getLogger(DejarSeguirUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        nickSeguido.removeAllItems();
        for(String stri : seguid) {
            nickSeguido.addItem(stri);
        }
    }//GEN-LAST:event_nickSeguidorActionPerformed

    private void nickSeguidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nickSeguidoActionPerformed
        // TODO add your handling code here:
        Seguido = String.valueOf(nickSeguido.getSelectedItem());
    }//GEN-LAST:event_nickSeguidoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Conteiner3;
    private javax.swing.JButton dejarButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JComboBox<String> nickSeguido;
    private javax.swing.JComboBox<String> nickSeguidor;
    // End of variables declaration//GEN-END:variables
}
