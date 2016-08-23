package espotify.Interfaces;

import espotify.Datatypes.DataDefecto;
import espotify.Datatypes.DataParticular;
import java.util.ArrayList;


public interface IAltaLista {
    public ArrayList<String> ListarClientes();
    public ArrayList<String> ListarGeneros();
    public void AltaListaParticular(DataParticular d) throws Exception;
    public void AltaListaDefecto(DataDefecto d) throws Exception;
}
