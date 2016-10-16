package espotify.interfaces.web;

import espotify.datatypes.DataAlbumExt;
import espotify.datatypes.DataTema;
import espotify.excepciones.AlbumRepetidoException;
import espotify.excepciones.ArtistaInexistenteException;
import espotify.excepciones.CampoVacioException;
import espotify.excepciones.DuracionInvalidaException;
import espotify.excepciones.GeneroInexistenteException;
import espotify.excepciones.NumeroTemaInvalidoException;
import espotify.excepciones.TemaRepetidoException;
import espotify.excepciones.TemaTipoInvalidoException;

/**
 *
 * @author agustina
 */
public interface IAltaAlbumWeb {
    public void addAlbumTemp(DataAlbumExt album) throws ArtistaInexistenteException;
    
    public DataAlbumExt getAlbumTemp(String nickArtista)
            throws ArtistaInexistenteException;
        
    public void aceptarAltaAlbum(String nickArtista)
            throws ArtistaInexistenteException, AlbumRepetidoException,
            GeneroInexistenteException, DuracionInvalidaException,
            NumeroTemaInvalidoException, TemaRepetidoException,
            CampoVacioException, TemaTipoInvalidoException;
    
    public boolean esAlbumDeArtista(String nickArtista, String album)
            throws ArtistaInexistenteException, AlbumRepetidoException,
            GeneroInexistenteException, DuracionInvalidaException,
            NumeroTemaInvalidoException, TemaRepetidoException,
            CampoVacioException, TemaTipoInvalidoException;
    
    public void addTemaAlbumTemp(String artista, DataTema tema)
            throws ArtistaInexistenteException;
    
    public void deleteTemaAlbumTemp(String artista, String tema)
            throws ArtistaInexistenteException;
}