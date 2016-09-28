package espotify.datatypes;

import java.io.File;
import java.util.List;


public class DataAlbum implements DataFavoriteable {
    private final String nombre;
    private final int anio;
    private final List<String> generos;
    private final File img;
    private final String nickArtista; //nickname

    public String getNombre() {
        return nombre;
    }
    
    public int getAnio() {
        return anio;
    }
    
    public List<String> getGeneros() {
        return generos;
    }
    
    public File getImg() {
        return img;
    }
    
    public String getNickArtista() {
        return nickArtista;
    }

    public DataAlbum(String nombre, int anio, List<String> generos, File img,
            String artista) {
        this.nombre = nombre;
        this.anio = anio;
        this.generos = generos;
        this.img = img;
        this.nickArtista = artista;
    }



    
    
}
