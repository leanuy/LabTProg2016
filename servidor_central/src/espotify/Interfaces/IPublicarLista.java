package espotify.Interfaces;

import espotify.Excepciones.ClienteInexistenteException;
import espotify.Excepciones.ListaInexistenteException;
import espotify.Excepciones.YaPublicaException;

import java.util.List;

public interface IPublicarLista {
    public void PublicarLista(String nomLista, String nick)
            throws ClienteInexistenteException,
            ListaInexistenteException,
            YaPublicaException;

    public List<String> ListarClientes();

    public List<String> ListarListasPrivadasDeCliente(String nick)
            throws ClienteInexistenteException;
}