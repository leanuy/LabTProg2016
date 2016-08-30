package Presentacion;


import espotify.Datatypes.DataAlbum;
import espotify.Datatypes.DataAlbumExt;
import espotify.Datatypes.DataGenero;
import espotify.Datatypes.DataTema;
import espotify.Datatypes.DataTemaArchivo;
import espotify.Datatypes.DataTemaWeb;
import espotify.Excepciones.AlbumRepetidoException;
import espotify.Excepciones.ArtistaInexistenteException;
import espotify.Excepciones.DuracionInvalidaException;
import espotify.Excepciones.GeneroInexistenteException;
import espotify.Excepciones.NumeroTemaInvalidoException;
import espotify.Excepciones.TemaRepetidoException;
import espotify.Fabrica;
import espotify.Interfaces.IAltaAlbum;
import espotify.Interfaces.IAltaGenero;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

public class AltaAlbum extends javax.swing.JInternalFrame {
    
    private DefaultListModel modeloTemas; 
    private DefaultListModel modeloGeneros;
    private DefaultTreeModel modeloTree;
    private String pathAImagen;
    private boolean primeraVez;
    private static int numeroTema;
    private static ArrayList<DataTema> listaTemas;
    
    private static boolean web;
    private static String url;
    private static File file;
    private static String nombre;
    private static int duracion;
    private BufferedImage img = null;
    private String ArtistSelected;
    
    /**
     * Creates new form AltaAlbum
     */
    public AltaAlbum() {
        initComponents();
        modeloTemas = new DefaultListModel();
        modeloGeneros = new DefaultListModel();
        ListaTemas.setModel(modeloTemas);
        buttonConfirmarALtaAlbum.setEnabled(false);
        PanelSDatosAlbum.setEnabled(true);
        primeraVez = true;
        numeroTema = 1;
        listaTemas = new ArrayList();
        web = false;
        url = "";
        file = null;
        nombre = "";
        duracion = 0;
        img = null;
        ArbolGeneros.getSelectionModel().setSelectionMode(TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION);
        
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelBusquedaDeArtista = new javax.swing.JPanel();
        LabelnombreArtista = new javax.swing.JLabel();
        nombreArtista = new javax.swing.JTextField();
        buttonBuscarArtista = new javax.swing.JButton();
        PanelSDatosAlbum = new javax.swing.JPanel();
        LabelGeneros = new javax.swing.JLabel();
        buttonAgregarTema = new javax.swing.JButton();
        LabelNombreALbum = new javax.swing.JLabel();
        nombreAlbum = new javax.swing.JTextField();
        LabelAnioCreacion = new javax.swing.JLabel();
        anioDeCreacion = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaTemas = new javax.swing.JList<>();
        LabelTemas = new javax.swing.JLabel();
        buttonAgregarImagen = new javax.swing.JButton();
        pathALaImagen = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        buttonConfirmarALtaAlbum = new javax.swing.JButton();
        buttonCancelarAltaAlbum = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        ArbolGeneros = new javax.swing.JTree();

        setClosable(true);
        setTitle("Alta Album");

        LabelnombreArtista.setText("Nombre del Artista");

        buttonBuscarArtista.setText("Buscar");
        buttonBuscarArtista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBuscarArtistaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelBusquedaDeArtistaLayout = new javax.swing.GroupLayout(PanelBusquedaDeArtista);
        PanelBusquedaDeArtista.setLayout(PanelBusquedaDeArtistaLayout);
        PanelBusquedaDeArtistaLayout.setHorizontalGroup(
            PanelBusquedaDeArtistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBusquedaDeArtistaLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(LabelnombreArtista)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombreArtista, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonBuscarArtista)
                .addContainerGap(65, Short.MAX_VALUE))
        );
        PanelBusquedaDeArtistaLayout.setVerticalGroup(
            PanelBusquedaDeArtistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBusquedaDeArtistaLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(PanelBusquedaDeArtistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelnombreArtista)
                    .addComponent(nombreArtista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonBuscarArtista))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        LabelGeneros.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        LabelGeneros.setText("Generos");

        buttonAgregarTema.setText("Agregar Tema");
        buttonAgregarTema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAgregarTemaActionPerformed(evt);
            }
        });

        LabelNombreALbum.setText("Nombre del Album");

        LabelAnioCreacion.setText("Anio de creacion");

        jLabel1.setText("(Seleccione los generos del arbol)");

        jScrollPane1.setViewportView(ListaTemas);

        LabelTemas.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        LabelTemas.setText("Temas");

        buttonAgregarImagen.setText("Agregar Imagen");
        buttonAgregarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAgregarImagenActionPerformed(evt);
            }
        });

        jLabel2.setText("(solo archivos .jpg o .png)");

        buttonConfirmarALtaAlbum.setText("Confirmar Alta Album");
        buttonConfirmarALtaAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConfirmarALtaAlbumActionPerformed(evt);
            }
        });

        buttonCancelarAltaAlbum.setText("Cancelar Alta");
        buttonCancelarAltaAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarAltaAlbumActionPerformed(evt);
            }
        });

        ArbolGeneros.setModel(null);
        jScrollPane2.setViewportView(ArbolGeneros);

        javax.swing.GroupLayout PanelSDatosAlbumLayout = new javax.swing.GroupLayout(PanelSDatosAlbum);
        PanelSDatosAlbum.setLayout(PanelSDatosAlbumLayout);
        PanelSDatosAlbumLayout.setHorizontalGroup(
            PanelSDatosAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSDatosAlbumLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(PanelSDatosAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelSDatosAlbumLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(PanelSDatosAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelTemas)
                            .addGroup(PanelSDatosAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(PanelSDatosAlbumLayout.createSequentialGroup()
                                    .addComponent(LabelGeneros)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel1))
                                .addGroup(PanelSDatosAlbumLayout.createSequentialGroup()
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(77, 77, 77)
                                    .addGroup(PanelSDatosAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(buttonAgregarTema, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(buttonConfirmarALtaAlbum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(buttonCancelarAltaAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(53, 53, 53))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel2)
                    .addGroup(PanelSDatosAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(PanelSDatosAlbumLayout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(LabelAnioCreacion)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(anioDeCreacion, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PanelSDatosAlbumLayout.createSequentialGroup()
                            .addComponent(LabelNombreALbum)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(nombreAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PanelSDatosAlbumLayout.createSequentialGroup()
                            .addComponent(buttonAgregarImagen)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(pathALaImagen))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelSDatosAlbumLayout.setVerticalGroup(
            PanelSDatosAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSDatosAlbumLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelSDatosAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelNombreALbum)
                    .addComponent(nombreAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelGeneros)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelSDatosAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PanelSDatosAlbumLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(buttonAgregarTema, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonConfirmarALtaAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonCancelarAltaAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelSDatosAlbumLayout.createSequentialGroup()
                        .addGroup(PanelSDatosAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelAnioCreacion)
                            .addComponent(anioDeCreacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(PanelSDatosAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonAgregarImagen)
                            .addComponent(pathALaImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LabelTemas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelBusquedaDeArtista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelSDatosAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelBusquedaDeArtista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelSDatosAlbum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonBuscarArtistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBuscarArtistaActionPerformed
        //crear interfaz ver si la hacemos local o solo la use una vez y devuelva

        IAltaAlbum inter =  Fabrica.getIAltaAlbum();                 
        DataGenero generoBase = null;
        try {
            generoBase = inter.ExisteArtista(nombreArtista.getText());
        } catch (ArtistaInexistenteException ex) {
            JOptionPane.showMessageDialog(this, "El artista no existe en el sistema", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        DefaultMutableTreeNode raiz = new DefaultMutableTreeNode(generoBase.getNombre());
        modeloTree  = new DefaultTreeModel(raiz);
        ArbolGeneros.setModel(modeloTree);
        cargarArbol(generoBase,raiz);
        buttonConfirmarALtaAlbum.setEnabled(true);
        ArtistSelected = nombreArtista.getText();
    }//GEN-LAST:event_buttonBuscarArtistaActionPerformed

    private void cargarArbol(DataGenero g, DefaultMutableTreeNode padre){
        int i = 0;
        for(DataGenero d: g.getHijos()){
            DefaultMutableTreeNode nodito = new DefaultMutableTreeNode(d.getNombre());
            modeloTree.insertNodeInto(nodito,padre,i);
            i++;
            cargarArbol(d,nodito);
        }
    
    }
    
    private void buttonAgregarTemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAgregarTemaActionPerformed
        // TODO abrir el jdialog ue agregue el tema y si esta todo ok ponerlo en la lista.
        // ver que carajo agregar de cada tema
       // String tema = JOptionPane.showInputDialog(this, "Ingrese el path al tema o el link al mismo");
        //modeloTemas.addElement(tema);
        
        DialogoIngresoTema ingTema = new DialogoIngresoTema(null,"Ingrese el Tema",true); 
        ingTema.setLocationRelativeTo(this);
        
        ingTema.setVisible(true);
        
        if(web){
            DataTemaWeb dt = new DataTemaWeb(url,nombre,duracion,numeroTema);
            listaTemas.add(dt);
            modeloTemas.addElement(String.valueOf(numeroTema) + " - " + dt.getNombre());
        }else{
            DataTemaArchivo dta = new DataTemaArchivo(file,nombre,duracion,numeroTema);
            listaTemas.add(dta);
            modeloTemas.addElement(String.valueOf(numeroTema) + " - " + dta.getNombre());
        }
        numeroTema++;
        
    }//GEN-LAST:event_buttonAgregarTemaActionPerformed

    private void buttonAgregarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAgregarImagenActionPerformed
        // TODO abrir un file chooser y que file por tipo de archivo. solo jpg o png. mostrar path luego en textfield editable
        // avisar y no seleccionar si archivo no tiene la extension deseada.
        JFileChooser fc = new JFileChooser();
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
                img = ImageIO.read(file);
                pathALaImagen.setText(pathAImagen);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "La ruta al archivo no es correcta", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        fc.setVisible(false);    
    }//GEN-LAST:event_buttonAgregarImagenActionPerformed

    private void buttonConfirmarALtaAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConfirmarALtaAlbumActionPerformed
        String ext = pathALaImagen.getText();
        if(!ext.equals("") && !getExtensionDeString(ext)){
            JOptionPane.showMessageDialog(this, "Debe seleccionar una imagen formato .jpg o .png", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(!ext.equals("")){
            if(!(img instanceof BufferedImage)){
                JOptionPane.showMessageDialog(this, "Imagen invalida", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        if("".equals(nombreAlbum.getText())){
            JOptionPane.showMessageDialog(this, "Debe ingresar un nombre al album", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(listaTemas.size() == 0){
            JOptionPane.showMessageDialog(this, "Debe ingresar al menos un tema al album", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int year = 0;
        try{
            year = Integer.parseInt(anioDeCreacion.getText());
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Año de creacion invalido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        ArrayList<String> genders = new ArrayList();
        TreePath[] path = ArbolGeneros.getSelectionPaths();
        if(path == null){
            JOptionPane.showMessageDialog(this, "Debe seleccionar al menos un genero", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        for (TreePath pat : path) {
            genders.add(pat.getLastPathComponent().toString());
        }
        
        
        DataAlbumExt nuevoAlbum = new DataAlbumExt(listaTemas,nombreAlbum.getText(),year,genders,img,ArtistSelected);
        
        IAltaAlbum inter =  Fabrica.getIAltaAlbum();
        try{
            inter.AltaAlbum(nuevoAlbum);
        }
        catch(AlbumRepetidoException e){
            JOptionPane.showMessageDialog(this, "El artista que ha ingresado ya tiene un album con ese nombre. Por favor seleccione un nombre distinto.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        catch(GeneroInexistenteException e){
            JOptionPane.showMessageDialog(this, "Uno de los géneros ingresados no existe y por lo tanto no se puede agregar al album.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        catch(DuracionInvalidaException e){
            JOptionPane.showMessageDialog(this, "Uno de los temas ingresados no tiene una duración válida.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        catch(NumeroTemaInvalidoException e){
            JOptionPane.showMessageDialog(this, "Uno de los temas ingresados no tiene un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        catch(TemaRepetidoException e){
            JOptionPane.showMessageDialog(this, "Se ingresaron dos temas con el mismo nombre. El nombre de tema debe ser único.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(this, "Alta Album exitosa", "Felicitaciones", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
    }//GEN-LAST:event_buttonConfirmarALtaAlbumActionPerformed

    private void buttonCancelarAltaAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarAltaAlbumActionPerformed
        this.dispose();
    }//GEN-LAST:event_buttonCancelarAltaAlbumActionPerformed
    
    public static void cargarTema(boolean webx,String urlx,File filex,String nombrex, int duracionx){
        web = webx;
        url = urlx;
        file = filex;
        nombre = nombrex;
        duracion = duracionx;
    }

    private String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');
        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
    }
    
    private boolean getExtensionDeString(String s) {
        boolean ext = false;
        int i = s.lastIndexOf('.');
        if (i > 0 &&  i < s.length() - 1) {
            ext = "jpg".equals(s.substring(i+1).toLowerCase()) || "png".equals(s.substring(i+1).toLowerCase());
        }
        return ext;
    }
           
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree ArbolGeneros;
    private javax.swing.JLabel LabelAnioCreacion;
    private javax.swing.JLabel LabelGeneros;
    private javax.swing.JLabel LabelNombreALbum;
    private javax.swing.JLabel LabelTemas;
    private javax.swing.JLabel LabelnombreArtista;
    private javax.swing.JList<String> ListaTemas;
    private javax.swing.JPanel PanelBusquedaDeArtista;
    private javax.swing.JPanel PanelSDatosAlbum;
    private javax.swing.JTextField anioDeCreacion;
    private javax.swing.JButton buttonAgregarImagen;
    private javax.swing.JButton buttonAgregarTema;
    private javax.swing.JButton buttonBuscarArtista;
    private javax.swing.JButton buttonCancelarAltaAlbum;
    private javax.swing.JButton buttonConfirmarALtaAlbum;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nombreAlbum;
    private javax.swing.JTextField nombreArtista;
    private javax.swing.JTextField pathALaImagen;
    // End of variables declaration//GEN-END:variables
}
