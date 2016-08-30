
package espotify.Interfaces;

import espotify.Tema;
import java.util.ArrayList;


public interface IAgregarTemaLista {
    public ArrayList<String> ListarClientes();
    public ArrayList<String> ListarArtistas();
    public ArrayList<String> ListarListasDeCliente(String nick) throws Exception;
    public ArrayList<String> ListarListasDefecto();
    public ArrayList<String> ListarAlbumesDeArtista(String na) throws Exception;
    public ArrayList<String> ListarTemasAlbum(String art, String alb) throws Exception;
    public ArrayList<String> ListarListasPrivadasDeCliente(String nick) throws Exception;
    public ArrayList<String> ListarListasPubliasDeCliente(String nick) throws Exception;
    public ArrayList<String> ListarTemasLista2(String cl, String l) throws Exception;
    public void AgregarTemaLista(String tema, String lista)throws Exception;
}
