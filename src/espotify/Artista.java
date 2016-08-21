package espotify;

import espotify.Datatypes.DataArtista;
import espotify.Datatypes.DataArtistaExt;
import java.util.HashMap;

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
    
    //constructores
    public Artista(DataArtista d)
    {
      super(d);
      albums = new HashMap<>();
      bio=d.getBio();
      url=d.getUrl();
    }
    
    //otros métodos
    static boolean ValidarDatosArtista(DataArtista d) {
        return Usuario.ValidarDatosUsuario(d);
    }

    public DataArtistaExt getDataArtistaExt() {
        DataArtistaExt da = new DataArtistaExt(getNick(), getNombre(), getApellido(), getCorreo(), getfNac(), getImg(), getBio(), getUrl(), albums);
        return da;
    }
}