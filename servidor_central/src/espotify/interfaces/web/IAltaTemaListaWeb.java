/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espotify.interfaces.web;

import espotify.excepciones.AlbumInexistenteException;
import espotify.excepciones.ArtistaInexistenteException;
import java.util.List;

/**
 *
 * @author Santiago
 */
public interface IAltaTemaListaWeb {
    
    public List<String> listarListasDeCliente(String nick) throws Exception;
    
    public void agregarTemaListaWeb(String nick, String listaPoner, String tema, 
            String Album, String listaSacar, String usrSacar, String Artista) throws
            ArtistaInexistenteException, AlbumInexistenteException, Exception;
}
