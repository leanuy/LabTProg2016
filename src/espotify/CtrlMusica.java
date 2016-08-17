package espotify;

import espotify.Datatypes.DataDefecto;
import java.util.ArrayList;
import java.util.HashMap;

public class CtrlMusica {
    private static CtrlMusica instancia;
    private final HashMap<String,Genero> generos;
    private final Genero generoBase;
    //getters
    public static CtrlMusica getInstancia()
    {
        if(instancia==null)
            instancia=new CtrlMusica();
        return instancia;
    }
    //constructor
    private CtrlMusica()
    {
        this.generoBase=new Genero(); //!!!parámetros
        this.generos=new HashMap<>();
    }

    ArrayList<Genero> ListarGeneros() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Genero BuscarGenero(String genero) {
        return generos.get(genero);
    }


}
