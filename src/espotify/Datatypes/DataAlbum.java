package espotify.Datatypes;

import java.util.ArrayList;


public class DataAlbum {
    private final String nombre;
    private final int anio;
    private final ArrayList<String> generos;
    private final String img;
    private final String nickArtista; //nickname

    public String getNombre() {
        return nombre;
    }
    public int getAnio() {
        return anio;
    }
    public ArrayList<String> getGeneros() {
        return generos;
    }
    public String getImg() {
        return img;
    }
    
    public String getNickArtista() {
        return nickArtista;
    }

    public DataAlbum(String nombre, int anio, ArrayList<String> generos, String img, String artista) {
        this.nombre = nombre;
        this.anio = anio;
        this.generos = generos;
        this.img = img;
        this.nickArtista = artista;
    }
}
