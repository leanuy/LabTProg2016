package espotify.Interfaces;

import espotify.Excepciones.ClienteInexistenteException;
import espotify.Excepciones.SeguidoInexistenteException;
import espotify.Excepciones.SeguidorInexistenteException;

import java.util.List;



public interface IDejarDeSeguir {
    
    public List<String> ListarClientes();

    public String[] getSeguidos(String usr)
            throws ClienteInexistenteException ;

    public void dejarDeSeguir(String nomSeguidor, String nomSeguido)
            throws SeguidoInexistenteException,SeguidorInexistenteException;
}