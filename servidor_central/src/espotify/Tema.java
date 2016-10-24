package espotify;

import espotify.datatypes.DataTema;

class Tema implements Favoriteable {
    private final String nombre;
    private final int duracion;
    private final int num;
    private final Album album;
    private int cantReproducciones;
    private int cantDescargas;

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
        return new DataTema(nombre, duracion, num, getNomArtista(), getNombreAlbum(), this instanceof TemaWeb);
    }

    Tema(DataTema dataTema, Album album) {
        this.nombre = dataTema.getNombre();
        this.duracion = dataTema.getDuracion();
        this.num = dataTema.getNum();
        this.album = album;
        this.cantDescargas=0;
        this.cantReproducciones=0;
    }

    void registrarUso(boolean esDescarga) {
        if (esDescarga) {
            cantDescargas++;
        } else {
            cantReproducciones++;
        }
    }
}
