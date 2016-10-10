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
    public boolean tieneTema(String tema) {
        return temas.stream().anyMatch((t) -> (t.getNombre().equals(tema)));
    }
    public void addTema(DataTema tema){
        this.temas.add(tema);
    }
    
    public void addTema(DataTema tema){
        this.temas.add(tema);
    }
    
    public DataAlbumExt(List<DataTema> temas, String nombre, int anio, List<String> generos,
            BufferedImage img, String nickArtista) {
        super(nombre, anio, generos, img, nickArtista);
        this.temas = temas;
    }
    public DataAlbumExt(String nombre, int anio, List<String> generos,
            BufferedImage img, String nickArtista) {
        super(nombre, anio, generos, img, nickArtista);
        this.temas = new ArrayList<>();
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
        if (this.getAnio() != other.getAnio()) {
            return false;
        }
        if (!Objects.equals(this.getNombre(), other.getNombre())) {
            return false;
        }
        if (!Objects.equals(this.getNickArtista(), other.getNickArtista())) {
            return false;
        }
        if (!Objects.equals(this.getGeneros(), other.getGeneros())) {
            return false;
        }
        if (!Objects.equals(this.getImg(), other.getImg())) {
            return false;
        }
        return Objects.equals(this.temas, other.temas);
    }
    
    
}
