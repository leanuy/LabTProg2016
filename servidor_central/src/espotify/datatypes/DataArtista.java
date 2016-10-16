package espotify.datatypes;

import java.awt.image.BufferedImage;
import java.util.Calendar;


public class DataArtista extends DataUsuario {
    private final String bio;
    private final String url;

    public String getBio() {
        return bio;
    }
    
    public String getUrl() {
        return url;
    }
    
    public DataArtista(String bio, String url, String nick, String nombre, String apellido,
            String correo, Calendar fechaNac, BufferedImage img, String pwd) {
        super(nick, nombre, apellido, correo, fechaNac, img, pwd);
        this.bio = bio;
        this.url = url;
    }
    
}
