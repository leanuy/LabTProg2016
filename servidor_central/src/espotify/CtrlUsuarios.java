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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CtrlUsuarios implements IDesFavoritear, IConsultaCliente, IConsultaArtista,
        IAltaSeguir, IDejarDeSeguir, IAltaPerfil, IFavoritear {
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
                return new CtrlListas().BuscarLista(((DataDefecto) dataFav).getNombre());
            }
        } else if (dataFav instanceof DataAlbum) {
            DataAlbum dataAlbum = (DataAlbum) dataFav;
            return buscarAlbumDeArtista(dataAlbum.getNickArtista(),dataAlbum.getNombre());
        } else if (dataFav instanceof DataTema) {
            return devolverTema((DataTema)dataFav);
        }
        return null;
    }
    
    private Publica buscarListaPublicaDeCliente(String nickCliente, String nomLista) throws
            ClienteInexistenteException, ListaInexistenteException {
        return buscarCliente(nickCliente).BuscarListaPublica(nomLista);
    }
    
    private Album buscarAlbumDeArtista(String nickArtista,String nomAlbum) throws
            ArtistaInexistenteException, AlbumInexistenteException {
        return buscarArtista(nickArtista).BuscarAlbum(nomAlbum);
    }

    Tema devolverTema(DataTema dataTema) throws ArtistaInexistenteException {
        return buscarArtista(dataTema.getNomArtista()).DevolverTema(dataTema);
    }

//Listas
    @Override
    public ArrayList<String> ListarClientes() {
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
        return buscarCliente(nick).ListarListas();
    }
    
    List<String> listarListasPrivadasDeCliente(String nick) throws ClienteInexistenteException {
        return buscarCliente(nick).ListarListasPrivadas();
    }
    
    @Override
    public List<String> listarListasPublicasDeCliente(String nick)
            throws ClienteInexistenteException {
        return buscarCliente(nick).ListarListasPublicas();
    }
    
    @Override
    public List<String> listarListasDefecto() {
        return new CtrlListas().ListarListasDefecto();
    }
    
    List<DataTema> listarTemasDeLista(String nick, String nombre)
            throws ClienteInexistenteException, ListaInexistenteException {
        return buscarCliente(nick).ListarTemasDeLista(nombre);
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
            if (!cli.SigueA(key) && !key.equals(cli.getNick())) {
                salida.add(key);
            }
        }
        for (Entry<String, Artista> entry : getArtistas().entrySet()) {
            String key = entry.getKey();
            if (!cli.SigueA(key)) {
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
        return buscarArtista(nomArtista).ListarAlbumes();
    }
    
    List<DataTema> listarTemasAlbum(String art, String alb) throws ArtistaInexistenteException,
            AlbumInexistenteException {
        return buscarArtista(art).BuscarAlbum(alb).getDataTemas();
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
    
    private boolean existeUsuarioCorreo(String correo) {
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
    
    private boolean existeUsuarioNick(String nick) {
        return getClientes().containsKey(nick) || getArtistas().containsKey(nick);
    }
    
    DataLista darInfoLista(String nomLista, String nick) throws ClienteInexistenteException,
            ListaInexistenteException {
        return buscarCliente(nick).DarInfoLista(nomLista);
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
    public void altaCliente(DataCliente dCliente)
            throws NickRepetidoException, CorreoRepetidoException,
            FormatoIncorrectoException {
        if (Usuario.validarDatosUsuario(dCliente)) {
            if (!existeUsuarioCorreo(dCliente.getCorreo())) {
                if (!existeUsuarioNick(dCliente.getNick())) {
                    Cliente nuevoCli = new Cliente(dCliente);
                    agregarCliente(dCliente.getNick(), nuevoCli);
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
    public void altaArtista(DataArtista dataArt)
            throws NickRepetidoException, CorreoRepetidoException,
            FormatoIncorrectoException {
        if (Artista.ValidarDatosArtista(dataArt)) {
            if (!existeUsuarioCorreo(dataArt.getCorreo())) {
                if (!existeUsuarioNick(dataArt.getNick())) {
                    Artista nuevoArtista = new Artista(dataArt);
                    agregarArtista(dataArt.getNick(), nuevoArtista);
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
    
    void publicarLista(String nomLista, String nick) throws ClienteInexistenteException,
            ListaInexistenteException, YaPublicaException {
        buscarCliente(nick).PublicarLista(nomLista);
    }
    
    void altaLista(DataParticular dataLista)
            throws ClienteInexistenteException, ListaRepetidaException {
        buscarCliente(dataLista.getNomCliente()).AltaLista(dataLista);
    }
    
    void quitarTemaDeLista(String nick, String nomLista, String nomTema, String nomAlbum)
            throws ListaInexistenteException, ClienteInexistenteException {
        buscarCliente(nick).QuitarTemaDeLista(nomLista,nomTema,nomAlbum);
    }
    
    @Override
    public void favoritear(String nick, DataFavoriteable dataFav)
            throws ClienteInexistenteException, FavoritoRepetidoException,
            ListaInexistenteException, ArtistaInexistenteException,
            AlbumInexistenteException {
        buscarCliente(nick).Favoritear(buscarFavoriteable(dataFav));
    }

    @Override
    public void desFavoritear(String nick, DataFavoriteable dataFav)
            throws ClienteInexistenteException, FavoritoRepetidoException,
            ListaInexistenteException, ArtistaInexistenteException,
            AlbumInexistenteException {
        buscarCliente(nick).DesFavoritear(buscarFavoriteable(dataFav));
    }
    
    void agregarTemaLista(Tema tema,String usr, String lista) throws Exception {
        buscarCliente(usr).AgregarTemaLista(tema, lista);
    }
}
