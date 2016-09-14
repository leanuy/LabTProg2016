package espotify.interfaces;

import espotify.datatypes.DataArtistaExt;
import espotify.excepciones.ArtistaInexistenteException;

import java.util.List;

public interface IConsultaArtista {
    public List<String> listarArtistas();

    public DataArtistaExt consultaArtista(String nick) throws ArtistaInexistenteException;
    
}