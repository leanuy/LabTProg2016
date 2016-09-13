package espotify;

import espotify.Datatypes.DataTema;

class Tema implements Favoriteable {
    private final String nombre;
    private final int duracion;
    private final int num;
    private final Album album;

    String getNombre() {
        return nombre;
    }
    
    String getNombreAlbum() {
        return album.getNombre();
    }
    
    String getNomArtista() {
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
