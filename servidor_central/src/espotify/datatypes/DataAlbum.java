package espotify.datatypes;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataAlbum implements DataFavoriteable {
    private String nombre;
    private int anio;
    private ArrayList<String> generos;
    private BufferedImage img;
    private String nickArtista;

    public String getNombre() {
        return nombre;
    }
    
    public int getAnio() {
        return anio;
    }
    
    public ArrayList<String> getGeneros() {
        return generos;
    }
    
    public BufferedImage getImg() {
        return img;
    }
    
    public String getNickArtista() {
        return nickArtista;
    }

    public DataAlbum(String nombre, int anio, ArrayList<String> generos, BufferedImage img,
            String artista) {
        this.nombre = nombre;
        this.anio = anio;
        this.generos = generos;
        this.img = img;
        this.nickArtista = artista;
    }    

    public DataAlbum() {
        this.generos = new ArrayList<>();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setGeneros(ArrayList<String> generos) {
        this.generos = generos;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }

    public void setNickArtista(String nickArtista) {
        this.nickArtista = nickArtista;
    }
}
