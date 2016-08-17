package espotify;

import espotify.Datatypes.DataDefecto;
import espotify.Datatypes.DataLista;


public class Defecto extends Lista implements Favoriteable{
    private Genero genero;

    public Defecto(Genero genero, String nombre, String img) {
        super(nombre, img);
        this.genero = genero;
    }
    public Defecto(DataDefecto d, Genero g) {
        super(d);
        genero=g;
    }
    
}
