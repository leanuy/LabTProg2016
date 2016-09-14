package espotify.Interfaces;

import espotify.Datatypes.DataAlbumExt;
import espotify.Datatypes.DataGenero;
import espotify.Excepciones.AlbumInexistenteException;
import espotify.Excepciones.ArtistaInexistenteException;
import espotify.Excepciones.GeneroInexistenteException;

import java.util.List;

public interface IConsultaAlbum { 
    public DataGenero ListarGeneros();

    public List<String[]> ListarAlbumesDeGenero(String nomGenero)
            throws GeneroInexistenteException;

    public List<String> ListarArtistas();

    public List<String> ListarAlbumesDeArtista(String nomArtista)
            throws ArtistaInexistenteException;

    public DataAlbumExt ConsultaAlbum(String nomAlbum, String nomArtista)
            throws ArtistaInexistenteException, AlbumInexistenteException;
}
