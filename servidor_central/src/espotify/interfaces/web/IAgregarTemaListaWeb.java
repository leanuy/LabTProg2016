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
import espotify.excepciones.TemaInexistenteException;
import java.util.List;

/**
 *
 * @author santiagoserantes
 */
public interface IAgregarTemaListaWeb {
    
    public void agregarTemaWebxAlbum(String nick_sesion, String lista_poner, 
            String nom_tema, String album, String artista) throws ArtistaInexistenteException, 
            AlbumInexistenteException, ClienteInexistenteException, Exception;
    
    /*public void agregarTemaWebxListaPub(String nick_sesion, String lista_poner, 
            String nom_tema, String lista_sacar, String usuario) throws ClienteInexistenteException, 
            ListaInexistenteException, TemaInexistenteException, Exception;
    
    public void agregarTemaWebxListaDefecto(String nick_sesion, String lista_poner, 
            String nom_tema, String lista_sacar) throws ListaInexistenteException, 
            TemaInexistenteException, ClienteInexistenteException, Exception;
*/    
    public List<String> listarListasDeCliente(String nick)
            throws ClienteInexistenteException;
    
}
