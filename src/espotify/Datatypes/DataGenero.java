package espotify.Datatypes;
import java.util.ArrayList;


public class DataGenero {
    private String nombre;
    private String padre;
    private ArrayList<DataGenero> hijos;

    public String getNombre() {
        return nombre;
    }
    public String getPadre() {
        return padre;
    }
    public ArrayList<DataGenero> getHijos()
    {
        return hijos;
    }

    public DataGenero(String nombre, String padre) {
        this.nombre = nombre;
        this.padre = padre;
        this.hijos=new ArrayList<>();
    }
}
