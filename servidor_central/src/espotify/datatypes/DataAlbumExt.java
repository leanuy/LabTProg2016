package espotify.datatypes;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataAlbumExt extends DataAlbum {
    private ArrayList<DataTema> temas;
    
    public ArrayList<DataTema> getTemas() {
        return this.temas;
    }
    public void setTemas(ArrayList<DataTema> temas){
        this .temas = temas;
    }
    public boolean tieneTema(String tema) {
        return temas.stream().anyMatch((dataTema) -> (dataTema.getNombre().equals(tema)));
    }

    public void addTema(DataTema tema) {
        this.temas.add(tema);
    }
    public void deleteTema(String tema) {
        DataTema data = null;
        if (temas != null) {
            for (DataTema t : temas) {
                if (t.getNombre().equals(tema)) {
                    data = t;
                }
            }
            if (data != null) {
                this.temas.remove(data);
            }
        }
    }
    
    public DataAlbumExt(ArrayList<DataTema> temas, String nombre, int anio, ArrayList<String> generos,
            BufferedImage img, String nickArtista) {
        super(nombre, anio, generos, img, nickArtista);
        this.temas = temas;
    }
    public DataAlbumExt(String nombre, int anio, ArrayList<String> generos,
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
