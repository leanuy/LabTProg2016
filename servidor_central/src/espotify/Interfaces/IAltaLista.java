package espotify.Interfaces;

import espotify.Datatypes.DataDefecto;
import espotify.Datatypes.DataGenero;
import espotify.Datatypes.DataParticular;
import espotify.Excepciones.ClienteInexistenteException;
import espotify.Excepciones.GeneroInexistenteException;
import espotify.Excepciones.ListaRepetidaException;

import java.util.List;


public interface IAltaLista {
    public List<String> listarClientes();

    public DataGenero listarGeneros();

    public void altaListaParticular(DataParticular dLista)
            throws ListaRepetidaException, ClienteInexistenteException;

    public void altaListaDefecto(DataDefecto dLista)
            throws ListaRepetidaException, GeneroInexistenteException;
}