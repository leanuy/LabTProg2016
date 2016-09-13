package espotify;

import espotify.Datatypes.DataAlbumExt;
import espotify.Datatypes.DataArtista;
import espotify.Datatypes.DataArtistaExt;
import espotify.Datatypes.DataTema;
import espotify.Excepciones.AlbumInexistenteException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Artista extends Usuario {
    //attr
    private final String bio;
    private final String url;
    private final HashMap<String,Album> albums;
    
    //getters
    
    void addAlbum(Album album) {
        this.albums.put(album.getNombre(), album);
    }

    boolean TieneAlbum(String album) {
        return this.albums.containsKey(album);
    }
    
    //constructores
    Artista(DataArtista data) {
      super(data);
      albums = new HashMap<>();
      bio=data.getBio();
      url=data.getUrl();
    }
    
    DataAlbumExt getDataAlbumExt(String nomAlbum) throws AlbumInexistenteException {
        Album album = BuscarAlbum(nomAlbum);
        return album.getDataExt();
    }
    
    //otros métodos
    static boolean ValidarDatosArtista(DataArtista d) {
        return Usuario.ValidarDatosUsuario(d);
    }

    DataArtistaExt getDataArtistaExt() {
        ArrayList<String> segdores = new ArrayList();
        String namef;
        Cliente cli;
        for (Map.Entry<String, Cliente> entry : this.seguidores.entrySet()) {
            cli = entry.getValue();
            namef = cli.nick;
            segdores.add(namef);
        }
        DataArtistaExt da = new DataArtistaExt(getNick(), getNombre(), getApellido(),
                getCorreo(), getFechaNac(), getImg(), bio, url, albums, segdores);
        return da;
    }
    
    Album BuscarAlbum(String nombre) throws AlbumInexistenteException {
        Album album = albums.get(nombre);
        if (album == null) {
            throw new AlbumInexistenteException();
        }
        return album;
    }
    
    ArrayList<String> ListarAlbumes() {
        ArrayList<String> listaAlbums = new ArrayList();
        Iterator it = albums.entrySet().iterator();
        Album actual;
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            actual = (Album) pair.getValue();
            listaAlbums.add(actual.getNombre());
        }
        return listaAlbums;
    }
    
    Tema DevolverTema(DataTema dt) {
        String album = dt.getAlbum();
        String tema = dt.getNombre();
        Album alb = albums.get(album);
        return alb.DevolverTema(tema);
    }
}