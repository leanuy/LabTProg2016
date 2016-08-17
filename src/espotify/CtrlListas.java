package espotify;

import espotify.Datatypes.DataTema;
import espotify.Datatypes.DataDefecto;
import espotify.Datatypes.DataGenero;
import espotify.Datatypes.DataLista;
import espotify.Datatypes.DataParticular;
import espotify.Interfaces.IAltaLista;
import espotify.Interfaces.IConsultaLista;
import espotify.Interfaces.IPublicarLista;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CtrlListas implements IAltaLista, IPublicarLista, IConsultaLista{
    private static CtrlListas instancia;
    private String nickMEM;
    private String nomListaMEM;
    private final HashMap<String,Defecto> listas;
    
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
    

    public void PublicarLista(String nomLista, String nick) throws Exception
    {
        CtrlUsuarios cu = CtrlUsuarios.getInstancia();
        cu.PublicarLista(nomLista,nick);
    }
    
    public ArrayList<String> ListarClientes()
    {
        CtrlUsuarios cu = CtrlUsuarios.getInstancia();
        return cu.ListarClientes();
    }
    public ArrayList<String> ListarListasDeCliente(String nick) throws Exception
    {
        nickMEM=nick;
        CtrlUsuarios cu = CtrlUsuarios.getInstancia();
        return cu.ListarListasDeCliente(nick);
    }
    public ArrayList<String> ListarListasPrivadasDeCliente(String nick) throws Exception
    {
        CtrlUsuarios cu = CtrlUsuarios.getInstancia();
        return cu.ListarListasPrivadasDeCliente(nick);
    }
    
    public ArrayList<String> ListarListasDefecto()
    {
        nickMEM="";
        ArrayList a = new ArrayList();
        listas.keySet().stream().forEach((key) -> {
            a.add(key);
        });
        return a;
    }
    
    public ArrayList<DataTema> ListarTemasLista(String nombre) throws Exception
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
    
    public void RemoverTemaLista(String nomTema, String nomAlbum) throws Exception
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
    
    public void AltaListaParticular(DataParticular d) throws Exception
    {
        CtrlUsuarios cu = CtrlUsuarios.getInstancia();
        cu.AltaLista(d);
    }
    
    public void AltaListaDefecto(DataDefecto d) throws Exception
    {
        CtrlMusica cm = CtrlMusica.getInstancia();
        if(ValidarNombreListaDefecto(d.getNombre()))
        {
            Genero g = cm.BuscarGenero(d.getGenero());
            listas.put(d.getNombre(), new Defecto(g, d.getNombre(), d.getImg()));
        }
        else
            throw new Exception("El nombre de la lista es vacío o está repetido");
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
    
    public DataLista DarInfoDefecto(String nomLista) throws Exception
    {
        Defecto d = listas.get(nomLista);
        if(d==null)
            throw new Exception("No hay una lista con ese nombre");
        return d.getData();
    }
    
    public DataLista DarInfoParticular(String nomLista, String nick) throws Exception
    {
        CtrlUsuarios cu = CtrlUsuarios.getInstancia();
        return cu.DarInfoLista(nomLista, nick);
    }
    
}
