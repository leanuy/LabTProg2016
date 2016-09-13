package espotify.Datatypes;

import java.io.File;

public class DataTemaArchivo extends DataTema {
    private final File archivo;

    public File getArchivo() {
        return archivo;
    }

    public DataTemaArchivo(File archivo, String nombre, int duracion,
            int num, String artista, String album) {
        super(nombre, duracion, num, artista, album);
        this.archivo = archivo;
    }
    
}