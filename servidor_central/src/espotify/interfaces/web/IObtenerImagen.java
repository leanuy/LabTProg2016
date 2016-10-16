package espotify.interfaces.web;

import espotify.excepciones.UsuarioInexistenteException;

import java.awt.image.BufferedImage;

public interface IObtenerImagen {
    
    public BufferedImage getImageUsuario(String nickUsr) throws UsuarioInexistenteException;
    
    public boolean esArtista(String nickUsr);
    
    public BufferedImage getImageAlbum(String nickUsr, String album);
    
/*    public BufferedImage getImageListaDefecto(String nomLista)
            throws ListaInexistenteException;
    
    public BufferedImage getImageListaParticular(String nickUsr, String lista) 
           throws ClienteInexistenteException, ListaInexistenteException;*/
    
    public BufferedImage getImageLista(String nickUsr, String lista);
}
