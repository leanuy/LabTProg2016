package espotify;

import java.util.ArrayList;

public abstract class Lista {
    protected String nombre;
    protected String img;
    protected final ArrayList<Tema> temas;

    public String getNombre() {
        return nombre;
    }
    public String getImg() {
        return img;
    }
    
    public Lista(String nombre, String img)
    {
        this.nombre=nombre;
        this.img=img;
        this.temas=new ArrayList<>();
    }

}
