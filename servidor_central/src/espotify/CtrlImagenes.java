package espotify;

import espotify.datatypes.DataAlbumExt;
import espotify.datatypes.DataLista;
import espotify.datatypes.DataUsuario;
import espotify.excepciones.AlbumInexistenteException;
import espotify.excepciones.ArtistaInexistenteException;
import espotify.excepciones.ClienteInexistenteException;
import espotify.excepciones.ListaInexistenteException;
import espotify.excepciones.UsuarioInexistenteException;
import espotify.interfaces.web.IObtenerImagen;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class CtrlImagenes implements IObtenerImagen {
    
    @Override
    public BufferedImage getImageUsuario(String nickUsr) throws UsuarioInexistenteException {
        try {
            DataUsuario usr = new CtrlUsuarios().buscarUsuario(nickUsr);
            BufferedImage img = usr.getImg();
            FileInputStream in = null;
            Properties props = new Properties();
            in = new FileInputStream("espotify_properties");
            props.load(in);
            in.close();
            String rutaDatosPrueba = props.getProperty("rutaDatosPrueba", "/");
            in.close();
            
            
            
            if (img == null) {
                File file = null;
                if (esArtista(nickUsr)) {
                    file = new File("."+rutaDatosPrueba+"img/artistas/artista.png");
                    try {
                        img = ImageIO.read(file);
                    } catch (IOException ex) {
                        Logger.getLogger(CtrlImagenes.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    file = new File("."+rutaDatosPrueba+"img/clientes/profile.png");
                    try {
                        img = ImageIO.read(file);
                    } catch (IOException ex) {
                        Logger.getLogger(CtrlImagenes.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            return img;
        } catch (FileNotFoundException ex) {
            return null;
        } catch (IOException ex) {
            return null;
        }
    }
    
    @Override
    public boolean esArtista(String nickUsr) {
        boolean salida = true;
        try {
            new CtrlUsuarios().buscarArtista(nickUsr);
        } catch (ArtistaInexistenteException ex) {
            salida = false;
        }
        return salida;
    }
    
    @Override
    public BufferedImage getImageAlbum(String nickUsr, String album) {
        try {
            DataAlbumExt alb = new CtrlUsuarios().consultaAlbum(album, nickUsr);
            BufferedImage img = null;
            img = alb.getImg();
            
            FileInputStream in = null;
            Properties props = new Properties();
            in = new FileInputStream("espotify_properties");
            props.load(in);
            in.close();
            String rutaDatosPrueba = props.getProperty("rutaDatosPrueba", "/");
            in.close();
            
            if (img == null) {
                File file = new File("."+rutaDatosPrueba+"img/albums/default_cover.png");
                try {
                    img = ImageIO.read(file);
                } catch (IOException ex) {
                    Logger.getLogger(CtrlImagenes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return img;
        } catch (ArtistaInexistenteException | AlbumInexistenteException ex) {
            return null;
        } catch (FileNotFoundException ex) {
            return null;
        } catch (IOException ex) {
            return null;
        }
    }
    
    @Override
    public BufferedImage getImageLista(String nickUsr, String lista) {
        try {
            DataLista list;
            BufferedImage img;
            
            FileInputStream in = null;
            Properties props = new Properties();
            in = new FileInputStream("espotify_properties");
            props.load(in);
            in.close();
            String rutaDatosPrueba = props.getProperty("rutaDatosPrueba", "/");
            in.close();
            
            
            if (nickUsr == null || nickUsr.equals("null")) {
                list = new CtrlListas().darInfoDefecto(lista);
                img = list.getImg();
            } else {
                list = new CtrlListas().darInfoParticular(lista, nickUsr);
                img = list.getImg();
            }
            if (img == null) {
                File file = new File("."+rutaDatosPrueba+"img/albums/default_cover.png");
                try {
                    img = ImageIO.read(file);
                } catch (IOException ex) {
                    Logger.getLogger(CtrlImagenes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return img;
        } catch (ClienteInexistenteException | ListaInexistenteException ex) {
            return null;
        } catch (FileNotFoundException ex) {
            return null;
        } catch (IOException ex) {
            return null;
        }        
    }
    
    @Override
    public byte[] getByteImage(BufferedImage bimg) {
        byte[] imageInByte = null;
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            ImageIO.write( bimg, "png", baos );
            baos.flush();
            imageInByte = baos.toByteArray();
        } catch (IOException ex) {
            Logger.getLogger(CtrlImagenes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return imageInByte;
    }
}
