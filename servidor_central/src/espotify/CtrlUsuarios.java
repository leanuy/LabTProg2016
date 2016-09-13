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
import espotify.Datatypes.DataParticular;
import espotify.Datatypes.DataTema;
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
import espotify.Interfaces.IAltaPerfil;
import espotify.Interfaces.IAltaSeguir;
import espotify.Interfaces.IConsultaArtista;
import espotify.Interfaces.IConsultaCliente;
import espotify.Interfaces.IDejarDeSeguir;
import espotify.Interfaces.IDesFavoritear;
import espotify.Interfaces.IFavoritear;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class CtrlUsuarios implements IDesFavoritear, IConsultaCliente, IConsultaArtista,
        IAltaSeguir, IDejarDeSeguir, IAltaPerfil, IFavoritear {
//Constructor
    public CtrlUsuarios() {
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
        if (artista == null) {
            throw new ArtistaInexistenteException();
        }
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
        if (d instanceof DataLista) {
            if(d instanceof DataParticular) {
                DataParticular dp = (DataParticular) d;
                return BuscarListaPublicaDeCliente(dp.getNomCliente(),dp.getNombre());
            }
            else if (d instanceof DataDefecto) {
                return new CtrlListas().BuscarLista(((DataDefecto) d).getNombre());
            }
        } else if (d instanceof DataAlbum) {
            DataAlbum da = (DataAlbum) d;
            return BuscarAlbumDeArtista(da.getNickArtista(),da.getNombre());
        }
        else if (d instanceof DataTema) {
            return DevolverTema((DataTema)d);
        }
        return null;
    }
    
    private Publica BuscarListaPublicaDeCliente(String nickCliente, String nomLista) throws
            ClienteInexistenteException, ListaInexistenteException {
        return BuscarCliente(nickCliente).BuscarListaPublica(nomLista);
    }
    
    private Album BuscarAlbumDeArtista(String nickArtista,String nomAlbum) throws
            ArtistaInexistenteException, AlbumInexistenteException {
        return BuscarArtista(nickArtista).BuscarAlbum(nomAlbum);
    }
    Tema DevolverTema(DataTema dt) throws ArtistaInexistenteException {
        return BuscarArtista(dt.getNomArtista()).DevolverTema(dt);
    }

//Listas
    @Override
    public ArrayList<String> ListarClientes() {
        ArrayList salida = new ArrayList();
        GetClientes().keySet().stream().forEach((key) -> {
            salida.add(key);
        });
        return salida;
    }
    
    @Override
    public ArrayList<String> ListarArtistas() {
        ArrayList salida = new ArrayList();
        GetArtistas().keySet().stream().forEach((key) -> {
            salida.add(key);
        });
        return salida;
    }
    
    ArrayList<String> ListarListasDeCliente(String nick) throws ClienteInexistenteException {
        return BuscarCliente(nick).ListarListas();
    }
    
    ArrayList<String> ListarListasPrivadasDeCliente(String nick) throws ClienteInexistenteException {
        return BuscarCliente(nick).ListarListasPrivadas();
    }
    
    @Override
    public ArrayList<String> ListarListasPublicasDeCliente(String nick) throws ClienteInexistenteException {
        return BuscarCliente(nick).ListarListasPublicas();
    }
    
    @Override
    public ArrayList<String> ListarListasDefecto() {
        return new CtrlListas().ListarListasDefecto();
    }
    
    ArrayList<DataTema> ListarTemasDeLista(String nick, String nombre) throws ClienteInexistenteException,
            ListaInexistenteException {
        return BuscarCliente(nick).ListarTemasDeLista(nombre);
    }

    @Override
    public ArrayList<String> ListarSeguibles(String nomSeguidor) throws SeguidorInexistenteException {
        Cliente cli;
        try {
            cli = BuscarCliente(nomSeguidor);
        } catch (ClienteInexistenteException ex) {
            throw new SeguidorInexistenteException();
        }
        ArrayList<String> salida = new ArrayList<>();
        for (Entry<String, Cliente> entry :  GetClientes().entrySet()) {
            String key = entry.getKey();
            if (!cli.SigueA(key) && !key.equals(cli.getNick())) {
                salida.add(key);
            }
        }
        for (Entry<String, Artista> entry : GetArtistas().entrySet()) {
            String key = entry.getKey();
            if (!cli.SigueA(key)) {
                salida.add(key);
            }
        }
        return salida;
    }
    
    @Override
    public String[] getSeguidos(String usr) throws ClienteInexistenteException {
        DataClienteExt dc = this.ConsultaCliente(usr);
        String[] seg = dc.getSeguidos();
        return seg;
    }
    
    @Override
    public ArrayList<String> ListarAlbumesDeArtista(String nomArtista) throws ArtistaInexistenteException {
        return BuscarArtista(nomArtista).ListarAlbumes();
    }
    
    ArrayList<DataTema> ListarTemasAlbum(String art, String alb) throws ArtistaInexistenteException,
            AlbumInexistenteException {
        Album al = BuscarArtista(art).BuscarAlbum(alb);
        return al.getDataTemas();
    }
    
    //Consultas
    @Override
    public DataClienteExt ConsultaCliente(String s) throws ClienteInexistenteException {
        return BuscarCliente(s).getDataClienteExt();
    }
    
    @Override
    public DataArtistaExt ConsultaArtista(String s) throws ArtistaInexistenteException {
        return BuscarArtista(s).getDataArtistaExt();
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
    
    DataLista DarInfoLista(String nomLista, String nick) throws ClienteInexistenteException,
            ListaInexistenteException {
        return BuscarCliente(nick).DarInfoLista(nomLista);
    }
    
    DataAlbumExt ConsultaAlbum(String nomAlbum, String nomArtista) throws ArtistaInexistenteException,
            AlbumInexistenteException {
        return BuscarArtista(nomArtista).getDataAlbumExt(nomAlbum);
    }        

    //Operaciones
    @Override
    public void AltaSeguir(String nomSeguidor, String nomSeguido) throws SeguidorInexistenteException, 
            SeguidoInexistenteException, SeguidoRepetidoException, AutoSeguirseException {
        Cliente cli = null;
        try {
            cli = BuscarCliente(nomSeguidor);
        } catch (ClienteInexistenteException ex) {
            throw new SeguidorInexistenteException();
        }
        Usuario user = null;
        try {
            user = BuscarCliente(nomSeguido);
        } catch (ClienteInexistenteException ex) {
            try {
                user = BuscarArtista(nomSeguido);
            } catch (ArtistaInexistenteException e) {
                throw new SeguidoInexistenteException();
            }
        }
        cli.Seguir(user);
        user.AgregarSeguidor(cli);
    }
    
    @Override
    public void DejarDeSeguir(String nomSeguidor, String nomSeguido) throws SeguidorInexistenteException,
            SeguidoInexistenteException {
        Cliente cli = null;
        try {
            cli = BuscarCliente(nomSeguidor);
        } catch (ClienteInexistenteException ex) {
            throw new SeguidorInexistenteException();
        }
        Usuario user = null;
        try {
            user = BuscarCliente(nomSeguido);
        } catch (ClienteInexistenteException ex) {
            try {
                user = BuscarArtista(nomSeguido);
            } catch (ArtistaInexistenteException e) {
                throw new SeguidoInexistenteException();
            }
        }
        cli.DejarDeSeguir(user);
        user.NoMeSiguenMas(cli);
    }
    
    @Override
    public void AltaCliente(DataCliente d) throws NickRepetidoException, CorreoRepetidoException,
            FormatoIncorrectoException {
        if (Usuario.ValidarDatosUsuario(d)) {
            if (!ExisteUsuarioCorreo(d.getCorreo())) {
                if (!ExisteUsuarioNick(d.getNick())) {
                    Cliente nuevoCli = new Cliente(d);
                    AgregarCliente(d.getNick(), nuevoCli);
                } else {
                    throw new NickRepetidoException();
                }
            } else {
                throw new CorreoRepetidoException();
            }
        } else {
            throw new FormatoIncorrectoException();
        }
    }
    
    @Override
    public void AltaArtista(DataArtista d) throws NickRepetidoException, CorreoRepetidoException,
            FormatoIncorrectoException {
        if (Artista.ValidarDatosArtista(d)) {
            if (!ExisteUsuarioCorreo(d.getCorreo())) {
                if (!ExisteUsuarioNick(d.getNick())) {
                    Artista nuevoArtista = new Artista(d);
                    AgregarArtista(d.getNick(), nuevoArtista);
                } else {
                    throw new NickRepetidoException();
                }
            } else {
                throw new CorreoRepetidoException();
            }
        } else {
            throw new FormatoIncorrectoException();
        }
    }
    
    void PublicarLista(String nomLista, String nick) throws ClienteInexistenteException,
            ListaInexistenteException, YaPublicaException {
        BuscarCliente(nick).PublicarLista(nomLista);
    }
    
    void AltaLista(DataParticular dataLista) throws ClienteInexistenteException, ListaRepetidaException {
        BuscarCliente(dataLista.getNomCliente()).AltaLista(dataLista);
    }
    
    void QuitarTemaDeLista(String nick, String nomLista, String nomTema, String nomAlbum) throws ListaInexistenteException,
            ClienteInexistenteException {
        BuscarCliente(nick).QuitarTemaDeLista(nomLista,nomTema,nomAlbum);
    }
    
    public void Favoritear(String nick, DataFavoriteable dataFav) throws ClienteInexistenteException,
            FavoritoRepetidoException, ListaInexistenteException, ArtistaInexistenteException,
            AlbumInexistenteException {
        BuscarCliente(nick).Favoritear(BuscarFavoriteable(dataFav));
    }
    public void DesFavoritear(String nick, DataFavoriteable dataFav) throws ClienteInexistenteException,
            FavoritoRepetidoException, ListaInexistenteException, ArtistaInexistenteException,
            AlbumInexistenteException {
        BuscarCliente(nick).DesFavoritear(BuscarFavoriteable(dataFav));
    }
    
    void AgregarTemaLista(Tema t,String usr, String lista) throws Exception {
        Cliente cliente = null;
        cliente = GetClientes().get(usr);
        if (cliente == null) {
            throw new ClienteInexistenteException("No se encontro el cliente");
        }
        cliente.AgregarTemaLista(t, lista);
    }
}
