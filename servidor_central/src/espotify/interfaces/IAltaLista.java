package espotify.interfaces;

import espotify.datatypes.DataDefecto;
import espotify.datatypes.DataGenero;
import espotify.datatypes.DataParticular;
import espotify.excepciones.ClienteInexistenteException;
import espotify.excepciones.GeneroInexistenteException;
import espotify.excepciones.ListaRepetidaException;

import java.util.List;


public interface IAltaLista {
    public List<String> listarClientes();

    public DataGenero listarGeneros();

    public void altaListaParticular(DataParticular dLista)
            throws ListaRepetidaException, ClienteInexistenteException;

    public void altaListaDefecto(DataDefecto dLista)
            throws ListaRepetidaException, GeneroInexistenteException;
}