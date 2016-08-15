package espotify.Datatypes;

public class DataLista {
    private String nombre;
    private String img;

    public String getNombre() {
        return nombre;
    }
    public String getImg() {
        return img;
    }

    public DataLista(String nombre, String img) {
        this.nombre = nombre;
        this.img = img;
    }
    
}
