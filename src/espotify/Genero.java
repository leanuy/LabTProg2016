package espotify;

import espotify.Datatypes.DataGenero;
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
    public Genero(String nombre)
    {
        this.nombre = nombre;
        this.subgeneros=new HashMap<>();
        this.albums=new HashMap<>();
    }
    public Genero(DataGenero d)
    {
        this(d.getNombre());
    }

    void AddHijo(Genero g) {
        subgeneros.put(g.getNombre(), g);
    }

}
