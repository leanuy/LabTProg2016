package espotify.Interfaces;

import espotify.Datatypes.DataClienteExt;
import espotify.Excepciones.ClienteInexistenteException;


public interface IConsultaCliente {
    public DataClienteExt ConsultaCliente(String s) throws ClienteInexistenteException ;
    public String[] DevolverClientes();
}