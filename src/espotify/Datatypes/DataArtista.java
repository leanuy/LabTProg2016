package espotify.Datatypes;

import java.util.Date;


public class DataArtista extends DataUsuario {
    private String bio;
    private String url;

    public String getBio() {
        return bio;
    }
    public String getUrl() {
        return url;
    }

    public DataArtista(String bio, String url, String nick, String nombre, String apellido, String correo, Date fNac, String img) {
        super(nick, nombre, apellido, correo, fNac, img);
        this.bio = bio;
        this.url = url;
    }
    
    
}
