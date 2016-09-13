package espotify.Interfaces;

import espotify.Datatypes.DataClienteExt;
import espotify.Excepciones.ClienteInexistenteException;
import java.util.ArrayList;


public interface IConsultaCliente {
    public DataClienteExt ConsultaCliente(String s) throws ClienteInexistenteException ;
    public ArrayList<String> ListarClientes();
}