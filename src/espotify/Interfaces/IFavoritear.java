package espotify.Interfaces;

import espotify.Datatypes.DataFavoriteable;
import espotify.Excepciones.AlbumInexistenteException;
import espotify.Excepciones.ArtistaInexistenteException;
import espotify.Excepciones.ClienteInexistenteException;
import espotify.Excepciones.FavoritoRepetidoException;
import espotify.Excepciones.ListaInexistenteException;

public interface IFavoritear {
    public void Favoritear(String nick, DataFavoriteable d) throws ClienteInexistenteException, FavoritoRepetidoException, ListaInexistenteException, ArtistaInexistenteException, AlbumInexistenteException;
}