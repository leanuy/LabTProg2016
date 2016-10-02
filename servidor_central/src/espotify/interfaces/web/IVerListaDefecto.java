package espotify.interfaces.web;

import espotify.datatypes.DataLista;
import espotify.excepciones.ListaInexistenteException;

public interface IVerListaDefecto {
    public DataLista darInfoDefecto(String nomLista) throws ListaInexistenteException;
    }
