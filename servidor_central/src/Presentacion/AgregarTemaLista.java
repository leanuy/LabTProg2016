package Presentacion;

import espotify.Datatypes.DataTema;
import espotify.Excepciones.AlbumInexistenteException;
import espotify.Excepciones.ArtistaInexistenteException;
import espotify.Fabrica;
import espotify.Interfaces.IAgregarTemaLista;

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
        ClientesBox.setVisible(false);
        Lista1Box.setVisible(false);
        Cliente2Box.setVisible(false);
        ArtistaBox.setVisible(false);
        Lista2Box.setVisible(false);
        AlbumBox.setVisible(false);
        TemaBox.setVisible(false);
        clienteslabel.setVisible(false);
        lista1label.setVisible(false);
        cliente2label.setVisible(false);
        artistalabel.setVisible(false);
        lista2label.setVisible(false);
        albumlabel.setVisible(false);
        temalabel.setVisible(false);
        SeleccionarLista.setVisible(false);
        SeleccionarCliente1.setVisible(false);
        SeleccionarCliente.setVisible(false);
        SeleccionarArtista.setVisible(false);
        SeleccionarLista1.setVisible(false);
        SeleccionarAlbum.setVisible(false);
        
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
        ClientesBox = new javax.swing.JComboBox<String>();
        jLabel3 = new javax.swing.JLabel();
        ParticularButton = new javax.swing.JRadioButton();
        DefectoButton = new javax.swing.JRadioButton();
        Lista1Box = new javax.swing.JComboBox<String>();
        jLabel5 = new javax.swing.JLabel();
        LPublicaButton = new javax.swing.JRadioButton();
        LDefectoButton = new javax.swing.JRadioButton();
        AlbumButton = new javax.swing.JRadioButton();
        cliente2label = new javax.swing.JLabel();
        lista2label = new javax.swing.JLabel();
        temalabel = new javax.swing.JLabel();
        Lista2Box = new javax.swing.JComboBox<String>();
        Cliente2Box = new javax.swing.JComboBox<String>();
        artistalabel = new javax.swing.JLabel();
        ArtistaBox = new javax.swing.JComboBox<String>();
        albumlabel = new javax.swing.JLabel();
        AlbumBox = new javax.swing.JComboBox<String>();
        AgregarButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TemaBox = new javax.swing.JList<String>();
        SeleccionarCliente = new javax.swing.JButton();
        SeleccionarArtista = new javax.swing.JButton();
        SeleccionarLista = new javax.swing.JButton();
        SeleccionarCliente1 = new javax.swing.JButton();
        SeleccionarLista1 = new javax.swing.JButton();
        SeleccionarAlbum = new javax.swing.JButton();

        setClosable(true);
        setTitle("Agregar Tema a Lista");

        clienteslabel.setText("Seleccione un Cliente:");

        lista1label.setText("Seleccione una Lista:");

        ClientesBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClientesBoxActionPerformed(evt);
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

        Lista1Box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Lista1BoxActionPerformed(evt);
            }
        });

        jLabel5.setText("De donde quiere obtener el tema?");

        buttonGroup2.add(LPublicaButton);
        LPublicaButton.setText("Lista Publica");
        LPublicaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LPublicaButtonActionPerformed(evt);
            }
        });

        buttonGroup2.add(LDefectoButton);
        LDefectoButton.setText("Lista por Defecto");
        LDefectoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LDefectoButtonActionPerformed(evt);
            }
        });

        buttonGroup2.add(AlbumButton);
        AlbumButton.setText("Album");
        AlbumButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlbumButtonActionPerformed(evt);
            }
        });

        cliente2label.setText("Seleccione un Cliente:");

        lista2label.setText("Seleccione una Lista:");

        temalabel.setText("Seleccione el tema que desea agregar:");

        Lista2Box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Lista2BoxActionPerformed(evt);
            }
        });

        Cliente2Box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cliente2BoxActionPerformed(evt);
            }
        });

        artistalabel.setText("Seleccione un Artista:");

        ArtistaBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArtistaBoxActionPerformed(evt);
            }
        });

        albumlabel.setText("Seleccione un Album:");

        AlbumBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlbumBoxActionPerformed(evt);
            }
        });

        AgregarButton.setText("Agregar");
        AgregarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarButtonActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(TemaBox);

        SeleccionarCliente.setText("Seleccionar");
        SeleccionarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionarClienteActionPerformed(evt);
            }
        });

        SeleccionarArtista.setText("Seleccionar");
        SeleccionarArtista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionarArtistaActionPerformed(evt);
            }
        });

        SeleccionarLista.setText("Seleccionar");
        SeleccionarLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionarListaActionPerformed(evt);
            }
        });

        SeleccionarCliente1.setText("Seleccionar");
        SeleccionarCliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionarCliente1ActionPerformed(evt);
            }
        });

        SeleccionarLista1.setText("Seleccionar");
        SeleccionarLista1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionarLista1ActionPerformed(evt);
            }
        });

        SeleccionarAlbum.setText("Seleccionar");
        SeleccionarAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionarAlbumActionPerformed(evt);
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
                                    .addComponent(Lista1Box, 0, 146, Short.MAX_VALUE)
                                    .addComponent(ClientesBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SeleccionarCliente1)
                                    .addComponent(SeleccionarLista1)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(26, 26, 26))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(LPublicaButton)
                                        .addGap(69, 69, 69)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addComponent(ParticularButton)
                                        .addGap(45, 45, 45)
                                        .addComponent(DefectoButton))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(LDefectoButton)))))
                        .addContainerGap(103, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AlbumButton)
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
                                .addComponent(Cliente2Box, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lista2label)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Lista2Box, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SeleccionarCliente)
                            .addComponent(SeleccionarLista))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(artistalabel)
                            .addComponent(albumlabel))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(AlbumBox, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(SeleccionarAlbum))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(ArtistaBox, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(SeleccionarArtista)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(temalabel, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(304, 304, 304)
                .addComponent(AgregarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(ClientesBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SeleccionarCliente1))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lista1label)
                    .addComponent(Lista1Box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SeleccionarLista1))
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(LPublicaButton)
                    .addComponent(LDefectoButton)
                    .addComponent(AlbumButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(temalabel)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cliente2label)
                            .addComponent(Cliente2Box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SeleccionarCliente))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(artistalabel)
                            .addComponent(ArtistaBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SeleccionarArtista))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lista2label)
                            .addComponent(Lista2Box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SeleccionarLista))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(albumlabel)
                            .addComponent(AlbumBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SeleccionarAlbum)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addComponent(AgregarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        if(ParticularButton.isSelected()){
            ClientesBox.setVisible(true);
            Lista1Box.setVisible(true);
            clienteslabel.setVisible(true);
            SeleccionarCliente1.setVisible(true);
            SeleccionarLista1.setVisible(true);
            lista1label.setVisible(true);
            ListaAGuardar = null;
            List<String> clientes = interf.ListarClientes();
            ClientesBox.removeAllItems();
            Lista1Box.removeAllItems();
            clientes.stream().forEach((cli) -> {
                ClientesBox.addItem(cli);
            });
        }
    }//GEN-LAST:event_ParticularButtonActionPerformed

    private void DefectoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DefectoButtonActionPerformed
        // TODO add your handling code here:
        if(DefectoButton.isSelected()){
            ClientesBox.setVisible(false);
            Lista1Box.setVisible(true);
            SeleccionarCliente1.setVisible(false);
            SeleccionarLista1.setVisible(true);
            clienteslabel.setVisible(false);
            lista1label.setVisible(true);
            ListaAGuardar = null;
            List<String> listas = interf.ListarListasDefecto();
            Lista1Box.removeAllItems();
            for(String s: listas){
                Lista1Box.addItem(s);
            }
        }
    }//GEN-LAST:event_DefectoButtonActionPerformed
   
    private void LPublicaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LPublicaButtonActionPerformed
        // TODO add your handling code here:
        Cliente2Box.setVisible(true);
        ArtistaBox.setVisible(false);
        Lista2Box.setVisible(true);
        AlbumBox.setVisible(false);
        TemaBox.setVisible(true);
        cliente2label.setVisible(true);
        artistalabel.setVisible(false);
        lista2label.setVisible(true);
        albumlabel.setVisible(false);
        temalabel.setVisible(true);
        SeleccionarCliente.setVisible(true);
        SeleccionarArtista.setVisible(false);
        SeleccionarLista.setVisible(true);
        SeleccionarAlbum.setVisible(false);
        Lista2Box.removeAllItems();
        Cliente2Box.removeAllItems();
        TemaBox.removeAll();
        TemaBox.setListData(vacio);
        List<String> clientes = interf.ListarClientes();
        for(String s : clientes){
            Cliente2Box.addItem(s);
        }
    }//GEN-LAST:event_LPublicaButtonActionPerformed

    private void LDefectoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LDefectoButtonActionPerformed
        // TODO add your handling code here:
        Cliente2Box.setVisible(false);
        ArtistaBox.setVisible(false);
        Lista2Box.setVisible(true);
        AlbumBox.setVisible(false);
        TemaBox.setVisible(true);
        cliente2label.setVisible(false);
        artistalabel.setVisible(false);
        lista2label.setVisible(true);
        albumlabel.setVisible(false);
        temalabel.setVisible(true);
        SeleccionarCliente.setVisible(false);
        SeleccionarArtista.setVisible(false);
        SeleccionarLista.setVisible(true);
        SeleccionarAlbum.setVisible(false);
        Lista2Box.removeAllItems();
        TemaBox.removeAll();
        TemaBox.setListData(vacio);
        try{
            List<String> listas = interf.ListarListasDefecto2();
            for (String s: listas){
                Lista2Box.addItem(s);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_LDefectoButtonActionPerformed

    private void AlbumButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlbumButtonActionPerformed
        // TODO add your handling code here:
        Cliente2Box.setVisible(false);
        ArtistaBox.setVisible(true);
        Lista2Box.setVisible(false);
        AlbumBox.setVisible(true);
        TemaBox.setVisible(true);
        cliente2label.setVisible(false);
        artistalabel.setVisible(true);
        lista2label.setVisible(false);
        albumlabel.setVisible(true);
        temalabel.setVisible(true);
        SeleccionarCliente.setVisible(false);
        SeleccionarArtista.setVisible(true);
        SeleccionarLista.setVisible(false);
        SeleccionarAlbum.setVisible(true);
        List<String> artistas = interf.ListarArtistas();
        ArtistaBox.removeAllItems();
        AlbumBox.removeAllItems();
        TemaBox.removeAll();
        TemaBox.setListData(vacio);
        for (String s: artistas){
            ArtistaBox.addItem(s);
        }
    }//GEN-LAST:event_AlbumButtonActionPerformed

    private void ClientesBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClientesBoxActionPerformed

    }//GEN-LAST:event_ClientesBoxActionPerformed

    private void Cliente2BoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cliente2BoxActionPerformed

    }//GEN-LAST:event_Cliente2BoxActionPerformed

    private void ArtistaBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArtistaBoxActionPerformed

    }//GEN-LAST:event_ArtistaBoxActionPerformed

    private void Lista2BoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Lista2BoxActionPerformed

    }//GEN-LAST:event_Lista2BoxActionPerformed

    private void AlbumBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlbumBoxActionPerformed

    }//GEN-LAST:event_AlbumBoxActionPerformed
//--------------------------------------------------------------------------------
    private void AgregarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarButtonActionPerformed
        int idx = TemaBox.getSelectedIndex();
        try{
            DataTema dTema = null;
            if (idx == -1){
                JOptionPane.showMessageDialog(this, "Selecciona un tema wachin!", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            dTema = listatemas[idx];
            interf.AgregarTemaLista(dTema, ListaAGuardar);
            JOptionPane.showMessageDialog(this, "Operación completada con éxito.", "OK", JOptionPane.PLAIN_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_AgregarButtonActionPerformed

    private void Lista1BoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Lista1BoxActionPerformed
    }//GEN-LAST:event_Lista1BoxActionPerformed

    private void SeleccionarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionarClienteActionPerformed
        if (LPublicaButton.isSelected()){
            String cli = String.valueOf(Cliente2Box.getSelectedItem());
            try {
                List<String> listas = interf.ListarListasPublicasDeCliente(cli);
                Lista2Box.removeAllItems();
                listas.stream().forEach((lista) -> {
                    Lista2Box.addItem(lista);
                });
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_SeleccionarClienteActionPerformed

    private void SeleccionarArtistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionarArtistaActionPerformed
        if (AlbumButton.isSelected()) {
            String art = String.valueOf(ArtistaBox.getSelectedItem());
            try {
                List<String> albums = interf.ListarAlbumesDeArtista(art);
                AlbumBox.removeAllItems();
                TemaBox.removeAll();
                for (String s: albums){
                    AlbumBox.addItem(s);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_SeleccionarArtistaActionPerformed

    private void SeleccionarListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionarListaActionPerformed
        String cliente = null;
        if (LPublicaButton.isSelected()) {
            cliente = String.valueOf(Cliente2Box.getSelectedItem());
        }
        String nomLista = String.valueOf(Lista2Box.getSelectedItem());
        try {
            List<DataTema> listaTemas = interf.ListarTemasLista2(cliente, nomLista);
            int size = listaTemas.size();
            String[] algo = new String[size];
            listatemas = new DataTema[size];
            TemaBox.removeAll();
            int idx = 0;
            String tema;
            for (DataTema tem: listaTemas){
                tema = "Nombre: " + tem.getNombre() + ". Album: " + tem.getAlbum() + ". Artista: " + tem.getNomArtista();
                algo[idx] = tema;
                listatemas[idx] = tem;
                idx++;
            }
            TemaBox.setListData(algo);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_SeleccionarListaActionPerformed

    private void SeleccionarCliente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionarCliente1ActionPerformed
        if(ParticularButton.isSelected()){
            String cliente = String.valueOf(ClientesBox.getSelectedItem());
            try{
                List<String> listas = interf.ListarListasDeCliente(cliente);
                Lista1Box.removeAllItems();
                for(String s: listas){
                    Lista1Box.addItem(s);
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_SeleccionarCliente1ActionPerformed

    private void SeleccionarLista1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionarLista1ActionPerformed
        ListaAGuardar = String.valueOf(Lista1Box.getSelectedItem());
    }//GEN-LAST:event_SeleccionarLista1ActionPerformed

    private void SeleccionarAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionarAlbumActionPerformed
        if(AlbumButton.isSelected()){        
            String artista;
            artista = String.valueOf(ArtistaBox.getSelectedItem());
            String album = String.valueOf(AlbumBox.getSelectedItem());
            List<DataTema> listaTemas=null;
            try {
                listaTemas = interf.ListarTemasAlbum(artista, album);
            } catch (ArtistaInexistenteException ex) {
                JOptionPane.showMessageDialog(this, "No se selecciono ningun artista", "ERROR", JOptionPane.ERROR_MESSAGE);
            } catch (AlbumInexistenteException ex) {
                JOptionPane.showMessageDialog(this, "No se selecciono ningun album", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            if(listaTemas != null){
                int size = listaTemas.size();
                String[] algo = new String[size];
                listatemas = new DataTema[size];
                TemaBox.removeAll();
                int idx = 0;
                String nombre;
                for (DataTema tem: listaTemas){
                    nombre = "Nombre: " + tem.getNombre() + ". Album: " + tem.getAlbum() + ". Artista: " + tem.getNomArtista();
                    algo[idx] = nombre;
                    listatemas[idx] = tem;
                    idx++;
                }
                TemaBox.setListData(algo);
            }
        }
    }//GEN-LAST:event_SeleccionarAlbumActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarButton;
    private javax.swing.JComboBox<String> AlbumBox;
    private javax.swing.JRadioButton AlbumButton;
    private javax.swing.JComboBox<String> ArtistaBox;
    private javax.swing.JComboBox<String> Cliente2Box;
    private javax.swing.JComboBox<String> ClientesBox;
    private javax.swing.JRadioButton DefectoButton;
    private javax.swing.JRadioButton LDefectoButton;
    private javax.swing.JRadioButton LPublicaButton;
    private javax.swing.JComboBox<String> Lista1Box;
    private javax.swing.JComboBox<String> Lista2Box;
    private javax.swing.JRadioButton ParticularButton;
    private javax.swing.JButton SeleccionarAlbum;
    private javax.swing.JButton SeleccionarArtista;
    private javax.swing.JButton SeleccionarCliente;
    private javax.swing.JButton SeleccionarCliente1;
    private javax.swing.JButton SeleccionarLista;
    private javax.swing.JButton SeleccionarLista1;
    private javax.swing.JList<String> TemaBox;
    private javax.swing.JLabel albumlabel;
    private javax.swing.JLabel artistalabel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel cliente2label;
    private javax.swing.JLabel clienteslabel;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lista1label;
    private javax.swing.JLabel lista2label;
    private javax.swing.JLabel temalabel;
    // End of variables declaration//GEN-END:variables
}
