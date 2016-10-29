package espotify.datatypes;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataLista implements DataFavoriteable {
    private String nombre;
    private BufferedImage img;
    private ArrayList<DataTema> temas;

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

    public DataLista(String nombre, BufferedImage img, ArrayList<DataTema> temas) {
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

    public DataLista() {
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }

    public void setTemas(ArrayList<DataTema> temas) {
        this.temas = temas;
    }
    
    
}
