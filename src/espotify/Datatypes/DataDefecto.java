package espotify.Datatypes;

import java.awt.image.BufferedImage;

public class DataDefecto extends DataLista {
    private String genero;

    public String getGenero() {
        return genero;
    }

    public DataDefecto(String genero, String nombre, BufferedImage img) {
        super(nombre, img);
        this.genero = genero;
    }
    
}
