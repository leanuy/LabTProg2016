package espotify.Interfaces;

import espotify.Datatypes.DataDefecto;
import espotify.Datatypes.DataGenero;
import espotify.Datatypes.DataParticular;
import espotify.Excepciones.ClienteInexistenteException;
import espotify.Excepciones.GeneroInexistenteException;
import espotify.Excepciones.ListaRepetidaException;

import java.util.List;


public interface IAltaLista {
    public List<String> ListarClientes();

    public DataGenero ListarGeneros();

    public void AltaListaParticular(DataParticular d)
            throws ListaRepetidaException, ClienteInexistenteException;

    public void AltaListaDefecto(DataDefecto d)
            throws ListaRepetidaException, GeneroInexistenteException;
}