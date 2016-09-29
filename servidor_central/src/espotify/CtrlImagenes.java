/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Santiago
 */
public class CtrlImagenes implements IObtenerImagen {
    
    @Override
    public BufferedImage getImageUsuario(String nickUsr) throws UsuarioInexistenteException {
        DataUsuario usr = new CtrlUsuarios().buscarUsuario(nickUsr);
        BufferedImage img = usr.getImg();
        if (img == null) {
            File file = new File("./src/Presentacion/img/clientes/ElPadrino.png");
            try {
                img = ImageIO.read(file);
            } catch (IOException ex) {
                Logger.getLogger(CtrlImagenes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return img;
    }
    
    @Override
    public BufferedImage getImageAlbum(String nickUsr, String album) throws ArtistaInexistenteException, AlbumInexistenteException {
        DataAlbumExt alb = new CtrlUsuarios().consultaAlbum(album, nickUsr);
        BufferedImage img = alb.getImg();
        if (img == null) {
            File file = new File("./src/Presentacion/img/clientes/ElPadrino.png");
            try {
                img = ImageIO.read(file);
            } catch (IOException ex) {
                Logger.getLogger(CtrlImagenes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return img;
    }
    
    @Override
    public BufferedImage getImageListaDefecto(String nomLista) throws ListaInexistenteException {
        DataLista list = new CtrlListas().darInfoDefecto(nomLista);
        BufferedImage img = list.getImg();
        if (img == null) {
            File file = new File("./src/Presentacion/img/clientes/ElPadrino.png");
            try {
                img = ImageIO.read(file);
            } catch (IOException ex) {
                Logger.getLogger(CtrlImagenes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return img;
    }
    
    @Override
    public BufferedImage getImageListaParticular(String nickUsr, String lista) throws ClienteInexistenteException, ListaInexistenteException {
        DataLista list = new CtrlListas().darInfoParticular(lista, nickUsr);
        BufferedImage img = list.getImg();
        if (img == null) {
            File file = new File("./src/Presentacion/img/clientes/ElPadrino.png");
            try {
                img = ImageIO.read(file);
            } catch (IOException ex) {
                Logger.getLogger(CtrlImagenes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return img;
    }
}
