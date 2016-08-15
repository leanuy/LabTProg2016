package espotify;

import java.util.HashMap;

public class CtrlListas {
    private CtrlListas instancia;
    private final HashMap<String,Defecto> listas;
    
    public CtrlListas getInstancia()
    {
        if(instancia==null)
            instancia=new CtrlListas();
        return instancia;
    }
    
    //constructores
    public CtrlListas()
    {
        this.listas=new HashMap<>();
    }
}
