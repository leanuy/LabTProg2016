package espotify.datatypes;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Objects;

public class DataLista implements DataFavoriteable {
    private final String nombre;
    protected BufferedImage img;
    private final List<DataTema> temas;

    public String getNombre() {
        return nombre;
    }
    
    public BufferedImage getImg() {
        return img;
    }
    
    public List<DataTema> getTemas() {
        return temas;
    }
    

    public DataLista(String nombre, BufferedImage img) {
        this.nombre = nombre;
        this.img = img;
        this.temas = null;
    }

    public DataLista(String nombre, BufferedImage img, List<DataTema> temas) {
        this.nombre = nombre;
        this.img = img;
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
        final DataLista other = (DataLista) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.img, other.img)) {
            return false;
        }
        return Objects.equals(this.temas, other.temas);
    }
    
    
}
