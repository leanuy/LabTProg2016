package espotify;

import espotify.Datatypes.DataTemaArchivo;
import java.io.File;

public class TemaArchivo extends Tema{
    private File archivo;

    public File getArchivo() {
        return archivo;
    }
    
    public TemaArchivo(DataTemaArchivo dta, Album album) {
        super(dta, album);
        this.archivo = dta.getArchivo();
    }
}
