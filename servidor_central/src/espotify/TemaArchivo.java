package espotify;

import espotify.datatypes.DataTema;
import espotify.datatypes.DataTemaArchivo;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;


class TemaArchivo extends Tema {
    private File file;
    
    TemaArchivo(DataTemaArchivo dta, final Album album) {
        super(dta, album);
        OutputStream out = null;
        try {
            InputStream in = dta.getArchivo();
            file = new File(ManejadorColecciones.getAudioFolder() + dta.getNomArtista()
                    + "|" + dta.getAlbum() + "|" + dta.getNombre() + ".mp3");
            out = new FileOutputStream(file);
            byte[] buffer = new byte[1024];
            int len = in.read(buffer);
            while (len != -1) {
                out.write(buffer, 0, len);
                len = in.read(buffer);
            }
            in.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TemaArchivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TemaArchivo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(TemaArchivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    @Override
    public DataTema getData() {
        DataTema root = super.getData();
        return new DataTemaArchivo(getAudio(), root.getNombre(), root.getDuracion(), root.getNum(),
                root.getNomArtista(), root.getAlbum()); 
    }  
        
    BufferedInputStream getAudio() {
        try {
            return new BufferedInputStream(new FileInputStream(file));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TemaArchivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}