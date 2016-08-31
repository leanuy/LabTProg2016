package espotify;

import espotify.Datatypes.DataAlbum;
import espotify.Datatypes.DataAlbumExt;
import espotify.Datatypes.DataArtista;
import espotify.Datatypes.DataArtistaExt;
import espotify.Datatypes.DataCliente;
import espotify.Datatypes.DataClienteExt;
import espotify.Datatypes.DataDefecto;
import espotify.Datatypes.DataFavoriteable;
import espotify.Datatypes.DataLista;
import espotify.Datatypes.DataTema;
import espotify.Interfaces.IAltaPerfil;
import espotify.Interfaces.IAltaSeguir;
import espotify.Interfaces.IConsultaArtista;
import espotify.Interfaces.IConsultaCliente;
import espotify.Interfaces.IDejarDeSeguir;
import espotify.Datatypes.DataParticular;
import espotify.Excepciones.AlbumInexistenteException;
import espotify.Excepciones.ArtistaInexistenteException;
import espotify.Excepciones.AutoSeguirseException;
import espotify.Excepciones.ClienteInexistenteException;
import espotify.Excepciones.CorreoRepetidoException;
import espotify.Excepciones.FavoritoRepetidoException;
import espotify.Excepciones.FormatoIncorrectoException;
import espotify.Excepciones.ListaInexistenteException;
import espotify.Excepciones.ListaRepetidaException;
import espotify.Excepciones.NickRepetidoException;
import espotify.Excepciones.SeguidoInexistenteException;
import espotify.Excepciones.SeguidoRepetidoException;
import espotify.Excepciones.SeguidorInexistenteException;
import espotify.Excepciones.YaPublicaException;
import espotify.Interfaces.IFavoritear;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class CtrlUsuarios implements IConsultaCliente, IConsultaArtista, IAltaSeguir, IDejarDeSeguir, IAltaPerfil, IFavoritear{
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
    
    public void AltaSeguir(String nomSeguidor, String nomSeguido) throws SeguidorInexistenteException,SeguidoInexistenteException, SeguidoRepetidoException, AutoSeguirseException{
        Cliente c = clientes.get(nomSeguidor);
        if (c==null){
            throw new SeguidorInexistenteException();
        }
        Usuario u = clientes.get(nomSeguido);
        if (u==null){
            u = artistas.get(nomSeguido);
        }
        if (u==null){
            throw new SeguidoInexistenteException();
        }
        c.Seguir(u);
    }
    
    public void DejarDeSeguir(String nomSeguidor, String nomSeguido) throws SeguidorInexistenteException,SeguidoInexistenteException{
        Cliente c = clientes.get(nomSeguidor);
        if (c==null){
            throw new SeguidorInexistenteException();
        }
        Usuario u = clientes.get(nomSeguido);
        if (u==null){
            u = artistas.get(nomSeguido);
        }
        if (u==null){
            throw new SeguidoInexistenteException();
        }
        c.DejarDeSeguir(u);
    }
    
    public void AltaCliente(DataCliente d) throws NickRepetidoException, CorreoRepetidoException, FormatoIncorrectoException
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
                    throw new NickRepetidoException();
            } else
                throw new CorreoRepetidoException();
        } else
            throw new FormatoIncorrectoException();
    }
    
    public void AltaArtista(DataArtista d) throws NickRepetidoException, CorreoRepetidoException, FormatoIncorrectoException
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
                    throw new NickRepetidoException();
            } else
                throw new CorreoRepetidoException();
        } else
            throw new FormatoIncorrectoException();
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
    
    public Cliente BuscarCliente(String nick) throws ClienteInexistenteException {
        Cliente cliente = clientes.get(nick);
        if (cliente == null) {
            throw new ClienteInexistenteException("No existe ese cliente!");
        }
        return cliente;
    }


    public void PublicarLista(String nomLista, String nick) throws ClienteInexistenteException, ListaInexistenteException, YaPublicaException {
        Cliente c = BuscarCliente(nick);
        c.PublicarLista(nomLista);
    }

    public ArrayList<String> ListarListasDeCliente(String nick) throws ClienteInexistenteException{
        Cliente c = BuscarCliente(nick);
        return c.ListarListas();
    }
    
    ArrayList<String> ListarListasPrivadasDeCliente(String nick) throws ClienteInexistenteException{
        Cliente c = BuscarCliente(nick);
        return c.ListarListasPrivadas();
    }

    public ArrayList<DataTema> ListarTemasDeLista(String nick, String nombre) throws ClienteInexistenteException, ListaInexistenteException{
        Cliente c = BuscarCliente(nick);
        return c.ListarTemasDeLista(nombre);
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

    void AltaLista(DataParticular d) throws ClienteInexistenteException, ListaRepetidaException {
        Cliente c = clientes.get(d.getNomCliente());
        if(c!=null)
            c.AltaLista(d);
        else
            throw new ClienteInexistenteException();
    }

    void QuitarTemaDeLista(String nick, String nomLista, String nomTema,String nomAlbum) throws ListaInexistenteException, ClienteInexistenteException {
        Cliente c = BuscarCliente(nick);
        c.QuitarTemaDeLista(nomLista,nomTema,nomAlbum);
    }

    DataLista DarInfoLista(String nomLista, String nick) throws ClienteInexistenteException, ListaInexistenteException{
        Cliente c = BuscarCliente(nick);
        return c.DarInfoLista(nomLista);
    }
    
    public DataAlbumExt ConsultaAlbum(String nomAlbum, String nomArtista) throws ArtistaInexistenteException, AlbumInexistenteException{
        Artista artista = BuscarArtista(nomArtista);
        DataAlbumExt data_album_ext = artista.getDataAlbumExt(nomAlbum);
        return data_album_ext;
    }        

    
    public Artista BuscarArtista(String nombre) throws ArtistaInexistenteException {
        Artista artista = artistas.get(nombre);
        if (artista == null) {
            throw new ArtistaInexistenteException();
        }
        return artista;
    }
    
    public ArrayList<String> ListarAlbumesDeArtista(String nomArtista) throws ArtistaInexistenteException{
        Artista artista = BuscarArtista(nomArtista);
        return artista.ListarAlbumes();
    }
    
    public void Favoritear(String nick, DataFavoriteable d) throws ClienteInexistenteException, FavoritoRepetidoException, ListaInexistenteException, ArtistaInexistenteException, AlbumInexistenteException
    {
        Favoriteable f = BuscarFavoriteable(d);
        Cliente c = BuscarCliente(nick);
        c.Favoritear(f);
    }
    
    public Favoriteable BuscarFavoriteable(DataFavoriteable d) throws ListaInexistenteException, ClienteInexistenteException, ArtistaInexistenteException, AlbumInexistenteException
    {
        if (d instanceof DataLista)
        {
            if(d instanceof DataParticular)
            {
                DataParticular dp = (DataParticular) d;
                return BuscarListaPublicaDeCliente(dp.getNomCliente(),dp.getNombre());
            }
            else if (d instanceof DataDefecto)
                return CtrlListas.getInstancia().BuscarLista(((DataDefecto) d).getNombre());
        } else if (d instanceof DataAlbum)
        {
            DataAlbum da = (DataAlbum) d;
            return BuscarAlbumDeArtista(da.getNickArtista(),da.getNombre());
        }
        else if (d instanceof DataTema)
            return DevolverTema((DataTema)d);
        return null;
    }
    
    Publica BuscarListaPublicaDeCliente(String nickCliente, String nomLista) throws ClienteInexistenteException, ListaInexistenteException
    {
        Cliente c = BuscarCliente(nickCliente);
        return c.BuscarListaPublica(nomLista);
    }
    Album BuscarAlbumDeArtista(String nickArtista,String nomAlbum) throws ArtistaInexistenteException, AlbumInexistenteException
    {
        Artista a = BuscarArtista(nickArtista);
        return a.BuscarAlbum(nomAlbum);
    }
    Tema DevolverTema(DataTema d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void DesFavoritear(String nick, DataFavoriteable d) throws ClienteInexistenteException, FavoritoRepetidoException, ListaInexistenteException, ArtistaInexistenteException, AlbumInexistenteException
    {
        Favoriteable f = BuscarFavoriteable(d);
        Cliente c = BuscarCliente(nick);
        c.DesFavoritear(f);
    }
}
