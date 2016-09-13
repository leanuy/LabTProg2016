package espotify.Interfaces;

import espotify.Datatypes.DataDefecto;
import espotify.Datatypes.DataGenero;
import espotify.Datatypes.DataParticular;
import espotify.Excepciones.ClienteInexistenteException;
import espotify.Excepciones.GeneroInexistenteException;
import espotify.Excepciones.ListaRepetidaException;
import java.util.ArrayList;


public interface IAltaLista {
    public ArrayList<String> ListarClientes();
    public DataGenero ListarGeneros();
    public void AltaListaParticular(DataParticular d) throws ListaRepetidaException, ClienteInexistenteException;
    public void AltaListaDefecto(DataDefecto d) throws ListaRepetidaException, GeneroInexistenteException;
}