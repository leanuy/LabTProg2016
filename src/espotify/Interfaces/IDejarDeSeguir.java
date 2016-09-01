package espotify.Interfaces;

import espotify.Excepciones.ClienteInexistenteException;
import espotify.Excepciones.SeguidoInexistenteException;
import espotify.Excepciones.SeguidorInexistenteException;
import java.util.ArrayList;



public interface IDejarDeSeguir {
    
    public ArrayList<String> ListarClientes();
    public String[] getSeguidos(String usr) throws ClienteInexistenteException ;
    public void DejarDeSeguir(String nomSeguidor, String nomSeguido) throws SeguidoInexistenteException,SeguidorInexistenteException;
}