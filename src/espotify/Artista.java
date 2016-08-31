package espotify;

import espotify.Datatypes.DataAlbumExt;
import espotify.Datatypes.DataArtista;
import espotify.Datatypes.DataArtistaExt;
import espotify.Excepciones.AlbumInexistenteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Artista extends Usuario{
    //attr
    private String bio;
    private String url;
    private final HashMap<String,Album> albums;
    
    //getters
    public String getBio() {
        return bio;
    }
    public String getUrl() {
        return url;
    }
    
    public void addAlbum(Album album) {
        this.albums.put(album.getNombre(), album);
    }

    public boolean TieneAlbum(String album) {
        return this.albums.containsKey(album);
    }
    
    //constructores
    public Artista(DataArtista d)
    {
      super(d);
      albums = new HashMap<>();
      bio=d.getBio();
      url=d.getUrl();
    }
    
    public DataAlbumExt getDataAlbumExt(String nomAlbum) throws AlbumInexistenteException {
        Album album = BuscarAlbum(nomAlbum);
        return album.getDataExt();
    }
    
    //otros métodos
    static boolean ValidarDatosArtista(DataArtista d) {
        return Usuario.ValidarDatosUsuario(d);
    }

    public DataArtistaExt getDataArtistaExt() {
        DataArtistaExt da = new DataArtistaExt(getNick(), getNombre(), getApellido(), getCorreo(), getfNac(), getImg(), getBio(), getUrl(), albums);
        return da;
    }
    
    private Album BuscarAlbum(String nombre) throws AlbumInexistenteException {
        Album album = albums.get(nombre);
        if (album == null){
            throw new AlbumInexistenteException();
        }
        return album;
    }
    
    public ArrayList<String> ListarAlbumes(){
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
}