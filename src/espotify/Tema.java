package espotify;

import espotify.Datatypes.DataTema;

public class Tema implements Favoriteable {
    private String nombre;
    private int duracion;
    private int num;
    private Album album;

    public String getNombre() {
        return nombre;
    }
    public int getDuracion() {
        return duracion;
    }
    public int getNum() {
        return num;
    }
    public String getNombreAlbum()
    {
        return album.getNombre();
    }
    public String getNomArtista()
    {
        return album.getNickArtista();
    }

    DataTema getData() {
        return new DataTema(nombre, duracion, num, getNomArtista(), getNombreAlbum());
    }

    public Tema(DataTema dt, Album album) {
        this.nombre = dt.getNombre();
        this.duracion = dt.getDuracion();
        this.num = dt.getNum();
        this.album = album;
    }
}
