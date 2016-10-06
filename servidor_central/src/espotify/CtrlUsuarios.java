package espotify;

import espotify.datatypes.DataAlbum;
import espotify.datatypes.DataAlbumExt;
import espotify.datatypes.DataArtista;
import espotify.datatypes.DataArtistaExt;
import espotify.datatypes.DataCliente;
import espotify.datatypes.DataClienteExt;
import espotify.datatypes.DataDefecto;
import espotify.datatypes.DataFavoriteable;
import espotify.datatypes.DataLista;
import espotify.datatypes.DataParticular;
import espotify.datatypes.DataPreview;
import espotify.datatypes.DataSuscripcion;
import espotify.datatypes.DataTema;
import espotify.datatypes.DataUsuario;
import espotify.datatypes.TipoSuscripcion;
import espotify.excepciones.AlbumInexistenteException;
import espotify.excepciones.ArtistaInexistenteException;
import espotify.excepciones.AutoSeguirseException;
import espotify.excepciones.CampoVacioException;
import espotify.excepciones.ClienteInexistenteException;
import espotify.excepciones.CorreoRepetidoException;
import espotify.excepciones.FavoritoRepetidoException;
import espotify.excepciones.FormatoIncorrectoException;
import espotify.excepciones.ListaInexistenteException;
import espotify.excepciones.ListaRepetidaException;
import espotify.excepciones.NickRepetidoException;
import espotify.excepciones.NoHaySuscripcionException;
import espotify.excepciones.SeguidoInexistenteException;
import espotify.excepciones.SeguidoRepetidoException;
import espotify.excepciones.SeguidorInexistenteException;
import espotify.excepciones.TemaTipoInvalidoException;
import espotify.excepciones.TransicionSuscripcionInvalidaException;
import espotify.excepciones.UsuarioInexistenteException;
import espotify.excepciones.YaPublicaException;
import espotify.interfaces.IActualizarSuscripcion;
import espotify.interfaces.IAltaPerfil;
import espotify.interfaces.IAltaSeguir;
import espotify.interfaces.IConsultaArtista;
import espotify.interfaces.IConsultaCliente;
import espotify.interfaces.IDejarDeSeguir;
import espotify.interfaces.IDesFavoritear;
import espotify.interfaces.IFavoritear;
import espotify.interfaces.IIniciarSesion;
import espotify.interfaces.web.IFavoritos;
import espotify.interfaces.web.IListarArtistas;
import espotify.interfaces.web.IListarClientes;
import espotify.interfaces.web.IObtenerAudio;
import espotify.interfaces.web.ISuscripcionWeb;
import espotify.interfaces.web.IValidar;
import espotify.interfaces.web.IVerPerfil;
import espotify.interfaces.web.IWebSeguir;
import java.io.BufferedInputStream;
import java.io.File;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CtrlUsuarios implements IDesFavoritear, IConsultaCliente, IConsultaArtista,
        IAltaSeguir, IDejarDeSeguir, IAltaPerfil, IFavoritear, IActualizarSuscripcion,
        IVerPerfil, IIniciarSesion, IWebSeguir, IListarArtistas, IListarClientes, IValidar, 
        IFavoritos, ISuscripcionWeb, IObtenerAudio {
//Constructor
    public CtrlUsuarios() {
    }
//Acceso al Manejador
    private void agregarCliente(String nick, Cliente cli) {
        ManejadorColecciones.getInstancia().agregarCliente(nick, cli);
    }
    
    private void agregarArtista(String nick, Artista art) {
        ManejadorColecciones.getInstancia().agregarArtista(nick, art);
    }
    
    Artista buscarArtista(String nombre) throws ArtistaInexistenteException {
        Artista artista = ManejadorColecciones.getInstancia().buscarArtista(nombre);
        if (artista == null) {
            throw new ArtistaInexistenteException();
        }
        return artista;
    }
    
    Cliente buscarCliente(String nick) throws ClienteInexistenteException {
        Cliente cliente = getClientes().get(nick);
        if (cliente == null) {
            throw new ClienteInexistenteException("No existe ese cliente!");
        }
        return cliente;
    }
    
    private static Map<String, Artista> getArtistas() {
        return ManejadorColecciones.getInstancia().getArtistas();
    }
    
    private static Map<String, Cliente> getClientes() {
        return ManejadorColecciones.getInstancia().getClientes();
    }

//Otras búsquedas
    private Favoriteable buscarFavoriteable(DataFavoriteable dataFav)
            throws ListaInexistenteException, ClienteInexistenteException,
            ArtistaInexistenteException, AlbumInexistenteException {
        if (dataFav instanceof DataLista) {
            if (dataFav instanceof DataParticular) {
                DataParticular dataPart = (DataParticular) dataFav;
                return buscarListaPublicaDeCliente(dataPart.getNomCliente(),dataPart.getNombre());
            } else if (dataFav instanceof DataDefecto) {
                return new CtrlListas().buscarLista(((DataDefecto) dataFav).getNombre());
            }
        } else if (dataFav instanceof DataAlbum) {
            DataAlbum dataAlbum = (DataAlbum) dataFav;
            return buscarAlbumDeArtista(dataAlbum.getNickArtista(),dataAlbum.getNombre());
        } else if (dataFav instanceof DataTema) {
            return devolverTema((DataTema)dataFav);
        }
        return null;
    }
    
    public boolean esFavorito(String nick, DataFavoriteable fav) 
            throws ClienteInexistenteException, ListaInexistenteException, ArtistaInexistenteException, AlbumInexistenteException {
        return buscarCliente(nick).esFavorito(buscarFavoriteable(fav));
    }
    
    private Publica buscarListaPublicaDeCliente(String nickCliente, String nomLista) throws
            ClienteInexistenteException, ListaInexistenteException {
        return buscarCliente(nickCliente).buscarListaPublica(nomLista);
    }
    
    private Album buscarAlbumDeArtista(String nickArtista,String nomAlbum) throws
            ArtistaInexistenteException, AlbumInexistenteException {
        return buscarArtista(nickArtista).buscarAlbum(nomAlbum);
    }

    Tema devolverTema(DataTema dataTema) throws ArtistaInexistenteException {
        return buscarArtista(dataTema.getNomArtista()).devolverTema(dataTema);
    }

//Listas
    @Override
    public ArrayList<String> listarClientes() {
        ArrayList salida = new ArrayList();
        getClientes().keySet().stream().forEach((key) -> {
            salida.add(key);
        });
        return salida;
    }
    
    @Override
    public List<String> listarArtistas() {
        List salida = new ArrayList();
        getArtistas().keySet().stream().forEach((key) -> {
            salida.add(key);
        });
        return salida;
    }
    
    List<String> listarListasDeCliente(String nick) throws ClienteInexistenteException {
        return buscarCliente(nick).listarListas();
    }
    
    @Override
    public List<String> listarListasPrivadasDeCliente(String nick)
            throws ClienteInexistenteException {
        return buscarCliente(nick).listarListasPrivadas();
    }
    
    @Override
    public List<String> listarListasPublicasDeCliente(String nick)
            throws ClienteInexistenteException {
        return buscarCliente(nick).listarListasPublicas();
    }
    
    @Override
    public List<String> listarListasDefecto() {
        return new CtrlListas().listarListasDefecto();
    }
    
    List<DataTema> listarTemasDeLista(String nick, String nombre)
            throws ClienteInexistenteException, ListaInexistenteException {
        return buscarCliente(nick).listarTemasDeLista(nombre);
    }

    @Override
    public List<String> listarSeguibles(String nomSeguidor) throws SeguidorInexistenteException {
        Cliente cli;
        try {
            cli = buscarCliente(nomSeguidor);
        } catch (ClienteInexistenteException ex) {
            throw new SeguidorInexistenteException();
        }
        List<String> salida = new ArrayList<>();
        for (Entry<String, Cliente> entry :  getClientes().entrySet()) {
            String key = entry.getKey();
            if (!cli.sigueA(key) && !key.equals(cli.getNick())) {
                salida.add(key);
            }
        }
        for (Entry<String, Artista> entry : getArtistas().entrySet()) {
            String key = entry.getKey();
            if (!cli.sigueA(key)) {
                salida.add(key);
            }
        }
        return salida;
    }
    
    @Override
    public String[] getSeguidos(String usr) throws ClienteInexistenteException {
        return this.consultaCliente(usr).getSeguidos();
    }
    
    @Override
    public List<String> listarAlbumesDeArtista(String nomArtista)
            throws ArtistaInexistenteException {
        return buscarArtista(nomArtista).listarAlbumes();
    }
    
    List<DataTema> listarTemasAlbum(String art, String alb) throws ArtistaInexistenteException,
            AlbumInexistenteException {
        return buscarArtista(art).buscarAlbum(alb).getDataTemas();
    }
    
    //Consultas
    @Override
    public DataClienteExt consultaCliente(String nick) throws ClienteInexistenteException {
        return buscarCliente(nick).getDataClienteExt();
    }
    
    @Override
    public DataArtistaExt consultaArtista(String nick) throws ArtistaInexistenteException {
        return buscarArtista(nick).getDataArtistaExt();
    }
    
    @Override
    public boolean existeUsuarioCorreo(String correo) {
        boolean salida = false;
        Iterator<Entry<String,Cliente>> iterator = getClientes().entrySet().iterator();
        while (iterator.hasNext() && !salida) {
            Map.Entry<String,Cliente> entry = (Map.Entry<String,Cliente>) iterator.next();
            salida = entry.getValue().getCorreo().equals(correo);
        }
        Iterator<Entry<String,Artista>> iterator2 = getArtistas().entrySet().iterator();
        while (iterator2.hasNext() && !salida) {
            Map.Entry<String,Artista> entry = (Map.Entry<String,Artista>) iterator2.next();
            salida = entry.getValue().getCorreo().equals(correo);
        }
        return salida;       
    }
    
    @Override
    public boolean existeUsuarioNick(String nick) {
        return getClientes().containsKey(nick) || getArtistas().containsKey(nick);
    }
    
    DataLista darInfoLista(String nomLista, String nick) throws ClienteInexistenteException,
            ListaInexistenteException {
        return buscarCliente(nick).darInfoLista(nomLista);
    }
    
    DataAlbumExt consultaAlbum(String nomAlbum, String nomArtista)
            throws ArtistaInexistenteException, AlbumInexistenteException {
        return buscarArtista(nomArtista).getDataAlbumExt(nomAlbum);
    }        

    //Operaciones
    @Override
    public void altaSeguir(String nomSeguidor, String nomSeguido)
            throws SeguidorInexistenteException, SeguidoInexistenteException,
            SeguidoRepetidoException, AutoSeguirseException {
        Cliente cli = null;
        try {
            cli = buscarCliente(nomSeguidor);
        } catch (ClienteInexistenteException ex) {
            throw new SeguidorInexistenteException();
        }
        Usuario user = null;
        try {
            user = buscarCliente(nomSeguido);
        } catch (ClienteInexistenteException ex) {
            try {
                user = buscarArtista(nomSeguido);
            } catch (ArtistaInexistenteException e) {
                throw new SeguidoInexistenteException();
            }
        }
        cli.seguir(user);
        user.agregarSeguidor(cli);
    }
    
    @Override
    public void dejarDeSeguir(String nomSeguidor, String nomSeguido)
            throws SeguidorInexistenteException, SeguidoInexistenteException {
        Cliente cli = null;
        try {
            cli = buscarCliente(nomSeguidor);
        } catch (ClienteInexistenteException ex) {
            throw new SeguidorInexistenteException();
        }
        Usuario user = null;
        try {
            user = buscarCliente(nomSeguido);
        } catch (ClienteInexistenteException ex) {
            try {
                user = buscarArtista(nomSeguido);
            } catch (ArtistaInexistenteException e) {
                throw new SeguidoInexistenteException();
            }
        }
        cli.dejarDeSeguir(user);
        user.noMeSiguenMas(cli);
    }
    
    @Override
    public void altaCliente(DataCliente dataCliente)
            throws NickRepetidoException, CorreoRepetidoException,
            FormatoIncorrectoException {
        if (Usuario.validarDatosUsuario(dataCliente)) {
            if (existeUsuarioCorreo(dataCliente.getCorreo())) {
                throw new CorreoRepetidoException();
            } else {
                if (existeUsuarioNick(dataCliente.getNick())) {
                    throw new NickRepetidoException();
                } else {
                    Cliente nuevoCli = new Cliente(dataCliente);
                    agregarCliente(dataCliente.getNick(), nuevoCli);
                }
            }
        } else {
            throw new FormatoIncorrectoException();
        }
    }
    
    @Override
    public void altaArtista(DataArtista dataArt)
            throws NickRepetidoException, CorreoRepetidoException,
            FormatoIncorrectoException {
        if (Artista.validarDatosArtista(dataArt)) {
            if (existeUsuarioCorreo(dataArt.getCorreo())) {
                throw new CorreoRepetidoException();
            } else {
                if (existeUsuarioNick(dataArt.getNick())) {
                    throw new NickRepetidoException();
                } else {
                    Artista nuevoArtista = new Artista(dataArt);
                    agregarArtista(dataArt.getNick(), nuevoArtista);
                }
            }
        } else {
            throw new FormatoIncorrectoException();
        }
    }
    
    void publicarLista(String nomLista, String nick) throws ClienteInexistenteException,
            ListaInexistenteException, YaPublicaException {
        buscarCliente(nick).publicarLista(nomLista);
    }
    
    void altaLista(DataParticular dataLista)
            throws ClienteInexistenteException, ListaRepetidaException, CampoVacioException {
        buscarCliente(dataLista.getNomCliente()).altaLista(dataLista);
    }
    
    void quitarTemaDeLista(String nick, String nomLista, String nomTema, String nomAlbum)
            throws ListaInexistenteException, ClienteInexistenteException {
        buscarCliente(nick).quitarTemaDeLista(nomLista,nomTema,nomAlbum);
    }
    
    @Override
    public void favoritear(String nick, DataFavoriteable dataFav)
            throws ClienteInexistenteException, FavoritoRepetidoException,
            ListaInexistenteException, ArtistaInexistenteException,
            AlbumInexistenteException {
        buscarCliente(nick).favoritear(buscarFavoriteable(dataFav));
    }

    @Override
    public void desFavoritear(String nick, DataFavoriteable dataFav)
            throws ClienteInexistenteException, FavoritoRepetidoException,
            ListaInexistenteException, ArtistaInexistenteException,
            AlbumInexistenteException {
        buscarCliente(nick).desFavoritear(buscarFavoriteable(dataFav));
    }
    
    void agregarTemaLista(Tema tema,String usr, String lista) throws Exception {
        buscarCliente(usr).agregarTemaLista(tema, lista);
    }
    
    @Override
    public DataSuscripcion getSuscripcionDeCliente(String nick)
            throws ClienteInexistenteException, NoHaySuscripcionException {
        return buscarCliente(nick).getSuscripcionActiva();
    }
    
    @Override
    public void aprobarSuscripcion(String nick)
            throws ClienteInexistenteException, NoHaySuscripcionException,
            TransicionSuscripcionInvalidaException {
        buscarCliente(nick).aprobarSuscripcion();
    }
    
    @Override
    public void cancelarSuscripcion(String nick)
            throws ClienteInexistenteException, NoHaySuscripcionException,
            TransicionSuscripcionInvalidaException {
        buscarCliente(nick).cancelarSuscripcion();
    }
    
    @Override
    public boolean esCliente(String nick) throws UsuarioInexistenteException {
        boolean esCliente = true;
        try {
            buscarCliente(nick);
            return true;
        } catch (ClienteInexistenteException e) {
            esCliente = false;
        }
        if (esCliente) {
        } else {
            try {
                buscarArtista(nick);
            } catch (ArtistaInexistenteException ex) {
                throw new UsuarioInexistenteException();
            }
        }
        return esCliente;
    }

    @Override
    public DataUsuario buscarUsuario(String nickUsuario) throws UsuarioInexistenteException {
        if (!this.existeUsuarioNick(nickUsuario)) {
            throw new UsuarioInexistenteException();
        }
        Usuario usuario;
        DataUsuario dataUsuario;
        try {
            usuario = this.buscarArtista(nickUsuario);
            dataUsuario = ((Artista)usuario).getDataArtistaExt();
        } catch (ArtistaInexistenteException ex) {
            try {
                usuario = this.buscarCliente(nickUsuario);
                dataUsuario = ((Cliente)usuario).getDataClienteExt();
            } catch (ClienteInexistenteException e) {
                throw new UsuarioInexistenteException();
            }
        }
        return dataUsuario;
    }
    
    @Override
    public boolean checkPassword(String nickUsuario, String password) throws UsuarioInexistenteException {
        Usuario usuario;
        try {
            usuario = this.buscarArtista(nickUsuario);
        } catch (ArtistaInexistenteException ex) {
            try {
                usuario = this.buscarCliente(nickUsuario);
            } catch (ClienteInexistenteException e) {
                throw new UsuarioInexistenteException();
            }
        }
        return usuario.getPassword().equals(password);
    }

    boolean listaEsPrivada(String nomLista, String nick) 
            throws ClienteInexistenteException, ListaInexistenteException {
        return buscarCliente(nick).listaEsPrivada(nomLista);
    }

    @Override
    public boolean siguiendo(String seguidor, String seguido) throws ClienteInexistenteException {
        return buscarCliente(seguidor).siguiendo(seguido);
    }

    @Override
    public List<DataPreview> previewArtistas() {
        List salida = new ArrayList();
        for (Entry<String, Artista> entry : getArtistas().entrySet()) {
            Artista art = entry.getValue();
            salida.add(art.getPreview());
        }
        return salida;
    }
    
    @Override
    public List<DataPreview> previewClientes() {
        List salida = new ArrayList();
        for (Entry<String, Cliente> entry : getClientes().entrySet()) {
            Cliente cli = entry.getValue();
            salida.add(cli.getPreview());
        }
        return salida;
    }

    @Override
    public List<DataFavoriteable> listarFavoritos(String nick) throws ClienteInexistenteException {
        return buscarCliente(nick).listarFavoritos();
    }
    
    @Override
    public List<DataSuscripcion> listarSuscripcionesCliente(String nickname) throws ClienteInexistenteException {
        Cliente client;
        List<DataSuscripcion> suscripciones = null;
        client = buscarCliente(nickname);
        suscripciones = client.getSuscripciones();
        return suscripciones;
    }
    @Override
    public DataSuscripcion obtenerSuscripcionActual(String nickname) throws ClienteInexistenteException {
        Cliente client;
        DataSuscripcion suscripcion;
        try { 
            client = buscarCliente(nickname);
            suscripcion = client.getSuscripcionActiva();                                 
        } catch (NoHaySuscripcionException e) {
            return null;
        } 
        return suscripcion;
    }
    
    @Override
    public boolean contratarSuscripcion(TipoSuscripcion tipo, String nickname) throws ClienteInexistenteException {
        Cliente client;
        boolean result = false;
        try {
            buscarCliente(nickname).contratar(tipo);
            result = true;
        } catch (TransicionSuscripcionInvalidaException | ClienteInexistenteException e) {
            result = false;
        }
        return result;
    }
    
    @Override
    public void cancelarSuscripcionVencida(String nickname) throws 
            NoHaySuscripcionException, TransicionSuscripcionInvalidaException,
            ClienteInexistenteException {
        Cliente client;
        client = buscarCliente(nickname);
        client.cancelarSuscripcion();
    }
    @Override
    public void aprobarSuscripcionPendiente(String nickname) throws NoHaySuscripcionException,
            TransicionSuscripcionInvalidaException, ClienteInexistenteException {
        Cliente client;
        client = buscarCliente(nickname);
        client.aprobarSuscripcion();
    }
    @Override
    public void actualizarEstadoSuscripcion(String nickname) {
        
    }
    @Override
    public void renovarSuscripcion(String nickname) throws ClienteInexistenteException,
            TransicionSuscripcionInvalidaException, NoHaySuscripcionException {
        Cliente client;
        client = buscarCliente(nickname);
        client.renovarSuscripcion();
    }
    @Override
    public void vencerSuscripcionActual(String nickname) throws ClienteInexistenteException {
        Cliente client;
        client = buscarCliente(nickname);
        client.vencerSuscripcion();
    }
    
    public boolean tieneSuscripcionVigente(String nick) throws ClienteInexistenteException {
        return buscarCliente(nick).tieneSuscripcionVigente();
    }
    
    DataTema consultaTema(String nick, String nomAlbum, String nomTema)
            throws ArtistaInexistenteException, AlbumInexistenteException {
        return buscarArtista(nick).consultaTema(nomAlbum,nomTema);
    }
    
    public BufferedInputStream getAudio(String nick, String album, String tema)
            throws ArtistaInexistenteException, AlbumInexistenteException, TemaTipoInvalidoException {
        return buscarArtista(nick).getAudio(album,tema);
    }

}
