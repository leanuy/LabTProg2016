package espotify.Interfaces;

import espotify.Datatypes.DataAlbumExt;
import espotify.Datatypes.DataGenero;
import espotify.Excepciones.AlbumRepetidoException;
import espotify.Excepciones.ArtistaInexistenteException;
import espotify.Excepciones.CampoVacioException;
import espotify.Excepciones.DuracionInvalidaException;
import espotify.Excepciones.GeneroInexistenteException;
import espotify.Excepciones.NumeroTemaInvalidoException;
import espotify.Excepciones.TemaRepetidoException;
import espotify.Excepciones.TemaTipoInvalidoException;

import java.util.List;

public interface IAltaAlbum {
    public DataGenero ListarGeneros();

    public List<String> ListarArtistas();

    public void AltaAlbum(DataAlbumExt d)
            throws AlbumRepetidoException, GeneroInexistenteException,
            DuracionInvalidaException, NumeroTemaInvalidoException,
            TemaRepetidoException, CampoVacioException,
            TemaTipoInvalidoException, ArtistaInexistenteException ;
}
