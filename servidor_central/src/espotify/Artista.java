package espotify;

import espotify.datatypes.DataAlbumExt;
import espotify.datatypes.DataArtista;
import espotify.datatypes.DataArtistaExt;
import espotify.datatypes.DataTema;
import espotify.excepciones.AlbumInexistenteException;
import espotify.excepciones.TemaTipoInvalidoException;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class Artista extends Usuario {
    //attr
    private final String bio;
    private final String url;
    private final Map<String,Album> albums;
    private DataAlbumExt albumTemp;
    
    //getters
    
    void addAlbum(Album album) {
        this.albums.put(album.getNombre(), album);
    }
    void addAlbumTemp(DataAlbumExt album) {
        this.albumTemp = album;
    }

    boolean tieneAlbum(String album) {
        return this.albums.containsKey(album);
    }
    boolean tieneAlbumTemp(String album) {
        return this.albumTemp.getNombre().equals(album);
    }
    
    Map<String, Album> getAlbums() {
        return this.albums;
    }
    DataAlbumExt getAlbumTemp() {
        return this.albumTemp;
    }
    
    //constructores
    Artista(DataArtista data) {
        super(data);
        albums = new HashMap<>();
        albumTemp = null;
        bio = data.getBio();
        url = data.getUrl();
    }
    
    DataAlbumExt getDataAlbumExt(String nomAlbum) throws AlbumInexistenteException {
        Album album = buscarAlbum(nomAlbum);
        return album.getDataExt();
    }
    
    //otros métodos
    static boolean validarDatosArtista(DataArtista dataArtista) {
        return Usuario.validarDatosUsuario(dataArtista);
    }

    DataArtistaExt getDataArtistaExt() {
        List<String> segdores = new ArrayList();
        String namef;
        Cliente cli;
        for (Map.Entry<String, Cliente> entry : this.getSeguidores().entrySet()) {
            cli = entry.getValue();
            namef = cli.getNick();
            segdores.add(namef);
        }
        return new DataArtistaExt(getNick(), getNombre(), getApellido(),
                getCorreo(), getFechaNac(), getImg(), bio, url, albums, segdores);
    }
    
    Album buscarAlbum(String nombre) throws AlbumInexistenteException {
        Album album = albums.get(nombre);
        if (album == null) {
            throw new AlbumInexistenteException();
        }
        return album;
    }
    
    ArrayList<String> listarAlbumes() {
        ArrayList<String> listaAlbums = new ArrayList();
        Iterator iterador = albums.entrySet().iterator();
        Album albumActual;
        while (iterador.hasNext()) {
            Map.Entry pair = (Map.Entry)iterador.next();
            albumActual = (Album) pair.getValue();
            listaAlbums.add(albumActual.getNombre());
        }
        return listaAlbums;
    }
    
    Tema devolverTema(DataTema data) {
        String album = data.getAlbum();
        String tema = data.getNombre();
        Album alb = albums.get(album);
        return alb.devolverTema(tema);
    }
    
    DataTema consultaTema(String nomAlbum, String nomTema)
            throws AlbumInexistenteException {
        return buscarAlbum(nomAlbum).devolverTema(nomTema).getData();
    }

    BufferedInputStream getAudio(String album, String tema,boolean esDescarga) throws AlbumInexistenteException, TemaTipoInvalidoException {
        return buscarAlbum(album).getAudio(tema,esDescarga);
    }

    void addTemaAlbumTemp(DataTema tema) {
        this.albumTemp.addTema(tema);
    }
    void deleteTemaAlbumTemp(String tema) {
        this.albumTemp.deleteTema(tema);
    }

}