package espotify.Datatypes;

import java.io.File;

public class DataTemaArchivo extends DataTema{
    private File archivo;

    public File getArchivo() {
        return archivo;
    }

    public DataTemaArchivo(File archivo, String nombre, int duracion, int num) {
        super(nombre, duracion, num);
        this.archivo = archivo;
    }
    
}