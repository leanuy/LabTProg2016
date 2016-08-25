package espotify.Datatypes;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class DataAlbumExt extends DataAlbum{
    private final ArrayList<DataTema> temas;
    
    public ArrayList<DataTema> getTemas() {
        return this.temas;
    }
    
    public DataAlbumExt(ArrayList<DataTema> temas, String nombre, int anio, ArrayList<String> generos, BufferedImage img, String nickArtista) {
        super(nombre, anio, generos, img, nickArtista);
        this.temas = temas;
    }
}
