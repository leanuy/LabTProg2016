package espotify.Interfaces;

import espotify.Excepciones.ClienteInexistenteException;
import espotify.Excepciones.ListaInexistenteException;
import espotify.Excepciones.YaPublicaException;

import java.util.List;

public interface IPublicarLista {
    public void publicarLista(String nomLista, String nick)
            throws ClienteInexistenteException,
            ListaInexistenteException,
            YaPublicaException;

    public List<String> listarClientes();

    public List<String> listarListasPrivadasDeCliente(String nick)
            throws ClienteInexistenteException;
}