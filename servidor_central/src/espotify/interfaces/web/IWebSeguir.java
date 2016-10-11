package espotify.interfaces.web;

import espotify.excepciones.AutoSeguirseException;
import espotify.excepciones.SeguidoInexistenteException;
import espotify.excepciones.SeguidoRepetidoException;
import espotify.excepciones.SeguidorInexistenteException;

/**
 *
 * @author Santiago
 */
public interface IWebSeguir {
    public void altaSeguir(String nomSeguidor, String nomSeguido)
            throws SeguidorInexistenteException, SeguidoInexistenteException,
            SeguidoRepetidoException, AutoSeguirseException;
    
    public void dejarDeSeguir(String nomSeguidor, String nomSeguido)
            throws SeguidoInexistenteException, SeguidorInexistenteException;
}
