package espotify.Datatypes;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Objects;


public class DataAlbum implements DataFavoriteable {
    protected final String nombre;
    protected final int anio;
    protected final ArrayList<String> generos;
    protected final BufferedImage img;
    protected final String nickArtista; //nickname

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



    
    
}
