package espotify.interfaces.web;

import espotify.datatypes.DataAlbumExt;
import espotify.excepciones.AlbumInexistenteException;
import espotify.excepciones.ArtistaInexistenteException;

public interface IVerAlbum {
        public DataAlbumExt consultaAlbum(String nomAlbum, String nomArtista)
            throws ArtistaInexistenteException, AlbumInexistenteException;
}
