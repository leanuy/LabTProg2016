package espotify.interfaces.web;

import espotify.excepciones.AlbumInexistenteException;
import espotify.excepciones.ArtistaInexistenteException;
import espotify.excepciones.TemaTipoInvalidoException;
import java.io.BufferedInputStream;

/**
 *
 * @author JavierM42
 */
public interface IObtenerAudio {
    public BufferedInputStream getAudio(String nick, String album, String tema,boolean esDescarga)
        throws ArtistaInexistenteException, AlbumInexistenteException, TemaTipoInvalidoException;
}
