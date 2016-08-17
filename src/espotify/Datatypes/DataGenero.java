package espotify.Datatypes;


public class DataGenero {
    private String nombre;
    private String padre;

    public String getNombre() {
        return nombre;
    }
    public String getPadre() {
        return padre;
    }

    public DataGenero(String nombre, String padre) {
        this.nombre = nombre;
        this.padre = padre;
    }

    public void setPadre(String padre) {
        this.padre = padre;
    }
}
