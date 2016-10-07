/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espotify.interfaces.web;

import espotify.excepciones.AlbumInexistenteException;
import espotify.excepciones.ArtistaInexistenteException;
import espotify.excepciones.ClienteInexistenteException;
import espotify.excepciones.ListaInexistenteException;
import espotify.excepciones.UsuarioInexistenteException;
import java.awt.image.BufferedImage;

/**
 *
 * @author Santiago
 */
public interface IObtenerImagen {
    
    public BufferedImage getImageUsuario(String nickUsr) throws UsuarioInexistenteException;
    
    public boolean esArtista(String nickUsr);
    
    public BufferedImage getImageAlbum(String nickUsr, String album);
    
    public BufferedImage getImageListaDefecto(String nomLista) throws ListaInexistenteException;
    
    public BufferedImage getImageListaParticular(String nickUsr, String lista) throws ClienteInexistenteException, ListaInexistenteException;
    
    public BufferedImage getImageLista(String nickUsr, String lista);
}
