package presentacion;

import espotify.datatypes.DataLista;
import espotify.datatypes.DataTema;
import espotify.excepciones.ClienteInexistenteException;
import espotify.excepciones.ListaInexistenteException;
import espotify.Fabrica;
import espotify.interfaces.IConsultaLista;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ConsultaListaPorCliente extends javax.swing.JInternalFrame {

    IConsultaLista interf = Fabrica.getIConsultaLista();
    /**
     * Creates new form ConsultaListaPorCliente
     */
    public ConsultaListaPorCliente() {
        initComponents();
        List<String> cli = interf.listarClientes();
        listascmb.setEnabled(false);
        for (String str : cli) {
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

        jLabel1 = new javax.swing.JLabel();
        clientescmb = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        listascmb = new javax.swing.JComboBox<>();
        ImgContainer = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaTemas = new javax.swing.JList<>();
        consultarbtn = new javax.swing.JButton();

        setClosable(true);
        setTitle("Consulta de Lista");

        jLabel1.setText("Cliente:");

        clientescmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientescmbActionPerformed(evt);
            }
        });

        jLabel2.setText("Lista:");

        listascmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listascmbActionPerformed(evt);
            }
        });

        ImgContainer.setText(" ");

        jScrollPane1.setViewportView(ListaTemas);

        consultarbtn.setText("Consultar");
        consultarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(clientescmb, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(listascmb, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(consultarbtn))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ImgContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(clientescmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(listascmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(consultarbtn)
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1))
            .addGroup(layout.createSequentialGroup()
                .addComponent(ImgContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 122, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clientescmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientescmbActionPerformed
        // TODO add your handling code here:
        String nomCliente = String.valueOf(clientescmb.getSelectedItem());
        listascmb.removeAllItems();
        try {
            listascmb.setEnabled(false);
            List<String> listas = interf.listarListasDeCliente(nomCliente);
            for (String str : listas) {
                listascmb.addItem(str);
            }
            listascmb.setEnabled(listas.size() > 0);
        } catch (ClienteInexistenteException ex) {
            JOptionPane.showMessageDialog(this, 
                    "El cliente elegido no existe",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }        
    }//GEN-LAST:event_clientescmbActionPerformed

    private void listascmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listascmbActionPerformed
    }//GEN-LAST:event_listascmbActionPerformed

    private void consultarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarbtnActionPerformed
        String nomLista = String.valueOf(listascmb.getSelectedItem());
        try {
            DataLista dLista = interf.darInfoParticular(nomLista, String.valueOf(clientescmb.getSelectedItem()));

            //mostrar la imagen
            BufferedImage imagen = dLista.getImg();
            BufferedImage image;
            if (imagen == null) {
                image = null;
            } else {
                image = getScaledImage(imagen,212,220);
            }
            ImgContainer.removeAll();
            if (image != null) {
                ImageIcon img = new ImageIcon(image);
                ImgContainer.setIcon(img);
                ImgContainer.setVisible(true);
            } else {
                ImgContainer.setText("El usuario NO tiene imagen");
                ImgContainer.setVisible(false);
            }
            //fin mostrar la imagen

            //mostrar los temas:
            List<DataTema> temas = dLista.getTemas();
            DefaultListModel<String> model = new DefaultListModel<>();
            ListaTemas.setModel(model);
            for (DataTema dt : temas) {
                model.addElement(dt.getNomArtista() + " - " + dt.getAlbum() + " - " + dt.getNombre() + " (" + dt.getDuracion() / 60 + ":" + dt.getDuracion() % 60 + ")");
            }
        } catch (ClienteInexistenteException ex) {
            JOptionPane.showMessageDialog(this,
                    "El cliente seleccionado no existe",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (ListaInexistenteException ex) {
            JOptionPane.showMessageDialog(this,
                    "El cliente seleccionado no tiene una lista con ese nombre",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_consultarbtnActionPerformed

    
    
    private BufferedImage getScaledImage(BufferedImage src, int width, int height) {
        int finalw = width;
        int finalh = height;
        double factor = 1.0d;
        if (src.getWidth() > src.getHeight()) {
            factor = (double)src.getHeight() / (double)src.getWidth();
            finalh = (int)(finalw * factor);                
        } else {
            factor = (double)src.getWidth() / (double)src.getHeight();
            finalw = (int)(finalh * factor);
        }   

        BufferedImage resizedImg = new BufferedImage(finalw, finalh, BufferedImage.TRANSLUCENT);
        Graphics2D graficos2 = resizedImg.createGraphics();
        graficos2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graficos2.drawImage(src, 0, 0, finalw, finalh, null);
        graficos2.dispose();
        return resizedImg;
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ImgContainer;
    private javax.swing.JList<String> ListaTemas;
    private javax.swing.JComboBox<String> clientescmb;
    private javax.swing.JButton consultarbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> listascmb;
    // End of variables declaration//GEN-END:variables
}
