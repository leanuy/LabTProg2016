package espotify.Datatypes;

import java.util.ArrayList;


public class DataAlbum {
    private String nombre;
    private int anio;
    private ArrayList<String> generos;
    private String img;

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

    public DataAlbum(String nombre, int anio, ArrayList<String> generos, String img) {
        this.nombre = nombre;
        this.anio = anio;
        this.generos = generos;
        this.img = img;
    }
}
