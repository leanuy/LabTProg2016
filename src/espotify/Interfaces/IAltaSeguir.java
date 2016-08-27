package espotify.Interfaces;

import espotify.Excepciones.AutoSeguirseException;
import espotify.Excepciones.SeguidoInexistenteException;
import espotify.Excepciones.SeguidoRepetidoException;
import espotify.Excepciones.SeguidorInexistenteException;



public interface IAltaSeguir {
    public String[] DevolverClientes();
    public String[] DevolverArtistas();
    public void AltaSeguir(String nomSeguidor, String nomSeguido) throws SeguidorInexistenteException,SeguidoInexistenteException, SeguidoRepetidoException, AutoSeguirseException;
}