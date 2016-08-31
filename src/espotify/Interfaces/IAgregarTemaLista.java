
package espotify.Interfaces;

import espotify.Datatypes.DataTema;
import espotify.Excepciones.AlbumInexistenteException;
import espotify.Excepciones.ArtistaInexistenteException;
import espotify.Excepciones.ClienteInexistenteException;
import espotify.Excepciones.ListaInexistenteException;
import espotify.Tema;
import java.util.ArrayList;


public interface IAgregarTemaLista {
    public ArrayList<String> ListarClientes();
    public ArrayList<String> ListarArtistas();
    public ArrayList<String> ListarListasDeCliente(String nick) throws Exception;
    public ArrayList<String> ListarListasDefecto();
    public ArrayList<String> ListarAlbumesDeArtista(String na) throws Exception;
    public ArrayList<String> ListarListasPrivadasDeCliente(String nick) throws Exception;
    public ArrayList<String> ListarListasPubliasDeCliente(String nick) throws Exception;
    public ArrayList<DataTema> ListarTemasAlbum(String art, String alb) throws ArtistaInexistenteException, AlbumInexistenteException;//, Exception;
    public ArrayList<DataTema> ListarTemasLista(String nombre) throws ClienteInexistenteException, ListaInexistenteException;
    public ArrayList<DataTema> ListarTemasLista2(String cl, String l) throws Exception;
    public void AgregarTemaLista(DataTema tema, String lista)throws Exception;
}
