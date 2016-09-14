package espotify.Interfaces;

import espotify.Datatypes.DataGenero;
import espotify.Excepciones.GeneroInexistenteException;
import espotify.Excepciones.GeneroRepetidoException;

import java.util.ArrayList;

public interface IAltaGenero {
    public DataGenero listarGeneros();

    public void altaGenero(DataGenero dGenero)
            throws GeneroInexistenteException, GeneroRepetidoException;
}
