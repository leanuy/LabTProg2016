package espotify;

import espotify.Datatypes.DataGenero;
import espotify.Interfaces.IAltaGenero;
import java.util.ArrayList;
import java.util.HashMap;

public class CtrlMusica implements IAltaGenero{

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
        this.generoBase=new Genero("Genero");
        this.generos=new HashMap<>();
        generos.put(generoBase.getNombre(), generoBase);
    }
    
    //otros métodos
    
    public ArrayList<String> ListarGeneros()
    {
        ArrayList<String> a = new ArrayList<>();
         generos.keySet().stream().forEach((key) -> {
             a.add(key);
         });
         return a;
    }
    
    public void AltaGenero(DataGenero d) throws Exception
    {
        if(!ExisteGenero(d.getNombre()))
        {
            if(d.getPadre().equals(""))
                d.setPadre("Genero");
            if(ExisteGenero(d.getPadre()))
            {
                Genero g = new Genero(d);
                generos.put(d.getNombre(), g);
                generos.get(d.getPadre()).AddHijo(g);
            }
            else
                throw new Exception("No existe el género padre");
        }
        else
            throw new Exception("Ya existe un género con ese nombre");
    }

    private boolean ExisteGenero(String nombre) {
        return generos.containsKey(nombre);
    }
    
    

    Genero BuscarGenero(String genero) {
        return generos.get(genero);
    }

}
