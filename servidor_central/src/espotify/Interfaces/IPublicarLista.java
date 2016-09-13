package espotify.Interfaces;

import espotify.Excepciones.ClienteInexistenteException;
import espotify.Excepciones.ListaInexistenteException;
import espotify.Excepciones.YaPublicaException;
import java.util.ArrayList;

public interface IPublicarLista {
    public void PublicarLista(String nomLista, String nick) throws ClienteInexistenteException, ListaInexistenteException, YaPublicaException;
    public ArrayList<String> ListarClientes();
    public ArrayList<String> ListarListasPrivadasDeCliente(String nick) throws ClienteInexistenteException;
}