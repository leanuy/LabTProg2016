package espotify.datatypes;

import java.io.File;


public class DataDefecto extends DataLista {
    private final String genero;

    public String getGenero() {
        return genero;
    }

    public DataDefecto(String genero, String nombre, File img) {
        super(nombre, img);
        this.genero = genero;
    }
    
}
