package espotify.Datatypes;

public class DataTema {
    private String nombre;
    private int duracion;
    private int num;
    private String nomArtista;
    private String album;
    
    public String getNombre() {
        return nombre;
    }
    public int getDuracion() {
        return duracion;
    }
    public int getNum() {
        return num;
    }
    public String getNomArtista() {
        return nomArtista;
    }
    
    public String getAlbum(){
        return album;
    }
    

    public DataTema(String nombre, int duracion, int num) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.num = num;
        this.nomArtista="";
    }

    public DataTema(String nombre, int duracion, int num, String nomArtista) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.num = num;
        this.nomArtista = nomArtista;
    }

    public DataTema(String nombre, int duracion, int num, String nomArtista, String album) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.num = num;
        this.nomArtista = nomArtista;
        this.album = album;
    }

    @Override
    public String toString() {
        return "DataTema{" + "nombre=" + nombre + ", nomArtista=" + nomArtista + ", album=" + album + '}';
    }
    
}
