package espotify;

import espotify.Datatypes.DataDefecto;
import espotify.Datatypes.DataLista;
import java.awt.image.BufferedImage;


class Defecto extends Lista implements Favoriteable{
    private Genero genero;

    Defecto(Genero genero, String nombre, BufferedImage img) {
        super(nombre, img);
        this.genero = genero;
    }
    
    String getNomGenero()
    {
        return genero.getNombre();
    }

}
