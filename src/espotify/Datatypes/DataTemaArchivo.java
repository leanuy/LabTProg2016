package espotify.Datatypes;

public abstract class DataTemaArchivo extends DataTema{
    private String archivo;

    public String getArchivo() {
        return archivo;
    }

    public DataTemaArchivo(String archivo, String nombre, int duracion, int num) {
        super(nombre, duracion, num);
        this.archivo = archivo;
    }
    
}