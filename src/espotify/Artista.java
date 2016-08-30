package espotify;

import espotify.Datatypes.DataAlbumExt;
import espotify.Datatypes.DataArtista;
import espotify.Datatypes.DataArtistaExt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Artista extends Usuario{

    //attr
    private String bio;
    private String url;
    private final HashMap<String,Album> albums;
// Cuando se agraga un album que la Key sea el nombre del album, asi lo implemente en otro lugar
    
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
    
    public DataAlbumExt getDataAlbumExt(String nomAlbum) throws Exception {
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
    
    public Album BuscarAlbum(String nombre) throws Exception {
        Album album = albums.get(nombre);
        if (album == null){
            throw new Exception("No existe un álbum con ese nombre!");
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