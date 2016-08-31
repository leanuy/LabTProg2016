package espotify;


import espotify.Artista;
import espotify.Cliente;
import espotify.Excepciones.ClienteInexistenteException;
import java.util.HashMap;

public class ManejadorUsuarios {
    private static ManejadorUsuarios instancia;
    private final HashMap<String,Cliente> clientes;
    private final HashMap<String,Artista> artistas;
    
    public static ManejadorUsuarios getInstancia()
    {
        if(instancia==null)
            instancia=new ManejadorUsuarios();
        return instancia;
    }
    private ManejadorUsuarios()
    {
        this.clientes=new HashMap<>();
        this.artistas=new HashMap<>();
    }

    public HashMap<String, Cliente> getClientes() {
        return clientes;
    }

    public HashMap<String, Artista> getArtistas() {
        return artistas;
    }
    
    public Cliente BuscarCliente(String nick) {
        return clientes.get(nick);
    }
    
    public Artista BuscarArtista(String nick) {
        return artistas.get(nick);
    }

    void AgregarCliente(String nick, Cliente c) {
        clientes.put(nick, c);
    }

    void AgregarArtista(String nick, Artista c) {
        artistas.put(nick, c);
    }
    
    static void clear()
    {
        instancia=null;
    }
    
}
