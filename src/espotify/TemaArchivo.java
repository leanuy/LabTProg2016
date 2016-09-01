package espotify;

import espotify.Datatypes.DataTemaArchivo;
import java.io.File;

class TemaArchivo extends Tema{
    private File archivo;
    
    TemaArchivo(DataTemaArchivo dta, Album album) {
        super(dta, album);
        this.archivo = dta.getArchivo();
    }
}
