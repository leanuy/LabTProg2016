package espotify;

import espotify.Datatypes.DataTemaArchivo;

public class TemaArchivo extends Tema{
    private String archivo;

    public String getArchivo() {
        return archivo;
    }
    
    public TemaArchivo(DataTemaArchivo dta, Album album) {
        super(dta, album);
        this.archivo = dta.getArchivo();
    }
}
