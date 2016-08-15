package espotify.Datatypes;

public class DataDefecto extends DataLista {
    private String genero;

    public String getGenero() {
        return genero;
    }

    public DataDefecto(String genero, String nombre, String img) {
        super(nombre, img);
        this.genero = genero;
    }
    
}
