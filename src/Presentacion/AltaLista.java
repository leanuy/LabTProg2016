package Presentacion;

import espotify.Datatypes.DataDefecto;
import espotify.Datatypes.DataGenero;
import espotify.Datatypes.DataParticular;
import espotify.Fabrica;
import espotify.Interfaces.IAltaGenero;
import espotify.Interfaces.IAltaLista;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

public class AltaLista extends javax.swing.JInternalFrame {

    private DefaultTreeModel modeloTree;

    /**
     * Creates new form AltaLista
     */
    public AltaLista() {
        initComponents();
        
        particularRadio.setSelected(true);
        IAltaLista ctrl = Fabrica.getIAltaLista();
        ArrayList<String> a = ctrl.ListarClientes();
        DefaultListModel<String> model = new DefaultListModel<>();
        clientlist.setModel(model);
        for(String str : a) {
            model.addElement(str);
        }
        
        ArbolGeneros.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        IAltaLista inter =  Fabrica.getIAltaLista();                 
        DataGenero generoBase = inter.ListarGeneros();
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

        tipoListagroup = new javax.swing.ButtonGroup();
        okDialog = new javax.swing.JDialog();
        mainpanel = new javax.swing.JPanel();
        defectoRadio = new javax.swing.JRadioButton();
        particularRadio = new javax.swing.JRadioButton();
        nombretxt = new javax.swing.JTextField();
        pathimgtxt = new javax.swing.JTextField();
        imgbtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        particularpanel = new javax.swing.JPanel();
        clientscrollpane = new javax.swing.JScrollPane();
        clientlist = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        confirmbtn = new javax.swing.JButton();
        defectopanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ArbolGeneros = new javax.swing.JTree();

        javax.swing.GroupLayout okDialogLayout = new javax.swing.GroupLayout(okDialog.getContentPane());
        okDialog.getContentPane().setLayout(okDialogLayout);
        okDialogLayout.setHorizontalGroup(
            okDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        okDialogLayout.setVerticalGroup(
            okDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setClosable(true);
        setResizable(true);
        setTitle("Crear Lista de Reproducción");

        tipoListagroup.add(defectoRadio);
        defectoRadio.setText("Por Defecto");

        tipoListagroup.add(particularRadio);
        particularRadio.setText("Particular");
        particularRadio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                particularRadioItemStateChanged(evt);
            }
        });

        imgbtn.setText("Browse...");
        imgbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imgbtnActionPerformed(evt);
            }
        });

        jLabel3.setText("Imagen:");

        jLabel1.setText("Nombre*:");

        clientlist.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        clientscrollpane.setViewportView(clientlist);

        jLabel4.setText("Cliente:");

        javax.swing.GroupLayout particularpanelLayout = new javax.swing.GroupLayout(particularpanel);
        particularpanel.setLayout(particularpanelLayout);
        particularpanelLayout.setHorizontalGroup(
            particularpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(particularpanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clientscrollpane, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
        );
        particularpanelLayout.setVerticalGroup(
            particularpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(particularpanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(particularpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clientscrollpane)
                    .addGroup(particularpanelLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 185, Short.MAX_VALUE)))
                .addContainerGap())
        );

        confirmbtn.setText("Confirmar");
        confirmbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmbtnActionPerformed(evt);
            }
        });

        jLabel2.setText("Género:");

        ArbolGeneros.setModel(null);
        jScrollPane1.setViewportView(ArbolGeneros);

        javax.swing.GroupLayout defectopanelLayout = new javax.swing.GroupLayout(defectopanel);
        defectopanel.setLayout(defectopanelLayout);
        defectopanelLayout.setHorizontalGroup(
            defectopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(defectopanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        defectopanelLayout.setVerticalGroup(
            defectopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(defectopanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(defectopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(defectopanelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 186, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout mainpanelLayout = new javax.swing.GroupLayout(mainpanel);
        mainpanel.setLayout(mainpanelLayout);
        mainpanelLayout.setHorizontalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainpanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainpanelLayout.createSequentialGroup()
                        .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainpanelLayout.createSequentialGroup()
                                .addComponent(defectoRadio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(particularRadio))
                            .addGroup(mainpanelLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nombretxt, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(mainpanelLayout.createSequentialGroup()
                                        .addComponent(pathimgtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(imgbtn))))
                            .addGroup(mainpanelLayout.createSequentialGroup()
                                .addComponent(particularpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(defectopanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainpanelLayout.createSequentialGroup()
                        .addComponent(confirmbtn)
                        .addGap(165, 165, 165))))
        );
        mainpanelLayout.setVerticalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainpanelLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(defectoRadio)
                    .addComponent(particularRadio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nombretxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(pathimgtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imgbtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(defectopanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(mainpanelLayout.createSequentialGroup()
                        .addComponent(particularpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 1, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(confirmbtn))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void confirmbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmbtnActionPerformed
        if(particularRadio.isSelected())
        {
            try
            {
                IAltaLista ctrl = Fabrica.getIAltaLista();
                String nomCli = clientlist.getSelectedValue();
                DataParticular d = new DataParticular(nomCli, nombretxt.getText(),pathimgtxt.getText());
                ctrl.AltaListaParticular(d);
                JOptionPane.showMessageDialog(okDialog,
                    "Operación completada con éxito",
                    "OK",
                    JOptionPane.PLAIN_MESSAGE);
                this.dispose();
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(okDialog,
                    e.getMessage(),
                    "Error",
                    JOptionPane.PLAIN_MESSAGE);
            }
        }
        else
        {
            try
            {
                IAltaLista ctrl = Fabrica.getIAltaLista();
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) ArbolGeneros.getLastSelectedPathComponent();
                String nomGenero = "";
                if (node != null)
                    nomGenero = (String)node.getUserObject();
                DataDefecto d = new DataDefecto(nomGenero, nombretxt.getText(),pathimgtxt.getText());
                ctrl.AltaListaDefecto(d);
                JOptionPane.showMessageDialog(okDialog,
                    "Operación completada con éxito",
                    "OK",
                    JOptionPane.PLAIN_MESSAGE);
                this.dispose();
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(okDialog,
                    e.getMessage(),
                    "Error",
                    JOptionPane.PLAIN_MESSAGE);
            }
        }
    }//GEN-LAST:event_confirmbtnActionPerformed

    private void imgbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imgbtnActionPerformed
        JFileChooser fc = new JFileChooser();
        String pathAImagen;
        this.getContentPane().add(fc);
        fc.setVisible(true);

        int selected = fc.showDialog(this, "Seleccionar");
        if(selected == JFileChooser.APPROVE_OPTION){
            File file = fc.getSelectedFile();
            try {
                pathAImagen = file.getCanonicalPath();
                String ext = getExtension(file);
                if(!"jpg".equals(ext) && !"png".equals(ext)){
                    JOptionPane.showMessageDialog(this, "Debe seleccionar una imagen formato .jpg o .png", "Error", JOptionPane.ERROR_MESSAGE);
                    fc.setVisible(false);
                    return;
                }
                pathimgtxt.setText(pathAImagen);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "La ruta al archivo no es correcta", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        fc.setVisible(false);
    }//GEN-LAST:event_imgbtnActionPerformed

    private void particularRadioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_particularRadioItemStateChanged
        if(particularRadio.isSelected())
        {
            particularpanel.setVisible(true);
            defectopanel.setVisible(false);
        }
        else
        {
            particularpanel.setVisible(false);
            defectopanel.setVisible(true);
        }
    }//GEN-LAST:event_particularRadioItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree ArbolGeneros;
    private javax.swing.JList<String> clientlist;
    private javax.swing.JScrollPane clientscrollpane;
    private javax.swing.JButton confirmbtn;
    private javax.swing.JRadioButton defectoRadio;
    private javax.swing.JPanel defectopanel;
    private javax.swing.JButton imgbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainpanel;
    private javax.swing.JTextField nombretxt;
    private javax.swing.JDialog okDialog;
    private javax.swing.JRadioButton particularRadio;
    private javax.swing.JPanel particularpanel;
    private javax.swing.JTextField pathimgtxt;
    private javax.swing.ButtonGroup tipoListagroup;
    // End of variables declaration//GEN-END:variables

    private String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');
        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
    }

}
