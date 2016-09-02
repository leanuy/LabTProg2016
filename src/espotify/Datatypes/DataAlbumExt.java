package espotify.Datatypes;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Objects;

public class DataAlbumExt extends DataAlbum{
    private final ArrayList<DataTema> temas;
    
    public ArrayList<DataTema> getTemas() {
        return this.temas;
    }
    
    public DataAlbumExt(ArrayList<DataTema> temas, String nombre, int anio, ArrayList<String> generos, BufferedImage img, String nickArtista) {
        super(nombre, anio, generos, img, nickArtista);
        this.temas = temas;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DataAlbumExt other = (DataAlbumExt) obj;
        if (this.anio != other.anio) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.nickArtista, other.nickArtista)) {
            return false;
        }
        if (!Objects.equals(this.generos, other.generos)) {
            return false;
        }
        if (!Objects.equals(this.img, other.img)) {
            return false;
        }
        if (!Objects.equals(this.temas, other.temas)) {
            return false;
        }
        return true;
    }
    
    
}
