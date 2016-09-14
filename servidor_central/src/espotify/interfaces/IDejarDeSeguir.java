package espotify.interfaces;

import espotify.excepciones.ClienteInexistenteException;
import espotify.excepciones.SeguidoInexistenteException;
import espotify.excepciones.SeguidorInexistenteException;

import java.util.List;



public interface IDejarDeSeguir {
    
    public List<String> listarClientes();

    public String[] getSeguidos(String usr)
            throws ClienteInexistenteException ;

    public void dejarDeSeguir(String nomSeguidor, String nomSeguido)
            throws SeguidoInexistenteException,SeguidorInexistenteException;
}