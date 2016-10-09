package espotify.interfaces;

import espotify.datatypes.DataDefecto;
import espotify.datatypes.DataGenero;
import espotify.datatypes.DataParticular;
import espotify.excepciones.CampoVacioException;
import espotify.excepciones.ClienteInexistenteException;
import espotify.excepciones.GeneroInexistenteException;
import espotify.excepciones.ListaRepetidaException;

import java.util.List;


public interface IAltaLista {
    public List<String> listarClientes();

    public DataGenero listarGeneros();

    public void altaListaParticular(DataParticular dataParticular)
            throws ListaRepetidaException, ClienteInexistenteException, CampoVacioException;

    public void altaListaDefecto(DataDefecto dataLista)
            throws ListaRepetidaException, GeneroInexistenteException;
}