package espotify.datatypes;

import java.io.BufferedInputStream;

public class DataTemaArchivo extends DataTema {
    private BufferedInputStream archivo;

    public BufferedInputStream getArchivo() {
        return archivo;
    }

    public DataTemaArchivo() {
        super();
    }

    public void setArchivo(BufferedInputStream archivo) {
        this.archivo = archivo;
    }

    public DataTemaArchivo(BufferedInputStream buf, String nombre, int duracion,
            int num, String artista, String album) {
        super(nombre, duracion, num, artista, album, false);
        this.archivo = buf;
    }
        
}