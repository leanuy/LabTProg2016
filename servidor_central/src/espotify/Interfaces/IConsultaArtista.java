package espotify.Interfaces;

import espotify.Datatypes.DataArtistaExt;
import espotify.Excepciones.ArtistaInexistenteException;

import java.util.List;

public interface IConsultaArtista {
    public List<String> listarArtistas();

    public DataArtistaExt consultaArtista(String nick) throws ArtistaInexistenteException;
    
}