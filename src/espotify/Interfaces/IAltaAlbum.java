package espotify.Interfaces;

import espotify.Datatypes.DataAlbumExt;
import espotify.Datatypes.DataGenero;

public interface IAltaAlbum {
    public DataGenero ExisteArtista(String nickArtista)throws Exception;
    public void AltaAlbum(DataAlbumExt d) throws Exception;
}
