package espotify;

import espotify.Datatypes.DataLista;
import java.util.ArrayList;

public abstract class Lista {
    private String nombre;
    private String img;
    private final ArrayList<Tema> temas;

    public String getNombre() {
        return nombre;
    }
    public String getImg() {
        return img;
    }
    
    public Lista(DataLista d)
    {
        this.nombre = d.getNombre();
        this.img = d.getImg();
        this.temas = new ArrayList<>();
    }
}
