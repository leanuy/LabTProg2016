package espotify.Interfaces;

import espotify.Datatypes.DataClienteExt;
import java.util.ArrayList;


public interface IConsultaCliente {
    public DataClienteExt ConsultaCliente(String s);
    public ArrayList<String> ListarClientes();
}
