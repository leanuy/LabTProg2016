package espotify;

import espotify.Datatypes.DataTema;
import espotify.Datatypes.DataDefecto;
import espotify.Datatypes.DataGenero;
import espotify.Datatypes.DataLista;
import espotify.Datatypes.DataParticular;
import espotify.Excepciones.ClienteInexistenteException;
import espotify.Excepciones.GeneroInexistenteException;
import espotify.Excepciones.ListaInexistenteException;
import espotify.Excepciones.ListaRepetidaException;
import espotify.Excepciones.YaPublicaException;
import espotify.Interfaces.IAltaLista;
import espotify.Interfaces.IConsultaLista;
import espotify.Interfaces.IPublicarLista;
import espotify.Interfaces.IAgregarTemaLista;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CtrlListas implements IAltaLista, IPublicarLista, IConsultaLista, IAgregarTemaLista{
    private static CtrlListas instancia;
    private String nickMEM;
    private String nomListaMEM;
    private final HashMap<String,Defecto> listas;
    private ArrayList<Tema> temasLista;
    
    public static CtrlListas getInstancia()
    {
        if(instancia==null)
            instancia=new CtrlListas();
        return instancia;
    }
    
    //constructores
    private CtrlListas()
    {
        this.listas=new HashMap<>();
    }
    

    public void PublicarLista(String nomLista, String nick) throws ClienteInexistenteException, ListaInexistenteException, YaPublicaException
    {
        CtrlUsuarios cu = CtrlUsuarios.getInstancia();
        cu.PublicarLista(nomLista,nick);
    }
    
    public ArrayList<String> ListarClientes()
    {
        CtrlUsuarios cu = CtrlUsuarios.getInstancia();
        return cu.ListarClientes();
    }
    public ArrayList<String> ListarArtistas()
    {
        CtrlUsuarios cu = CtrlUsuarios.getInstancia();
        return cu.ListarArtistas();
    }
    public ArrayList<String> ListarListasDeCliente(String nick) throws ClienteInexistenteException
    {
        nickMEM=nick;
        CtrlUsuarios cu = CtrlUsuarios.getInstancia();
        return cu.ListarListasDeCliente(nick);
    }
    public ArrayList<String> ListarListasPrivadasDeCliente(String nick) throws ClienteInexistenteException
    {
        CtrlUsuarios cu = CtrlUsuarios.getInstancia();
        return cu.ListarListasPrivadasDeCliente(nick);
    }
    
    public ArrayList<String> ListarListasPubliasDeCliente(String nick) throws Exception
    {
        CtrlUsuarios cu = CtrlUsuarios.getInstancia();
        return cu.ListarListasPublicasDeCliente(nick);
    }
    
    @Override
    public ArrayList<String> ListarListasDefecto()
    {
        nickMEM="";
        ArrayList a = new ArrayList();
        listas.keySet().stream().forEach((key) -> {
            a.add(key);
        });
        return a;
    }
    
    public ArrayList<DataTema> ListarTemasLista(String nombre) throws ClienteInexistenteException, ListaInexistenteException
    {
        nomListaMEM =nombre;
        if(nickMEM.equals("")) //listaron las por defecto
        {
            Lista l = listas.get(nombre);
            return l.ListarTemas();
        }
        else
        {
            CtrlUsuarios cu = CtrlUsuarios.getInstancia();
            return cu.ListarTemasDeLista(nickMEM,nombre);
        }
    }
    

    @Override
    public ArrayList<String> ListarTemasLista2(String cl, String l) throws Exception  // Yo no paso x la funcion que guarda el nick!
    {
        if(cl==null){
            Lista lis = listas.get(l);
            temasLista = lis.DevolverTemas();
        }else{
            CtrlUsuarios cu = CtrlUsuarios.getInstancia();
            temasLista = cu.ListarTemasDeLista2(cl, l);
        }
        ArrayList a = new ArrayList();
        for(Tema t : temasLista) {
            a.add(t.getNombre());
        }
        return a;
    }
    
    public void RemoverTemaLista(String nomTema, String nomAlbum) throws ListaInexistenteException, ClienteInexistenteException
    {
        if(nickMEM.equals("")) //listaron las por defecto
        {
            listas.get(nomListaMEM).QuitarTema(nomTema,nomAlbum);
        }
        else
        {
            CtrlUsuarios cu = CtrlUsuarios.getInstancia();
            cu.QuitarTemaDeLista(nickMEM,nomListaMEM,nomTema,nomAlbum);
        }
    }
    
    
    public DataGenero ListarGeneros()
    {
        CtrlMusica cm = CtrlMusica.getInstancia();
        return cm.ListarGeneros();
    }
    
    public void AltaListaParticular(DataParticular d) throws ListaRepetidaException, ClienteInexistenteException
    {
        CtrlUsuarios cu = CtrlUsuarios.getInstancia();
        cu.AltaLista(d);
    }
    
    public void AltaListaDefecto(DataDefecto d) throws ListaRepetidaException, GeneroInexistenteException
    {
        CtrlMusica cm = CtrlMusica.getInstancia();
        if(ValidarNombreListaDefecto(d.getNombre()))
        {
            Genero g = cm.BuscarGenero(d.getGenero());
            listas.put(d.getNombre(), new Defecto(g, d.getNombre(), d.getImg()));
        }
        else
            throw new ListaRepetidaException();
    }

    private boolean ValidarNombreListaDefecto(String d) {
        return !d.equals("") && !listas.containsKey(d);
    }

    public ArrayList<String> ListarListasDeGenero(String nomGenero) {
        ArrayList<String> a = new ArrayList();
        for(Map.Entry<String, Defecto> entry : listas.entrySet()) {
            Defecto d = entry.getValue();
            if(d.getNomGenero().equals(nomGenero))
                a.add(d.getNombre());
        }
        return a;
    }
    
    public DataLista DarInfoDefecto(String nomLista) throws ListaInexistenteException
    {
        return BuscarLista(nomLista).getData();
    }
    
    public DataLista DarInfoParticular(String nomLista, String nick) throws ClienteInexistenteException, ListaInexistenteException
    {
        CtrlUsuarios cu = CtrlUsuarios.getInstancia();
        return cu.DarInfoLista(nomLista, nick);
    }
    
    public Defecto BuscarLista(String nomLista) throws ListaInexistenteException
    {
        Defecto d = listas.get(nomLista);
        if(d==null)
            throw new ListaInexistenteException();
        return d;
    }

    public ArrayList<String> ListarAlbumesDeArtista(String na) throws Exception
    {
        CtrlUsuarios cu = CtrlUsuarios.getInstancia();
        return cu.ListarAlbumesDeArtista(na);
    }
    
    public ArrayList<String> ListarTemasAlbum(String art, String alb) throws Exception
    {
        CtrlUsuarios cu = CtrlUsuarios.getInstancia();
        temasLista = cu.ListarTemasAlbum(art, alb);
        ArrayList<String> nombreTemas = new ArrayList();
        String nombre;
        for(Tema t : temasLista){
            nombre = t.getNombre();
            nombreTemas.add(nombre);
        }
        return nombreTemas;
    }
    
    
    public void AgregarTemaLista(String tema, String lista)throws Exception{
        CtrlUsuarios cu = CtrlUsuarios.getInstancia();
        Tema dt = null;
        String nombre;
        for(Tema dt2 : temasLista){
            nombre = dt2.getNombre();
            if (nombre == null ? tema == null : nombre.equals(tema)){
                dt = dt2;
            }
        }
        if (dt == null){
            throw new Exception("El tema no se encuentra en los temas almacenados");
        }
        if(nickMEM.equals("")){
            if(lista == null){
                throw new Exception("No existe esa lista");
            }
            Lista l = listas.get(lista);
            l.AgregarTema(dt);
        }else{
            cu.AgregarTemaLista(dt,nickMEM, lista);
        }
    }
    
}
