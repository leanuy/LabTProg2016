package espotify;

import espotify.Datatypes.DataArtistaExt;
import java.util.HashMap;

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
    
    //constructores
    public Artista()
    {
      albums = new HashMap<>();
    }

    public DataArtistaExt CrearDataArtistaExt() {
        DataArtistaExt da = new DataArtistaExt(getNick(), getNombre(), getApellido(), getCorreo(), getfNac(), getImg(), getBio(), getUrl());
        return da;
    }
}