/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import espotify.Excepciones.ClienteInexistenteException;
import espotify.Excepciones.ListaInexistenteException;
import espotify.Excepciones.YaPublicaException;
import espotify.Fabrica;
import espotify.Interfaces.IPublicarLista;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author JavierM42
 */
public class PublicarLista extends javax.swing.JInternalFrame {

    /**
     * Creates new form PublicarLista
     */
    public PublicarLista() {
        initComponents();
        listascmb.setEnabled(false);
        publicarbtn.setEnabled(false);
        IPublicarLista interf = Fabrica.getIPublicarLista();
        ArrayList<String> a = interf.ListarClientes();
        for(String str : a) {
            clientescmb.addItem(str);
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

        clientescmb = new javax.swing.JComboBox<>();
        clilabel = new javax.swing.JLabel();
        lstlabel = new javax.swing.JLabel();
        listascmb = new javax.swing.JComboBox<>();
        publicarbtn = new javax.swing.JButton();

        setClosable(true);
        setTitle("Publicar Lista");

        clientescmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientescmbActionPerformed(evt);
            }
        });

        clilabel.setText("Cliente:");

        lstlabel.setText("Lista:");

        listascmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listascmbActionPerformed(evt);
            }
        });

        publicarbtn.setText("Publicar");
        publicarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                publicarbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(clilabel)
                            .addComponent(lstlabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(listascmb, 0, 221, Short.MAX_VALUE)
                            .addComponent(clientescmb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(publicarbtn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clientescmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clilabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lstlabel)
                    .addComponent(listascmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(publicarbtn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clientescmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientescmbActionPerformed
        String cli = String.valueOf(clientescmb.getSelectedItem());
        IPublicarLista interf = Fabrica.getIPublicarLista();
        listascmb.removeAllItems();

        try {
            ArrayList<String> a = interf.ListarListasPrivadasDeCliente(cli);
            listascmb.setEnabled(a.size()>0);
            for(String str : a) {
              listascmb.addItem(str);
            }
        } catch (ClienteInexistenteException e) {
            JOptionPane.showMessageDialog(new JDialog(),
            "El cliente seleccionado no existe",
            "Error",
            JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_clientescmbActionPerformed

    private void listascmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listascmbActionPerformed
        publicarbtn.setEnabled(true);
    }//GEN-LAST:event_listascmbActionPerformed

    private void publicarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_publicarbtnActionPerformed
        IPublicarLista interf = Fabrica.getIPublicarLista();
        try
        {
        interf.PublicarLista(String.valueOf(listascmb.getSelectedItem()),String.valueOf(clientescmb.getSelectedItem()));
        JOptionPane.showMessageDialog(this, "Operación completada con éxito.", "OK", JOptionPane.PLAIN_MESSAGE);
        }
        catch (ClienteInexistenteException e){
            JOptionPane.showMessageDialog(this, "El cliente seleccionado no existe.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }     
        catch (ListaInexistenteException e){
            JOptionPane.showMessageDialog(this, "El cliente seleccionado no tiene una lista con ese nombre", "ERROR", JOptionPane.ERROR_MESSAGE);
        }   
        catch (YaPublicaException e){
            JOptionPane.showMessageDialog(this, "La lista seleccionada ya es pública.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }   
    }//GEN-LAST:event_publicarbtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> clientescmb;
    private javax.swing.JLabel clilabel;
    private javax.swing.JComboBox<String> listascmb;
    private javax.swing.JLabel lstlabel;
    private javax.swing.JButton publicarbtn;
    // End of variables declaration//GEN-END:variables
}
