package espotify.interfaces;

import espotify.datatypes.DataAlbumExt;
import espotify.datatypes.DataGenero;
import espotify.excepciones.AlbumRepetidoException;
import espotify.excepciones.ArtistaInexistenteException;
import espotify.excepciones.CampoVacioException;
import espotify.excepciones.DuracionInvalidaException;
import espotify.excepciones.GeneroInexistenteException;
import espotify.excepciones.NumeroTemaInvalidoException;
import espotify.excepciones.TemaRepetidoException;
import espotify.excepciones.TemaTipoInvalidoException;

import java.util.List;

public interface IAltaAlbum {
    public DataGenero listarGeneros();

    public List<String> listarArtistas();

    public void altaAlbum(DataAlbumExt dataAlbum)
            throws AlbumRepetidoException, GeneroInexistenteException,
            DuracionInvalidaException, NumeroTemaInvalidoException,
            TemaRepetidoException, CampoVacioException,
            TemaTipoInvalidoException, ArtistaInexistenteException ;
}
