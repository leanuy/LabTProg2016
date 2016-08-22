package espotify.Interfaces;

import espotify.Datatypes.DataClienteExt;


public interface IConsultaCliente {
    public DataClienteExt ConsultaCliente(String s);
    public String[] DevolverClientes();
}