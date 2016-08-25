package espotify;

import espotify.Datatypes.DataDefecto;
import espotify.Datatypes.DataLista;
import java.awt.image.BufferedImage;


public class Defecto extends Lista implements Favoriteable{
    private Genero genero;

    public Defecto(Genero genero, String nombre, BufferedImage img) {
        super(nombre, img);
        this.genero = genero;
    }
    public Defecto(DataDefecto d, Genero g) {
        super(d);
        genero=g;
    }
    
    public String getNomGenero()
    {
        return genero.getNombre();
    }

}
