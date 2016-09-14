package presentacion;

import espotify.datatypes.DataAlbumExt;
import espotify.datatypes.DataGenero;
import espotify.Fabrica;
import espotify.interfaces.IConsultaAlbum;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

/**
 *
 * @author leandro
 */
public class ConsultaAlbumPorGenero extends javax.swing.JInternalFrame {

    /**
     * Creates new form ConsultaAlbumPorGenero
     */
    
    private DefaultTreeModel modeloTree;
    private DefaultListModel modelitoAlbums;
    private List<String[]> albumsIndex;
    
    IConsultaAlbum inter = Fabrica.getIConsultaAlbum();
    
    public ConsultaAlbumPorGenero() {
        initComponents();
        
             
        modelitoAlbums = new DefaultListModel();
        
        ListaAlbumsGenero.setModel(modelitoAlbums);
        DataGenero genders = null;
        ArbolGeneros.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        genders = inter.listarGeneros();
        DefaultMutableTreeNode raiz = new DefaultMutableTreeNode(genders.getNombre());
        modeloTree  = new DefaultTreeModel(raiz);
        ArbolGeneros.setModel(modeloTree);
        cargarArbol(genders,raiz);
        albumsIndex = new ArrayList();
        
        //expandir nodos
        expandAllNodes(ArbolGeneros, 0, ArbolGeneros.getRowCount());
    }
    
    private void cargarArbol(DataGenero dGenero, DefaultMutableTreeNode padre){
        int idx = 0;
        for(DataGenero d: dGenero.getHijos()){
            DefaultMutableTreeNode nodito = new DefaultMutableTreeNode(d.getNombre());
            modeloTree.insertNodeInto(nodito,padre,idx);
            idx++;
            cargarArbol(d,nodito);
        }
    
    }    
    
    private void expandAllNodes(JTree tree, int startingIndex, int rowCount){
        for(int i=startingIndex;i<rowCount;++i){
            tree.expandRow(i);
        }

        if(tree.getRowCount()!=rowCount){
            expandAllNodes(tree, rowCount, tree.getRowCount());
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

        ConsultaAlbumXGenPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        obtenerAlbumsGeneroButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaAlbumsGenero = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        consultarAlbumButton = new javax.swing.JButton();
        salirButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        ArbolGeneros = new javax.swing.JTree();

        setClosable(true);
        setTitle("Consulta Album Por Genero");

        ConsultaAlbumXGenPanel.setPreferredSize(new java.awt.Dimension(725, 477));

        jLabel1.setText("Seleccionar Genero");

        obtenerAlbumsGeneroButton.setText("Obtener Albums del Genero");
        obtenerAlbumsGeneroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                obtenerAlbumsGeneroButtonActionPerformed(evt);
            }
        });

        ListaAlbumsGenero.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(ListaAlbumsGenero);

        jLabel2.setText("Albums");

        consultarAlbumButton.setText("Consultar Album");
        consultarAlbumButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarAlbumButtonActionPerformed(evt);
            }
        });

        salirButton.setText("Salir");
        salirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirButtonActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(ArbolGeneros);

        javax.swing.GroupLayout ConsultaAlbumXGenPanelLayout = new javax.swing.GroupLayout(ConsultaAlbumXGenPanel);
        ConsultaAlbumXGenPanel.setLayout(ConsultaAlbumXGenPanelLayout);
        ConsultaAlbumXGenPanelLayout.setHorizontalGroup(
            ConsultaAlbumXGenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConsultaAlbumXGenPanelLayout.createSequentialGroup()
                .addGroup(ConsultaAlbumXGenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ConsultaAlbumXGenPanelLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(obtenerAlbumsGeneroButton))
                    .addGroup(ConsultaAlbumXGenPanelLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel2))
                    .addGroup(ConsultaAlbumXGenPanelLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ConsultaAlbumXGenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(salirButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(consultarAlbumButton))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        ConsultaAlbumXGenPanelLayout.setVerticalGroup(
            ConsultaAlbumXGenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConsultaAlbumXGenPanelLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(ConsultaAlbumXGenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(obtenerAlbumsGeneroButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ConsultaAlbumXGenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ConsultaAlbumXGenPanelLayout.createSequentialGroup()
                        .addComponent(consultarAlbumButton)
                        .addGap(226, 226, 226)
                        .addComponent(salirButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ConsultaAlbumXGenPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 667, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ConsultaAlbumXGenPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void obtenerAlbumsGeneroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obtenerAlbumsGeneroButtonActionPerformed
        List<String[]> Albums = null;
        modelitoAlbums.clear();
        albumsIndex.clear();
        TreePath path = ArbolGeneros.getSelectionPath();
        if (path == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar al menos un genero", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String generoSeleccionado = path.getLastPathComponent().toString();
        
        int count = 1;
        try {
            Albums = inter.listarAlbumesDeGenero(generoSeleccionado);
            
            for (String[] d : Albums) {
                modelitoAlbums.addElement(count + " " + d[1] + " - " + d[0]);
                String[] nodo = new String[3];
                nodo[0] = d[0];
                nodo[1] = d[1];
                nodo[2] = String.valueOf(count);
                count++;
                albumsIndex.add(nodo);
            } 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Atencion!!!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_obtenerAlbumsGeneroButtonActionPerformed

    private void salirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_salirButtonActionPerformed

    private void consultarAlbumButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarAlbumButtonActionPerformed
        DataAlbumExt dataAlbum = null;
        String nomAlbum = null;
        int[] opcion;
        AlbumConsultado ventanaAlbum;
        try {
            opcion = ListaAlbumsGenero.getSelectedIndices();
            if (opcion.length != 1) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un solo album", "Atencion!!!", JOptionPane.ERROR_MESSAGE);
                return;
            }
            nomAlbum = (String)modelitoAlbums.getElementAt(ListaAlbumsGenero.getSelectedIndex());
            String[] res = null;
            //obtener indice de album en la lista...
            res = obtenerNumerodeLista(nomAlbum);
            //ir a la estructura con el indice y traerse el nombreAlbum y artista
            dataAlbum = inter.consultaAlbum(res[0],res[1]);
            ventanaAlbum = new AlbumConsultado(dataAlbum);            
            ventanaAlbum.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Atencion!!!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_consultarAlbumButtonActionPerformed

    private String[] obtenerNumerodeLista(String str) {
        int idx = str.indexOf(' ');
        String numero = str.substring(0, idx);
        String[] res = null;
        for (String[] datosAlbum: albumsIndex) {
            if(datosAlbum[2].equals(numero)) {
                res = new String[2];
                res[0] = datosAlbum[0];
                res[1] = datosAlbum[1];
                break;
            }
        }
        return res;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree ArbolGeneros;
    private javax.swing.JPanel ConsultaAlbumXGenPanel;
    private javax.swing.JList<String> ListaAlbumsGenero;
    private javax.swing.JButton consultarAlbumButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton obtenerAlbumsGeneroButton;
    private javax.swing.JButton salirButton;
    // End of variables declaration//GEN-END:variables
}
