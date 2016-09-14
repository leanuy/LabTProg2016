package espotify;

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

}
