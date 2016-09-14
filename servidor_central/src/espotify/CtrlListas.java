package espotify;

import espotify.datatypes.DataDefecto;
import espotify.datatypes.DataGenero;
import espotify.datatypes.DataLista;
import espotify.datatypes.DataParticular;
import espotify.datatypes.DataTema;
import espotify.excepciones.AlbumInexistenteException;
import espotify.excepciones.ArtistaInexistenteException;
import espotify.excepciones.ClienteInexistenteException;
import espotify.excepciones.GeneroInexistenteException;
import espotify.excepciones.ListaInexistenteException;
import espotify.excepciones.ListaRepetidaException;
import espotify.excepciones.YaPublicaException;
import espotify.interfaces.IAgregarTemaLista;
import espotify.interfaces.IAltaLista;
import espotify.interfaces.IConsultaLista;
import espotify.interfaces.IPublicarLista;
import espotify.interfaces.IQuitarTemaLista;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CtrlListas implements IAltaLista, IPublicarLista,
        IConsultaLista, IAgregarTemaLista, IQuitarTemaLista {
    private static CtrlListas instancia;
    private String nickMem;
    private String nomListaMem;
    private List<DataTema> temasLista;
    
//Constructor
    public CtrlListas() {
    }
//Acceso al Manejador
    Defecto buscarLista(String nomLista) throws ListaInexistenteException {
        Defecto def = ManejadorColecciones.getInstancia().buscarLista(nomLista);
        if (def == null) {
            throw new ListaInexistenteException();
        }
        return def;
    }
    
    private static Map<String, Defecto> getListas() {
        return ManejadorColecciones.getInstancia().getListas();
    }
//Listas
    @Override
    public List<String> listarClientes() {
        return new CtrlUsuarios().listarClientes();
    }
    
    @Override
    public List<String> listarArtistas() {
        return new CtrlUsuarios().listarArtistas();
    }
    
    @Override
    public List<String> listarListasDeCliente(String nick) throws ClienteInexistenteException {
        nickMem = nick;
        return new CtrlUsuarios().listarListasDeCliente(nick);
    }
    
    @Override
    public List<String> listarListasPrivadasDeCliente(String nick) throws ClienteInexistenteException {
        return new CtrlUsuarios().listarListasPrivadasDeCliente(nick);
    }
    
    @Override
    public List<String> listarListasPublicasDeCliente(String nick) throws ClienteInexistenteException {
        return  new CtrlUsuarios().listarListasPublicasDeCliente(nick);
    }
    
    @Override
    public List<String> listarListasDefecto() {
        nickMem = "";
        return listarListasDefecto2();
    }
    
    @Override
    public List<String> listarListasDefecto2() {
        final List salida = new ArrayList();
        getListas().keySet().stream().forEach((key) -> {
            salida.add(key);
        });
        return salida;
    }
    
    @Override
    public List<DataTema> listarTemasLista(String nombre)
            throws ClienteInexistenteException, ListaInexistenteException {
        nomListaMem = nombre;
        if (nickMem.equals("")) /*listaron las por defecto*/ {
            return buscarLista(nombre).listarTemas();
        } else {
            return new CtrlUsuarios().listarTemasDeLista(nickMem,nombre);
        }
    }
    
    @Override
    public List<DataTema> listarTemasLista2(String cliente, String nomLista) throws Exception {
        if (cliente == null) {
            temasLista = buscarLista(nomLista).listarTemas();
        } else {
            temasLista = new CtrlUsuarios().listarTemasDeLista(cliente, nomLista);
        }
        return temasLista;
    }
    
    @Override
    public DataGenero listarGeneros() {
        return new CtrlMusica().listarGeneros();
    }
    
    @Override
    public List<String> listarListasDeGenero(String nomGenero) {
        List<String> salida = new ArrayList();
        for (Map.Entry<String, Defecto> entry : getListas().entrySet()) {
            Defecto def = entry.getValue();
            if (def.getNomGenero().equals(nomGenero)) {
                salida.add(def.getNombre());
            }
        }
        return salida;
    }
    
    @Override
    public List<String> listarAlbumesDeArtista(String nick) throws ArtistaInexistenteException {
        return new CtrlUsuarios().listarAlbumesDeArtista(nick);
    }
    
    @Override
    public List<DataTema> listarTemasAlbum(String art, String alb) throws
            ArtistaInexistenteException, AlbumInexistenteException {
        return new CtrlUsuarios().listarTemasAlbum(art, alb);
    }
    
//Consultas
    @Override
    public DataLista darInfoDefecto(String nomLista) throws ListaInexistenteException {
        return buscarLista(nomLista).getData();
    }
    
    @Override
    public DataLista darInfoParticular(String nomLista, String nick) throws
            ClienteInexistenteException, ListaInexistenteException {
        return new CtrlUsuarios().darInfoLista(nomLista, nick);
    }
    
    private boolean validarNombreListaDefecto(String nomLista) {
        return !nomLista.equals("") && !getListas().containsKey(nomLista);
    }
    
//Operaciones
    @Override
    public void publicarLista(String nomLista, String nick) throws ClienteInexistenteException,
            ListaInexistenteException, YaPublicaException {
        new CtrlUsuarios().publicarLista(nomLista,nick);
    }
    
    @Override
    public void removerTemaLista(String nomTema, String nomAlbum) throws ListaInexistenteException,
            ClienteInexistenteException {
        if (nickMem.equals("")) { //listaron las por defecto
            buscarLista(nomListaMem).quitarTema(nomTema,nomAlbum);
        } else {
            new CtrlUsuarios().quitarTemaDeLista(nickMem,nomListaMem,nomTema,nomAlbum);
        }
    }
    
    @Override
    public void altaListaParticular(DataParticular dParticular) throws ListaRepetidaException, ClienteInexistenteException {
        new CtrlUsuarios().altaLista(dParticular);
    }
    
    @Override
    public void altaListaDefecto(DataDefecto dLista) throws ListaRepetidaException, GeneroInexistenteException {
        if (validarNombreListaDefecto(dLista.getNombre())) {
            Genero genero = new CtrlMusica().buscarGenero(dLista.getGenero());
            ManejadorColecciones.getInstancia().agregarLista(dLista.getNombre(),
                    new Defecto(genero, dLista.getNombre(), dLista.getImg()));
        } else {
            throw new ListaRepetidaException();
        }
    }
    
    @Override
    public void agregarTemaLista(DataTema dtema, String lista)throws Exception {
        CtrlUsuarios ctrlU = new CtrlUsuarios();        
        if (dtema == null) {
            throw new Exception("No se selecciono un tema valido");
        }
        Tema tema = ctrlU.devolverTema(dtema);
        if (nickMem == null || nickMem.equals("")) {
            buscarLista(lista).agregarTema(tema);
        } else {
            ctrlU.agregarTemaLista(tema,nickMem, lista);
        }
    }
    
}
