package Presentacion;

import espotify.Datatypes.DataAlbumExt;
import espotify.Datatypes.DataTema;
import espotify.Datatypes.DataTemaArchivo;
import espotify.Datatypes.DataTemaWeb;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

/**
 *
 * @author leandro
 */
public class AlbumConsultado extends javax.swing.JDialog {
    
    private List<DataTema> temas;
    private List<String> genders;
    private DefaultListModel modeloTemas; 
    private DefaultListModel modeloGenders; 
    private DataAlbumExt album;
    
    /**
     * Creates new form AlbumConsultado
     */
    public AlbumConsultado(DataAlbumExt data) {
        initComponents();
        album = data;
        AlbumName.setText(data.getNombre());
        nickArtista.setText(data.getNickArtista());
        anioAlbum.setText(String.valueOf(data.getAnio()));
        temas = data.getTemas();
        genders = data.getGeneros();
        modeloTemas = new DefaultListModel();  
        modeloGenders = new DefaultListModel(); 
        ListaTemas.setModel(modeloTemas);
        ListaGenders.setModel(modeloGenders);
        ListaTemas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        for(DataTema d : temas){
            modeloTemas.addElement(String.valueOf(d.getNum())+ " - " +d.getNombre() + " (" + d.getDuracion()/60+":"+d.getDuracion()%60 + ")");
        }
        for(String g: genders){
            modeloGenders.addElement(g);
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
        AlbumName = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        anioAlbum = new javax.swing.JLabel();
        ImagePanel = new javax.swing.JPanel();
        verFotoAlbum = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaTemas = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nickArtista = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        descargarTema = new javax.swing.JButton();
        salirButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        ListaGenders = new javax.swing.JList<>();

        setTitle("Album Info");

        jLabel1.setText("Nombre Album:");

        jLabel2.setText("Anio creacion:");

        verFotoAlbum.setText("Ver Album Cover");
        verFotoAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verFotoAlbumActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ImagePanelLayout = new javax.swing.GroupLayout(ImagePanel);
        ImagePanel.setLayout(ImagePanelLayout);
        ImagePanelLayout.setHorizontalGroup(
            ImagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ImagePanelLayout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(verFotoAlbum)
                .addContainerGap())
        );
        ImagePanelLayout.setVerticalGroup(
            ImagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ImagePanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(verFotoAlbum)
                .addContainerGap(174, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(ListaTemas);

        jLabel3.setText("Lista de Temas");

        jLabel4.setText("Artista:");

        jLabel5.setText("Generos del album:");

        descargarTema.setText("Descargar");
        descargarTema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descargarTemaActionPerformed(evt);
            }
        });

        salirButton.setText("Salir");
        salirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirButtonActionPerformed(evt);
            }
        });

        ListaGenders.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ListaGenders.setToolTipText("");
        jScrollPane3.setViewportView(ListaGenders);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(165, 165, 165))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(AlbumName, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                                        .addComponent(nickArtista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(anioAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)))
                .addComponent(ImagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(descargarTema)
                        .addGap(156, 156, 156)
                        .addComponent(salirButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nickArtista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AlbumName, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(anioAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(ImagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descargarTema)
                    .addComponent(salirButton))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void verFotoAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verFotoAlbumActionPerformed
        // TODO 
        // 
        if(album.getImg() == null){
            JOptionPane.showMessageDialog(this, "El album no tiene imagen", "Atencion!.", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        //help please:un alma caritativa que sabe desplegar imagenes que abra un frame loco con la foto.
        ImagenAlbum frameImagen = new ImagenAlbum(album.getImg());
        frameImagen.setVisible(true);
        
    }//GEN-LAST:event_verFotoAlbumActionPerformed

    private void salirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_salirButtonActionPerformed

    private void descargarTemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descargarTemaActionPerformed
        int indice = ListaTemas.getSelectedIndex();
        if (indice == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un tema", "Atencion!.", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String seleccion = (String)modeloTemas.getElementAt(indice);
        int numeroTema = Integer.parseInt(obtenerNumerodeLista(seleccion));
        DataTema temaElegido = null;
        //buscar el tema con ese numero. si es tema web sugerir el link si es archivo ver como abrir el chooser y que seleccione destino,
        for (DataTema da : temas) {
            if(da.getNum() == numeroTema){
                temaElegido = da;
                break;
            }
        }
        if (temaElegido == null) {
            JOptionPane.showMessageDialog(this,"Hicimos algo mal (hice je)");
            return;
        }
        if (temaElegido instanceof DataTemaWeb) {
            JTextArea a = new JTextArea();
            a.setText(((DataTemaWeb) temaElegido).getUrl());
            JOptionPane.showMessageDialog(this, a,"Link a > " +  temaElegido.getNombre(), JOptionPane.INFORMATION_MESSAGE);
        } else {
            JFileChooser fileChooser = new JFileChooser();  //en construccion
            fileChooser.setDialogTitle("Descargar Tema en...");   
            
            File fileToSave = null;
            fileChooser.setSelectedFile(new File(temaElegido.getNombre() + ".mp3"));
            
            int userSelection = fileChooser.showSaveDialog(this);
            
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                fileToSave = fileChooser.getSelectedFile();
                //System.out.println("Save as file: " + fileToSave.getAbsolutePath());
                
            } else {
                return;
            }
            if(fileToSave == null) {
                JOptionPane.showMessageDialog(this,"Problemas al seleccionar destino","Atencion!.",JOptionPane.ERROR_MESSAGE);
                return;
            }
            try {
                File fileElegido = ((DataTemaArchivo)temaElegido).getArchivo();
                
                FileInputStream fis = new FileInputStream(fileElegido);
                FileOutputStream alRes = new FileOutputStream(fileToSave);
                alRes.flush();
                byte[] buf = new byte[8192];
                while (fis.read(buf, 0, 8192) != -1){
                    alRes.write(buf);
                }
                alRes.close();
                JOptionPane.showMessageDialog(this,"Tema descargado con exito!","Well Done!.",JOptionPane.INFORMATION_MESSAGE);
            }catch(Exception e){
                JOptionPane.showMessageDialog(this,"Problemas al descargar el archivo, llame a soporte","Atencion!.",JOptionPane.ERROR_MESSAGE);
            }    
        }
    }//GEN-LAST:event_descargarTemaActionPerformed
    
    private String obtenerNumerodeLista(String s){
        int i = s.indexOf(" ");
        String numero = s.substring(0, i);
        return numero;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AlbumName;
    private javax.swing.JPanel ImagePanel;
    private javax.swing.JList<String> ListaGenders;
    private javax.swing.JList<String> ListaTemas;
    private javax.swing.JLabel anioAlbum;
    private javax.swing.JButton descargarTema;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel nickArtista;
    private javax.swing.JButton salirButton;
    private javax.swing.JButton verFotoAlbum;
    // End of variables declaration//GEN-END:variables
}
