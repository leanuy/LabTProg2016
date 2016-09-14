package espotify.interfaces;

import espotify.datatypes.DataTema;
import espotify.excepciones.ClienteInexistenteException;
import espotify.excepciones.ListaInexistenteException;

import java.util.List;

public interface IQuitarTemaLista {

    public List<String> listarClientes();

    public List<String> listarListasDeCliente(String nick)
            throws ClienteInexistenteException;

    public List<String> listarListasDefecto();

    public List<DataTema> listarTemasLista(String nombre)
            throws ClienteInexistenteException, ListaInexistenteException;

    public void removerTemaLista(String nomTema, String nomAlbum)
            throws ListaInexistenteException, ClienteInexistenteException;
}
