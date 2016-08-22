package espotify;

import espotify.Datatypes.DataArtista;
import espotify.Datatypes.DataArtistaExt;
import espotify.Datatypes.DataCliente;
import espotify.Datatypes.DataClienteExt;
import espotify.Datatypes.DataTema;
import espotify.Interfaces.IAltaPerfil;
import espotify.Interfaces.IAltaSeguir;
import espotify.Interfaces.IConsultaArtista;
import espotify.Interfaces.IConsultaCliente;
import espotify.Interfaces.IDejarDeSeguir;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class CtrlUsuarios implements IConsultaCliente, IConsultaArtista, IAltaSeguir, IDejarDeSeguir, IAltaPerfil{
    private static CtrlUsuarios instancia;
    private final HashMap<String,Cliente> clientes;
    private final HashMap<String,Artista> artistas;
    
    public static CtrlUsuarios getInstancia()
    {
        if(instancia==null)
            instancia=new CtrlUsuarios();
        return instancia;
    }
    
    private CtrlUsuarios()
    {
        this.clientes=new HashMap<>();
        this.artistas=new HashMap<>();
    }
    
    public ArrayList<String> ListarClientes(){
        ArrayList a = new ArrayList();
        clientes.keySet().stream().forEach((key) -> {
            a.add(key);
        });
        return a;
    }
    
    public DataClienteExt ConsultaCliente(String s){
        Cliente c = clientes.get(s);
        DataClienteExt dc = c.getDataClienteExt();
        return dc;
    }
    
    public ArrayList<String> ListarArtistas(){
        ArrayList a = new ArrayList();
        artistas.keySet().stream().forEach((key) -> {
            a.add(key);
        });
        return a;
    }
    
    public DataArtistaExt ConsultaArtista(String s){
        Artista a = artistas.get(s);
        DataArtistaExt da = a.getDataArtistaExt();
        return da;
    }
    
    public void AltaSeguir(String nomSeguidor, String nomSeguido) throws Exception{
        Cliente c = clientes.get(nomSeguidor);
        if (c==null){
            throw new Exception("No existe el usuario que quiere seguir");
        }
        Usuario u = clientes.get(nomSeguido);
        if (u==null){
            u = artistas.get(nomSeguido);
        }
        if (u==null){
            throw new Exception("no existe ese usuario a seguir");
        }
        c.Seguir(u);
    }
    
    public void DejarDeSeguir(String nomSeguidor, String nomSeguido) throws Exception{
        Cliente c = clientes.get(nomSeguidor);
        if (c==null){
            throw new Exception("No existe el usuario que quiere seguir");
        }
        Usuario u = clientes.get(nomSeguido);
        if (u==null){
            u = artistas.get(nomSeguido);
        }
        if (u==null){
            throw new Exception("no existe el usuario que se quiere dejar de seguir");
        }
        c.DejarDeSeguir(u);
    }
    
    public void AltaCliente(DataCliente d) throws Exception
    {
        if(Usuario.ValidarDatosUsuario(d))
        {
            if(!ExisteUsuarioCorreo(d.getCorreo()))
            {
                if(!ExisteUsuarioNick(d.getNick()))
                {
                    Cliente c = new Cliente(d);
                    clientes.put(d.getNick(), c);
                } else
                    throw new Exception("Ya existe un usuario con ese nick");
            } else
                throw new Exception("Ya existe un usuario con ese correo");
        } else
            throw new Exception("Los datos ingresados no son correctos");
    }
    
    public void AltaArtista(DataArtista d) throws Exception
    {
        if(Artista.ValidarDatosArtista(d))
        {
            if(!ExisteUsuarioCorreo(d.getCorreo()))
            {
                if(!ExisteUsuarioNick(d.getNick()))
                {
                    Artista c = new Artista(d);
                    artistas.put(d.getNick(), c);
                } else
                    throw new Exception("Ya existe un usuario con ese nick");
            } else
                throw new Exception("Ya existe un usuario con ese correo");
        } else
            throw new Exception("Los datos ingresados no son correctos");
    }

    private boolean ExisteUsuarioCorreo(String correo) {
        boolean salida = false;
        Iterator<Entry<String,Cliente>> iterator = clientes.entrySet().iterator();
        while (iterator.hasNext() && !salida) {
                Map.Entry<String,Cliente> entry = (Map.Entry<String,Cliente>) iterator.next();
                salida = entry.getValue().getCorreo().equals(correo);
        }
        Iterator<Entry<String,Artista>> iterator2 = artistas.entrySet().iterator();
        while (iterator2.hasNext() && !salida) {
                Map.Entry<String,Artista> entry = (Map.Entry<String,Artista>) iterator2.next();
                salida = entry.getValue().getCorreo().equals(correo);
        }
        return salida;       
    }
    private boolean ExisteUsuarioNick(String nick) {
        return clientes.containsKey(nick) || artistas.containsKey(nick);
    }
    
    public Cliente BuscarCliente(String nick) {
            return clientes.get(nick);
    }
    public Artista BuscarArtista(String nick) {
            return artistas.get(nick);
    }

    public void PublicarLista(String nomLista, String nick) throws Exception {
        Cliente c = clientes.get(nick);
        if(c!=null)
        {
            c.PublicarLista(nomLista);
        }
        else
            throw new Exception("El cliente no existe");
    }

    public ArrayList<String> ListarListasDeCliente(String nick) throws Exception{
        Cliente c = BuscarCliente(nick);
        if(c!=null)
        {
            return c.ListarListas();
        }
        else
            throw new Exception("El cliente no existe");
    }

    public ArrayList<DataTema> ListarTemasDeLista(String nick, String nombre) throws Exception{
        Cliente c = BuscarCliente(nick);
        if(c!=null)
        {
            return c.ListarTemasDeLista(nombre);
        }
        else
            throw new Exception("El cliente no existe");
    }
    
    @Override
    public String[] DevolverClientes(){
        int cant = clientes.size();
        String[] a;
        a = new String[cant];
        int i = 0;
        for(Entry<String, Cliente> entry : clientes.entrySet()) {
            String key = entry.getKey();
            a[i] = key;
            i++;
        }
        return a;
    }
    
    @Override
    public String[] DevolverArtistas(){
        int cant = artistas.size();
        String[] a;
        a = new String[cant];
        int i = 0;
        for(Entry<String, Artista> entry : artistas.entrySet()) {
            String key = entry.getKey();
            a[i] = key;
            i++;
        }
        return a;
    }    
    
    @Override
    public String[] getSeguidos(String usr){
        DataClienteExt dc = this.ConsultaCliente(usr);
        String[] seg = dc.getSeguidos();
        return seg;
    }
}
