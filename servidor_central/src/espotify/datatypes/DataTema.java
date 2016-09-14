package espotify.datatypes;

import java.util.Objects;

public class DataTema implements DataFavoriteable {
    private final String nombre;
    private final int duracion;
    private final int num;
    private final String nomArtista;
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
    
    public String getAlbum() {
        return album;
    }
    

    public DataTema(String nombre, int duracion, int num) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.num = num;
        this.nomArtista = "";
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
        return "DataTema{" + "nombre=" + nombre + ", nomArtista=" +
                nomArtista + ", album=" + album + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        final DataTema other = (DataTema) obj;
        if (this.duracion != other.duracion) {
            return false;
        }
        if (this.num != other.num) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.nomArtista, other.nomArtista)) {
            return false;
        }
        return Objects.equals(this.album, other.album);
    }
    
    
    
}
