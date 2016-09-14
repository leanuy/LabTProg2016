package espotify.Interfaces;

import espotify.Datatypes.DataArtistaExt;
import espotify.Excepciones.ArtistaInexistenteException;

import java.util.List;

public interface IConsultaArtista {
    public List<String> ListarArtistas();

    public DataArtistaExt ConsultaArtista(String nick) throws ArtistaInexistenteException;
    
}