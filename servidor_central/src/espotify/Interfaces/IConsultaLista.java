package espotify.Interfaces;

import espotify.Datatypes.DataGenero;
import espotify.Datatypes.DataLista;
import espotify.Excepciones.ClienteInexistenteException;
import espotify.Excepciones.ListaInexistenteException;

import java.util.ArrayList;

public interface IConsultaLista {
    public ArrayList<String> ListarClientes();

    public DataGenero ListarGeneros();

    public ArrayList<String> ListarListasDeGenero(String nomGenero);

    public ArrayList<String> ListarListasDeCliente(String nick)
            throws ClienteInexistenteException;

    public DataLista DarInfoParticular(String nomLista, String nick)
            throws ClienteInexistenteException, ListaInexistenteException;

    public DataLista DarInfoDefecto(String nomLista)
            throws ListaInexistenteException;
}
