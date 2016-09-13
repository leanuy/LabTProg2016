package espotify.Interfaces;

import espotify.Datatypes.DataFavoriteable;
import espotify.Excepciones.AlbumInexistenteException;
import espotify.Excepciones.ArtistaInexistenteException;
import espotify.Excepciones.ClienteInexistenteException;
import espotify.Excepciones.FavoritoRepetidoException;
import espotify.Excepciones.ListaInexistenteException;
import java.util.ArrayList;

public interface IFavoritear {
    public void Favoritear(String nick, DataFavoriteable d) throws ClienteInexistenteException, FavoritoRepetidoException, ListaInexistenteException, ArtistaInexistenteException, AlbumInexistenteException;
    public ArrayList<String> ListarClientes();
    public ArrayList<String> ListarListasPublicasDeCliente(String nick) throws ClienteInexistenteException;
    public ArrayList<String> ListarListasDefecto();
    public ArrayList<String> ListarArtistas();
    public ArrayList<String> ListarAlbumesDeArtista(String nickArtista) throws ArtistaInexistenteException;
}