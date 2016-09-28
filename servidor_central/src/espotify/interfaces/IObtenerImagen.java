/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espotify.interfaces;

import espotify.excepciones.AlbumInexistenteException;
import espotify.excepciones.ArtistaInexistenteException;
import espotify.excepciones.ClienteInexistenteException;
import espotify.excepciones.ListaInexistenteException;
import espotify.excepciones.UsuarioInexistenteException;
import java.io.File;

/**
 *
 * @author Santiago
 */
public interface IObtenerImagen {
    
    public File getImageUsuario(String nickUsr) throws UsuarioInexistenteException;
    
    public File getImageAlbum(String nickUsr, String album) throws ArtistaInexistenteException, AlbumInexistenteException;
    
    public File getImageListaDefecto(String nomLista) throws ListaInexistenteException;
    
    public File getImageListaParticular(String nickUsr, String lista) throws ClienteInexistenteException, ListaInexistenteException;
}
