package espotify.interfaces.web;

import espotify.datatypes.DataGenero;
import espotify.excepciones.GeneroInexistenteException;
import java.util.List;


public interface IVerGenero {
    public List<String> listarListasDeGenero(String nomGenero)
            throws GeneroInexistenteException;
    
    public List<String[]> listarAlbumesDeGenero(String nomGenero)
            throws GeneroInexistenteException;
    
    //quizás agregar un parámetro de niveles de recursión, esto lista todo el subárbol.
    public DataGenero consultaGenero(String nomGenero)
            throws GeneroInexistenteException;
}
