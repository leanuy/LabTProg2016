package espotify.Interfaces;

import java.util.ArrayList;


public interface IAltaSeguir {
    public ArrayList<String> ListarClientes();
    public void AltaSeguir(String nomSeguidor, String nomSeguido) throws Exception;
}
