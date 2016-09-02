package espotify.Datatypes;

public class DataTemaWeb extends DataTema {
    private String url;

    public String getUrl() {
        return url;
    }

    public DataTemaWeb(String url, String nombre, int duracion, int num) {
        super(nombre, duracion, num);
        this.url = url;
    }
    
    public DataTemaWeb(String url, String nombre, int duracion, int num, String artista, String album) {
        super(nombre, duracion, num, artista, album);
        this.url = url;
    }
    
}
