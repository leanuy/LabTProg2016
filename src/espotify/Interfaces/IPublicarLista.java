package espotify.Interfaces;

import java.util.ArrayList;

public interface IPublicarLista {
    public void PublicarLista(String nomLista, String nick) throws Exception;
    public ArrayList<String> ListarClientes();
    public ArrayList<String> ListarListasPrivadasDeCliente(String nick) throws Exception;
}