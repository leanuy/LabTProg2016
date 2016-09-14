package espotify.interfaces;

import espotify.excepciones.ClienteInexistenteException;
import espotify.excepciones.ListaInexistenteException;
import espotify.excepciones.YaPublicaException;

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