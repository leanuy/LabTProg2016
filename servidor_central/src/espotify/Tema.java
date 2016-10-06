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
    
    Album getAlbum() {
        return this.album;
    }

    public DataTema getData() {
        return new DataTema(nombre, duracion, num, getNomArtista(), getNombreAlbum());
    }

    Tema(DataTema dataTema, Album album) {
        this.nombre = dataTema.getNombre();
        this.duracion = dataTema.getDuracion();
        this.num = dataTema.getNum();
        this.album = album;
    }
}
