package espotify;

import espotify.Datatypes.DataDefecto;
import java.util.HashMap;

public class Genero {
    //attrs
    private String nombre;
    private final HashMap<String,Genero> subgeneros;
    private final HashMap<String,Album> albums;

    //getters
    public String getNombre() {
        return nombre;
    }
    //constructores
    public Genero()
    {
        this.subgeneros=new HashMap<>();
        this.albums=new HashMap<>();
    }

}
