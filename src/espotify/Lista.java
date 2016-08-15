package espotify;

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
    
    public Lista()
    {
        this.temas=new ArrayList<>();
    }
}
