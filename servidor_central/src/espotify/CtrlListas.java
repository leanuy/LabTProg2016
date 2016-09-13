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
import java.util.Map;

public class CtrlListas implements IAltaLista, IPublicarLista,
        IConsultaLista, IAgregarTemaLista, IQuitarTemaLista {
    private static CtrlListas instancia;
    private String nickMem;
    private String nomListaMem;
    private ArrayList<DataTema> temasLista;
    
//Constructor
    public CtrlListas() {
    }
//Acceso al Manejador
    Defecto BuscarLista(String nomLista) throws ListaInexistenteException {
        Defecto def = ManejadorColecciones.getInstancia().BuscarLista(nomLista);
        if (def == null) {
            throw new ListaInexistenteException();
        }
        return def;
    }
    
    private static HashMap<String, Defecto> GetListas() {
        return ManejadorColecciones.getInstancia().getListas();
    }
//Listas
    @Override
    public ArrayList<String> ListarClientes() {
        CtrlUsuarios cu = new CtrlUsuarios();
        return cu.ListarClientes();
    }
    
    @Override
    public ArrayList<String> ListarArtistas() {
        CtrlUsuarios cu = new CtrlUsuarios();
        return cu.ListarArtistas();
    }
    
    @Override
    public ArrayList<String> ListarListasDeCliente(String nick) throws ClienteInexistenteException {
        nickMem=nick;
        CtrlUsuarios cu = new CtrlUsuarios();
        return cu.ListarListasDeCliente(nick);
    }
    
    @Override
    public ArrayList<String> ListarListasPrivadasDeCliente(String nick) throws ClienteInexistenteException {
        CtrlUsuarios cu = new CtrlUsuarios();
        return cu.ListarListasPrivadasDeCliente(nick);
    }
    
    @Override
    public ArrayList<String> ListarListasPublicasDeCliente(String nick) throws ClienteInexistenteException {
        CtrlUsuarios cu = new CtrlUsuarios();
        return cu.ListarListasPublicasDeCliente(nick);
    }
    
    @Override
    public ArrayList<String> ListarListasDefecto() {
        nickMem="";
        ArrayList salida = new ArrayList();
        GetListas().keySet().stream().forEach((key) -> {
            salida.add(key);
        });
        return salida;
    }
    
    @Override
    public ArrayList<String> ListarListasDefecto2() {
        ArrayList salida = new ArrayList();
        GetListas().keySet().stream().forEach((key) -> {
            salida.add(key);
        });
        return salida;
    }
    
    @Override
    public ArrayList<DataTema> ListarTemasLista(String nombre) throws ClienteInexistenteException, ListaInexistenteException {
        nomListaMem = nombre;
        if (nickMem.equals("")) /*listaron las por defecto*/ {
            return BuscarLista(nombre).ListarTemas();
        } else {
            return new CtrlUsuarios().ListarTemasDeLista(nickMem,nombre);
        }
    }
    
    @Override
    public ArrayList<DataTema> ListarTemasLista2(String cliente, String nomLista) throws Exception {
        if (cliente == null) {
            temasLista = BuscarLista(nomLista).ListarTemas();
        } else {
            temasLista = new CtrlUsuarios().ListarTemasDeLista(cliente, nomLista);
        }
        return temasLista;
    }
    
    @Override
    public DataGenero ListarGeneros() {
        CtrlMusica cm = new CtrlMusica();
        return cm.ListarGeneros();
    }
    
    @Override
    public ArrayList<String> ListarListasDeGenero(String nomGenero) {
        ArrayList<String> salida = new ArrayList();
        for (Map.Entry<String, Defecto> entry : GetListas().entrySet()) {
            Defecto def = entry.getValue();
            if (def.getNomGenero().equals(nomGenero)) {
                salida.add(def.getNombre());
            }
        }
        return salida;
    }
    
    @Override
    public ArrayList<String> ListarAlbumesDeArtista(String na) throws ArtistaInexistenteException {
        return new CtrlUsuarios().ListarAlbumesDeArtista(na);
    }
    
    @Override
    public ArrayList<DataTema> ListarTemasAlbum(String art, String alb) throws
            ArtistaInexistenteException, AlbumInexistenteException {
        return new CtrlUsuarios().ListarTemasAlbum(art, alb);
    }
    
//Consultas
    @Override
    public DataLista DarInfoDefecto(String nomLista) throws ListaInexistenteException {
        return BuscarLista(nomLista).getData();
    }
    
    @Override
    public DataLista DarInfoParticular(String nomLista, String nick) throws
            ClienteInexistenteException, ListaInexistenteException {
        CtrlUsuarios cu = new CtrlUsuarios();
        return cu.DarInfoLista(nomLista, nick);
    }
    
    private boolean ValidarNombreListaDefecto(String nomLista) {
        return !nomLista.equals("") && !GetListas().containsKey(nomLista);
    }
    
//Operaciones
    @Override
    public void PublicarLista(String nomLista, String nick) throws ClienteInexistenteException,
            ListaInexistenteException, YaPublicaException {
        CtrlUsuarios cu = new CtrlUsuarios();
        cu.PublicarLista(nomLista,nick);
    }
    
    @Override
    public void RemoverTemaLista(String nomTema, String nomAlbum) throws ListaInexistenteException,
            ClienteInexistenteException {
        if (nickMem.equals("")) { //listaron las por defecto
            BuscarLista(nomListaMem).QuitarTema(nomTema,nomAlbum);
        } else {
            new CtrlUsuarios().QuitarTemaDeLista(nickMem,nomListaMem,nomTema,nomAlbum);
        }
    }
    
    @Override
    public void AltaListaParticular(DataParticular d) throws ListaRepetidaException, ClienteInexistenteException {
        new CtrlUsuarios().AltaLista(d);
    }
    
    @Override
    public void AltaListaDefecto(DataDefecto d) throws ListaRepetidaException, GeneroInexistenteException {
        CtrlMusica cm = new CtrlMusica();
        if (ValidarNombreListaDefecto(d.getNombre())) {
            Genero genero = cm.BuscarGenero(d.getGenero());
            ManejadorColecciones.getInstancia().AgregarLista(d.getNombre(),
                    new Defecto(genero, d.getNombre(), d.getImg()));
        } else {
            throw new ListaRepetidaException();
        }
    }
    
    @Override
    public void AgregarTemaLista(DataTema dtema, String lista)throws Exception{
        CtrlUsuarios cu = new CtrlUsuarios();        
        if (dtema == null) {
            throw new Exception("No se selecciono un tema valido");
        }
        Tema tema = cu.DevolverTema(dtema);
        if (nickMem == null || nickMem.equals("")) {
            /*if (lista == null) {
                throw new ListaInexistenteException("No existe esa lista");
            }*/
            BuscarLista(lista).AgregarTema(tema);
        } else {
            cu.AgregarTemaLista(tema,nickMem, lista);
        }
    }
    
}
