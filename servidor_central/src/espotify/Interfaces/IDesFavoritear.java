package espotify.Interfaces;

import espotify.Datatypes.DataFavoriteable;
import espotify.Excepciones.AlbumInexistenteException;
import espotify.Excepciones.ArtistaInexistenteException;
import espotify.Excepciones.ClienteInexistenteException;
import espotify.Excepciones.FavoritoRepetidoException;
import espotify.Excepciones.ListaInexistenteException;

import java.util.List;

public interface IDesFavoritear {
    public void DesFavoritear(String nick, DataFavoriteable dFav)
            throws ClienteInexistenteException, FavoritoRepetidoException,
            ListaInexistenteException, ArtistaInexistenteException,
            AlbumInexistenteException;

    public List<String> ListarClientes();

    public List<String> ListarListasPublicasDeCliente(String nick)
            throws ClienteInexistenteException;

    public List<String> ListarListasDefecto();

    public List<String> ListarArtistas();

    public List<String> ListarAlbumesDeArtista(String nickArtista)
            throws ArtistaInexistenteException;

}