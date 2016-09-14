package presentacion;

import espotify.datatypes.DataTema;
import espotify.Fabrica;
import espotify.interfaces.IQuitarTemaLista;

import java.util.List;

import javax.swing.JOptionPane;

/**
 *
 * @author Santiago
 */
public class QuitarTemaLista extends javax.swing.JInternalFrame {

    /**
     * Creates new form QuitarTemaLista
     */
    public QuitarTemaLista() {
        initComponents();
        ListaBox.setVisible(false);
        ListaLabel.setVisible(false);
        ClientesBox.setVisible(false);
        ClienteLabel.setVisible(false);
        ListaTema.setVisible(false);
        SeleccionarTemaLabel.setVisible(false);
        QuitarButton.setVisible(false);
        SeleccionarClienteButton.setVisible(false);
        SeleccionarListaButton.setVisible(false);
    }
    
    DataTema[] listatemas;
    IQuitarTemaLista interf = Fabrica.getIQuitarTemaLista();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ClientesBox = new javax.swing.JComboBox<>();
        SeleccionarClienteButton = new javax.swing.JButton();
        ClienteLabel = new javax.swing.JLabel();
        ListaLabel = new javax.swing.JLabel();
        SeleccionarListaButton = new javax.swing.JButton();
        ListaBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaTema = new javax.swing.JList<>();
        SeleccionarTemaLabel = new javax.swing.JLabel();
        QuitarButton = new javax.swing.JButton();
        ParticularButton = new javax.swing.JRadioButton();
        PorDefectoButton = new javax.swing.JRadioButton();

        setClosable(true);
        setTitle("Quitar Tema de Lista");

        jLabel1.setText("Desea quitar el tema de una lista particular o una por defecto?");

        SeleccionarClienteButton.setText("Seleccionar");
        SeleccionarClienteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionarClienteButtonActionPerformed(evt);
            }
        });

        ClienteLabel.setText("Seleccione un Cliente:");

        ListaLabel.setText("Seleccione una Lista:");

        SeleccionarListaButton.setText("Seleccionar");
        SeleccionarListaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionarListaButtonActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(ListaTema);

        SeleccionarTemaLabel.setText("Seleccione un tema:");

        QuitarButton.setText("Quitar");
        QuitarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ClienteLabel)
                            .addComponent(ListaLabel)
                            .addComponent(SeleccionarTemaLabel))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(ListaBox, javax.swing.GroupLayout.Alignment.LEADING, 0, 167, Short.MAX_VALUE)
                                    .addComponent(ClientesBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(41, 41, 41)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SeleccionarClienteButton)
                                    .addComponent(SeleccionarListaButton)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                                .addComponent(QuitarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(53, 53, 53))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ClientesBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SeleccionarClienteButton)
                    .addComponent(ClienteLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ListaLabel)
                    .addComponent(SeleccionarListaButton)
                    .addComponent(ListaBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SeleccionarTemaLabel))
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(QuitarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74))))
        );

        buttonGroup1.add(ParticularButton);
        ParticularButton.setText("Particular");
        ParticularButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ParticularButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(PorDefectoButton);
        PorDefectoButton.setText("Por Defecto");
        PorDefectoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PorDefectoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(439, Short.MAX_VALUE)
                .addComponent(ParticularButton)
                .addGap(29, 29, 29)
                .addComponent(PorDefectoButton)
                .addGap(39, 39, 39))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ParticularButton)
                    .addComponent(PorDefectoButton))
                .addContainerGap(296, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ParticularButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ParticularButtonActionPerformed
        ListaBox.setVisible(true);
        ListaLabel.setVisible(true);
        ClientesBox.setVisible(true);
        ClienteLabel.setVisible(true);
        ListaTema.setVisible(true);
        SeleccionarTemaLabel.setVisible(true);
        QuitarButton.setVisible(true);
        SeleccionarClienteButton.setVisible(true);
        SeleccionarListaButton.setVisible(true);
        ClientesBox.removeAllItems();
        ListaTema.removeAll();
        ListaBox.removeAllItems();
        List<String> clientes = interf.listarClientes();
        ClientesBox.removeAllItems();
        for (String s : clientes) {
            ClientesBox.addItem(s);
        }
    }//GEN-LAST:event_ParticularButtonActionPerformed

    private void PorDefectoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PorDefectoButtonActionPerformed
        ListaBox.setVisible(true);
        ListaLabel.setVisible(true);
        ClientesBox.setVisible(false);
        ClienteLabel.setVisible(false);
        ListaTema.setVisible(true);
        SeleccionarTemaLabel.setVisible(true);
        QuitarButton.setVisible(true);
        SeleccionarClienteButton.setVisible(false);
        SeleccionarListaButton.setVisible(true);
        ClientesBox.removeAllItems();
        ListaTema.removeAll();
        ListaBox.removeAllItems();
        List<String> listas = interf.listarListasDefecto();
        ListaBox.removeAllItems();
        for (String s : listas) {
            ListaBox.addItem(s);
        }
    }//GEN-LAST:event_PorDefectoButtonActionPerformed

    private void SeleccionarClienteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionarClienteButtonActionPerformed
        String nick = String.valueOf(ClientesBox.getSelectedItem());
        try {
            List<String> listas = interf.listarListasDeCliente(nick);
            ListaBox.removeAllItems();
            ListaTema.removeAll();
            for (String s : listas) {
                ListaBox.addItem(s);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_SeleccionarClienteButtonActionPerformed

    private void SeleccionarListaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionarListaButtonActionPerformed
        String lis = String.valueOf(ListaBox.getSelectedItem());
        String str;
        try {
            List<DataTema> temas = interf.listarTemasLista(lis);
            ListaTema.removeAll();
            int size = temas.size();
            String[] algo = new String[size];
            listatemas = new DataTema[size];
            int idx = 0;
            for (DataTema dt : temas) {
                str = dt.getNombre() + ". Artista: " + dt.getNomArtista();
                algo[idx] = str;
                listatemas[idx] = dt;
                idx++;
            }
            ListaTema.setListData(algo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_SeleccionarListaButtonActionPerformed

    private void QuitarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitarButtonActionPerformed
        int index = ListaTema.getSelectedIndex();
        try {
            DataTema dTema = null;
            if (index == -1) {
                JOptionPane.showMessageDialog(this, "Selecciona un tema wachin!", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            dTema = listatemas[index];
            String nombre = dTema.getNombre();
            String album = dTema.getAlbum();
            interf.removerTemaLista(nombre, album); 
            JOptionPane.showMessageDialog(this, "Operación completada con éxito.", "OK", JOptionPane.PLAIN_MESSAGE);
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_QuitarButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ClienteLabel;
    private javax.swing.JComboBox<String> ClientesBox;
    private javax.swing.JComboBox<String> ListaBox;
    private javax.swing.JLabel ListaLabel;
    private javax.swing.JList<String> ListaTema;
    private javax.swing.JRadioButton ParticularButton;
    private javax.swing.JRadioButton PorDefectoButton;
    private javax.swing.JButton QuitarButton;
    private javax.swing.JButton SeleccionarClienteButton;
    private javax.swing.JButton SeleccionarListaButton;
    private javax.swing.JLabel SeleccionarTemaLabel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
