package espotify.datatypes;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Objects;


public class DataAlbum implements DataFavoriteable {
    protected final String nombre;
    protected final int anio;
    protected final List<String> generos;
    protected final BufferedImage img;
    protected final String nickArtista; //nickname

    public String getNombre() {
        return nombre;
    }
    
    public int getAnio() {
        return anio;
    }
    
    public List<String> getGeneros() {
        return generos;
    }
    
    public BufferedImage getImg() {
        return img;
    }
    
    public String getNickArtista() {
        return nickArtista;
    }

    public DataAlbum(String nombre, int anio, List<String> generos, BufferedImage img,
            String artista) {
        this.nombre = nombre;
        this.anio = anio;
        this.generos = generos;
        this.img = img;
        this.nickArtista = artista;
    }



    
    
}
