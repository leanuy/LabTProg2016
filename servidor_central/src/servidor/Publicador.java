package servidor;
import espotify.Fabrica;
import espotify.datatypes.BeanBusqueda;
import espotify.datatypes.BeanConsultaGenero;
import espotify.datatypes.DataAlbumExt;
import espotify.datatypes.DataArtista;
import espotify.datatypes.DataArtistaExt;
import espotify.datatypes.DataCliente;
import espotify.datatypes.DataClienteExt;
import espotify.datatypes.DataColeccionString;
import espotify.datatypes.DataColeccionSuscripcion;
import espotify.datatypes.DataLista;
import espotify.datatypes.DataColeccionRanking;
import espotify.datatypes.DataColeccionTemas;
import espotify.datatypes.DataDefecto;
import espotify.datatypes.DataImagen;
import espotify.datatypes.DataParticular;
import espotify.datatypes.DataSuscripcion;
import espotify.datatypes.DataSuscripcionVigente;
import espotify.datatypes.DataTema;
import espotify.datatypes.DataTemaWeb;
import espotify.datatypes.DataUsuario;
import espotify.datatypes.TipoSuscripcion;
import espotify.excepciones.AlbumInexistenteException;
import espotify.excepciones.ArtistaInexistenteException;
import espotify.excepciones.AutoSeguirseException;
import espotify.excepciones.ClienteInexistenteException;
import espotify.excepciones.CorreoRepetidoException;
import espotify.excepciones.FormatoIncorrectoException;
import espotify.excepciones.GeneroInexistenteException;
import espotify.excepciones.ListaInexistenteException;
import espotify.excepciones.NickRepetidoException;
import espotify.excepciones.NoHaySuscripcionException;
import espotify.excepciones.SeguidoInexistenteException;
import espotify.excepciones.SeguidoRepetidoException;
import espotify.excepciones.SeguidorInexistenteException;
import espotify.excepciones.TemaRepetidoException;
import espotify.excepciones.TemaTipoInvalidoException;
import espotify.excepciones.TransicionSuscripcionInvalidaException;
import espotify.excepciones.UsuarioInexistenteException;
import espotify.excepciones.YaPublicaException;
import espotify.interfaces.IBuscar;
import espotify.interfaces.web.IVerGenero;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.image.BufferedImage;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;
/**
 *
 * @author JavierM42
 */
@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class Publicador {
    private Endpoint endpoint = null;
    //Constructor
    public Publicador(){}

    //Operaciones las cuales quiero publicar

    @WebMethod(exclude = true)
    public void publicar(){
         endpoint = Endpoint.publish("http://localhost:9128/publicador", this);
    }

    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
            return endpoint;
    }

    @WebMethod
    public boolean existeUsuarioNick(String nick) {
        return Fabrica.getIValidar().existeUsuarioNick(nick);
    }
    
    @WebMethod
    public boolean existeUsuarioCorreo(String correo) {
        return Fabrica.getIValidar().existeUsuarioCorreo(correo);
    }
    
    @WebMethod
    public void altaCliente(DataCliente dataCli)
            throws NickRepetidoException,
            CorreoRepetidoException, FormatoIncorrectoException {
        Fabrica.getIAltaPerfil().altaCliente(dataCli);
    }
    
    @WebMethod
    public void altaArtista(DataArtista dataArt)
            throws NickRepetidoException, CorreoRepetidoException,
            FormatoIncorrectoException {
        Fabrica.getIAltaPerfil().altaArtista(dataArt);
    }
    
    @WebMethod
    public DataUsuario buscarUsuario(String nickUsuario) throws UsuarioInexistenteException {
        return Fabrica.getIIniciarSesion().buscarUsuario(nickUsuario);
    }
    
    @WebMethod
    public boolean checkPassword(String nickUsuario, String password) throws UsuarioInexistenteException {
        return Fabrica.getIIniciarSesion().checkPassword(nickUsuario, password);
    }
    
    @WebMethod
    public boolean tieneSuscripcionVigente(String nick) throws ClienteInexistenteException {
        return Fabrica.getISuscripcionWeb().tieneSuscripcionVigente(nick);
    }
    
    @WebMethod
    public DataColeccionString listarArtistas() {
        return new DataColeccionString(Fabrica.getIListarUsuarios().listarArtistas());
    }
    
    @WebMethod
    public DataColeccionString listarClientes() {
        return new DataColeccionString(Fabrica.getIListarUsuarios().listarClientes());
    }
    
    @WebMethod
    public boolean esCliente(String nick)
            throws UsuarioInexistenteException {
        return Fabrica.getIVerPerfil().esCliente(nick);
    }
    
    @WebMethod
    public DataClienteExt consultaCliente(String nick) 
            throws ClienteInexistenteException {
        return Fabrica.getIVerPerfil().consultaCliente(nick);
    }
    
    @WebMethod
    public boolean siguiendo(String seguidor, String seguido) throws ClienteInexistenteException {
        return Fabrica.getIVerPerfil().siguiendo(seguidor, seguido);
    }
    
    @WebMethod
    public DataArtistaExt consultaArtista(String nick)
        throws ArtistaInexistenteException {
        return Fabrica.getIVerPerfil().consultaArtista(nick);
    }
    
    @WebMethod
    public DataColeccionString listarAlbumesDeArtista(String nomArtista)
        throws ArtistaInexistenteException {
        return new DataColeccionString(Fabrica.getIVerPerfil().listarAlbumesDeArtista(nomArtista));
    }
    
    @WebMethod
    public DataColeccionString listarListasPublicasDeCliente(String nick)
            throws ClienteInexistenteException {
        return new DataColeccionString(Fabrica.getIVerPerfil().listarListasPublicasDeCliente(nick));
    }
    
    @WebMethod
    public DataColeccionString listarListasPrivadasDeCliente(String nick)
            throws ClienteInexistenteException {
        return new DataColeccionString(Fabrica.getIVerPerfil().listarListasPrivadasDeCliente(nick));
    }
    
    @WebMethod
    public DataLista darInfoParticular(String nomLista, String nick)
            throws ClienteInexistenteException, ListaInexistenteException {
        return Fabrica.getIVerListaParticular().darInfoParticular(nomLista, nick);
    }
    
    @WebMethod
    public boolean listaEsPrivada(String nomLista, String nick)
            throws ClienteInexistenteException, ListaInexistenteException {
        return Fabrica.getIVerListaParticular().listaEsPrivada(nomLista, nick);
    }
    
    @WebMethod
    public DataColeccionSuscripcion listarSuscripcionesCliente(String nickname) throws ClienteInexistenteException {
        return new DataColeccionSuscripcion(Fabrica.getISuscripcionWeb().listarSuscripcionesCliente(nickname));
    }
    
    @WebMethod
    public DataSuscripcion obtenerSuscripcionActual(String nickname) throws ClienteInexistenteException, NoHaySuscripcionException {
        DataSuscripcion salida = Fabrica.getISuscripcionWeb().obtenerSuscripcionActual(nickname);
        if (salida == null) {
            throw new NoHaySuscripcionException();
        }
        return salida;
    }
    
    @WebMethod
    public void cancelarSuscripcion(String nickname) throws 
            NoHaySuscripcionException, TransicionSuscripcionInvalidaException,
            ClienteInexistenteException {
        Fabrica.getISuscripcionWeb().cancelarSuscripcion(nickname);
    }
    
    @WebMethod
    public BeanConsultaGenero consultaGenero(String nomGenero) throws GeneroInexistenteException {
        BeanConsultaGenero salida = new BeanConsultaGenero();
        IVerGenero inter = Fabrica.getIVerGenero();
        salida.setListas(inter.listarListasDeGenero(nomGenero));
        salida.setAlbums(inter.listarAlbumesDeGenero(nomGenero));
        salida.setData(inter.consultaGenero(nomGenero));
        return salida;
    }
    
    @WebMethod
    public void altaSeguir(String nomSeguidor, String nomSeguido)
            throws SeguidorInexistenteException, SeguidoInexistenteException,
            SeguidoRepetidoException, AutoSeguirseException {
        Fabrica.getIWebSeguir().altaSeguir(nomSeguidor, nomSeguido);
    }
    
    @WebMethod
    public void dejarDeSeguir(String nomSeguidor, String nomSeguido)
            throws SeguidoInexistenteException, SeguidorInexistenteException {
        Fabrica.getIWebSeguir().dejarDeSeguir(nomSeguidor, nomSeguido);
    }

    @WebMethod
    public BeanBusqueda buscar(String busqueda) {
        BeanBusqueda salida = new BeanBusqueda();
        IBuscar inter = Fabrica.getIBuscar();
        salida.setAlbums(inter.buscarAlbums(busqueda));
        salida.setListas(inter.buscarListas(busqueda));
        salida.setTemas(inter.buscarTemas(busqueda));
        return salida;
    }
    
    @WebMethod
    public void publicarLista(String nomLista, String nick)
            throws ClienteInexistenteException,
            ListaInexistenteException,
            YaPublicaException {
        Fabrica.getIPublicarLista().publicarLista(nomLista, nick);
    }
    
    @WebMethod
    public DataColeccionRanking darRanking() {
        return new DataColeccionRanking(Fabrica.getIRanking().darRanking());
    }
    
    @WebMethod
    public boolean contratarSuscripcion(TipoSuscripcion tipo, String nickname) throws ClienteInexistenteException {
        return Fabrica.getISuscripcionWeb().contratarSuscripcion(tipo, nickname);
    }
    
    @WebMethod
    public DataColeccionTemas sugerir() {
        return Fabrica.getISugerencias().sugerir();
    }
    
    @WebMethod
    public DataColeccionString listarListasDeCliente(String nick)
            throws ClienteInexistenteException {
        return new DataColeccionString(Fabrica.getIAgregarTemaListaWeb().listarListasDeCliente(nick));
    }

    @WebMethod
    public DataTema consultaTema(String nick, String nomAlbum, String nomTema)
        throws ArtistaInexistenteException, AlbumInexistenteException {
        return Fabrica.getIVerAlbum().consultaTema(nick, nomAlbum, nomTema);
    }
    
    @WebMethod
    public String consultaURLTema(String nick, String nomAlbum, String nomTema)
            throws ArtistaInexistenteException, AlbumInexistenteException {
        DataTema data = Fabrica.getIVerAlbum().consultaTema(nick, nomAlbum, nomTema);
        if (data instanceof DataTemaWeb) {
            return ((DataTemaWeb) data).getUrl();
        } else {
            return "";
        }
    }
    
    @WebMethod
    public void agregarTemaWebxAlbum(String nick_sesion, String lista_poner, 
            String nom_tema, String album, String artista) throws ArtistaInexistenteException, 
            AlbumInexistenteException, ClienteInexistenteException, ListaInexistenteException, TemaRepetidoException {
        Fabrica.getIAgregarTemaListaWeb().agregarTemaWebxAlbum(nick_sesion, lista_poner, nom_tema, album, artista);
    }
    
    @WebMethod
    public String consultaFechaVencimientoSuscripcionVigente(String nick) throws ClienteInexistenteException {
        DataSuscripcionVigente sus = (DataSuscripcionVigente) Fabrica.getISuscripcionWeb().obtenerSuscripcionActual(nick);
        return sus.getFechaVenStr();
    }
    
    @WebMethod
    public void renovarSuscripcion(String nick) throws ClienteInexistenteException,
            TransicionSuscripcionInvalidaException, NoHaySuscripcionException {
        Fabrica.getISuscripcionWeb().renovarSuscripcion(nick);
    }
    
    @WebMethod
    public byte[] getAudio(String nick, String album, String tema,boolean esDescarga) throws ArtistaInexistenteException,
            AlbumInexistenteException, TemaTipoInvalidoException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try {
            BufferedInputStream is = Fabrica.getIObtenerAudio().getAudio(nick, album, tema, esDescarga);
            int nRead;
            byte[] data = new byte[16384];
            
            while ((nRead = is.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, nRead);
            }
            
            buffer.flush();            
        } catch (IOException ex) {
            Logger.getLogger(Publicador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return buffer.toByteArray();
    }
    
    @WebMethod
        public DataAlbumExt consultaAlbum(String nomAlbum, String nomArtista)
        throws ArtistaInexistenteException, AlbumInexistenteException {
        return Fabrica.getIVerAlbum().consultaAlbum(nomAlbum, nomArtista);
    }

    @WebMethod
    public DataLista darInfoDefecto(String nombre)
        throws ClienteInexistenteException, ListaInexistenteException {
        return Fabrica.getIVerListaDefecto().darInfoDefecto(nombre);
    }
    
    @WebMethod
    public boolean esFavoritoTema(String nick, String artista, String album, String nomtema) throws ClienteInexistenteException, AlbumInexistenteException, ArtistaInexistenteException, ListaInexistenteException {
            DataTema data = new DataTema(nomtema, 0, 0, artista, album);
            return Fabrica.getIFavoritos().esFavorito(nick, data);
    }
    
    @WebMethod
    public boolean esFavoritoDefecto(String nick, String nomlista) throws ClienteInexistenteException, AlbumInexistenteException, ArtistaInexistenteException, ListaInexistenteException {
            DataDefecto lisdefecto = new DataDefecto("", nomlista, null);
            return Fabrica.getIFavoritos().esFavorito(nick, lisdefecto);
    }
    
    @WebMethod
    public boolean esFavoritoParticular(String nickSesion, String nomCliente, String nomlista) throws ClienteInexistenteException, AlbumInexistenteException, ArtistaInexistenteException, ListaInexistenteException {
            DataParticular lispart = new DataParticular(nomCliente, nomlista, null);
            return Fabrica.getIFavoritos().esFavorito(nickSesion, lispart);
    }
    
    @WebMethod
    public DataImagen getImageUsuario(String nickUsr) throws UsuarioInexistenteException {
        BufferedImage img = Fabrica.getIImagen().getImageUsuario(nickUsr);
        return new DataImagen(img);
    }
    
    @WebMethod
    public DataImagen getImageAlbum(String nickUsr, String album) {
        BufferedImage img = Fabrica.getIImagen().getImageAlbum(nickUsr, album);
        return new DataImagen(img);
    }
    
    @WebMethod
    public DataImagen getImageLista(String nickUsr, String lista) {
        BufferedImage img = Fabrica.getIImagen().getImageLista(nickUsr, lista);
        return new DataImagen(img);
    }
    
    @WebMethod
    public boolean esArtista(String nickUsr) {
        return Fabrica.getIImagen().esArtista(nickUsr);
    }
}
