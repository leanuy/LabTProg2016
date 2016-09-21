package espotify;

import espotify.datatypes.DataDefecto;
import espotify.datatypes.DataLista;
import java.awt.image.BufferedImage;


class Defecto extends Lista implements Favoriteable {
    private final Genero genero;

    Defecto(Genero genero, String nombre, BufferedImage img) {
        super(nombre, img);
        this.genero = genero;
    }
    
    String getNomGenero() {
        return genero.getNombre();
    }
    
    public DataDefecto getData() {
        return new DataDefecto(genero.getNombre(),nombre,img);
    }

}
