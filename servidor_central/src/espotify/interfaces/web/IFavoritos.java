package espotify.interfaces.web;

import espotify.datatypes.DataFavoriteable;
import espotify.excepciones.AlbumInexistenteException;
import espotify.excepciones.ArtistaInexistenteException;
import espotify.excepciones.ClienteInexistenteException;
import espotify.excepciones.ListaInexistenteException;
import java.util.List;

public interface IFavoritos {
    public boolean esFavorito(String nick, DataFavoriteable fav) throws ClienteInexistenteException,
            ListaInexistenteException, ArtistaInexistenteException, AlbumInexistenteException;
    
    public List<DataFavoriteable> listarFavoritos(String nick) throws ClienteInexistenteException;
}
