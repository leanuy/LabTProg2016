package espotify.Datatypes;

public class DataTema {
    private String nombre;
    private int duracion;
    private int num;

    public String getNombre() {
        return nombre;
    }
    public int getDuracion() {
        return duracion;
    }
    public int getNum() {
        return num;
    }

    public DataTema(String nombre, int duracion, int num) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.num = num;
    }
    
}
