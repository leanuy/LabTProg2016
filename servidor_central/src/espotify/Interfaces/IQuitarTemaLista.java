package espotify.Interfaces;

import espotify.Datatypes.DataTema;
import espotify.Excepciones.ClienteInexistenteException;
import espotify.Excepciones.ListaInexistenteException;

import java.util.ArrayList;

public interface IQuitarTemaLista {

    public ArrayList<String> ListarClientes();

    public ArrayList<String> ListarListasDeCliente(String nick)
            throws ClienteInexistenteException;

    public ArrayList<String> ListarListasDefecto();

    public ArrayList<DataTema> ListarTemasLista(String nombre)
            throws ClienteInexistenteException, ListaInexistenteException;

    public void RemoverTemaLista(String nomTema, String nomAlbum)
            throws ListaInexistenteException, ClienteInexistenteException;
}
