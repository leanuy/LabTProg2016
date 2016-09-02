/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import espotify.Datatypes.DataAlbum;
import espotify.Datatypes.DataDefecto;
import espotify.Datatypes.DataParticular;
import espotify.Datatypes.DataTema;
import espotify.Excepciones.AlbumInexistenteException;
import espotify.Excepciones.ArtistaInexistenteException;
import espotify.Excepciones.ClienteInexistenteException;
import espotify.Excepciones.FavoritoRepetidoException;
import espotify.Excepciones.ListaInexistenteException;
import espotify.Fabrica;
import espotify.Interfaces.IFavoritear;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author JavierM42
 */
public class Favoritear extends javax.swing.JInternalFrame {

    /**
     * Creates new form Favoritear
     */
    public Favoritear() {
        initComponents();
    }

    IFavoritear ifav = Fabrica.getIFavoritear();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nicktxt = new javax.swing.JTextField();
        txt1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnListaPublica = new javax.swing.JButton();
        btnAlbum = new javax.swing.JButton();
        btnTemaAlbum = new javax.swing.JButton();
        btnListaDefecto = new javax.swing.JButton();

        setClosable(true);

        jLabel1.setText("Cliente");

        jLabel2.setText("Cliente/ArtistaAlbum/NomListaDefecto");

        jLabel3.setText("NomLIstaPublica/NomAlbum");

        jLabel4.setText("NomTema");

        btnListaPublica.setText("Favoritear lista Publica");
        btnListaPublica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaPublicaActionPerformed(evt);
            }
        });

        btnAlbum.setText("Favoritear Album");
        btnAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlbumActionPerformed(evt);
            }
        });

        btnTemaAlbum.setText("Favoritear Tema de Album");
        btnTemaAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTemaAlbumActionPerformed(evt);
            }
        });

        btnListaDefecto.setText("Favoritear lista por defecto");
        btnListaDefecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaDefectoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nicktxt, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txt2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                        .addComponent(txt1, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(txt3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAlbum, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnListaDefecto)
                        .addGap(26, 26, 26)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnListaPublica))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnTemaAlbum)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nicktxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnListaPublica)
                    .addComponent(btnAlbum))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTemaAlbum)
                    .addComponent(btnListaDefecto))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnListaDefectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaDefectoActionPerformed
        DataDefecto d = new DataDefecto("", txt1.getText(), null);
        try {
            ifav.Favoritear(nicktxt.getText(), d);
        } catch (ClienteInexistenteException ex) {
            JOptionPane.showMessageDialog(new JDialog(), "El cliente seleccionado no existe", "Error", JOptionPane.PLAIN_MESSAGE);
        } catch (FavoritoRepetidoException ex) {
            JOptionPane.showMessageDialog(new JDialog(), "Ya ha marcado ese ítem como favorito", "Error", JOptionPane.PLAIN_MESSAGE);
        } catch (ListaInexistenteException ex) {
            JOptionPane.showMessageDialog(new JDialog(), "La lista no existe", "Error", JOptionPane.PLAIN_MESSAGE);
        } catch (ArtistaInexistenteException ex) {
            JOptionPane.showMessageDialog(new JDialog(), "El artista seleccionado no existe", "Error", JOptionPane.PLAIN_MESSAGE);
        } catch (AlbumInexistenteException ex) {
            JOptionPane.showMessageDialog(new JDialog(), "El album seleccionado no existe", "Error", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_btnListaDefectoActionPerformed

    private void btnListaPublicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaPublicaActionPerformed
        DataParticular d = new DataParticular(txt1.getText(),txt2.getText(),null);
        try {
            ifav.Favoritear(nicktxt.getText(), d);
        } catch (ClienteInexistenteException ex) {
            JOptionPane.showMessageDialog(new JDialog(), "El cliente seleccionado no existe", "Error", JOptionPane.PLAIN_MESSAGE);
        } catch (FavoritoRepetidoException ex) {
            JOptionPane.showMessageDialog(new JDialog(), "Ya ha marcado ese ítem como favorito", "Error", JOptionPane.PLAIN_MESSAGE);
        } catch (ListaInexistenteException ex) {
            JOptionPane.showMessageDialog(new JDialog(), "La lista no existe", "Error", JOptionPane.PLAIN_MESSAGE);
        } catch (ArtistaInexistenteException ex) {
            JOptionPane.showMessageDialog(new JDialog(), "El artista seleccionado no existe", "Error", JOptionPane.PLAIN_MESSAGE);
        } catch (AlbumInexistenteException ex) {
            JOptionPane.showMessageDialog(new JDialog(), "El album seleccionado no existe", "Error", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_btnListaPublicaActionPerformed

    private void btnAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlbumActionPerformed
        DataAlbum d = new DataAlbum(txt2.getText(), 0, null, null, txt1.getText());
        try {
            ifav.Favoritear(nicktxt.getText(), d);
        } catch (ClienteInexistenteException ex) {
            JOptionPane.showMessageDialog(new JDialog(), "El cliente seleccionado no existe", "Error", JOptionPane.PLAIN_MESSAGE);
        } catch (FavoritoRepetidoException ex) {
            JOptionPane.showMessageDialog(new JDialog(), "Ya ha marcado ese ítem como favorito", "Error", JOptionPane.PLAIN_MESSAGE);
        } catch (ListaInexistenteException ex) {
            JOptionPane.showMessageDialog(new JDialog(), "La lista no existe", "Error", JOptionPane.PLAIN_MESSAGE);
        } catch (ArtistaInexistenteException ex) {
            JOptionPane.showMessageDialog(new JDialog(), "El artista seleccionado no existe", "Error", JOptionPane.PLAIN_MESSAGE);
        } catch (AlbumInexistenteException ex) {
            JOptionPane.showMessageDialog(new JDialog(), "El album seleccionado no existe", "Error", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_btnAlbumActionPerformed

    private void btnTemaAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTemaAlbumActionPerformed

    }//GEN-LAST:event_btnTemaAlbumActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlbum;
    private javax.swing.JButton btnListaDefecto;
    private javax.swing.JButton btnListaPublica;
    private javax.swing.JButton btnTemaAlbum;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField nicktxt;
    private javax.swing.JTextField txt1;
    private javax.swing.JTextField txt2;
    private javax.swing.JTextField txt3;
    // End of variables declaration//GEN-END:variables
}
