package presentacion;

import espotify.datatypes.DataArtista;
import espotify.datatypes.DataCliente;
import espotify.excepciones.CorreoRepetidoException;
import espotify.excepciones.FormatoIncorrectoException;
import espotify.excepciones.NickRepetidoException;
import espotify.excepciones.PasswordsDistintasException;
import espotify.Fabrica;
import espotify.interfaces.IAltaPerfil;

import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;



public class internalAltaPerfil extends javax.swing.JInternalFrame {

    /**
     * Creates new form internalAltaPerfil
     */
    public internalAltaPerfil() {
        initComponents();
        biotxt.setEnabled(false);
        urltxt.setEnabled(false);
        clienteRadio.setSelected(true);
    }
    
    BufferedImage img = null;

    IAltaPerfil ctrl = Fabrica.getIAltaPerfil();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tipoUserGroup = new javax.swing.ButtonGroup();
        okDialog = new javax.swing.JDialog();
        contenedor = new javax.swing.JPanel();
        nickLabel = new javax.swing.JLabel();
        nicktxt = new javax.swing.JTextField();
        nomtxt = new javax.swing.JTextField();
        apetxt = new javax.swing.JTextField();
        mailtxt = new javax.swing.JTextField();
        nomlabel = new javax.swing.JLabel();
        apelabel = new javax.swing.JLabel();
        maillabel = new javax.swing.JLabel();
        fechatxt = new javax.swing.JFormattedTextField();
        fechalabel = new javax.swing.JLabel();
        imglabel = new javax.swing.JLabel();
        imagentxt = new javax.swing.JTextField();
        imgbtn = new javax.swing.JButton();
        clienteRadio = new javax.swing.JRadioButton();
        artistaRadio = new javax.swing.JRadioButton();
        biolabel = new javax.swing.JLabel();
        bioscroll = new javax.swing.JScrollPane();
        biotxt = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        urltxt = new javax.swing.JTextField();
        confirmbtn = new javax.swing.JButton();
        pwdtxt = new javax.swing.JTextField();
        pwdcnonfirmtxt = new javax.swing.JTextField();
        nickLabel1 = new javax.swing.JLabel();
        nickLabel2 = new javax.swing.JLabel();

        okDialog.setTitle("Ok");
        okDialog.setResizable(false);

        javax.swing.GroupLayout okDialogLayout = new javax.swing.GroupLayout(okDialog.getContentPane());
        okDialog.getContentPane().setLayout(okDialogLayout);
        okDialogLayout.setHorizontalGroup(
            okDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 214, Short.MAX_VALUE)
        );
        okDialogLayout.setVerticalGroup(
            okDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 57, Short.MAX_VALUE)
        );

        setClosable(true);
        setTitle("Alta de Perfil");

        nickLabel.setText("Nickname*:");

        nomlabel.setText("Nombre*:");

        apelabel.setText("Apellido*:");

        maillabel.setText("Correo*:");

        fechatxt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("d/M/yy"))));

        fechalabel.setText("Fecha de Nacimiento (dd/mm/aa)*:");

        imglabel.setText("Imagen:");

        imgbtn.setText("Browse...");
        imgbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imgbtnActionPerformed(evt);
            }
        });

        tipoUserGroup.add(clienteRadio);
        clienteRadio.setText("Cliente");

        tipoUserGroup.add(artistaRadio);
        artistaRadio.setText("Artista");
        artistaRadio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                artistaRadioItemStateChanged(evt);
            }
        });

        biolabel.setText("Biografía:");

        biotxt.setColumns(20);
        biotxt.setRows(5);
        bioscroll.setViewportView(biotxt);

        jLabel1.setText("URL:");

        confirmbtn.setText("Confirmar");
        confirmbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmbtnActionPerformed(evt);
            }
        });

        nickLabel1.setText("Contraseña*:");

        nickLabel2.setText("Confirmación de Contraseña*:");

        javax.swing.GroupLayout contenedorLayout = new javax.swing.GroupLayout(contenedor);
        contenedor.setLayout(contenedorLayout);
        contenedorLayout.setHorizontalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(imglabel)
                    .addComponent(nickLabel)
                    .addComponent(nomlabel)
                    .addComponent(apelabel)
                    .addComponent(maillabel)
                    .addComponent(fechalabel)
                    .addComponent(biolabel)
                    .addComponent(jLabel1)
                    .addComponent(nickLabel1)
                    .addComponent(nickLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contenedorLayout.createSequentialGroup()
                        .addComponent(pwdtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenedorLayout.createSequentialGroup()
                        .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fechatxt)
                            .addGroup(contenedorLayout.createSequentialGroup()
                                .addComponent(imagentxt, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(imgbtn)
                        .addGap(22, 22, 22))
                    .addGroup(contenedorLayout.createSequentialGroup()
                        .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(contenedorLayout.createSequentialGroup()
                                    .addComponent(clienteRadio)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(artistaRadio))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(nicktxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                                    .addComponent(nomtxt, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(mailtxt, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(apetxt, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addComponent(confirmbtn)
                            .addComponent(bioscroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(urltxt, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pwdcnonfirmtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(53, Short.MAX_VALUE))))
        );
        contenedorLayout.setVerticalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clienteRadio)
                    .addComponent(artistaRadio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nickLabel)
                    .addComponent(nicktxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pwdtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nickLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pwdcnonfirmtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nickLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomlabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(apetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apelabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mailtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maillabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fechatxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fechalabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(imagentxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imglabel)
                    .addComponent(imgbtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(biolabel)
                    .addComponent(bioscroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(urltxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confirmbtn)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void artistaRadioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_artistaRadioItemStateChanged
        if (biotxt.isEnabled()) {
            biotxt.setEnabled(false);
            urltxt.setEnabled(false);
            urltxt.setText("");
            biotxt.setText("");
        }
        else {
            biotxt.setEnabled(true);
            urltxt.setEnabled(true);
        }
    }//GEN-LAST:event_artistaRadioItemStateChanged

    private void confirmbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmbtnActionPerformed
        if (clienteRadio.isSelected()) {
            try {
                Calendar fNac = Calendar.getInstance(); //TODO
                SimpleDateFormat sdf = new SimpleDateFormat("d/M/y");
                fNac.setTime(sdf.parse(fechatxt.getText()));
                String pwd = pwdtxt.getText();
                String verif = pwdcnonfirmtxt.getText();
                if (!pwd.equals(verif)) {
                    throw new PasswordsDistintasException();
                }
                DataCliente dCliente = new DataCliente(
                                nicktxt.getText(),
                                nomtxt.getText(),
                                apetxt.getText(),
                                mailtxt.getText(),
                                fNac,
                                img,
                                pwd);
                ctrl.altaCliente(dCliente);
                ResetCampos();
                JOptionPane.showMessageDialog(okDialog,
                    "Operación completada con éxito",
                    "OK",
                    JOptionPane.PLAIN_MESSAGE);
                this.dispose();
            }
            catch (NickRepetidoException e) {
                JOptionPane.showMessageDialog(okDialog,
                        "Ya existe un usuario con ese nick",
                        "Error", JOptionPane.PLAIN_MESSAGE);
            }
            catch (CorreoRepetidoException e) {
                JOptionPane.showMessageDialog(okDialog,
                        "Ya existe un usuario con ese correo",
                        "Error", JOptionPane.PLAIN_MESSAGE);
            }
            catch (FormatoIncorrectoException e) {
                JOptionPane.showMessageDialog(okDialog,
                        "El formato de correo no es correcto, o algún campo obligatorio está vacío",
                        "Error", JOptionPane.PLAIN_MESSAGE);
            }
            catch (PasswordsDistintasException e) {
                JOptionPane.showMessageDialog(okDialog,
                        "Las contraseñas no coinciden.",
                        "Error", JOptionPane.PLAIN_MESSAGE);
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(okDialog,
                    "Datos invalidos, revise",
                    "Error",
                    JOptionPane.PLAIN_MESSAGE);
            }
        }
        else {
            try {
                Calendar fNac = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("d/M/y");
                fNac.setTime(sdf.parse(fechatxt.getText()));
                String pwd = pwdtxt.getText();
                String verif = pwdcnonfirmtxt.getText();
                if (!pwd.equals(verif)) {
                    throw new PasswordsDistintasException();
                }
                DataArtista dArt = new DataArtista(
                                biotxt.getText(),
                                urltxt.getText(),
                                nicktxt.getText(),
                                nomtxt.getText(),
                                apetxt.getText(),
                                mailtxt.getText(),
                                fNac,
                                img,
                                pwd);
                ctrl.altaArtista(dArt);
                ResetCampos();
                JOptionPane.showMessageDialog(okDialog,
                    "Operación completada con éxito",
                    "OK",
                    JOptionPane.PLAIN_MESSAGE);
                this.dispose();
            }
            catch (NickRepetidoException e) {
                JOptionPane.showMessageDialog(okDialog, "Ya existe un usuario con ese nick", "Error", JOptionPane.PLAIN_MESSAGE);
            }
            catch (CorreoRepetidoException e) {
                JOptionPane.showMessageDialog(okDialog, "Ya existe un usuario con ese correo", "Error", JOptionPane.PLAIN_MESSAGE);
            }
            catch (FormatoIncorrectoException e) {
                JOptionPane.showMessageDialog(okDialog, "El formato de correo no es correcto, o algún campo obligatorio está vacío", "Error", JOptionPane.PLAIN_MESSAGE);
            }
            catch (PasswordsDistintasException e) {
                JOptionPane.showMessageDialog(okDialog, "Las contraseñas no coinciden.", "Error", JOptionPane.PLAIN_MESSAGE);
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(okDialog,
                    e.getMessage(),
                    "Error",
                    JOptionPane.PLAIN_MESSAGE);
            }
        }    
        
            
    }//GEN-LAST:event_confirmbtnActionPerformed

    private void imgbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imgbtnActionPerformed
        JFileChooser fChooser = new JFileChooser();
        this.getContentPane().add(fChooser);
        fChooser.setVisible(true);
        
        int selected = fChooser.showDialog(this, "Seleccionar");
        if (selected == JFileChooser.APPROVE_OPTION) {
            File file = fChooser.getSelectedFile();
            try {
                String ext = getExtension(file);
                if (!"jpg".equals(ext) && !"png".equals(ext)) {
                    JOptionPane.showMessageDialog(this, "Debe seleccionar una imagen formato .jpg o .png", "Error", JOptionPane.ERROR_MESSAGE);
                    fChooser.setVisible(false);
                    return;
                }
                img = ImageIO.read(file);
                String pathAImagen = file.getCanonicalPath();
                imagentxt.setText(pathAImagen);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "La ruta al archivo no es correcta", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        fChooser.setVisible(false);    
    }//GEN-LAST:event_imgbtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel apelabel;
    private javax.swing.JTextField apetxt;
    private javax.swing.JRadioButton artistaRadio;
    private javax.swing.JLabel biolabel;
    private javax.swing.JScrollPane bioscroll;
    private javax.swing.JTextArea biotxt;
    private javax.swing.JRadioButton clienteRadio;
    private javax.swing.JButton confirmbtn;
    private javax.swing.JPanel contenedor;
    private javax.swing.JLabel fechalabel;
    private javax.swing.JFormattedTextField fechatxt;
    private javax.swing.JTextField imagentxt;
    private javax.swing.JButton imgbtn;
    private javax.swing.JLabel imglabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel maillabel;
    private javax.swing.JTextField mailtxt;
    private javax.swing.JLabel nickLabel;
    private javax.swing.JLabel nickLabel1;
    private javax.swing.JLabel nickLabel2;
    private javax.swing.JTextField nicktxt;
    private javax.swing.JLabel nomlabel;
    private javax.swing.JTextField nomtxt;
    private javax.swing.JDialog okDialog;
    private javax.swing.JTextField pwdcnonfirmtxt;
    private javax.swing.JTextField pwdtxt;
    private javax.swing.ButtonGroup tipoUserGroup;
    private javax.swing.JTextField urltxt;
    // End of variables declaration//GEN-END:variables

    private void ResetCampos() {
        nicktxt.setText("");
        nomtxt.setText("");
        apetxt.setText("");
        mailtxt.setText("");
        fechatxt.setText("");
        imagentxt.setText("");
        biotxt.setText("");
        urltxt.setText("");
    }
    
    private String getExtension(File file) {
        String ext = null;
        String nomArchivo = file.getName();
        int idx = nomArchivo.lastIndexOf('.');
        if (idx > 0 &&  idx < nomArchivo.length() - 1) {
            ext = nomArchivo.substring(idx + 1).toLowerCase();
        }
        return ext;
    }
}
