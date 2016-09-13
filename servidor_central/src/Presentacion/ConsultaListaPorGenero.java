package Presentacion;

import espotify.Datatypes.DataGenero;
import espotify.Datatypes.DataLista;
import espotify.Datatypes.DataTema;
import espotify.Excepciones.ListaInexistenteException;
import espotify.Fabrica;
import espotify.Interfaces.IAltaGenero;
import espotify.Interfaces.IConsultaLista;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

public class ConsultaListaPorGenero extends javax.swing.JInternalFrame {

        private DefaultTreeModel modeloTree;

    /**
     * Creates new form ConsultaListaPorGenero
     */
    public ConsultaListaPorGenero() {
        initComponents();
        ArbolGeneros.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        IAltaGenero interfaz =  Fabrica.getIAltaGenero();                 
        DataGenero generoBase = interfaz.ListarGeneros();
        DefaultMutableTreeNode raiz = new DefaultMutableTreeNode(generoBase.getNombre());
        modeloTree  = new DefaultTreeModel(raiz);
        ArbolGeneros.setModel(modeloTree);
        cargarArbol(generoBase,raiz);
    }

    private void cargarArbol(DataGenero g, DefaultMutableTreeNode padre){
        int i = 0;
        for(DataGenero d: g.getHijos()){
            DefaultMutableTreeNode nodito = new DefaultMutableTreeNode(d.getNombre());
            modeloTree.insertNodeInto(nodito,padre,i);
            i++;
            cargarArbol(d,nodito);
        }
        for (i = 0; i < ArbolGeneros.getRowCount(); i++) {
            ArbolGeneros.expandRow(i);
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
        jLabel2 = new javax.swing.JLabel();
        listascmb = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaTemas = new javax.swing.JList<>();
        ImgContainer = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ArbolGeneros = new javax.swing.JTree();
        consultarbtn = new javax.swing.JButton();

        setClosable(true);
        setTitle("Consulta de Lista");

        jLabel1.setText("Género:");

        jLabel2.setText("Lista:");

        listascmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listascmbActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(ListaTemas);

        ImgContainer.setText(" ");

        ArbolGeneros.setModel(null);
        ArbolGeneros.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                ArbolGenerosValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(ArbolGeneros);

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
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                    .addComponent(listascmb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(consultarbtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ImgContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 55, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ImgContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(listascmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(consultarbtn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    IConsultaLista interf = Fabrica.getIConsultaLista();

    
    private void listascmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listascmbActionPerformed
        
    }//GEN-LAST:event_listascmbActionPerformed

    private void ArbolGenerosValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_ArbolGenerosValueChanged
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) ArbolGeneros.getLastSelectedPathComponent();
        String nomGenero = "";
        if (node != null)
            nomGenero = (String)node.getUserObject();
        listascmb.removeAllItems();
        ArrayList<String> listas = interf.ListarListasDeGenero(nomGenero);
        for(String str : listas) {
            listascmb.addItem(str);
        }
    }//GEN-LAST:event_ArbolGenerosValueChanged

    private void consultarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarbtnActionPerformed
        String nomLista = String.valueOf(listascmb.getSelectedItem());
        try {
            DataLista dl = interf.DarInfoDefecto(nomLista);
            
            //mostrar la imagen
            BufferedImage imagen = dl.getImg();
            BufferedImage image;
            if(imagen == null){
                image = null;
            }
            else{
                image = getScaledImage(imagen,212,220);
            }
            ImgContainer.removeAll();
            if (image != null){
                ImageIcon img = new ImageIcon(image);
                ImgContainer.setIcon(img);
                ImgContainer.setVisible(true);
            }else{
                ImgContainer.setText("El usuario NO tiene imagen");
                ImgContainer.setVisible(false);
            }
            //fin mostrar la imagen

            //mostrar los temas:
            ArrayList<DataTema> a = dl.getTemas();
            DefaultListModel<String> model = new DefaultListModel<>();
            ListaTemas.setModel(model);
            for(DataTema dt : a) {
                model.addElement(dt.getNomArtista() + " - " + dt.getAlbum() + " - " + dt.getNombre() + " (" + dt.getDuracion()/60+":"+dt.getDuracion()%60 + ")");
            }

        } catch (ListaInexistenteException ex) {
            JOptionPane.showMessageDialog(this, "No existe una lista con ese nombre", "ERROR", JOptionPane.ERROR_MESSAGE);
        }   
        
        
    }//GEN-LAST:event_consultarbtnActionPerformed

    private BufferedImage getScaledImage(BufferedImage src, int w, int h){
        int finalw = w;
        int finalh = h;
        double factor = 1.0d;
        if(src.getWidth() > src.getHeight()){
            factor = ((double)src.getHeight()/(double)src.getWidth());
            finalh = (int)(finalw * factor);                
        }else{
            factor = ((double)src.getWidth()/(double)src.getHeight());
            finalw = (int)(finalh * factor);
        }   

        BufferedImage resizedImg = new BufferedImage(finalw, finalh, BufferedImage.TRANSLUCENT);
        Graphics2D g2 = resizedImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(src, 0, 0, finalw, finalh, null);
        g2.dispose();
        return resizedImg;
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree ArbolGeneros;
    private javax.swing.JLabel ImgContainer;
    private javax.swing.JList<String> ListaTemas;
    private javax.swing.JButton consultarbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> listascmb;
    // End of variables declaration//GEN-END:variables
}