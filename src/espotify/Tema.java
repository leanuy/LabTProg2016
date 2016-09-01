package espotify;

import espotify.Datatypes.DataTema;

class Tema implements Favoriteable {
    private String nombre;
    private int duracion;
    private int num;
    private Album album;

    String getNombre() {
        return nombre;
    }
    String getNombreAlbum()
    {
        return album.getNombre();
    }
    String getNomArtista()
    {
        return album.getNickArtista();
    }

    DataTema getData() {
        return new DataTema(nombre, duracion, num, getNomArtista(), getNombreAlbum());
    }

    Tema(DataTema dt, Album album) {
        this.nombre = dt.getNombre();
        this.duracion = dt.getDuracion();
        this.num = dt.getNum();
        this.album = album;
    }
}
