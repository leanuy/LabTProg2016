package espotify.interfaces;

import espotify.datatypes.DataGenero;
import espotify.datatypes.DataLista;
import espotify.excepciones.ClienteInexistenteException;
import espotify.excepciones.ListaInexistenteException;

import java.util.List;

public interface IConsultaLista {
    public List<String> listarClientes();

    public DataGenero listarGeneros();

    public List<String> listarListasDeGenero(String nomGenero);

    public List<String> listarListasDeCliente(String nick)
            throws ClienteInexistenteException;

    public DataLista darInfoParticular(String nomLista, String nick)
            throws ClienteInexistenteException, ListaInexistenteException;

    public DataLista darInfoDefecto(String nomLista)
            throws ListaInexistenteException;
}
