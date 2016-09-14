
package espotify.Interfaces;

import espotify.Datatypes.DataTema;
import espotify.Excepciones.AlbumInexistenteException;
import espotify.Excepciones.ArtistaInexistenteException;
import espotify.Excepciones.ClienteInexistenteException;
import espotify.Excepciones.ListaInexistenteException;

import java.util.List;


public interface IAgregarTemaLista {
    public List<String> ListarClientes();

    public List<String> ListarArtistas();

    public List<String> ListarListasDeCliente(String nick) throws Exception;

    public List<String> ListarListasDefecto();

    public List<String> ListarAlbumesDeArtista(String nomArtista) throws ArtistaInexistenteException;

    public List<String> ListarListasDefecto2();

    public List<String> ListarListasPrivadasDeCliente(String nick) throws Exception;

    public List<String> ListarListasPublicasDeCliente(String nick) throws ClienteInexistenteException;

    public List<DataTema> ListarTemasAlbum(String art, String alb) throws ArtistaInexistenteException, AlbumInexistenteException;//, Exception;

    public List<DataTema> ListarTemasLista(String nombre) throws ClienteInexistenteException, ListaInexistenteException;

    public List<DataTema> ListarTemasLista2(String nickCliente, String nomLista) throws Exception;

    public void AgregarTemaLista(DataTema tema, String lista)throws Exception;
}
