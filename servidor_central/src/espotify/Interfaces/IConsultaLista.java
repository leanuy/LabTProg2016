package espotify.Interfaces;

import espotify.Datatypes.DataGenero;
import espotify.Datatypes.DataLista;
import espotify.Excepciones.ClienteInexistenteException;
import espotify.Excepciones.ListaInexistenteException;

import java.util.List;

public interface IConsultaLista {
    public List<String> ListarClientes();

    public DataGenero ListarGeneros();

    public List<String> ListarListasDeGenero(String nomGenero);

    public List<String> ListarListasDeCliente(String nick)
            throws ClienteInexistenteException;

    public DataLista DarInfoParticular(String nomLista, String nick)
            throws ClienteInexistenteException, ListaInexistenteException;

    public DataLista DarInfoDefecto(String nomLista)
            throws ListaInexistenteException;
}
