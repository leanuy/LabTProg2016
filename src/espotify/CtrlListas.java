package espotify;


import espotify.Datatypes.DataTema;
import espotify.Datatypes.DataDefecto;
import espotify.Datatypes.DataParticular;
import espotify.Interfaces.IAltaLista;
import java.util.ArrayList;
import java.util.HashMap;

public class CtrlListas implements IAltaLista{
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
    
    public void RemoverTemaLista(String nomTema)
    {
        
    }
    
    
    public ArrayList<String> ListarGeneros()
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
        Genero g = cm.BuscarGenero(d.getGenero());
        if(g!=null)
            listas.put(d.getNombre(), new Defecto(g, d.getNombre(), d.getImg()));
        else
            throw new Exception("No existe un género con ese nombre");
    }
    
}
