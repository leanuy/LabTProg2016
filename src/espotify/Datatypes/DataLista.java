package espotify.Datatypes;

import java.util.ArrayList;

public class DataLista {
    private String nombre;
    private String img;
    private ArrayList<DataTema> temas;

    public String getNombre() {
        return nombre;
    }
    public String getImg() {
        return img;
    }

    public DataLista(String nombre, String img) {
        this.nombre = nombre;
        this.img = img;
        this.temas = null;
    }

    public DataLista(String nombre, String img, ArrayList<DataTema> temas) {
        this.nombre = nombre;
        this.img = img;
        this.temas = temas;
    }
    
    
}
