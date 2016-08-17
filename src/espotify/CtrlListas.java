package espotify;

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
}
