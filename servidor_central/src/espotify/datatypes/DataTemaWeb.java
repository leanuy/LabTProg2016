package espotify.datatypes;

public class DataTemaWeb extends DataTema {
    private String url;

    public String getUrl() {
        return url;
    }

    public DataTemaWeb() {
        super();
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    
    
    public DataTemaWeb(String url, String nombre, int duracion,
            int num, String artista, String album) {
        super(nombre, duracion, num, artista, album, true);
        this.url = url;
    }
    
}
