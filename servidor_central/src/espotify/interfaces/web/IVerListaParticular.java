package espotify.interfaces.web;

import espotify.datatypes.DataLista;
import espotify.excepciones.ClienteInexistenteException;
import espotify.excepciones.ListaInexistenteException;

public interface IVerListaParticular {
    public DataLista darInfoParticular(String nomLista, String nick)
            throws ClienteInexistenteException, ListaInexistenteException;
    
    public boolean listaEsPrivada(String nomLista, String nick)
            throws ClienteInexistenteException, ListaInexistenteException;
    
}
