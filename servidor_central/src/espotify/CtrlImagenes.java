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
import espotify.interfaces.IObtenerImagen;
import java.io.File;

/**
 *
 * @author Santiago
 */
public class CtrlImagenes implements IObtenerImagen {
    
    @Override
    public File getImageUsuario(String nickUsr) throws UsuarioInexistenteException {
        DataUsuario usr = new CtrlUsuarios().buscarUsuario(nickUsr);
        return usr.getImg();
    }
    
    @Override
    public File getImageAlbum(String nickUsr, String album) throws ArtistaInexistenteException, AlbumInexistenteException {
        DataAlbumExt alb = new CtrlUsuarios().consultaAlbum(album, nickUsr);
        return alb.getImg();
    }
    
    @Override
    public File getImageListaDefecto(String nomLista) throws ListaInexistenteException {
        DataLista list = new CtrlListas().darInfoDefecto(nomLista);
        return list.getImg();
    }
    
    @Override
    public File getImageListaParticular(String nickUsr, String lista) throws ClienteInexistenteException, ListaInexistenteException {
        DataLista list = new CtrlListas().darInfoParticular(lista, nickUsr);
        return list.getImg();
    }
}
