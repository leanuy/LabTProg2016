package espotify.Interfaces;

import espotify.Excepciones.AutoSeguirseException;
import espotify.Excepciones.SeguidoInexistenteException;
import espotify.Excepciones.SeguidoRepetidoException;
import espotify.Excepciones.SeguidorInexistenteException;

import java.util.ArrayList;



public interface IAltaSeguir {
    public ArrayList<String> ListarSeguibles(String nomSeguidor)
            throws SeguidorInexistenteException;
    
    public void AltaSeguir(String nomSeguidor, String nomSeguido)
            throws SeguidorInexistenteException,SeguidoInexistenteException,
            SeguidoRepetidoException, AutoSeguirseException;
    
    public ArrayList<String> ListarClientes();
}