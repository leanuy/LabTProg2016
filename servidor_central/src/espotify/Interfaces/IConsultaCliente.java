package espotify.Interfaces;

import espotify.Datatypes.DataClienteExt;
import espotify.Excepciones.ClienteInexistenteException;

import java.util.List;


public interface IConsultaCliente {
    public DataClienteExt consultaCliente(String nick) 
            throws ClienteInexistenteException;

    public List<String> listarClientes();
}