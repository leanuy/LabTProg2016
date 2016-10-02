package espotify.interfaces.web;

import espotify.datatypes.DataArtistaExt;
import espotify.datatypes.DataClienteExt;
import espotify.excepciones.ArtistaInexistenteException;
import espotify.excepciones.ClienteInexistenteException;
import espotify.excepciones.UsuarioInexistenteException;

import java.util.List;

public interface IVerPerfil {
    public DataClienteExt consultaCliente(String nick) 
            throws ClienteInexistenteException;
    
    public List<String> listarListasPublicasDeCliente(String nick)
            throws ClienteInexistenteException;
    
    public List<String> listarListasPrivadasDeCliente(String nick)
            throws ClienteInexistenteException;

    //true si es cliente, false si es artista, exception si no existe.
    public boolean esCliente(String nick)
            throws UsuarioInexistenteException;
    
    public List<String> listarAlbumesDeArtista(String nomArtista)
            throws ArtistaInexistenteException;
    
    public DataArtistaExt consultaArtista(String nick)
            throws ArtistaInexistenteException;
    
    public boolean siguiendo(String seguidor, String seguido) throws ClienteInexistenteException;
}

