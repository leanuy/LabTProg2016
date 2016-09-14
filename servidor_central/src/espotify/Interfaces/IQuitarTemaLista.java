package espotify.Interfaces;

import espotify.Datatypes.DataTema;
import espotify.Excepciones.ClienteInexistenteException;
import espotify.Excepciones.ListaInexistenteException;

import java.util.List;

public interface IQuitarTemaLista {

    public List<String> ListarClientes();

    public List<String> ListarListasDeCliente(String nick)
            throws ClienteInexistenteException;

    public List<String> ListarListasDefecto();

    public List<DataTema> ListarTemasLista(String nombre)
            throws ClienteInexistenteException, ListaInexistenteException;

    public void RemoverTemaLista(String nomTema, String nomAlbum)
            throws ListaInexistenteException, ClienteInexistenteException;
}
