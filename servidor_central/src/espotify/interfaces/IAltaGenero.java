package espotify.interfaces;

import espotify.datatypes.DataGenero;
import espotify.excepciones.GeneroInexistenteException;
import espotify.excepciones.GeneroRepetidoException;

import java.util.ArrayList;

public interface IAltaGenero {
    public DataGenero listarGeneros();

    public void altaGenero(DataGenero dataGenero)
            throws GeneroInexistenteException, GeneroRepetidoException;
}
