package espotify.Interfaces;

import espotify.Datatypes.DataAlbumExt;
import espotify.Datatypes.DataGenero;
import espotify.Excepciones.AlbumInexistenteException;
import espotify.Excepciones.ArtistaInexistenteException;
import espotify.Excepciones.GeneroInexistenteException;

import java.util.List;

public interface IConsultaAlbum { 
    public DataGenero listarGeneros();

    public List<String[]> listarAlbumesDeGenero(String nomGenero)
            throws GeneroInexistenteException;

    public List<String> listarArtistas();

    public List<String> listarAlbumesDeArtista(String nomArtista)
            throws ArtistaInexistenteException;

    public DataAlbumExt consultaAlbum(String nomAlbum, String nomArtista)
            throws ArtistaInexistenteException, AlbumInexistenteException;
}
