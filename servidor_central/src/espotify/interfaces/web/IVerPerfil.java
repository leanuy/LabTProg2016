package espotify.interfaces.web;

import espotify.datatypes.DataArtistaExt;
import espotify.datatypes.DataClienteExt;
import espotify.excepciones.ArtistaInexistenteException;
import espotify.excepciones.ClienteInexistenteException;
import espotify.excepciones.UsuarioInexistenteException;
import java.util.ArrayList;

import java.util.List;

public interface IVerPerfil {
    public DataClienteExt consultaCliente(String nick) 
            throws ClienteInexistenteException;
    
    public ArrayList<String> listarListasPublicasDeCliente(String nick)
            throws ClienteInexistenteException;
    
    public ArrayList<String> listarListasPrivadasDeCliente(String nick)
            throws ClienteInexistenteException;

    public boolean esCliente(String nick)
            throws UsuarioInexistenteException;
    
    public ArrayList<String> listarAlbumesDeArtista(String nomArtista)
            throws ArtistaInexistenteException;
    
    public DataArtistaExt consultaArtista(String nick)
            throws ArtistaInexistenteException;
    
    public boolean siguiendo(String seguidor, String seguido) throws ClienteInexistenteException;
}

