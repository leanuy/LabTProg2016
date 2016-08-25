package espotify.Interfaces;

import espotify.Datatypes.DataDefecto;
import espotify.Datatypes.DataGenero;
import espotify.Datatypes.DataLista;
import espotify.Datatypes.DataParticular;
import java.util.ArrayList;

public interface IConsultaLista {
    public ArrayList<String> ListarClientes();
    public DataGenero ListarGeneros();
    public ArrayList<String> ListarListasDeGenero(String nomGenero) throws Exception;
    public ArrayList<String> ListarListasDeCliente(String nick) throws Exception;
    public DataLista DarInfoParticular(String nomLista, String nick) throws Exception;
    public DataLista DarInfoDefecto(String nomLista) throws Exception;
}
