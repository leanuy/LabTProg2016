package espotify.Interfaces;

import espotify.Datatypes.DataClienteExt;
import espotify.Excepciones.ClienteInexistenteException;

import java.util.List;


public interface IConsultaCliente {
    public DataClienteExt ConsultaCliente(String s) 
            throws ClienteInexistenteException;

    public List<String> ListarClientes();
}