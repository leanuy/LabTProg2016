package espotify.datatypes;

import java.io.BufferedInputStream;

public class DataTemaArchivo extends DataTema {
    private final BufferedInputStream archivo;

    public BufferedInputStream getArchivo() {
        return archivo;
    }

    public DataTemaArchivo(BufferedInputStream buf, String nombre, int duracion,
            int num, String artista, String album) {
        super(nombre, duracion, num, artista, album, false);
        this.archivo = buf;
    }
        
}