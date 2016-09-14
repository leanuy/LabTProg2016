package espotify;

import espotify.datatypes.DataTema;

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

    Tema(DataTema dTema, Album album) {
        this.nombre = dTema.getNombre();
        this.duracion = dTema.getDuracion();
        this.num = dTema.getNum();
        this.album = album;
    }
}
