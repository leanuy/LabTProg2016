package espotify.interfaces;

import espotify.datatypes.DataClienteExt;
import espotify.excepciones.ClienteInexistenteException;

import java.util.List;


public interface IConsultaCliente {
    public DataClienteExt consultaCliente(String nick) 
            throws ClienteInexistenteException;

    public List<String> listarClientes();
}