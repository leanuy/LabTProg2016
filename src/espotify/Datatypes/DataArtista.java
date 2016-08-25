package espotify.Datatypes;

import java.awt.image.BufferedImage;
import java.util.Calendar;


public class DataArtista extends DataUsuario {
    private String bio;
    private String url;

    public String getBio() {
        return bio;
    }
    public String getUrl() {
        return url;
    }

    public DataArtista(String bio, String url, String nick, String nombre, String apellido, String correo, Calendar fNac, BufferedImage img) {
        super(nick, nombre, apellido, correo, fNac, img);
        this.bio = bio;
        this.url = url;
    }
    
    
}
