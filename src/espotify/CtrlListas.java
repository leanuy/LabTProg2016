package espotify;

import espotify.Datatypes.DataTema;
import espotify.Datatypes.DataDefecto;
import espotify.Datatypes.DataGenero;
import espotify.Datatypes.DataLista;
import espotify.Datatypes.DataParticular;
import espotify.Excepciones.AlbumInexistenteException;
import espotify.Excepciones.ArtistaInexistenteException;
import espotify.Excepciones.ClienteInexistenteException;
import espotify.Excepciones.GeneroInexistenteException;
import espotify.Excepciones.ListaInexistenteException;
import espotify.Excepciones.ListaRepetidaException;
import espotify.Excepciones.YaPublicaException;
import espotify.Interfaces.IAltaLista;
import espotify.Interfaces.IConsultaLista;
import espotify.Interfaces.IPublicarLista;
import espotify.Interfaces.IAgregarTemaLista;
import espotify.Interfaces.IQuitarTemaLista;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CtrlListas implements IAltaLista, IPublicarLista, IConsultaLista, IAgregarTemaLista, IQuitarTemaLista{
    private static CtrlListas instancia;
    private String nickMEM;
    private String nomListaMEM;
    private ArrayList<DataTema> temasLista;
    
//Constructor
    public CtrlListas()
    {
    }
//Acceso al Manejador
    Defecto BuscarLista(String nomLista) throws ListaInexistenteException {
        Defecto d = ManejadorColecciones.getInstancia().BuscarLista(nomLista);
        if(d==null)
            throw new ListaInexistenteException();
        return d;
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
    public ArrayList<String> ListarListasDeCliente(String nick) throws ClienteInexistenteException
    {
        nickMEM=nick;
        CtrlUsuarios cu = new CtrlUsuarios();
        return cu.ListarListasDeCliente(nick);
    }
    @Override
    public ArrayList<String> ListarListasPrivadasDeCliente(String nick) throws ClienteInexistenteException
    {
        CtrlUsuarios cu = new CtrlUsuarios();
        return cu.ListarListasPrivadasDeCliente(nick);
    }
    @Override
    public ArrayList<String> ListarListasPubliasDeCliente(String nick) throws Exception
    {
        CtrlUsuarios cu = new CtrlUsuarios();
        return cu.ListarListasPublicasDeCliente(nick);
    }
    @Override
    public ArrayList<String> ListarListasDefecto() {
        nickMEM="";
        ArrayList a = new ArrayList();
        GetListas().keySet().stream().forEach((key) -> {
            a.add(key);
        });
        return a;
    }
    @Override
    public ArrayList<String> ListarListasDefecto2() {
        ArrayList a = new ArrayList();
        GetListas().keySet().stream().forEach((key) -> {
            a.add(key);
        });
        return a;
    }
    @Override
    public ArrayList<DataTema> ListarTemasLista(String nombre) throws ClienteInexistenteException, ListaInexistenteException
    {
        nomListaMEM =nombre;
        if(nickMEM.equals("")) //listaron las por defecto
        {
            Lista l = BuscarLista(nombre);
            return l.ListarTemas();
        }
        else
        {
            CtrlUsuarios cu = new CtrlUsuarios();
            return cu.ListarTemasDeLista(nickMEM,nombre);
        }
    }
    @Override
    public ArrayList<DataTema> ListarTemasLista2(String cl, String l) throws Exception {
        if(cl==null){
            Lista lis = BuscarLista(l);
            temasLista = lis.ListarTemas();
        }else{
            CtrlUsuarios cu = new CtrlUsuarios();
            temasLista = cu.ListarTemasDeLista(cl, l);
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
        ArrayList<String> a = new ArrayList();
        for(Map.Entry<String, Defecto> entry : GetListas().entrySet()) {
            Defecto d = entry.getValue();
            if(d.getNomGenero().equals(nomGenero))
                a.add(d.getNombre());
        }
        return a;
    }
    @Override
    public ArrayList<String> ListarAlbumesDeArtista(String na) throws Exception {
        CtrlUsuarios cu = new CtrlUsuarios();
        return cu.ListarAlbumesDeArtista(na);
    }
    @Override
    public ArrayList<DataTema> ListarTemasAlbum(String art, String alb) throws ArtistaInexistenteException, AlbumInexistenteException {
        CtrlUsuarios cu = new CtrlUsuarios();
        return cu.ListarTemasAlbum(art, alb);
    }
    
//Consultas
    @Override
    public DataLista DarInfoDefecto(String nomLista) throws ListaInexistenteException {
        return BuscarLista(nomLista).getData();
    }
    @Override
    public DataLista DarInfoParticular(String nomLista, String nick) throws ClienteInexistenteException, ListaInexistenteException {
        CtrlUsuarios cu = new CtrlUsuarios();
        return cu.DarInfoLista(nomLista, nick);
    }
    private boolean ValidarNombreListaDefecto(String d) {
        return !d.equals("") && !GetListas().containsKey(d);
    }
    
//Operaciones
    @Override
    public void PublicarLista(String nomLista, String nick) throws ClienteInexistenteException, ListaInexistenteException, YaPublicaException {
        CtrlUsuarios cu = new CtrlUsuarios();
        cu.PublicarLista(nomLista,nick);
    }
    @Override
    public void RemoverTemaLista(String nomTema, String nomAlbum) throws ListaInexistenteException, ClienteInexistenteException {
        if(nickMEM.equals("")) //listaron las por defecto
            BuscarLista(nomListaMEM).QuitarTema(nomTema,nomAlbum);
        else
        {
            CtrlUsuarios cu = new CtrlUsuarios();
            cu.QuitarTemaDeLista(nickMEM,nomListaMEM,nomTema,nomAlbum);
        }
    }
    @Override
    public void AltaListaParticular(DataParticular d) throws ListaRepetidaException, ClienteInexistenteException {
        CtrlUsuarios cu = new CtrlUsuarios();
        cu.AltaLista(d);
    }
    @Override
    public void AltaListaDefecto(DataDefecto d) throws ListaRepetidaException, GeneroInexistenteException {
        CtrlMusica cm = new CtrlMusica();
        if(ValidarNombreListaDefecto(d.getNombre()))
        {
            Genero g = cm.BuscarGenero(d.getGenero());
            ManejadorColecciones.getInstancia().AgregarLista(d.getNombre(), new Defecto(g, d.getNombre(), d.getImg()));
        }
        else
            throw new ListaRepetidaException();
    }
    @Override
    public void AgregarTemaLista(DataTema dtema, String lista)throws Exception{
        CtrlUsuarios cu = new CtrlUsuarios();        
        if(dtema==null){
            throw new Exception("No se selecciono un tema valido");
        }
        Tema t = cu.DevolverTema(dtema);
        if(nickMEM.equals("")){
            if(lista == null){
                throw new Exception("No existe esa lista");
            }
            Lista l = BuscarLista(lista);
            l.AgregarTema(t);
        }else{
            cu.AgregarTemaLista(t,nickMEM, lista);
        }
    }
    
}
