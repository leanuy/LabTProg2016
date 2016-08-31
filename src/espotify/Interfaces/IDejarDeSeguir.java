package espotify.Interfaces;

import espotify.Excepciones.ClienteInexistenteException;
import espotify.Excepciones.SeguidoInexistenteException;
import espotify.Excepciones.SeguidorInexistenteException;



public interface IDejarDeSeguir {
    
    public String[] DevolverClientes();
    public String[] getSeguidos(String usr) throws ClienteInexistenteException ;
    public void DejarDeSeguir(String nomSeguidor, String nomSeguido) throws SeguidoInexistenteException,SeguidorInexistenteException;
}