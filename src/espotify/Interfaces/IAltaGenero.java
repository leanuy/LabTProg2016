package espotify.Interfaces;

import espotify.Datatypes.DataGenero;
import espotify.Excepciones.GeneroInexistenteException;
import espotify.Excepciones.GeneroRepetidoException;
import java.util.ArrayList;

public interface IAltaGenero {
    public DataGenero ListarGeneros();
    public void AltaGenero(DataGenero d) throws GeneroInexistenteException, GeneroRepetidoException;
}
