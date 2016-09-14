package espotify.Interfaces;

import espotify.Datatypes.DataGenero;
import espotify.Datatypes.DataLista;
import espotify.Excepciones.ClienteInexistenteException;
import espotify.Excepciones.ListaInexistenteException;

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
