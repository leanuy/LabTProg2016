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
import espotify.Interfaces.IAltaAlbum;
import espotify.Interfaces.IDesFavoritear;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrlUsuarios implements IDesFavoritear, IConsultaCliente, IConsultaArtista, IAltaSeguir, IDejarDeSeguir, IAltaPerfil, IFavoritear{
//Constructor
    public CtrlUsuarios()
    {
    }
//Acceso al Manejador
    private void AgregarCliente(String nick, Cliente c) {
        ManejadorColecciones.getInstancia().AgregarCliente(nick, c);
    }
    private void AgregarArtista(String nick, Artista c) {
        ManejadorColecciones.getInstancia().AgregarArtista(nick, c);
    }
    Artista BuscarArtista(String nombre) throws ArtistaInexistenteException {
        Artista artista = ManejadorColecciones.getInstancia().BuscarArtista(nombre);
        if (artista == null)
            throw new ArtistaInexistenteException();
        return artista;
    }
    Cliente BuscarCliente(String nick) throws ClienteInexistenteException {
        Cliente cliente = GetClientes().get(nick);
        if (cliente == null) {
            throw new ClienteInexistenteException("No existe ese cliente!");
        }
        return cliente;
    }
    private static HashMap<String, Artista> GetArtistas() {
        return ManejadorColecciones.getInstancia().getArtistas();
    }
    private static HashMap<String, Cliente> GetClientes() {
        return ManejadorColecciones.getInstancia().getClientes();
    }

//Otras búsquedas
    private Favoriteable BuscarFavoriteable(DataFavoriteable d) throws ListaInexistenteException, ClienteInexistenteException, ArtistaInexistenteException, AlbumInexistenteException {
        if (d instanceof DataLista)
        {
            if(d instanceof DataParticular)
            {
                DataParticular dp = (DataParticular) d;
                return BuscarListaPublicaDeCliente(dp.getNomCliente(),dp.getNombre());
            }
            else if (d instanceof DataDefecto)
                return new CtrlListas().BuscarLista(((DataDefecto) d).getNombre());
        } else if (d instanceof DataAlbum)
        {
            DataAlbum da = (DataAlbum) d;
            return BuscarAlbumDeArtista(da.getNickArtista(),da.getNombre());
        }
        else if (d instanceof DataTema)
            return DevolverTema((DataTema)d);
        return null;
    }
    private Publica BuscarListaPublicaDeCliente(String nickCliente, String nomLista) throws ClienteInexistenteException, ListaInexistenteException {
        Cliente c = BuscarCliente(nickCliente);
        return c.BuscarListaPublica(nomLista);
    }
    private Album BuscarAlbumDeArtista(String nickArtista,String nomAlbum) throws ArtistaInexistenteException, AlbumInexistenteException {
        Artista a = BuscarArtista(nickArtista);
        return a.BuscarAlbum(nomAlbum);
    }
    Tema DevolverTema(DataTema dt) throws ArtistaInexistenteException{
        Artista a = BuscarArtista(dt.getNomArtista());
        return a.DevolverTema(dt);
    }

//Listas
    @Override
    public ArrayList<String> ListarClientes(){
        ArrayList a = new ArrayList();
        GetClientes().keySet().stream().forEach((key) -> {
            a.add(key);
        });
        return a;
    }
    @Override
    public ArrayList<String> ListarArtistas(){
        ArrayList a = new ArrayList();
        GetArtistas().keySet().stream().forEach((key) -> {
            a.add(key);
        });
        return a;
    }
    ArrayList<String> ListarListasDeCliente(String nick) throws ClienteInexistenteException{
        Cliente c = BuscarCliente(nick);
        return c.ListarListas();
    }
    ArrayList<String> ListarListasPrivadasDeCliente(String nick) throws ClienteInexistenteException{
        Cliente c = BuscarCliente(nick);
        return c.ListarListasPrivadas();
    }
    @Override
    public ArrayList<String> ListarListasPublicasDeCliente(String nick) throws ClienteInexistenteException{
        Cliente c = BuscarCliente(nick);
        return c.ListarListasPublicas();
    }
    @Override
    public ArrayList<String> ListarListasDefecto()
    {
        return new CtrlListas().ListarListasDefecto();
    }
    ArrayList<DataTema> ListarTemasDeLista(String nick, String nombre) throws ClienteInexistenteException, ListaInexistenteException{
        Cliente c = BuscarCliente(nick);
        return c.ListarTemasDeLista(nombre);
    }

    @Override
    public ArrayList<String> ListarSeguibles(String nomSeguidor) throws SeguidorInexistenteException
    {
        Cliente c;
        try {
            c = BuscarCliente(nomSeguidor);
        } catch (ClienteInexistenteException ex) {
            throw new SeguidorInexistenteException();
        }
        ArrayList<String> a = new ArrayList<>();
        for(Entry<String, Cliente> entry :  GetClientes().entrySet()) {
            String key = entry.getKey();
            if(!c.SigueA(key) && !key.equals(c.getNick()))
                a.add(key);
        }
        for(Entry<String, Artista> entry : GetArtistas().entrySet()) {
            String key = entry.getKey();
            if(!c.SigueA(key))
                a.add(key);
        }
        return a;
    }
    @Override
    public String[] getSeguidos(String usr) throws ClienteInexistenteException {
        DataClienteExt dc = this.ConsultaCliente(usr);
        String[] seg = dc.getSeguidos();
        return seg;
    }
    ArrayList<String> ListarAlbumesDeArtista(String nomArtista) throws ArtistaInexistenteException{
        Artista artista = BuscarArtista(nomArtista);
        return artista.ListarAlbumes();
    }
    ArrayList<DataTema> ListarTemasAlbum(String art, String alb) throws ArtistaInexistenteException, AlbumInexistenteException {
        Artista artista = BuscarArtista(art);
        Album al = artista.BuscarAlbum(alb);
        ArrayList<DataTema> datatemas = al.getDataTemas();
        return datatemas;
    }
    
    //Consultas
    @Override
    public DataClienteExt ConsultaCliente(String s) throws ClienteInexistenteException{
        Cliente c = BuscarCliente(s);
        DataClienteExt dc = c.getDataClienteExt();
        return dc;
    }
    @Override
    public DataArtistaExt ConsultaArtista(String s){
        Artista a = GetArtistas().get(s);
        DataArtistaExt da = a.getDataArtistaExt();
        return da;
    }
    private boolean ExisteUsuarioCorreo(String correo) {
        boolean salida = false;
        Iterator<Entry<String,Cliente>> iterator = GetClientes().entrySet().iterator();
        while (iterator.hasNext() && !salida) {
                Map.Entry<String,Cliente> entry = (Map.Entry<String,Cliente>) iterator.next();
                salida = entry.getValue().getCorreo().equals(correo);
        }
        Iterator<Entry<String,Artista>> iterator2 = GetArtistas().entrySet().iterator();
        while (iterator2.hasNext() && !salida) {
                Map.Entry<String,Artista> entry = (Map.Entry<String,Artista>) iterator2.next();
                salida = entry.getValue().getCorreo().equals(correo);
        }
        return salida;       
    }
    private boolean ExisteUsuarioNick(String nick) {
        return GetClientes().containsKey(nick) || GetArtistas().containsKey(nick);
    }
    DataLista DarInfoLista(String nomLista, String nick) throws ClienteInexistenteException, ListaInexistenteException{
        Cliente c = BuscarCliente(nick);
        return c.DarInfoLista(nomLista);
    }
    DataAlbumExt ConsultaAlbum(String nomAlbum, String nomArtista) throws ArtistaInexistenteException, AlbumInexistenteException{
        Artista artista = BuscarArtista(nomArtista);
        DataAlbumExt data_album_ext = artista.getDataAlbumExt(nomAlbum);
        return data_album_ext;
    }        

    //Operaciones
    @Override
    public void AltaSeguir(String nomSeguidor, String nomSeguido) throws SeguidorInexistenteException,SeguidoInexistenteException, SeguidoRepetidoException, AutoSeguirseException{
        Cliente c = null;
        try {
            c = BuscarCliente(nomSeguidor);
        } catch (ClienteInexistenteException ex) {
            throw new SeguidorInexistenteException();
        }
        Usuario u = null;
        try
        {
            u = BuscarCliente(nomSeguido);
        } catch (ClienteInexistenteException ex) {        }
        if (u==null){
            try
            {
                u = BuscarArtista(nomSeguido);
            }
            catch (ArtistaInexistenteException ex)
            {
                throw new SeguidoInexistenteException();
            }
        }
        c.Seguir(u);
    }
    @Override
    public void DejarDeSeguir(String nomSeguidor, String nomSeguido) throws SeguidorInexistenteException,SeguidoInexistenteException{
        Cliente c = null;
        try {
            c = BuscarCliente(nomSeguidor);
        } catch (ClienteInexistenteException ex) {
            throw new SeguidorInexistenteException();
        }
        Usuario u = null;
        try
        {
            u = BuscarCliente(nomSeguido);
        } catch (ClienteInexistenteException ex) {        }
        if (u==null){
            try
            {
                u = BuscarArtista(nomSeguido);
            }
            catch (ArtistaInexistenteException ex)
            {
                throw new SeguidoInexistenteException();
            }
        }
        c.DejarDeSeguir(u);
    }
    @Override
    public void AltaCliente(DataCliente d) throws NickRepetidoException, CorreoRepetidoException, FormatoIncorrectoException {
        if(Usuario.ValidarDatosUsuario(d))
        {
            if(!ExisteUsuarioCorreo(d.getCorreo()))
            {
                if(!ExisteUsuarioNick(d.getNick()))
                {
                    Cliente c = new Cliente(d);
                    AgregarCliente(d.getNick(), c);
                } else
                    throw new NickRepetidoException();
            } else
                throw new CorreoRepetidoException();
        } else
            throw new FormatoIncorrectoException();
    }
    @Override
    public void AltaArtista(DataArtista d) throws NickRepetidoException, CorreoRepetidoException, FormatoIncorrectoException {
        if(Artista.ValidarDatosArtista(d))
        {
            if(!ExisteUsuarioCorreo(d.getCorreo()))
            {
                if(!ExisteUsuarioNick(d.getNick()))
                {
                    Artista c = new Artista(d);
                    AgregarArtista(d.getNick(), c);
                } else
                    throw new NickRepetidoException();
            } else
                throw new CorreoRepetidoException();
        } else
            throw new FormatoIncorrectoException();
    }
    void PublicarLista(String nomLista, String nick) throws ClienteInexistenteException, ListaInexistenteException, YaPublicaException {
        Cliente c = BuscarCliente(nick);
        c.PublicarLista(nomLista);
    }
    void AltaLista(DataParticular d) throws ClienteInexistenteException, ListaRepetidaException {
        Cliente c = GetClientes().get(d.getNomCliente());
        if(c!=null)
            c.AltaLista(d);
        else
            throw new ClienteInexistenteException();
    }
    void QuitarTemaDeLista(String nick, String nomLista, String nomTema,String nomAlbum) throws ListaInexistenteException, ClienteInexistenteException {
        Cliente c = BuscarCliente(nick);
        c.QuitarTemaDeLista(nomLista,nomTema,nomAlbum);
    }
    public void Favoritear(String nick, DataFavoriteable d) throws ClienteInexistenteException, FavoritoRepetidoException, ListaInexistenteException, ArtistaInexistenteException, AlbumInexistenteException {
        Favoriteable f = BuscarFavoriteable(d);
        Cliente c = BuscarCliente(nick);
        c.Favoritear(f);
    }
    public void DesFavoritear(String nick, DataFavoriteable d) throws ClienteInexistenteException, FavoritoRepetidoException, ListaInexistenteException, ArtistaInexistenteException, AlbumInexistenteException {
        Favoriteable f = BuscarFavoriteable(d);
        Cliente c = BuscarCliente(nick);
        c.DesFavoritear(f);
    }
    void AgregarTemaLista(Tema t,String usr, String lista) throws Exception{
        Cliente cliente = null;
        cliente = GetClientes().get(usr);
        if (cliente == null){
            throw new Exception("No se encontro el cliente");
        }
        cliente.AgregarTemaLista(t, lista);
    }
}
