package espotify.datatypes;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DataAlbumExt extends DataAlbum {
    private final List<DataTema> temas;
    
    public List<DataTema> getTemas() {
        return this.temas;
    }
    
    public DataAlbumExt(List<DataTema> temas, String nombre, int anio, List<String> generos,
            BufferedImage img, String nickArtista) {
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
        return Objects.equals(this.temas, other.temas);
    }
    
    
}
