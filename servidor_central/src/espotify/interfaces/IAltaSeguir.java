package espotify.interfaces;

import espotify.excepciones.AutoSeguirseException;
import espotify.excepciones.SeguidoInexistenteException;
import espotify.excepciones.SeguidoRepetidoException;
import espotify.excepciones.SeguidorInexistenteException;

import java.util.List;



public interface IAltaSeguir {
    public List<String> listarSeguibles(String nomSeguidor)
            throws SeguidorInexistenteException;
    
    public void altaSeguir(String nomSeguidor, String nomSeguido)
            throws SeguidorInexistenteException,SeguidoInexistenteException,
            SeguidoRepetidoException, AutoSeguirseException;
    
    public List<String> listarClientes();
}