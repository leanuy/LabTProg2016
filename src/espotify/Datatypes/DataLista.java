package espotify.Datatypes;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class DataLista implements DataFavoriteable{
    private String nombre;
    protected BufferedImage img;
    private ArrayList<DataTema> temas;

    public String getNombre() {
        return nombre;
    }
    public BufferedImage getImg() {
        return img;
    }
    public ArrayList<DataTema> getTemas() {
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
    
    
}
