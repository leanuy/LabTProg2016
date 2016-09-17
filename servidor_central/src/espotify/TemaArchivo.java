package espotify;

import espotify.datatypes.DataTema;
import espotify.datatypes.DataTemaArchivo;

import java.io.File;

class TemaArchivo extends Tema {
    private final File archivo;
    
    TemaArchivo(DataTemaArchivo dta, final Album album) {
        super(dta, album);
        this.archivo = dta.getArchivo();
    }

    @Override
    DataTema getData() {
        DataTema root = super.getData();
        return new DataTemaArchivo(archivo, root.getNombre(), root.getDuracion(), root.getNum(),
                root.getNomArtista(), root.getAlbum()); 
    }  
    
}
