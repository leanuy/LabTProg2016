package espotify.interfaces;

import espotify.datatypes.DataAlbumExt;
import espotify.datatypes.DataGenero;
import espotify.excepciones.AlbumInexistenteException;
import espotify.excepciones.ArtistaInexistenteException;
import espotify.excepciones.GeneroInexistenteException;

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
