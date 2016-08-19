package espotify.Interfaces;

import java.util.ArrayList;

public interface IDejarDeSeguir {
    
    public ArrayList<String> ListarClientes();
    public void DejarDeSeguir(String nomSeguidor, String nomSeguido) throws Exception;
}
