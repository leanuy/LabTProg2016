package espotify;

import espotify.Datatypes.DataDefecto;
import espotify.Datatypes.DataParticular;
import java.util.ArrayList;
import java.util.HashMap;

public class CtrlListas {
    private static CtrlListas instancia;
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
    //otros métodos
    
    public ArrayList<String> ListarClientes()
    {
        CtrlUsuarios cu = CtrlUsuarios.getInstancia();
        return cu.ListarClientes();
    }
    
    public ArrayList<Stirng> ListarGeneros()
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
