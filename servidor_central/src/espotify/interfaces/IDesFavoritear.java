package espotify.interfaces;

import espotify.datatypes.DataFavoriteable;
import espotify.excepciones.AlbumInexistenteException;
import espotify.excepciones.ArtistaInexistenteException;
import espotify.excepciones.ClienteInexistenteException;
import espotify.excepciones.FavoritoRepetidoException;
import espotify.excepciones.ListaInexistenteException;

import java.util.List;

public interface IDesFavoritear {
    public void desFavoritear(String nick, DataFavoriteable dataFav)
            throws ClienteInexistenteException, FavoritoRepetidoException,
            ListaInexistenteException, ArtistaInexistenteException,
            AlbumInexistenteException;

    public List<String> listarClientes();

    public List<String> listarListasPublicasDeCliente(String nick)
            throws ClienteInexistenteException;

    public List<String> listarListasDefecto();

    public List<String> listarArtistas();

    public List<String> listarAlbumesDeArtista(String nickArtista)
            throws ArtistaInexistenteException;

}