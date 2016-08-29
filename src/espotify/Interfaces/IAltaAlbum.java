package espotify.Interfaces;

import espotify.Datatypes.DataAlbumExt;
import espotify.Datatypes.DataGenero;
import espotify.Excepciones.AlbumRepetidoException;
import espotify.Excepciones.ArtistaInexistenteException;
import espotify.Excepciones.DuracionInvalidaException;
import espotify.Excepciones.GeneroInexistenteException;
import espotify.Excepciones.NumeroTemaInvalidoException;
import espotify.Excepciones.TemaRepetidoException;

public interface IAltaAlbum {
    public DataGenero ExisteArtista(String nickArtista)throws ArtistaInexistenteException;
    public void AltaAlbum(DataAlbumExt d) throws AlbumRepetidoException, GeneroInexistenteException, DuracionInvalidaException, NumeroTemaInvalidoException, TemaRepetidoException ;
}
