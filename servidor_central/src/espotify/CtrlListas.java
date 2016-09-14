package espotify;

import espotify.Datatypes.DataDefecto;
import espotify.Datatypes.DataGenero;
import espotify.Datatypes.DataLista;
import espotify.Datatypes.DataParticular;
import espotify.Datatypes.DataTema;
import espotify.Excepciones.AlbumInexistenteException;
import espotify.Excepciones.ArtistaInexistenteException;
import espotify.Excepciones.ClienteInexistenteException;
import espotify.Excepciones.GeneroInexistenteException;
import espotify.Excepciones.ListaInexistenteException;
import espotify.Excepciones.ListaRepetidaException;
import espotify.Excepciones.YaPublicaException;
import espotify.Interfaces.IAgregarTemaLista;
import espotify.Interfaces.IAltaLista;
import espotify.Interfaces.IConsultaLista;
import espotify.Interfaces.IPublicarLista;
import espotify.Interfaces.IQuitarTemaLista;

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
    Defecto BuscarLista(String nomLista) throws ListaInexistenteException {
        Defecto def = ManejadorColecciones.getInstancia().buscarLista(nomLista);
        if (def == null) {
            throw new ListaInexistenteException();
        }
        return def;
    }
    
    private static Map<String, Defecto> GetListas() {
        return ManejadorColecciones.getInstancia().getListas();
    }
//Listas
    @Override
    public List<String> ListarClientes() {
        return new CtrlUsuarios().ListarClientes();
    }
    
    @Override
    public List<String> ListarArtistas() {
        return new CtrlUsuarios().listarArtistas();
    }
    
    @Override
    public List<String> ListarListasDeCliente(String nick) throws ClienteInexistenteException {
        nickMem = nick;
        return new CtrlUsuarios().ListarListasDeCliente(nick);
    }
    
    @Override
    public List<String> ListarListasPrivadasDeCliente(String nick) throws ClienteInexistenteException {
        return new CtrlUsuarios().listarListasPrivadasDeCliente(nick);
    }
    
    @Override
    public List<String> ListarListasPublicasDeCliente(String nick) throws ClienteInexistenteException {
        return  new CtrlUsuarios().listarListasPublicasDeCliente(nick);
    }
    
    @Override
    public List<String> ListarListasDefecto() {
        nickMem = "";
        List salida = new ArrayList();
        GetListas().keySet().stream().forEach((key) -> {
            salida.add(key);
        });
        return salida;
    }
    
    @Override
    public List<String> ListarListasDefecto2() {
        List salida = new ArrayList();
        GetListas().keySet().stream().forEach((key) -> {
            salida.add(key);
        });
        return salida;
    }
    
    @Override
    public List<DataTema> ListarTemasLista(String nombre) throws ClienteInexistenteException, ListaInexistenteException {
        nomListaMem = nombre;
        if (nickMem.equals("")) /*listaron las por defecto*/ {
            return BuscarLista(nombre).listarTemas();
        } else {
            return new CtrlUsuarios().listarTemasDeLista(nickMem,nombre);
        }
    }
    
    @Override
    public List<DataTema> ListarTemasLista2(String cliente, String nomLista) throws Exception {
        if (cliente == null) {
            temasLista = BuscarLista(nomLista).listarTemas();
        } else {
            temasLista = new CtrlUsuarios().listarTemasDeLista(cliente, nomLista);
        }
        return temasLista;
    }
    
    @Override
    public DataGenero ListarGeneros() {
        return new CtrlMusica().ListarGeneros();
    }
    
    @Override
    public List<String> ListarListasDeGenero(String nomGenero) {
        List<String> salida = new ArrayList();
        for (Map.Entry<String, Defecto> entry : GetListas().entrySet()) {
            Defecto def = entry.getValue();
            if (def.getNomGenero().equals(nomGenero)) {
                salida.add(def.getNombre());
            }
        }
        return salida;
    }
    
    @Override
    public List<String> ListarAlbumesDeArtista(String nick) throws ArtistaInexistenteException {
        return new CtrlUsuarios().listarAlbumesDeArtista(nick);
    }
    
    @Override
    public List<DataTema> ListarTemasAlbum(String art, String alb) throws
            ArtistaInexistenteException, AlbumInexistenteException {
        return new CtrlUsuarios().listarTemasAlbum(art, alb);
    }
    
//Consultas
    @Override
    public DataLista DarInfoDefecto(String nomLista) throws ListaInexistenteException {
        return BuscarLista(nomLista).getData();
    }
    
    @Override
    public DataLista DarInfoParticular(String nomLista, String nick) throws
            ClienteInexistenteException, ListaInexistenteException {
        return new CtrlUsuarios().darInfoLista(nomLista, nick);
    }
    
    private boolean ValidarNombreListaDefecto(String nomLista) {
        return !nomLista.equals("") && !GetListas().containsKey(nomLista);
    }
    
//Operaciones
    @Override
    public void PublicarLista(String nomLista, String nick) throws ClienteInexistenteException,
            ListaInexistenteException, YaPublicaException {
        new CtrlUsuarios().publicarLista(nomLista,nick);
    }
    
    @Override
    public void RemoverTemaLista(String nomTema, String nomAlbum) throws ListaInexistenteException,
            ClienteInexistenteException {
        if (nickMem.equals("")) { //listaron las por defecto
            BuscarLista(nomListaMem).quitarTema(nomTema,nomAlbum);
        } else {
            new CtrlUsuarios().quitarTemaDeLista(nickMem,nomListaMem,nomTema,nomAlbum);
        }
    }
    
    @Override
    public void AltaListaParticular(DataParticular dParticular) throws ListaRepetidaException, ClienteInexistenteException {
        new CtrlUsuarios().altaLista(dParticular);
    }
    
    @Override
    public void AltaListaDefecto(DataDefecto dLista) throws ListaRepetidaException, GeneroInexistenteException {
        if (ValidarNombreListaDefecto(dLista.getNombre())) {
            Genero genero = new CtrlMusica().BuscarGenero(dLista.getGenero());
            ManejadorColecciones.getInstancia().agregarLista(dLista.getNombre(),
                    new Defecto(genero, dLista.getNombre(), dLista.getImg()));
        } else {
            throw new ListaRepetidaException();
        }
    }
    
    @Override
    public void AgregarTemaLista(DataTema dtema, String lista)throws Exception {
        CtrlUsuarios ctrlU = new CtrlUsuarios();        
        if (dtema == null) {
            throw new Exception("No se selecciono un tema valido");
        }
        Tema tema = ctrlU.devolverTema(dtema);
        if (nickMem == null || nickMem.equals("")) {
            /*if (lista == null) {
                throw new ListaInexistenteException("No existe esa lista");
            }*/
            BuscarLista(lista).agregarTema(tema);
        } else {
            ctrlU.agregarTemaLista(tema,nickMem, lista);
        }
    }
    
}
