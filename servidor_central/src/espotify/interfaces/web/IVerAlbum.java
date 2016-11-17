package espotify.interfaces.web;

import espotify.datatypes.DataAlbumExt;
import espotify.datatypes.DataTema;
import espotify.excepciones.AlbumInexistenteException;
import espotify.excepciones.ArtistaInexistenteException;

public interface IVerAlbum {
    public DataAlbumExt consultaAlbum(String nomAlbum, String nomArtista)
        throws ArtistaInexistenteException, AlbumInexistenteException;

    public DataTema consultaTema(String nick, String nomAlbum, String nomTema)
            throws ArtistaInexistenteException, AlbumInexistenteException;

    public int cantDescargas(String nick, String nomAlbum, String nomTema)
            throws ArtistaInexistenteException, AlbumInexistenteException;
}
