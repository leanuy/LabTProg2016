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

public class CtrlImagenes implements IObtenerImagen {
    
    @Override
    public BufferedImage getImageUsuario(String nickUsr) throws UsuarioInexistenteException {
        DataUsuario usr = new CtrlUsuarios().buscarUsuario(nickUsr);
        BufferedImage img = usr.getImg();
        return img;
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
    public BufferedImage getImageAlbum(String nickUsr, String album){
        try {
            DataAlbumExt alb = new CtrlUsuarios().consultaAlbum(album, nickUsr);
            BufferedImage img = null;
            img = alb.getImg();
            return img;
        } catch (ArtistaInexistenteException | AlbumInexistenteException ex) {
            return null;
        }
    }
    
/*    @Override
    public BufferedImage getImageListaDefecto(String nomLista) throws ListaInexistenteException {
        DataLista list = new CtrlListas().darInfoDefecto(nomLista);
        BufferedImage img = list.getImg();
        return img;
    }
    
    @Override
    public BufferedImage getImageListaParticular(String nickUsr, String lista) throws ClienteInexistenteException, ListaInexistenteException {
        DataLista list = new CtrlListas().darInfoParticular(lista, nickUsr);
        BufferedImage img = list.getImg();
        return img;
    }*/
    
    @Override
    public BufferedImage getImageLista(String nickUsr, String lista) {
        try {
            DataLista list;
            BufferedImage img;
            if (nickUsr == null || nickUsr.equals("null")){
                list = new CtrlListas().darInfoDefecto(lista);
                img = list.getImg();
            } else {
                list = new CtrlListas().darInfoParticular(lista, nickUsr);
                img = list.getImg();
            }
            return img;
        } catch (ClienteInexistenteException | ListaInexistenteException ex) {
            return null;
        }        
    }
}
