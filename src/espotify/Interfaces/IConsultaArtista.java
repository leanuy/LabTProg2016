package espotify.Interfaces;

import espotify.Datatypes.DataArtistaExt;
import espotify.Excepciones.ArtistaInexistenteException;
import java.util.ArrayList;

public interface IConsultaArtista {
    public ArrayList<String> ListarArtistas();
    public DataArtistaExt ConsultaArtista(String s) throws ArtistaInexistenteException;
    
}