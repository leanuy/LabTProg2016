
package espotify.Interfaces;

import espotify.Datatypes.DataTema;
import espotify.Excepciones.AlbumInexistenteException;
import espotify.Excepciones.ArtistaInexistenteException;
import espotify.Excepciones.ClienteInexistenteException;
import espotify.Excepciones.ListaInexistenteException;

import java.util.List;


public interface IAgregarTemaLista {
    public List<String> listarClientes();

    public List<String> listarArtistas();

    public List<String> listarListasDeCliente(String nick) throws Exception;

    public List<String> listarListasDefecto();

    public List<String> listarAlbumesDeArtista(String nomArtista) throws ArtistaInexistenteException;

    public List<String> listarListasDefecto2();

    public List<String> listarListasPrivadasDeCliente(String nick) throws Exception;

    public List<String> listarListasPublicasDeCliente(String nick) throws ClienteInexistenteException;

    public List<DataTema> listarTemasAlbum(String art, String alb) throws ArtistaInexistenteException, AlbumInexistenteException;//, Exception;

    public List<DataTema> listarTemasLista(String nombre) throws ClienteInexistenteException, ListaInexistenteException;

    public List<DataTema> listarTemasLista2(String nickCliente, String nomLista) throws Exception;

    public void agregarTemaLista(DataTema tema, String lista)throws Exception;
}
