package espotify;

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
}