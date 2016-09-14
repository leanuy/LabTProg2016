package espotify.Interfaces;

import espotify.Datatypes.DataFavoriteable;
import espotify.Excepciones.AlbumInexistenteException;
import espotify.Excepciones.ArtistaInexistenteException;
import espotify.Excepciones.ClienteInexistenteException;
import espotify.Excepciones.FavoritoRepetidoException;
import espotify.Excepciones.ListaInexistenteException;

import java.util.List;

public interface IFavoritear {
    public void favoritear(String nick, DataFavoriteable dFav)
            throws ClienteInexistenteException, FavoritoRepetidoException,
            ListaInexistenteException, ArtistaInexistenteException, AlbumInexistenteException;

    public List<String> listarClientes();

    public List<String> listarListasPublicasDeCliente(String nick)
            throws ClienteInexistenteException;

    public List<String> listarListasDefecto();

    public List<String> listarArtistas();

    public List<String> listarAlbumesDeArtista(String nickArtista)
            throws ArtistaInexistenteException;
}