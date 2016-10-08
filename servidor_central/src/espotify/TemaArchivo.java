package espotify;

import espotify.datatypes.DataTema;
import espotify.datatypes.DataTemaArchivo;
import java.io.BufferedInputStream;
import java.io.BufferedReader;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

class TemaArchivo extends Tema {
    private BufferedInputStream archivo;
    private ArrayList<Integer> fil;
    
    TemaArchivo(DataTemaArchivo dta, final Album album) {
        super(dta, album);
        this.archivo = dta.getArchivo();
    }

    @Override
    public DataTema getData() {
        DataTema root = super.getData();
        return new DataTemaArchivo(archivo, root.getNombre(), root.getDuracion(), root.getNum(),
                root.getNomArtista(), root.getAlbum()); 
    }  
        
    BufferedInputStream getAudio() {
        return archivo;
    }
}