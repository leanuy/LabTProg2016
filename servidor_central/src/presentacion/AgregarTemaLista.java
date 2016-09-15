package presentacion;

import espotify.Fabrica;
import espotify.datatypes.DataTema;
import espotify.excepciones.AlbumInexistenteException;
import espotify.excepciones.ArtistaInexistenteException;
import espotify.interfaces.IAgregarTemaLista;

import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Santiago
 */
public class AgregarTemaLista extends javax.swing.JInternalFrame {
   
    private String ListaAGuardar = null;
    private DataTema[] listatemas = null;
    private String[] vacio = new String[0];

    /**
     * Creates new form AgregarTemaLista
     */
    public AgregarTemaLista() {
        initComponents();
        clientesBox.setVisible(false);
        lista1Box.setVisible(false);
        cliente2Box.setVisible(false);
        artistaBox.setVisible(false);
        lista2Box.setVisible(false);
        albumBox.setVisible(false);
        temaBox.setVisible(false);
        clienteslabel.setVisible(false);
        lista1label.setVisible(false);
        cliente2label.setVisible(false);
        artistalabel.setVisible(false);
        lista2label.setVisible(false);
        albumlabel.setVisible(false);
        temalabel.setVisible(false);
        seleccionarLista.setVisible(false);
        seleccionarCliente1.setVisible(false);
        seleccionarCliente.setVisible(false);
        seleccionarArtista.setVisible(false);
        seleccionarLista1.setVisible(false);
        seleccionarAlbum.setVisible(false);
        
    }
    
    IAgregarTemaLista interf = Fabrica.getIAgregarTemaLista();


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        clienteslabel = new javax.swing.JLabel();
        lista1label = new javax.swing.JLabel();
        clientesBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        ParticularButton = new javax.swing.JRadioButton();
        DefectoButton = new javax.swing.JRadioButton();
        lista1Box = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        listaPublicaRadio = new javax.swing.JRadioButton();
        listaDefectoRadio = new javax.swing.JRadioButton();
        albumRadio = new javax.swing.JRadioButton();
        cliente2label = new javax.swing.JLabel();
        lista2label = new javax.swing.JLabel();
        temalabel = new javax.swing.JLabel();
        lista2Box = new javax.swing.JComboBox<>();
        cliente2Box = new javax.swing.JComboBox<>();
        artistalabel = new javax.swing.JLabel();
        artistaBox = new javax.swing.JComboBox<>();
        albumlabel = new javax.swing.JLabel();
        albumBox = new javax.swing.JComboBox<>();
        agregarButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        temaBox = new javax.swing.JList<>();
        seleccionarCliente = new javax.swing.JButton();
        seleccionarArtista = new javax.swing.JButton();
        seleccionarLista = new javax.swing.JButton();
        seleccionarCliente1 = new javax.swing.JButton();
        seleccionarLista1 = new javax.swing.JButton();
        seleccionarAlbum = new javax.swing.JButton();

        setClosable(true);
        setTitle("Agregar Tema a Lista");

        clienteslabel.setText("Seleccione un Cliente:");

        lista1label.setText("Seleccione una Lista:");

        clientesBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientesBoxActionPerformed(evt);
            }
        });

        jLabel3.setText("Desea agregar un tema a una Lista Particular o una por Defecto?");

        buttonGroup1.add(ParticularButton);
        ParticularButton.setText("Particular");
        ParticularButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ParticularButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(DefectoButton);
        DefectoButton.setText("Por Defecto");
        DefectoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DefectoButtonActionPerformed(evt);
            }
        });

        lista1Box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lista1BoxActionPerformed(evt);
            }
        });

        jLabel5.setText("De donde quiere obtener el tema?");

        buttonGroup2.add(listaPublicaRadio);
        listaPublicaRadio.setText("Lista Publica");
        listaPublicaRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaPublicaRadioActionPerformed(evt);
            }
        });

        buttonGroup2.add(listaDefectoRadio);
        listaDefectoRadio.setText("Lista por Defecto");
        listaDefectoRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaDefectoRadioActionPerformed(evt);
            }
        });

        buttonGroup2.add(albumRadio);
        albumRadio.setText("Album");
        albumRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                albumRadioActionPerformed(evt);
            }
        });

        cliente2label.setText("Seleccione un Cliente:");

        lista2label.setText("Seleccione una Lista:");

        temalabel.setText("Seleccione el tema que desea agregar:");

        lista2Box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lista2BoxActionPerformed(evt);
            }
        });

        cliente2Box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cliente2BoxActionPerformed(evt);
            }
        });

        artistalabel.setText("Seleccione un Artista:");

        artistaBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                artistaBoxActionPerformed(evt);
            }
        });

        albumlabel.setText("Seleccione un Album:");

        albumBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                albumBoxActionPerformed(evt);
            }
        });

        agregarButton.setText("Agregar");
        agregarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarButtonActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(temaBox);

        seleccionarCliente.setText("Seleccionar");
        seleccionarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarClienteActionPerformed(evt);
            }
        });

        seleccionarArtista.setText("Seleccionar");
        seleccionarArtista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarArtistaActionPerformed(evt);
            }
        });

        seleccionarLista.setText("Seleccionar");
        seleccionarLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarListaActionPerformed(evt);
            }
        });

        seleccionarCliente1.setText("Seleccionar");
        seleccionarCliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarCliente1ActionPerformed(evt);
            }
        });

        seleccionarLista1.setText("Seleccionar");
        seleccionarLista1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarLista1ActionPerformed(evt);
            }
        });

        seleccionarAlbum.setText("Seleccionar");
        seleccionarAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarAlbumActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(clienteslabel)
                                    .addComponent(lista1label))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lista1Box, 0, 146, Short.MAX_VALUE)
                                    .addComponent(clientesBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(seleccionarCliente1)
                                    .addComponent(seleccionarLista1)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(26, 26, 26))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(listaPublicaRadio)
                                        .addGap(69, 69, 69)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addComponent(ParticularButton)
                                        .addGap(45, 45, 45)
                                        .addComponent(DefectoButton))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(listaDefectoRadio)))))
                        .addContainerGap(103, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(albumRadio)
                        .addGap(57, 57, 57))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cliente2label)
                                .addGap(30, 30, 30)
                                .addComponent(cliente2Box, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lista2label)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lista2Box, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(seleccionarCliente)
                            .addComponent(seleccionarLista))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(artistalabel)
                            .addComponent(albumlabel))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(albumBox, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(seleccionarAlbum))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(artistaBox, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(seleccionarArtista)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(temalabel, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(304, 304, 304)
                .addComponent(agregarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ParticularButton)
                    .addComponent(DefectoButton)
                    .addComponent(jLabel3))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clienteslabel)
                    .addComponent(clientesBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seleccionarCliente1))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lista1label)
                    .addComponent(lista1Box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seleccionarLista1))
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(listaPublicaRadio)
                    .addComponent(listaDefectoRadio)
                    .addComponent(albumRadio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(temalabel)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cliente2label)
                            .addComponent(cliente2Box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(seleccionarCliente))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(artistalabel)
                            .addComponent(artistaBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(seleccionarArtista))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lista2label)
                            .addComponent(lista2Box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(seleccionarLista))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(albumlabel)
                            .addComponent(albumBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(seleccionarAlbum)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addComponent(agregarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    private void ParticularButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ParticularButtonActionPerformed
        // TODO add your handling code here:
        if (ParticularButton.isSelected()) {
            clientesBox.setVisible(true);
            lista1Box.setVisible(true);
            clienteslabel.setVisible(true);
            seleccionarCliente1.setVisible(true);
            seleccionarLista1.setVisible(true);
            lista1label.setVisible(true);
            ListaAGuardar = null;
            List<String> clientes = interf.listarClientes();
            clientesBox.removeAllItems();
            lista1Box.removeAllItems();
            clientes.stream().forEach((cli) -> {
                clientesBox.addItem(cli);
            });
        }
    }//GEN-LAST:event_ParticularButtonActionPerformed

    private void DefectoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DefectoButtonActionPerformed
        // TODO add your handling code here:
        if (DefectoButton.isSelected()) {
            clientesBox.setVisible(false);
            lista1Box.setVisible(true);
            seleccionarCliente1.setVisible(false);
            seleccionarLista1.setVisible(true);
            clienteslabel.setVisible(false);
            lista1label.setVisible(true);
            ListaAGuardar = null;
            List<String> listas = interf.listarListasDefecto();
            lista1Box.removeAllItems();
            for (String s: listas) {
                lista1Box.addItem(s);
            }
        }
    }//GEN-LAST:event_DefectoButtonActionPerformed
   
    private void listaPublicaRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaPublicaRadioActionPerformed
        // TODO add your handling code here:
        cliente2Box.setVisible(true);
        artistaBox.setVisible(false);
        lista2Box.setVisible(true);
        albumBox.setVisible(false);
        temaBox.setVisible(true);
        cliente2label.setVisible(true);
        artistalabel.setVisible(false);
        lista2label.setVisible(true);
        albumlabel.setVisible(false);
        temalabel.setVisible(true);
        seleccionarCliente.setVisible(true);
        seleccionarArtista.setVisible(false);
        seleccionarLista.setVisible(true);
        seleccionarAlbum.setVisible(false);
        lista2Box.removeAllItems();
        cliente2Box.removeAllItems();
        temaBox.removeAll();
        temaBox.setListData(vacio);
        List<String> clientes = interf.listarClientes();
        for (String s : clientes) {
            cliente2Box.addItem(s);
        }
    }//GEN-LAST:event_listaPublicaRadioActionPerformed

    private void listaDefectoRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaDefectoRadioActionPerformed
        // TODO add your handling code here:
        cliente2Box.setVisible(false);
        artistaBox.setVisible(false);
        lista2Box.setVisible(true);
        albumBox.setVisible(false);
        temaBox.setVisible(true);
        cliente2label.setVisible(false);
        artistalabel.setVisible(false);
        lista2label.setVisible(true);
        albumlabel.setVisible(false);
        temalabel.setVisible(true);
        seleccionarCliente.setVisible(false);
        seleccionarArtista.setVisible(false);
        seleccionarLista.setVisible(true);
        seleccionarAlbum.setVisible(false);
        lista2Box.removeAllItems();
        temaBox.removeAll();
        temaBox.setListData(vacio);
        try {
            List<String> listas = interf.listarListasDefecto2();
            for (String s: listas) {
                lista2Box.addItem(s);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_listaDefectoRadioActionPerformed

    private void albumRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_albumRadioActionPerformed
        // TODO add your handling code here:
        cliente2Box.setVisible(false);
        artistaBox.setVisible(true);
        lista2Box.setVisible(false);
        albumBox.setVisible(true);
        temaBox.setVisible(true);
        cliente2label.setVisible(false);
        artistalabel.setVisible(true);
        lista2label.setVisible(false);
        albumlabel.setVisible(true);
        temalabel.setVisible(true);
        seleccionarCliente.setVisible(false);
        seleccionarArtista.setVisible(true);
        seleccionarLista.setVisible(false);
        seleccionarAlbum.setVisible(true);
        List<String> artistas = interf.listarArtistas();
        artistaBox.removeAllItems();
        albumBox.removeAllItems();
        temaBox.removeAll();
        temaBox.setListData(vacio);
        for (String s: artistas) {
            artistaBox.addItem(s);
        }
    }//GEN-LAST:event_albumRadioActionPerformed

    private void clientesBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientesBoxActionPerformed

    }//GEN-LAST:event_clientesBoxActionPerformed

    private void cliente2BoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cliente2BoxActionPerformed

    }//GEN-LAST:event_cliente2BoxActionPerformed

    private void artistaBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_artistaBoxActionPerformed

    }//GEN-LAST:event_artistaBoxActionPerformed

    private void lista2BoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lista2BoxActionPerformed

    }//GEN-LAST:event_lista2BoxActionPerformed

    private void albumBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_albumBoxActionPerformed

    }//GEN-LAST:event_albumBoxActionPerformed
//--------------------------------------------------------------------------------
    private void agregarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarButtonActionPerformed
        int idx = temaBox.getSelectedIndex();
        try {
            DataTema dTema = null;
            if (idx == -1) {
                JOptionPane.showMessageDialog(this, "Selecciona un tema wachin!", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            dTema = listatemas[idx];
            interf.agregarTemaLista(dTema, ListaAGuardar);
            JOptionPane.showMessageDialog(this, "Operación completada con éxito.", "OK", JOptionPane.PLAIN_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_agregarButtonActionPerformed

    private void lista1BoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lista1BoxActionPerformed
    }//GEN-LAST:event_lista1BoxActionPerformed

    private void seleccionarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarClienteActionPerformed
        if (listaPublicaRadio.isSelected()) {
            String cli = String.valueOf(cliente2Box.getSelectedItem());
            try {
                List<String> listas = interf.listarListasPublicasDeCliente(cli);
                lista2Box.removeAllItems();
                listas.stream().forEach((lista) -> {
                    lista2Box.addItem(lista);
                });
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_seleccionarClienteActionPerformed

    private void seleccionarArtistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarArtistaActionPerformed
        if (albumRadio.isSelected()) {
            String art = String.valueOf(artistaBox.getSelectedItem());
            try {
                List<String> albums = interf.listarAlbumesDeArtista(art);
                albumBox.removeAllItems();
                temaBox.removeAll();
                for (String s: albums) {
                    albumBox.addItem(s);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_seleccionarArtistaActionPerformed

    private void seleccionarListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarListaActionPerformed
        String cliente = null;
        if (listaPublicaRadio.isSelected()) {
            cliente = String.valueOf(cliente2Box.getSelectedItem());
        }
        String nomLista = String.valueOf(lista2Box.getSelectedItem());
        try {
            List<DataTema> listaTemas = interf.listarTemasLista2(cliente, nomLista);
            int size = listaTemas.size();
            String[] algo = new String[size];
            listatemas = new DataTema[size];
            temaBox.removeAll();
            int idx = 0;
            String tema;
            for (DataTema tem: listaTemas) {
                tema = "Nombre: " + tem.getNombre() + ". Album: " + tem.getAlbum() + ". Artista: " + tem.getNomArtista();
                algo[idx] = tema;
                listatemas[idx] = tem;
                idx++;
            }
            temaBox.setListData(algo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_seleccionarListaActionPerformed

    private void seleccionarCliente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarCliente1ActionPerformed
        if (ParticularButton.isSelected()) {
            String cliente = String.valueOf(clientesBox.getSelectedItem());
            try {
                List<String> listas = interf.listarListasDeCliente(cliente);
                lista1Box.removeAllItems();
                for (String s: listas) {
                    lista1Box.addItem(s);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_seleccionarCliente1ActionPerformed

    private void seleccionarLista1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarLista1ActionPerformed
        ListaAGuardar = String.valueOf(lista1Box.getSelectedItem());
    }//GEN-LAST:event_seleccionarLista1ActionPerformed

    private void seleccionarAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarAlbumActionPerformed
        if (albumRadio.isSelected()) {        
            String artista;
            artista = String.valueOf(artistaBox.getSelectedItem());
            String album = String.valueOf(albumBox.getSelectedItem());
            List<DataTema> listaTemas= null;
            try {
                listaTemas = interf.listarTemasAlbum(artista, album);
            } catch (ArtistaInexistenteException ex) {
                JOptionPane.showMessageDialog(this, "No se selecciono ningun artista", "ERROR", JOptionPane.ERROR_MESSAGE);
            } catch (AlbumInexistenteException ex) {
                JOptionPane.showMessageDialog(this, "No se selecciono ningun album", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            if (listaTemas != null) {
                int size = listaTemas.size();
                String[] algo = new String[size];
                listatemas = new DataTema[size];
                temaBox.removeAll();
                int idx = 0;
                String nombre;
                for (DataTema tem: listaTemas) {
                    nombre = "Nombre: " + tem.getNombre() + ". Album: " + tem.getAlbum() + ". Artista: " + tem.getNomArtista();
                    algo[idx] = nombre;
                    listatemas[idx] = tem;
                    idx++;
                }
                temaBox.setListData(algo);
            }
        }
    }//GEN-LAST:event_seleccionarAlbumActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton DefectoButton;
    private javax.swing.JRadioButton ParticularButton;
    private javax.swing.JButton agregarButton;
    private javax.swing.JComboBox<String> albumBox;
    private javax.swing.JRadioButton albumRadio;
    private javax.swing.JLabel albumlabel;
    private javax.swing.JComboBox<String> artistaBox;
    private javax.swing.JLabel artistalabel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cliente2Box;
    private javax.swing.JLabel cliente2label;
    private javax.swing.JComboBox<String> clientesBox;
    private javax.swing.JLabel clienteslabel;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> lista1Box;
    private javax.swing.JLabel lista1label;
    private javax.swing.JComboBox<String> lista2Box;
    private javax.swing.JLabel lista2label;
    private javax.swing.JRadioButton listaDefectoRadio;
    private javax.swing.JRadioButton listaPublicaRadio;
    private javax.swing.JButton seleccionarAlbum;
    private javax.swing.JButton seleccionarArtista;
    private javax.swing.JButton seleccionarCliente;
    private javax.swing.JButton seleccionarCliente1;
    private javax.swing.JButton seleccionarLista;
    private javax.swing.JButton seleccionarLista1;
    private javax.swing.JList<String> temaBox;
    private javax.swing.JLabel temalabel;
    // End of variables declaration//GEN-END:variables
}
